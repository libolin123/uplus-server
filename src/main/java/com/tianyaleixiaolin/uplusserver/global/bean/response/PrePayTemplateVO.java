package com.tianyaleixiaolin.uplusserver.global.bean.response;

/**
 * @author Mr.li wrote on 2018/12/17.
 */
public class PrePayTemplateVO {
    private Long id;
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
    /**
     * TODO
     */
    private String provinceValue;
    private String city;
    private String cityValue;
    private String country;
    private String countryValue;
    /**
     * 期望就医省市县
     */
    private String wantProvince;
    /**
     * TODO
     */
    private String wantProvinceValue;
    private String wantCity;
    private String wantCityValue;
    private String wantCountry;
    private String wantCountryValue;

    private String sheBaoProvince;
    /**
     * TODO
     */
    private String sheBaoProvinceValue;
    private String sheBaoCity;
    private String sheBaoCityValue;
    private String sheBaoCountry;
    private String sheBaoCountryValue;
    /**
     * 医院id
     */
    private Long hospitalId;
    /**
     * TODO 医院名字
     */
    private String hospitalName;
    /**
     * 一级科室。从字典表里选，填入dKey
     */
    private String dept1;
    /**
     * TODO
     */
    private String dept1Value;
    /**
     * 二级科室。从字典表里选，填入dKey
     */
    private String dept2;
    /**
     * TODO
     */
    private String dept2Value;
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
     * TODO
     */
    private String sheBaoStateValue;
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
        return "PrePayTemplateVO{" +
                "id=" + id +
                ", productId=" + productId +
                ", bookMobile='" + bookMobile + '\'' +
                ", sickType=" + sickType +
                ", sickName='" + sickName + '\'' +
                ", province='" + province + '\'' +
                ", provinceValue='" + provinceValue + '\'' +
                ", city='" + city + '\'' +
                ", cityValue='" + cityValue + '\'' +
                ", country='" + country + '\'' +
                ", countryValue='" + countryValue + '\'' +
                ", wantProvince='" + wantProvince + '\'' +
                ", wantProvinceValue='" + wantProvinceValue + '\'' +
                ", wantCity='" + wantCity + '\'' +
                ", wantCityValue='" + wantCityValue + '\'' +
                ", wantCountry='" + wantCountry + '\'' +
                ", wantCountryValue='" + wantCountryValue + '\'' +
                ", sheBaoProvince='" + sheBaoProvince + '\'' +
                ", sheBaoProvinceValue='" + sheBaoProvinceValue + '\'' +
                ", sheBaoCity='" + sheBaoCity + '\'' +
                ", sheBaoCityValue='" + sheBaoCityValue + '\'' +
                ", sheBaoCountry='" + sheBaoCountry + '\'' +
                ", sheBaoCountryValue='" + sheBaoCountryValue + '\'' +
                ", hospitalId=" + hospitalId +
                ", hospitalName='" + hospitalName + '\'' +
                ", dept1='" + dept1 + '\'' +
                ", dept1Value='" + dept1Value + '\'' +
                ", dept2='" + dept2 + '\'' +
                ", dept2Value='" + dept2Value + '\'' +
                ", doctorId=" + doctorId +
                ", enterHospitalState=" + enterHospitalState +
                ", enterHospitalTime='" + enterHospitalTime + '\'' +
                ", payMoney=" + payMoney +
                ", needMoney=" + needMoney +
                ", sheBaoState='" + sheBaoState + '\'' +
                ", sheBaoStateValue='" + sheBaoStateValue + '\'' +
                ", sheBaoPay=" + sheBaoPay +
                ", nongHeSign=" + nongHeSign +
                ", remark='" + remark + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getProvinceValue() {
        return provinceValue;
    }

    public void setProvinceValue(String provinceValue) {
        this.provinceValue = provinceValue;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCityValue() {
        return cityValue;
    }

    public void setCityValue(String cityValue) {
        this.cityValue = cityValue;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCountryValue() {
        return countryValue;
    }

    public void setCountryValue(String countryValue) {
        this.countryValue = countryValue;
    }

    public String getWantProvince() {
        return wantProvince;
    }

    public void setWantProvince(String wantProvince) {
        this.wantProvince = wantProvince;
    }

    public String getWantProvinceValue() {
        return wantProvinceValue;
    }

    public void setWantProvinceValue(String wantProvinceValue) {
        this.wantProvinceValue = wantProvinceValue;
    }

    public String getWantCity() {
        return wantCity;
    }

    public void setWantCity(String wantCity) {
        this.wantCity = wantCity;
    }

    public String getWantCityValue() {
        return wantCityValue;
    }

    public void setWantCityValue(String wantCityValue) {
        this.wantCityValue = wantCityValue;
    }

    public String getWantCountry() {
        return wantCountry;
    }

    public void setWantCountry(String wantCountry) {
        this.wantCountry = wantCountry;
    }

    public String getWantCountryValue() {
        return wantCountryValue;
    }

    public void setWantCountryValue(String wantCountryValue) {
        this.wantCountryValue = wantCountryValue;
    }

    public String getSheBaoProvince() {
        return sheBaoProvince;
    }

    public void setSheBaoProvince(String sheBaoProvince) {
        this.sheBaoProvince = sheBaoProvince;
    }

    public String getSheBaoProvinceValue() {
        return sheBaoProvinceValue;
    }

    public void setSheBaoProvinceValue(String sheBaoProvinceValue) {
        this.sheBaoProvinceValue = sheBaoProvinceValue;
    }

    public String getSheBaoCity() {
        return sheBaoCity;
    }

    public void setSheBaoCity(String sheBaoCity) {
        this.sheBaoCity = sheBaoCity;
    }

    public String getSheBaoCityValue() {
        return sheBaoCityValue;
    }

    public void setSheBaoCityValue(String sheBaoCityValue) {
        this.sheBaoCityValue = sheBaoCityValue;
    }

    public String getSheBaoCountry() {
        return sheBaoCountry;
    }

    public void setSheBaoCountry(String sheBaoCountry) {
        this.sheBaoCountry = sheBaoCountry;
    }

    public String getSheBaoCountryValue() {
        return sheBaoCountryValue;
    }

    public void setSheBaoCountryValue(String sheBaoCountryValue) {
        this.sheBaoCountryValue = sheBaoCountryValue;
    }

    public Long getHospitalId() {
        return hospitalId;
    }

    public void setHospitalId(Long hospitalId) {
        this.hospitalId = hospitalId;
    }

    public String getHospitalName() {
        return hospitalName;
    }

    public void setHospitalName(String hospitalName) {
        this.hospitalName = hospitalName;
    }

    public String getDept1() {
        return dept1;
    }

    public void setDept1(String dept1) {
        this.dept1 = dept1;
    }

    public String getDept1Value() {
        return dept1Value;
    }

    public void setDept1Value(String dept1Value) {
        this.dept1Value = dept1Value;
    }

    public String getDept2() {
        return dept2;
    }

    public void setDept2(String dept2) {
        this.dept2 = dept2;
    }

    public String getDept2Value() {
        return dept2Value;
    }

    public void setDept2Value(String dept2Value) {
        this.dept2Value = dept2Value;
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

    public String getSheBaoStateValue() {
        return sheBaoStateValue;
    }

    public void setSheBaoStateValue(String sheBaoStateValue) {
        this.sheBaoStateValue = sheBaoStateValue;
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
