package com.byc.merchants.merchants_cms.service.serviceImpl.store;

/**
 * created by pht on 2018/9/12 0012
 */

import com.byc.merchants.merchants_cms.bean.store.*;
import com.byc.merchants.merchants_cms.constant.Constant;
import com.byc.merchants.merchants_cms.dao.store.AccountMapper;
import com.byc.merchants.merchants_cms.exception.UnifiedException;
import com.byc.merchants.merchants_cms.qo.IncomeQueryObject;
import com.byc.merchants.merchants_cms.qo.PageResult;
import com.byc.merchants.merchants_cms.qo.WithdrawQueryObject;
import com.byc.merchants.merchants_cms.service.store.AccountService;
import com.byc.merchants.merchants_cms.util.RecordNoUtil;
import com.byc.merchants.merchants_cms.util.TimeUtils;
import com.byc.merchants.merchants_cms.util.ValidatorUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author pht
 * @program merchants_cms
 * @date 2018/9/12 0012
 */
@Service
@Slf4j
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountMapper accountMapper;

    /**
     * 收入列表
     *
     * @param mer_id
     * @param qo
     * @return
     */
    @Override
    public Map<String, Object> list(Integer mer_id, IncomeQueryObject qo) {

        Map<String, Object> resultMap = new HashMap<>();
        //参数的校验
        int count = accountMapper.queryForCount(mer_id, qo);

        PageResult pageResult = PageResult.emptyResult();
        if (count > 0) {
            List<Income> incomes = accountMapper.queryForList(mer_id, qo);
            pageResult = new PageResult(qo.getCurrentPage(), qo.getPageSize(), count, incomes);
        }
        resultMap.put("income_list", pageResult);
        //查询总收入
        double amount = accountMapper.selectTotalIncome(mer_id);
        resultMap.put("total_income", amount);

        return resultMap;
    }

    /**
     * 申请提现
     *
     * @param mer_id
     * @param withdraw_amount
     * @param bank_no
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void applyWithdraw(Integer mer_id, Double withdraw_amount, String bank_no) throws UnifiedException {

        /**
         * 参数校验
         */

        if (ValidatorUtils.isNull(mer_id)) {
            throw new UnifiedException(200014);
        }
        //银行卡号校验
        if (!ValidatorUtils.checkBankCard(bank_no)) {
            throw new UnifiedException(220003);
        }
        //获取银行卡名称
        String bankName = ValidatorUtils.getBankNameByBankNo(bank_no);
        if (ValidatorUtils.isNull(bankName)) {
            throw new UnifiedException(220006);
        }
        //金额校验
        if (ValidatorUtils.isNull(withdraw_amount)) {
            //金额为空
            throw new UnifiedException(220001);
        }
        double v = Double.parseDouble(Constant.MIN_WITHDRAW_AMOUNT);
        if (v > withdraw_amount) {
            //大于最小提现额度
            throw new UnifiedException(220002);
        }
        MerAccount account = accountMapper.selectAccountByMerId(mer_id);
        if (ValidatorUtils.isNull(account)) {
            throw new UnifiedException(200014);
        }
        Double usable_balance = account.getUsable_balance();
        if (withdraw_amount > usable_balance) {
            //可用余额不足
            throw new UnifiedException(220004);
        }
        Double frozen_amount = account.getFrozen_amount();
        //减掉可用余额
        usable_balance -= withdraw_amount;
        //增加冻结金额
        frozen_amount += withdraw_amount;
        //更新可用余额
        int count = accountMapper.updateUsableBalance(mer_id, usable_balance, frozen_amount);
        if (count != 1) {
            throw new UnifiedException(220005);
        }
        //生成提现记录
        Withdraw withdraw = new Withdraw();
        withdraw.setApply_time(Integer.parseInt(TimeUtils.getCurrentTimeStamp() + ""));
        withdraw.setMer_id(mer_id);
        withdraw.setReceipt_account(bank_no);
        withdraw.setReceipt_type(bankName);
        withdraw.setWithdraw_amount(withdraw_amount);
        String withdraw_no = RecordNoUtil.generateOrderNo();
        withdraw.setWithdraw_no(withdraw_no);
        int i = accountMapper.insertWithdrawNote(withdraw);
        if (i != 1) {
            throw new UnifiedException(220005);
        }
        //更新日志
        MerAccountLog accountLog = new MerAccountLog();
        accountLog.setAmount(withdraw_amount);
        accountLog.setCreate_time(Integer.parseInt(TimeUtils.getCurrentTimeStamp() + ""));
        accountLog.setMer_id(mer_id);
        accountLog.setTrade_no(withdraw_no);
        accountLog.setRemark("商家提现,可用余额减少:" + withdraw_amount + ",冻结金额增加: " + withdraw_amount + ",账户类型:" + bankName);
        int a = accountMapper.insertAccountLog(accountLog);
        if (a != 1) {
            throw new UnifiedException(220005);
        }
    }

    /**
     * 去提现页面
     *
     * @param mer_id
     */
    @Override
    public MerAccount toWithdraw(Integer mer_id) throws UnifiedException {
        //多余的校验
        if (ValidatorUtils.isNull(mer_id)) {
            throw new UnifiedException(200014);
        }
        //查询余额
        return accountMapper.selectAccountByMerId(mer_id);
    }

    /**
     * 提现记录列表
     *
     * @param mer_id 商户id
     * @param qo     高级查询对象
     * @return
     */
    @Override
    public PageResult withdrawList(Integer mer_id, WithdrawQueryObject qo) throws UnifiedException {

        //多余的检验
        if (ValidatorUtils.isNull(mer_id)) {
            throw new UnifiedException(200014);
        }

        //查询总数
        int count = accountMapper.queryForWithdrawCount(mer_id, qo);
        PageResult pageResult = PageResult.emptyResult();
        if (count > 0) {
            //查询列表
            List<Withdraw> withdrawList = accountMapper.queryForWithdrawList(mer_id, qo);
            pageResult = new PageResult(qo.getCurrentPage(), qo.getPageSize(), count, withdrawList);
        }


        return pageResult;
    }

    /**
     * 去退款
     *
     * @param mer_id
     */
    @Override
    public Map<String, Object> toRefund(Integer mer_id) throws UnifiedException {
        //无用的检验
        if (ValidatorUtils.isNull(mer_id)) {
            throw new UnifiedException(200014);
        }

        //查询保证金
        Double deposit = accountMapper.selectDepositByMerId(mer_id);
        Map<String, Object> map = new HashMap<>();
        if (ValidatorUtils.isNull(deposit)) {
            throw new UnifiedException(200008);
        }
        map.put("deposit", deposit);
        return map;


    }

    /**
     * 退款申请
     *
     * @param mer_id
     * @param bank_no
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void refund(Integer mer_id, String bank_no) throws UnifiedException {
        //多余的检验
        if (ValidatorUtils.isNull(mer_id)) {
            throw new UnifiedException(200014);
        }

        //银行卡号校验
        if (!ValidatorUtils.checkBankCard(bank_no)) {
            throw new UnifiedException(220003);
        }
        //获取银行卡名称
        String bankName = ValidatorUtils.getBankNameByBankNo(bank_no);
        if (ValidatorUtils.isNull(bankName)) {
            throw new UnifiedException(220006);
        }

        //查询保证金
        Double deposit = accountMapper.selectDepositByMerId(mer_id);
        if (ValidatorUtils.isNull(deposit) || 0 == deposit) {
            throw new UnifiedException(220007);
        }

        //保证金归零
        log.info("保证金归零...");
        int count = accountMapper.updateDeposit(mer_id, 0d);
        if (count != 1) {
            throw new UnifiedException(220009);
        }
        //生成退款记录
        log.info("开始生成退款记录...");
        MerRefund merRefund = new MerRefund();
        merRefund.setMer_id(mer_id);
        merRefund.setRefund_amount(deposit);
        merRefund.setReceipt_account(bank_no);
        merRefund.setReceipt_type(bankName);
        String refundNo = RecordNoUtil.get16();
        merRefund.setRefund_no(refundNo);
        merRefund.setApply_time(Integer.parseInt(TimeUtils.getCurrentTimeStamp() + ""));
        int i = accountMapper.insertRefundNote(merRefund);
        if (i != 1) {
            throw new UnifiedException(220009);
        }

        //更新资金流水记录
        log.info("更新资金流水记录...");
        MerAccountLog accountLog = new MerAccountLog();
        accountLog.setMer_id(mer_id);
        accountLog.setAmount(deposit);
        accountLog.setCreate_time(Integer.parseInt(TimeUtils.getCurrentTimeStamp() + ""));
        accountLog.setRemark("商户保证金退款申请,保证金账户减少:" + deposit + ",账户:" + bankName + "," + bank_no);
        accountLog.setTrade_no(refundNo);

        int a = accountMapper.insertAccountLog(accountLog);
        if (a != 1) {
            throw new UnifiedException(220009);
        }
    }
}
