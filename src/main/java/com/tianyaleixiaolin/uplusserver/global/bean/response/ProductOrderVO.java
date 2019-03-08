package com.tianyaleixiaolin.uplusserver.global.bean.response;

import com.tianyaleixiaolin.uplusserver.core.product.flow.PtOrderFlow;

import java.util.List;

/**
 * @author Mr.li wrote on 2018/12/10.
 */
public class ProductOrderVO {
    private Long productId;
    private String productName;
    private Long groundPersonId;
    
    private OrderListVO orderListVO;

    private PrePayTemplateVO template;

    private GroundPersonListVO groundPersonListVO;

    private PtOrderFlow orderFlow;

    private List<String> personNames;

    @Override
    public String toString() {
        return "ProductOrderVO{" +
                "productId=" + productId +
                ", productName='" + productName + '\'' +
                ", groundPersonId=" + groundPersonId +
                ", orderListVO=" + orderListVO +
                ", template=" + template +
                ", groundPersonListVO=" + groundPersonListVO +
                ", orderFlow=" + orderFlow +
                '}';
    }

    public List<String> getPersonNames() {
        return personNames;
    }

    public void setPersonNames(List<String> personNames) {
        this.personNames = personNames;
    }

    public Long getGroundPersonId() {
        return groundPersonId;
    }

    public void setGroundPersonId(Long groundPersonId) {
        this.groundPersonId = groundPersonId;
    }

    public PtOrderFlow getOrderFlow() {
        return orderFlow;
    }

    public void setOrderFlow(PtOrderFlow orderFlow) {
        this.orderFlow = orderFlow;
    }

    public GroundPersonListVO getGroundPersonListVO() {
        return groundPersonListVO;
    }

    public void setGroundPersonListVO(GroundPersonListVO groundPersonListVO) {
        this.groundPersonListVO = groundPersonListVO;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public OrderListVO getOrderListVO() {
        return orderListVO;
    }

    public void setOrderListVO(OrderListVO orderListVO) {
        this.orderListVO = orderListVO;
    }

    public PrePayTemplateVO getTemplate() {
        return template;
    }

    public void setTemplate(PrePayTemplateVO template) {
        this.template = template;
    }
}
