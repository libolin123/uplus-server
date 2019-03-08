package com.tianyaleixiaolin.uplusserver.global.bean.request;

/**
 * @author Mr.li wrote on 2018/11/15.
 */
public class CompanyListQueryModel extends BaseModel {
    /**
     * 公司名
     */
    private String name;
    /**
     * 公司类型，group=7
     */
    private String type;

    @Override
    public String toString() {
        return "CompanyListQueryModel{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
