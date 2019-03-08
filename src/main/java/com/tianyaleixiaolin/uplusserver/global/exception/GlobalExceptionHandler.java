package com.tianyaleixiaolin.uplusserver.global.exception;

import com.tianyaleixiaolin.uplusserver.global.bean.BaseData;
import com.tianyaleixiaolin.uplusserver.global.bean.ResultCode;
import com.tianyaleixiaolin.uplusserver.global.bean.ResultGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;

import static com.tianyaleixiaolin.uplusserver.global.bean.ResultCode.PARAMETER_ERROR;
import static org.springframework.http.HttpStatus.NOT_EXTENDED;

/**
 * @author Mr.li wrote on 2018/10/23.
 * 全局异常处理
 */
@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
    private Logger logger = LoggerFactory.getLogger(getClass().getName());

    /**
     * 在controller里面内容执行之前，校验一些参数不匹配啊，Get post方法不对啊之类的
     */
    @Override
    protected ResponseEntity<Object> handleExceptionInternal(Exception ex, Object body, HttpHeaders headers,
                                                             HttpStatus status, WebRequest request) {
        log(ex);
        return new ResponseEntity<>(ResultGenerator.genFailResult(PARAMETER_ERROR, "GET、POST方法错误或参数类型有错误"),
                NOT_EXTENDED);
    }

    @ExceptionHandler(value = NoLoginException.class)
    @ResponseBody
    public BaseData noLoginHandler(NoLoginException e) {
        log(e);
        return ResultGenerator.genFailResult(ResultCode.NO_LOGIN, "您没有登录");
    }

    //@ExceptionHandler(value = DataIntegrityViolationException.class)
    //@ResponseBody
    //public BaseData sqlErrorHandler(DataIntegrityViolationException e) {
    //    log(e);
    //    return ResultGenerator.genFailResult(ResultCode.SQL_ERROR, "数据库参数有误");
    //}

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public BaseData jsonHandler(HttpServletRequest request, Exception e) throws Exception {
        log(e);
        return ResultGenerator.genFailResult(ResultCode.INTERNAL_SERVER_ERROR, e.getMessage());
    }

    private void log(Exception ex) {
        logger.error("************************异常开始*******************************");
        logger.error(ex.toString());

        StackTraceElement[] error = ex.getStackTrace();
        for (StackTraceElement stackTraceElement : error) {
            logger.error(stackTraceElement.toString());
        }
        logger.error("************************异常结束*******************************");
    }
}
                                  