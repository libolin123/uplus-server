package com.tianyaleixiaolin.uplusserver.core.user.role;


import com.tianyaleixiaolin.uplusserver.core.base.BaseDeleteEntity;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author Mr.li wrote on 2018/10/25.
 * 角色表
 */
@Entity
@Table(name = "pt_role")
public class PtRole extends BaseDeleteEntity {

    /**
     * 角色名（admin，level1，level2，level3）
     */
    private String name;
    /**
     * 角色描述（超级管理员，1级客户，2级客户，3级客户）
     */
    private String sign;
    /**
     * 状态，（0正常，-1停用）
     */
    private Integer state;

    @Override
    public String toString() {
        return "PtRole{" +
                "name='" + name + '\'' +
                ", sign='" + sign + '\'' +
                ", state=" + state +
                '}';
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
