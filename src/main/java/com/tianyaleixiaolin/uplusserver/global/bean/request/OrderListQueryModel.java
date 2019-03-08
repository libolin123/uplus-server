package com.tianyaleixiaolin.uplusserver.global.bean.request;

/**
 * @author Mr.li wrote on 2018/11/22.
 */
public class OrderListQueryModel extends BaseModel {
    /**
     * 用户名称
     */
    private String userName;
    /**
     * 保单号
     */
    private String cardNum;
    /**
     * 电话号码
     */
    private String mobile;
    /**
     * 证件号码
     */
    private String paper;
    /**
     * 公司ID
     */
    private Long companyId;
    private String province;
    private String city;
    private String country;
    /**
     * 0正常，1中止，2终止，3失效
     */
    private Integer status;

    @Override
    public String toString() {
        return "OrderListQueryModel{" +
                "userName='" + userName + '\'' +
                ", cardNum='" + cardNum + '\'' +
                ", mobile='" + mobile + '\'' +
                ", paper='" + paper + '\'' +
                ", companyId=" + companyId +
                ", province='" + province + '\'' +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                ", status=" + status +
                '}';
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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getCardNum() {
        return cardNum;
    }

    public void setCardNum(String cardNum) {
        this.cardNum = cardNum;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getPaper() {
        return paper;
    }

    public void setPaper(String paper) {
        this.paper = paper;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }
}
