package com.tianyaleixiaolin.uplusserver.core.medical.physical.child;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author Mr.li wrote on 2018/10/26.
 */
public interface PtPhysicalChildRepository extends JpaRepository<PtPhysicalChild, Long>,
        JpaSpecificationExecutor<PtPhysicalChild> {
    Long countByPhysicalId(Long id);
}
