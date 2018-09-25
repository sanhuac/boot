package com.byc.merchants.merchants_cms.bean.store;

/**
 * created by pht on 2018/9/13 0013
 */

import java.io.Serializable;

/**
 * 商户资金流水
 *
 * @author pht
 * @program merchants_cms
 * @date 2018/9/13 0013
 */
public class MerAccountLog implements Serializable {

    private static final long serialVersionUID = -3807076965810662798L;
    private Integer log_id;          // '店铺资金流水表主键',
    private Integer mer_id;          // '商户id',
    private String trade_no;        // '订单号',
    private Integer pay_type;        // '支付类型:  00 微信, 01 支付宝, 02 花呗分期 03 工商支付',
    private Double amount;           // '操作金额',
    private String remark;           // '流水备注(用途之类)',
    private String result_info;      // '资金处理结果',
    private String request_params;   // '请求参数',
    private Integer create_time;      //'资金发生时间',

    public Integer getLog_id() {
        return log_id;
    }

    public void setLog_id(Integer log_id) {
        this.log_id = log_id;
    }

    public Integer getMer_id() {
        return mer_id;
    }

    public void setMer_id(Integer mer_id) {
        this.mer_id = mer_id;
    }

    public String getTrade_no() {
        return trade_no;
    }

    public void setTrade_no(String trade_no) {
        this.trade_no = trade_no;
    }

    public Integer getPay_type() {
        return pay_type;
    }

    public void setPay_type(Integer pay_type) {
        this.pay_type = pay_type;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getResult_info() {
        return result_info;
    }

    public void setResult_info(String result_info) {
        this.result_info = result_info;
    }

    public String getRequest_params() {
        return request_params;
    }

    public void setRequest_params(String request_params) {
        this.request_params = request_params;
    }

    public Integer getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Integer create_time) {
        this.create_time = create_time;
    }

    @Override
    public String toString() {
        return "MerAccountLog{" +
                "log_id=" + log_id +
                ", mer_id=" + mer_id +
                ", trade_no=" + trade_no +
                ", pay_type=" + pay_type +
                ", amount=" + amount +
                ", remark='" + remark + '\'' +
                ", result_info='" + result_info + '\'' +
                ", request_params='" + request_params + '\'' +
                ", create_time='" + create_time + '\'' +
                '}';
    }
}
