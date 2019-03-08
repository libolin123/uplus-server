package com.tianyaleixiaolin.uplusserver.core.product.flow.setting;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

/**
 * @author Mr.li wrote on 2018/10/26.
 */
public interface PtOrderFlowSettingRepository extends JpaRepository<PtOrderFlowSetting, Long>,
        JpaSpecificationExecutor<PtOrderFlowSetting> {
    List<PtOrderFlowSetting> findByProductIdOrderBySort(Long productId);
}
