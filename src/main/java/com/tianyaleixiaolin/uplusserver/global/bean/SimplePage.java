package com.tianyaleixiaolin.uplusserver.global.bean;

import org.springframework.data.domain.Page;

import java.util.List;

/**
 * @author Mr.li wrote on 2018/10/26.
 */
public class SimplePage<T> {
    private int totalPage;
    private long totalCount;
    private List<T> list;

    public SimplePage() {
    }

    public SimplePage(int totalPage, long totalCount, List<T> list) {
        this.totalPage = totalPage;
        this.totalCount = totalCount;
        this.list = list;
    }

    public SimplePage(Page<T> page) {
        this.totalCount = page.getTotalElements();
        this.totalPage = page.getTotalPages();
        this.list = page.getContent();
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public long getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(long totalCount) {
        this.totalCount = totalCount;
    }

    public List<?> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "SimplePage{" +
                "totalPage=" + totalPage +
                ", totalCount=" + totalCount +
                ", list=" + list +
                '}';
    }
}
