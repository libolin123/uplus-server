package com.tianyaleixiaolin.uplusserver.core.product;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class PtProductManager {
    @Resource
    private PtProductRepository ptProductRepository;

    public Page<PtProduct> findAll(Specification<PtProduct> var1, Pageable var2) {
        return ptProductRepository.findAll(var1, var2);
    }

    public List<PtProduct> findAll() {
        return ptProductRepository.findByDeleteFlagFalse();
    }

    public PtProduct find(Long id) {
        return ptProductRepository.getOne(id);
    }

    public String findNameById(Long id) {
        PtProduct ptProduct = find(id);
        if (ptProduct != null) {
            return ptProduct.getName();
        }
        return "";
    }

    public PtProduct add(PtProduct ptProduct) {
        return save(ptProduct);
    }

    public PtProduct update(PtProduct ptProduct) {
        return save(ptProduct);
    }

    public void delete(PtProduct ptProduct) {
        ptProduct.setDeleteFlag(true);
        update(ptProduct);
    }

    private PtProduct save(PtProduct ptProduct)  {
        return ptProductRepository.save(ptProduct);
    }
}
