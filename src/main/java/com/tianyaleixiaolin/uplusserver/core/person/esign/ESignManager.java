package com.tianyaleixiaolin.uplusserver.core.person.esign;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.xiaoleilu.hutool.date.DateField;
import com.xiaoleilu.hutool.date.DateUtil;
import com.tianyaleixiaolin.uplusserver.core.dict.area.AreaEntity;
import com.tianyaleixiaolin.uplusserver.core.dict.area.AreaManager;
import com.tianyaleixiaolin.uplusserver.core.medical.hospital.PtHospitalManager;
import com.tianyaleixiaolin.uplusserver.core.person.PtGroundPerson;
import com.tianyaleixiaolin.uplusserver.core.person.price.PtAreaPrice;
import com.tianyaleixiaolin.uplusserver.core.person.price.PtAreaPriceManager;
import com.tianyaleixiaolin.uplusserver.global.http.HttpUtil;
import com.tianyaleixiaolin.uplusserver.global.util.CommonUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Mr.li wrote on 2019/2/13.
 */
@Component
public class ESignManager {
    @Resource
    private HttpUtil httpUtil;
    @Value("${sign.url}")
    private String url;
    @Value("${sign.templateId}")
    private String templateId;

    @Resource
    private AreaManager areaManager;
    @Resource
    private PtHospitalManager ptHospitalManager;
    @Resource
    private PtAreaPriceManager ptAreaPriceManager;

    public String createPersonAccountId(PtGroundPerson ptGroundPerson) {
        Map<String, Object> map = new HashMap<>();
        map.put("thirdId", ptGroundPerson.getPaper());
        map.put("name", ptGroundPerson.getUserName());
        map.put("idNo", ptGroundPerson.getPaper());
        map.put("idType", 19);
        String s = httpUtil.buildSign(url + "/account/create/person", map);
        JSONObject result = JSON.parseObject(s);
        int errCode = result.getInteger("errCode");
        String personAccountid = "";
        if (0 != errCode) {
            return null;
        } else {
            String data = result.getString("data");
            JSONObject obj = JSON.parseObject(data);
            personAccountid = obj.getString("accountId");
            System.out.println("创建个人账户成功！" + result);
        }
        return personAccountid;
    }

    /**
     * 创建个人合同
     */
    public String createAgreement(PtGroundPerson ptGroundPerson) {
        Map<String, Object> map = new HashMap<>();
        map.put("templateId", templateId);
        map.put("name", ptGroundPerson.getUserName() + "合同");

        Map<String, Object> fieldMap = new HashMap<>();
        Date today = new Date();
        String todayStr = CommonUtil.parseDate(today);
        Date end = DateUtil.offset(today, DateField.YEAR, 1);
        fieldMap.put("Text1sigingDate", todayStr);
        fieldMap.put("Text2signer", ptGroundPerson.getUserName());
        fieldMap.put("Text3signerAddress", ptGroundPerson.getAddress());
        fieldMap.put("Text4contact", ptGroundPerson.getMobile());
        fieldMap.put("fill_1_2area", areaManager.findName(ptGroundPerson.getProvince()) + "-" + areaManager.findName
                (ptGroundPerson.getCity()));

        AreaEntity areaEntity = areaManager.findByAreaCode(ptGroundPerson.getCity());
        if (areaEntity != null) {
            PtAreaPrice ptAreaPrice = ptAreaPriceManager.findByAreaName(areaEntity.getAreaName());
            if (ptAreaPrice != null) {
                fieldMap.put("fill_1_3serviceFee1", ptAreaPrice.getThreePrice());
                fieldMap.put("fill_2serviceFee2", ptAreaPrice.getSinglePrice());
            }
        }

        fieldMap.put("fill_3signingDate", todayStr);
        fieldMap.put("fill_4signingDeadline", CommonUtil.parseDate(end));
        fieldMap.put("Text5signingDate", todayStr);
        fieldMap.put("Text6signingDate", todayStr);
        fieldMap.put("fill_1_4signer", ptGroundPerson.getUserName());
        fieldMap.put("fill_2_2gender", ptGroundPerson.getSex() == 1 ? "男" : "女");
        fieldMap.put("fill_3_2area", areaManager.findName(ptGroundPerson.getProvince()));
        String ids = ptGroundPerson.getHospitalIds();
        if (!StringUtils.isEmpty(ids)) {
            String[] array = ids.split(",");
            if (array.length > 0) {
                fieldMap.put("fill_4_2company", ptHospitalManager.findName(Long.valueOf(array[0])));
            }
        }
        
        fieldMap.put("fill_5identificationNumber", ptGroundPerson.getPaper());
        fieldMap.put("fill_6qualificationCertificate", ptGroundPerson.getNurseNum());
        fieldMap.put("fill_7bankCardNumber", ptGroundPerson.getBankCardNum());
        fieldMap.put("fill_8bankName", ptGroundPerson.getBank());
        fieldMap.put("fill_9receiveAddress", ptGroundPerson.getAddress());
        map.put("simpleFormFields", fieldMap);
        String s = httpUtil.buildSign(url + "/doc/createbytemplate", map);
        JSONObject result = JSON.parseObject(s);
        int errCode = result.getInteger("errCode");
        String personAgreementId = "";
        if (0 != errCode) {
            return null;
        } else {
            String data = result.getString("data");
            JSONObject obj = JSON.parseObject(data);
            personAgreementId = obj.getString("docId");
            System.out.println("创建合同:" + personAgreementId);
        }
        return personAgreementId;
    }

    /**
     * 创建签署流程
     */
    public String createSignFlow(String docId) {
        Map<String, Object> map = new HashMap<>();
        map.put("businessScene", "线下兼职人员聘用协议");
        map.put("docId", docId);
        map.put("signPlatform", "1");
        String s = httpUtil.buildSign(url + "/sign/contract/addProcess", map);
        //"flowId":"c49be53c7e2347759eaf5f320a84c82d"
        JSONObject result = JSON.parseObject(s);
        int errCode = result.getInteger("errCode");
        String flowId = "";
        if (0 != errCode) {
            return null;
        } else {
            String data = result.getString("data");
            JSONObject obj = JSON.parseObject(data);
            flowId = obj.getString("flowId");
        }
        return flowId;
    }

    /**
     * 企业自动签署
     */
    public String companySign(String flowId) {
        Map<String, Object> map = new HashMap<>();
        map.put("flowId", flowId);

        Map<String, Object> posMap = new HashMap<>();
        posMap.put("signType", 2);
        posMap.put("posPage", 5);
        posMap.put("posX", 199);
        posMap.put("posY", 715);

        map.put("posList", Arrays.asList(posMap));
        String s = httpUtil.buildSign(url + "/sign/contract/platformSignTask", map);
        //"flowId":"c49be53c7e2347759eaf5f320a84c82d"
        JSONObject result = JSON.parseObject(s);
        int errCode = result.getInteger("errCode");
        
        if (0 != errCode) {
            return null;
        } else {
            String data = result.getString("data");
            JSONObject obj = JSON.parseObject(data);
            flowId = obj.getString("flowId");
        }
        return flowId;
    }

    /**
     * 个人手动签署
     */
    public String sign(String accountId, String flowId) {
        Map<String, Object> map = new HashMap<>();
        map.put("flowId", flowId);
        map.put("accountId", accountId);

        Map<String, Object> posMap = new HashMap<>();
        posMap.put("signType", 2);
        posMap.put("posPage", 5);
        posMap.put("posX", 155);
        posMap.put("posY", 606);

        map.put("posList", Arrays.asList(posMap));
        String s = httpUtil.buildSign(url + "/sign/contract/handPersonSignTask", map);
        //"flowId":"c49be53c7e2347759eaf5f320a84c82d"
        JSONObject result = JSON.parseObject(s);
        int errCode = result.getInteger("errCode");
        String signUrl = "";
        if (0 != errCode) {
            return null;
        } else {
            String data = result.getString("data");
            JSONObject obj = JSON.parseObject(data);
            signUrl = obj.getString("signUrl");
        }
        return signUrl;
    }

    /**
     * 查询签署状态
     */
    public boolean signState(String flowId) {
        Map<String, Object> map = new HashMap<>();
        map.put("flowId", flowId);
        String s = httpUtil.buildSign(url + "/sign/contract/detail", map);
        //"flowId":"c49be53c7e2347759eaf5f320a84c82d"
        JSONObject result = JSON.parseObject(s);
        int errCode = result.getInteger("errCode");
        if (0 != errCode) {
            return false;
        } else {
            String data = result.getString("data");
            JSONObject obj = JSON.parseObject(data);
            int state = obj.getInteger("flowStatus");
            //已经归档过了
            if (state == 2) {
                return true;
            }

            JSONArray jsonArray = obj.getJSONArray("signDetailList");
            JSONObject jsonObject = (JSONObject) jsonArray.get(0);
            //签署状态
            state = jsonObject.getInteger("signStatus");
            if (state == 2) {
                String msg = guidang(flowId);
                //归档成功
                return msg != null;
            }
            return false;
        }
    }

    /**
     * 归档
     */
    public String guidang(String flowId) {
        Map<String, Object> map = new HashMap<>();
        map.put("flowId", flowId);
        String s = httpUtil.buildSign(url + "/sign/contract/archiveProcess", map);
        //"flowId":"c49be53c7e2347759eaf5f320a84c82d"
        JSONObject result = JSON.parseObject(s);
        int errCode = result.getInteger("errCode");
        if (0 != errCode) {
            return null;
        } else {
            return "success";
        }
    }

    /**
     * 下载
     */
    public String download(String flowId) {
        Map<String, Object> map = new HashMap<>();
        map.put("flowId", flowId);
        String s = httpUtil.buildSign(url + "/sign/download", map);
        //"flowId":"c49be53c7e2347759eaf5f320a84c82d"
        JSONObject result = JSON.parseObject(s);
        int errCode = result.getInteger("errCode");
        if (0 != errCode) {
            return null;
        } else {
            String data = result.getString("data");
            JSONArray obj = JSON.parseArray(data);
            JSONObject jsonObject = (JSONObject) obj.get(0);
            return jsonObject.getString("docUrl");
        }
    }

}
