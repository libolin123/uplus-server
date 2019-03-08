package com.tianyaleixiaolin.uplusserver.core.medical.dentistry.child;

import com.xiaoleilu.hutool.util.BeanUtil;
import com.tianyaleixiaolin.uplusserver.core.dict.area.AreaManager;
import com.tianyaleixiaolin.uplusserver.global.bean.SimplePage;
import com.tianyaleixiaolin.uplusserver.global.bean.request.DentistryChildListQueryModel;
import com.tianyaleixiaolin.uplusserver.global.bean.response.DentistryChildVO;
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
public class DentistryChildService {
    @Resource
    private PtDentistryChildManager ptDentistryChildManager;
    @Resource
    private AreaManager areaManager;

    public PtDentistryChild add(PtDentistryChild ptDentistryChild) {
        return ptDentistryChildManager.add(ptDentistryChild);
    }

    public PtDentistryChild update(PtDentistryChild ptDentistryChild) {
        return ptDentistryChildManager.add(ptDentistryChild);
    }

    public PtDentistryChild find(Long id) {
        return ptDentistryChildManager.find(id);
    }

    public void delete(Long id) {
        ptDentistryChildManager.delete(ptDentistryChildManager.find(id));
    }

    /**
     * 总院被删，则删所有子院
     */
    public void deleteByDentistryId(Long DentistryId) {
        Criteria<PtDentistryChild> criteria = new Criteria<>();
        criteria.add(Restrictions.eq("dentistryId", DentistryId, true));
        criteria.add(Restrictions.eq("deleteFlag", false, true));
        List<PtDentistryChild> list = ptDentistryChildManager.findAll(criteria);
        for (PtDentistryChild ptDentistryChild : list) {
            delete(ptDentistryChild.getId());
        }
    }

    public List<PtDentistryChild> findByNameLike(String name) {
        Criteria<PtDentistryChild> criteria = new Criteria<>();
        criteria.add(Restrictions.like("name", name, true));
        criteria.add(Restrictions.eq("deleteFlag", false, true));
        return ptDentistryChildManager.findAll(criteria);
    }

    public SimplePage<DentistryChildVO> find(DentistryChildListQueryModel dentistryChildListQueryModel) {
        Criteria<PtDentistryChild> criteria = new Criteria<>();
        criteria.add(Restrictions.eq("dentistryId", dentistryChildListQueryModel.getDentistryId(), true));
        criteria.add(Restrictions.eq("province", dentistryChildListQueryModel.getProvince(), true));
        criteria.add(Restrictions.eq("city", dentistryChildListQueryModel.getCity(), true));
        criteria.add(Restrictions.eq("country", dentistryChildListQueryModel.getCountry(), true));
        criteria.add(Restrictions.like("name", dentistryChildListQueryModel.getName(), true));
        //criteria.add(Restrictions.eq("deleteFlag", false, true));

        Pageable pageable = PageRequest.of(dentistryChildListQueryModel.getPage(),
                dentistryChildListQueryModel.getSize(), Sort.Direction.DESC, "id");
        Page<PtDentistryChild> page = ptDentistryChildManager.findAll(criteria, pageable);

        return new SimplePage<>(page.getTotalPages(), page.getTotalElements(), page.getContent().stream()
        .map(this::parse).collect(Collectors.toList()));
    }

    private DentistryChildVO parse(PtDentistryChild ptDentistryChild) {
        DentistryChildVO dentistryChildVO = new DentistryChildVO();
        BeanUtil.copyProperties(ptDentistryChild, dentistryChildVO);
        dentistryChildVO.setProvinceValue(areaManager.findName(ptDentistryChild.getProvince()));
        dentistryChildVO.setCityValue(areaManager.findName(ptDentistryChild.getCity()));
        dentistryChildVO.setCountryValue(areaManager.findName(ptDentistryChild.getCountry()));
        return dentistryChildVO;
    }
}
