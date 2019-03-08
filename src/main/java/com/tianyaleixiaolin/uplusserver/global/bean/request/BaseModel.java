package com.tianyaleixiaolin.uplusserver.global.bean.request;

/**
 * @author Mr.li wrote on 2018/11/15.
 */
public class BaseModel {
    private Integer page = 0;
    private Integer size = 20;


    @Override
    public String toString() {
        return "BaseModel{" +
                "page=" + page +
                ", size=" + size +
                '}';
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }
}
