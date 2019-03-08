package com.tianyaleixiaolin.uplusserver.global.aop;

import com.tianyaleixiaolin.uplusserver.core.base.BaseEntity;
import com.tianyaleixiaolin.uplusserver.core.operation.OperationLog;
import com.tianyaleixiaolin.uplusserver.core.operation.OperationLogManager;
import com.tianyaleixiaolin.uplusserver.global.util.CommonUtil;
import com.tianyaleixiaolin.uplusserver.global.util.Constant;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * @author Mr.li wrote on 2018/10/23.
 */
@Aspect
@Component
@Order(2)
public class SavePointAspect {
    @Resource
    private OperationLogManager operationLogManager;

    @Around("@within(service) && !within(com.tianyaleixiaolin.uplusserver.core.operation.OperationLogManager)")
    public Object around(ProceedingJoinPoint joinPoint, Service service) throws Throwable {
        String className = joinPoint.getSignature().getDeclaringTypeName();
        String method = joinPoint.getSignature().getName();
        if (method.contains("find") || method.contains("query") || method.contains("has")) {
            return joinPoint.proceed();
        }
        // 接收到请求，记录请求内容
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        Long userId = Long.valueOf(request.getHeader(Constant.USERID));
        Object[] obj = joinPoint.getArgs();
        Date date = CommonUtil.getNow();
        for (Object o : obj) {
            if (!(o instanceof BaseEntity)) {
                continue;
            }
            BaseEntity baseEntity = (BaseEntity) o;

            //添加系统日志
            OperationLog operationLog = new OperationLog();
            if (!method.contains("add") && !method.contains("update") && !method.contains("delete")) {
                continue;
            }

            if (method.contains("add")) {
                operationLog.setOperationType("add");
                baseEntity.setCreateTime(date);
            } else if (method.contains("update")) {
                operationLog.setOperationType("update");
            } else if (method.contains("delete")) {
                operationLog.setOperationType("delete");
            }

            baseEntity.setOperatorId(userId);
            baseEntity.setUpdateTime(date);

            String jsonContent = o.toString();
            //String jsonContent = FastJsonUtils.convertObjectToJSON(o);
            operationLog.setContent(jsonContent);
            operationLog.setSucceed(true);
            operationLog.setTitle(className.replace("com.tianyaleixiaolin.uplusserver.core.", "") + "." + method);
            operationLog.setOperatorId(userId);
            operationLog.setCreateTime(date);
            operationLog.setUpdateTime(date);

            try {
                Object o1 = joinPoint.proceed();
                
                operationLog.setKeyword("Id:" + baseEntity.getId());
                operationLogManager.operationLog(operationLog);
                return o1;
            } catch (Throwable throwable) {
                operationLog.setSucceed(false);
                operationLogManager.operationLog(operationLog);
                throw throwable;
            }
        }
        return joinPoint.proceed();
    }
}
