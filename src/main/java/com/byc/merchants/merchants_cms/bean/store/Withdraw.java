package com.byc.merchants.merchants_cms.bean.store;

/**
 * created by pht on 2018/9/13 0013
 */

import java.io.Serializable;

/**
 * 提现记录实体类
 *
 * @author pht
 * @program merchants_cms
 * @date 2018/9/13 0013
 */
public class Withdraw implements Serializable {

    private static final long serialVersionUID = -492047389835344157L;

    private Integer withdraw_id; //'提现申请id',
    private String withdraw_no; //'提现编号',
    private Integer mer_id; //'提现申请人',
    private Double withdraw_amount; //'提现金额',
    private String receipt_type; // '收款类型(招商银行类似)',
    private String receipt_account; //'收款账号',
    private Integer apply_time; // '申请时间',
    private Integer pay_time; // '打款时间',
    private Integer admin_id; // '打款审批人id',
    private String name; //审核人姓名
    private Integer withdraw_status; // '提现状态(0:提现中,1:提现成功,2:提现失败)',
    private String remark; // '提现说明',

    public Integer getWithdraw_id() {
        return withdraw_id;
    }

    public void setWithdraw_id(Integer withdraw_id) {
        this.withdraw_id = withdraw_id;
    }

    public String getWithdraw_no() {
        return withdraw_no;
    }

    public void setWithdraw_no(String withdraw_no) {
        this.withdraw_no = withdraw_no;
    }

    public Integer getMer_id() {
        return mer_id;
    }

    public void setMer_id(Integer mer_id) {
        this.mer_id = mer_id;
    }

    public Double getWithdraw_amount() {
        return withdraw_amount;
    }

    public void setWithdraw_amount(Double withdraw_amount) {
        this.withdraw_amount = withdraw_amount;
    }

    public String getReceipt_type() {
        return receipt_type;
    }

    public void setReceipt_type(String receipt_type) {
        this.receipt_type = receipt_type;
    }

    public String getReceipt_account() {
        return receipt_account;
    }

    public void setReceipt_account(String receipt_account) {
        this.receipt_account = receipt_account;
    }

    public Integer getApply_time() {
        return apply_time;
    }

    public void setApply_time(Integer apply_time) {
        this.apply_time = apply_time;
    }

    public Integer getPay_time() {
        return pay_time;
    }

    public void setPay_time(Integer pay_time) {
        this.pay_time = pay_time;
    }

    public Integer getAdmin_id() {
        return admin_id;
    }

    public void setAdmin_id(Integer admin_id) {
        this.admin_id = admin_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getWithdraw_status() {
        return withdraw_status;
    }

    public void setWithdraw_status(Integer withdraw_status) {
        this.withdraw_status = withdraw_status;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "Withdraw{" +
                "withdraw_id=" + withdraw_id +
                ", withdraw_no='" + withdraw_no + '\'' +
                ", mer_id=" + mer_id +
                ", withdraw_amount=" + withdraw_amount +
                ", receipt_type='" + receipt_type + '\'' +
                ", receipt_account='" + receipt_account + '\'' +
                ", apply_time=" + apply_time +
                ", pay_time=" + pay_time +
                ", admin_id=" + admin_id +
                ", name='" + name + '\'' +
                ", withdraw_status=" + withdraw_status +
                ", remark='" + remark + '\'' +
                '}';
    }
}
