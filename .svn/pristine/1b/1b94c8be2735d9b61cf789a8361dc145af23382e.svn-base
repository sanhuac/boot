package com.byc.merchants.merchants_cms.qo;

/**
 * created by pht on 2018/9/17 0017
 */

import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * @author pht
 * @program merchants_cms
 * @date 2018/9/17 0017
 */
public class ApplyQueryObject extends QueryObject implements Serializable {
    private static final long serialVersionUID = 1648029480363568097L;

    /**
     * 关键字查询
     */
    private String keyword;

    /**
     * 时间查询
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date applyDate;

    /**
     * 开始时间
     */
    private Integer startTime;
    /**
     * 结束时间
     */
    private Integer endTime;

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public Date getApplyDate() {
        return applyDate;
    }

    public void setApplyDate(Date applyDate) {
        this.applyDate = applyDate;
    }

    public Integer getStartTime() {
        return startTime;
    }

    public void setStartTime(Integer startTime) {
        this.startTime = startTime;
    }

    public Integer getEndTime() {
        return endTime;
    }

    public void setEndTime(Integer endTime) {
        this.endTime = endTime;
    }

    @Override
    public String toString() {
        return "ApplyQueryObject{" +
                "keyword='" + keyword + '\'' +
                ", applyDate=" + applyDate +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                '}';
    }
}
