package com.tianyaleixiaolin.uplusserver.core.product;

import com.tianyaleixiaolin.uplusserver.core.person.GroundPersonService;
import com.tianyaleixiaolin.uplusserver.core.person.PtGroundPerson;
import com.tianyaleixiaolin.uplusserver.core.product.flow.PtOrderFlow;
import com.tianyaleixiaolin.uplusserver.core.product.order.ProductOrderService;
import com.tianyaleixiaolin.uplusserver.global.bean.BaseData;
import com.tianyaleixiaolin.uplusserver.global.bean.ResultGenerator;
import com.tianyaleixiaolin.uplusserver.global.bean.request.ProductOrderListQueryModel;
import com.tianyaleixiaolin.uplusserver.global.sms.SmsUtil;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 微信H5
 *
 * @author Mr.li wrote on 2018/11/12.
 */
@RestController
@RequestMapping("weChat")
public class WeChatController {
    @Resource
    private GroundPersonService groundPersonService;
    @Resource
    private ProductOrderService productOrderService;
    @Resource
    private SmsUtil smsUtil;
    @Resource
    private OrderFlowService orderFlowService;
    @Resource
    private QiniuService qiniuService;

    /**
     * 发短信
     */
    @GetMapping("sms")
    public BaseData sms(String mobile) {
        return smsUtil.send(mobile);
    }

    /**
     * 验证码判断
     */
    @GetMapping("checkCode")
    public BaseData checkSms(String mobile, String smsCode) {
        return groundPersonService.checkCode(mobile, smsCode);
    }

    @PostMapping("")
    public BaseData login(String mobile, String smsCode, String openid, String wechatName) {
        return groundPersonService.login(mobile, smsCode, openid, wechatName);
    }

    /**
     * 查看人员状态
     */
    @GetMapping("/personState")
    public BaseData get() {
        return groundPersonService.checkState();
    }

    /**
     * 地勤注册
     */
    @PostMapping("/regist")
    public BaseData add(PtGroundPerson ptGroundPerson) {
        return groundPersonService.add(ptGroundPerson);
    }

    @GetMapping("/orders")
    public BaseData orders(Boolean finish, String mobile, String userName) {
        ProductOrderListQueryModel productOrderListQueryModel = new ProductOrderListQueryModel();
        if (finish == null) {
            finish = false;
        }
        if (finish) {
            productOrderListQueryModel.setState(8);
        } else {
            productOrderListQueryModel.setNotState(8);
        }
        productOrderListQueryModel.setUserName(userName);
        productOrderListQueryModel.setMobile(mobile);
        return ResultGenerator.genSuccessResult(productOrderService.findAll(productOrderListQueryModel));
    }

    @GetMapping("/orders/{id}")
    public BaseData orderOne(@PathVariable Long id) {
        return ResultGenerator.genSuccessResult(productOrderService.find(id));
    }

    @GetMapping("/orders/{id}/words")
    public BaseData words(@PathVariable Long id) {
        return ResultGenerator.genSuccessResult(productOrderService.findWords(id));
    }

    @PutMapping("/orderFlow")
    public BaseData modify(PtOrderFlow ptOrderFlow) {
        return ResultGenerator.genSuccessResult(orderFlowService.addOrUpdate(ptOrderFlow));
    }

    /**
     * 获取七牛token
     */
    @GetMapping("/qiniu/token")
    public BaseData qiniuToken() {
        return ResultGenerator.genSuccessResult(qiniuService.token());
    }

    
}
