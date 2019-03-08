package com.tianyaleixiaolin.uplusserver.core.user.menu;


import com.tianyaleixiaolin.uplusserver.core.base.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.Table;

/**
 * @author Mr.li wrote on 2018/10/25.
 * 菜单表
 */
@Entity
@Table(name = "pt_menu", indexes = {@Index(name = "parent_id", columnList =
        "parentId")})
public class PtMenu extends BaseEntity implements Comparable {
    /**
     * 菜单名
     */
    private String name;
    /**
     * 父菜单的groupId（1级为0）
     */
    private Long parentId;
    /**
     * 组的ID
     */
    private Long groupId;
    /**
     * 地址url("/contact")
     */
    private String url;
    /**
     * 描述
     */
    private String description;
    /**
     * 权限字符串（"role:add","contact:push"）
     */
    private String permission;
    /**
     * '类型   0：目录   1：菜单   2：按钮'
     */
    private int type;
    /**
     * 菜单icon
     */
    private String icon;
    /**
     * 排序（从小到大显示）
     */
    private int orderNum;
    /**
     * 是否隐藏
     */
    private boolean hide;

    @Override
    public String toString() {
        return "PtMenu{" +
                "name='" + name + '\'' +
                ", parentId=" + parentId +
                ", groupId=" + groupId +
                ", url='" + url + '\'' +
                ", description='" + description + '\'' +
                ", permission='" + permission + '\'' +
                ", type=" + type +
                ", icon='" + icon + '\'' +
                ", orderNum=" + orderNum +
                ", hide=" + hide +
                '}';
    }

    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isHide() {
        return hide;
    }

    public void setHide(boolean hide) {
        this.hide = hide;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public int getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(int orderNum) {
        this.orderNum = orderNum;
    }

    @Override
    public int compareTo(Object o) {
        if (this == o) {
            return 0;
        } else if (o != null && o instanceof PtMenu) {
            PtMenu u = (PtMenu) o;
            if (orderNum > u.orderNum) {
                return -1;
            } else {
                return 1;
            }
        } else {
            return -1;
        }
    }

}
