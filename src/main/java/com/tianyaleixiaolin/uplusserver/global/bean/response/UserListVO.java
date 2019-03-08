package com.tianyaleixiaolin.uplusserver.global.bean.response;

/**
 * @author Mr.li wrote on 2018/11/26.
 */
public class UserListVO {
    private Long id;
    /**
     * 账号
     */
    private String account;
    /**
     * 用户名称
     */
    private String name;
    private String roleName;
    private Long roleId;
    /**
     * 状态
     */
    private Integer state;
    private String mobile;

    @Override
    public String toString() {
        return "UserListVO{" +
                "id=" + id +
                ", account='" + account + '\'' +
                ", name='" + name + '\'' +
                ", roleName='" + roleName + '\'' +
                ", roleId=" + roleId +
                ", state=" + state +
                ", mobile='" + mobile + '\'' +
                '}';
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
}
