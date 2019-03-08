package com.tianyaleixiaolin.uplusserver.core.dict.area;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author Mr.li wrote on 2018/10/26.
 */
public interface AreaRepository extends JpaRepository<AreaEntity, Long> {
    AreaEntity findByAreaCode(String areaCode);

    List<AreaEntity> findByParentId(Long parentId);
}
