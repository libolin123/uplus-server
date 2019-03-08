package com.tianyaleixiaolin.uplusserver.core.medical.dentistry;

import com.xiaoleilu.hutool.util.BeanUtil;
import com.xiaoleilu.hutool.util.StrUtil;
import com.tianyaleixiaolin.uplusserver.core.medical.dentistry.child.PtDentistryChild;
import com.tianyaleixiaolin.uplusserver.core.medical.dentistry.child.PtDentistryChildManager;
import com.tianyaleixiaolin.uplusserver.global.bean.SimplePage;
import com.tianyaleixiaolin.uplusserver.global.bean.request.DentistryListQueryModel;
import com.tianyaleixiaolin.uplusserver.global.bean.response.DentistryListVO;
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
public class DentistryService {
    @Resource
    private PtDentistryManager ptDentistryManager;
    @Resource
    private com.tianyaleixiaolin.uplusserver.core.medical.dentistry.child.DentistryChildService DentistryChildService;
    @Resource
    private PtDentistryChildManager ptDentistryChildManager;

    public PtDentistry add(PtDentistry ptDentistry) {
        return ptDentistryManager.add(ptDentistry);
    }

    public PtDentistry update(PtDentistry ptDentistry) {
        return ptDentistryManager.update(ptDentistry);
    }


    public PtDentistry find(Long id) {
        return ptDentistryManager.find(id);
    }

    /**
     * 下架医院
     */
    public void delete(Long id) {
        ptDentistryManager.delete(ptDentistryManager.find(id));
        //下架所有分院
        DentistryChildService.deleteByDentistryId(id);
    }

    public SimplePage<DentistryListVO> find(DentistryListQueryModel dentistryListQueryModel) {
        Criteria<PtDentistry> criteria = new Criteria<>();
        criteria.add(Restrictions.like("name", dentistryListQueryModel.getName(), true));
        if (StrUtil.isNotEmpty(dentistryListQueryModel.getChildName())) {
            List<PtDentistryChild> children = DentistryChildService.findByNameLike(dentistryListQueryModel.getChildName());
            criteria.add(Restrictions.in("id",
                    children.stream().map(PtDentistryChild::getDentistryId).collect(Collectors.toSet()), false));
        }

        //criteria.add(Restrictions.eq("deleteFlag", false, true));

        Pageable pageable = PageRequest.of(dentistryListQueryModel.getPage(),
                dentistryListQueryModel.getSize(), Sort.Direction.DESC, "id");
        Page<PtDentistry> page = ptDentistryManager.findAll(criteria, pageable);

        return new SimplePage<>(page.getTotalPages(), page.getTotalElements(),
                page.getContent().stream().map(this::parse).collect(Collectors.toList()));
    }

    private DentistryListVO parse(PtDentistry ptDentistry) {
        DentistryListVO vo = new DentistryListVO();
        BeanUtil.copyProperties(ptDentistry, vo);
        vo.setCount(ptDentistryChildManager.countByDentistryId(ptDentistry.getId()));
        return vo;
    }
}
