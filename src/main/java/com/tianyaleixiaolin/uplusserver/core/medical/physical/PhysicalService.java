package com.tianyaleixiaolin.uplusserver.core.medical.physical;

import com.xiaoleilu.hutool.util.BeanUtil;
import com.xiaoleilu.hutool.util.StrUtil;
import com.tianyaleixiaolin.uplusserver.core.medical.physical.child.PhysicalChildService;
import com.tianyaleixiaolin.uplusserver.core.medical.physical.child.PtPhysicalChild;
import com.tianyaleixiaolin.uplusserver.core.medical.physical.child.PtPhysicalChildManager;
import com.tianyaleixiaolin.uplusserver.global.bean.SimplePage;
import com.tianyaleixiaolin.uplusserver.global.bean.request.PhysicalListQueryModel;
import com.tianyaleixiaolin.uplusserver.global.bean.response.PhysicalListVO;
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
public class PhysicalService {
    @Resource
    private PtPhysicalManager ptPhysicalManager;
    @Resource
    private PhysicalChildService physicalChildService;
    @Resource
    private PtPhysicalChildManager ptPhysicalChildManager;

    public PtPhysical add(PtPhysical ptPhysical) {
        return ptPhysicalManager.add(ptPhysical);
    }

    public PtPhysical update(PtPhysical ptPhysical) {
        return ptPhysicalManager.update(ptPhysical);
    }


    public PtPhysical find(Long id) {
        return ptPhysicalManager.find(id);
    }

    /**
     * 下架医院
     */
    public void delete(Long id) {
        ptPhysicalManager.delete(ptPhysicalManager.find(id));
        //下架所有分院
        physicalChildService.deleteByPhysicalId(id);
    }

    public SimplePage<PhysicalListVO> find(PhysicalListQueryModel physicalListQueryModel) {
        Criteria<PtPhysical> criteria = new Criteria<>();
        criteria.add(Restrictions.like("name", physicalListQueryModel.getName(), true));
        if (StrUtil.isNotEmpty(physicalListQueryModel.getChildName())) {
            List<PtPhysicalChild> children = physicalChildService.findByNameLike(physicalListQueryModel.getChildName());
            criteria.add(Restrictions.in("id",
                    children.stream().map(PtPhysicalChild::getPhysicalId).collect(Collectors.toSet()), false));
        }

        //criteria.add(Restrictions.eq("deleteFlag", false, true));

        Pageable pageable = PageRequest.of(physicalListQueryModel.getPage(),
                physicalListQueryModel.getSize(), Sort.Direction.DESC, "id");
        Page<PtPhysical> page = ptPhysicalManager.findAll(criteria, pageable);

        return new SimplePage<>(page.getTotalPages(), page.getTotalElements(),
                page.getContent().stream().map(this::parse).collect(Collectors.toList()));
    }

    private PhysicalListVO parse(PtPhysical ptPhysical) {
        PhysicalListVO vo = new PhysicalListVO();
        BeanUtil.copyProperties(ptPhysical, vo);
        vo.setCount(ptPhysicalChildManager.countByPhysicalId(ptPhysical.getId()));
        return vo;
    }
}
