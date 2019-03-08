package com.tianyaleixiaolin.uplusserver.core.user.user;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @author Mr.li wrote on 2018/10/26.
 */
public interface PtUserRepository extends JpaRepository<PtUser, Long>,
        JpaSpecificationExecutor<PtUser> {
    PtUser findByAccount(String account);

    /**
     * 查询某个部门的所有成员数量
     */
    Integer countByDepartmentIdAndState(Long departmentId, Integer state);

    /**
     * 查询某个部门所有正常状态员工
     *
     * @param departmentId
     *         部门id
     * @param state
     *         状态
     * @return 结果集
     */
    List<PtUser> findByDepartmentIdAndState(Long departmentId, Integer state);

    List<PtUser> findByCompanyIdAndState(Long companyId, Integer state);

    Page<PtUser> findByCompanyId(Long companyId, Pageable pageable);

    List<PtUser> findByCompanyIdAndStateAndNameLike(Long companyId, Integer state, String name);

    List<PtUser> findByDeleteFlagFalse();

    /**
     * 根据状态和名字模糊查询
     *
     * @param state
     *         是否可用
     * @param name
     *         名字
     * @return 结果集
     */
    List<PtUser> findByStateAndNameLike(Integer state, String name);

    /**
     * 根据状态查询所有
     *
     * @param state
     *         状态
     * @return 结果
     */
    List<PtUser> findByState(Integer state);

    /**
     * 查询最大id值
     * @param companyId
     *         companyId
     * @return 结果
     */
    @Query(value = "select max(id) from PtUser where companyId = ?1")
    Long findCompanyMaxUserId(Long companyId);

    /**
     * 查找最新的用户信息
     *
     * @param beginId
     *         开始id
     * @param endId
     *         结束id
     * @param companyId
     *         companyId
     * @return 结果
     */
    List<PtUser> findByIdBetweenAndCompanyId(Long beginId, Long endId, Long companyId);

    /**
     * 根据公司id查找当前公司下用户最小的创建时间
     * @param companyId companyId
     * @return Date
     */
    PtUser findFirstByCompanyIdOrderByCreateTime(Long companyId);

}
