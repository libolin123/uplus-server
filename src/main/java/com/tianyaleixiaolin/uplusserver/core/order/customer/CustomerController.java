package com.tianyaleixiaolin.uplusserver.core.order.customer;

import com.tianyaleixiaolin.uplusserver.core.order.OrderService;
import com.tianyaleixiaolin.uplusserver.global.bean.BaseData;
import com.tianyaleixiaolin.uplusserver.global.bean.ResultGenerator;
import com.tianyaleixiaolin.uplusserver.global.bean.request.OrderAddUpdateModel;
import com.tianyaleixiaolin.uplusserver.global.bean.request.OrderListQueryModel;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 客户管理
 * @author Mr.li wrote on 2018/11/16.
 */
@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Resource
    private OrderService orderService;

    @GetMapping("")
    public BaseData list(OrderListQueryModel orderListQueryModel) {
        return ResultGenerator.genSuccessResult(orderService.find(orderListQueryModel));
    }

    /**
     * 查询某用户的保单列表
     */
    @GetMapping("/{id}")
    public BaseData one(@PathVariable Long id) {
        return ResultGenerator.genSuccessResult(orderService.findListByUserPaper(id));
    }


    @PostMapping("")
    public BaseData add(@RequestBody OrderAddUpdateModel orderAddUpdateModel) {
        return ResultGenerator.genSuccessResult(orderService.add(orderAddUpdateModel, false));
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
