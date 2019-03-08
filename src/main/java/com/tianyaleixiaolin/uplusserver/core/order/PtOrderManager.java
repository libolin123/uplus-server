package com.tianyaleixiaolin.uplusserver.core.order;

import com.tianyaleixiaolin.uplusserver.global.util.Constant;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author Mr.li wrote on 2018/11/22.
 */
@Service
public class PtOrderManager {
    @Resource
    private PtOrderRepository ptOrderRepository;
    @Resource
    private PtOrderTempRepository ptOrderTempRepository;

    public PtOrder add(PtOrder ptOrder) {
        return save(ptOrder);
    }

    public PtOrderTemp addTemp(PtOrderTemp ptOrder) {
        return save(ptOrder);
    }

    /**
     * 提交更新时，修改原来的状态为"待审核"，将新的属性全部存到temp中
     *
     * @param ptOrder
     *         PtOrder
     * @return PtOrder
     */
    public PtOrder update(PtOrder ptOrder) {
        return save(ptOrder);
    }

    public PtOrderTemp updateTemp(PtOrderTemp ptOrder) {
        return saveTemp(ptOrder);
    }

    public PtOrderTemp save(PtOrderTemp ptOrderTemp) {
        return ptOrderTempRepository.save(ptOrderTemp);
    }

    public PtOrderTemp findTempByOrderId(Long orderId) {
        return ptOrderTempRepository.findFirstByOrderIdOrderByIdDesc(orderId);
    }

    /**
     * 商品下架
     */
    public void delete(PtOrder ptOrder) {
        ptOrder.setDeleteFlag(true);
        save(ptOrder);
    }

    /**
     * 下架商品
     */
    public void deleteTemp(PtOrderTemp ptOrderTemp) {
        ptOrderTemp.setDeleteFlag(true);
        ptOrderTemp.setOperatorType(Constant.REASON_DELETE);
        save(ptOrderTemp);
    }

    public PtOrderTemp findOneTempByOrderId(Long orderId) {
        return ptOrderTempRepository.findFirstByOrderIdOrderByIdDesc(orderId);
    }

    public PtOrderTemp findOneTemp(Long id) {
        return ptOrderTempRepository.getOne(id);
    }

    private PtOrder save(PtOrder ptOrder) {
        return ptOrderRepository.save(ptOrder);
    }

    private PtOrderTemp saveTemp(PtOrderTemp ptOrder) {
        return ptOrderTempRepository.save(ptOrder);
    }

    public PtOrder findOne(Long id) {
        return ptOrderRepository.getOne(id);
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
    public Page<PtOrder> findAll(Specification<PtOrder> var1, Pageable var2) {
        return ptOrderRepository.findAll(var1, var2);
    }

    public Page<PtOrderTemp> findAllTemp(Specification<PtOrderTemp> var1, Pageable var2) {
        return ptOrderTempRepository.findAll(var1, var2);
    }

}
