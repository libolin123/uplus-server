package com.tianyaleixiaolin.uplusserver.global;

import com.tianyaleixiaolin.uplusserver.global.util.Constant;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Mr.li wrote on 2018/11/6.
 */
@Component
public class UserKit {

    public Long getCurrentUserId() {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        return Long.valueOf(request.getHeader(Constant.USERID));
    }

    /**
     * 获取地勤人员id
     */
    public Long getGroundPersonId() {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        if (request.getHeader(Constant.PERSONID) == null) {
            return null;
        }
        return Long.valueOf(request.getHeader(Constant.PERSONID));
    }

}
