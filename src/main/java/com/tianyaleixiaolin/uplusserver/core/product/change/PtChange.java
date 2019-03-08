package com.tianyaleixiaolin.uplusserver.core.product.change;

import com.tianyaleixiaolin.uplusserver.core.base.BaseEntity;

import javax.persistence.Entity;

/**
 * 转单
 * @author Mr.li wrote on 2018/12/4.
 */
@Entity
public class PtChange extends BaseEntity {
    /**
     * 对应的服务单ID
     */
    private Long orderId;
    /**
     * 地勤人员
     */
    private Long oldPersonId;
    /**
     * 转给谁
     */
    private Long newPersonId;


    @Override
    public String toString() {
        return "PtChange{" +
                "orderId=" + orderId +
                ", oldPersonId=" + oldPersonId +
                ", newPersonId=" + newPersonId +
                '}';
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getOldPersonId() {
        return oldPersonId;
    }

    public void setOldPersonId(Long oldPersonId) {
        this.oldPersonId = oldPersonId;
    }

    public Long getNewPersonId() {
        return newPersonId;
    }

    public void setNewPersonId(Long newPersonId) {
        this.newPersonId = newPersonId;
    }
}
