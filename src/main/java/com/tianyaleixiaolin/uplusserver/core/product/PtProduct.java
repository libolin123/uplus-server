package com.tianyaleixiaolin.uplusserver.core.product;

import com.tianyaleixiaolin.uplusserver.core.base.BaseDeleteEntity;

import javax.persistence.Entity;

/**
 * 产品管理（押金垫付、xxx）
 *
 * @author Mr.li wrote on 2018/11/16.
 */
@Entity
public class PtProduct extends BaseDeleteEntity {
    /**
     * 名称
     */
    private String name;

    @Override
    public String toString() {
        return "PtProduct{" +
                "name='" + name + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
