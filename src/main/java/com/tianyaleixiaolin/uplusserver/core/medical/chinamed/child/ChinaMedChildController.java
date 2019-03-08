package com.tianyaleixiaolin.uplusserver.core.medical.chinamed.child;

import com.tianyaleixiaolin.uplusserver.global.bean.BaseData;
import com.tianyaleixiaolin.uplusserver.global.bean.ResultGenerator;
import com.tianyaleixiaolin.uplusserver.global.bean.request.ChinaMedChildListQueryModel;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;

/**
 * 分院管理
 * @author Mr.li wrote on 2018/11/12.
 */
@RestController
@RequestMapping("chinaMedChild")
public class ChinaMedChildController {
    @Resource
    private ChinaMedChildService chinaMedChildService;

    @GetMapping("")
    public BaseData list(ChinaMedChildListQueryModel chinaMedChildListQueryModel) {
        return ResultGenerator.genSuccessResult(chinaMedChildService.find(chinaMedChildListQueryModel));
    }

    @GetMapping("/{id}")
    public BaseData one(@PathVariable Long id) {
        return ResultGenerator.genSuccessResult(chinaMedChildService.find(id));
    }

    @PostMapping("")
    public BaseData add(@Valid PtChinaMedChild ptChinaMedChild, BindingResult bindingResult) {
        return ResultGenerator.genSuccessResult(chinaMedChildService.add(ptChinaMedChild));
    }

    @PutMapping("")
    public BaseData update(@Valid PtChinaMedChild ptChinaMedChild, BindingResult bindingResult) {
        return ResultGenerator.genSuccessResult(chinaMedChildService.update(ptChinaMedChild));
    }

    @DeleteMapping("/{id}")
    public BaseData delete(@PathVariable Long id) {
        chinaMedChildService.delete(id);
        return ResultGenerator.genSuccessResult("删除成功");
    }
}
