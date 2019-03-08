package com.tianyaleixiaolin.uplusserver.core.medical.chinamed;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author Mr.li wrote on 2018/10/26.
 */
public interface PtChinaMedRepository extends JpaRepository<PtChinaMed, Long>, JpaSpecificationExecutor<PtChinaMed> {
}
