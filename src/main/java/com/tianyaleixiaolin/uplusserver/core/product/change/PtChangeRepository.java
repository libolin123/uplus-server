package com.tianyaleixiaolin.uplusserver.core.product.change;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

/**
 * @author Mr.li wrote on 2018/10/26.
 */
public interface PtChangeRepository extends JpaRepository<PtChange, Long>,
        JpaSpecificationExecutor<PtChange> {
    List<PtChange> findByOldPersonIdOrNewPersonId(Long oldId, Long newId);

    PtChange findFirstByNewPersonIdOrderByIdDesc(Long newId);
}
