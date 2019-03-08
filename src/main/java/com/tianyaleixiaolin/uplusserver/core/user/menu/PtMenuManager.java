package com.tianyaleixiaolin.uplusserver.core.user.menu;

import com.xiaoleilu.hutool.util.CollectionUtil;
import com.tianyaleixiaolin.uplusserver.core.user.role.PtRole;
import com.tianyaleixiaolin.uplusserver.global.cache.RoleMenuCache;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Mr.li wrote on 2018/10/26.
 */
@Service
public class PtMenuManager {
    @Resource
    private PtMenuRepository ptMenuRepository;
    @Resource
    private RoleMenuCache roleMenuCache;
    @Resource
    private PtRoleMenuRepository ptRoleMenuRepository;

    public List<PtMenu> findByRoleId(Long roleId) {
        //读缓存
        List<Long> menuIdList = roleMenuCache.findMenuByRoleId(roleId);

        if (CollectionUtil.isNotEmpty(menuIdList)) {
            return menuIdList.stream().map(id -> ptMenuRepository.getOne(id)).collect(Collectors
                    .toList());
        }

        List<PtRoleMenu> menuRoles = ptRoleMenuRepository.findByRoleId(roleId);
        List<PtMenu> menuList = menuRoles.stream().map(ptRoleMenu -> ptMenuRepository.getOne(ptRoleMenu.getMenuId()))
                .collect
                        (Collectors.toList());
        roleMenuCache.saveMenusByRoleId(roleId, menuList.stream().map(PtMenu::getId).collect(Collectors.toList()));
        return menuList;
    }

    public List<PtMenu> findAllMenuByRoles(List<PtRole> roles) {
        List<PtMenu> menus = new ArrayList<>();
        for (PtRole role : roles) {
            menus.addAll(findByRoleId(role.getId()));
        }
        return menus;
    }

    /**
     * 添加一个菜单
     *
     * @return 菜单
     */
    public PtMenu save(PtMenu ptMenu) {
        return ptMenuRepository.save(ptMenu);
    }

    public void delete(Long id) {
        ptMenuRepository.deleteById(id);
    }

    public PtMenu findOne(Long id) {
        return ptMenuRepository.getOne(id);
    }

    public boolean hasChild(Long id) {
        return ptMenuRepository.countByParentIdAndHideIsFalse(id) > 0;
    }
}
