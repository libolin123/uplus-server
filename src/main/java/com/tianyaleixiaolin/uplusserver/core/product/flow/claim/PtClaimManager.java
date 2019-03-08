package com.tianyaleixiaolin.uplusserver.core.product.flow.claim;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author wuwf
 */
@Service
public class PtClaimManager {
    @Resource
    private PtClaimRepository ptClaimRepository;

    public PtClaim findByProductOrderId(Long productOrderId) {
        return ptClaimRepository.findFirstByProductOrderId(productOrderId);
    }

    public PtClaim add(PtClaim ptClaim) {
        return save(ptClaim);
    }

    public PtClaim update(PtClaim ptClaim) {
        return save(ptClaim);
    }

    public PtClaim find(Long id) {
        return ptClaimRepository.getOne(id);
    }

    private PtClaim save(PtClaim ptClaim) {
        return ptClaimRepository.save(ptClaim);
    }
    
    public void delete(PtClaim ptClaim) {
        ptClaimRepository.delete(ptClaim);
    }

}
