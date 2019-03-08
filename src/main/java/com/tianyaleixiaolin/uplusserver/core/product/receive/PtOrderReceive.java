package com.tianyaleixiaolin.uplusserver.core.product.receive;

import com.tianyaleixiaolin.uplusserver.core.base.BaseEntity;

import javax.persistence.Entity;

/**
 * 抢单
 *
 * @author Mr.li wrote on 2018/11/16.
 */
@Entity
public class PtOrderReceive extends BaseEntity {

    private Long productOrderId;
    private String province;
    private String city;
    private String country;
    /**
     * 已通知的人
     */
    private String personIds;

    @Override
    public String toString() {
        return "PtOrderReceive{" +
                "productOrderId=" + productOrderId +
                ", province='" + province + '\'' +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                ", personIds='" + personIds + '\'' +
                '}';
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Long getProductOrderId() {
        return productOrderId;
    }

    public void setProductOrderId(Long productOrderId) {
        this.productOrderId = productOrderId;
    }

    public String getPersonIds() {
        return personIds;
    }

    public void setPersonIds(String personIds) {
        this.personIds = personIds;
    }
}
