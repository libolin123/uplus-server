package com.tianyaleixiaolin.uplusserver.global.bean.response;

import java.util.Date;

/**
 * @author Mr.li wrote on 2018/11/20.
 */
public class GoodsListVO {
    private Long id;
    /**
     * 商品名称
     */
    private String name;
    /**
     * 计划的名字
     */
    private String ptGoodsPlanName;
    /**
     * 商品生效时间
     */
    private Date beginTime;
    /**
     * 失效时间
     */
    private Date endTime;
    /**
     * 包含的优加服务
     */
    private String youServers;
    private Boolean deleteFlag;

    @Override
    public String toString() {
        return "GoodsListVO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", ptGoodsPlanName='" + ptGoodsPlanName + '\'' +
                ", beginTime=" + beginTime +
                ", endTime=" + endTime +
                ", youServers='" + youServers + '\'' +
                ", deleteFlag=" + deleteFlag +
                '}';
    }

    public Boolean getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(Boolean deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    public String getPtGoodsPlanName() {
        return ptGoodsPlanName;
    }

    public void setPtGoodsPlanName(String ptGoodsPlanName) {
        this.ptGoodsPlanName = ptGoodsPlanName;
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

    public Date getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(Date beginTime) {
        this.beginTime = beginTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getYouServers() {
        return youServers;
    }

    public void setYouServers(String youServers) {
        this.youServers = youServers;
    }
}
