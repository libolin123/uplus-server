package com.tianyaleixiaolin.uplusserver.core.company.company;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author libolin wrote on 2018/10/26.
 */
@Service
public class PtCompanyManager {
    @Resource
    private PtCompanyRepository ptCompanyRepository;
    @Resource
    private PtCompanyTempRepository ptCompanyTempRepository;

    public PtCompany add(PtCompany ptCompany) {
        return save(ptCompany);
    }

    public PtCompanyTemp addTemp(PtCompanyTemp ptCompany) {
        return save(ptCompany);
    }

    /**
     * 提交更新时，修改原来的状态为"待审核"，将新的属性全部存到temp中
     * @param ptCompany  ptCompany
     * @return PtCompany
     */
    public PtCompany update(PtCompany ptCompany) {
        return save(ptCompany);
    }

    public PtCompanyTemp updateTemp(PtCompanyTemp ptCompany) {
        return saveTemp(ptCompany);
    }

    public PtCompanyTemp save(PtCompanyTemp ptCompanyTemp) {
        return ptCompanyTempRepository.save(ptCompanyTemp);
    }

    public PtCompanyTemp findTempByCompanyId(Long companyId) {
        return ptCompanyTempRepository.findFirstByCompanyIdOrderByIdDesc(companyId);
    }

    public PtCompanyTemp findOneTemp(Long id) {
        return ptCompanyTempRepository.getOne(id);
    }

    private PtCompany save(PtCompany ptCompany) {
        return ptCompanyRepository.save(ptCompany);
    }

    private PtCompanyTemp saveTemp(PtCompanyTemp ptCompany) {
        return ptCompanyTempRepository.save(ptCompany);
    }

    public PtCompany findOne(Long id) {
        return ptCompanyRepository.getOne(id);
    }

    public boolean exist(Long id) {
        return ptCompanyRepository.existsById(id);
    }

    /**
     * 判断该公司状态是否异常(status不为0，或者对应的product的state为-1)
     *
     * @param companyId
     *         公司id
     * @return 是否异常
     */
    public boolean isStatusError(Long companyId) {
        PtCompany ptCompany = ptCompanyRepository.getOne(companyId);
        return ptCompany != null && ptCompany.getStatus() != 0;
    }

    public String findNameById(Long id) {
        if (id == null || !ptCompanyRepository.existsById(id)) {
            return "";
        }

        return findOne(id).getName();
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
    public Page<PtCompany> findAll(Specification<PtCompany> var1, Pageable var2) {
        return ptCompanyRepository.findAll(var1, var2);
    }

    public Page<PtCompanyTemp> findAllTemp(Specification<PtCompanyTemp> var1, Pageable var2) {
        return ptCompanyTempRepository.findAll(var1, var2);
    }
}
