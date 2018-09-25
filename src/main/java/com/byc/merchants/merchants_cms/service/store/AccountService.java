package com.byc.merchants.merchants_cms.service.store;

import com.byc.merchants.merchants_cms.bean.store.MerAccount;
import com.byc.merchants.merchants_cms.exception.UnifiedException;
import com.byc.merchants.merchants_cms.qo.IncomeQueryObject;
import com.byc.merchants.merchants_cms.qo.PageResult;
import com.byc.merchants.merchants_cms.qo.WithdrawQueryObject;

import java.util.Map;

/**
 * created by pht on 2018/9/12 0012
 */
public interface AccountService {
    /**
     * 收入列表
     *
     * @param mer_id
     * @param qo
     * @return
     */
    Map<String, Object> list(Integer mer_id, IncomeQueryObject qo);

    /**
     * 申请提现
     *
     * @param mer_id
     * @param withdraw_amount
     * @param bank_no
     * @return
     */
    void applyWithdraw(Integer mer_id, Double withdraw_amount, String bank_no) throws UnifiedException;

    /**
     * 去提现
     *
     * @param mer_id
     */
    MerAccount toWithdraw(Integer mer_id) throws UnifiedException;

    /**
     * 提现记录
     * @param mer_id
     * @param qo
     * @return
     */
    PageResult withdrawList(Integer mer_id, WithdrawQueryObject qo) throws UnifiedException;

    /**
     * 去退款页面
     * @param mer_id
     */
    Map<String, Object> toRefund(Integer mer_id) throws UnifiedException;

    /**
     * 退款申请
     * @param mer_id
     * @param bank_no
     */
    void refund(Integer mer_id, String bank_no) throws UnifiedException;
}
