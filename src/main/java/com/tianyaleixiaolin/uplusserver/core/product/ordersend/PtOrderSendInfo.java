package com.tianyaleixiaolin.uplusserver.core.product.ordersend;

import com.tianyaleixiaolin.uplusserver.core.base.BaseEntity;

import javax.persistence.Entity;

/**
 * 产品派单设置的信息，即服务预约信息，分别对应每一项的值
 *
 * @author Mr.li wrote on 2018/11/16.
 */
@Entity
public class PtOrderSendInfo extends BaseEntity {
    /**
     * 名称
     */
    private String info;
    /**
     * 对应的派单设置的项
     */
    private Long orderSendSettingId;

    @Override
    public String toString() {
        return "PtOrderSendInfo{" +
                "info='" + info + '\'' +
                ", orderSendSettingId=" + orderSendSettingId +
                '}';
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public Long getOrderSendSettingId() {
        return orderSendSettingId;
    }

    public void setOrderSendSettingId(Long orderSendSettingId) {
        this.orderSendSettingId = orderSendSettingId;
    }
}
