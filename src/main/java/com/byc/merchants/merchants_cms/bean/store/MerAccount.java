package com.byc.merchants.merchants_cms.bean.store;

/**
 * created by pht on 2018/9/13 0013
 */

import java.io.Serializable;

/**
 * 店铺账户
 *
 * @author pht
 * @program merchants_cms
 * @date 2018/9/13 0013
 */
public class MerAccount implements Serializable {

    private static final long serialVersionUID = -1532475269544384333L;

    /**
     * 账户id
     */
    private Integer account_id;
    /**
     * 商户id
     */
    private Integer mer_id;
    /**
     * 可用余额
     */
    private Double usable_balance;
    /**
     * 冻结金额
     */
    private Double frozen_amount;
    /**
     * 总收入
     */
    private Double total_income;

    /**
     * 今日收入
     */
    private Double today_income;


    public Integer getAccount_id() {
        return account_id;
    }

    public void setAccount_id(Integer account_id) {
        this.account_id = account_id;
    }

    public Integer getMer_id() {
        return mer_id;
    }

    public void setMer_id(Integer mer_id) {
        this.mer_id = mer_id;
    }


    public Double getUsable_balance() {
        return usable_balance;
    }

    public void setUsable_balance(Double usable_balance) {
        this.usable_balance = usable_balance;
    }

    public Double getFrozen_amount() {
        return frozen_amount;
    }

    public void setFrozen_amount(Double frozen_amount) {
        this.frozen_amount = frozen_amount;
    }

    public Double getTotal_income() {
        return total_income;
    }

    public void setTotal_income(Double total_income) {
        this.total_income = total_income;
    }

    public Double getToday_income() {
        return today_income;
    }

    public void setToday_income(Double today_income) {
        this.today_income = today_income;
    }

    @Override
    public String toString() {
        return "MerAccount{" +
                "account_id=" + account_id +
                ", mer_id=" + mer_id +
                ", usable_balance=" + usable_balance +
                ", frozen_amount=" + frozen_amount +
                ", total_income=" + total_income +
                ", today_income=" + today_income +
                '}';
    }
}
