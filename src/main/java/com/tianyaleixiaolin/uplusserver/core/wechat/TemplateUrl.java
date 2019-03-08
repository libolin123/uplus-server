package com.tianyaleixiaolin.uplusserver.core.wechat;

/**
 * @author Mr.li wrote on 2019/1/21.
 */
public interface TemplateUrl {
    //https://yfb.youjiajk.com/
    //http://yjhealth-test.s1.natapp.cc/
    String NEW_ORDER = "https://yfb.youjiajk.com/healthcloud365common/static/wechat/template/neworder";
    String CHANGE_STATE = "https://yfb.youjiajk.com/healthcloud365common/static/wechat/template/updatestates";
    //抢单
    String RECEIVE_ORDER = "https://yfb.youjiajk.com/healthcloud365common/static/wechat/template/grabSheet";
}
