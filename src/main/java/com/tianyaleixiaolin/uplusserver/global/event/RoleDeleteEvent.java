package com.tianyaleixiaolin.uplusserver.global.event;

import org.springframework.context.ApplicationEvent;

/**
 * 菜单被删除事件
 *
 * @author Mr.li wrote on 2018/1/16.
 */
public class RoleDeleteEvent extends ApplicationEvent {
    public RoleDeleteEvent(Long roleId) {
        super(roleId);
    }
}
