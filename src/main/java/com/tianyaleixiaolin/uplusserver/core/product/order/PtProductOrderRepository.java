package com.tianyaleixiaolin.uplusserver.core.product.order;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author Mr.li wrote on 2018/10/26.
 */
public interface PtProductOrderRepository extends JpaRepository<PtProductOrder, Long>,
        JpaSpecificationExecutor<PtProductOrder> {
}
