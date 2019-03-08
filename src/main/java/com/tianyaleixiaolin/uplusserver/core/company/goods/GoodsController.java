package com.tianyaleixiaolin.uplusserver.core.company.goods;

import com.tianyaleixiaolin.uplusserver.global.bean.BaseData;
import com.tianyaleixiaolin.uplusserver.global.bean.ResultGenerator;
import com.tianyaleixiaolin.uplusserver.global.bean.request.GoodsAddUpdateModel;
import com.tianyaleixiaolin.uplusserver.global.bean.request.GoodsTempListQueryModel;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author libolin wrote on 2018/11/16.
 */
@RestController
@RequestMapping("/goods")
public class GoodsController {
    @Resource
    private GoodsService goodsService;

    @GetMapping("")
    public BaseData list(Long companyId, @PageableDefault(sort = "id", direction = Sort.Direction.DESC) Pageable
            pageable) {
        return ResultGenerator.genSuccessResult(goodsService.findByCompanyId(companyId, pageable));
    }

    @GetMapping("/tempList")
    public BaseData confirm(GoodsTempListQueryModel goodsTempListQueryModel) {
        return ResultGenerator.genSuccessResult(goodsService.find(goodsTempListQueryModel));
    }

    @GetMapping("/{id}")
    public BaseData one(@PathVariable Long id) {
        return ResultGenerator.genSuccessResult(goodsService.findOne(id));
    }

    /**
     * 包含被修改的详情
     */
    @GetMapping("/{id}/detail")
    public BaseData detail(@PathVariable Long id) {
        return ResultGenerator.genSuccessResult(goodsService.findDetail(id));
    }

    /**
     * 押金垫付查询
     */
    @GetMapping("/cashPrePay/{id}")
    public BaseData cashPrePay(@PathVariable Long id) {
        return ResultGenerator.genSuccessResult(goodsService.findByCashPrePayId(id));
    }

    /**
     * 电话医生查询
     */
    @GetMapping("/phoneDoctor/{id}")
    public BaseData phoneDoctor(@PathVariable Long id) {
        return ResultGenerator.genSuccessResult(goodsService.findByPhoneDoctorId(id));
    }

    @PostMapping("/{id}/detail/confirm")
    public BaseData confirm(@PathVariable Long id, Boolean confirm) {
        goodsService.confirm(id, confirm);
        return ResultGenerator.genSuccessResult("操作成功");
    }

    @PostMapping("")
    public BaseData add(@RequestBody GoodsAddUpdateModel goodsAddUpdateModel) {
        return ResultGenerator.genSuccessResult(goodsService.add(goodsAddUpdateModel));
    }

    @PutMapping("")
    public BaseData update(@RequestBody GoodsAddUpdateModel goodsAddUpdateModel) {
        return ResultGenerator.genSuccessResult(goodsService.update(goodsAddUpdateModel));
    }

    /**
     * 上、下架操作
     */
    @DeleteMapping("/{id}")
    public BaseData delete(@PathVariable Long id, Boolean upload) {
        goodsService.deleteById(id, upload);
        return ResultGenerator.genSuccessResult("操作成功，请等待审核");
    }
}
