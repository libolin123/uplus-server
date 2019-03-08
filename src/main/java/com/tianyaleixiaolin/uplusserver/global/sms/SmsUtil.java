package com.tianyaleixiaolin.uplusserver.global.sms;

import com.tianyaleixiaolin.uplusserver.global.bean.BaseData;
import com.tianyaleixiaolin.uplusserver.global.bean.ResultGenerator;
import com.yunpian.sdk.YunpianClient;
import com.yunpian.sdk.model.Result;
import com.yunpian.sdk.model.SmsSingleSend;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * @author Mr.li wrote on 2018/12/17.
 */
@Component
public class SmsUtil {
    @Resource
    private YunpianClient yunpianClient;
    @Resource
    private StringRedisTemplate stringRedisTemplate;

    public BaseData send(String mobile) {
        //发送短信API
        Map<String, String> param = yunpianClient.newParam(2);
        param.put(YunpianClient.MOBILE, mobile);
        int smsCode = new Random(System.currentTimeMillis()).nextInt(8999) + 1000;
        param.put(YunpianClient.TEXT, "【优服帮】正在进行登录操作，您的验证码是" + smsCode);
        Result<SmsSingleSend> r = yunpianClient.sms().single_send(param);
        //获取返回结果，返回码:r.getCode(),返回码描述:r.getMsg(),API结果:r.getData(),其他说明:r.getDetail(),调用异常:r.getThrowable(

        if (0 == r.getCode()) {
            //存入redis
            stringRedisTemplate.opsForValue().set("uplus_sms_" + mobile, smsCode + "", 300, TimeUnit.SECONDS);
            return ResultGenerator.genSuccessResult();
        } else {
            return ResultGenerator.genFailResult(r.getMsg());
        }
    }
}
