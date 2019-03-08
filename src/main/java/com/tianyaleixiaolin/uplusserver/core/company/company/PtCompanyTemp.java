package com.tianyaleixiaolin.uplusserver.core.company.company;


import com.tianyaleixiaolin.uplusserver.core.base.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author libolin wrote on 2018/10/25.
 * 平台添加的公司，这个表存被修改的，修改被确认后，删除该记录
 */
@Entity
@Table(name = "pt_company_temp")
public class PtCompanyTemp extends BaseEntity {
    /**
     * 对应compnay的主键
     */
    private Long companyId;
    /**
     * 修改原因
     */
    private String reason;
    ///////////// 下面的字段和company的一样 ///////////////////////////////////
    /**
     * 公司名称
     */
    private String name;
    /**
     * 公司地址
     */
    private String address;
    /**
     * 公司性质，"国企，外商，民营"，group=6
     */
    private String property;
    /**
     * 公司类型，"保险公司，互联网公司"，group=7
     */
    private String type;
    /**
     * 公司状态（-1待审核，0正常，-2被拒绝）
     */
    private Integer status;
    /**
     * 是否上市
     */
    private boolean ipo;
    /**
     * 联系人
     */
    private String contactPerson;
    /**
     * 手机
     */
    private String mobile;
    /**
     * 销售电话
     */
    private String saleMobile;
    /**
     * 注册资本
     */
    private String capital;
    /**
     * 简介
     */
    private String intro;
    /**
     * 执照地址，可以有多个地址，逗号分隔
     */
    private String license;

    @Override
    public String toString() {
        return "PtCompanyTemp{" +
                "companyId=" + companyId +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", property='" + property + '\'' +
                ", type='" + type + '\'' +
                ", status=" + status +
                ", ipo=" + ipo +
                ", contactPerson='" + contactPerson + '\'' +
                ", mobile='" + mobile + '\'' +
                ", saleMobile='" + saleMobile + '\'' +
                ", capital='" + capital + '\'' +
                ", intro='" + intro + '\'' +
                ", license='" + license + '\'' +
                '}';
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getProperty() {
        return property;
    }

    public void setProperty(String property) {
        this.property = property;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public boolean isIpo() {
        return ipo;
    }

    public void setIpo(boolean ipo) {
        this.ipo = ipo;
    }

    public String getContactPerson() {
        return contactPerson;
    }

    public void setContactPerson(String contactPerson) {
        this.contactPerson = contactPerson;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getSaleMobile() {
        return saleMobile;
    }

    public void setSaleMobile(String saleMobile) {
        this.saleMobile = saleMobile;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license;
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
}
