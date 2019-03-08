package com.tianyaleixiaolin.uplusserver.core.medical.doctor;

import com.tianyaleixiaolin.uplusserver.global.bean.BaseData;
import com.tianyaleixiaolin.uplusserver.global.bean.ResultGenerator;
import com.tianyaleixiaolin.uplusserver.global.bean.request.DoctorListQueryModel;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author Mr.li wrote on 2018/11/12.
 */
@RestController
@RequestMapping("doctor")
public class DoctorController {
    @Resource
    private DoctorService doctorService;

    @GetMapping("")
    public BaseData list(DoctorListQueryModel doctorListQueryModel) {
        return ResultGenerator.genSuccessResult(doctorService.find(doctorListQueryModel));
    }

    @GetMapping("/{id}")
    public BaseData one(@PathVariable Long id) {
        return ResultGenerator.genSuccessResult(doctorService.find(id));
    }


    @PostMapping("")
    public BaseData add(PtDoctor ptDoctor) {
        return ResultGenerator.genSuccessResult(doctorService.add(ptDoctor));
    }

    @PutMapping("")
    public BaseData update(PtDoctor ptDoctor) {
        return ResultGenerator.genSuccessResult(doctorService.update(ptDoctor));
    }

    @DeleteMapping("/{id}")
    public BaseData delete(@PathVariable Long id) {
        doctorService.delete(id);
        return ResultGenerator.genSuccessResult("删除成功");
    }
}
