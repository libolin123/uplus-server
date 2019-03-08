package com.tianyaleixiaolin.uplusserver.core.wechat.event;

/**
 * @author Mr.li wrote on 2019/1/21.
 */
public class NewOrderBean {
    //订单号
    private String orderNumber;
    //微信id
    private String openId;
    //客户姓名
    private String userName;
    //服务类型:押金垫付
    private String serviceName;
    //客户电话
    private String userPhone;

    public NewOrderBean() {
    }

    public NewOrderBean(String orderNumber, String openId, String userName, String serviceName, String userPhone) {
        this.orderNumber = orderNumber;
        this.openId = openId;
        this.userName = userName;
        this.serviceName = serviceName;
        this.userPhone = userPhone;
    }

    @Override
    public String toString() {
        return "NewOrderBean{" +
                "orderNumber='" + orderNumber + '\'' +
                ", openId='" + openId + '\'' +
                ", userName='" + userName + '\'' +
                ", serviceName='" + serviceName + '\'' +
                ", userPhone='" + userPhone + '\'' +
                '}';
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }
}
