package com.tianyaleixiaolin.uplusserver.global.bean.response;

import java.util.Date;

/**
 * @author Mr.li wrote on 2018/11/15.
 */
public class CompanyTempListVO {
    private Long id;
    /**
     * 公司id
     */
    private Long companyId;
    /**
     * 公司名称
     */
    private String name;
    /**
     * 原因
     */
    private String reason;
    /**
     * 公司地址
     */
    private String address;
    /**
     * 修改人
     */
    private String property;
    /**
     * status
     */
    private Integer status;
    /**
     * 修改时间
     */
    private Date updateTime;
    /**
     * 修改人姓名
     */
    private String operatorName;

    @Override
    public String toString() {
        return "CompanyTempListVO{" +
                "id=" + id +
                ", companyId=" + companyId +
                ", name='" + name + '\'' +
                ", reason='" + reason + '\'' +
                ", address='" + address + '\'' +
                ", property='" + property + '\'' +
                ", status=" + status +
                ", updateTime=" + updateTime +
                ", operatorName='" + operatorName + '\'' +
                '}';
    }

    public String getOperatorName() {
        return operatorName;
    }

    public void setOperatorName(String operatorName) {
        this.operatorName = operatorName;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getProperty() {
        return property;
    }

    public void setProperty(String property) {
        this.property = property;
    }
}
