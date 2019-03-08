package com.tianyaleixiaolin.uplusserver.core.order;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.tianyaleixiaolin.uplusserver.core.base.BaseDeleteEntity;

import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.Table;
import java.util.Date;

/**
 * 服务单、保单、用户管理都是这个
 *
 * @author Mr.li wrote on 2018/11/16.
 */
@Entity
@Table(name = "pt_order_temp", indexes = {@Index(name = "user_name", columnList =
        "userName"), @Index(name = "company_id", columnList =
        "companyId"), @Index(name = "pt_goods_id", columnList =
        "ptGoodsId")})
@JsonIgnoreProperties(value = {"hibernateLazyInitializer"})
public class PtOrderTemp extends BaseDeleteEntity {
    /**
     * 对应PtOrder的主键
     */
    private Long orderId;
    /**
     * 修改原因
     */
    private String reason;
    /**
     * 操作类型（新建，修改，删除）
     */
    private String operatorType;
    /**
     * 删除时需要文件，逗号分隔
     */
    private String files;
    ///////////// PtOrder ///////////////////////////////////
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
    private String province;
    private String city;
    private String country;
    /**
     * 保单生效时间
     */
    private Date beginTime;
    /**
     * 保单时间
     */
    private Date endTime;
    private String remark;
    /**
     * 状态（0正常，1中止，2终止，3失效）
     */
    private Integer state;
    /**
     * 状态（-1待审核，-2被拒绝，0正常）
     */
    private Integer status;

    @Override
    public String toString() {
        return "PtOrderTemp{" +
                "orderId=" + orderId +
                ", reason='" + reason + '\'' +
                ", operatorType='" + operatorType + '\'' +
                ", files='" + files + '\'' +
                ", userName='" + userName + '\'' +
                ", ptGoodsId=" + ptGoodsId +
                ", companyId=" + companyId +
                ", sex=" + sex +
                ", paperType='" + paperType + '\'' +
                ", paper='" + paper + '\'' +
                ", mobile='" + mobile + '\'' +
                ", cardNum='" + cardNum + '\'' +
                ", email='" + email + '\'' +
                ", province='" + province + '\'' +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                ", beginTime=" + beginTime +
                ", endTime=" + endTime +
                ", remark='" + remark + '\'' +
                ", state=" + state +
                ", status=" + status +
                '}';
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getFiles() {
        return files;
    }

    public void setFiles(String files) {
        this.files = files;
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

    public Long getPtGoodsId() {
        return ptGoodsId;
    }

    public void setPtGoodsId(Long ptGoodsId) {
        this.ptGoodsId = ptGoodsId;
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

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
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

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}