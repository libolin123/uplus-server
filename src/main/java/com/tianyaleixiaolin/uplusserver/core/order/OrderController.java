package com.tianyaleixiaolin.uplusserver.core.order;

import com.tianyaleixiaolin.uplusserver.global.bean.BaseData;
import com.tianyaleixiaolin.uplusserver.global.bean.ResultGenerator;
import com.tianyaleixiaolin.uplusserver.global.bean.request.OrderAddUpdateModel;
import com.tianyaleixiaolin.uplusserver.global.bean.request.OrderListQueryModel;
import com.tianyaleixiaolin.uplusserver.global.bean.request.OrderTempListQueryModel;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;

/**
 * @author Mr.li wrote on 2018/11/16.
 */
@RestController
@RequestMapping("/order")
public class OrderController {
    @Resource
    private OrderService orderService;

    @GetMapping("")
    public BaseData list(OrderListQueryModel orderListQueryModel) {
        return ResultGenerator.genSuccessResult(orderService.find(orderListQueryModel));
    }

    @GetMapping("/tempList")
    public BaseData confirm(OrderTempListQueryModel orderTempListQueryModel) {
        return ResultGenerator.genSuccessResult(orderService.findTemp(orderTempListQueryModel));
    }

    @GetMapping("/{id}")
    public BaseData one(@PathVariable Long id) {
        return ResultGenerator.genSuccessResult(orderService.findOne(id));
    }

    /**
     * 包含被修改的详情
     */
    @GetMapping("/{id}/detail")
    public BaseData detail(@PathVariable Long id) {
        return ResultGenerator.genSuccessResult(orderService.findDetail(id));
    }

    @PostMapping("/{id}/detail/confirm")
    public BaseData confirm(@PathVariable Long id, Boolean confirm) {
        orderService.confirm(id, confirm);
        return ResultGenerator.genSuccessResult("操作成功");
    }

    @PostMapping("")
    public BaseData add(@RequestBody OrderAddUpdateModel orderAddUpdateModel) {
        return ResultGenerator.genSuccessResult(orderService.add(orderAddUpdateModel, true));
    }

    /**
     * 导入csv
     */
    @PostMapping("/import")
    public BaseData importCsv(@RequestParam("file") MultipartFile file, Long goodsId) {
        return orderService.importCsv(file, goodsId);
    }

    @PutMapping("")
    public BaseData update(@RequestBody OrderAddUpdateModel orderAddUpdateModel) {
        return ResultGenerator.genSuccessResult(orderService.update(orderAddUpdateModel));
    }

    /**
     * 删除
     */
    @DeleteMapping("/{id}")
    public BaseData delete(@PathVariable Long id, String reason, String files) {
        orderService.deleteById(id, reason, files);
        return ResultGenerator.genSuccessResult("操作成功，请等待审核");
    }
}
