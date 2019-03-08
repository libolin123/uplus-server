package com.tianyaleixiaolin.uplusserver.core.order;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author Mr.li wrote on 2018/11/22.
 */
@Service
public class PtOrderRelationManager {
    @Resource
    private PtOrderRelationRepository ptOrderRelationRepository;

    public PtOrderRelation add(PtOrderRelation ptOrderRelation) {
        return save(ptOrderRelation);
    }

    public PtOrderRelation update(PtOrderRelation ptOrderRelation) {
        return save(ptOrderRelation);
    }

    private PtOrderRelation save(PtOrderRelation ptOrderRelation) {
        return ptOrderRelationRepository.save(ptOrderRelation);
    }

    public PtOrderRelation findByOrderId(Long orderId) {
        return ptOrderRelationRepository.findFirstByOrderId(orderId);
    }

    public String findNameByOrderId(Long orderId) {
        PtOrderRelation orderRelation = findByOrderId(orderId);
        if (orderRelation == null) {
            return "无";
        }
        return orderRelation.getUserName();
    }
}
