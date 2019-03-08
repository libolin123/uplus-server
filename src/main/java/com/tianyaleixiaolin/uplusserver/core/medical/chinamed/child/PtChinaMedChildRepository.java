package com.tianyaleixiaolin.uplusserver.core.medical.chinamed.child;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author Mr.li wrote on 2018/10/26.
 */
public interface PtChinaMedChildRepository extends JpaRepository<PtChinaMedChild, Long>,
        JpaSpecificationExecutor<PtChinaMedChild> {
    Long countByChinaMedId(Long id);
}
