package com.tianyaleixiaolin.uplusserver.core.medical.dentistry.child;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author Mr.li wrote on 2018/10/26.
 */
public interface PtDentistryChildRepository extends JpaRepository<PtDentistryChild, Long>,
        JpaSpecificationExecutor<PtDentistryChild> {
    Long countByDentistryId(Long id);
}
