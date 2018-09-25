package com.byc.merchants.merchants_cms.controller.user;

import com.byc.merchants.merchants_cms.annoation.CurrentUser;
import com.byc.merchants.merchants_cms.annoation.LoginNotRequired;
import com.byc.merchants.merchants_cms.bean.user.User;
import com.byc.merchants.merchants_cms.controller.BaseController;
import com.byc.merchants.merchants_cms.model.register.MerchantsIn;
import com.byc.merchants.merchants_cms.model.user.UpdateMerModel;
import com.byc.merchants.merchants_cms.model.user.UserModel;
import com.byc.merchants.merchants_cms.model.register.RegisterModel;
import com.byc.merchants.merchants_cms.result.JsonResult;
import com.byc.merchants.merchants_cms.service.user.UserService;
import com.byc.merchants.merchants_cms.util.CommonUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: 胡丛
 * @Date: 2018/9/5 10:48
 * @Description:
 */
@RestController
@RequestMapping("/user")
@Api(value = "商户接口", tags = {"商户接口"})
@Slf4j
@PropertySource({"classpath:config/my.properties", "classpath:config/config.properties"})
public class UserController extends BaseController {

    @Autowired
    private UserService userService;

    @Value("${my.application_name}")
    private String application_name;

    @Value("${config.deskey}")
    private String deskey;

    // 创建线程安全的Map
    static Map<Integer, User> users = Collections.synchronizedMap(new HashMap<Integer, User>());

    /**
     * @描述 获取用户
     * @参数 商户id
     * @返回值 ResponseEntity
     * @创建人 胡丛
     * @创建时间 2018/9/5
     * @修改人和其它信息
     */
    @ApiOperation(value = "获取商户信息", notes = "根据url的merchants_id来获取用户详细信息")
    @ApiImplicitParam(name = "id", value = "商户ID", required = true, dataType = "Integer", paramType = "path")
    @RequestMapping(value = "/getUser/{id}", method = RequestMethod.GET)
    public ResponseEntity<JsonResult> getUser(@PathVariable("id") Integer m_id) {
        log.info("商户id:" + m_id);
        JsonResult r = new JsonResult();
        try {
            UserModel userModel = userService.selectUserById(m_id);
            r.setResult(userModel);
            r.setStatus("ok");
        } catch (Exception e) {
            r.setResult(e.getClass().getName() + ":" + e.getMessage());
            r.setStatus("error");
            e.printStackTrace();
        }
        return ResponseEntity.ok(r);
    }

    /**
     * 登录
     *
     * @param request
     * @param mer_mobile
     * @param password
     * @return
     */
    @ApiOperation(value = "商户登录", notes = "登录操作")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "mer_mobile", value = "商户登录手机号", required = true, dataType = "string"),
            @ApiImplicitParam(name = "password", value = "商户登录密码", required = true, dataType = "string"),
            @ApiImplicitParam(name = "longitude", value = "经度", required = false, dataType = "string"),
            @ApiImplicitParam(name = "latitude", value = "纬度", required = false, dataType = "string"),
    })
    @PostMapping("/login")
    @LoginNotRequired
    public ResponseEntity<JsonResult> login(HttpServletRequest request, String mer_mobile, String password, String longitude, String latitude) {
        log.info("登录请求参数:mer_mobile = " + mer_mobile);
        JsonResult result = new JsonResult();
        try {
            //获取ip
            String ip = CommonUtils.getIP(request);
            Map<String, Object> resultMap = userService.login(request, mer_mobile, password, ip, longitude, latitude);
            log.info("登录响应参数:" + resultMap);
            result = dealSuccess(resultMap);
        } catch (Exception e) {
            result = dealException(e);
        }
        return ResponseEntity.ok(result);
    }


    /**
     * @描述 商户注册
     * @参数
     * @返回值
     * @创建人 胡丛
     * @创建时间 2018/9/7
     * @修改人和其它信息
     */
    @ApiOperation(value = "商户注册", notes = "商户注册")
    @RequestMapping(value = "register", method = RequestMethod.POST)
    @LoginNotRequired
    public ResponseEntity<JsonResult> register(RegisterModel model) {
        log.info("商户注册所传参数:" + model);
        JsonResult result = new JsonResult();
        try {
            userService.register(model);
            Map<String, Object> resultMap = new HashMap<String, Object>();
            resultMap.put("result", "注册成功");
            result = dealSuccess(resultMap);
        } catch (Exception e) {
            result = dealException(e);
        }
        return ResponseEntity.ok(result);

    }

    /**
     * @描述 商户注入
     * @参数
     * @返回值
     * @创建人 胡丛
     * @创建时间 2018/9/10
     * @修改人和其它信息
     */
    @ApiOperation(value = "我要开店", notes = "我要开店")
    @RequestMapping(value = "merchantsIn", method = RequestMethod.POST)
    @LoginNotRequired
    public ResponseEntity<JsonResult> merchantsIn(MerchantsIn model, @CurrentUser Integer merId) {
        log.info("商户驻入开店参数:" + model);
        model.setMer_id(merId);
        JsonResult result = new JsonResult();
        try {
            Map<String, Object> resultMap = new HashMap<String, Object>();
            MerchantsIn merchantsIn = userService.merchantsIn(model);
            resultMap.put("result", merchantsIn);
            result = dealSuccess(resultMap);
        } catch (Exception e) {
            result = dealException(e);
        }
        return ResponseEntity.ok(result);
    }

    /**
     * @描述 商户完善信息
     * @参数
     * @返回值
     * @创建人 胡丛
     * @创建时间 2018/9/10
     * @修改人和其它信息
     */
    @ApiOperation(value = "商户信息完善", notes = "商户信息完善数据")
    @ApiImplicitParam(name = "mer_id", value = "商户ID", required = true, dataType = "String")
    @RequestMapping(value = "completeInfo", method = RequestMethod.POST)
    public ResponseEntity<JsonResult> completeInfo(@CurrentUser Integer merId) {
        JsonResult result = new JsonResult();
        try {
            Map<String, Object> resultMap = new HashMap<String, Object>();
            UserModel userModel = userService.selectStoreById(merId);
            resultMap.put("result", userModel);
            result = dealSuccess(resultMap);
        } catch (Exception e) {
            result = dealException(e);
        }
        return ResponseEntity.ok(result);
    }

    /**
     * 重置密码
     *
     * @param mer_mobile
     * @param password
     * @param validCode
     * @return
     */
    @ApiOperation(value = "忘记密码", notes = "重置密码")
    @PostMapping("/forgetPassword")
    @LoginNotRequired
    public ResponseEntity<JsonResult> forgetPassword(String mer_mobile, String password, String validCode) {
        log.info("忘记密码请求:手机号 = " + mer_mobile + ",密码 = " + password + ",验证码 = " + validCode);
        JsonResult result = new JsonResult();
        try {
            userService.forgetPassword(mer_mobile, password, validCode);
            result = dealSuccess();
        } catch (Exception e) {
            result = dealException(e);
        }
        return ResponseEntity.ok(result);
    }


}
