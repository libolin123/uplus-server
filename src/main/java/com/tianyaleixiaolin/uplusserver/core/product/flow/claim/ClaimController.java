package com.tianyaleixiaolin.uplusserver.core.product.flow.claim;

import com.tianyaleixiaolin.uplusserver.global.bean.BaseData;
import com.tianyaleixiaolin.uplusserver.global.bean.ResultGenerator;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 理赔单
 * @author Mr.li wrote on 2018/12/13.
 */
@RestController
@RequestMapping("claim")
public class ClaimController {
    @Resource
    private PtClaimManager ptClaimManager;

    @GetMapping("")
    public BaseData list(Long productOrderId) {
        return ResultGenerator.genSuccessResult(ptClaimManager.findByProductOrderId(productOrderId));
    }

    @PostMapping("")
    public BaseData add(PtClaim ptClaim) {
        return ResultGenerator.genSuccessResult(ptClaimManager.add(ptClaim));
    }

    @PutMapping("")
    public BaseData update(PtClaim ptClaim) {
        return ResultGenerator.genSuccessResult(ptClaimManager.update(ptClaim));
    }

    @DeleteMapping("/{id}")
    public BaseData delete(@PathVariable Long id) {
        ptClaimManager.delete(ptClaimManager.find(id));
        return ResultGenerator.genSuccessResult("删除成功");
    }
}
