package com.tianyaleixiaolin.uplusserver.core.product.define;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author wuwf
 */
@Service
public class PtProductDefineSettingManager {
    @Resource
    private PtProductDefineSettingRepository ptProductDefineSettingRepository;

    public PtProductDefineSetting findByProductId(Long id) {
        return ptProductDefineSettingRepository.findFirstByProductId(id);
    }

    public PtProductDefineSetting add(PtProductDefineSetting ptProductDefineSetting) {
        return save(ptProductDefineSetting);
    }

    public PtProductDefineSetting update(PtProductDefineSetting ptProductDefineSetting) {
        return save(ptProductDefineSetting);
    }

    private PtProductDefineSetting save(PtProductDefineSetting ptProductDefineSetting) {
        return ptProductDefineSettingRepository.save(ptProductDefineSetting);
    }

    public void delete(PtProductDefineSetting ptProductDefineSetting) {
        ptProductDefineSettingRepository.delete(ptProductDefineSetting);
    }

}
