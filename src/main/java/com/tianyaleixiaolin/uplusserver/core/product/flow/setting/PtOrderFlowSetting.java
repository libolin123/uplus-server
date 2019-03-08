package com.tianyaleixiaolin.uplusserver.core.product.flow.setting;

import com.tianyaleixiaolin.uplusserver.core.base.BaseEntity;

import javax.persistence.Entity;

/**
 * 订单流程设置
 * @author Mr.li wrote on 2018/12/3.
 */
@Entity
public class PtOrderFlowSetting extends BaseEntity {
    private String name;
    private int sort;

    private Long productId;

    @Override
    public String toString() {
        return "PtOrderFlowSetting{" +
                "name='" + name + '\'' +
                ", sort=" + sort +
                ", productId=" + productId +
                '}';
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSort() {
        return sort;
    }

    public void setSort(int sort) {
        this.sort = sort;
    }
}
