package com.byc.merchants.merchants_cms.controller.pay;

import com.byc.merchants.merchants_cms.annoation.CurrentUser;
import com.byc.merchants.merchants_cms.controller.BaseController;
import com.byc.merchants.merchants_cms.model.pay.DepositLogModel;
import com.byc.merchants.merchants_cms.result.JsonResult;
import com.byc.merchants.merchants_cms.service.pay.DepositService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: 胡丛
 * @Date: 2018/9/11 13:37
 * @Description: 支付接口
 */
@RestController
@RequestMapping("/pay")
@Api(value = "支付接口", tags = {"支付接口"})
@Slf4j
public class PayController extends BaseController{


    @Autowired
    private DepositService depositService;


    /**
     *@描述 添加定金日志
     *@参数
     *@返回值
     *@创建人  胡丛
     *@创建时间  2018/9/10
     *@修改人和其它信息
     */
    @ApiOperation(value="添加定金日志", notes="添加定金日志")
    @RequestMapping(value = "updateStoreLogo",method = RequestMethod.POST)
    public ResponseEntity<JsonResult> depositLog(DepositLogModel model, @CurrentUser Integer merId){
        model.setMer_id(merId);
        log.info("添加定金日志参数:"+model);
        JsonResult result = new JsonResult();
        try {
            Map<String,Object> resultMap = new HashMap<String,Object>();
            depositService.insertLog(model);
            resultMap.put("result","添加成功");
            result =dealSuccess (resultMap);
        } catch (Exception e) {
            result = dealException(e);
        }
        return ResponseEntity.ok(result);

    }
}
