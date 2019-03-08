package com.tianyaleixiaolin.uplusserver.global.aop;

import com.tianyaleixiaolin.uplusserver.global.bean.ResultGenerator;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.hibernate.validator.internal.engine.path.PathImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.LocalVariableTableParameterNameDiscoverer;
import org.springframework.core.ParameterNameDiscoverer;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.ValidatorFactory;
import javax.validation.executable.ExecutableValidator;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Set;

/**
 * Created by wuwf on 18/10/27.
 * 参数校验切面
 */
@Aspect
@Component
@Order(2)
public class ValidAspect {
    private Logger logger = LoggerFactory.getLogger(getClass());

    /**
     环绕通知,环绕增强，相当于MethodInterceptor
     */
    @Around("@within(restController)")
    public Object arround(ProceedingJoinPoint pjp, RestController restController) {
        try {
            //取参数，如果没参数，那肯定不校验了
            Object[] objects = pjp.getArgs();
            if (objects.length == 0) {
                return pjp.proceed();
            }
            /**************************校验封装好的javabean**********************/
            //寻找带BindingResult参数的方法，然后判断是否有error，如果有则是校验不通过
            for (Object object : objects) {
                if (object instanceof BeanPropertyBindingResult) {
                    //有校验
                    BeanPropertyBindingResult result = (BeanPropertyBindingResult) object;
                    if (result.hasErrors()) {
                        List<ObjectError> list = result.getAllErrors();
                        for (ObjectError error : list) {
                            logger.info("参数校验不通过");
                            logger.info(error.getCode() + "---" + error.getArguments() + "--" + error.getDefaultMessage());
                            //返回第一条校验失败信息。也可以拼接起来返回所有的
                            return ResultGenerator.genFailResult(error.getDefaultMessage());
                        }
                    }
                }
            }

            /**************************校验普通参数*************************/
            //  获得切入目标对象
            Object target = pjp.getThis();
            // 获得切入的方法
            Method method = ((MethodSignature) pjp.getSignature()).getMethod();
            // 执行校验，获得校验结果
            Set<ConstraintViolation<Object>> validResult = validMethodParams(target, method, objects);
            //如果有校验不通过的
            if (!validResult.isEmpty()) {
                // 获得方法的参数名称
                String[] parameterNames = parameterNameDiscoverer.getParameterNames(method);

                for (ConstraintViolation<Object> constraintViolation : validResult) {
                    // 获得校验的参数路径信息
                    PathImpl pathImpl = (PathImpl) constraintViolation.getPropertyPath();
                    // 获得校验的参数位置
                    int paramIndex = pathImpl.getLeafNode().getParameterIndex();
                    // 获得校验的参数名称
                    String paramName = parameterNames[paramIndex];

                    logger.info("参数校验不通过");
                    logger.info(paramName + "---" + constraintViolation.getMessage());
                    return ResultGenerator.genFailResult(constraintViolation.getMessage());
                }
                //返回第一条
                return validResult.iterator().next().getMessage();
            }

            return pjp.proceed();
        } catch (Throwable e) {
            e.printStackTrace();
            return null;
        }
    }

    private ParameterNameDiscoverer parameterNameDiscoverer = new LocalVariableTableParameterNameDiscoverer();
    private final ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
    private final ExecutableValidator validator = factory.getValidator().forExecutables();


    private <T> Set<ConstraintViolation<T>> validMethodParams(T obj, Method method, Object[] params) {
        return validator.validateParameters(obj, method, params);
    }
}