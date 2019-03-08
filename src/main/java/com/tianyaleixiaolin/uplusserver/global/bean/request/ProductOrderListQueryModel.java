package com.tianyaleixiaolin.uplusserver.global.bean.request;

/**
 * @author Mr.li wrote on 2018/12/11.
 */
public class ProductOrderListQueryModel extends BaseModel {
    private String id;
    private String userName;
    private String paper;
    private String mobile;
    private String province;
    private String city;
    private String country;
    /**
     * 企业id
     */
    private Long companyId;
    /**
     * 当前状态group=14.未派单，已派单，已接单，
     */
    private Integer state;
    /**
     * 不能为哪个state
     */
    private Integer notState;
    /**
     * 子状态group=15。已转单，未转单
     */
    private Integer childState;
    private Boolean deleteFlag;

    /**
     * 为true则是我派的单
     */
    private Boolean myOrder;

    @Override
    public String toString() {
        return "ProductOrderListQueryModel{" +
                "id='" + id + '\'' +
                ", userName='" + userName + '\'' +
                ", paper='" + paper + '\'' +
                ", mobile='" + mobile + '\'' +
                ", province='" + province + '\'' +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                ", companyId=" + companyId +
                ", state=" + state +
                ", notState=" + notState +
                ", childState=" + childState +
                ", deleteFlag=" + deleteFlag +
                ", myOrder=" + myOrder +
                '}';
    }

    public Boolean getMyOrder() {
        return myOrder;
    }

    public void setMyOrder(Boolean myOrder) {
        this.myOrder = myOrder;
    }

    public Boolean getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(Boolean deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    public Integer getNotState() {
        return notState;
    }

    public void setNotState(Integer notState) {
        this.notState = notState;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getChildState() {
        return childState;
    }

    public void setChildState(Integer childState) {
        this.childState = childState;
    }
}
