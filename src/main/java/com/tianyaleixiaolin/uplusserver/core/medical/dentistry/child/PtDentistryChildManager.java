package com.tianyaleixiaolin.uplusserver.core.medical.dentistry.child;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class PtDentistryChildManager {
    @Resource
    private PtDentistryChildRepository ptDentistryChildRepository;

    public Page<PtDentistryChild> findAll(Specification<PtDentistryChild> var1, Pageable var2) {
        return ptDentistryChildRepository.findAll(var1, var2);
    }

    public List<PtDentistryChild> findAll(Specification<PtDentistryChild> var1) {
        return ptDentistryChildRepository.findAll(var1);
    }

    /**
     * 统计分院数量
     *
     * @param DentistryId DentistryId
     * @return Integer
     */
    public Integer countByDentistryId(Long DentistryId) {
        return ptDentistryChildRepository.countByDentistryId(DentistryId).intValue();
    }

    public PtDentistryChild find(Long id) {
        return ptDentistryChildRepository.getOne(id);
    }

    public PtDentistryChild add(PtDentistryChild ptDentistry) {
        return save(ptDentistry);
    }

    public PtDentistryChild update(PtDentistryChild ptDentistry) {
        return save(ptDentistry);
    }

    public void delete(PtDentistryChild ptDentistry) {
        ptDentistry.setDeleteFlag(true);
        update(ptDentistry);
    }

    private PtDentistryChild save(PtDentistryChild ptDentistry) {
        return ptDentistryChildRepository.save(ptDentistry);
    }

}
