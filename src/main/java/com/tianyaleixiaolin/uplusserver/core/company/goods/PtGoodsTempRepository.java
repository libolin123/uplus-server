package com.tianyaleixiaolin.uplusserver.core.company.goods;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

/**
 * @author libolin wrote on 2018/10/26.
 */
public interface PtGoodsTempRepository extends JpaRepository<PtGoodsTemp, Long>,
        JpaSpecificationExecutor<PtGoodsTemp> {

    PtGoodsTemp findFirstByGoodsIdOrderByIdDesc(Long goodsId);

    /**
     * 根据计划查询所有
     */
    List<PtGoodsTemp> findByPtGoodsPlanId(Long planId);
}
