package com.tianyaleixiaolin.uplusserver.core.medical.chinamed;

import com.xiaoleilu.hutool.util.BeanUtil;
import com.xiaoleilu.hutool.util.StrUtil;
import com.tianyaleixiaolin.uplusserver.core.medical.chinamed.child.PtChinaMedChild;
import com.tianyaleixiaolin.uplusserver.core.medical.chinamed.child.PtChinaMedChildManager;
import com.tianyaleixiaolin.uplusserver.global.bean.SimplePage;
import com.tianyaleixiaolin.uplusserver.global.bean.request.ChinaMedListQueryModel;
import com.tianyaleixiaolin.uplusserver.global.bean.response.ChinaMedListVO;
import com.tianyaleixiaolin.uplusserver.global.specify.Criteria;
import com.tianyaleixiaolin.uplusserver.global.specify.Restrictions;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ChinaMedService {
    @Resource
    private PtChinaMedManager ptChinaMedManager;
    @Resource
    private com.tianyaleixiaolin.uplusserver.core.medical.chinamed.child.ChinaMedChildService ChinaMedChildService;
    @Resource
    private PtChinaMedChildManager ptChinaMedChildManager;

    public PtChinaMed add(PtChinaMed ptChinaMed) {
        return ptChinaMedManager.add(ptChinaMed);
    }

    public PtChinaMed update(PtChinaMed ptChinaMed) {
        return ptChinaMedManager.update(ptChinaMed);
    }


    public PtChinaMed find(Long id) {
        return ptChinaMedManager.find(id);
    }

    /**
     * 下架医院
     */
    public void delete(Long id) {
        ptChinaMedManager.delete(ptChinaMedManager.find(id));
        //下架所有分院
        ChinaMedChildService.deleteByChinaMedId(id);
    }

    public SimplePage<ChinaMedListVO> find(ChinaMedListQueryModel ChinaMedListQueryModel) {
        Criteria<PtChinaMed> criteria = new Criteria<>();
        criteria.add(Restrictions.like("name", ChinaMedListQueryModel.getName(), true));
        if (StrUtil.isNotEmpty(ChinaMedListQueryModel.getChildName())) {
            List<PtChinaMedChild> children = ChinaMedChildService.findByNameLike(ChinaMedListQueryModel.getChildName());
            criteria.add(Restrictions.in("id",
                    children.stream().map(PtChinaMedChild::getChinaMedId).collect(Collectors.toSet()), false));
        }

        //criteria.add(Restrictions.eq("deleteFlag", false, true));

        Pageable pageable = PageRequest.of(ChinaMedListQueryModel.getPage(),
                ChinaMedListQueryModel.getSize(), Sort.Direction.DESC, "id");
        Page<PtChinaMed> page = ptChinaMedManager.findAll(criteria, pageable);

        return new SimplePage<>(page.getTotalPages(), page.getTotalElements(),
                page.getContent().stream().map(this::parse).collect(Collectors.toList()));
    }

    private ChinaMedListVO parse(PtChinaMed ptChinaMed) {
        ChinaMedListVO vo = new ChinaMedListVO();
        BeanUtil.copyProperties(ptChinaMed, vo);
        vo.setCount(ptChinaMedChildManager.countByChinaMedId(ptChinaMed.getId()));
        return vo;
    }
}
