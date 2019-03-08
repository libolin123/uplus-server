package com.tianyaleixiaolin.uplusserver.global.bean.request;

public class DentistryChildListQueryModel extends BaseModel {
    private String name;
    private String province;
    private String city;
    private String country;
    private Long dentistryId;

    @Override
    public String toString() {
        return "DentistryChildListQueryModel{" +
                "name='" + name + '\'' +
                ", province='" + province + '\'' +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                ", dentistryId=" + dentistryId +
                '}';
    }

    public Long getDentistryId() {
        return dentistryId;
    }

    public void setDentistryId(Long dentistryId) {
        this.dentistryId = dentistryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
}
