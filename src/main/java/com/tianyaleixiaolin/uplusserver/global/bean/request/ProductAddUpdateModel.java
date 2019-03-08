package com.tianyaleixiaolin.uplusserver.global.bean.request;

import com.tianyaleixiaolin.uplusserver.core.product.PtProduct;
import com.tianyaleixiaolin.uplusserver.core.product.define.PtProductDefineSetting;

/**
 * @author Mr.li wrote on 2018/12/3.
 */
public class ProductAddUpdateModel {
    private PtProduct product;
    private PtProductDefineSetting productDefineSetting;
    //private List<PtOrderSendSetting> orderSendSettings;

    @Override
    public String toString() {
        return "ProductVO{" +
                "product=" + product +
                ", productDefineSetting=" + productDefineSetting +
                //", orderSendSettings=" + orderSendSettings +
                '}';
    }

    public PtProduct getProduct() {
        return product;
    }

    public void setProduct(PtProduct product) {
        this.product = product;
    }

    public PtProductDefineSetting getProductDefineSetting() {
        return productDefineSetting;
    }

    public void setProductDefineSetting(PtProductDefineSetting productDefineSetting) {
        this.productDefineSetting = productDefineSetting;
    }

    //public List<PtOrderSendSetting> getOrderSendSettings() {
    //    return orderSendSettings;
    //}
    //
    //public void setOrderSendSettings(List<PtOrderSendSetting> orderSendSettings) {
    //    this.orderSendSettings = orderSendSettings;
    //}
}
