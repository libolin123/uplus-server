package com.tianyaleixiaolin.uplusserver.core.company.goods;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @author libolin wrote on 2018/10/26.
 */
public interface PtGoodsRepository extends JpaRepository<PtGoods, Long>,
        JpaSpecificationExecutor<PtGoods> {

    @Query("update PtGoods set deleteFlag = true where ptGoodsPlanId = ?1")
    @Modifying
    void xiajiaByPlanId(Long goodsPlanId);

    /**
     * 分页查询某公司的所有商品
     */
    Page<PtGoods> findByCompanyId(Long companyId, Pageable pageable);


    List<PtGoods> findByPtGoodsPlanIdAndDeleteFlagFalse(Long goodsPlanId);
}
