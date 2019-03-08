package com.tianyaleixiaolin.uplusserver.core.order;

import com.xiaoleilu.hutool.io.FileUtil;
import com.xiaoleilu.hutool.util.BeanUtil;
import com.xiaoleilu.hutool.util.StrUtil;
import com.tianyaleixiaolin.uplusserver.core.company.company.PtCompanyManager;
import com.tianyaleixiaolin.uplusserver.core.company.goods.PtGoods;
import com.tianyaleixiaolin.uplusserver.core.company.goods.PtGoodsManager;
import com.tianyaleixiaolin.uplusserver.core.dict.area.AreaManager;
import com.tianyaleixiaolin.uplusserver.core.user.user.PtUserManager;
import com.tianyaleixiaolin.uplusserver.global.bean.BaseData;
import com.tianyaleixiaolin.uplusserver.global.bean.ResultGenerator;
import com.tianyaleixiaolin.uplusserver.global.bean.SimplePage;
import com.tianyaleixiaolin.uplusserver.global.bean.request.OrderAddUpdateModel;
import com.tianyaleixiaolin.uplusserver.global.bean.request.OrderListQueryModel;
import com.tianyaleixiaolin.uplusserver.global.bean.request.OrderTempListQueryModel;
import com.tianyaleixiaolin.uplusserver.global.bean.response.OrderListVO;
import com.tianyaleixiaolin.uplusserver.global.bean.response.OrderModifyDetailVO;
import com.tianyaleixiaolin.uplusserver.global.bean.response.OrderTempListVO;
import com.tianyaleixiaolin.uplusserver.global.specify.Criteria;
import com.tianyaleixiaolin.uplusserver.global.specify.Restrictions;
import com.tianyaleixiaolin.uplusserver.global.util.Constant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Mr.li wrote on 2018/11/22.
 */
@Component
public class OrderService {
    @Resource
    private PtOrderManager ptOrderManager;
    @Resource
    private PtGoodsManager ptGoodsManager;
    @Resource
    private PtCompanyManager ptCompanyManager;
    @Resource
    private PtUserManager ptUserManager;
    @Resource
    private PtOrderRelationManager ptOrderRelationManager;
    @Resource
    private AreaManager areaManager;

    private Logger logger = LoggerFactory.getLogger(getClass());

    public PtOrder add(OrderAddUpdateModel orderAddUpdateModel, boolean needConfirm) {
        PtOrder ptOrder = new PtOrder();
        BeanUtil.copyProperties(orderAddUpdateModel, ptOrder);

        //同时新建一个temp
        PtOrderTemp ptOrderTemp = new PtOrderTemp();
        BeanUtil.copyProperties(orderAddUpdateModel, ptOrderTemp, "id");
        ptOrderTemp.setReason(Constant.REASON_NEW_CREATE);
        ptOrderTemp.setOperatorType(Constant.REASON_NEW_CREATE);

        if (needConfirm) {
            ptOrder.setStatus(Constant.STATE_CONFIRM);
            ptOrderTemp.setStatus(Constant.STATE_CONFIRM);
        } else {
            ptOrder.setStatus(Constant.STATE_NORMAL);
            ptOrderTemp.setStatus(Constant.STATE_NORMAL);
        }

        ptOrder = ptOrderManager.add(ptOrder);

        ptOrderTemp.setOrderId(ptOrder.getId());
        ptOrderManager.addTemp(ptOrderTemp);

        PtOrderRelation ptOrderRelation = orderAddUpdateModel.getOrderRelation();
        if (ptOrderRelation != null) {
            ptOrderRelation.setOrderId(ptOrder.getId());
            ptOrderRelationManager.add(ptOrderRelation);
        }

        return ptOrder;
    }


    /**
     * 导入csv功能
     */
    public BaseData importCsv(MultipartFile multFile, Long goodsId) {
        // 获取文件名
        String fileName = multFile.getOriginalFilename();
        logger.info("文件名--" + fileName);
        // 获取文件后缀
        String prefix = fileName.substring(fileName.lastIndexOf("."));
        try {
            // 用uuid作为文件名，防止生成的临时文件重复
            File excelFile = File.createTempFile(System.currentTimeMillis() + "", prefix);
            // MultipartFile to File
            multFile.transferTo(excelFile);
            List<String> list = FileUtil.readLines(excelFile, "utf-8");
            logger.info("文件共有" + list.size() + "行");

            List<OrderAddUpdateModel> models = new ArrayList<>();

            PtGoods ptGoods = ptGoodsManager.findOne(goodsId);
            Long companyId = ptGoods.getCompanyId();

            for (String line : list) {
                //忽略表头
                if (line.contains("姓名")) {
                    continue;
                }
                OrderAddUpdateModel model = parseCsv(line, goodsId, companyId);
                if (model != null) {
                    models.add(model);
                    add(model, true);
                }

            }
            return ResultGenerator.genSuccessResult("成功导入" + models.size() + "条");
        } catch (IOException e) {
            e.printStackTrace();
            return ResultGenerator.genFailResult("导入失败");
        }

    }

    private OrderAddUpdateModel parseCsv(String line, Long goodsId, Long companyId) {
        String[] array = line.split(",");
        if (array.length != 11) {
            logger.info("这一行数据不对:" + line);
            return null;
        }
        OrderAddUpdateModel model = new OrderAddUpdateModel();
        model.setUserName(array[0]);
        model.setSex(Integer.valueOf(array[1]));
        model.setPaperType(array[2]);
        model.setPaper(array[3]);
        model.setMobile(array[4]);
        model.setEmail(array[5]);
        model.setCardNum(array[6]);

        String begin = array[7];
        if (begin.contains("/")) {
            model.setBeginTime(array[7].replace("/", "-"));
        } else {
            model.setBeginTime(array[7]);
        }
        String end = array[8];
        if (end.contains("/")) {
            model.setEndTime(array[8].replace("/", "-"));
        } else {
            model.setEndTime(array[8]);
        }
       
        model.setRemark(array[9]);
        model.setState(Integer.valueOf(array[10]));

        model.setPtGoodsId(goodsId);
        model.setCompanyId(companyId);

        return model;
    }


    /**
     * 查询order详情
     *
     * @param id
     *         id
     * @return PtOrder
     */
    public PtOrder findOne(Long id) {
        return ptOrderManager.findOne(id);
    }


    /**
     * 查询某用户的所有保单列表
     * @param id id
     * @return List
     */
    public List<OrderListVO> findListByUserPaper(Long id) {
        PtOrder ptOrder = findOne(id);
        String paper = ptOrder.getPaper();
        if (StrUtil.isEmpty(paper)) {
            return new ArrayList<>();
        }
        Criteria<PtOrder> criteria = new Criteria<>();
        criteria.add(Restrictions.eq("status", Constant.STATE_NORMAL, true));
        criteria.add(Restrictions.like("paper", paper, true));
        criteria.add(Restrictions.eq("deleteFlag", false, true));
        Pageable pageable = PageRequest.of(0, 1000, Sort
                .Direction.DESC, "id");
        Page<PtOrder> page = ptOrderManager.findAll(criteria, pageable);
        return page.getContent().stream().map(this::parse).collect(Collectors.toList());
    }

    /**
     * 下架某个服务单，则先操作temp表，该表不动
     *
     * @param id
     *         id
     */
    public void deleteById(Long id, String reason, String files) {
        PtOrderTemp temp = ptOrderManager.findOneTempByOrderId(id);
        temp.setStatus(Constant.STATE_CONFIRM);
        temp.setReason(reason);
        temp.setFiles(files);
        ptOrderManager.deleteTemp(temp);
    }

    /**
     * 包含被修改的详情
     */
    public OrderModifyDetailVO findDetail(Long id) {
        PtOrderTemp orderTemp = ptOrderManager.findOneTemp(id);
        PtOrder ptGoods = ptOrderManager.findOne(orderTemp.getOrderId());

        OrderModifyDetailVO orderModifyDetailVO = new OrderModifyDetailVO();
        orderModifyDetailVO.setOperatorName(ptUserManager.findNameById(orderTemp.getOperatorId()));
        orderModifyDetailVO.setOrignal(ptGoods);
        orderModifyDetailVO.setModified(orderTemp);

        PtOrderRelation orderRelation = ptOrderRelationManager.findByOrderId(orderTemp.getOrderId());
        orderModifyDetailVO.setOrderRelation(orderRelation);

        return orderModifyDetailVO;
    }

    public PtOrderTemp update(OrderAddUpdateModel orderAddUpdateModel) {
        //看有没有在修改中的，有则取，无则新建
        PtOrderTemp ptOrderTemp = ptOrderManager.findTempByOrderId(orderAddUpdateModel.getId());
        if (ptOrderTemp == null) {
            ptOrderTemp = new PtOrderTemp();
            ptOrderTemp.setOrderId(orderAddUpdateModel.getId());
        }
        BeanUtil.copyProperties(orderAddUpdateModel, ptOrderTemp, "id");
        ptOrderTemp.setStatus(Constant.STATE_CONFIRM);
        ptOrderTemp.setReason(orderAddUpdateModel.getReason());
        ptOrderTemp.setOperatorType(Constant.REASON_UPDATE);

        PtOrderRelation ptOrderRelation = orderAddUpdateModel.getOrderRelation();
        if (ptOrderRelation != null) {
            ptOrderRelationManager.update(ptOrderRelation);
        }
        return ptOrderManager.updateTemp(ptOrderTemp);
    }
                                                                           
    /**
     * 查已通过的
     */
    public SimplePage<OrderListVO> find(OrderListQueryModel companyListQueryModel) {
        Criteria<PtOrder> criteria = new Criteria<>();
        criteria.add(Restrictions.eq("companyId", companyListQueryModel.getCompanyId(), true));
        //criteria.add(Restrictions.eq("status", Constant.STATE_NORMAL, true));
        criteria.add(Restrictions.like("userName", companyListQueryModel.getUserName(), true));
        criteria.add(Restrictions.like("cardNum", companyListQueryModel.getCardNum(), true));
        criteria.add(Restrictions.like("mobile", companyListQueryModel.getMobile(), true));
        criteria.add(Restrictions.like("paper", companyListQueryModel.getPaper(), true));
        criteria.add(Restrictions.eq("province", companyListQueryModel.getProvince(), true));
        criteria.add(Restrictions.eq("city", companyListQueryModel.getCity(), true));
        criteria.add(Restrictions.eq("country", companyListQueryModel.getCountry(), true));
        criteria.add(Restrictions.eq("deleteFlag", false, true));

        Pageable pageable = PageRequest.of(companyListQueryModel.getPage(), companyListQueryModel.getSize(), Sort
                .Direction.DESC, "id");
        Page<PtOrder> page = ptOrderManager.findAll(criteria, pageable);

        return new SimplePage<>(page.getTotalPages(), page.getTotalElements(), page.getContent().stream().map
                (this::parse).collect(Collectors.toList()));
    }

    public List<Long> findIds(OrderListQueryModel companyListQueryModel) {
        Criteria<PtOrder> criteria = new Criteria<>();
        criteria.add(Restrictions.eq("companyId", companyListQueryModel.getCompanyId(), true));
        //criteria.add(Restrictions.eq("status", Constant.STATE_NORMAL, true));
        criteria.add(Restrictions.like("userName", companyListQueryModel.getUserName(), true));
        criteria.add(Restrictions.like("mobile", companyListQueryModel.getMobile(), true));
        criteria.add(Restrictions.like("paper", companyListQueryModel.getPaper(), true));
        criteria.add(Restrictions.eq("province", companyListQueryModel.getProvince(), true));
        criteria.add(Restrictions.eq("city", companyListQueryModel.getCity(), true));
        criteria.add(Restrictions.eq("country", companyListQueryModel.getCountry(), true));
        criteria.add(Restrictions.eq("deleteFlag", false, true));
        Pageable pageable = PageRequest.of(0, 1000, Sort
                .Direction.DESC, "id");
        Page<PtOrder> page = ptOrderManager.findAll(criteria, pageable);
        return page.getContent().stream().map(PtOrder::getId).collect(Collectors.toList());
    }

    /**
     * 查待确认的，所有的
     */
    public SimplePage<OrderTempListVO> findTemp(OrderTempListQueryModel orderTempListQueryModel) {
        Criteria<PtOrderTemp> criteria = new Criteria<>();
        criteria.add(Restrictions.eq("status", orderTempListQueryModel.getStatus(), true));
        criteria.add(Restrictions.eq("operatorId", orderTempListQueryModel.getOperatorId(), true));
        criteria.add(Restrictions.like("userName", orderTempListQueryModel.getUserName(), true));
        criteria.add(Restrictions.like("mobile", orderTempListQueryModel.getMobile(), true));

        Pageable pageable = PageRequest.of(orderTempListQueryModel.getPage(), orderTempListQueryModel.getSize(),
                Sort.Direction.DESC, "updateTime");
        Page<PtOrderTemp> page = ptOrderManager.findAllTemp(criteria, pageable);

        return new SimplePage<>(page.getTotalPages(), page.getTotalElements(), page.getContent().stream().map
                (this::parseTemp).collect(Collectors.toList()));
    }

    /**
     * 审核服务单，是否同意
     *
     * @param id
     *         tempId
     * @param confirm
     *         confirm
     */
    public void confirm(Long id, Boolean confirm) {
        if (confirm == null) {
            return;
        }
        PtOrderTemp oneTemp = ptOrderManager.findOneTemp(id);
        PtOrder ptOrder = ptOrderManager.findOne(oneTemp.getOrderId());
        //如果是下架
        if (Constant.REASON_DELETE.equals(oneTemp.getOperatorType())) {
            if (confirm) {
                //确认下架，将deleteFlag置为true
                ptOrderManager.delete(ptOrder);
                oneTemp.setStatus(Constant.STATE_NORMAL);
            } else {
                oneTemp.setStatus(Constant.STATE_REFUSE);
            }
        } else { //新建、修改相关的
            if (confirm) {
                oneTemp.setStatus(Constant.STATE_NORMAL);
                PtOrderTemp temp = new PtOrderTemp();
                BeanUtil.copyProperties(oneTemp, temp);

                //将更新后的覆盖到原来的里面
                BeanUtil.copyProperties(temp, ptOrder, "id");
                ptOrderManager.update(ptOrder);
            } else {
                oneTemp.setStatus(Constant.STATE_REFUSE);
            }
        }
        ptOrderManager.updateTemp(oneTemp);
    }

    public OrderListVO parse(PtOrder ptOrder) {
        OrderListVO orderListVO = new OrderListVO();
        BeanUtil.copyProperties(ptOrder, orderListVO);
        orderListVO.setGoodsName(ptGoodsManager.findNameById(ptOrder.getPtGoodsId()));
        orderListVO.setYouServers(ptGoodsManager.youServers(ptOrder.getPtGoodsId()));
        orderListVO.setCompanyName(ptCompanyManager.findNameById(ptOrder.getCompanyId()));
        orderListVO.setProvinceValue(areaManager.findName(ptOrder.getProvince()));
        orderListVO.setCityValue(areaManager.findName(ptOrder.getCity()));
        orderListVO.setCountryValue(areaManager.findName(ptOrder.getCountry()));
        orderListVO.setRelationUserName(ptOrderRelationManager.findNameByOrderId(ptOrder.getId()));

        return orderListVO;
    }

    public OrderListVO parse(Long orderId) {
        return parse(findOne(orderId));
    }

    private OrderTempListVO parseTemp(PtOrderTemp ptOrderTemp) {
        OrderTempListVO tempListVO = new OrderTempListVO();
        BeanUtil.copyProperties(ptOrderTemp, tempListVO);
        tempListVO.setOperatorName(ptUserManager.findNameById(ptOrderTemp.getOperatorId()));
        return tempListVO;
    }
}
