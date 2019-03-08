package com.tianyaleixiaolin.uplusserver.core.user.role;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author Mr.li wrote on 2018/10/26.
 */
public interface PtRoleRepository extends JpaRepository<PtRole, Long> {
    List<PtRole> findByDeleteFlagFalse();
}
