package com.tianyaleixiaolin.uplusserver.global.bean.request;

public class DentistryListQueryModel extends BaseModel {
    private String name;
    private String childName;

    @Override
    public String toString() {
        return "DentistryListQueryModel{" +
                "name='" + name + '\'' +
                ", childName='" + childName + '\'' +
                '}';
    }

    public String getChildName() {
        return childName;
    }

    public void setChildName(String childName) {
        this.childName = childName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
