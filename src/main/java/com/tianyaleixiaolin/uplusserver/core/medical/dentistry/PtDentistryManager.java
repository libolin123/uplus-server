package com.tianyaleixiaolin.uplusserver.core.medical.dentistry;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class PtDentistryManager {
    @Resource
    private PtDentistryRepository ptDentistryRepository;

    public Page<PtDentistry> findAll(Specification<PtDentistry> var1, Pageable var2) {
        return ptDentistryRepository.findAll(var1, var2);
    }

    public PtDentistry find(Long id) {
        return ptDentistryRepository.getOne(id);
    }

    public PtDentistry add(PtDentistry ptDentistry) {
        return save(ptDentistry);
    }

    public PtDentistry update(PtDentistry ptDentistry) {
        return save(ptDentistry);
    }

    public void delete(PtDentistry ptDentistry) {
        ptDentistry.setDeleteFlag(true);
        update(ptDentistry);
    }

    private PtDentistry save(PtDentistry ptDentistry)  {
        return ptDentistryRepository.save(ptDentistry);
    }

}
