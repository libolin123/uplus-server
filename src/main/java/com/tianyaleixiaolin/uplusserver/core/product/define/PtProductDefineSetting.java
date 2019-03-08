package com.tianyaleixiaolin.uplusserver.core.product.define;

import com.tianyaleixiaolin.uplusserver.core.base.BaseEntity;

import javax.persistence.Entity;

/**
 * 产品定义设置
 *
 * @author Mr.li wrote on 2018/11/16.
 */
@Entity
public class PtProductDefineSetting extends BaseEntity {
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
     * 沟通提示文案
     */
    private String remark;
    /**
     * 样本文件
     */
    private String sampleFile;

    private Long productId;

    @Override
    public String toString() {
        return "PtProductDefineSetting{" +
                "cityCodes='" + cityCodes + '\'' +
                ", serverTimes=" + serverTimes +
                ", waitMonths=" + waitMonths +
                ", remark='" + remark + '\'' +
                ", sampleFile='" + sampleFile + '\'' +
                ", productId=" + productId +
                '}';
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

    public String getSampleFile() {
        return sampleFile;
    }

    public void setSampleFile(String sampleFile) {
        this.sampleFile = sampleFile;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }
}
