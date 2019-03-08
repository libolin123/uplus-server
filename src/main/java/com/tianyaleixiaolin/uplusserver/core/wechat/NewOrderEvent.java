package com.tianyaleixiaolin.uplusserver.core.wechat;

import com.tianyaleixiaolin.uplusserver.core.wechat.event.BaseEvent;
import com.tianyaleixiaolin.uplusserver.core.wechat.event.NewOrderBean;

/**
 * @author Mr.li wrote on 2019/1/21.
 */
public class NewOrderEvent extends BaseEvent {


    public NewOrderEvent(NewOrderBean source) {
        super(source);
    }
}
