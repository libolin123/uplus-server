package com.tianyaleixiaolin.uplusserver.core.company.goods;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 商品计划
 *
 * @author libolin wrote on 2018/11/16.
 */
@Service
public class PtGoodsPlanManager {
    @Resource
    private PtGoodsPlanRepository ptGoodsPlanRepository;

    public List<PtGoodsPlan> findByCompanyId(Long companyId) {
        return ptGoodsPlanRepository.findByCompanyId(companyId);
    }

    public String findNameById(Long id) {
        if (id == null || findOne(id) == null) {
            return "无";
        }
        return findOne(id).getName();
    }

    public PtGoodsPlan findOne(Long id) {
        return ptGoodsPlanRepository.getOne(id);
    }

    public PtGoodsPlan add(PtGoodsPlan ptGoodsPlan) {
        return save(ptGoodsPlan);
    }

    public PtGoodsPlan update(PtGoodsPlan ptGoodsPlan) {
        return save(ptGoodsPlan);
    }

    private PtGoodsPlan save(PtGoodsPlan ptGoodsPlan) {
        return ptGoodsPlanRepository.save(ptGoodsPlan);
    }
}
