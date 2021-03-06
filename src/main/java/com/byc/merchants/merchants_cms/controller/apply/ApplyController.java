package com.byc.merchants.merchants_cms.controller.apply;

/**
 * created by pht on 2018/9/17 0017
 */

import com.byc.merchants.merchants_cms.annoation.CurrentUser;
import com.byc.merchants.merchants_cms.controller.BaseController;
import com.byc.merchants.merchants_cms.qo.ApplyQueryObject;
import com.byc.merchants.merchants_cms.qo.EarnestQueryObject;
import com.byc.merchants.merchants_cms.result.JsonResult;
import com.byc.merchants.merchants_cms.service.apply.ApplyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 关于车辆预约
 *
 * @author pht
 * @program merchants_cms
 * @date 2018/9/17 0017
 */
@RestController
@RequestMapping("/apply")
@Slf4j
public class ApplyController extends BaseController {


    @Autowired
    private ApplyService applyService;

    /**
     * 预约列表
     *
     * @param mer_id
     * @return
     */
    @PostMapping("/subscribeList")
    public ResponseEntity<JsonResult> subscribeList(@CurrentUser Integer mer_id, ApplyQueryObject qo) {
        JsonResult result = new JsonResult();

        log.info("预约列表请求参数:mer_id" + mer_id);

        try {
            result = dealSuccess(applyService.subscribeList(mer_id, qo));
        } catch (Exception e) {
            result = dealException(e);
        }

        log.info("预约列表响应:" + result);
        return ResponseEntity.ok(result);
    }

    /**
     * 定金购车列表
     *
     * @param mer_id
     * @return
     */
    @PostMapping("/earnestList")
    public ResponseEntity<JsonResult> earnestList(@CurrentUser Integer mer_id, EarnestQueryObject qo) {
        JsonResult result = new JsonResult();

        log.info("定金购车列表请求参数:mer_id = " + mer_id + ",qo = " + qo);

        try {
            result = dealSuccess(applyService.earnestList(mer_id, qo));
        } catch (Exception e) {
            result = dealException(e);
        }

        log.info("定金购车列表响应信息:" + result);
        return ResponseEntity.ok(result);
    }

}
