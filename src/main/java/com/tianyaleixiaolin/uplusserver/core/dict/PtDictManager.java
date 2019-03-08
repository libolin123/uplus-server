package com.tianyaleixiaolin.uplusserver.core.dict;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Mr.li wrote on 2018/11/14.
 */
@Service
public class PtDictManager {
    @Resource
    private PtDictRepository ptDictRepository;

    public List<PtDict> findByGroupId(Integer groupId) {
        return ptDictRepository.findByGroupId(groupId);
    }

    public List<PtDict> findByGroupIdAndParentKey(Integer groupId, String parentKey) {
        return ptDictRepository.findByGroupIdAndParentKey(groupId, parentKey);
    }

    public List<PtDict> findAll() {
        return ptDictRepository.findAll();
    }

    public PtDict add(PtDict ptDict) {
        return save(ptDict);
    }

    public PtDict update(PtDict ptDict) {
        return save(ptDict);
    }

    public void delete(PtDict ptDict) {
        ptDictRepository.delete(ptDict);
        //删1级科室
        if (1 == ptDict.getGroupId()) {
            //同时删2级科室
            ptDictRepository.deleteByParentKey(ptDict.getdKey());
        }
    }

    public PtDict find(Long id) {
        return ptDictRepository.getOne(id);
    }

    public PtDict save(PtDict ptDict) {
        return ptDictRepository.save(ptDict);
    }
}
