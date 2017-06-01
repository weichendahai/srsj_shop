package com.srsj.common.bo;

import org.apache.commons.lang3.StringUtils;

/**
 * Created by weichen on 2017/6/1.
 */
public class PageRequest{
    private Integer page = 1;
    private Integer pageSize = 10;
    private String sortField;
    private String sortOrder;

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

    public String getSortField() {
        return sortField;
    }

    public void setSortField(String sortField) {
        this.sortField = sortField;
    }

    public String getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(String sortOrder) {
        this.sortOrder = sortOrder;
    }

    public String getSortCondition() {
        if (StringUtils.isNotEmpty(sortField)) {
            StringBuilder sortStr = new StringBuilder();
            sortStr.append(" order by ")
                    .append(sortField)
                    .append(StringUtils.equals(sortOrder, "asc") ? " asc "
                            : " desc ");
            return sortStr.toString();
        }
        return null;
    }

    public String getLimitCondition() {
        StringBuilder limitStr = new StringBuilder();
        limitStr.append(" limit ").append((page - 1) * pageSize).append(" , ")
                .append(pageSize);
        return limitStr.toString();
    }
}
