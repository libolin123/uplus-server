package com.tianyaleixiaolin.uplusserver.core.product.order;

import com.tianyaleixiaolin.uplusserver.core.product.OrderFlowService;
import com.tianyaleixiaolin.uplusserver.core.product.flow.PtOrderFlow;
import com.tianyaleixiaolin.uplusserver.global.bean.BaseData;
import com.tianyaleixiaolin.uplusserver.global.bean.ResultGenerator;
import com.tianyaleixiaolin.uplusserver.global.bean.request.ProductOrderAddModel;
import com.tianyaleixiaolin.uplusserver.global.bean.request.ProductOrderListQueryModel;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 产品管理
 * @author Mr.li wrote on 2018/11/12.
 */
@RestController
@RequestMapping("productOrder")
public class ProductOrderController {
    @Resource
    private ProductOrderService productOrderService;
    @Resource
    private OrderFlowService orderFlowService;

    @GetMapping("")
    public BaseData list(ProductOrderListQueryModel productOrderListQueryModel) {
        return ResultGenerator.genSuccessResult(productOrderService.findAll(productOrderListQueryModel));
    }

    @GetMapping("/{id}")
    public BaseData one(@PathVariable Long id) {
        return ResultGenerator.genSuccessResult(productOrderService.find(id));
    }

    /**
     * 地勤开始抢单
     */
    @PostMapping("/{id}/hasReceive")
    public BaseData qiangdan(@PathVariable Long id) {
        return productOrderService.receiveOrder(id);
    }

    /**
     * 后台发起抢单
     */
    @PostMapping("/{id}/beginReceive")
    public BaseData beginqiangdan(@PathVariable Long id, String province, String city, String country) {
        return productOrderService.beginReceiveOrder(id, province, city, country);
    }

    /**
     * 选地勤人员
     */
    @PostMapping("/{id}/groundPerson")
    public BaseData paidan(@PathVariable Long id, Long personId, String remark) {
        return ResultGenerator.genSuccessResult(productOrderService.chooseGroundPerson(id, personId, remark));
    }

    /**
     * 转单给别的地勤人员
     */
    @PutMapping("/{id}/groundPerson")
    public BaseData paidanOther(@PathVariable Long id, Long personId, String remark) {
        return ResultGenerator.genSuccessResult(productOrderService.changeGroundPerson(id, personId, remark));
    }

    @PostMapping("")
    public BaseData add(@RequestBody ProductOrderAddModel ptProduct) {
        return ResultGenerator.genSuccessResult(productOrderService.add(ptProduct));
    }

    @PutMapping("")
    public BaseData update(@RequestBody ProductOrderAddModel ptProduct) {
        return ResultGenerator.genSuccessResult(productOrderService.update(ptProduct));
    }

    @PutMapping("/orderFlow")
    public BaseData orderFlow(PtOrderFlow ptOrderFlow) {
        return ResultGenerator.genSuccessResult(orderFlowService.addOrUpdate(ptOrderFlow));
    }

    @DeleteMapping("/{id}")
    public BaseData delete(@PathVariable Long id, String reason) {
        productOrderService.delete(id, reason);
        return ResultGenerator.genSuccessResult("删除成功");
    }
}
