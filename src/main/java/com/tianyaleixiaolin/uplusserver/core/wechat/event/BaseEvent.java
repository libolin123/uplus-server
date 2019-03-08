package com.tianyaleixiaolin.uplusserver.core.wechat.event;

import org.springframework.context.ApplicationEvent;

/**
 * @author Mr.li wrote on 2019/2/27.
 */
public class BaseEvent extends ApplicationEvent {
    private String orderId;
    private String personId;

    @Override
    public String toString() {
        return "BaseEvent{" +
                "orderId='" + orderId + '\'' +
                ", personId='" + personId + '\'' +
                '}';
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }

    public BaseEvent(Object source) {
        super(source);
    }
}
