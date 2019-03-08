package com.tianyaleixiaolin.uplusserver.global.cache;

import com.xiaoleilu.hutool.util.CollectionUtil;
import com.tianyaleixiaolin.uplusserver.global.event.RoleMenuChangeEvent;
import com.tianyaleixiaolin.uplusserver.global.util.FastJsonUtils;
import org.springframework.context.event.EventListener;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

import static com.tianyaleixiaolin.uplusserver.global.util.CacheConstant.CACHE_ROLE_MENU_KEY;


/**
 * @author Mr.li wrote on 2018/11/3.
 * 角色和menu对应关系的缓存
 */
@Component
public class RoleMenuCache {
    @Resource
    private StringRedisTemplate stringRedisTemplate;

    /**
     * 根据角色查询menu集合的缓存
     *
     * @param roleId
     *         roleId
     * @return 菜单Id集合
     */
    public List<Long> findMenuByRoleId(Long roleId) {
        Object object = stringRedisTemplate.opsForValue().get(keyOfRole(roleId));
        if (object == null) {
            return null;
        }
        return FastJsonUtils.toList(object.toString(), Long.class);
    }

    /**
     * 缓存role的menu信息
     *
     * @param roleId
     *         roleId
     * @param menuIds
     *         菜单集合
     */
    public void saveMenusByRoleId(Long roleId, List<Long> menuIds) {
        if (CollectionUtil.isEmpty(menuIds)) {
            return;
        }

        stringRedisTemplate.opsForValue().set(keyOfRole(roleId), FastJsonUtils.convertObjectToJSON(menuIds));
    }

    /**
     * 用户角色、权限发生变化时的回调事件
     *
     * @param event
     *         事件
     */
    @SuppressWarnings("unchecked")
    @EventListener
    public void listenUserRoleChange(RoleMenuChangeEvent event) {
        List<Long> roleIds = (List<Long>) event.getSource();
        for (Long roleId : roleIds) {
            remove(roleId);
        }
    }

    private void remove(Long roleId) {
        stringRedisTemplate.delete(keyOfRole(roleId));
    }


    private String keyOfRole(Long roleId) {
        return CACHE_ROLE_MENU_KEY + "_" + roleId;
    }
}
