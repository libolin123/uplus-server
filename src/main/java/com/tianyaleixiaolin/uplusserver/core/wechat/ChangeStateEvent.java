package com.tianyaleixiaolin.uplusserver.core.wechat;

import com.tianyaleixiaolin.uplusserver.core.wechat.event.BaseEvent;
import com.tianyaleixiaolin.uplusserver.core.wechat.event.ChangeStateBean;

/**
 * @author Mr.li wrote on 2019/1/21.
 */
public class ChangeStateEvent extends BaseEvent {


    public ChangeStateEvent(ChangeStateBean source) {
        super(source);
    }
}
