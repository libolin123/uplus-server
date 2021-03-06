package com.tianyaleixiaolin.uplusserver.core.order;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author Mr.li wrote on 2018/10/26.
 */
public interface PtOrderRepository extends JpaRepository<PtOrder, Long>,
        JpaSpecificationExecutor<PtOrder> {

}
