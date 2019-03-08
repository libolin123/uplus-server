package com.tianyaleixiaolin.uplusserver.core.person.sign;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author Mr.li wrote on 2018/10/26.
 */
public interface PtSignRepository extends JpaRepository<PtSign, Long>,
        JpaSpecificationExecutor<PtSign> {
    PtSign findFirstByGroundPersonId(Long id);
}
