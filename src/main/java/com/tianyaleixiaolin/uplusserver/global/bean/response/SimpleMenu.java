package com.tianyaleixiaolin.uplusserver.global.bean.response;

import java.util.List;
import java.util.Objects;

/**
 * @author Mr.li wrote on 2018/11/30.
 */
public class SimpleMenu {
    private Long id;
    private Long groupId;
    /**
     * 菜单名
     */
    private String name;
    /**
     * 菜单名
     */
    private int orderNum;
    private List<SimpleMenu> childMenus;

    @Override
    public String toString() {
        return "SimpleMenu{" +
                "id=" + id +
                ", groupId=" + groupId +
                ", name='" + name + '\'' +
                ", orderNum=" + orderNum +
                ", childMenus=" + childMenus +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SimpleMenu that = (SimpleMenu) o;
        return orderNum == that.orderNum &&
                Objects.equals(id, that.id) &&
                Objects.equals(groupId, that.groupId) &&
                Objects.equals(name, that.name) &&
                Objects.equals(childMenus, that.childMenus);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, groupId, name, orderNum, childMenus);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    public List<SimpleMenu> getChildMenus() {
        return childMenus;
    }

    public void setChildMenus(List<SimpleMenu> childMenus) {
        this.childMenus = childMenus;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(int orderNum) {
        this.orderNum = orderNum;
    }
}
