package com.tianyaleixiaolin.uplusserver.global.bean.response;

import java.util.Date;

/**
 * @author Mr.li wrote on 2018/11/22.
 */
public class OrderListVO {
    private Long id;
    /**
     * 关联权益人姓名
     */
    private String relationUserName;
    /**
     * 用户名称
     */
    private String userName;
    /**
     * 商品名字 TODO
     */
    private String goodsName;
    /**
     * 公司名字 TODO
     */
    private String companyName;
    /**
     * 证件号码
     */
    private String paper;
    /**
     * 电话号码
     */
    private String mobile;
    /**
     * 保单号
     */
    private String cardNum;
    /**
     * 优加服务 TODO
     */
    private String youServers;
    /**
     * 保单生效时间
     */
    private Date beginTime;
    /**
     * 保单时间
     */
    private Date endTime;
    private String province;
    private String provinceValue;
    private String city;
    private String cityValue;
    private String country;
    private String countryValue;
    /**
     * 状态（0正常，1中止，2终止，3失效）
     */
    private Integer status;

    @Override
    public String toString() {
        return "OrderListVO{" +
                "id=" + id +
                ", relationUserName='" + relationUserName + '\'' +
                ", userName='" + userName + '\'' +
                ", goodsName='" + goodsName + '\'' +
                ", companyName='" + companyName + '\'' +
                ", paper='" + paper + '\'' +
                ", mobile='" + mobile + '\'' +
                ", cardNum='" + cardNum + '\'' +
                ", youServers='" + youServers + '\'' +
                ", beginTime=" + beginTime +
                ", endTime=" + endTime +
                ", province='" + province + '\'' +
                ", provinceValue='" + provinceValue + '\'' +
                ", city='" + city + '\'' +
                ", cityValue='" + cityValue + '\'' +
                ", country='" + country + '\'' +
                ", countryValue='" + countryValue + '\'' +
                ", status=" + status +
                '}';
    }

    public String getRelationUserName() {
        return relationUserName;
    }

    public void setRelationUserName(String relationUserName) {
        this.relationUserName = relationUserName;
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

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getPaper() {
        return paper;
    }

    public void setPaper(String paper) {
        this.paper = paper;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getCardNum() {
        return cardNum;
    }

    public void setCardNum(String cardNum) {
        this.cardNum = cardNum;
    }

    public String getYouServers() {
        return youServers;
    }

    public void setYouServers(String youServers) {
        this.youServers = youServers;
    }

    public Date getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(Date beginTime) {
        this.beginTime = beginTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
