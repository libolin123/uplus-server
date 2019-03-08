package com.tianyaleixiaolin.uplusserver.core.person.sign;


import com.tianyaleixiaolin.uplusserver.core.base.BaseDeleteEntity;

import javax.persistence.Entity;

/**
 * @author Mr.li wrote on 2018/10/25.
 * 签约
 */
@Entity
public class PtSign extends BaseDeleteEntity {

    /**
     * 地勤id
     */
    private Long groundPersonId;
    /**
     * 合同地址
     */
    private String docUrl;
    /**
     * 流程id
     */
    private String flowId;
    /**
     * 在e签宝的accountId
     */
    private String accountId;
    /**
     * 永久的签名地址
     */
    private String signUrl;

    @Override
    public String toString() {
        return "PtSign{" +
                "groundPersonId=" + groundPersonId +
                ", docUrl='" + docUrl + '\'' +
                ", flowId='" + flowId + '\'' +
                ", accountId='" + accountId + '\'' +
                ", signUrl='" + signUrl + '\'' +
                '}';
    }

    public String getDocUrl() {
        return docUrl;
    }

    public void setDocUrl(String docUrl) {
        this.docUrl = docUrl;
    }

    public String getFlowId() {
        return flowId;
    }

    public void setFlowId(String flowId) {
        this.flowId = flowId;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getSignUrl() {
        return signUrl;
    }

    public void setSignUrl(String signUrl) {
        this.signUrl = signUrl;
    }

    public Long getGroundPersonId() {
        return groundPersonId;
    }

    public void setGroundPersonId(Long groundPersonId) {
        this.groundPersonId = groundPersonId;
    }

}
