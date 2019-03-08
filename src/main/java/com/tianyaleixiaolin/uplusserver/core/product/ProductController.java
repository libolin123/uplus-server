package com.tianyaleixiaolin.uplusserver.core.product;

import com.tianyaleixiaolin.uplusserver.global.bean.BaseData;
import com.tianyaleixiaolin.uplusserver.global.bean.ResultGenerator;
import com.tianyaleixiaolin.uplusserver.global.bean.request.ProductAddUpdateModel;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 产品管理
 * @author Mr.li wrote on 2018/11/12.
 */
@RestController
@RequestMapping("product")
public class ProductController {
    @Resource
    private ProductService productService;

    @GetMapping("")
    public BaseData list() {
        return ResultGenerator.genSuccessResult(productService.findAll());
    }

    @GetMapping("/{id}")
    public BaseData one(@PathVariable Long id) {
        return ResultGenerator.genSuccessResult(productService.find(id));
    }

    @PostMapping("")
    public BaseData add(@RequestBody ProductAddUpdateModel ptProduct) {
        return ResultGenerator.genSuccessResult(productService.add(ptProduct));
    }

    @PutMapping("")
    public BaseData update(@RequestBody ProductAddUpdateModel ptProduct) {
        return ResultGenerator.genSuccessResult(productService.update(ptProduct));
    }

    @DeleteMapping("/{id}")
    public BaseData delete(@PathVariable Long id) {
        productService.delete(id);
        return ResultGenerator.genSuccessResult("删除成功");
    }
}
