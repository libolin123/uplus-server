package com.tianyaleixiaolin.uplusserver.global.sms;

import com.yunpian.sdk.YunpianClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Mr.li wrote on 2018/12/17.
 */
@Configuration
public class SmsConfig {
    @Value("${sms.apiKey}")
    private String apiKey;

    @Bean
    public YunpianClient yunpianClient() {
        return new YunpianClient(apiKey).init();
    }
}
