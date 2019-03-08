package com.tianyaleixiaolin.uplusserver.global.bean.response;

import java.util.Date;

/**
 * @author Mr.li wrote on 2018/11/20.
 */
public class GoodsTempListVO {
    private Long id;
    /**
     * 对应的商品id
     */
    private Long goodsId;
    /**
     * 商品名称
     */
    private String name;
    /**
     * 计划的名字//TODO
     */
    private String ptGoodsPlanName;
    /**
     * 商品生效时间
     */
    private Date updateTime;
    /**
     * 原因
     */
    private String reason;
    /**
     * 修改人姓名//TODO
     */
    private String operatorName;
    /**
     * 状态（-1待审核，0正常，-2被拒绝）
     */
    private Integer status;
    /**
     * 操作类型（新建，修改，下架）
     */
    private String operatorType;

    @Override
    public String toString() {
        return "GoodsTempListVO{" +
                "id=" + id +
                ", goodsId=" + goodsId +
                ", name='" + name + '\'' +
                ", ptGoodsPlanName='" + ptGoodsPlanName + '\'' +
                ", updateTime=" + updateTime +
                ", reason='" + reason + '\'' +
                ", operatorName='" + operatorName + '\'' +
                ", status=" + status +
                ", operatorType='" + operatorType + '\'' +
                '}';
    }

    public String getPtGoodsPlanName() {
        return ptGoodsPlanName;
    }

    public void setPtGoodsPlanName(String ptGoodsPlanName) {
        this.ptGoodsPlanName = ptGoodsPlanName;
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

    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getOperatorName() {
        return operatorName;
    }

    public void setOperatorName(String operatorName) {
        this.operatorName = operatorName;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getOperatorType() {
        return operatorType;
    }

    public void setOperatorType(String operatorType) {
        this.operatorType = operatorType;
    }
}
