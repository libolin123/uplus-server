package com.tianyaleixiaolin.uplusserver.global.filter;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Mr.li wrote on 2018/11/1.
 */
@Configuration
public class FilterConfig {

    @Bean
    public FilterRegistrationBean registFilter() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(new UrlFilter());
        registration.addUrlPatterns("/*");
        registration.setName("UrlFilter");
        registration.setOrder(1);
        return registration;
    }

}