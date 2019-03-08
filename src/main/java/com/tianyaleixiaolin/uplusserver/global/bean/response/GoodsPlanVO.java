package com.tianyaleixiaolin.uplusserver.global.bean.response;

/**
 * @author Mr.li wrote on 2018/11/29.
 */
public class GoodsPlanVO {
    private Long id;
    /**
     * 计划名字
     */
    private String name;
    /**
     * 属于哪个企业
     */
    private Long companyId;
    /**
     * 商品名字集合，逗号分隔
     */
    private String goodsName;
    private Boolean deleteFlag;

    @Override
    public String toString() {
        return "GoodsPlanVO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", companyId=" + companyId +
                ", goodsName='" + goodsName + '\'' +
                ", deleteFlag=" + deleteFlag +
                '}';
    }

    public Boolean getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(Boolean deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }
}
