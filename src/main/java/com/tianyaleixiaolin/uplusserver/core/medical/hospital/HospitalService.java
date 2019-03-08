package com.tianyaleixiaolin.uplusserver.core.medical.hospital;

import com.xiaoleilu.hutool.util.CollectionUtil;
import com.tianyaleixiaolin.uplusserver.global.bean.BaseData;
import com.tianyaleixiaolin.uplusserver.global.bean.ResultGenerator;
import com.tianyaleixiaolin.uplusserver.global.bean.SimplePage;
import com.tianyaleixiaolin.uplusserver.global.bean.request.HospitalListQueryModel;
import com.tianyaleixiaolin.uplusserver.global.specify.Criteria;
import com.tianyaleixiaolin.uplusserver.global.specify.Restrictions;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

@Component
public class HospitalService {
    @Resource
    private PtHospitalManager ptHospitalManager;

    public BaseData add(PtHospital ptHospital) {
        List<PtHospital> temp = ptHospitalManager.findByName(ptHospital.getName());
        if (CollectionUtil.isNotEmpty(temp)) {
            return ResultGenerator.genFailResult("已存在同名医院");
        }
        
        return ResultGenerator.genSuccessResult(ptHospitalManager.add(ptHospital));
    }

    public PtHospital update(PtHospital ptHospital) {
        return ptHospitalManager.update(ptHospital);
    }


    public PtHospital find(Long id) {
        return ptHospitalManager.find(id);
    }

    public void delete(Long id) {
        ptHospitalManager.delete(ptHospitalManager.find(id));
    }

    public SimplePage<PtHospital> find(HospitalListQueryModel hospitalListQueryModel) {
        Criteria<PtHospital> criteria1 = buildCriteria(hospitalListQueryModel);
        criteria1.add(Restrictions.like("name", hospitalListQueryModel.getName(), true));

        Criteria<PtHospital> criteria2 = buildCriteria(hospitalListQueryModel);
        criteria2.add(Restrictions.like("otherName", hospitalListQueryModel.getName(), true));

        Pageable pageable = PageRequest.of(hospitalListQueryModel.getPage(),
                hospitalListQueryModel.getSize(), Sort.Direction.DESC, "id");
        Page<PtHospital> page = ptHospitalManager.findAll(criteria1.or(criteria2), pageable);

        return new SimplePage<>(page.getTotalPages(), page.getTotalElements(), page.getContent());
    }

    private Criteria<PtHospital>  buildCriteria(HospitalListQueryModel hospitalListQueryModel) {
        Criteria<PtHospital> criteria = new Criteria<>();

        criteria.add(Restrictions.eq("level", hospitalListQueryModel.getLevel(), true));
        criteria.add(Restrictions.eq("province", hospitalListQueryModel.getProvince(), true));
        criteria.add(Restrictions.eq("city", hospitalListQueryModel.getCity(), true));
        criteria.add(Restrictions.eq("country", hospitalListQueryModel.getCountry(), true));
        criteria.add(Restrictions.eq("deleteFlag", false, true));

        return criteria;
    }

}
