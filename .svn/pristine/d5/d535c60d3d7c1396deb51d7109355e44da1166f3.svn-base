package com.byc.merchants.merchants_cms.qo;/**
 * created by pht on 2018/9/11 0011
 */


import java.io.Serializable;
import java.util.Collections;
import java.util.List;

/**
 * 分页对象
 *
 * @author pht
 * @program merchants_cms
 * @date 2018/9/11 0011
 */
public class PageResult implements Serializable {

    private static final long serialVersionUID = -3352109842828410828L;
    //当前页
    private Integer currentPage;
    //每页条数
    private Integer pageSize;
    //上一页
    private Integer prePage;
    //下一页
    private Integer nextPage;
    //总页数
    private Integer totalPage;
    //总数量
    private Integer totalCount;

    private List list;

    public PageResult(Integer currentPage, Integer pageSize, Integer totalCount, List list) {
        //当前页
        this.currentPage = currentPage < 1 ? 1 : currentPage;
        //没页数
        this.pageSize = pageSize < 1 ? 10 : pageSize;
        //总数量
        this.totalCount = totalCount;
        //总页数
        this.totalPage = totalCount % pageSize == 0 ? totalCount / pageSize : (totalCount / pageSize) + 1;
        //计算开始页
        if (totalCount == 0) {
            this.totalPage = 1;
        }
        if (totalPage <= currentPage) {
            this.currentPage = totalPage;
        }
        this.list = list;
        //上一页
        this.prePage = currentPage - 1 <= 0 ? currentPage : currentPage - 1;
        //下一页
        this.nextPage = currentPage + 1 >= totalPage ? totalPage : currentPage + 1;

    }


    public static PageResult emptyResult() {
        return new PageResult(1, 10, 0, Collections.EMPTY_LIST);
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

    public Integer getPrePage() {
        return prePage;
    }

    public void setPrePage(Integer prePage) {
        this.prePage = prePage;
    }

    public Integer getNextPage() {
        return nextPage;
    }

    public void setNextPage(Integer nextPage) {
        this.nextPage = nextPage;
    }

    public Integer getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public List getList() {
        return list;
    }

    public void setList(List list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "PageResult{" +
                "currentPage=" + currentPage +
                ", pageSize=" + pageSize +
                ", prePage=" + prePage +
                ", nextPage=" + nextPage +
                ", totalPage=" + totalPage +
                ", totalCount=" + totalCount +
                ", list=" + list +
                '}';
    }
}
