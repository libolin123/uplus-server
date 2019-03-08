package com.tianyaleixiaolin.uplusserver.global.bean.response;

import java.util.Date;

/**
 * @author Mr.li wrote on 2018/11/22.
 */
public class OrderTempListVO {
    private Long id;
    /**
     * 用户名称
     */
    private String userName;
    /**
     * 电话号码
     */
    private String mobile;
    /**
     * 修改人姓名//TODO
     */
    private String operatorName;
    private String reason;
    /**
     * 操作类型（新建，修改，删除）
     */
    private String operatorType;
    /**
     * 修改时间
     */
    private Date updateTime;
    /**
     * 状态（0正常，1中止，2终止，3失效）
     */
    private Integer status;

    @Override
    public String toString() {
        return "OrderTempListVO{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", mobile='" + mobile + '\'' +
                ", operatorName='" + operatorName + '\'' +
                ", reason='" + reason + '\'' +
                ", operatorType='" + operatorType + '\'' +
                ", updateTime=" + updateTime +
                ", status=" + status +
                '}';
    }

    public String getOperatorName() {
        return operatorName;
    }

    public void setOperatorName(String operatorName) {
        this.operatorName = operatorName;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getOperatorType() {
        return operatorType;
    }

    public void setOperatorType(String operatorType) {
        this.operatorType = operatorType;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
