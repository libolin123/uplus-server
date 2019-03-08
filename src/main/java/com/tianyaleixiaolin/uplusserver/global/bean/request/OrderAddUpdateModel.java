package com.tianyaleixiaolin.uplusserver.global.bean.request;

import com.tianyaleixiaolin.uplusserver.core.order.PtOrderRelation;

/**
 * @author Mr.li wrote on 2018/11/22.
 */
public class OrderAddUpdateModel {
    private Long id;
    /**
     * 原因
     */
    private String reason;
    //*********************下面是添加需要的，上面是update需要的***********************//
    /**
     * 用户名称
     */
    private String userName;
    /**
     * 商品ID
     */
    private Long ptGoodsId;
    private Long companyId;
    /**
     * 男1女0
     */
    private Integer sex;
    /**
     * 证件类型，group=9
     */
    private String paperType;
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
     * 邮箱
     */
    private String email;
    /**
     * 地区编码
     */
    private String areaCode;
    /**
     * 保单生效时间
     */
    private String beginTime;
    /**
     * 保单时间
     */
    private String endTime;
    private String remark;
    /**
     * 状态（0正常，1中止，2终止，3失效）
     */
    private Integer state;
    /**
     * 关联权益人
     */
    private PtOrderRelation orderRelation;

    @Override
    public String toString() {
        return "OrderAddUpdateModel{" +
                "id=" + id +
                ", reason='" + reason + '\'' +
                ", userName='" + userName + '\'' +
                ", ptGoodsId=" + ptGoodsId +
                ", companyId=" + companyId +
                ", sex=" + sex +
                ", paperType='" + paperType + '\'' +
                ", paper='" + paper + '\'' +
                ", mobile='" + mobile + '\'' +
                ", cardNum='" + cardNum + '\'' +
                ", email='" + email + '\'' +
                ", areaCode='" + areaCode + '\'' +
                ", beginTime='" + beginTime + '\'' +
                ", endTime='" + endTime + '\'' +
                ", remark='" + remark + '\'' +
                ", state=" + state +
                ", orderRelation=" + orderRelation +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Long getPtGoodsId() {
        return ptGoodsId;
    }

    public void setPtGoodsId(Long ptGoodsId) {
        this.ptGoodsId = ptGoodsId;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getPaperType() {
        return paperType;
    }

    public void setPaperType(String paperType) {
        this.paperType = paperType;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    public String getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(String beginTime) {
        this.beginTime = beginTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public PtOrderRelation getOrderRelation() {
        return orderRelation;
    }

    public void setOrderRelation(PtOrderRelation orderRelation) {
        this.orderRelation = orderRelation;
    }
}
