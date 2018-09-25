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
public class EarnestQueryObject extends QueryObject implements Serializable {

    private static final long serialVersionUID = 6053784185703963590L;

    /**
     * 申请时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date applyDate;

    /**
     * 用户名
     */
    private String userName;
    /**
     * 用户手机号
     */
    private String userPhone;

    private Integer startTime;
    private Integer endTime;

    public Date getApplyDate() {
        return applyDate;
    }

    public void setApplyDate(Date applyDate) {
        this.applyDate = applyDate;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
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
        return "EarnestQueryObject{" +
                "applyDate=" + applyDate +
                ", userName='" + userName + '\'' +
                ", userPhone='" + userPhone + '\'' +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                '}';
    }
}
