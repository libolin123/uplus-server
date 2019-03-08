package com.tianyaleixiaolin.uplusserver.core.dict;


import com.tianyaleixiaolin.uplusserver.core.base.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author Mr.li wrote on 2018/11/1.
 */
@Entity
@Table(name = "pt_dict")
public class PtDict extends BaseEntity {
    private int groupId;
    /**
     * 父级groupID
     */
    private String parentKey;
    private int sortId;
    private String dKey;
    private String dValue;
    private String dDescribe;

    @Override
    public String toString() {
        return "PtDict{" +
                "groupId=" + groupId +
                ", parentKey=" + parentKey +
                ", sortId=" + sortId +
                ", dKey='" + dKey + '\'' +
                ", dValue='" + dValue + '\'' +
                ", dDescribe='" + dDescribe + '\'' +
                '}';
    }

    public String getParentKey() {
        return parentKey;
    }

    public void setParentKey(String parentKey) {
        this.parentKey = parentKey;
    }

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public int getSortId() {
        return sortId;
    }

    public void setSortId(int sortId) {
        this.sortId = sortId;
    }

    public String getdKey() {
        return dKey;
    }

    public void setdKey(String dKey) {
        this.dKey = dKey;
    }

    public String getdValue() {
        return dValue;
    }

    public void setdValue(String dValue) {
        this.dValue = dValue;
    }

    public String getdDescribe() {
        return dDescribe;
    }

    public void setdDescribe(String dDescribe) {
        this.dDescribe = dDescribe;
    }
}
