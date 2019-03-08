package com.tianyaleixiaolin.uplusserver.core.product.flow.setting;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author wuwf
 */
@Service
public class PtOrderFlowSettingManager {
    @Resource
    private PtOrderFlowSettingRepository ptOrderFlowSettingRepository;

    public List<PtOrderFlowSetting> findByProductId(Long productId) {
        return ptOrderFlowSettingRepository.findByProductIdOrderBySort(productId);
    }

    public PtOrderFlowSetting add(PtOrderFlowSetting ptOrderFlowSetting) {
        return save(ptOrderFlowSetting);
    }

    public PtOrderFlowSetting update(PtOrderFlowSetting ptOrderFlowSetting) {
        return save(ptOrderFlowSetting);
    }

    public PtOrderFlowSetting find(Long id) {
        return ptOrderFlowSettingRepository.getOne(id);
    }

    private PtOrderFlowSetting save(PtOrderFlowSetting ptOrderFlowSetting) {
        return ptOrderFlowSettingRepository.save(ptOrderFlowSetting);
    }
    
    public void delete(PtOrderFlowSetting ptOrderFlowSetting) {
        ptOrderFlowSettingRepository.delete(ptOrderFlowSetting);
    }

}
