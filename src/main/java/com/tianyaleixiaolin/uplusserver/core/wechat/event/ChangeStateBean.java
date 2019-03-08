package com.tianyaleixiaolin.uplusserver.core.wechat.event;

/**
 * 订单状态变化
 * @author Mr.li wrote on 2019/1/21.
 */
public class ChangeStateBean {
    private String openId;
    //审核通过，审核失败
    private String statesMsg;
    // 提交押金垫付文件审核1，2；上传住院押金条审核3，4；出院结算明细审核5，6
    private String orderStatus;

    public ChangeStateBean() {
    }

    public ChangeStateBean(String openId, String statesMsg, String orderStatus) {
        this.openId = openId;
        this.statesMsg = statesMsg;
        this.orderStatus = orderStatus;
    }

    @Override
    public String toString() {
        return "ChangeStateBean{" +
                "openId='" + openId + '\'' +
                ", statesMsg='" + statesMsg + '\'' +
                ", orderStatus='" + orderStatus + '\'' +
                '}';
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getStatesMsg() {
        return statesMsg;
    }

    public void setStatesMsg(String statesMsg) {
        this.statesMsg = statesMsg;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }
}
