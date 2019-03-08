package com.tianyaleixiaolin.uplusserver.core.wechat;

import com.tianyaleixiaolin.uplusserver.core.wechat.event.ChangeStateBean;
import com.tianyaleixiaolin.uplusserver.core.wechat.event.NewOrderBean;
import com.tianyaleixiaolin.uplusserver.core.wechat.event.OrderReceiveBean;
import com.tianyaleixiaolin.uplusserver.global.http.HttpUtil;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * 微信发送模板消息
 * @author Mr.li wrote on 2019/1/21.
 */
@Component
public class WeChatUtils {
    @Resource
    private HttpUtil httpUtil;

    @Async
    @EventListener(NewOrderEvent.class)
    public void newOrder(NewOrderEvent newOrderEvent) {
        NewOrderBean newOrderBean = (NewOrderBean) newOrderEvent.getSource();
        Map<String, Object> map = new HashMap<>();
        map.put("orderNumber", newOrderBean.getOrderNumber());
        map.put("openId", newOrderBean.getOpenId());
        map.put("userName", newOrderBean.getUserName());
        map.put("serviceName", newOrderBean.getServiceName());
        map.put("userPhone", newOrderBean.getUserPhone());

        httpUtil.build(TemplateUrl.NEW_ORDER, map);
    }

    /**
     * 订单状态变更
     */
    @Async
    @EventListener(ChangeStateEvent.class)
    public void newOrder(ChangeStateEvent changeStateEvent) {
        ChangeStateBean changeStateBean = (ChangeStateBean) changeStateEvent.getSource();
        Map<String, Object> map = new HashMap<>();
        map.put("openId", changeStateBean.getOpenId());
        map.put("statesMsg", changeStateBean.getStatesMsg());
        map.put("orderStatus", changeStateBean.getOrderStatus());
        httpUtil.build(TemplateUrl.CHANGE_STATE, map);
    }

    /**
     * 开始抢单
     */
    @Async
    @EventListener(OrderReceiveEvent.class)
    public void beginQiangDan(OrderReceiveEvent orderReceiveEvent) {
        OrderReceiveBean orderReceiveBean = (OrderReceiveBean) orderReceiveEvent.getSource();
        Map<String, Object> map = new HashMap<>();
        map.put("openId", orderReceiveBean.getOpenId());
        map.put("personId", orderReceiveBean.getPersonId());
        map.put("orderNumber", orderReceiveBean.getOrderNumber());
        map.put("serviceName", orderReceiveBean.getServiceName());
        httpUtil.build(TemplateUrl.RECEIVE_ORDER, map);
    }
}
