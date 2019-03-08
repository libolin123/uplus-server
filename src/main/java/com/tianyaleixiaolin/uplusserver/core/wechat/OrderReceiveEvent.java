package com.tianyaleixiaolin.uplusserver.core.wechat;

import com.tianyaleixiaolin.uplusserver.core.wechat.event.BaseEvent;
import com.tianyaleixiaolin.uplusserver.core.wechat.event.OrderReceiveBean;

/**
 * @author Mr.li wrote on 2019/1/21.
 */
public class OrderReceiveEvent extends BaseEvent {


    public OrderReceiveEvent(OrderReceiveBean source) {
        super(source);
    }
}
