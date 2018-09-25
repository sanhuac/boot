package com.byc.merchants.merchants_cms.controller.apply;

/**
 * created by pht on 2018/9/17 0017
 */

import com.byc.merchants.merchants_cms.annoation.CurrentUser;
import com.byc.merchants.merchants_cms.controller.BaseController;
import com.byc.merchants.merchants_cms.qo.InsuranceQueryObject;
import com.byc.merchants.merchants_cms.result.JsonResult;
import com.byc.merchants.merchants_cms.service.apply.InsuranceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 保险申请相关
 *
 * @author pht
 * @program merchants_cms
 * @date 2018/9/17 0017
 */
@RestController
@RequestMapping("/insuranceApply")
@Slf4j
public class InsuranceController extends BaseController {

    @Autowired
    private InsuranceService insuranceService;

    /**
     * 保险申请列表
     *
     * @param mer_id
     * @param qo
     * @return
     */
    @PostMapping("/insuranceList")
    public ResponseEntity<JsonResult> insuranceList(@CurrentUser Integer mer_id, InsuranceQueryObject qo) {

        JsonResult result = new JsonResult();
        log.info("保险列表请求参数:mer_id = " + mer_id + ",qo = " + qo);

        try {
            result = dealSuccess(insuranceService.insuranceList(mer_id, qo));
        } catch (Exception e) {
            result = dealException(e);
        }

        log.info("保险列表响应信息:" + result);
        return ResponseEntity.ok(result);
    }
}
