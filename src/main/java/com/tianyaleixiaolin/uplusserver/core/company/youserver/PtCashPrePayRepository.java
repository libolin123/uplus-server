package com.tianyaleixiaolin.uplusserver.core.company.youserver;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author libolin wrote on 2018/10/26.
 */
public interface PtCashPrePayRepository extends JpaRepository<PtCashPrePay, Long>,
        JpaSpecificationExecutor<PtCashPrePay> {

}
