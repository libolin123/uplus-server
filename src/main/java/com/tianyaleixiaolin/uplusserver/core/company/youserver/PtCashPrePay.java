package com.tianyaleixiaolin.uplusserver.core.company.youserver;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.tianyaleixiaolin.uplusserver.core.base.BaseEntity;

import javax.persistence.Entity;

/**
 * 优加服务，押金垫付
 * @author libolin wrote on 2018/11/16.
 */
@Entity
@JsonIgnoreProperties(value = {"hibernateLazyInitializer"})
public class PtCashPrePay extends BaseEntity {
    /**
     * 城市code的集合，用逗号分隔。如果不限，里面传-1
     */
    private String cityCodes;
    /**
     * 服务次数，-1为不限
     */
    private Integer serverTimes;
    /**
     * 等待期，-1为无
     */
    private Integer waitMonths;
    /**
     * 备注
     */
    private String remark;
    /**
     * 携带文件，也是逗号分隔
     */
    private String filePaths;
    /**
     * 携带信息  [{name: '', link: ''}, {}]
     */
    private String carryInfoList;

    private Long goodsId;

    public String getCarryInfoList() {
        return carryInfoList;
    }

    public void setCarryInfoList(String carryInfoList) {
        this.carryInfoList = carryInfoList;
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

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getFilePaths() {
        return filePaths;
    }

    public void setFilePaths(String filePaths) {
        this.filePaths = filePaths;
    }
}
