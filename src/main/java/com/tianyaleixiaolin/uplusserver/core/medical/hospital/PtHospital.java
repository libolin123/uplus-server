package com.tianyaleixiaolin.uplusserver.core.medical.hospital;

import com.tianyaleixiaolin.uplusserver.core.base.BaseDeleteEntity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "pt_hospital")
public class PtHospital extends BaseDeleteEntity {
    private String name;
    /**
     *别名
     */
    private String otherName;
    /**
     * 医院类型（公立、私立）group=10
     */
    private String type;
    /**
     * 三甲二甲group=3
     */
    private String level;
    private String province;
    private String city;
    private String country;
    private String phone;
    private String address;
    /**
     * 简介
     */
    private String info;
    private String remark;
    /**
     * 社保
     */
    private Boolean shebao;

    //***************1.1新增*************//
    /**
     * 直付
     */
    private Boolean zhifu;
    /**
     * 免押
     */
    private Boolean mianya;
    /**
     * 对公转账
     */
    private Boolean publicTrans;
    /**
     * 结算周期。1月结，2七天结，3出院结
     */
    private Integer zhouqi;
    /**
     * 银行
     */
    private String bank;
    /**
     * 银行卡号
     */
    private String bankCardNum;

    @Override
    public String toString() {
        return "PtHospital{" +
                "name='" + name + '\'' +
                ", otherName='" + otherName + '\'' +
                ", type='" + type + '\'' +
                ", level='" + level + '\'' +
                ", province='" + province + '\'' +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", info='" + info + '\'' +
                ", remark='" + remark + '\'' +
                ", shebao=" + shebao +
                ", zhifu=" + zhifu +
                ", mianya=" + mianya +
                ", publicTrans=" + publicTrans +
                ", zhouqi=" + zhouqi +
                ", bank='" + bank + '\'' +
                ", bankCardNum='" + bankCardNum + '\'' +
                '}';
    }

    public Boolean getZhifu() {
        return zhifu;
    }

    public void setZhifu(Boolean zhifu) {
        this.zhifu = zhifu;
    }

    public Boolean getMianya() {
        return mianya;
    }

    public void setMianya(Boolean mianya) {
        this.mianya = mianya;
    }

    public Boolean getPublicTrans() {
        return publicTrans;
    }

    public void setPublicTrans(Boolean publicTrans) {
        this.publicTrans = publicTrans;
    }

    public Integer getZhouqi() {
        return zhouqi;
    }

    public void setZhouqi(Integer zhouqi) {
        this.zhouqi = zhouqi;
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    public String getBankCardNum() {
        return bankCardNum;
    }

    public void setBankCardNum(String bankCardNum) {
        this.bankCardNum = bankCardNum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOtherName() {
        return otherName;
    }

    public void setOtherName(String otherName) {
        this.otherName = otherName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Boolean getShebao() {
        return shebao;
    }

    public void setShebao(Boolean shebao) {
        this.shebao = shebao;
    }
}
