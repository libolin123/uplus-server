package com.tianyaleixiaolin.uplusserver.core.product.ordersend;

import com.tianyaleixiaolin.uplusserver.core.base.BaseEntity;

import javax.persistence.Entity;

/**
 * 产品派单设置。设置派单时需要填写哪些选项
 *
 * @author Mr.li wrote on 2018/11/16.
 */
@Entity
public class PtOrderSendSetting extends BaseEntity {
    /**
     * 名称
     */
    private String name;
    /**
     * 类型(group=11,字段的类型，选择框、字符输入框)
     */
    private String type;
    /**
     * 排序，从小到大
     */
    private int sort;
    /**
     * 是否是必须的
     */
    private boolean necessary;

    private Long productId;

    @Override
    public String toString() {
        return "PtOrderSendSetting{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", sort=" + sort +
                ", necessary=" + necessary +
                ", productId=" + productId +
                '}';
    }

    public boolean isNecessary() {
        return necessary;
    }

    public void setNecessary(boolean necessary) {
        this.necessary = necessary;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getSort() {
        return sort;
    }

    public void setSort(int sort) {
        this.sort = sort;
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
}
