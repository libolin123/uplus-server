package com.tianyaleixiaolin.uplusserver.core.product.order;

import com.xiaoleilu.hutool.util.BeanUtil;
import com.tianyaleixiaolin.uplusserver.core.company.company.PtCompanyManager;
import com.tianyaleixiaolin.uplusserver.core.company.goods.PtGoods;
import com.tianyaleixiaolin.uplusserver.core.company.goods.PtGoodsManager;
import com.tianyaleixiaolin.uplusserver.core.company.youserver.PtCashPrePay;
import com.tianyaleixiaolin.uplusserver.core.company.youserver.PtCashPrePayManager;
import com.tianyaleixiaolin.uplusserver.core.dict.area.AreaManager;
import com.tianyaleixiaolin.uplusserver.core.medical.hospital.PtHospitalManager;
import com.tianyaleixiaolin.uplusserver.core.order.OrderService;
import com.tianyaleixiaolin.uplusserver.core.order.PtOrder;
import com.tianyaleixiaolin.uplusserver.core.order.PtOrderManager;
import com.tianyaleixiaolin.uplusserver.core.person.GroundPersonService;
import com.tianyaleixiaolin.uplusserver.core.person.PtGroundPerson;
import com.tianyaleixiaolin.uplusserver.core.person.PtGroundPersonManager;
import com.tianyaleixiaolin.uplusserver.core.person.sign.PtSignManager;
import com.tianyaleixiaolin.uplusserver.core.product.PtProductManager;
import com.tianyaleixiaolin.uplusserver.core.product.change.PtChange;
import com.tianyaleixiaolin.uplusserver.core.product.change.PtChangeManager;
import com.tianyaleixiaolin.uplusserver.core.product.flow.PtOrderFlow;
import com.tianyaleixiaolin.uplusserver.core.product.flow.PtOrderFlowManager;
import com.tianyaleixiaolin.uplusserver.core.product.receive.PtOrderReceive;
import com.tianyaleixiaolin.uplusserver.core.product.receive.PtOrderReceiveManager;
import com.tianyaleixiaolin.uplusserver.core.product.template.prepay.PtPrePayTemplate;
import com.tianyaleixiaolin.uplusserver.core.product.template.prepay.PtPrePayTemplateManager;
import com.tianyaleixiaolin.uplusserver.core.wechat.NewOrderEvent;
import com.tianyaleixiaolin.uplusserver.core.wechat.OrderReceiveEvent;
import com.tianyaleixiaolin.uplusserver.core.wechat.event.NewOrderBean;
import com.tianyaleixiaolin.uplusserver.core.wechat.event.OrderReceiveBean;
import com.tianyaleixiaolin.uplusserver.global.UserKit;
import com.tianyaleixiaolin.uplusserver.global.bean.BaseData;
import com.tianyaleixiaolin.uplusserver.global.bean.ResultGenerator;
import com.tianyaleixiaolin.uplusserver.global.bean.SimplePage;
import com.tianyaleixiaolin.uplusserver.global.bean.request.GroundPersonListQueryModel;
import com.tianyaleixiaolin.uplusserver.global.bean.request.OrderListQueryModel;
import com.tianyaleixiaolin.uplusserver.global.bean.request.ProductOrderAddModel;
import com.tianyaleixiaolin.uplusserver.global.bean.request.ProductOrderListQueryModel;
import com.tianyaleixiaolin.uplusserver.global.bean.response.*;
import com.tianyaleixiaolin.uplusserver.global.cache.DictCache;
import com.tianyaleixiaolin.uplusserver.global.specify.Criteria;
import com.tianyaleixiaolin.uplusserver.global.specify.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 派单功能
 *
 * @author Mr.li wrote on 2018/11/12.
 */
@Component
@Transactional(rollbackFor = Exception.class)
public class ProductOrderService {
    @Resource
    private PtProductOrderManager ptProductOrderManager;
    @Resource
    private PtProductManager ptProductManager;
    @Resource
    private PtPrePayTemplateManager ptPrePayTemplateManager;
    @Resource
    private OrderService orderService;
    @Resource
    private DictCache dictCache;
    @Resource
    private AreaManager areaManager;
    @Resource
    private PtCompanyManager ptCompanyManager;
    @Resource
    private PtGroundPersonManager ptGroundPersonManager;
    @Resource
    private PtHospitalManager ptHospitalManager;
    @Resource
    private GroundPersonService groundPersonService;
    @Resource
    private PtOrderFlowManager ptOrderFlowManager;
    @Resource
    private PtGoodsManager ptGoodsManager;
    @Resource
    private PtCashPrePayManager ptCashPrePayManager;
    @Resource
    private UserKit userKit;
    @Resource
    private PtChangeManager ptChangeManager;
    @Resource
    private PtOrderReceiveManager ptOrderReceiveManager;
    @Resource
    private PtOrderManager ptOrderManager;
    @Resource
    private PtSignManager ptSignManager;
    @Resource
    private ApplicationEventPublisher applicationEventPublisher;
    
    private Logger logger = LoggerFactory.getLogger(getClass());


    public BaseData add(ProductOrderAddModel productOrderAddModel) {
        PtPrePayTemplate template = productOrderAddModel.getTemplate();
        if (template == null) {
            return ResultGenerator.genFailResult("预约信息不能为空");
        }

        PtProductOrder ptProductOrder = new PtProductOrder();
        BeanUtil.copyProperties(productOrderAddModel, ptProductOrder);
        //未派单
        ptProductOrder.setState("1");
        //未转单
        ptProductOrder.setChildState("1");
        ptProductOrder = ptProductOrderManager.add(ptProductOrder);

        template.setProductId(ptProductOrder.getId());
        template = ptPrePayTemplateManager.add(template);
        ptProductOrder.setTemplateId(template.getId());

        ptProductOrderManager.update(ptProductOrder);

        return ResultGenerator.genSuccessResult(ptProductOrder);
    }

    public PtProductOrder update(ProductOrderAddModel productOrderAddModel) {
        Long id = productOrderAddModel.getId();
        PtProductOrder ptProductOrder = ptProductOrderManager.find(id);
        if (ptProductOrder == null) {
            return null;
        }
        BeanUtil.copyProperties(productOrderAddModel, ptProductOrder, BeanUtil.CopyOptions.create()
                .setIgnoreNullValue(true));

        PtPrePayTemplate template = productOrderAddModel.getTemplate();
        if (template != null) {
            PtPrePayTemplate originalTemplate = ptPrePayTemplateManager.find(productOrderAddModel.getTemplateId());
            if (originalTemplate == null) {
                originalTemplate = new PtPrePayTemplate();
            }
            BeanUtil.copyProperties(template, originalTemplate, BeanUtil.CopyOptions.create().setIgnoreNullValue(true));
            ptPrePayTemplateManager.update(originalTemplate);

            ptProductOrder.setTemplateId(originalTemplate.getId());
        }

        return ptProductOrderManager.update(ptProductOrder);
    }

    /**
     * 查询某一个
     */
    public ProductOrderVO find(Long id) {
        ProductOrderVO productOrderVO = new ProductOrderVO();
        PtProductOrder ptProductOrder = ptProductOrderManager.find(id);
        PtPrePayTemplate template = ptPrePayTemplateManager.find(ptProductOrder.getTemplateId());
        productOrderVO.setTemplate(parseTemplate(template));

        productOrderVO.setProductId(ptProductOrder.getProductId());
        productOrderVO.setGroundPersonId(ptProductOrder.getGroundPersonId());
        productOrderVO.setProductName(ptProductManager.findNameById(ptProductOrder.getProductId()));

        OrderListVO orderListVO = orderService.parse(ptProductOrder.getOrderId());
        productOrderVO.setOrderListVO(orderListVO);

        GroundPersonListVO groundPersonListVO = groundPersonService.parse(ptProductOrder.getGroundPersonId());
        productOrderVO.setGroundPersonListVO(groundPersonListVO);

        //订单的详细流程
        PtOrderFlow orderFlow = ptOrderFlowManager.findByProductOrderId(id);
        if (orderFlow != null) {
            productOrderVO.setOrderFlow(orderFlow);

            List<String> personNames = new ArrayList<>();
            if (orderFlow.getPersonIds() != null) {
                for (String personId : orderFlow.getPersonIds().split(",")) {
                    if (!StringUtils.isEmpty(personId)) {
                        personNames.add(groundPersonService.findName(Long.valueOf(personId)));
                    }
                }
            }

            productOrderVO.setPersonNames(personNames);
        }

        return productOrderVO;
    }

    public CashPrePayWordsVO findWords(Long id) {
        PtProductOrder ptProductOrder = ptProductOrderManager.find(id);
        PtOrder ptOrder = orderService.findOne(ptProductOrder.getOrderId());
        Long goodsId = ptOrder.getPtGoodsId();
        PtGoods ptGoods = ptGoodsManager.findOne(goodsId);
        CashPrePayWordsVO vo = new CashPrePayWordsVO();
        Long prepayId = ptGoods.getYouCashPrePayId();
        if (prepayId != 0) {
            PtCashPrePay ptCashPrePay = ptCashPrePayManager.find(prepayId);
            vo.setFilePaths(ptCashPrePay.getFilePaths());
            vo.setRemark(ptCashPrePay.getRemark());
            vo.setCarryInfoList(ptCashPrePay.getCarryInfoList());
        }
        return vo;
    }

    private PrePayTemplateVO parseTemplate(PtPrePayTemplate template) {
        PrePayTemplateVO vo = new PrePayTemplateVO();
        BeanUtil.copyProperties(template, vo);
        vo.setProvinceValue(areaManager.findName(template.getProvince()));
        vo.setCityValue(areaManager.findName(template.getCity()));
        vo.setCountryValue(areaManager.findName(template.getCountry()));
        vo.setWantProvinceValue(areaManager.findName(template.getWantProvince()));
        vo.setWantCityValue(areaManager.findName(template.getWantCity()));
        vo.setWantCountryValue(areaManager.findName(template.getWantCountry()));
        vo.setSheBaoCityValue(areaManager.findName(template.getSheBaoCity()));
        vo.setSheBaoCountryValue(areaManager.findName(template.getSheBaoCountry()));
        vo.setSheBaoProvinceValue(areaManager.findName(template.getSheBaoProvince()));
        vo.setHospitalName(ptHospitalManager.findName(template.getHospitalId()));
        vo.setDept1Value(dictCache.findByGroupIdAndKey(1, template.getDept1()));
        vo.setDept2Value(dictCache.findByGroupIdAndKey(2, template.getDept2()));
        vo.setSheBaoStateValue(dictCache.findByGroupIdAndKey(13, template.getSheBaoState()));
        return vo;
    }

    /**
     * 地勤抢单
     */
    public BaseData receiveOrder(Long id) {
        PtProductOrder ptProductOrder = ptProductOrderManager.find(id);
        //已被他人抢单
        if (ptProductOrder.getGroundPersonId() != null) {
            return ResultGenerator.genFailResult("已被别人抢单");
        }
        Long personId = userKit.getGroundPersonId();
        ptProductOrder.setGroundPersonId(personId);
        ptProductOrder.setState("2");
        //设置转单记录
        PtChange ptChange = new PtChange();
        ptChange.setOrderId(id);
        ptChange.setNewPersonId(personId);
        ptChangeManager.add(ptChange);
        //添加flow
        PtOrderFlow ptOrderFlow = new PtOrderFlow();
        ptOrderFlow.setGroundPersonId(personId);
        ptOrderFlow.setProductOrderId(id);
        ptOrderFlow.setPersonIds(personId + "");
        ptOrderFlow.setGroundPersonIdTime(System.currentTimeMillis());
        ptOrderFlowManager.add(ptOrderFlow);

        return ResultGenerator.genSuccessResult(ptProductOrderManager.update(ptProductOrder));
    }

    /**
     * 后台发起抢单
     */
    public BaseData beginReceiveOrder(Long id, String province, String city, String country) {
        PtOrderReceive ptOrderReceive = new PtOrderReceive();
        ptOrderReceive.setProductOrderId(id);
        ptOrderReceive.setProvince(province);
        ptOrderReceive.setCity(city);
        ptOrderReceive.setCountry(country);

        //查询所有该地区的地勤
        GroundPersonListQueryModel groundPersonListQueryModel = new GroundPersonListQueryModel();
        groundPersonListQueryModel.setProvince(province);
        groundPersonListQueryModel.setCity(city);
        groundPersonListQueryModel.setCountry(country);
        groundPersonListQueryModel.setState(0);
        groundPersonListQueryModel.setSize(10000);
        SimplePage<GroundPersonListVO> simplePage = groundPersonService.find(groundPersonListQueryModel);
        List<GroundPersonListVO> tempList = (List<GroundPersonListVO>) simplePage.getList();
        List<GroundPersonListVO> list = new ArrayList<>();
        for (GroundPersonListVO groundPersonListVO : tempList) {
            if (ptSignManager.hasSign(groundPersonListVO.getId())) {
                list.add(groundPersonListVO);
            }
        }

        int count = 0;
        String personIds = "";
        for (GroundPersonListVO vo : list) {
            if (!StringUtils.isEmpty(vo.getOpenId())) {
                //通知
                applicationEventPublisher.publishEvent(new OrderReceiveEvent(new OrderReceiveBean(id + "",
                        vo.getOpenId(), "", "押金垫付" ,"",
                        vo.getId() + "")));
                count++;
                personIds += vo.getId() + ",";
            }
        }

        ptOrderReceive.setPersonIds(personIds);
        ptOrderReceiveManager.add(ptOrderReceive);

        return ResultGenerator.genSuccessResult(count);
    }

    /**
     * 派单
     */
    public PtProductOrder chooseGroundPerson(Long id, Long personId, String remark) {
        PtProductOrder ptProductOrder = ptProductOrderManager.find(id);
        ptProductOrder.setRemark(remark);
        ptProductOrder.setGroundPersonId(personId);
        ptProductOrder.setState("2");
        ptProductOrder.setPaidanPersonId(userKit.getCurrentUserId());

        PtChange ptChange = new PtChange();
        ptChange.setOrderId(id);
        ptChange.setNewPersonId(personId);
        ptChangeManager.add(ptChange);

        PtGroundPerson ptGroundPerson = ptGroundPersonManager.find(personId);
        Long orderId = ptProductOrder.getOrderId();
        PtOrder ptOrder = ptOrderManager.findOne(orderId);

        applicationEventPublisher.publishEvent(new NewOrderEvent(new NewOrderBean(id + "", ptGroundPerson.getOpenid(),
                ptOrder.getUserName(), "押金垫付", ptOrder.getMobile())));
        return ptProductOrderManager.update(ptProductOrder);
    }

    /**
     * 转单
     */
    public PtProductOrder changeGroundPerson(Long id, Long personId, String remark) {
        PtProductOrder ptProductOrder = ptProductOrderManager.find(id);
        //添加转单记录
        PtChange ptChange = new PtChange();
        ptChange.setOrderId(id);
        ptChange.setOldPersonId(ptProductOrder.getGroundPersonId());
        ptChange.setNewPersonId(personId);
        ptChangeManager.add(ptChange);

        ptProductOrder.setRemark(remark);
        ptProductOrder.setGroundPersonId(personId);
        ptProductOrder.setState("2");
        ptProductOrder.setChildState("2");
        ptProductOrder.setChangePerson(true);

        PtGroundPerson ptGroundPerson = ptGroundPersonManager.find(personId);
        Long orderId = ptProductOrder.getOrderId();
        PtOrder ptOrder = ptOrderManager.findOne(orderId);
        applicationEventPublisher.publishEvent(new NewOrderEvent(new NewOrderBean(id + "", ptGroundPerson.getOpenid(),
                ptOrder.getUserName(), "押金垫付", ptOrder.getMobile())));
        return ptProductOrderManager.update(ptProductOrder);
    }

    /**
     * 所有的
     */
    public SimplePage<ProductOrderListVO> findAll(ProductOrderListQueryModel productOrderListQueryModel) {
        Criteria<PtProductOrder> criteria = new Criteria<>();
        criteria.add(Restrictions.eq("id", productOrderListQueryModel.getId(), true));
        criteria.add(Restrictions.eq("state", productOrderListQueryModel.getState(), true));
        criteria.add(Restrictions.ne("state", productOrderListQueryModel.getNotState(), true));
        if (productOrderListQueryModel.getMyOrder() != null && productOrderListQueryModel.getMyOrder()) {
            criteria.add(Restrictions.eq("paidanPersonId", userKit.getCurrentUserId(), true));
        }
        criteria.add(Restrictions.eq("childState", productOrderListQueryModel.getChildState(), true));
        criteria.add(Restrictions.eq("deleteFlag", productOrderListQueryModel.getDeleteFlag(), true));
        //给H5用的功能
        if (userKit.getGroundPersonId() != null) {
            logger.info("personId是" + userKit.getGroundPersonId());
            //criteria.add(Restrictions.eq("groundPersonId", userKit.getGroundPersonId(), true));
            //查询某人所有接过的单
            criteria.add(Restrictions.in("id", ptChangeManager.findOrderIds(userKit.getGroundPersonId()), false));
        }

        OrderListQueryModel orderListQueryModel = new OrderListQueryModel();
        BeanUtil.copyProperties(productOrderListQueryModel, orderListQueryModel);
        if (!isAllFieldNull(orderListQueryModel)) {
            List<Long> ids = orderService.findIds(orderListQueryModel);
            criteria.add(Restrictions.in("orderId", ids, false));
        }

        Pageable pageable = PageRequest.of(productOrderListQueryModel.getPage(), productOrderListQueryModel.getSize(),
                Sort.Direction.DESC, "updateTime");
        Page<PtProductOrder> page = ptProductOrderManager.findAll(criteria, pageable);

        return new SimplePage<>(page.getTotalPages(), page.getTotalElements(), page.getContent().stream().map
                (this::parse).collect(Collectors.toList()));
    }

    private ProductOrderListVO parse(PtProductOrder ptProductOrder) {
        ProductOrderListVO productOrderListVO = new ProductOrderListVO();

        PtOrder order = orderService.findOne(ptProductOrder.getOrderId());
        BeanUtil.copyProperties(order, productOrderListVO);

        PtPrePayTemplate ptPrePayTemplate = ptPrePayTemplateManager.find(ptProductOrder.getTemplateId());

        BeanUtil.copyProperties(ptProductOrder, productOrderListVO);
        productOrderListVO.setChildStateValue(dictCache.findByGroupIdAndKey(15, ptProductOrder.getChildState()));
        productOrderListVO.setStateValue(dictCache.findByGroupIdAndKey(14, ptProductOrder.getState()));

        productOrderListVO.setCityValue(areaManager.findName(order.getCity()));
        productOrderListVO.setProvinceValue(areaManager.findName(order.getProvince()));
        productOrderListVO.setCountryValue(areaManager.findName(order.getCountry()));

        productOrderListVO.setWantProvince(areaManager.findName(ptPrePayTemplate.getWantProvince()));
        productOrderListVO.setWantCity(areaManager.findName(ptPrePayTemplate.getWantCity()));
        productOrderListVO.setWantCountry(areaManager.findName(ptPrePayTemplate.getWantCountry()));

        productOrderListVO.setCompanyName(ptCompanyManager.findNameById(order.getCompanyId()));
        productOrderListVO.setGroundPersonName(ptGroundPersonManager.findNameById(ptProductOrder.getGroundPersonId()));
        productOrderListVO.setHospitalName(ptHospitalManager.findName(ptPrePayTemplateManager.find(ptProductOrder
                .getTemplateId()).getHospitalId()));

        if (userKit.getGroundPersonId() != null) {
            //查询某人所有接过的单
            productOrderListVO.setPaiTime(ptChangeManager.findTime(userKit.getGroundPersonId()));
        }

        return productOrderListVO;
    }

    /**
     * 判断该对象是否: 返回true表示所有属性为null  返回false表示不是所有属性都是null
     */
    private boolean isAllFieldNull(Object obj) {
        Class stuCla = obj.getClass();
        Field[] fs = stuCla.getDeclaredFields();
        boolean flag = true;
        //遍历属性
        for (Field f : fs) {
            // 设置属性是可以访问的(私有的也可以)
            f.setAccessible(true);
            // 得到此属性的值
            Object val = null;
            try {
                val = f.get(obj);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            //只要有1个属性不为空,那么就不是所有的属性值都为空
            if (val != null) {
                flag = false;
                break;
            }
        }
        return flag;
    }


    public void delete(Long id, String reason) {
        PtProductOrder ptProductOrder = ptProductOrderManager.find(id);
        ptProductOrder.setDeleteFlag(true);
        ptProductOrder.setReason(reason);
        //已完成
        ptProductOrder.setState("8");
        ptProductOrder.setChildState("19");
        ptProductOrderManager.update(ptProductOrder);
    }

}
