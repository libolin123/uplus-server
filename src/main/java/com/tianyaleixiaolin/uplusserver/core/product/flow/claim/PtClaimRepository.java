package com.tianyaleixiaolin.uplusserver.core.product.flow.claim;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author Mr.li wrote on 2018/10/26.
 */
public interface PtClaimRepository extends JpaRepository<PtClaim, Long>,
        JpaSpecificationExecutor<PtClaim> {
    PtClaim findFirstByProductOrderId(Long productOrderId);
}
