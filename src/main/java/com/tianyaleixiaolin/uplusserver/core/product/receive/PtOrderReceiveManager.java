package com.tianyaleixiaolin.uplusserver.core.product.receive;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class PtOrderReceiveManager {
    @Resource
    private PtOrderReceiveRepository ptOrderReceiveRepository;


    public PtOrderReceive findByProductOrderId(Long id) {
        return ptOrderReceiveRepository.getOne(id);
    }

    public PtOrderReceive add(PtOrderReceive ptOrderReceive) {
        return save(ptOrderReceive);
    }

    public PtOrderReceive update(PtOrderReceive ptOrderReceive) {
        return save(ptOrderReceive);
    }


    private PtOrderReceive save(PtOrderReceive ptOrderReceive)  {
        return ptOrderReceiveRepository.save(ptOrderReceive);
    }
}
