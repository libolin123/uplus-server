package com.tianyaleixiaolin.uplusserver.core.person;

import com.tianyaleixiaolin.uplusserver.global.bean.BaseData;
import com.tianyaleixiaolin.uplusserver.global.bean.ResultGenerator;
import com.tianyaleixiaolin.uplusserver.global.bean.request.GroundPersonListQueryModel;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 外派人员
 * @author Mr.li wrote on 2018/11/12.
 */
@RestController
@RequestMapping("groundPerson")
public class GroundPersonController {
    @Resource
    private GroundPersonService groundPersonService;

    @GetMapping("")
    public BaseData list(GroundPersonListQueryModel groundPersonListQueryModel) {
        return ResultGenerator.genSuccessResult(groundPersonService.find(groundPersonListQueryModel));
    }

    @GetMapping("/{id}")
    public BaseData one(@PathVariable Long id) {
        return ResultGenerator.genSuccessResult(groundPersonService.findDetail(id));
    }

    @PostMapping("")
    public BaseData add(PtGroundPerson ptGroundPerson) {
        return groundPersonService.add(ptGroundPerson);
    }

    @PutMapping("")
    public BaseData update(PtGroundPerson ptGroundPerson) {
        return ResultGenerator.genSuccessResult(groundPersonService.update(ptGroundPerson));
    }

    @DeleteMapping("/{id}")
    public BaseData delete(@PathVariable Long id) {
        groundPersonService.delete(id);
        return ResultGenerator.genSuccessResult("删除成功");
    }
}
