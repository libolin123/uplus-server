package com.tianyaleixiaolin.uplusserver.global.event;

import org.springframework.context.ApplicationEvent;

import java.util.List;

/**
 * @author Mr.li wrote on 2018/11/3.
 * 用户角色发生变化时的回调事件
 */
public class UserRoleChangeEvent extends ApplicationEvent {
    public UserRoleChangeEvent(List<Long> userIds) {
        super(userIds);
    }
}
