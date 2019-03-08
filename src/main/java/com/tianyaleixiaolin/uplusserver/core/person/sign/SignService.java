package com.tianyaleixiaolin.uplusserver.core.person.sign;

import com.tianyaleixiaolin.uplusserver.core.person.PtGroundPerson;
import com.tianyaleixiaolin.uplusserver.core.person.PtGroundPersonManager;
import com.tianyaleixiaolin.uplusserver.core.person.esign.ESignManager;
import com.tianyaleixiaolin.uplusserver.global.bean.BaseData;
import com.tianyaleixiaolin.uplusserver.global.bean.ResultGenerator;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;

/**
 * @author Mr.li wrote on 2019/2/14.
 */
@Component
public class SignService {
    @Resource
    private PtSignManager ptSignManager;
    @Resource
    private PtGroundPersonManager ptGroundPersonManager;
    @Resource
    private ESignManager eSignManager;

    /**
     * 获取签名的地址
     */
    public BaseData findSignPath(Long personId) {
        String failMsg = "获取签约地址失败，请完善个人信息（身份证、姓名）";
        PtSign ptSign = ptSignManager.findByGroundPersonId(personId);
        if (ptSign != null) {
            return ResultGenerator.genSuccessResult(ptSign.getSignUrl());
        }

        PtGroundPerson ptGroundPerson = ptGroundPersonManager.find(personId);
        String accountId = eSignManager.createPersonAccountId(ptGroundPerson);
        if (StringUtils.isEmpty(accountId)) {
            return ResultGenerator.genFailResult(failMsg);
        }

        //合同id
        String docId = eSignManager.createAgreement(ptGroundPerson);
        if (StringUtils.isEmpty(docId)) {
            return ResultGenerator.genFailResult(failMsg);
        }

        String flowId = eSignManager.createSignFlow(docId);
        if (StringUtils.isEmpty(flowId)) {
            return ResultGenerator.genFailResult(failMsg);
        }

        String companySign = eSignManager.companySign(flowId);
        if (StringUtils.isEmpty(companySign)) {
            return ResultGenerator.genFailResult(failMsg);
        }

        String signUrl = eSignManager.sign(accountId, flowId);
        if (StringUtils.isEmpty(flowId)) {
            return ResultGenerator.genFailResult(failMsg);
        }

        ptSign = new PtSign();
        ptSign.setGroundPersonId(personId);
        ptSign.setAccountId(accountId);
        ptSign.setFlowId(flowId);
        ptSign.setSignUrl(signUrl);
        ptSignManager.add(ptSign);
        return ResultGenerator.genSuccessResult(signUrl);
    }

    public BaseData findDownLoadPath(Long personId) {
        String failMsg = "还未处理完毕";
        PtSign ptSign = ptSignManager.findByGroundPersonId(personId);
        //如果之前没取过
        if (StringUtils.isEmpty(ptSign.getDocUrl())) {
            //归档
            String guidang = eSignManager.guidang(ptSign.getFlowId());
            if (guidang == null) {
                return ResultGenerator.genFailResult(failMsg);
            }
        }
        //如果之前已经取过了，就再取一次，30分钟链接有效
        String docUrl = eSignManager.download(ptSign.getFlowId());
        if (docUrl == null) {
            return ResultGenerator.genFailResult(failMsg);
        }
        ptSign.setDocUrl(docUrl);
        ptSignManager.update(ptSign);

        return ResultGenerator.genSuccessResult(docUrl);
    }

    /**
     * 查询签署后的状态
     */
    public BaseData checkSign(Long personId) {
        return ResultGenerator.genSuccessResult(ptSignManager.hasSign(personId));
    }
}
