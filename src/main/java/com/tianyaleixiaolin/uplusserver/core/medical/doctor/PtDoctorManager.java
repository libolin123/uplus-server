package com.tianyaleixiaolin.uplusserver.core.medical.doctor;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class PtDoctorManager {
    @Resource
    private PtDoctorRepository ptDoctorRepository;

    public Page<PtDoctor> findAll(Specification<PtDoctor> var1, Pageable var2) {
        return ptDoctorRepository.findAll(var1, var2);
    }

    public PtDoctor find(Long id) {
        return ptDoctorRepository.getOne(id);
    }

    public PtDoctor add(PtDoctor ptDoctor) {
        return save(ptDoctor);
    }

    public PtDoctor update(PtDoctor ptDoctor) {
        return save(ptDoctor);
    }

    public void delete(PtDoctor ptDoctor) {
        ptDoctor.setDeleteFlag(true);
        update(ptDoctor);
    }

    private PtDoctor save(PtDoctor ptDoctor)  {
        return ptDoctorRepository.save(ptDoctor);
    }

}
