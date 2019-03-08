package com.tianyaleixiaolin.uplusserver.core.product.change;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 转单记录
 * @author wuwf
 */
@Service
public class PtChangeManager {
    @Resource
    private PtChangeRepository ptChangeRepository;


    /**
     * 查询某人所有接过的单
     */
    public List<PtChange> findAll(Long personId) {
        return ptChangeRepository.findByOldPersonIdOrNewPersonId(personId, personId);
    }

    public List<Long> findOrderIds(Long personId) {
        return findAll(personId).stream().map(PtChange::getOrderId).collect(Collectors.toList());
    }

    public Date findTime(Long id) {
        PtChange ptChange = ptChangeRepository.findFirstByNewPersonIdOrderByIdDesc(id);
        if (ptChange == null) {
            return null;
        }
        return ptChange.getCreateTime();
    }

    public PtChange add(PtChange ptChange) {
        return ptChangeRepository.save(ptChange);
    }
}
