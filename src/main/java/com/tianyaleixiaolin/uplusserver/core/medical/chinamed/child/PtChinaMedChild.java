package com.tianyaleixiaolin.uplusserver.core.medical.chinamed.child;

import com.tianyaleixiaolin.uplusserver.core.base.BaseDeleteEntity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "pt_china_med_child")
public class PtChinaMedChild extends BaseDeleteEntity {
    @NotNull(message = "父级ID不能为空")
    private Long chinaMedId;
    @NotEmpty(message = "名字不能为空")
    private String name;
    /**
     *联系人
     */
    private String contactPerson;
    private String province;
    private String city;
    private String country;

    private String address;

    private String workTime;

    private String phone;

    @Override
    public String toString() {
        return "PtChinaMedChild{" +
                "chinaMedId=" + chinaMedId +
                ", name='" + name + '\'' +
                ", contactPerson='" + contactPerson + '\'' +
                ", province='" + province + '\'' +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                ", address='" + address + '\'' +
                ", workTime='" + workTime + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }

    public String getContactPerson() {
        return contactPerson;
    }

    public void setContactPerson(String contactPerson) {
        this.contactPerson = contactPerson;
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
