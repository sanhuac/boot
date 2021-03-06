package com.byc.merchants.merchants_cms.qo;

/**
 * created by pht on 2018/9/11 0011
 */

import io.swagger.annotations.ApiModelProperty;

/**
 * @author pht
 * @program merchants_cms
 * @date 2018/9/11 0011
 */
public class QueryObject {

    @ApiModelProperty(value = "当前页", name = "currentPage", example = "1")

    private Integer currentPage = 1;
    @ApiModelProperty(value = "每页条数", name = "pageSize", example = "10")
    private Integer pageSize = 10;
    @ApiModelProperty(hidden = true)
    private Integer startIndex;

    public Integer getStartIndex() {
        this.currentPage = currentPage == null || currentPage == 0 ? 1 : currentPage;
        this.pageSize = pageSize == null || pageSize == 0 ? 10 : pageSize;
        return (currentPage - 1) * pageSize;
    }

    public void setStartIndex(Integer startIndex) {
        this.startIndex = (currentPage - 1) * pageSize;
    }

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

    @Override
    public String toString() {
        return "QueryObject{" +
                "currentPage=" + currentPage +
                ", pageSize=" + pageSize +
                '}';
    }
}
