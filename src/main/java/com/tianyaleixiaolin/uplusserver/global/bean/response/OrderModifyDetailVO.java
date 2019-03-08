package com.tianyaleixiaolin.uplusserver.global.bean.response;

import com.tianyaleixiaolin.uplusserver.core.order.PtOrder;
import com.tianyaleixiaolin.uplusserver.core.order.PtOrderRelation;
import com.tianyaleixiaolin.uplusserver.core.order.PtOrderTemp;

/**
 * 订单和订单修改后
 * @author Mr.li wrote on 2018/11/15.
 */
public class OrderModifyDetailVO {
    private PtOrder orignal;
    /**
     * 修改过的
     */
    private PtOrderTemp modified;
    /**
     * 修改人
     */
    private String operatorName;
    private PtOrderRelation orderRelation;

    @Override
    public String toString() {
        return "OrderModifyDetailVO{" +
                "orignal=" + orignal +
                ", modified=" + modified +
                ", operatorName='" + operatorName + '\'' +
                ", orderRelation=" + orderRelation +
                '}';
    }

    public PtOrderRelation getOrderRelation() {
        return orderRelation;
    }

    public void setOrderRelation(PtOrderRelation orderRelation) {
        this.orderRelation = orderRelation;
    }

    public PtOrder getOrignal() {
        return orignal;
    }

    public void setOrignal(PtOrder orignal) {
        this.orignal = orignal;
    }

    public PtOrderTemp getModified() {
        return modified;
    }

    public void setModified(PtOrderTemp modified) {
        this.modified = modified;
    }

    public String getOperatorName() {
        return operatorName;
    }

    public void setOperatorName(String operatorName) {
        this.operatorName = operatorName;
    }
}
