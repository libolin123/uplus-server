package com.tianyaleixiaolin.uplusserver.core.medical.chinamed;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class PtChinaMedManager {
    @Resource
    private PtChinaMedRepository ptChinaMedRepository;

    public Page<PtChinaMed> findAll(Specification<PtChinaMed> var1, Pageable var2) {
        return ptChinaMedRepository.findAll(var1, var2);
    }

    public PtChinaMed find(Long id) {
        return ptChinaMedRepository.getOne(id);
    }

    public PtChinaMed add(PtChinaMed ptChinaMed) {
        return save(ptChinaMed);
    }

    public PtChinaMed update(PtChinaMed ptChinaMed) {
        return save(ptChinaMed);
    }

    public void delete(PtChinaMed ptChinaMed) {
        ptChinaMed.setDeleteFlag(true);
        update(ptChinaMed);
    }

    private PtChinaMed save(PtChinaMed ptChinaMed)  {
        return ptChinaMedRepository.save(ptChinaMed);
    }

}
