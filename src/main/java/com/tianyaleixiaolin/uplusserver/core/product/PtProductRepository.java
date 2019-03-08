package com.tianyaleixiaolin.uplusserver.core.product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

/**
 * @author Mr.li wrote on 2018/10/26.
 */
public interface PtProductRepository extends JpaRepository<PtProduct, Long>,
        JpaSpecificationExecutor<PtProduct> {
     List<PtProduct> findByDeleteFlagFalse();
}
