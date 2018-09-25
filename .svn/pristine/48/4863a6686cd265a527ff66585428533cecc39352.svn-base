package com.byc.merchants.merchants_cms.controller.user;

import com.byc.merchants.merchants_cms.annoation.LoginNotRequired;
import com.byc.merchants.merchants_cms.controller.BaseController;
import com.byc.merchants.merchants_cms.model.sms.SmsCode;
import com.byc.merchants.merchants_cms.result.JsonResult;
import com.byc.merchants.merchants_cms.service.sms.SmsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: 胡丛
 * @Date: 2018/9/6 17:12
 * @Description:
 */
@RestController
@RequestMapping("/sms")
@Api(value = "短信接口",tags = {"短信接口"})
@Slf4j
public class SmsController extends BaseController{

    @Autowired
    private SmsService smsService;

    /**
     *@描述 获取验证码
     *@参数  mer_mobile   type
     *@返回值  ResponseEntity
     *@创建人  胡丛
     *@创建时间  2018/9/6
     *@修改人和其它信息
     */
    @ApiOperation(value="获取商户注册短信验证码", notes="商户注册的时候获取验证码")
    @RequestMapping(value = "getCode", method = RequestMethod.POST)
    @LoginNotRequired
    public ResponseEntity<JsonResult> getCode(SmsCode smsCode){
        log.info("短信验证码参数:"+smsCode);
        JsonResult result = new JsonResult();
        try {
            smsService.send(smsCode.getMer_mobile(),smsCode.getCode_type());
            Map<String,Object> resultMap = new HashMap<String,Object>();
            resultMap.put("result","短信验证码发送成功");
            result =dealSuccess (resultMap);
        } catch (Exception e) {
            result = dealException(e);
        }
        return ResponseEntity.ok(result);

    }
}
