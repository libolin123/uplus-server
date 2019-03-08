package com.tianyaleixiaolin.uplusserver.global.cache;

import com.xiaoleilu.hutool.util.CollectionUtil;
import com.tianyaleixiaolin.uplusserver.global.event.UserRoleChangeEvent;
import com.tianyaleixiaolin.uplusserver.global.util.FastJsonUtils;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static com.tianyaleixiaolin.uplusserver.global.util.CacheConstant.CACHE_USER_ROLE_EXPIE;
import static com.tianyaleixiaolin.uplusserver.global.util.CacheConstant.CACHE_USER_ROLE_KEY;


/**
 * @author Mr.li wrote on 2018/10/27.
 * 用户角色信息缓存
 */
@Component
public class UserRoleCache extends BaseCache {

    /**
     * 根据userId获取缓存的角色
     *
     * @param userId
     *         userId
     * @return 角色集合
     */
    public List<Long> findRolesByUserId(Long userId) {
        Object object = stringRedisTemplate.opsForValue().get(roleKeyOfUserId(userId));
        if (object == null) {
            return null;
        }
        return FastJsonUtils.toList(object.toString(), Long.class);
    }

    /**
     * 缓存用户的所有role
     *
     * @param userId
     *         userId
     * @param roleIds
     *         角色ID集合
     */
    public void saveUserRolesByUser(Long userId, List<Long> roleIds) {
        if (CollectionUtil.isEmpty(roleIds)) {
            return;
        }
        stringRedisTemplate.opsForValue().set(roleKeyOfUserId(userId), FastJsonUtils.convertObjectToJSON(roleIds),
                CACHE_USER_ROLE_EXPIE, TimeUnit.HOURS);
    }

    /**
     * 用户角色、权限发生变化时的回调事件
     *
     * @param event
     *         事件
     */
    @SuppressWarnings("unchecked")
    @EventListener
    public void listenUserRoleChange(UserRoleChangeEvent event) {
        List<Long> userIds = (List<Long>) event.getSource();
        for (Long userId : userIds) {
            remove(userId);
        }
    }

    private void remove(Long userId) {
        stringRedisTemplate.delete(roleKeyOfUserId(userId));
    }

    private String roleKeyOfUserId(Long userId) {
        return CACHE_USER_ROLE_KEY + "_" + userId;
    }
}
