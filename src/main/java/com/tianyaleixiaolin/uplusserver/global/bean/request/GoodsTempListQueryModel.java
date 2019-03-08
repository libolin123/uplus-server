package com.tianyaleixiaolin.uplusserver.global.bean.request;

/**
 * @author Mr.li wrote on 2018/11/20.
 */
public class GoodsTempListQueryModel extends BaseModel {
    /**
     * 商品名称
     */
    private String name;

    /**
     * 状态（-1待审核，0正常，-2被拒绝）
     */
    private Integer status;
    /**
     * 修改人id
     */
    private Long operatorId;

    @Override
    public String toString() {
        return "GoodsTempListQueryModel{" +
                "name='" + name + '\'' +
                ", status=" + status +
                ", operatorId=" + operatorId +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
