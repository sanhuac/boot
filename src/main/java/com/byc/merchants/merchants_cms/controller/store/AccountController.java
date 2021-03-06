package com.byc.merchants.merchants_cms.controller.store;

/**
 * created by pht on 2018/9/12 0012
 */

import com.byc.merchants.merchants_cms.annoation.CurrentUser;
import com.byc.merchants.merchants_cms.controller.BaseController;
import com.byc.merchants.merchants_cms.qo.IncomeQueryObject;
import com.byc.merchants.merchants_cms.qo.PageResult;
import com.byc.merchants.merchants_cms.qo.WithdrawQueryObject;
import com.byc.merchants.merchants_cms.result.JsonResult;
import com.byc.merchants.merchants_cms.service.store.AccountService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 店铺账户相关业务
 *
 * @author pht
 * @program merchants_cms
 * @date 2018/9/12 0012
 */

@Api(value = "财务模块", tags = {"财务管理"})
@RequestMapping("/account")
@RestController
@Slf4j
public class AccountController extends BaseController {

    @Autowired
    private AccountService accountService;

    /**
     * 收入列表
     *
     * @return
     */

    @PostMapping("/incomeList")
    @ApiOperation(value = "收入列表", notes = "店铺的收入列表,以及一些收入详情")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "accessId", value = "登录tokenId", required = true, dataType = "string"),
            @ApiImplicitParam(name = "mer_id", value = "不用传", dataType = "int"),
    })
    public ResponseEntity<JsonResult> incomeList(@CurrentUser Integer mer_id, IncomeQueryObject qo) {
        JsonResult result = new JsonResult();

        log.info("店铺收入列表请求参数:" + mer_id);

        try {
            result = dealSuccess(accountService.list(mer_id, qo));
        } catch (Exception e) {
            result = dealException(e);
        }

        log.info("店铺收入列表响应参数:" + result);
        return ResponseEntity.ok(result);
    }

    /**
     * 去提现页面
     *
     * @param mer_id
     * @return 可用余额
     */
    @PostMapping("/toWithdraw")
    @ApiOperation(value = "去提现页面,返回可用余额")
    public ResponseEntity<JsonResult> toWithdraw(@CurrentUser Integer mer_id) {
        JsonResult result = new JsonResult();

        log.info("去提现页面请求参数:mer_id = " + mer_id);

        try {
            result = dealSuccess(accountService.toWithdraw(mer_id));
        } catch (Exception e) {
            result = dealException(e);
        }

        log.info("去提现页面响应参数:" + result);
        return ResponseEntity.ok(result);
    }

    /**
     * 申请提现
     *
     * @param mer_id
     * @param withdraw_amount
     * @param bank_no
     * @return
     */
    @PostMapping("/applyWithdraw")
    @ApiOperation(value = "申请提现", notes = "店铺申请提现")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "accessId", value = "登录tokenId", required = true, dataType = "string"),
            @ApiImplicitParam(name = "withdraw_amount", value = "提现金额", required = true, dataType = "double"),
            @ApiImplicitParam(name = "bank_no", value = "银行卡号", required = true, dataType = "string"),
            @ApiImplicitParam(name = "mer_id", value = "不用传", dataType = "int"),
    })
    public ResponseEntity<JsonResult> applyWithdraw(@CurrentUser Integer mer_id, Double withdraw_amount, String bank_no) {
        JsonResult result = new JsonResult();

        log.info("申请提现请求参数:" + mer_id);

        try {
            accountService.applyWithdraw(mer_id, withdraw_amount, bank_no);
            result = dealSuccess();
        } catch (Exception e) {
            result = dealException(e);
        }

        log.info("申请提现响应参数:" + result);
        return ResponseEntity.ok(result);
    }


    /**
     * 体现记录
     *
     * @param mer_id
     * @return
     */
    @PostMapping("/withdrawList")
    public ResponseEntity<JsonResult> withdrawList(@CurrentUser Integer mer_id, WithdrawQueryObject qo) {
        JsonResult result = new JsonResult();

        log.info("提现记录列表请求参数:mer_id = " + mer_id + ",qo = " + qo);

        try {
            result = dealSuccess(accountService.withdrawList(mer_id, qo));
        } catch (Exception e) {
            result = dealException(e);
        }

        log.info("提现记录列表响应参数:" + result);
        return ResponseEntity.ok(result);
    }

    /**
     * 退保证金页面,返回保证金金额
     *
     * @param mer_id
     * @return
     */
    @PostMapping("/toRefund")
    public ResponseEntity<JsonResult> toRefund(@CurrentUser Integer mer_id) {
        JsonResult result = new JsonResult();
        log.info("保证金退款页面请求参数:mer_id = " + mer_id);
        try {
            result = dealSuccess(accountService.toRefund(mer_id));
        } catch (Exception e) {
            result = dealException(e);
        }

        log.info("保证金退款页面响应参数:" + result);
        return ResponseEntity.ok(result);
    }


    /**
     * 保证金退款申请(发起申请,退款完成后删除当前店铺)
     *
     * @param mer_id
     * @param refund_amount
     * @param bank_no
     * @return
     */
    @PostMapping("/refund")
    public ResponseEntity<JsonResult> refund(@CurrentUser Integer mer_id, String bank_no) {
        JsonResult result = new JsonResult();

        log.info("保证金退款提交请求参数: mer_id = " + mer_id + ", bank_no = " + bank_no);

        try {
            accountService.refund(mer_id,  bank_no);
            result = dealSuccess();
        } catch (Exception e) {
            result = dealException(e);
        }

        log.info("保证金退款提交响应参数:" + result);
        return ResponseEntity.ok(result);
    }
}
