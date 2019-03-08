package com.tianyaleixiaolin.uplusserver.core.dict.area;


import javax.persistence.*;

/**
 * @author Mr.li wrote on 2018/11/1.
 */
@Entity
@Table(name = "area")
public class AreaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /**
     * 地区编码
     */
    private String areaCode;
    /**
     * 地区名
     */
    private String areaName;
    /**
     * 地区级别（1:省份province,2:市city,3:区县district,4:街道street）
     */
    private byte level;
    /**
     * 城市编码
     */
    private String cityCode;
    /**
     * 城市中心点（即：经纬度坐标）
     */
    private String center;
    /**
     * 地区父节点
     */
    private Long parentId;

    @Override
    public String toString() {
        return "AreaEntity{" +
                "id=" + id +
                ", areaCode='" + areaCode + '\'' +
                ", areaName='" + areaName + '\'' +
                ", level=" + level +
                ", cityCode='" + cityCode + '\'' +
                ", center='" + center + '\'' +
                ", parentId=" + parentId +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public byte getLevel() {
        return level;
    }

    public void setLevel(byte level) {
        this.level = level;
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public String getCenter() {
        return center;
    }

    public void setCenter(String center) {
        this.center = center;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }
}
