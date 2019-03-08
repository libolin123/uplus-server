package com.tianyaleixiaolin.uplusserver.core.medical.physical;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author Mr.li wrote on 2018/10/26.
 */
public interface PtPhysicalRepository extends JpaRepository<PtPhysical, Long>, JpaSpecificationExecutor<PtPhysical> {
}
