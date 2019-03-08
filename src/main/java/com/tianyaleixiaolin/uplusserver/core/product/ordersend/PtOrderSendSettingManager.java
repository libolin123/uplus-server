package com.tianyaleixiaolin.uplusserver.core.product.ordersend;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author wuwf
 */
@Service
public class PtOrderSendSettingManager {
    @Resource
    private PtOrderSendSettingRepository ptOrderSendSettingRepository;

    public List<PtOrderSendSetting> findByProductId(Long productId) {
        return ptOrderSendSettingRepository.findByProductIdOrderBySortDesc(productId);
    }

    public PtOrderSendSetting add(PtOrderSendSetting ptOrderSendSetting) {
        return save(ptOrderSendSetting);
    }

    public PtOrderSendSetting update(PtOrderSendSetting ptOrderSendSetting) {
        return save(ptOrderSendSetting);
    }

    private PtOrderSendSetting save(PtOrderSendSetting ptOrderSendSetting) {
        return ptOrderSendSettingRepository.save(ptOrderSendSetting);
    }
    
    public void delete(PtOrderSendSetting ptOrderSendSetting) {
        ptOrderSendSettingRepository.delete(ptOrderSendSetting);
    }

    public void deleteByProductId(Long productId) {
        ptOrderSendSettingRepository.deleteByProductId(productId);
    }

}
