package com.tianyaleixiaolin.uplusserver.core.company.company;

import com.tianyaleixiaolin.uplusserver.core.user.user.PtUserManager;
import com.tianyaleixiaolin.uplusserver.global.bean.SimplePage;
import com.tianyaleixiaolin.uplusserver.global.bean.request.CompanyListQueryModel;
import com.tianyaleixiaolin.uplusserver.global.bean.request.CompanyTempListQueryModel;
import com.tianyaleixiaolin.uplusserver.global.bean.response.CompanyListVO;
import com.tianyaleixiaolin.uplusserver.global.bean.response.CompanyModifyDetailVO;
import com.tianyaleixiaolin.uplusserver.global.bean.response.CompanyTempListVO;
import com.tianyaleixiaolin.uplusserver.global.cache.DictCache;
import com.tianyaleixiaolin.uplusserver.global.specify.Criteria;
import com.tianyaleixiaolin.uplusserver.global.specify.Restrictions;
import com.tianyaleixiaolin.uplusserver.global.util.Constant;
import com.xiaoleilu.hutool.util.BeanUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.stream.Collectors;

/**
 * @author libolin wrote on 2018/11/15.
 */
@Component
@Transactional(rollbackFor = Exception.class)
public class CompanyService {
    @Resource
    private PtCompanyManager ptCompanyManager;
    @Resource
    private PtUserManager ptUserManager;
    @Resource
    private DictCache dictCache;

    public PtCompany add(PtCompany ptCompany) {
        ptCompany.setStatus(Constant.STATE_CONFIRM);
        ptCompany = ptCompanyManager.add(ptCompany);

        //同时新建一个temp
        PtCompanyTemp ptCompanyTemp = new PtCompanyTemp();
        BeanUtil.copyProperties(ptCompany, ptCompanyTemp, "id");
        ptCompanyTemp.setReason(Constant.REASON_NEW_CREATE);
        ptCompanyTemp.setCompanyId(ptCompany.getId());
        ptCompanyManager.addTemp(ptCompanyTemp);
        return ptCompany;
    }

    public PtCompanyTemp update(PtCompany ptCompany, String reason) {
        //待审核
        //ptCompany.setStatus(Constant.STATE_CONFIRM);
        //ptCompany = ptCompanyManager.update(ptCompany);

        //看有没有在修改中的，有则取，无则新建
        PtCompanyTemp ptCompanyTemp = ptCompanyManager.findTempByCompanyId(ptCompany.getId());
        if (ptCompanyTemp == null) {
            ptCompanyTemp = new PtCompanyTemp();
            ptCompanyTemp.setCompanyId(ptCompany.getId());
        }
        BeanUtil.copyProperties(ptCompany, ptCompanyTemp, "id");
        ptCompanyTemp.setStatus(Constant.STATE_CONFIRM);
        ptCompanyTemp.setReason(reason);
        return ptCompanyManager.updateTemp(ptCompanyTemp);
    }

    /**
     * 查已通过的
     */
    public SimplePage<CompanyListVO> find(CompanyListQueryModel companyListQueryModel) {
        Criteria<PtCompany> criteria = new Criteria<>();
        criteria.add(Restrictions.like("name", companyListQueryModel.getName(), true));
        criteria.add(Restrictions.eq("type", companyListQueryModel.getType(), true));
        criteria.add(Restrictions.eq("status", Constant.STATE_NORMAL, true));
        criteria.add(Restrictions.eq("deleteFlag", false, true));

        Pageable pageable = PageRequest.of(companyListQueryModel.getPage(), companyListQueryModel.getSize(), Sort
                .Direction.DESC, "id");
        Page<PtCompany> page = ptCompanyManager.findAll(criteria, pageable);

        return new SimplePage<>(page.getTotalPages(), page.getTotalElements(), page.getContent().stream().map
                (this::parse).collect(Collectors.toList()));
    }

    /**
     * 查待确认的，所有的
     */
    public SimplePage<CompanyTempListVO> find(CompanyTempListQueryModel companyTempListQueryModel) {
        Criteria<PtCompanyTemp> criteria = new Criteria<>();
        criteria.add(Restrictions.like("name", companyTempListQueryModel.getName(), true));
        criteria.add(Restrictions.eq("status", companyTempListQueryModel.getStatus(), true));
        criteria.add(Restrictions.eq("operatorId", companyTempListQueryModel.getOperatorId(), true));

        Pageable pageable = PageRequest.of(companyTempListQueryModel.getPage(), companyTempListQueryModel.getSize(), Sort
                .Direction.DESC, "updateTime");
        Page<PtCompanyTemp> page = ptCompanyManager.findAllTemp(criteria, pageable);

        return new SimplePage<>(page.getTotalPages(), page.getTotalElements(), page.getContent().stream().map
                (this::parseTemp).collect(Collectors.toList()));
    }

    /**
     * 查询某公司详情
     *
     * @param id
     *         id
     * @return PtCompany
     */
    public PtCompany findOne(Long id) {
        return ptCompanyManager.findOne(id);
    }

    /**
     * 包含被修改的详情
     */
    public CompanyModifyDetailVO findDetail(Long id) {
        PtCompanyTemp companyTemp = ptCompanyManager.findOneTemp(id);
        PtCompany company = ptCompanyManager.findOne(companyTemp.getCompanyId());

        CompanyModifyDetailVO companyModifyDetailVO = new CompanyModifyDetailVO();
        companyModifyDetailVO.setOperatorName(ptUserManager.findNameById(companyTemp.getOperatorId()));
        companyModifyDetailVO.setOrignal(company);
        companyModifyDetailVO.setModified(companyTemp);

        return companyModifyDetailVO;
    }

    /**
     * 审核公司，是否同意
     * 注意：新建时确认则是通过，需要修改原值。修改时，确认也需要覆盖，被拒绝了，则原值不用动
     * @param id tempId
     * @param confirm
     * confirm
     */
    @Transactional(rollbackFor = Exception.class)
    public void confirm(Long id, Boolean confirm) {
        if (confirm == null) {
            return;
        }
        PtCompanyTemp companyTemp = ptCompanyManager.findOneTemp(id);

        PtCompany ptCompany = ptCompanyManager.findOne(companyTemp.getCompanyId());
        if (confirm) {
            companyTemp.setStatus(Constant.STATE_NORMAL);
            PtCompanyTemp temp = new PtCompanyTemp();
            BeanUtils.copyProperties(companyTemp, temp);
            //将更新后的覆盖到原来的里面
            BeanUtil.copyProperties(temp, ptCompany, "id");
        } else {
            companyTemp.setStatus(Constant.STATE_REFUSE);
        }
        ptCompanyManager.update(ptCompany);
        ptCompanyManager.updateTemp(companyTemp);
    }

    private CompanyListVO parse(PtCompany ptCompany) {
        CompanyListVO companyListVO = new CompanyListVO();
        BeanUtil.copyProperties(ptCompany, companyListVO);
        companyListVO.setPropertyValue(dictCache.findByGroupIdAndKey(6, ptCompany.getProperty()));
        companyListVO.setTypeValue(dictCache.findByGroupIdAndKey(7, ptCompany.getType()));
        return companyListVO;
    }

    private CompanyTempListVO parseTemp(PtCompanyTemp ptCompany) {
        CompanyTempListVO companyListVO = new CompanyTempListVO();
        BeanUtil.copyProperties(ptCompany, companyListVO);
        companyListVO.setOperatorName(ptUserManager.findNameById(ptCompany.getOperatorId()));
        return companyListVO;
    }
}
