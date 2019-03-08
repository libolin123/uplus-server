package com.tianyaleixiaolin.uplusserver.core.company.goods;

import com.xiaoleilu.hutool.util.BeanUtil;
import com.tianyaleixiaolin.uplusserver.core.company.company.PtCompanyManager;
import com.tianyaleixiaolin.uplusserver.global.bean.response.GoodsPlanVO;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 商品计划
 *
 * @author libolin wrote on 2018/11/16.
 */
@Component
@Transactional(rollbackFor = Exception.class)
public class GoodsPlanService {
    @Resource
    private PtGoodsPlanManager ptGoodsPlanManager;
    @Resource
    private PtGoodsManager ptGoodsManager;
    @Resource
    private GoodsService goodsService;
    @Resource
    private PtCompanyManager ptCompanyManager;

    public List<GoodsPlanVO> findByCompanyId(Long companyId) {
        List<PtGoodsPlan> goodsPlans = ptGoodsPlanManager.findByCompanyId(companyId);
        return goodsPlans.stream().map(this::parse).collect(Collectors.toList());
    }

    private GoodsPlanVO parse(PtGoodsPlan goodsPlan) {
        GoodsPlanVO vo = new GoodsPlanVO();
        BeanUtil.copyProperties(goodsPlan, vo);
        vo.setGoodsName(ptGoodsManager.findNameByPlanId(goodsPlan.getId()));
        return vo;
    }

    public PtGoodsPlan add(PtGoodsPlan ptGoodsPlan) {
        return ptGoodsPlanManager.add(ptGoodsPlan);
    }

    public int check(Long companyId) {
        if (!ptCompanyManager.exist(companyId)) {
            return -1;
        }
        return 0;
    }

    /**
     * 更新plan
     */
    public PtGoodsPlan update(PtGoodsPlan ptGoodsPlan) {
        return ptGoodsPlanManager.update(ptGoodsPlan);
    }

    public void delete(Long id, Boolean upload) {
        PtGoodsPlan goodsPlan = ptGoodsPlanManager.findOne(id);
        if (upload == null) {
            upload = false;
        }
        goodsPlan.setDeleteFlag(upload);
        ptGoodsPlanManager.update(goodsPlan);

        goodsService.deleteTempByPlanId(goodsPlan.getId(), upload);
    }
}
