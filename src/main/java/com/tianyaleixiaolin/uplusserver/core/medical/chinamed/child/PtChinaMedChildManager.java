package com.tianyaleixiaolin.uplusserver.core.medical.chinamed.child;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class PtChinaMedChildManager {
    @Resource
    private PtChinaMedChildRepository ptChinaMedChildRepository;

    public Page<PtChinaMedChild> findAll(Specification<PtChinaMedChild> var1, Pageable var2) {
        return ptChinaMedChildRepository.findAll(var1, var2);
    }

    public List<PtChinaMedChild> findAll(Specification<PtChinaMedChild> var1) {
        return ptChinaMedChildRepository.findAll(var1);
    }

    /**
     * 统计分院数量
     *
     * @param ChinaMedId ChinaMedId
     * @return Integer
     */
    public Integer countByChinaMedId(Long ChinaMedId) {
        return ptChinaMedChildRepository.countByChinaMedId(ChinaMedId).intValue();
    }

    public PtChinaMedChild find(Long id) {
        return ptChinaMedChildRepository.getOne(id);
    }

    public PtChinaMedChild add(PtChinaMedChild ptChinaMed) {
        return save(ptChinaMed);
    }

    public PtChinaMedChild update(PtChinaMedChild ptChinaMed) {
        return save(ptChinaMed);
    }

    public void delete(PtChinaMedChild ptChinaMed) {
        ptChinaMed.setDeleteFlag(true);
        update(ptChinaMed);
    }

    private PtChinaMedChild save(PtChinaMedChild ptChinaMed) {
        return ptChinaMedChildRepository.save(ptChinaMed);
    }

}
