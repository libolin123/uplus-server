package com.tianyaleixiaolin.uplusserver.core.medical.dentistry.child;

import com.tianyaleixiaolin.uplusserver.global.bean.BaseData;
import com.tianyaleixiaolin.uplusserver.global.bean.ResultGenerator;
import com.tianyaleixiaolin.uplusserver.global.bean.request.DentistryChildListQueryModel;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;

/**
 * 分院管理
 * @author Mr.li wrote on 2018/11/12.
 */
@RestController
@RequestMapping("dentistryChild")
public class DentistryChildController {
    @Resource
    private DentistryChildService dentistryChildService;

    @GetMapping("")
    public BaseData list(DentistryChildListQueryModel dentistryChildListQueryModel) {
        return ResultGenerator.genSuccessResult(dentistryChildService.find(dentistryChildListQueryModel));
    }

    @GetMapping("/{id}")
    public BaseData one(@PathVariable Long id) {
        return ResultGenerator.genSuccessResult(dentistryChildService.find(id));
    }

    @PostMapping("")
    public BaseData add(@Valid PtDentistryChild ptDentistryChild, BindingResult bindingResult) {
        return ResultGenerator.genSuccessResult(dentistryChildService.add(ptDentistryChild));
    }

    @PutMapping("")
    public BaseData update(@Valid PtDentistryChild ptDentistryChild, BindingResult bindingResult) {
        return ResultGenerator.genSuccessResult(dentistryChildService.update(ptDentistryChild));
    }

    @DeleteMapping("/{id}")
    public BaseData delete(@PathVariable Long id) {
        dentistryChildService.delete(id);
        return ResultGenerator.genSuccessResult("删除成功");
    }
}
