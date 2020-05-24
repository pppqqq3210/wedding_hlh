package com.bailiban.wedding_hlh.entity;

import lombok.Data;

import java.util.List;

/**
 * 分页实体类（泛型，将类型作为参数，实现通用化）
 */
@Data
public class Page<T> {

    //数据集合
    private List<T> data;
    //页面总数
    private int pageCount;
    //当前页数
    private int currentPage;

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }
}
