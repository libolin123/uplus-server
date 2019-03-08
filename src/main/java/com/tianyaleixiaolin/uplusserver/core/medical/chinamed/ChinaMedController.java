package com.tianyaleixiaolin.uplusserver.core.medical.chinamed;

import com.tianyaleixiaolin.uplusserver.global.bean.BaseData;
import com.tianyaleixiaolin.uplusserver.global.bean.ResultGenerator;
import com.tianyaleixiaolin.uplusserver.global.bean.request.ChinaMedListQueryModel;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;

/**
 * 分院管理
 * @author Mr.li wrote on 2018/11/12.
 */
@RestController
@RequestMapping("chinaMed")
public class ChinaMedController {
    @Resource
    private ChinaMedService chinaMedService;

    @GetMapping("")
    public BaseData list(ChinaMedListQueryModel chinaMedListQueryModel) {
        return ResultGenerator.genSuccessResult(chinaMedService.find(chinaMedListQueryModel));
    }

    @GetMapping("/{id}")
    public BaseData one(@PathVariable Long id) {
        return ResultGenerator.genSuccessResult(chinaMedService.find(id));
    }

    @PostMapping("")
    public BaseData add(@Valid PtChinaMed ptChinaMed, BindingResult bindingResult) {
        return ResultGenerator.genSuccessResult(chinaMedService.add(ptChinaMed));
    }

    @PutMapping("")
    public BaseData update(@Valid PtChinaMed ptChinaMed, BindingResult bindingResult) {
        return ResultGenerator.genSuccessResult(chinaMedService.update(ptChinaMed));
    }

    @DeleteMapping("/{id}")
    public BaseData delete(@PathVariable Long id) {
        chinaMedService.delete(id);
        return ResultGenerator.genSuccessResult("删除成功");
    }
}
