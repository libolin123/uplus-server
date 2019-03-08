package com.tianyaleixiaolin.uplusserver.core.company.goods;

import com.tianyaleixiaolin.uplusserver.global.bean.BaseData;
import com.tianyaleixiaolin.uplusserver.global.bean.ResultGenerator;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author libolin wrote on 2018/11/16.
 */
@RestController
@RequestMapping("/goodsPlan")
public class GoodsPlanController {
    @Resource
    private GoodsPlanService goodsPlanService;

    @GetMapping("")
    public BaseData list(Long companyId) {
        return ResultGenerator.genSuccessResult(goodsPlanService.findByCompanyId(companyId));
    }

    @PostMapping("")
    public BaseData add(PtGoodsPlan ptGoodsPlan) {
        if (-1 == goodsPlanService.check(ptGoodsPlan.getCompanyId())) {
            return ResultGenerator.genFailResult("公司不存在");
        }
        return ResultGenerator.genSuccessResult(goodsPlanService.add(ptGoodsPlan));
    }

    @PutMapping("")
    public BaseData update(PtGoodsPlan ptGoodsPlan) {
        if (-1 == goodsPlanService.check(ptGoodsPlan.getCompanyId())) {
            return ResultGenerator.genFailResult("公司不存在");
        }
        return ResultGenerator.genSuccessResult(goodsPlanService.update(ptGoodsPlan));
    }

    @DeleteMapping("/{id}")
    public BaseData delete(@PathVariable Long id, Boolean upload) {
        goodsPlanService.delete(id, upload);
        return ResultGenerator.genSuccessResult();
    }
}
