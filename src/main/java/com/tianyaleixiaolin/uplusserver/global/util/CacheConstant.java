package com.tianyaleixiaolin.uplusserver.global.util;

/**
 * @author Mr.li wrote on 2018/11/3.
 */
public interface CacheConstant extends Constant {
    /**
     * 记录登录密码输入错误次数
     */
    String CACHE_SHIRO_PASS_COUNT_KEY = "shiro_pass_count";
    /**
     * 密码错误状态保存10分钟，10分钟后就可以重新输入密码了
     */
    int CACHE_SHIRO_PASS_COUNT_EXPIE = 10;
    /**
     * 用户角色
     */
    String CACHE_USER_ROLE_KEY = "user_role_key";
    /**
     * 权限保存10个小时，redis存储的user权限
     */
    int CACHE_USER_ROLE_EXPIE = 10;
    /**
     * token的key名，key为token
     */
    String CACHE_USER_TOKEN_KEY = "user_token_key";
    /**
     * token的key名，key为userId
     */
    String CACHE_USER_TOKEN_ID_KEY = "user_token_id_key";
    /**
     * 用户登录的token缓存1个小时
     */
    int CACHE_USER_HEADER_TOKEN_EXPIE = 3600;
    /**
     * role对应的菜单缓存的key
     */
    String CACHE_ROLE_MENU_KEY = "role_menu_key";

    /**
     * ec的token的key
     */
    String CACHE_EC_TOKEN_KEY = "ec_user_token_key";

    String CACHE_EC_HEADER_CROP_ID = "CORP_ID";

    String SALE_STATE_KEY = "sale_state_key";
}
