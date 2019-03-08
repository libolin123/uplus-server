package com.tianyaleixiaolin.uplusserver.core.dict;

import com.tianyaleixiaolin.uplusserver.global.bean.BaseData;
import com.tianyaleixiaolin.uplusserver.global.bean.ResultGenerator;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author Mr.li wrote on 2018/11/14.
 */
@RestController
@RequestMapping("dict")
public class DictController {
    @Resource
    private PtDictManager ptDictManager;

    @GetMapping("")
    public BaseData query(Integer groupId, String parentKey) {
        if (groupId == null) {
            return ResultGenerator.genSuccessResult(ptDictManager.findAll());
        }
        if (parentKey != null) {
            return ResultGenerator.genSuccessResult(ptDictManager.findByGroupIdAndParentKey(groupId, parentKey));
        }
        return ResultGenerator.genSuccessResult(ptDictManager.findByGroupId(groupId));
    }


    @PostMapping("")
    public BaseData add(PtDict ptDict) {
        return ResultGenerator.genSuccessResult(ptDictManager.add(ptDict));
    }

    @PutMapping("")
    public BaseData update(PtDict ptDict) {
        return ResultGenerator.genSuccessResult(ptDictManager.update(ptDict));
    }

    @DeleteMapping("/{id}")
    public BaseData delete(@PathVariable Long id) {
        ptDictManager.delete(ptDictManager.find(id));
        return ResultGenerator.genSuccessResult("删除成功");
    }
}
