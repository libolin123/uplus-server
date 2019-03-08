package com.tianyaleixiaolin.uplusserver.core.user.menu;

import com.xiaoleilu.hutool.util.BeanUtil;
import com.tianyaleixiaolin.uplusserver.core.user.role.PtRole;
import com.tianyaleixiaolin.uplusserver.core.user.role.PtRoleManager;
import com.tianyaleixiaolin.uplusserver.global.UserKit;
import com.tianyaleixiaolin.uplusserver.global.bean.response.MenuVO;
import com.tianyaleixiaolin.uplusserver.global.event.MenuDeleteEvent;
import com.tianyaleixiaolin.uplusserver.global.event.RoleMenuChangeEvent;
import com.tianyaleixiaolin.uplusserver.global.util.CommonUtil;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Mr.li wrote on 2018/11/3.
 */
@Component
public class MenuService {
    @Resource
    private PtMenuManager ptMenuManager;
    @Resource
    private PtRoleManager ptRoleManager;
    @Resource
    private PtRoleMenuManager ptRoleMenuManager;
    @Resource
    private UserKit userKit;
    @Resource
    private ApplicationEventPublisher eventPublisher;

    /**
     * 添加菜单
     *
     * @param ptMenu
     *         菜单
     * @return 菜单
     */
    public PtMenu add(PtMenu ptMenu) {
        ptMenu.setCreateTime(CommonUtil.getNow());
        ptMenu.setUpdateTime(CommonUtil.getNow());

        ptMenu = ptMenuManager.save(ptMenu);

        return ptMenu;
    }

    /**
     * 修改菜单
     *
     * @param ptMenu
     *         菜单
     * @return 菜单
     */
    public PtMenu update(PtMenu ptMenu) {
        ptMenu.setUpdateTime(CommonUtil.getNow());
        PtMenu oldMenu = ptMenuManager.findOne(ptMenu.getId());
        BeanUtil.copyProperties(ptMenu, oldMenu, BeanUtil.CopyOptions.create().setIgnoreNullValue(true));
        //发布菜单事件
        PtMenu menu = ptMenuManager.save(oldMenu);

        notifyMenuChangeEvent(ptMenu.getId());
        return menu;
    }

    /**
     * 删除菜单
     *
     * @param id
     *         菜单id
     */
    public boolean delete(Long id) {
        //先判断是否是目录，如果是目录的话，子菜单还有值的话就不让删
        if (ptMenuManager.hasChild(id)) {
            return false;
        }
        ptMenuManager.delete(id);
        notifyMenuChangeEvent(id);
        //删除MenuRole中关于该menu的记录
        eventPublisher.publishEvent(new MenuDeleteEvent(id));
        return true;
    }

    /**
     * 当菜单信息变更时，通知所有拥有该菜单的role
     *
     * @param menuId
     *         菜单id
     */
    private void notifyMenuChangeEvent(Long menuId) {
        //查询有该菜单的所有role
        List<PtRole> roles = ptRoleMenuManager.findRolesByMenu(menuId);

        //发布菜单事件
        eventPublisher.publishEvent(new RoleMenuChangeEvent(roles.stream().map(PtRole::getId).collect(Collectors
                .toList())));
    }

    /**
     * 查询某个菜单的子菜单，默认0则查询所有一级菜单
     *
     * @param parentId
     *         父菜单id
     */
    public List<MenuVO> find(final Long parentId) {
        long id = parentId == null ? 0 : parentId;
        Long userId = userKit.getCurrentUserId();
        List<PtRole> ptRoleList = ptRoleManager.findByUserId(userId);
        //得到该用户所有菜单
        List<PtMenu> menuList = ptMenuManager.findAllMenuByRoles(ptRoleList);
        //其他人不显示已隐藏的菜单
        return parseMenu(menuList.stream().filter(ptMenu -> ptMenu.getParentId() == id)
                .filter(ptMenu -> !ptMenu.isHide())
                .sorted(Comparator.comparing(PtMenu::getOrderNum))
                .collect
                        (Collectors
                                .toList()));
    }

    private List<MenuVO> parseMenu(List<PtMenu> ptMenus) {
        List<MenuVO> menuVOS = new ArrayList<>(ptMenus.size());
        for (PtMenu ptMenu : ptMenus) {
            MenuVO menuVO = new MenuVO();
            BeanUtil.copyProperties(ptMenu, menuVO, BeanUtil.CopyOptions.create().setIgnoreNullValue(true));
            menuVO.setHasChild(ptMenuManager.hasChild(ptMenu.getId()));
            menuVOS.add(menuVO);
        }
        return menuVOS;
    }
}
