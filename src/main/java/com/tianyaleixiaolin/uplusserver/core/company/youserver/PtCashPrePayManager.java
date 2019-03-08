package com.tianyaleixiaolin.uplusserver.core.company.youserver;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author libolin wrote on 2018/11/20.
 */
@Service
public class PtCashPrePayManager {
    @Resource
    private PtCashPrePayRepository ptCashPrePayRepository;

    public PtCashPrePay find(Long id) {
        return ptCashPrePayRepository.getOne(id);
    }

    public PtCashPrePay add(PtCashPrePay ptCashPrePay) {
        return ptCashPrePayRepository.save(ptCashPrePay);
    }

    public PtCashPrePay update(PtCashPrePay ptCashPrePay) {
        return ptCashPrePayRepository.save(ptCashPrePay);
    }
}
