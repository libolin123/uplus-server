package com.tianyaleixiaolin.uplusserver.global.bean.request;

public class ChinaMedChildListQueryModel extends BaseModel {
    private String name;
    private String province;
    private String city;
    private String country;
    private Long chinaMedId;

    @Override
    public String toString() {
        return "ChinaMedChildListQueryModel{" +
                "name='" + name + '\'' +
                ", province='" + province + '\'' +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                ", chinaMedId=" + chinaMedId +
                '}';
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
