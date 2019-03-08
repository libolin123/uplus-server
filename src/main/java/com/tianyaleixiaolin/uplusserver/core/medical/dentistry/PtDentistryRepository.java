package com.tianyaleixiaolin.uplusserver.core.medical.dentistry;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author Mr.li wrote on 2018/10/26.
 */
public interface PtDentistryRepository extends JpaRepository<PtDentistry, Long>, JpaSpecificationExecutor<PtDentistry> {
}
