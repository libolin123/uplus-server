package com.tianyaleixiaolin.uplusserver.core.user.user;

import com.tianyaleixiaolin.uplusserver.global.bean.BaseData;
import com.tianyaleixiaolin.uplusserver.global.bean.ResultGenerator;
import com.tianyaleixiaolin.uplusserver.global.bean.request.UserAddRequestModel;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;

/**
 * @author Mr.li wrote on 2018/11/23.
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserService userService;

    @GetMapping("")
    public BaseData find() {
        return ResultGenerator.genSuccessResult(userService.findAll());
    }

    @GetMapping("/{id}")
    public BaseData one(@PathVariable Long id) {
        return ResultGenerator.genSuccessResult(userService.find(id));
    }

    /**
     * 查询自己的所有菜单
     */
    @GetMapping("/menu")
    public BaseData menus() {
        return ResultGenerator.genSuccessResult(userService.findMenus());
    }

    @PutMapping("/password")
    public BaseData password(String oldPassword, String password) {
        return userService.updatePassword(oldPassword, password);
    }

    @PostMapping
    public BaseData add(@Valid UserAddRequestModel userAddRequestModel, BindingResult bindingResult) {
        return ResultGenerator.genSuccessResult(userService.add(userAddRequestModel));
    }

    @PutMapping
    public BaseData update(@Valid UserAddRequestModel userAddRequestModel, BindingResult bindingResult) {
        return ResultGenerator.genSuccessResult(userService.update(userAddRequestModel));
    }

    @DeleteMapping("/{id}")
    public BaseData delete(@PathVariable Long id) {
        userService.delete(id);
        return ResultGenerator.genSuccessResult();
    }
}
