package com.tianyaleixiaolin.uplusserver.core.dict.area;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Mr.li wrote on 2018/11/15.
 */
@Service
public class AreaManager {
    @Resource
    private AreaRepository areaRepository;

    public List<AreaEntity> findByParentId(Long parentId) {
        if (parentId == null || parentId <= 0) {
            parentId = -1L;
        }
        return areaRepository.findByParentId(parentId);
    }

    public AreaEntity findByAreaCode(String areaCode) {
        return areaRepository.findByAreaCode(areaCode);
    }

    public AreaEntity add(AreaEntity areaEntity) {
        return areaRepository.save(areaEntity);
    }

    public AreaEntity update(AreaEntity areaEntity) {
        return areaRepository.save(areaEntity);
    }

    public void delete(Long id) {
        areaRepository.deleteById(id);
    }

    public String findName(String areaCode) {
        if (areaCode == null) {
            return "";
        }
        AreaEntity areaEntity = areaRepository.findByAreaCode(areaCode);
        if (areaEntity == null) {
            return "";
        }
        return areaEntity.getAreaName();
    }

    /**
     * 查询完整地址
     * @param areaCode areaCode
     * @return 河南-漯河-源汇
     */
    public String findFull(String areaCode) {
        if (areaCode == null) {
            return "";
        }
        AreaEntity areaEntity = areaRepository.findByAreaCode(areaCode);
        //区
        String qu = areaEntity.getAreaName();
        AreaEntity city = areaRepository.getOne(areaEntity.getId());
        //市
        String shi = city.getAreaName();
        AreaEntity province = areaRepository.getOne(city.getParentId());
        String sheng = province.getAreaName();
        return sheng + "-" + shi + "-" + qu;
    }
}
