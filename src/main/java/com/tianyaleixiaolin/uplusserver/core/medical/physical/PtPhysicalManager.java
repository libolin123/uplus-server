package com.tianyaleixiaolin.uplusserver.core.medical.physical;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class PtPhysicalManager {
    @Resource
    private PtPhysicalRepository ptPhysicalRepository;

    public Page<PtPhysical> findAll(Specification<PtPhysical> var1, Pageable var2) {
        return ptPhysicalRepository.findAll(var1, var2);
    }

    public PtPhysical find(Long id) {
        return ptPhysicalRepository.getOne(id);
    }

    public PtPhysical add(PtPhysical ptPhysical) {
        return save(ptPhysical);
    }

    public PtPhysical update(PtPhysical ptPhysical) {
        return save(ptPhysical);
    }

    public void delete(PtPhysical ptPhysical) {
        ptPhysical.setDeleteFlag(true);
        update(ptPhysical);
    }

    private PtPhysical save(PtPhysical ptPhysical)  {
        return ptPhysicalRepository.save(ptPhysical);
    }

}
