package com.tianyaleixiaolin.uplusserver.core.company.company;

import com.tianyaleixiaolin.uplusserver.global.bean.BaseData;
import com.tianyaleixiaolin.uplusserver.global.bean.ResultGenerator;
import com.tianyaleixiaolin.uplusserver.global.bean.request.CompanyListQueryModel;
import com.tianyaleixiaolin.uplusserver.global.bean.request.CompanyTempListQueryModel;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author libolin wrote on 2018/11/12.
 */
@RestController
@RequestMapping("company")
public class CompanyController {
    @Resource
    private CompanyService companyService;

    @GetMapping("")
    public BaseData list(CompanyListQueryModel companyListQueryModel) {
        return ResultGenerator.genSuccessResult(companyService.find(companyListQueryModel));
    }

    @GetMapping("/tempList")
    public BaseData confirm(CompanyTempListQueryModel companyTempListQueryModel) {
        return ResultGenerator.genSuccessResult(companyService.find(companyTempListQueryModel));
    }

    @GetMapping("/{id}")
    public BaseData one(@PathVariable Long id) {
        return ResultGenerator.genSuccessResult(companyService.findOne(id));
    }

    @GetMapping("/{id}/detail")
    public BaseData detail(@PathVariable Long id) {
        return ResultGenerator.genSuccessResult(companyService.findDetail(id));
    }

    @PostMapping("/{id}/detail/confirm")
    public BaseData confirm(@PathVariable Long id, Boolean confirm) {
        companyService.confirm(id, confirm);
        return ResultGenerator.genSuccessResult("操作成功");
    }

    @PostMapping("")
    public BaseData add(PtCompany ptCompany) {
        return ResultGenerator.genSuccessResult(companyService.add(ptCompany));
    }

    @PutMapping("")
    public BaseData update(PtCompany ptCompany, String reason) {
        return ResultGenerator.genSuccessResult(companyService.update(ptCompany, reason));
    }
}
