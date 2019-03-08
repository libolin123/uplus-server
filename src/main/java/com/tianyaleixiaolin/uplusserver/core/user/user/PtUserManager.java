package com.tianyaleixiaolin.uplusserver.core.user.user;

import com.xiaoleilu.hutool.util.StrUtil;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

import static com.tianyaleixiaolin.uplusserver.global.util.Constant.STATE_NORMAL;


/**
 * @author Mr.li wrote on 2018/10/26.
 */
@Service
public class PtUserManager {
    @Resource
    private PtUserRepository userRepository;

    public String findNameById(Long id) {
        if (id == null) {
            return "";
        }
        PtUser ptUser = find(id);
        if (ptUser == null) {
            return "";
        }
        return ptUser.getName();
    }


    /**
     * 根据account查询User
     *
     * @param account
     *         账号名
     * @return 用户
     */
    public PtUser findByAccount(String account) {
        return userRepository.findByAccount(account);
    }

    public PtUser find(Long id) {
        return userRepository.getOne(id);
    }

    public void delete(PtUser ptUser) {
        ptUser.setDeleteFlag(true);
        update(ptUser);
    }

    public PtUser add(PtUser ptUser) {
        return userRepository.save(ptUser);
    }

    public PtUser update(PtUser ptUser) {
        return userRepository.save(ptUser);
    }

    public List<PtUser> findAll() {
        return userRepository.findByDeleteFlagFalse();
    }

    /**
     * 分页查找
     *
     * @param var1
     *         var1
     * @param var2
     *         var2
     * @return Page
     */
    public Page<PtUser> findAll(Specification<PtUser> var1, Pageable var2) {
        return userRepository.findAll(var1, var2);
    }

    /**
     * 根据名字模糊查询
     *
     * @param name
     *         名字
     * @return 集合
     */
    public List<PtUser> findByNameLike(String name) {
        if (StrUtil.isEmpty(name)) {
            return userRepository.findByState(STATE_NORMAL);
        }
        return userRepository.findByStateAndNameLike(STATE_NORMAL, "%" + name + "%");
    }

    /**
     * 查询最大id值
     *
     * @return 结果
     */
    public Long findCompanyMaxUserId(Long companyId) {
        return userRepository.findCompanyMaxUserId(companyId);
    }

    /**
     * 查询id范围内的数据
     *
     * @param beginId
     *         开始id
     * @param endId
     *         结束id
     * @return 结果
     */
    public List<PtUser> findByIdBetweenAndCompanyId(Long beginId, Long endId, Long companyId) {
        return userRepository.findByIdBetweenAndCompanyId(beginId, endId, companyId);
    }

    /**
     * 用户状态异常，不可登录
     *
     * @param ptUser
     *         user
     * @return 是否异常状态
     */
    public boolean isErrorUser(PtUser ptUser) {
        return null == ptUser || ptUser.getState() == -1;
    }

    /**
     * 公司id查找管理员用户，创建最早的那个就是
     *
     * @param companyId
     *         companyId
     * @return PtUser
     */
    public PtUser findManagerByCompanyId(Long companyId) {
        return userRepository.findFirstByCompanyIdOrderByCreateTime(companyId);
    }
}
