package com.tianyaleixiaolin.uplusserver.core.company.youserver;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.tianyaleixiaolin.uplusserver.core.base.BaseEntity;

import javax.persistence.Entity;

/**
 * 优加服务，电话医生
 * @author libolin wrote on 2018/11/16.
 */
@Entity
@JsonIgnoreProperties(value = {"hibernateLazyInitializer"})
public class PtPhoneDoctor extends BaseEntity {
    /**
     * 城市code的集合，用逗号分隔。如果不限，里面传-1
     */
    private String cityCodes;
    /**
     * 服务次数，-1为不限
     */
    private Integer serverTimes;
    /**
     * 单次时长
     */
    private Integer singleDuration;
    /**
     * 自费购买,-1为不是自费
     */
    private Integer selfPay;
    /**
     * 等待期
     */
    private Integer waitMonths;

    private Long goodsId;

    @Override
    public String toString() {
        return "PtPhoneDoctor{" +
                "cityCodes='" + cityCodes + '\'' +
                ", serverTimes=" + serverTimes +
                ", singleDuration=" + singleDuration +
                ", selfPay=" + selfPay +
                ", waitMonths=" + waitMonths +
                ", goodsId=" + goodsId +
                '}';
    }

    public Integer getSingleDuration() {
        return singleDuration;
    }

    public void setSingleDuration(Integer singleDuration) {
        this.singleDuration = singleDuration;
    }

    public Integer getSelfPay() {
        return selfPay;
    }

    public void setSelfPay(Integer selfPay) {
        this.selfPay = selfPay;
    }

    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    public String getCityCodes() {
        return cityCodes;
    }

    public void setCityCodes(String cityCodes) {
        this.cityCodes = cityCodes;
    }

    public Integer getServerTimes() {
        return serverTimes;
    }

    public void setServerTimes(Integer serverTimes) {
        this.serverTimes = serverTimes;
    }

    public Integer getWaitMonths() {
        return waitMonths;
    }

    public void setWaitMonths(Integer waitMonths) {
        this.waitMonths = waitMonths;
    }
}
