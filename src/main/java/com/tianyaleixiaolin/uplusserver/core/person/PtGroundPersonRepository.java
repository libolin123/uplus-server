package com.tianyaleixiaolin.uplusserver.core.person;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author Mr.li wrote on 2018/10/26.
 */
public interface PtGroundPersonRepository extends JpaRepository<PtGroundPerson, Long>,
        JpaSpecificationExecutor<PtGroundPerson> {
    PtGroundPerson findFirstByMobileAndDeleteFlagFalse(String mobile);
}
