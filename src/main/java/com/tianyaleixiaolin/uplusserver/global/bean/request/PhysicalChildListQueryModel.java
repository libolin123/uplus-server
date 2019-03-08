package com.tianyaleixiaolin.uplusserver.global.bean.request;

public class PhysicalChildListQueryModel extends BaseModel {
    private String name;
    private String province;
    private String city;
    private String country;
    private Long physicalId;

    @Override
    public String toString() {
        return "PhysicalChildListQueryModel{" +
                "name='" + name + '\'' +
                ", province='" + province + '\'' +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                ", physicalId=" + physicalId +
                '}';
    }

    public Long getPhysicalId() {
        return physicalId;
    }

    public void setPhysicalId(Long physicalId) {
        this.physicalId = physicalId;
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
