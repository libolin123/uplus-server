package com.tianyaleixiaolin.uplusserver.global.bean.response;

import java.util.Date;

/**
 * @author Mr.li wrote on 2018/11/26.
 */
public class GroundPersonListVO {
    private Long id;
    /**
     * 用户名称
     */
    private String userName;
    /**
     * 电话号码
     */
    private String mobile;
    private String province;
    private String provinceValue;
    private String city;
    private String cityValue;
    private String country;
    private String countryValue;
    private String remark;
    private String workTimes;
    /**
     * 微信昵称
     */
    private String wechatName;
    /**
     * 微信id
     */
    private String openId;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 审核状态（-1待审核，0正常，-2被拒绝）
     */
    private Integer state;
    /**
     * 是否已签约
     */
    private Boolean sign;


    @Override
    public String toString() {
        return "GroundPersonListVO{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", mobile='" + mobile + '\'' +
                ", province='" + province + '\'' +
                ", provinceValue='" + provinceValue + '\'' +
                ", city='" + city + '\'' +
                ", cityValue='" + cityValue + '\'' +
                ", country='" + country + '\'' +
                ", countryValue='" + countryValue + '\'' +
                ", remark='" + remark + '\'' +
                ", workTimes='" + workTimes + '\'' +
                ", wechatName='" + wechatName + '\'' +
                ", openId='" + openId + '\'' +
                ", createTime=" + createTime +
                ", state=" + state +
                ", sign=" + sign +
                '}';
    }

    public Boolean getSign() {
        return sign;
    }

    public void setSign(Boolean sign) {
        this.sign = sign;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getWechatName() {
        return wechatName;
    }

    public void setWechatName(String wechatName) {
        this.wechatName = wechatName;
    }

    public String getWorkTimes() {
        return workTimes;
    }

    public void setWorkTimes(String workTimes) {
        this.workTimes = workTimes;
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

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
