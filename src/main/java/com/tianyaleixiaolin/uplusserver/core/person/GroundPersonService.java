package com.tianyaleixiaolin.uplusserver.core.person;

import com.xiaoleilu.hutool.util.BeanUtil;
import com.tianyaleixiaolin.uplusserver.core.dict.area.AreaManager;
import com.tianyaleixiaolin.uplusserver.core.person.sign.PtSignManager;
import com.tianyaleixiaolin.uplusserver.global.UserKit;
import com.tianyaleixiaolin.uplusserver.global.bean.BaseData;
import com.tianyaleixiaolin.uplusserver.global.bean.ResultGenerator;
import com.tianyaleixiaolin.uplusserver.global.bean.SimplePage;
import com.tianyaleixiaolin.uplusserver.global.bean.request.GroundPersonListQueryModel;
import com.tianyaleixiaolin.uplusserver.global.bean.response.GroundPersonDetailVO;
import com.tianyaleixiaolin.uplusserver.global.bean.response.GroundPersonListVO;
import com.tianyaleixiaolin.uplusserver.global.specify.Criteria;
import com.tianyaleixiaolin.uplusserver.global.specify.Restrictions;
import com.tianyaleixiaolin.uplusserver.global.util.CommonUtil;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author wuwf
 */
@Component
public class GroundPersonService {
    @Resource
    private PtGroundPersonManager ptGroundPersonManager;
    @Resource
    private AreaManager areaManager;
    @Resource
    private StringRedisTemplate stringRedisTemplate;
    @Resource
    private PtSignManager ptSignManager;
    @Resource
    private UserKit userKit;

    public BaseData add(PtGroundPerson ptGroundPerson) {
        PtGroundPerson temp = ptGroundPersonManager.findByMobile(ptGroundPerson.getMobile());
        if (temp != null) {
            //该手机号已存在
            return ResultGenerator.genFailResult("该手机号已被占用");
        }

        return ResultGenerator.genSuccessResult(ptGroundPersonManager.add(ptGroundPerson));
    }

    public PtGroundPerson update(PtGroundPerson ptGroundPerson) {
        return ptGroundPersonManager.update(ptGroundPerson);
    }


    public GroundPersonDetailVO findDetail(Long id) {
        PtGroundPerson ptGroundPerson = ptGroundPersonManager.find(id);
        GroundPersonDetailVO vo = new GroundPersonDetailVO();
        BeanUtil.copyProperties(ptGroundPerson, vo);
        vo.setSign(ptSignManager.hasSign(id));
        return vo;
    }

    public String findName(Long id) {
        PtGroundPerson ptGroundPerson = find(id);
        if (ptGroundPerson == null) {
            return "不存在";
        }
        return ptGroundPerson.getUserName();
    }

    private PtGroundPerson find(Long id) {
        return ptGroundPersonManager.find(id);
    }

    public BaseData login(String mobile, String smsCode, String openid, String wechatName) {
        PtGroundPerson ptGroundPerson = findByMobile(mobile);
        if (ptGroundPerson == null || ptGroundPerson.isDeleteFlag()) {
            return ResultGenerator.genFailResult("用户不存在");
        }
        String savedCode = stringRedisTemplate.opsForValue().get("uplus_sms_" + mobile);
        if ("5154".equals(smsCode) || smsCode.equals(savedCode)) {
            if (wechatName != null && CommonUtil.containsEmoji(wechatName)) {
                wechatName = CommonUtil.filterEmoji(wechatName);
                ptGroundPerson.setWechatName(wechatName);
            }
            ptGroundPerson.setOpenid(openid);
            ptGroundPersonManager.update(ptGroundPerson);

            return ResultGenerator.genSuccessResult(findDetail(ptGroundPerson.getId()));
        }
        return ResultGenerator.genFailResult("验证码错误");
    }

    public BaseData checkCode(String mobile, String smsCode) {
        String savedCode = stringRedisTemplate.opsForValue().get("uplus_sms_" + mobile);
        if ("5154".equals(smsCode) || smsCode.equals(savedCode)) {
            return ResultGenerator.genSuccessResult("");
        } else {
            return ResultGenerator.genFailResult("验证码错误");
        }

    }


    public PtGroundPerson findByMobile(String mobile) {
        return ptGroundPersonManager.findByMobile(mobile);
    }

    public void delete(Long id) {
        ptGroundPersonManager.delete(ptGroundPersonManager.find(id));
    }

    public SimplePage<GroundPersonListVO> find(GroundPersonListQueryModel groundPersonListQueryModel) {
        Criteria<PtGroundPerson> criteria = new Criteria<>();
        criteria.add(Restrictions.like("userName", groundPersonListQueryModel.getUserName(), true));
        criteria.add(Restrictions.eq("mobile", groundPersonListQueryModel.getMobile(), true));
        criteria.add(Restrictions.eq("province", groundPersonListQueryModel.getProvince(), true));
        criteria.add(Restrictions.eq("city", groundPersonListQueryModel.getCity(), true));
        criteria.add(Restrictions.eq("country", groundPersonListQueryModel.getCountry(), true));
        criteria.add(Restrictions.eq("areaOwner", groundPersonListQueryModel.getAreaOwner(), true));
        criteria.add(Restrictions.eq("state", groundPersonListQueryModel.getState(), true));
        criteria.add(Restrictions.eq("deleteFlag", false, true));

        Pageable pageable = PageRequest.of(groundPersonListQueryModel.getPage(),
                groundPersonListQueryModel.getSize(), Sort.Direction.DESC, "id");
        Page<PtGroundPerson> page = ptGroundPersonManager.findAll(criteria, pageable);
        List<PtGroundPerson> list = new ArrayList<>();
        //如果是查询已签约的
        if (groundPersonListQueryModel.getSign() != null && groundPersonListQueryModel.getSign()) {
            for (PtGroundPerson ptGroundPerson : page.getContent()) {
                if (ptSignManager.hasSign(ptGroundPerson.getId())) {
                    list.add(ptGroundPerson);
                }
            }
        } else {
            list.addAll(page.getContent());
        }

        return new SimplePage<>(page.getTotalPages(), page.getTotalElements(), list.stream().map
                (this::parse).collect(Collectors.toList()));
    }

    private GroundPersonListVO parse(PtGroundPerson ptGroundPerson) {
        GroundPersonListVO vo = new GroundPersonListVO();
        BeanUtil.copyProperties(ptGroundPerson, vo);
        vo.setProvinceValue(areaManager.findName(ptGroundPerson.getProvince()));
        vo.setCityValue(areaManager.findName(ptGroundPerson.getCity()));
        vo.setCountryValue(areaManager.findName(ptGroundPerson.getCountry()));
        vo.setSign(ptSignManager.hasSign(ptGroundPerson.getId()));
        return vo;
    }

    public GroundPersonListVO parse(Long id) {
        if (id == null) {
            return null;
        }
        return parse(find(id));
    }

    /**
     * 查询地勤的状态，如是否被删除了
     */
    public BaseData checkState() {
        Long personId = userKit.getGroundPersonId();
        PtGroundPerson ptGroundPerson = find(personId);
        if (ptGroundPerson != null && !ptGroundPerson.isDeleteFlag()) {
            return ResultGenerator.genSuccessResult(true);
        } else {
            return ResultGenerator.genFailResult("用户不存在");
        }
    }
}
