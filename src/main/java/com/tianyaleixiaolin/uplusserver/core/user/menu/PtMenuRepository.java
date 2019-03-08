package com.tianyaleixiaolin.uplusserver.core.user.menu;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Mr.li wrote on 2018/10/26.
 */
public interface PtMenuRepository extends JpaRepository<PtMenu, Long> {
    int countByParentIdAndHideIsFalse(Long id);
}
