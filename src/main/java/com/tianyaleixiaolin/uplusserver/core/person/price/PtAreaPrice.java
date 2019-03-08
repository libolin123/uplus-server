package com.tianyaleixiaolin.uplusserver.core.person.price;


import com.tianyaleixiaolin.uplusserver.core.base.BaseEntity;

import javax.persistence.Entity;

/**
 * @author Mr.li wrote on 2018/10/25.
 * 地勤，不同地区的价格
 */
@Entity
public class PtAreaPrice extends BaseEntity {

    /**
     * 地勤id
     */
    private String areaName;
    /**
     * 3次价格
     */
    private String threePrice;
    /**
     * 单次价格
     */
    private String singlePrice;

    @Override
    public String toString() {
        return "PtAreaPrice{" +
                "areaName='" + areaName + '\'' +
                ", threePrice='" + threePrice + '\'' +
                ", singlePrice='" + singlePrice + '\'' +
                '}';
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public String getThreePrice() {
        return threePrice;
    }

    public void setThreePrice(String threePrice) {
        this.threePrice = threePrice;
    }

    public String getSinglePrice() {
        return singlePrice;
    }

    public void setSinglePrice(String singlePrice) {
        this.singlePrice = singlePrice;
    }
}
