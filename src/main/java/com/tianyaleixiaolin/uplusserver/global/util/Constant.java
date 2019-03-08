package com.tianyaleixiaolin.uplusserver.global.util;

import org.springframework.data.domain.Sort;

/**
 * @author Mr.li wrote on 2018/10/25.
 */
public interface Constant {
    String SALT = "mindata";
    /**
     * 正常态
     */
    int STATE_NORMAL = 0;
    /**
     * 待审核
     */
    int STATE_CONFIRM = -1;
    /**
     * 被拒绝
     */
    int STATE_REFUSE = -2;

    String REASON_NEW_CREATE = "新建";
    String REASON_UPDATE = "修改";
    String REASON_DELETE = "下架";
    String REASON_UPLOAD = "上架";

    int STATE_FAIL = 2;

    int STATE_NO_PUSH = 0;


    int SUCCESS = 1;
    int FAILURE = 0;

    String ROLE_ADMIN = "admin";

    Long MANAGER_COMPANY_ID = 0L;

    String CONTENT_TYPE = "Content-Type";
    String APP_JSON = "application/json";

    /**
     * 用户访问任何接口header里带的token
     */
    String AUTHORIZATION = "token";
    String USERID = "userId";
    String PERSONID = "personId";

    int PAGE_SIZE = 10;
    int PAGE_NUM = 0;
    Sort.Direction DIRECTION = Sort.Direction.DESC;
}
