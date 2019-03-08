package com.tianyaleixiaolin.uplusserver.core.medical.doctor;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author Mr.li wrote on 2018/10/26.
 */
public interface PtDoctorRepository extends JpaRepository<PtDoctor, Long>,
        JpaSpecificationExecutor<PtDoctor> {
}
