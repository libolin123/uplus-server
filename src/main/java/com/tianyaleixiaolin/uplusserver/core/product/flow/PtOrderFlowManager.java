package com.tianyaleixiaolin.uplusserver.core.product.flow;

import com.tianyaleixiaolin.uplusserver.core.product.order.PtProductOrder;
import com.tianyaleixiaolin.uplusserver.core.product.order.PtProductOrderManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;

/**
 * @author wuwf
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class PtOrderFlowManager {
    @Resource
    private PtOrderFlowRepository ptOrderFlowRepository;
    @Resource
    private PtProductOrderManager ptProductOrderManager;

    public PtOrderFlow findByProductOrderId(Long productOrderId) {
        return ptOrderFlowRepository.findFirstByProductOrderId(productOrderId);
    }

    public PtOrderFlow add(PtOrderFlow ptOrderFlow) {
        return save(ptOrderFlow);
    }

    public PtOrderFlow update(PtOrderFlow ptOrderFlow) {
        return save(ptOrderFlow);
    }

    public PtOrderFlow find(Long id) {
        return ptOrderFlowRepository.getOne(id);
    }

    public boolean exist(Long id) {
        return ptOrderFlowRepository.existsById(id);
    }

    private PtOrderFlow save(PtOrderFlow ptOrderFlow) {
        ptOrderFlowRepository.save(ptOrderFlow);

        PtOrderFlow flow = ptOrderFlowRepository.getOne(ptOrderFlow.getId());

        PtProductOrder ptProductOrder = ptProductOrderManager.find(flow.getProductOrderId());
        ptOrderFlow.setGroundPersonId(ptProductOrder.getGroundPersonId());
        ptOrderFlowRepository.save(ptOrderFlow);


        //已接单
        if (flow.getGroundPersonId() != null) {
            ptProductOrder.setState("3");
            if (flow.getHasContact() != null && flow.getHasContact()) {
                ptProductOrder.setChildState("4");
            } else {
                ptProductOrder.setChildState("3");
            }
        }
        //检查资料
        if (flow.getHasChecked() != null) {
            ptProductOrder.setState("4");
            if (flow.getHasChecked()) {
                ptProductOrder.setChildState("6");
            } else {
                ptProductOrder.setChildState("5");
            }
            if (flow.getPrePayFileConfirm() != null) {
                if (flow.getPrePayFileConfirm()) {
                    ptProductOrder.setChildState("8");
                } else {
                    ptProductOrder.setChildState("7");
                }
            }
        }
        //是否同意垫付
        if (flow.getRefusePay() != null) {
            //拒绝垫付
            if (flow.getRefusePay()) {
                ptProductOrder.setState("6");
            } else {
                //同意垫付
                ptProductOrder.setState("5");
            }
            //垫付金额
            if (flow.getPrePayMoney() != null) {
                ptProductOrder.setChildState("9");
            }
            //已上传付款凭证
            if (!StringUtils.isEmpty(flow.getDepositFiles())) {
                ptProductOrder.setChildState("11");
            }
        }
        //出院
        if (!StringUtils.isEmpty(flow.getBalanceFiles())) {
            ptProductOrder.setState("7");
            //如果没有设置
            if (flow.getRefuseBalance() != null && !flow.getRefuseBalance()) {
                ptProductOrder.setChildState("13");
            } else {
                ptProductOrder.setChildState("12");
            }
            //说明有追缴
            if (flow.getNeedMoney() != null) {
                if (flow.getFinishNeedMoney() != null && flow.getFinishNeedMoney()) {
                    ptProductOrder.setChildState("16");
                } else {
                    ptProductOrder.setChildState("15");
                }
            }
        }
        //已完成
        if (flow.getFinishTime() != null) {
            ptProductOrder.setState("8");
            if (flow.getClaimId() != null) {
                ptProductOrder.setChildState("18");
            } else {
                ptProductOrder.setChildState("17");
            }
        }
        ptProductOrderManager.update(ptProductOrder);
        return flow;
    }

    public void delete(PtOrderFlow ptOrderFlow) {
        ptOrderFlowRepository.delete(ptOrderFlow);
    }

}
