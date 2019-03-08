package com.tianyaleixiaolin.uplusserver.global.bean.response;

import java.util.Date;

/**
 * 派单列表页
 * @author Mr.li wrote on 2018/12/11.
 */
public class ProductOrderListVO {
    private Long id;
    /**
     * 用户名称
     */
    private String userName;
    /**
     * 电话号码
     */
    private String mobile;
    private String provinceValue;
    private String cityValue;
    private String countryValue;

    /**
     * 期望就医省市县
     */
    private String wantProvince;
    private String wantCity;
    private String wantCountry;
    /**
     * 医院名 TODO
     */
    private String hospitalName;
    /**
     * 接单人 TODO
     */
    private String groundPersonName;
    /**
     * 公司名字 TODO
     */
    private String companyName;
    /**
     * 当前状态group=14.未派单，已派单，已接单，
     */
    private String stateValue;
    /**
     * 子状态group=15。已转单，未转单
     */
    private String childStateValue;
    private String remark;
    private Boolean deleteFlag;
    //关闭原因
    private String reason;
    /**
     * 是否转过单
     */
    private Boolean changePerson;
    /**
     * 派单时间
     */
    private Date paiTime;

    @Override
    public String toString() {
        return "ProductOrderListVO{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", mobile='" + mobile + '\'' +
                ", provinceValue='" + provinceValue + '\'' +
                ", cityValue='" + cityValue + '\'' +
                ", countryValue='" + countryValue + '\'' +
                ", wantProvince='" + wantProvince + '\'' +
                ", wantCity='" + wantCity + '\'' +
                ", wantCountry='" + wantCountry + '\'' +
                ", hospitalName='" + hospitalName + '\'' +
                ", groundPersonName='" + groundPersonName + '\'' +
                ", companyName='" + companyName + '\'' +
                ", stateValue='" + stateValue + '\'' +
                ", childStateValue='" + childStateValue + '\'' +
                ", remark='" + remark + '\'' +
                ", deleteFlag=" + deleteFlag +
                ", reason='" + reason + '\'' +
                ", changePerson=" + changePerson +
                ", paiTime=" + paiTime +
                '}';
    }

    public Date getPaiTime() {
        return paiTime;
    }

    public void setPaiTime(Date paiTime) {
        this.paiTime = paiTime;
    }

    public Boolean getChangePerson() {
        return changePerson;
    }

    public void setChangePerson(Boolean changePerson) {
        this.changePerson = changePerson;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getWantProvince() {
        return wantProvince;
    }

    public void setWantProvince(String wantProvince) {
        this.wantProvince = wantProvince;
    }

    public String getWantCity() {
        return wantCity;
    }

    public void setWantCity(String wantCity) {
        this.wantCity = wantCity;
    }

    public String getWantCountry() {
        return wantCountry;
    }

    public void setWantCountry(String wantCountry) {
        this.wantCountry = wantCountry;
    }

    public Boolean getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(Boolean deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    public String getProvinceValue() {
        return provinceValue;
    }

    public void setProvinceValue(String provinceValue) {
        this.provinceValue = provinceValue;
    }

    public String getCityValue() {
        return cityValue;
    }

    public void setCityValue(String cityValue) {
        this.cityValue = cityValue;
    }

    public String getCountryValue() {
        return countryValue;
    }

    public void setCountryValue(String countryValue) {
        this.countryValue = countryValue;
    }

    public String getStateValue() {
        return stateValue;
    }

    public void setStateValue(String stateValue) {
        this.stateValue = stateValue;
    }

    public String getChildStateValue() {
        return childStateValue;
    }

    public void setChildStateValue(String childStateValue) {
        this.childStateValue = childStateValue;
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

    public String getHospitalName() {
        return hospitalName;
    }

    public void setHospitalName(String hospitalName) {
        this.hospitalName = hospitalName;
    }

    public String getGroundPersonName() {
        return groundPersonName;
    }

    public void setGroundPersonName(String groundPersonName) {
        this.groundPersonName = groundPersonName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
