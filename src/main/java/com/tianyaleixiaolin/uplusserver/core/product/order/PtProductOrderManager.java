package com.tianyaleixiaolin.uplusserver.core.product.order;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author wuwf
 */
@Service
public class PtProductOrderManager {
    @Resource
    private PtProductOrderRepository ptProductOrderRepository;

    public PtProductOrder add(PtProductOrder ptProductOrder) {
        return save(ptProductOrder);
    }


    /**
     * 分页查找
     *
     * @param var1
     *         var1
     * @param var2
     *         var2
     * @return Page
     */
    public Page<PtProductOrder> findAll(Specification<PtProductOrder> var1, Pageable var2) {
        return ptProductOrderRepository.findAll(var1, var2);
    }

    public PtProductOrder update(PtProductOrder ptProductOrder) {
        return save(ptProductOrder);
    }

    public PtProductOrder find(Long id) {
        return ptProductOrderRepository.getOne(id);
    }

    private PtProductOrder save(PtProductOrder ptProductOrder) {
        return ptProductOrderRepository.save(ptProductOrder);
    }
    
    public void delete(PtProductOrder ptProductOrder) {
        ptProductOrderRepository.delete(ptProductOrder);
    }

}
