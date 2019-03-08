package com.tianyaleixiaolin.uplusserver.core.medical.chinamed;

import com.tianyaleixiaolin.uplusserver.core.base.BaseDeleteEntity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

/**
 * 中医
 */
@Entity
@Table(name = "pt_china_med")
public class PtChinaMed extends BaseDeleteEntity {
    @NotEmpty(message = "名字不能为空")
    private String name;
    /**
     *联系人
     */
    private String contactPerson;
    private String phone;

    @Override
    public String toString() {
        return "PtChinaMed{" +
                "name='" + name + '\'' +
                ", contactPerson='" + contactPerson + '\'' +
                ", phone='" + phone + '\'' +
                '}';
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
