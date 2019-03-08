package com.tianyaleixiaolin.uplusserver.global.bean.response;

/**
 * @author Mr.li wrote on 2018/12/20.
 */
public class ChinaMedChildVO {
    private Long id;
    private Long chinaMedId;
    private String name;
    /**
     * 联系人
     */
    private String contactPerson;
    private String province;
    private String provinceValue;
    private String city;
    private String cityValue;
    private String country;
    private String countryValue;

    private String address;

    private String workTime;

    private String phone;

    private Boolean deleteFlag;

    @Override
    public String toString() {
        return "ChinaMedChildVO{" +
                "id=" + id +
                ", chinaMedId=" + chinaMedId +
                ", name='" + name + '\'' +
                ", contactPerson='" + contactPerson + '\'' +
                ", province='" + province + '\'' +
                ", provinceValue='" + provinceValue + '\'' +
                ", city='" + city + '\'' +
                ", cityValue='" + cityValue + '\'' +
                ", country='" + country + '\'' +
                ", countryValue='" + countryValue + '\'' +
                ", address='" + address + '\'' +
                ", workTime='" + workTime + '\'' +
                ", phone='" + phone + '\'' +
                ", deleteFlag=" + deleteFlag +
                '}';
    }

    public Boolean getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(Boolean deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getChinaMedId() {
        return chinaMedId;
    }

    public void setChinaMedId(Long chinaMedId) {
        this.chinaMedId = chinaMedId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContactPerson() {
        return contactPerson;
    }

    public void setContactPerson(String contactPerson) {
        this.contactPerson = contactPerson;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getWorkTime() {
        return workTime;
    }

    public void setWorkTime(String workTime) {
        this.workTime = workTime;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
