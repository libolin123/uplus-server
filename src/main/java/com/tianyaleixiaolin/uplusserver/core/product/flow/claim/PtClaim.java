package com.tianyaleixiaolin.uplusserver.core.product.flow.claim;

import com.tianyaleixiaolin.uplusserver.core.base.BaseEntity;

import javax.persistence.Entity;

/**
 * 订单流程的理赔
 * @author Mr.li wrote on 2018/12/3.
 */
@Entity
public class PtClaim extends BaseEntity {
    private Long productOrderId;
    private Long orderFlowId;
    /**
     * 垫付时间，首次垫付、二次垫付、逗号分隔
     */
    private String prePayTimes;
    /**
     * 总垫付金额
     */
    private Double totalMoney;
    /**
     * 退费金额
     */
    private Double backMoney;
    /**
     * 实际垫付
     */
    private Double realPayMoney;
    /**
     * 理赔金额
     */
    private Double compensateMoney;
    /**
     * 应追缴
     */
    private Double needMoney;

    @Override
    public String toString() {
        return "PtClaim{" +
                "productOrderId=" + productOrderId +
                ", orderFlowId=" + orderFlowId +
                ", prePayTimes='" + prePayTimes + '\'' +
                ", totalMoney=" + totalMoney +
                ", backMoney=" + backMoney +
                ", realPayMoney=" + realPayMoney +
                ", compensateMoney=" + compensateMoney +
                ", needMoney=" + needMoney +
                '}';
    }

    public Long getProductOrderId() {
        return productOrderId;
    }

    public void setProductOrderId(Long productOrderId) {
        this.productOrderId = productOrderId;
    }

    public Long getOrderFlowId() {
        return orderFlowId;
    }

    public void setOrderFlowId(Long orderFlowId) {
        this.orderFlowId = orderFlowId;
    }

    public String getPrePayTimes() {
        return prePayTimes;
    }

    public void setPrePayTimes(String prePayTimes) {
        this.prePayTimes = prePayTimes;
    }

    public Double getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(Double totalMoney) {
        this.totalMoney = totalMoney;
    }

    public Double getBackMoney() {
        return backMoney;
    }

    public void setBackMoney(Double backMoney) {
        this.backMoney = backMoney;
    }

    public Double getRealPayMoney() {
        return realPayMoney;
    }

    public void setRealPayMoney(Double realPayMoney) {
        this.realPayMoney = realPayMoney;
    }

    public Double getCompensateMoney() {
        return compensateMoney;
    }

    public void setCompensateMoney(Double compensateMoney) {
        this.compensateMoney = compensateMoney;
    }

    public Double getNeedMoney() {
        return needMoney;
    }

    public void setNeedMoney(Double needMoney) {
        this.needMoney = needMoney;
    }
}
