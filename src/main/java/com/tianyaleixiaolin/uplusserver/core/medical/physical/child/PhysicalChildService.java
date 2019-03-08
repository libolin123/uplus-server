package com.tianyaleixiaolin.uplusserver.core.medical.physical.child;

import com.xiaoleilu.hutool.util.BeanUtil;
import com.tianyaleixiaolin.uplusserver.core.dict.area.AreaManager;
import com.tianyaleixiaolin.uplusserver.global.bean.SimplePage;
import com.tianyaleixiaolin.uplusserver.global.bean.request.PhysicalChildListQueryModel;
import com.tianyaleixiaolin.uplusserver.global.bean.response.PhysicalChildVO;
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
public class PhysicalChildService {
    @Resource
    private PtPhysicalChildManager ptPhysicalChildManager;
    @Resource
    private AreaManager areaManager;

    public PtPhysicalChild add(PtPhysicalChild ptPhysicalChild) {
        return ptPhysicalChildManager.add(ptPhysicalChild);
    }

    public PtPhysicalChild update(PtPhysicalChild ptPhysicalChild) {
        return ptPhysicalChildManager.add(ptPhysicalChild);
    }

    public PtPhysicalChild find(Long id) {
        return ptPhysicalChildManager.find(id);
    }

    public void delete(Long id) {
        ptPhysicalChildManager.delete(ptPhysicalChildManager.find(id));
    }

    /**
     * 总院被删，则删所有子院
     */
    public void deleteByPhysicalId(Long physicalId) {
        Criteria<PtPhysicalChild> criteria = new Criteria<>();
        criteria.add(Restrictions.eq("physicalId", physicalId, true));
        criteria.add(Restrictions.eq("deleteFlag", false, true));
        List<PtPhysicalChild> list = ptPhysicalChildManager.findAll(criteria);
        for (PtPhysicalChild ptPhysicalChild : list) {
            delete(ptPhysicalChild.getId());
        }
    }

    public List<PtPhysicalChild> findByNameLike(String name) {
        Criteria<PtPhysicalChild> criteria = new Criteria<>();
        criteria.add(Restrictions.like("name", name, true));
        criteria.add(Restrictions.eq("deleteFlag", false, true));
        return ptPhysicalChildManager.findAll(criteria);
    }

    public SimplePage<PhysicalChildVO> find(PhysicalChildListQueryModel physicalChildListQueryModel) {
        Criteria<PtPhysicalChild> criteria = new Criteria<>();
        criteria.add(Restrictions.eq("physicalId", physicalChildListQueryModel.getPhysicalId(), true));
        criteria.add(Restrictions.eq("province", physicalChildListQueryModel.getProvince(), true));
        criteria.add(Restrictions.eq("city", physicalChildListQueryModel.getCity(), true));
        criteria.add(Restrictions.eq("country", physicalChildListQueryModel.getCountry(), true));
        criteria.add(Restrictions.like("name", physicalChildListQueryModel.getName(), true));
        //criteria.add(Restrictions.eq("deleteFlag", false, true));

        Pageable pageable = PageRequest.of(physicalChildListQueryModel.getPage(),
                physicalChildListQueryModel.getSize(), Sort.Direction.DESC, "id");
        Page<PtPhysicalChild> page = ptPhysicalChildManager.findAll(criteria, pageable);

        return new SimplePage<>(page.getTotalPages(), page.getTotalElements(), page.getContent().stream()
        .map(this::parse).collect(Collectors.toList()));
    }

    private PhysicalChildVO parse(PtPhysicalChild ptPhysicalChild) {
        PhysicalChildVO physicalChildVO = new PhysicalChildVO();
        BeanUtil.copyProperties(ptPhysicalChild, physicalChildVO);
        physicalChildVO.setProvinceValue(areaManager.findName(ptPhysicalChild.getProvince()));
        physicalChildVO.setCityValue(areaManager.findName(ptPhysicalChild.getCity()));
        physicalChildVO.setCountryValue(areaManager.findName(ptPhysicalChild.getCountry()));
        return physicalChildVO;
    }

}
