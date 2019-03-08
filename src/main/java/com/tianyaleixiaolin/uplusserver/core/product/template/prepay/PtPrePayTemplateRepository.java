package com.tianyaleixiaolin.uplusserver.core.product.template.prepay;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author Mr.li wrote on 2018/10/26.
 */
public interface PtPrePayTemplateRepository extends JpaRepository<PtPrePayTemplate, Long>,
        JpaSpecificationExecutor<PtPrePayTemplate> {
}
