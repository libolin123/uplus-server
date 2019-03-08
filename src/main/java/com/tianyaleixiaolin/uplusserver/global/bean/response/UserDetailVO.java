package com.tianyaleixiaolin.uplusserver.global.bean.response;

import java.util.Set;

/**
 * @author Mr.li wrote on 2018/11/30.
 */
public class UserDetailVO {
    private String account;
    private String name;
    private String mobile;

    private Set<Long> roleIds;

    private Set<SimpleMenu> menus;

    @Override
    public String toString() {
        return "UserDetailVO{" +
                "account='" + account + '\'' +
                ", name='" + name + '\'' +
                ", mobile='" + mobile + '\'' +
                ", roleIds=" + roleIds +
                ", menus=" + menus +
                '}';
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Set<Long> getRoleIds() {
        return roleIds;
    }

    public void setRoleIds(Set<Long> roleIds) {
        this.roleIds = roleIds;
    }

    public Set<SimpleMenu> getMenus() {
        return menus;
    }

    public void setMenus(Set<SimpleMenu> menus) {
        this.menus = menus;
    }
}
