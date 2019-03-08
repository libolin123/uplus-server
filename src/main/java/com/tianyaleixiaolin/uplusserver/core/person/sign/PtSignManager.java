package com.tianyaleixiaolin.uplusserver.core.person.sign;

import com.tianyaleixiaolin.uplusserver.core.person.esign.ESignManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;

@Service
public class PtSignManager {
    @Resource
    private PtSignRepository ptSignRepository;
    @Resource
    private ESignManager eSignManager;

    private Logger logger = LoggerFactory.getLogger(getClass());


    public Page<PtSign> findAll(Specification<PtSign> var1, Pageable var2) {
        return ptSignRepository.findAll(var1, var2);
    }

    public PtSign findByGroundPersonId(Long personId) {
        return ptSignRepository.findFirstByGroundPersonId(personId);
    }

    public Boolean hasSign(Long personId) {
        PtSign ptSign = findByGroundPersonId(personId);
        logger.info("ptSign为" + ptSign);
        if (ptSign == null) {
            return false;
        } else {
           if (!StringUtils.isEmpty(ptSign.getDocUrl())) {
               return true;
           } else {
               boolean state = eSignManager.signState(ptSign.getFlowId());
               if (state) {
                   ptSign.setDocUrl("ready, wait download");
                   update(ptSign);
                   return true;
               } else {
                   return false;
               }
           }
        }

    }

    public PtSign find(Long id) {
        return ptSignRepository.getOne(id);
    }

    public PtSign add(PtSign ptSign) {
        return save(ptSign);
    }

    public PtSign update(PtSign ptSign) {
        return save(ptSign);
    }

    public void delete(PtSign ptSign) {
        ptSign.setDeleteFlag(true);
        update(ptSign);
    }

    private PtSign save(PtSign ptSign) {
        return ptSignRepository.save(ptSign);
    }
}
