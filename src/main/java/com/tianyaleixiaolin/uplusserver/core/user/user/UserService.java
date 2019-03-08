package com.tianyaleixiaolin.uplusserver.core.user.user;

import com.xiaoleilu.hutool.util.BeanUtil;
import com.tianyaleixiaolin.uplusserver.core.user.role.PtRole;
import com.tianyaleixiaolin.uplusserver.core.user.role.PtRoleManager;
import com.tianyaleixiaolin.uplusserver.core.user.role.RoleService;
import com.tianyaleixiaolin.uplusserver.core.user.userrole.PtUserRoleManager;
import com.tianyaleixiaolin.uplusserver.global.UserKit;
import com.tianyaleixiaolin.uplusserver.global.bean.BaseData;
import com.tianyaleixiaolin.uplusserver.global.bean.ResultGenerator;
import com.tianyaleixiaolin.uplusserver.global.bean.request.UserAddRequestModel;
import com.tianyaleixiaolin.uplusserver.global.bean.response.RoleMenuVO;
import com.tianyaleixiaolin.uplusserver.global.bean.response.UserListVO;
import com.tianyaleixiaolin.uplusserver.global.event.UserRoleChangeEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Mr.li wrote on 2018/11/23.
 */
@Component
public class UserService {
    @Resource
    private PtUserManager ptUserManager;
    @Resource
    private PtUserRoleManager ptUserRoleManager;
    @Resource
    private PtRoleManager ptRoleManager;
    @Resource
    private RoleService roleService;
    @Resource
    private UserKit userKit;
    @Resource
    private ApplicationEventPublisher eventPublisher;

    public BaseData updatePassword(String oldPass, String pass) {
        Long userId = userKit.getCurrentUserId();
        PtUser ptUser = ptUserManager.find(userId);
        if (!ptUser.getPassword().equals(oldPass)) {
            return ResultGenerator.genFailResult("旧密码不正确");
        }

        ptUser.setPassword(pass);
        ptUserManager.update(ptUser);
        return ResultGenerator.genSuccessResult("修改成功");
    }

    public List<UserListVO> findAll() {
        List<PtUser> list = ptUserManager.findAll();
        return list.stream().map(this::parse).collect(Collectors.toList());
    }

    public UserListVO find(Long id) {
        PtUser ptUser = ptUserManager.find(id);
        return parse(ptUser);
    }

    public RoleMenuVO findMenus() {
        PtUser ptUser = ptUserManager.find(userKit.getCurrentUserId());
        List<PtRole> ptRoles = ptRoleManager.findByUserId(ptUser.getId());

        return roleService.findOne(ptRoles.get(0).getId());
    }

    //public UserDetailVO findOne(Long id) {
    //    UserDetailVO userDetailVO = new UserDetailVO();
    //    PtUser ptUser = ptUserManager.find(id);
    //    BeanUtil.copyProperties(ptUser, userDetailVO);
    //
    //    List<PtUserRole> userRoles = ptUserRoleManager.findByUserId(id);
    //    Set<Long> roleIds = userRoles.stream().map(PtUserRole::getRoleId).collect(Collectors.toSet());
    //    userDetailVO.setRoleIds(roleIds);
    //
    //    Set<SimpleMenu> simpleMenus = new HashSet<>();
    //    for (Long roleId : roleIds) {
    //        simpleMenus.addAll(roleService.findMenusByRoleId(roleId));
    //    }
    //    userDetailVO.setMenus(simpleMenus);
    //
    //    return userDetailVO;
    //}

    private UserListVO parse(PtUser ptUser) {
        UserListVO vo = new UserListVO();
        BeanUtil.copyProperties(ptUser, vo);
        List<PtRole> ptRoles = ptRoleManager.findByUserId(ptUser.getId());
        String roleName = "";
        for (PtRole role : ptRoles) {
            roleName += role.getName() + " ";
            vo.setRoleId(role.getId());
        }
        vo.setRoleName(roleName);
        return vo;
    }

    public PtUser add(UserAddRequestModel userAddRequestModel) {
        PtUser ptUser = new PtUser();
        BeanUtil.copyProperties(userAddRequestModel, ptUser);
        ptUser = ptUserManager.add(ptUser);

        Long roleId = userAddRequestModel.getRoleId();
        if (roleId != null) {
            ptUserRoleManager.add(ptUser.getId(), roleId);
        }

        return ptUser;
    }

    public PtUser update(UserAddRequestModel userAddRequestModel) {
        PtUser ptUser = ptUserManager.find(userAddRequestModel.getId());
        BeanUtil.copyProperties(userAddRequestModel, ptUser, BeanUtil.CopyOptions.create().setIgnoreNullValue(true));

        Long roleId = userAddRequestModel.getRoleId();
        if (roleId != null) {
            ptUserRoleManager.deleteByUserId(userAddRequestModel.getId());
            ptUserRoleManager.add(ptUser.getId(), roleId);

            eventPublisher.publishEvent(new UserRoleChangeEvent(Arrays.asList(ptUser.getId())));
        }

        return ptUserManager.update(ptUser);
    }

    public void delete(Long id) {
        eventPublisher.publishEvent(new UserRoleChangeEvent(Arrays.asList(id)));
        ptUserManager.delete(ptUserManager.find(id));
    }
}
