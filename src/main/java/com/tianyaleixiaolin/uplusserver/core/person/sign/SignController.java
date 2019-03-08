package com.tianyaleixiaolin.uplusserver.core.person.sign;

import com.tianyaleixiaolin.uplusserver.global.bean.BaseData;
import com.tianyaleixiaolin.uplusserver.global.bean.ResultGenerator;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 外派人员查询签约
 * @author Mr.li wrote on 2018/11/12.
 */
@RestController
@RequestMapping("sign")
public class SignController {
    @Resource
    private PtSignManager ptSignManager;
    @Resource
    private SignService signService;

    @GetMapping("")
    public BaseData list(Long groundPersonId) {
        return ResultGenerator.genSuccessResult(ptSignManager.hasSign(groundPersonId));
    }

    /**
     * 开始签约
     */
    @GetMapping("beginSign")
    public BaseData beginSign(Long groundPersonId) {
        return signService.findSignPath(groundPersonId);
    }

    /**
     * 查询签约结果
     */
    @GetMapping("checkSign")
    public BaseData checkSign(Long groundPersonId) {
        return signService.checkSign(groundPersonId);
    }

    /**
     * 合同下载地址
     */
    @GetMapping("downloadSign")
    public BaseData down(Long groundPersonId) {
        return signService.findDownLoadPath(groundPersonId);
    }

    @GetMapping("/{id}")
    public BaseData one(@PathVariable Long id) {
        return ResultGenerator.genSuccessResult(ptSignManager.find(id));
    }

    @PostMapping("")
    public BaseData add(PtSign ptSign) {
        return ResultGenerator.genSuccessResult(ptSignManager.add(ptSign));
    }

    @PutMapping("")
    public BaseData update(PtSign ptSign) {
        return ResultGenerator.genSuccessResult(ptSignManager.update(ptSign));
    }

    @DeleteMapping("/{id}")
    public BaseData delete(@PathVariable Long id) {
        ptSignManager.delete(ptSignManager.find(id));
        return ResultGenerator.genSuccessResult("删除成功");
    }
}
