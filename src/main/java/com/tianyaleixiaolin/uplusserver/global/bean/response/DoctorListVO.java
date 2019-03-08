package com.tianyaleixiaolin.uplusserver.global.bean.response;

/**
 * @author wuwf
 */
public class DoctorListVO {
    private Long id;
    /**
     * 医院ID
     */
    private Long hospitalId;
    /**
     * TODO
     */
    private String hospitalName;
    private String name;
    /**
     * 科室
     */
    private String dept;
    /**
     * 一级科室,group=1
     */
    private String dept1;
    /**
     * TODO
     */
    private String dept1Value;
    /**
     * 二级科室 ,group=2
     */
    private String dept2;
    /**
     * TODO
     */
    private String dept2Value;
    private String province;
    private String provinceValue;
    private String city;
    private String cityValue;
    private String country;
    private String countryValue;
    private String phone;
    /**
     * 职称
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
    //////////////////////////////////////////
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
        return "DoctorListVO{" +
                "id=" + id +
                ", hospitalId=" + hospitalId +
                ", hospitalName='" + hospitalName + '\'' +
                ", name='" + name + '\'' +
                ", dept='" + dept + '\'' +
                ", dept1='" + dept1 + '\'' +
                ", dept1Value='" + dept1Value + '\'' +
                ", dept2='" + dept2 + '\'' +
                ", dept2Value='" + dept2Value + '\'' +
                ", province='" + province + '\'' +
                ", provinceValue='" + provinceValue + '\'' +
                ", city='" + city + '\'' +
                ", cityValue='" + cityValue + '\'' +
                ", country='" + country + '\'' +
                ", countryValue='" + countryValue + '\'' +
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

    public String getDept1Value() {
        return dept1Value;
    }

    public void setDept1Value(String dept1Value) {
        this.dept1Value = dept1Value;
    }

    public String getDept2Value() {
        return dept2Value;
    }

    public void setDept2Value(String dept2Value) {
        this.dept2Value = dept2Value;
    }

    public String getProvinceValue() {
        return provinceValue;
    }

    public void setProvinceValue(String provinceValue) {
        this.provinceValue = provinceValue;
    }

    public String getCityValue() {
        return cityValue;
    }

    public void setCityValue(String cityValue) {
        this.cityValue = cityValue;
    }

    public String getCountryValue() {
        return countryValue;
    }

    public void setCountryValue(String countryValue) {
        this.countryValue = countryValue;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getHospitalName() {
        return hospitalName;
    }

    public void setHospitalName(String hospitalName) {
        this.hospitalName = hospitalName;
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

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getHeadIcon() {
        return headIcon;
    }

    public void setHeadIcon(String headIcon) {
        this.headIcon = headIcon;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
