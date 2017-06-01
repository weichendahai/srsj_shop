package com.srsj.common.bo;

import java.util.List;

/**
 * Created by weichen on 2017/6/1.
 */
public class PageResponse<T> {
    private Integer page;
    private Integer pageSize;
    private Integer totalCount;
    private Integer pageCount;
    private List<T> itemList;

    public PageResponse() {
        super();
    }

    public PageResponse(int totalCount, List<T> itemList, PageRequest page) {
        this.page = page.getPage();
        this.pageSize = page.getPageSize();
        this.totalCount = totalCount;
        this.pageCount = page.getPageSize() <= 0 ? 0 : (totalCount
                % page.getPageSize() == 0) ? totalCount / page.getPageSize()
                : totalCount / page.getPageSize() + 1;
        this.itemList = itemList;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public Integer getPageCount() {
        return pageCount;
    }

    public void setPageCount(Integer pageCount) {
        this.pageCount = pageCount;
    }

    public List<T> getItemList() {
        return itemList;
    }

    public void setItemList(List<T> itemList) {
        this.itemList = itemList;
    }

    @Override
    public String toString() {
        return "PageResponse [page=" + page + ", pageSize=" + pageSize + ", totalCount=" + totalCount + ", pageCount=" + pageCount + ", itemList=" + itemList
                + "]";
    }

}
