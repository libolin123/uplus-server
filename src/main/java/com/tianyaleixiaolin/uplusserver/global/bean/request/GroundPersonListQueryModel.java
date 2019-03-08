package com.tianyaleixiaolin.uplusserver.global.bean.request;

/**
 * @author Mr.li wrote on 2018/11/26.
 */
public class GroundPersonListQueryModel extends BaseModel {
    private String userName;
    private String mobile;
    private String province;
    private String city;
    private String country;
    private Boolean areaOwner;
    /**
     * 审核状态（-1待审核，0正常，-2被拒绝）
     */
    private Integer state;
    /**
     * 是否签约
     */
    private Boolean sign;

    @Override
    public String toString() {
        return "GroundPersonListQueryModel{" +
                "userName='" + userName + '\'' +
                ", mobile='" + mobile + '\'' +
                ", province='" + province + '\'' +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                ", areaOwner=" + areaOwner +
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

    public Boolean getAreaOwner() {
        return areaOwner;
    }

    public void setAreaOwner(Boolean areaOwner) {
        this.areaOwner = areaOwner;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
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
}
