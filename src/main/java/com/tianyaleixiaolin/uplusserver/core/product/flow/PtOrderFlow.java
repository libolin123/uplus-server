package com.tianyaleixiaolin.uplusserver.core.product.flow;

import com.tianyaleixiaolin.uplusserver.core.base.BaseEntity;

import javax.persistence.Entity;

/**
 * 订单各流程阶段
 * @author Mr.li wrote on 2018/12/3.
 */
@Entity
public class PtOrderFlow extends BaseEntity {
    private Long productOrderId;
    /**
     * 地勤人员id集合，逗号分隔
     */
    private String personIds;
    /**
     * 为null则是未接单。存在已派单，但未接单的情况
     */
    private Long groundPersonId;
    /**
     * 接单时间
     */
    private Long groundPersonIdTime;
    /**
     * 理赔相关信息的id
     */
    private Long claimId;
    /**
     * 生成理赔单，时间
     */
    private Long claimIdTime;
    /**
     * 与患者联系人沟通服务细节
     */
    private Boolean hasContact;
    /**
     * 沟通的内容
     */
    private String contactRemark;
    /**
     * 与患者联系人沟通服务细节，时间
     */
    private Long hasContactTime;
    /**
     * 检查并携带相关协议无误
     */
    private Boolean hasChecked;
    /**
     * 检查并携带相关协议无误，时间
     */
    private Long hasCheckedTime;
    /**
     * 提交押金垫付已签署文件。逗号分隔
     */
    private String prePayFiles;
    /**
     * 是否已确认"押金垫付的文件"
     */
    private Boolean prePayFileConfirm;
    /**
     * 是否已确认"押金垫付的文件"，确认时间
     */
    private Long prePayFileConfirmTime;
    /**
     * 确认垫付金额
     */
    private String prePayMoney;
    /**
     * 是否拒绝赔付，true为拒绝，null为没设置
     */
    private Boolean refusePay;
    /**
     * 确认垫付金额，确认时间
     */
    private Long prePayMoneyTime;
    /**
     * 住院押金条
     */
    private String depositFiles;
    /**
     * 住院押金条，确认时间
     */
    private Long depositFilesTime;
    /**
     * 是否驳回押金条
     */
    private Boolean refuseDeposit;
    /**
     * 出院结算明细
     */
    private String balanceFiles;
    /**
     * 出院结算明细，确认时间
     */
    private Long balanceFilesTime;
    /**
     * 是否驳回出院结算单子
     */
    private Boolean refuseBalance;
    /**
     * 需要追缴用户欠费xxx元
     */
    private Double needMoney;
    /**
     * 追缴完成
     */
    private Boolean finishNeedMoney;
    /**
     * 追缴完成，确认时间
     */
    private Long finishNeedMoneyTime;
    /**
     * 服务完成时间
     */
    private Long finishTime;

    @Override
    public String toString() {
        return "PtOrderFlow{" +
                "productOrderId=" + productOrderId +
                ", personIds='" + personIds + '\'' +
                ", groundPersonId=" + groundPersonId +
                ", groundPersonIdTime=" + groundPersonIdTime +
                ", claimId=" + claimId +
                ", claimIdTime=" + claimIdTime +
                ", hasContact=" + hasContact +
                ", contactRemark='" + contactRemark + '\'' +
                ", hasContactTime=" + hasContactTime +
                ", hasChecked=" + hasChecked +
                ", hasCheckedTime=" + hasCheckedTime +
                ", prePayFiles='" + prePayFiles + '\'' +
                ", prePayFileConfirm=" + prePayFileConfirm +
                ", prePayFileConfirmTime=" + prePayFileConfirmTime +
                ", prePayMoney='" + prePayMoney + '\'' +
                ", refusePay=" + refusePay +
                ", prePayMoneyTime=" + prePayMoneyTime +
                ", depositFiles='" + depositFiles + '\'' +
                ", depositFilesTime=" + depositFilesTime +
                ", refuseDeposit=" + refuseDeposit +
                ", balanceFiles='" + balanceFiles + '\'' +
                ", balanceFilesTime=" + balanceFilesTime +
                ", refuseBalance=" + refuseBalance +
                ", needMoney=" + needMoney +
                ", finishNeedMoney=" + finishNeedMoney +
                ", finishNeedMoneyTime=" + finishNeedMoneyTime +
                ", finishTime=" + finishTime +
                '}';
    }

    public String getContactRemark() {
        return contactRemark;
    }

    public void setContactRemark(String contactRemark) {
        this.contactRemark = contactRemark;
    }

    public String getPersonIds() {
        return personIds;
    }

    public void setPersonIds(String personIds) {
        this.personIds = personIds;
    }

    public Long getGroundPersonIdTime() {
        return groundPersonIdTime;
    }

    public void setGroundPersonIdTime(Long groundPersonIdTime) {
        this.groundPersonIdTime = groundPersonIdTime;
    }

    public Long getClaimIdTime() {
        return claimIdTime;
    }

    public void setClaimIdTime(Long claimIdTime) {
        this.claimIdTime = claimIdTime;
    }

    public Boolean getHasContact() {
        return hasContact;
    }

    public Boolean getPrePayFileConfirm() {
        return prePayFileConfirm;
    }

    public Long getHasContactTime() {
        return hasContactTime;
    }

    public void setHasContactTime(Long hasContactTime) {
        this.hasContactTime = hasContactTime;
    }

    public Long getHasCheckedTime() {
        return hasCheckedTime;
    }

    public void setHasCheckedTime(Long hasCheckedTime) {
        this.hasCheckedTime = hasCheckedTime;
    }

    public Long getPrePayFileConfirmTime() {
        return prePayFileConfirmTime;
    }

    public void setPrePayFileConfirmTime(Long prePayFileConfirmTime) {
        this.prePayFileConfirmTime = prePayFileConfirmTime;
    }

    public Long getPrePayMoneyTime() {
        return prePayMoneyTime;
    }

    public void setPrePayMoneyTime(Long prePayMoneyTime) {
        this.prePayMoneyTime = prePayMoneyTime;
    }

    public Long getDepositFilesTime() {
        return depositFilesTime;
    }

    public void setDepositFilesTime(Long depositFilesTime) {
        this.depositFilesTime = depositFilesTime;
    }

    public Long getBalanceFilesTime() {
        return balanceFilesTime;
    }

    public void setBalanceFilesTime(Long balanceFilesTime) {
        this.balanceFilesTime = balanceFilesTime;
    }

    public Long getFinishNeedMoneyTime() {
        return finishNeedMoneyTime;
    }

    public void setFinishNeedMoneyTime(Long finishNeedMoneyTime) {
        this.finishNeedMoneyTime = finishNeedMoneyTime;
    }

    public Long getProductOrderId() {
        return productOrderId;
    }

    public void setProductOrderId(Long productOrderId) {
        this.productOrderId = productOrderId;
    }

    public Long getGroundPersonId() {
        return groundPersonId;
    }

    public void setGroundPersonId(Long groundPersonId) {
        this.groundPersonId = groundPersonId;
    }

    public Long getClaimId() {
        return claimId;
    }

    public void setClaimId(Long claimId) {
        this.claimId = claimId;
    }

    public Boolean isHasContact() {
        return hasContact;
    }

    public void setHasContact(Boolean hasContact) {
        this.hasContact = hasContact;
    }

    public Boolean getHasChecked() {
        return hasChecked;
    }

    public Boolean isHasChecked() {
        return hasChecked;
    }

    public void setHasChecked(Boolean hasChecked) {
        this.hasChecked = hasChecked;
    }

    public String getPrePayFiles() {
        return prePayFiles;
    }

    public void setPrePayFiles(String prePayFiles) {
        this.prePayFiles = prePayFiles;
    }

    public Boolean isPrePayFileConfirm() {
        return prePayFileConfirm;
    }

    public void setPrePayFileConfirm(Boolean prePayFileConfirm) {
        this.prePayFileConfirm = prePayFileConfirm;
    }

    public String getPrePayMoney() {
        return prePayMoney;
    }

    public void setPrePayMoney(String prePayMoney) {
        this.prePayMoney = prePayMoney;
    }

    public Boolean getRefusePay() {
        return refusePay;
    }

    public void setRefusePay(Boolean refusePay) {
        this.refusePay = refusePay;
    }

    public String getDepositFiles() {
        return depositFiles;
    }

    public void setDepositFiles(String depositFiles) {
        this.depositFiles = depositFiles;
    }

    public Boolean getRefuseDeposit() {
        return refuseDeposit;
    }

    public void setRefuseDeposit(Boolean refuseDeposit) {
        this.refuseDeposit = refuseDeposit;
    }

    public String getBalanceFiles() {
        return balanceFiles;
    }

    public void setBalanceFiles(String balanceFiles) {
        this.balanceFiles = balanceFiles;
    }

    public Boolean getRefuseBalance() {
        return refuseBalance;
    }

    public void setRefuseBalance(Boolean refuseBalance) {
        this.refuseBalance = refuseBalance;
    }

    public Double getNeedMoney() {
        return needMoney;
    }

    public void setNeedMoney(Double needMoney) {
        this.needMoney = needMoney;
    }

    public Boolean getFinishNeedMoney() {
        return finishNeedMoney;
    }

    public void setFinishNeedMoney(Boolean finishNeedMoney) {
        this.finishNeedMoney = finishNeedMoney;
    }

    public Long getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(Long finishTime) {
        this.finishTime = finishTime;
    }
}
