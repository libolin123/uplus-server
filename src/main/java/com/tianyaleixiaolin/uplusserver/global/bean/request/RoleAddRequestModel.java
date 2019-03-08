package com.tianyaleixiaolin.uplusserver.global.bean.request;

/**
 * @author Mr.li wrote on 2018/11/26.
 */
public class RoleAddRequestModel {
    private Long id;
    /**
     * 角色名（admin，level1，level2，level3）
     */
    private String name;
    private Integer state = 0;

    private String menu;

    @Override
    public String toString() {
        return "RoleAddRequestModel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", state=" + state +
                '}';
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMenu() {
        return menu;
    }

    public void setMenu(String menu) {
        this.menu = menu;
    }
}
