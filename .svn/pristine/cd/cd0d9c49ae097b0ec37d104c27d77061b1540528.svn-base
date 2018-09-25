package com.byc.merchants.merchants_cms.qo;

/**
 * created by pht on 2018/9/14 0014
 */

import java.io.Serializable;

/**
 * 提现记录分页实体类
 *
 * @author pht
 * @program merchants_cms
 * @date 2018/9/14 0014
 */
public class WithdrawQueryObject extends QueryObject implements Serializable {
    private static final long serialVersionUID = -1431990750498791279L;

    /**
     * 开始时间
     */
    private Integer startTime;
    /**
     * 结束时间
     */
    private Integer endTime;
    /**
     * 提现状态(0:提现中,1:提现成功,2:提现失败)
     */
    private Integer status;

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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "WithdrawQueryObject{" +
                "startTime=" + startTime +
                ", endTime=" + endTime +
                ", status=" + status +
                '}';
    }
}
