package com.tianyaleixiaolin.uplusserver.core.product.define;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author Mr.li wrote on 2018/10/26.
 */
public interface PtProductDefineSettingRepository extends JpaRepository<PtProductDefineSetting, Long>,
        JpaSpecificationExecutor<PtProductDefineSetting> {
    PtProductDefineSetting findFirstByProductId(Long productId);
}
