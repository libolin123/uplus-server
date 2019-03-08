package com.tianyaleixiaolin.uplusserver.global.bean.request;

import com.tianyaleixiaolin.uplusserver.core.product.template.prepay.PtPrePayTemplate;

import javax.validation.constraints.NotNull;

/**
 * 派单功能
 * @author Mr.li wrote on 2018/12/10.
 */
public class ProductOrderAddModel {
    private Long id;

    /**
     * 对应的服务单ID
     */
    @NotNull(message = "服务单不能为空")
    private Long orderId;
    /**
     * 产品ID，如"押金垫付"
     */
    @NotNull(message = "产品不能为空")
    private Long productId;
    /**
     * 对应的模板ID,TODO
     */
    private Long templateId;
    /**
     * 服务预约信息
     */
    private PtPrePayTemplate template;

    @Override
    public String toString() {
        return "ProductOrderAddModel{" +
                "id=" + id +
                ", orderId=" + orderId +
                ", productId=" + productId +
                ", templateId=" + templateId +
                ", template=" + template +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Long getTemplateId() {
        return templateId;
    }

    public void setTemplateId(Long templateId) {
        this.templateId = templateId;
    }

    public PtPrePayTemplate getTemplate() {
        return template;
    }

    public void setTemplate(PtPrePayTemplate template) {
        this.template = template;
    }
}
