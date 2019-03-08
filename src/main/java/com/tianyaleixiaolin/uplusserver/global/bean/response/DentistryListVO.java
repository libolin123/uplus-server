package com.tianyaleixiaolin.uplusserver.global.bean.response;

public class DentistryListVO {
    private Long id;
    private String name;
    /**
     *联系人
     */
    private String contactPerson;
    private String phone;
    /**
     * 分院数量
     */
    private Integer count;
    private Boolean deleteFlag;

    @Override
    public String toString() {
        return "DentistryListVO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", contactPerson='" + contactPerson + '\'' +
                ", phone='" + phone + '\'' +
                ", count=" + count +
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

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
