package com.byc.merchants.merchants_cms.controller.index;

/**
 * created by pht on 2018/9/17 0017
 */

import com.byc.merchants.merchants_cms.annoation.CurrentUser;
import com.byc.merchants.merchants_cms.controller.BaseController;
import com.byc.merchants.merchants_cms.result.JsonResult;
import com.byc.merchants.merchants_cms.service.index.IndexService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 关于首页
 *
 * @author pht
 * @program merchants_cms
 * @date 2018/9/17 0017
 */
@RestController
@RequestMapping("/index")
@Slf4j
public class IndexController extends BaseController {

    @Autowired
    private IndexService indexService;

    @PostMapping("/merIndex")
    public ResponseEntity<JsonResult> index(@CurrentUser Integer mer_id) {
        JsonResult result = new JsonResult();

        log.info("商户首页请求参数: mer_id = " + mer_id);

        try {
            result = dealSuccess(indexService.merIndex(mer_id));
        } catch (Exception e) {
            result = dealException(e);
        }

        log.info("商户首页响应列表");
        return ResponseEntity.ok(result);
    }

}
