package com.tianyaleixiaolin.uplusserver.global.bean.request;

/**
 * 待确认的公司列表
 * @author Mr.li wrote on 2018/11/15.
 */
public class CompanyTempListQueryModel extends BaseModel {
    /**
     * 公司名
     */
    private String name;
    /**
     * 修改人id
     */
    private Long operatorId;
    /**
     * 公司状态（-1待审核，0正常，-2被拒绝）
     */
    private Integer status;

    @Override
    public String toString() {
        return "CompanyListQueryModel{" +
                "name='" + name + '\'' +
                ", operatorId=" + operatorId +
                ", status=" + status +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(Long operatorId) {
        this.operatorId = operatorId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
