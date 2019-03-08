package com.tianyaleixiaolin.uplusserver.core.user.role;

import com.xiaoleilu.hutool.util.CollectionUtil;
import com.tianyaleixiaolin.uplusserver.core.user.user.PtUser;
import com.tianyaleixiaolin.uplusserver.core.user.user.PtUserManager;
import com.tianyaleixiaolin.uplusserver.core.user.userrole.PtUserRole;
import com.tianyaleixiaolin.uplusserver.core.user.userrole.PtUserRoleRepository;
import com.tianyaleixiaolin.uplusserver.global.cache.UserRoleCache;
import com.tianyaleixiaolin.uplusserver.global.util.Constant;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Mr.li wrote on 2018/10/26.
 */
@Service
public class PtRoleManager {
    @Resource
    private PtRoleRepository ptRoleRepository;
    @Resource
    private PtUserRoleRepository ptUserRoleRepository;
    @Resource
    private UserRoleCache userRoleCache;
    @Resource
    private PtUserManager ptUserManager;

    public PtRole find(Long roleId) {
        return ptRoleRepository.getOne(roleId);
    }

    public List<PtRole> findAll() {
        return ptRoleRepository.findByDeleteFlagFalse();
    }

    /**
     * 添加一个role
     *
     * @param ptRole
     *         ptRole
     * @return ptRole
     */
    public PtRole add(PtRole ptRole) {
        return save(ptRole);
    }

    public PtRole update(PtRole ptRole) {
        return save(ptRole);
    }

    private PtRole save(PtRole ptRole) {
        return ptRoleRepository.save(ptRole);
    }

    /**
     * 删除角色
     *
     * @param ptRole
     *         ptRole
     */
    public void delete(PtRole ptRole) {
        ptRole.setDeleteFlag(true);
        update(ptRole);
    }

    /**
     * 查询用户的所有role
     *
     * @param userId
     *         userId
     * @return 集合
     */
    private List<PtRole> findRolesByUserId(Long userId) {
        List<PtUserRole> userRoles = ptUserRoleRepository.findByUserId(userId);
        return userRoles.stream().map(userRole -> ptRoleRepository.getOne(userRole.getRoleId())).collect(Collectors
                .toList());
    }

    /**
     * 获取用户的roles
     *
     * @param user
     *         user
     * @return 角色集合
     */
    private List<PtRole> findRolesByUser(PtUser user) {
        //从缓存获取
        List<Long> roleIds = userRoleCache.findRolesByUserId(user.getId());
        if (CollectionUtil.isEmpty(roleIds)) {
            List<PtRole> roles = findRolesByUserId(user.getId());
            //放入缓存
            userRoleCache.saveUserRolesByUser(user.getId(), roles.stream().map(PtRole::getId).collect(Collectors
                    .toList()));
            return roles;
        }
        return roleIds.stream().map(id -> ptRoleRepository.getOne(id)).collect(Collectors.toList());
    }

    public List<PtRole> findByUserId(Long userId) {
        PtUser ptUser = ptUserManager.find(userId);
        return findRolesByUser(ptUser);
    }

    /**
     * 是否是超管
     *
     * @param userId
     *         userId
     * @return 是否
     */
    public boolean isAdmin(Long userId) {
        List<PtRole> ptRoles = findByUserId(userId);
        return ptRoles.stream().map(PtRole::getName).collect(Collectors.toSet()).contains(Constant.ROLE_ADMIN);
    }

    public boolean exists(Long id) {
        return ptRoleRepository.existsById(id);
    }
}
