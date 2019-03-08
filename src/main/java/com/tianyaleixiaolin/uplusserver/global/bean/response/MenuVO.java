package com.tianyaleixiaolin.uplusserver.global.bean.response;

import java.util.Date;

/**
 * @author Mr.li wrote on 2018/2/7.
 */
public class MenuVO {
    private Long id;

    private Date createTime;

    private Date updateTime;
    /**
     * 菜单名
     */
    private String name;
    /**
     * 父菜单id（1级为0）
     */
    private Long parentId;
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

    /**
     * 是否有子菜单
     */
    private boolean hasChild;

    private Long groupId;

    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isHasChild() {
        return hasChild;
    }

    public void setHasChild(boolean hasChild) {
        this.hasChild = hasChild;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
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

    public boolean isHide() {
        return hide;
    }

    public void setHide(boolean hide) {
        this.hide = hide;
    }

    @Override
    public String toString() {
        return "MenuVO{" +
                "id=" + id +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", name='" + name + '\'' +
                ", parentId=" + parentId +
                ", url='" + url + '\'' +
                ", description='" + description + '\'' +
                ", permission='" + permission + '\'' +
                ", type=" + type +
                ", icon='" + icon + '\'' +
                ", orderNum=" + orderNum +
                ", hide=" + hide +
                ", hasChild=" + hasChild +
                ", groupId=" + groupId +
                '}';
    }
}
