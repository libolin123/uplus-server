package com.tianyaleixiaolin.uplusserver.global.event;

import org.springframework.context.ApplicationEvent;

import java.util.List;

/**
 * @author Mr.li wrote on 2018/11/3.
 * 角色权限发生变化时的回调事件
 */
public class RoleMenuChangeEvent extends ApplicationEvent {
    public RoleMenuChangeEvent(List<Long> roleIds) {
        super(roleIds);
    }
}
