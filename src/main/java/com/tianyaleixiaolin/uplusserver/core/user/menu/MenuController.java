package com.tianyaleixiaolin.uplusserver.core.user.menu;

import com.tianyaleixiaolin.uplusserver.global.bean.BaseData;
import com.tianyaleixiaolin.uplusserver.global.bean.ResultGenerator;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author Mr.li wrote on 2018/11/3.
 * 菜单
 */
@RestController
@RequestMapping("/menu")
public class MenuController {
    @Resource
    private MenuService menuService;

    /**
     * 获取自己的菜单
     *
     * @param parentId
     *         父菜单id
     * @return 菜单结果
     */
    @GetMapping("")
    public BaseData get(Long parentId) {
        return ResultGenerator.genSuccessResult(menuService.find(parentId));
    }

    /**
     * 添加菜单
     */
    @PostMapping("")
    public BaseData add(@ModelAttribute PtMenu ptMenu) {
        return ResultGenerator.genSuccessResult(menuService.add(ptMenu));
    }

    @PutMapping("")
    public BaseData update(@ModelAttribute PtMenu ptMenu) {
        if (ptMenu.getId() == null) {
            return ResultGenerator.genFailResult("菜单Id不能为空");
        }
        return ResultGenerator.genSuccessResult(menuService.update(ptMenu));
    }

    @DeleteMapping("/{id}")
    public BaseData delete(@PathVariable Long id) {
        boolean success = menuService.delete(id);
        if (success) {
            return ResultGenerator.genSuccessResult("删除成功");
        } else {
            return ResultGenerator.genFailResult("该菜单还有子菜单未删除");
        }
    }

}
