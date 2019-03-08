package com.tianyaleixiaolin.uplusserver.core.product.template.prepay;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author wuwf
 */
@Service
public class PtPrePayTemplateManager {
    @Resource
    private PtPrePayTemplateRepository ptPrePayTemplateRepository;

    public PtPrePayTemplate add(PtPrePayTemplate ptPrePayTemplate) {
        return save(ptPrePayTemplate);
    }

    public PtPrePayTemplate update(PtPrePayTemplate ptPrePayTemplate) {
        return save(ptPrePayTemplate);
    }

    public PtPrePayTemplate find(Long id) {
        return ptPrePayTemplateRepository.getOne(id);
    }


    private PtPrePayTemplate save(PtPrePayTemplate ptPrePayTemplate) {
        return ptPrePayTemplateRepository.save(ptPrePayTemplate);
    }
    
    public void delete(PtPrePayTemplate ptPrePayTemplate) {
        ptPrePayTemplateRepository.delete(ptPrePayTemplate);
    }

}
