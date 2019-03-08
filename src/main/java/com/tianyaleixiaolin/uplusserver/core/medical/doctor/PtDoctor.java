package com.tianyaleixiaolin.uplusserver.core.medical.doctor;

import com.tianyaleixiaolin.uplusserver.core.base.BaseDeleteEntity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "pt_doctor")
public class PtDoctor extends BaseDeleteEntity {
    private String name;
    /**
     * 医院ID
     */
    private Long hospitalId;
    /**
     *科室
     */
    private String dept;
    /**
     * 一级科室,group=1
     */
    private String dept1;
    /**
     * 二级科室,group=2
     */
    private String dept2;

    private String province;
    private String city;
    private String country;
    private String phone;
    /**
     * 级别
     */
    private String level;
    /**
     * 头像
     */
    private String headIcon;
    /**
     * 简介
     */
    private String info;
    /**
     * 擅长
     */
    private String skill;
    private String remark;
    //***************1.1新增*************//
    /**
     * 是否优加医生
     */
    private Boolean youplusDoctor;
    /**
     * 身份证号
     */
    private String paper;
    /**
     * 身份证照片
     */
    private String paperPics;
    /**
     * 执业医师证
     */
    private String doctorPic;
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
        return "PtDoctor{" +
                "name='" + name + '\'' +
                ", hospitalId=" + hospitalId +
                ", dept='" + dept + '\'' +
                ", dept1='" + dept1 + '\'' +
                ", dept2='" + dept2 + '\'' +
                ", province='" + province + '\'' +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                ", phone='" + phone + '\'' +
                ", level='" + level + '\'' +
                ", headIcon='" + headIcon + '\'' +
                ", info='" + info + '\'' +
                ", skill='" + skill + '\'' +
                ", remark='" + remark + '\'' +
                ", youplusDoctor=" + youplusDoctor +
                ", paper='" + paper + '\'' +
                ", paperPics='" + paperPics + '\'' +
                ", doctorPic='" + doctorPic + '\'' +
                ", bank='" + bank + '\'' +
                ", bankCardNum='" + bankCardNum + '\'' +
                '}';
    }

    public Boolean getYouplusDoctor() {
        return youplusDoctor;
    }

    public void setYouplusDoctor(Boolean youplusDoctor) {
        this.youplusDoctor = youplusDoctor;
    }

    public String getPaper() {
        return paper;
    }

    public void setPaper(String paper) {
        this.paper = paper;
    }

    public String getPaperPics() {
        return paperPics;
    }

    public void setPaperPics(String paperPics) {
        this.paperPics = paperPics;
    }

    public String getDoctorPic() {
        return doctorPic;
    }

    public void setDoctorPic(String doctorPic) {
        this.doctorPic = doctorPic;
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

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getHospitalId() {
        return hospitalId;
    }

    public void setHospitalId(Long hospitalId) {
        this.hospitalId = hospitalId;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
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

    public String getHeadIcon() {
        return headIcon;
    }

    public void setHeadIcon(String headIcon) {
        this.headIcon = headIcon;
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
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

}
