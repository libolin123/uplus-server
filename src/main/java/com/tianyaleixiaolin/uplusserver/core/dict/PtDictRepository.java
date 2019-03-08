package com.tianyaleixiaolin.uplusserver.core.dict;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Mr.li wrote on 2018/10/26.
 */
public interface PtDictRepository extends JpaRepository<PtDict, Long> {
    List<PtDict> findByGroupId(Integer groupId);

    List<PtDict> findByGroupIdAndParentKey(Integer groupId, String parentKey);

    @Transactional(rollbackFor = Exception.class)
    @Modifying
    void deleteByParentKey(String key);
}
