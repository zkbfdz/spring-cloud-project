package com.zhukai.cloud.common.model;

import com.zhukai.cloud.common.Enum.SortType;

public class CommonCondition {

    private Integer currentPage = 1;

    private Integer pageSize = 10;

    private String sortKey;

    private SortType sortType = SortType.ASC;

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public String getSortKey() {
        return sortKey;
    }

    public void setSortKey(String sortKey) {
        this.sortKey = sortKey;
    }

    public SortType getSortType() {
        return sortType;
    }

    public void setSortType(SortType sortType) {
        this.sortType = sortType;
    }
}
