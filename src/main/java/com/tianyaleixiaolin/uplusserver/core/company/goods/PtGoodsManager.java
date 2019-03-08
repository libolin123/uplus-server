package com.tianyaleixiaolin.uplusserver.core.company.goods;

import com.tianyaleixiaolin.uplusserver.global.util.Constant;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author libolin wrote on 2018/11/16.
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class PtGoodsManager {
    @Resource
    private PtGoodsRepository ptGoodsRepository;
    @Resource
    private PtGoodsTempRepository ptGoodsTempRepository;

    public PtGoods add(PtGoods ptGoods) {
        return save(ptGoods);
    }

    public PtGoodsTemp addTemp(PtGoodsTemp ptGoods) {
        return ptGoodsTempRepository.save(ptGoods);
    }

    public PtGoodsTemp updateTemp(PtGoodsTemp ptGoodsTemp) {
        return save(ptGoodsTemp);
    }

    public PtGoods update(PtGoods ptGoods) {
        return save(ptGoods);
    }

    private PtGoods save(PtGoods ptGoods) {
        return ptGoodsRepository.save(ptGoods);
    }

    private PtGoodsTemp save(PtGoodsTemp ptGoodsTemp) {
        return ptGoodsTempRepository.save(ptGoodsTemp);
    }

    public String youServers(Long id) {
        return youServers(findOne(id));
    }

    public String youServers(PtGoods ptGoods) {
        String you = "";
        //优加服务
        if (ptGoods.getYouCashPrePayId() != 0) {
            you += "押金垫付 ";
        }
        if (ptGoods.getYouPhoneDoctorId() != 0) {
            you += "电话医生 ";
        }
        if (ptGoods.getYouBodyCheck() != 0) {
            you += "体检服务 ";
        }
        if (ptGoods.getYouOutpatient() != 0) {
            you += "门诊绿通 ";
        }
        if (ptGoods.getYouHospital() != 0) {
            you += "住院绿通 ";
        }
        if (ptGoods.getYouOperation() != 0) {
            you += "手术绿通 ";
        }
        if (ptGoods.getYouSecondMed() != 0) {
            you += "二次诊疗";
        }
        return you;
    }

    /**
     * 商品下架
     */
    public void delete(PtGoods ptGoods) {
        ptGoods.setDeleteFlag(true);
        save(ptGoods);
    }

    /**
     * 上、下架商品
     */
    public void deleteTemp(PtGoodsTemp ptGoodsTemp, Boolean upload) {
        if (upload == null) {
            upload = false;
        }
        ptGoodsTemp.setDeleteFlag(upload);
        if (upload) {
            ptGoodsTemp.setReason(Constant.REASON_UPLOAD);
            ptGoodsTemp.setOperatorType(Constant.REASON_UPLOAD);
        } else {
            ptGoodsTemp.setReason(Constant.REASON_DELETE);
            ptGoodsTemp.setOperatorType(Constant.REASON_DELETE);
        }
        save(ptGoodsTemp);
    }

    /**
     * 根据商品计划查询所有temp
     */
    public List<PtGoodsTemp> findByPlanId(Long planId) {
        return ptGoodsTempRepository.findByPtGoodsPlanId(planId);
    }

    public PtGoodsTemp findOneTemp(Long id) {
        return ptGoodsTempRepository.getOne(id);
    }

    public PtGoodsTemp findOneTempByGoodsId(Long goodsId) {
        return ptGoodsTempRepository.findFirstByGoodsIdOrderByIdDesc(goodsId);
    }

    public PtGoods findOne(Long id) {
        return ptGoodsRepository.getOne(id);
    }

    public String findNameById(Long id) {
        PtGoods ptGoods = findOne(id);
        return ptGoods.getName();
    }

    public String findNameByPlanId(Long planId) {
        List<PtGoods> ptGoods = ptGoodsRepository.findByPtGoodsPlanIdAndDeleteFlagFalse(planId);
        StringBuilder stringBuilder = new StringBuilder();
        for (PtGoods goods : ptGoods) {
            stringBuilder.append(goods.getName()).append("  ");
        }
        return stringBuilder.toString();
    }

    /**
     * 分页查找
     *
     * @param var1
     *         var1
     * @param var2
     *         var2
     * @return Page
     */
    public Page<PtGoods> findAll(Specification<PtGoods> var1, Pageable var2) {
        return ptGoodsRepository.findAll(var1, var2);
    }

    /**
     * 根据公司id查询
     */
    public Page<PtGoods> findByCompanyId(Long companyId, Pageable var2) {
        return ptGoodsRepository.findByCompanyId(companyId, var2);
    }

    public Page<PtGoodsTemp> findAllTemp(Specification<PtGoodsTemp> var1, Pageable var2) {
        return ptGoodsTempRepository.findAll(var1, var2);
    }
}
