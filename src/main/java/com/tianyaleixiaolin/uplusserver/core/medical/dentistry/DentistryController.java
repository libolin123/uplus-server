package com.tianyaleixiaolin.uplusserver.core.medical.dentistry;

import com.tianyaleixiaolin.uplusserver.global.bean.BaseData;
import com.tianyaleixiaolin.uplusserver.global.bean.ResultGenerator;
import com.tianyaleixiaolin.uplusserver.global.bean.request.DentistryListQueryModel;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;

/**
 * 分院管理
 * @author Mr.li wrote on 2018/11/12.
 */
@RestController
@RequestMapping("dentistry")
public class DentistryController {
    @Resource
    private DentistryService dentistryService;

    @GetMapping("")
    public BaseData list(DentistryListQueryModel dentistryListQueryModel) {
        return ResultGenerator.genSuccessResult(dentistryService.find(dentistryListQueryModel));
    }

    @GetMapping("/{id}")
    public BaseData one(@PathVariable Long id) {
        return ResultGenerator.genSuccessResult(dentistryService.find(id));
    }

    @PostMapping("")
    public BaseData add(@Valid PtDentistry ptDentistry, BindingResult bindingResult) {
        return ResultGenerator.genSuccessResult(dentistryService.add(ptDentistry));
    }

    @PutMapping("")
    public BaseData update(@Valid PtDentistry ptDentistry, BindingResult bindingResult) {
        return ResultGenerator.genSuccessResult(dentistryService.update(ptDentistry));
    }

    @DeleteMapping("/{id}")
    public BaseData delete(@PathVariable Long id) {
        dentistryService.delete(id);
        return ResultGenerator.genSuccessResult("删除成功");
    }
}
