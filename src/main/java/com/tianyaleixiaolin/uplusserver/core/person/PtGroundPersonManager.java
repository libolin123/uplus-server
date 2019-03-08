package com.tianyaleixiaolin.uplusserver.core.person;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class PtGroundPersonManager {
    @Resource
    private PtGroundPersonRepository ptGroundPersonRepository;

    public Page<PtGroundPerson> findAll(Specification<PtGroundPerson> var1, Pageable var2) {
        return ptGroundPersonRepository.findAll(var1, var2);
    }

    public String findNameById(Long id) {
        if (id == null || !ptGroundPersonRepository.existsById(id)) {
            return "";
        }

        return find(id).getUserName();
    }

    public PtGroundPerson findByMobile(String mobile) {
        return ptGroundPersonRepository.findFirstByMobileAndDeleteFlagFalse(mobile);
    }


    public PtGroundPerson find(Long id) {
        return ptGroundPersonRepository.getOne(id);
    }

    public PtGroundPerson add(PtGroundPerson ptGroundPerson) {
        return save(ptGroundPerson);
    }

    public PtGroundPerson update(PtGroundPerson ptGroundPerson) {
        return save(ptGroundPerson);
    }

    public void delete(PtGroundPerson ptGroundPerson) {
        ptGroundPerson.setDeleteFlag(true);
        update(ptGroundPerson);
    }

    private PtGroundPerson save(PtGroundPerson ptGroundPerson) {
        return ptGroundPersonRepository.save(ptGroundPerson);
    }
}
