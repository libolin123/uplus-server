package com.tianyaleixiaolin.uplusserver.global.aop;

import com.xiaoleilu.hutool.date.DateUtil;
import com.xiaoleilu.hutool.date.TimeInterval;
import com.tianyaleixiaolin.uplusserver.global.util.Constant;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

/**
 * @author Mr.li wrote on 2018/10/23.
 */
@Aspect
@Component
@Order(1)
public class LogAspect {
    private Logger logger = LoggerFactory.getLogger(getClass().getName());

    private TimeInterval timer;

    @Around("@within(restController)")
    public Object around(ProceedingJoinPoint joinPoint, RestController restController) throws Throwable {
        // 接收到请求，记录请求内容
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        logger.info("-------------------用户发起请求-----------------");
        logger.info("userId为：" + request.getHeader(Constant.USERID));
        timer = DateUtil.timer();
        // 记录下请求内容
        logger.info("URL : " + request.getRequestURL().toString());
        logger.info("HTTP_METHOD : " + request.getMethod());
        //如果是表单，参数值是普通键值对。如果是application/json，则request.getParameter是取不到的。
        logger.info("Content-type : " + request.getHeader("content-type"));
        logger.info("IP : " + request.getRemoteAddr());
        logger.info("CLASS_METHOD : " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint
                .getSignature().getName());
        logger.info("传参为：");

        if (Constant.APP_JSON.equals(request.getHeader(Constant.CONTENT_TYPE))) {
            Method method = ((MethodSignature) joinPoint.getSignature()).getMethod();
            Object[] objects = joinPoint.getArgs();
            for (int i = 0; i < method.getParameters().length; i++) {
                Parameter parameter = method.getParameters()[i];
                if (parameter.isAnnotationPresent(RequestBody.class) || parameter.isAnnotationPresent(ModelAttribute
                        .class)) {
                    //记录application/json时的传参，SpringMVC中使用@RequestBody接收的值
                    logger.info(objects[i].toString());
                }
            }

        } else {
            //记录请求的键值对
            for (String key : request.getParameterMap().keySet()) {
                logger.info(key + "->" + request.getParameter(key));
            }
        }
        Object object = joinPoint.proceed();

        // 处理完请求，返回内容
        logger.info("方法的返回值 : " + object);
        logger.info("共耗时：" + timer.interval() + "毫秒");
        logger.info("------------------请求结束------------------");

        return object;
    }

}
