package com.tianyaleixiaolin.uplusserver.global.bean.response;


import com.tianyaleixiaolin.uplusserver.core.user.role.PtRole;

/**
 * @author Mr.li wrote on 2018/11/30.
 */
public class RoleMenuVO {
    private PtRole role;

    private String menu;

    @Override
    public String toString() {
        return "RoleMenuVO{" +
                "role=" + role +
                ", menus=" + menu +
                '}';
    }

    public PtRole getRole() {
        return role;
    }

    public void setRole(PtRole role) {
        this.role = role;
    }

    public String getMenu() {
        return menu;
    }

    public void setMenu(String menu) {
        this.menu = menu;
    }
}