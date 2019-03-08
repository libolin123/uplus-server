package com.tianyaleixiaolin.uplusserver.core.product.template.prepay;

import com.tianyaleixiaolin.uplusserver.core.product.template.BaseTemplate;

import javax.persistence.Entity;

/**
 * 押金垫付模板
 * @author Mr.li wrote on 2018/12/4.
 */
@Entity
public class PtPrePayTemplate extends BaseTemplate {
    /**
     * 产品ID
     */
    private Long productId;
    /**
     * 预约电话
     */
    private String bookMobile;
    /**
     * 疾病类型(意外1、疾病2、重疾3)
     */
    private Integer sickType;
    /**
     * 具体疾病名称
     */
    private String sickName;
    /**
     * 所在地区省市县
     */
    private String province;
    private String city;
    private String country;
    /**
     * 期望就医省市县
     */
    private String wantProvince;
    private String wantCity;
    private String wantCountry;

    private String sheBaoProvince;
    private String sheBaoCity;
    private String sheBaoCountry;
    /**
     * 医院id
     */
    private Long hospitalId;
    /**
     * 一级科室。从字典表里选，填入dKey
     */
    private String dept1;
    /**
     * 二级科室。从字典表里选，填入dKey
     */
    private String dept2;
    /**
     * 选择医院后，查询该医院的所有医生，填入ID
     */
    private Long doctorId;
    /**
     * 住院状态，1已住院，2未确认住院，3有住院单未住院。group=12
     */
    private Integer enterHospitalState;
    /**
     * 入院时间
     */
    private String enterHospitalTime;
    /**
     * 已交费用
     */
    private Integer payMoney;
    /**
     * 催缴费用
     */
    private Integer needMoney;
    /**
     * 社保状态，group=13
     */
    private String sheBaoState;
    /**
     * 社保直结
     */
    private Boolean sheBaoPay;
    /**
     * 新农合盖章
     */
    private Boolean nongHeSign;
    /**
     * 备注
     */
    private String remark;

    @Override
    public String toString() {
        return "PtPrePayTemplate{" +
                "productId=" + productId +
                ", bookMobile='" + bookMobile + '\'' +
                ", sickType=" + sickType +
                ", sickName='" + sickName + '\'' +
                ", province='" + province + '\'' +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                ", wantProvince='" + wantProvince + '\'' +
                ", wantCity='" + wantCity + '\'' +
                ", wantCountry='" + wantCountry + '\'' +
                ", sheBaoProvince='" + sheBaoProvince + '\'' +
                ", sheBaoCity='" + sheBaoCity + '\'' +
                ", sheBaoCountry='" + sheBaoCountry + '\'' +
                ", hospitalId=" + hospitalId +
                ", dept1='" + dept1 + '\'' +
                ", dept2='" + dept2 + '\'' +
                ", doctorId=" + doctorId +
                ", enterHospitalState=" + enterHospitalState +
                ", enterHospitalTime='" + enterHospitalTime + '\'' +
                ", payMoney=" + payMoney +
                ", needMoney=" + needMoney +
                ", sheBaoState='" + sheBaoState + '\'' +
                ", sheBaoPay=" + sheBaoPay +
                ", nongHeSign=" + nongHeSign +
                ", remark='" + remark + '\'' +
                '}';
    }

    public Integer getSickType() {
        return sickType;
    }

    public void setSickType(Integer sickType) {
        this.sickType = sickType;
    }

    public String getSickName() {
        return sickName;
    }

    public void setSickName(String sickName) {
        this.sickName = sickName;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getBookMobile() {
        return bookMobile;
    }

    public void setBookMobile(String bookMobile) {
        this.bookMobile = bookMobile;
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

    public String getSheBaoProvince() {
        return sheBaoProvince;
    }

    public void setSheBaoProvince(String sheBaoProvince) {
        this.sheBaoProvince = sheBaoProvince;
    }

    public String getSheBaoCity() {
        return sheBaoCity;
    }

    public void setSheBaoCity(String sheBaoCity) {
        this.sheBaoCity = sheBaoCity;
    }

    public String getSheBaoCountry() {
        return sheBaoCountry;
    }

    public void setSheBaoCountry(String sheBaoCountry) {
        this.sheBaoCountry = sheBaoCountry;
    }

    public Long getHospitalId() {
        return hospitalId;
    }

    public void setHospitalId(Long hospitalId) {
        this.hospitalId = hospitalId;
    }

    public String getDept1() {
        return dept1;
    }

    public void setDept1(String dept1) {
        this.dept1 = dept1;
    }

    public String getDept2() {
        return dept2;
    }

    public void setDept2(String dept2) {
        this.dept2 = dept2;
    }

    public Long getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Long doctorId) {
        this.doctorId = doctorId;
    }

    public Integer getEnterHospitalState() {
        return enterHospitalState;
    }

    public void setEnterHospitalState(Integer enterHospitalState) {
        this.enterHospitalState = enterHospitalState;
    }

    public String getEnterHospitalTime() {
        return enterHospitalTime;
    }

    public void setEnterHospitalTime(String enterHospitalTime) {
        this.enterHospitalTime = enterHospitalTime;
    }

    public Integer getPayMoney() {
        return payMoney;
    }

    public void setPayMoney(Integer payMoney) {
        this.payMoney = payMoney;
    }

    public Integer getNeedMoney() {
        return needMoney;
    }

    public void setNeedMoney(Integer needMoney) {
        this.needMoney = needMoney;
    }

    public String getSheBaoState() {
        return sheBaoState;
    }

    public void setSheBaoState(String sheBaoState) {
        this.sheBaoState = sheBaoState;
    }

    public Boolean getSheBaoPay() {
        return sheBaoPay;
    }

    public void setSheBaoPay(Boolean sheBaoPay) {
        this.sheBaoPay = sheBaoPay;
    }

    public Boolean getNongHeSign() {
        return nongHeSign;
    }

    public void setNongHeSign(Boolean nongHeSign) {
        this.nongHeSign = nongHeSign;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
