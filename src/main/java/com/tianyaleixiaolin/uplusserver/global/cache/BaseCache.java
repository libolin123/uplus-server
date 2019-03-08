package com.tianyaleixiaolin.uplusserver.global.cache;

import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author Mr.li wrote on 2018/11/3.
 */
@Component
public class BaseCache {
    @Resource
    protected StringRedisTemplate stringRedisTemplate;
}
