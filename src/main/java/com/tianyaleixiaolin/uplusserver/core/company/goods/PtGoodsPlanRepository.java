package com.tianyaleixiaolin.uplusserver.core.company.goods;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

/**
 * @author libolin wrote on 2018/10/26.
 */
public interface PtGoodsPlanRepository extends JpaRepository<PtGoodsPlan, Long>,
        JpaSpecificationExecutor<PtGoodsPlan> {
    List<PtGoodsPlan> findByCompanyId(Long companyId);
}
