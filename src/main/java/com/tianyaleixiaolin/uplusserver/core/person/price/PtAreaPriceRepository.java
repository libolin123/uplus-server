package com.tianyaleixiaolin.uplusserver.core.person.price;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author Mr.li wrote on 2018/10/26.
 */
public interface PtAreaPriceRepository extends JpaRepository<PtAreaPrice, Long>,
        JpaSpecificationExecutor<PtAreaPrice> {
    PtAreaPrice findByAreaName(String areaName);
}
