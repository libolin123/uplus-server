package com.tianyaleixiaolin.uplusserver.core.order;

import com.tianyaleixiaolin.uplusserver.core.base.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.Table;

/**
 * 服务单、保单、用户管理都是这个
 *
 * @author Mr.li wrote on 2018/11/16.
 */
@Entity
@Table(name = "pt_order_relation", indexes = {@Index(name = "order_id", columnList =
        "orderId")})
public class PtOrderRelation extends BaseEntity {
    /**
     * 用户名称
     */
    private String userName;
    /**
     * orderID
     */
    private Long orderId;
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
     * 邮箱
     */
    private String email;
    /**
     * 关系（1父母，2子女，3配偶，4其他）
     */
    private Integer relationType;

    @Override
    public String toString() {
        return "PtOrderRelation{" +
                "userName='" + userName + '\'' +
                ", orderId=" + orderId +
                ", sex=" + sex +
                ", paperType='" + paperType + '\'' +
                ", paper='" + paper + '\'' +
                ", mobile='" + mobile + '\'' +
                ", email='" + email + '\'' +
                ", relationType=" + relationType +
                '}';
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Integer getSex() {
        return sex;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getRelationType() {
        return relationType;
    }

    public void setRelationType(Integer relationType) {
        this.relationType = relationType;
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

}
