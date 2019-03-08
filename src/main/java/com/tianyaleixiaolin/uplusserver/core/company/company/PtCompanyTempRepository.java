package com.tianyaleixiaolin.uplusserver.core.company.company;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author libolin wrote on 2018/10/26.
 */
public interface PtCompanyTempRepository extends JpaRepository<PtCompanyTemp, Long>,
        JpaSpecificationExecutor<PtCompanyTemp> {

    PtCompanyTemp findFirstByCompanyIdOrderByIdDesc(Long companyId);
}
