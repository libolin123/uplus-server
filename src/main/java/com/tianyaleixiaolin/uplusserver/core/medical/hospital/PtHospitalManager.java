package com.tianyaleixiaolin.uplusserver.core.medical.hospital;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class PtHospitalManager {
    @Resource
    private PtHospitalRepository ptHospitalRepository;

    public Page<PtHospital> findAll(Specification<PtHospital> var1, Pageable var2) {
        return ptHospitalRepository.findAll(var1, var2);
    }

    public List<PtHospital> findByName(String name) {
        return ptHospitalRepository.findByName(name);
    }

    public List<PtHospital> findByNameLike(String name) {
        return ptHospitalRepository.findByNameLikeOrOtherNameLike("%" + name + "%", "%" + name + "%");
    }

    public String findName(Long id) {
        if (id == null || !ptHospitalRepository.existsById(id)) {
            return "";
        }
        
        return find(id).getName();
    }

    public PtHospital find(Long id) {
        return ptHospitalRepository.getOne(id);
    }

    public PtHospital add(PtHospital ptHospital) {
        return save(ptHospital);
    }

    public PtHospital update(PtHospital ptHospital) {
        return save(ptHospital);
    }

    public void delete(PtHospital ptHospital) {
        ptHospital.setDeleteFlag(true);
        update(ptHospital);
    }

    private PtHospital save(PtHospital ptHospital)  {
        return ptHospitalRepository.save(ptHospital);
    }

}
