package com.tianyaleixiaolin.uplusserver.core.user.userrole;

import com.tianyaleixiaolin.uplusserver.global.util.CommonUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Mr.li wrote on 2018/10/31.
 */
@Service
public class PtUserRoleManager {
    @Resource
    private PtUserRoleRepository ptUserRoleRepository;

    /**
     * 添加一个role和user的对应关系
     */
    public PtUserRole add(Long userId, Long roleId) {
        PtUserRole ptUserRole = ptUserRoleRepository.findByUserIdAndRoleId(userId, roleId);
        if (ptUserRole != null) {
            return ptUserRole;
        }
        ptUserRole = new PtUserRole();
        ptUserRole.setRoleId(roleId);
        ptUserRole.setUserId(userId);
        ptUserRole.setCreateTime(CommonUtil.getNow());
        ptUserRole.setUpdateTime(CommonUtil.getNow());
        return ptUserRoleRepository.save(ptUserRole);
    }

    /**
     * 根据roleId查询
     *
     * @param roleId roleId
     * @return 集合
     */
    public List<PtUserRole> findByRoleId(Long roleId) {
        return ptUserRoleRepository.findByRoleId(roleId);
    }


    /**
     * 根据userId查找角色
     *
     * @param userId userId
     * @return List
     */
    public List<PtUserRole> findByUserId(Long userId) {
        return ptUserRoleRepository.findByUserId(userId);
    }

    /**
     * 修改
     *
     * @param ptUserRole ptUserRole
     */
    public void update(PtUserRole ptUserRole) {
        ptUserRoleRepository.save(ptUserRole);
    }

    /**
     * 根据userId删除
     *
     * @param userId
     *         userId
     */
    public void deleteByUserId(Long userId) {
        ptUserRoleRepository.deleteByUserId(userId);
    }

    /**
     * 修改一个用户的role
     *
     * @param userId
     *         userId
     */
    public void updateUserRole(Long userId, Long roleId) {
        deleteByUserId(userId);
        add(userId, roleId);
    }
}
