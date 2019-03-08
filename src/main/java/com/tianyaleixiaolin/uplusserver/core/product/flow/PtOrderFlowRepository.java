package com.tianyaleixiaolin.uplusserver.core.product.flow;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author Mr.li wrote on 2018/10/26.
 */
public interface PtOrderFlowRepository extends JpaRepository<PtOrderFlow, Long>,
        JpaSpecificationExecutor<PtOrderFlow> {

    PtOrderFlow findFirstByProductOrderId(Long productOrderId);
}
