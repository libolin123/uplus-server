package com.tianyaleixiaolin.uplusserver.core.medical.hospital;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

/**
 * @author Mr.li wrote on 2018/10/26.
 */
public interface PtHospitalRepository extends JpaRepository<PtHospital, Long>, JpaSpecificationExecutor<PtHospital> {
    List<PtHospital> findByNameLikeOrOtherNameLike(String name, String otherName);

    List<PtHospital> findByName(String name);
}
