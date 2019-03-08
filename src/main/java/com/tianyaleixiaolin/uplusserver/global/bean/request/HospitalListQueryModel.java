package com.tianyaleixiaolin.uplusserver.global.bean.request;

public class HospitalListQueryModel extends BaseModel {
    private String name;
    private String level;
    private String province;
    private String city;
    private String country;

    @Override
    public String toString() {
        return "HospitalListQueryModel{" +
                "name='" + name + '\'' +
                ", level='" + level + '\'' +
                ", province='" + province + '\'' +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
}
