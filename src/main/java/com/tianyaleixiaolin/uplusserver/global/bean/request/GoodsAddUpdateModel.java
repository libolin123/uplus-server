package com.tianyaleixiaolin.uplusserver.global.bean.request;

import com.tianyaleixiaolin.uplusserver.core.company.youserver.PtCashPrePay;
import com.tianyaleixiaolin.uplusserver.core.company.youserver.PtPhoneDoctor;

/**
 * @author Mr.li wrote on 2018/11/20.
 */
public class GoodsAddUpdateModel {
    private Long id;
    /**
     * 原因
     */
    private String reason;
    //*********************下面是添加需要的，上面是update需要的***********************//
    /**
     * 商品名称
     */
    private String name;
    /**
     * 商品计划ID
     */
    private Long ptGoodsPlanId;
    /**
     * 商品生效时间
     */
    private String beginTime;
    /**
     * 失效时间
     */
    private String endTime;
    private String remark;

    private Long companyId;

    private PtCashPrePay ptCashPrePay;

    private PtPhoneDoctor ptPhoneDoctor;

    /**
     * 体检服务
     */
    private Integer youBodyCheck = 0;
    /**
     * 门诊绿通
     */
    private Integer youOutpatient = 0;
    /**
     * 住院绿通
     */
    private Integer youHospital = 0;
    /**
     * 手术绿通
     */
    private Integer youOperation = 0;
    /**
     * 二次诊疗
     */
    private Integer youSecondMed = 0;


    @Override
    public String toString() {
        return "GoodsAddUpdateModel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", ptGoodsPlanId=" + ptGoodsPlanId +
                ", beginTime='" + beginTime + '\'' +
                ", endTime='" + endTime + '\'' +
                ", remark='" + remark + '\'' +
                ", companyId=" + companyId +
                ", ptCashPrePay=" + ptCashPrePay +
                ", ptPhoneDoctor=" + ptPhoneDoctor +
                ", youBodyCheck=" + youBodyCheck +
                ", youOutpatient=" + youOutpatient +
                ", youHospital=" + youHospital +
                ", youOperation=" + youOperation +
                ", youSecondMed=" + youSecondMed +
                ", reason='" + reason + '\'' +
                '}';
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getYouBodyCheck() {
        return youBodyCheck;
    }

    public void setYouBodyCheck(Integer youBodyCheck) {
        this.youBodyCheck = youBodyCheck;
    }

    public Integer getYouOutpatient() {
        return youOutpatient;
    }

    public void setYouOutpatient(Integer youOutpatient) {
        this.youOutpatient = youOutpatient;
    }

    public Integer getYouHospital() {
        return youHospital;
    }

    public void setYouHospital(Integer youHospital) {
        this.youHospital = youHospital;
    }

    public Integer getYouOperation() {
        return youOperation;
    }

    public void setYouOperation(Integer youOperation) {
        this.youOperation = youOperation;
    }

    public Integer getYouSecondMed() {
        return youSecondMed;
    }

    public void setYouSecondMed(Integer youSecondMed) {
        this.youSecondMed = youSecondMed;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getPtGoodsPlanId() {
        return ptGoodsPlanId;
    }

    public void setPtGoodsPlanId(Long ptGoodsPlanId) {
        this.ptGoodsPlanId = ptGoodsPlanId;
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

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public PtCashPrePay getPtCashPrePay() {
        return ptCashPrePay;
    }

    public void setPtCashPrePay(PtCashPrePay ptCashPrePay) {
        this.ptCashPrePay = ptCashPrePay;
    }

    public PtPhoneDoctor getPtPhoneDoctor() {
        return ptPhoneDoctor;
    }

    public void setPtPhoneDoctor(PtPhoneDoctor ptPhoneDoctor) {
        this.ptPhoneDoctor = ptPhoneDoctor;
    }
}
