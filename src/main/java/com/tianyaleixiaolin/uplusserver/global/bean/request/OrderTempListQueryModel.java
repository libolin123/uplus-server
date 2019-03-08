package com.tianyaleixiaolin.uplusserver.global.bean.request;

/**
 * @author Mr.li wrote on 2018/11/20.
 */
public class OrderTempListQueryModel extends BaseModel {
    /**
     * 保单人
     */
    private String userName;

    /**
     * 状态（-1待审核，0正常，-2被拒绝）
     */
    private Integer status;
    private String mobile;
    /**
     * 修改人id
     */
    private Long operatorId;

    @Override
    public String toString() {
        return "OrderTempListQueryModel{" +
                "userName='" + userName + '\'' +
                ", status=" + status +
                ", mobile='" + mobile + '\'' +
                ", operatorId=" + operatorId +
                '}';
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Long getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(Long operatorId) {
        this.operatorId = operatorId;
    }
}
