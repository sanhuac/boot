package com.byc.merchants.merchants_cms.controller.store;

import com.byc.merchants.merchants_cms.annoation.CurrentUser;
import com.byc.merchants.merchants_cms.annoation.LoginNotRequired;
import com.byc.merchants.merchants_cms.controller.BaseController;
import com.byc.merchants.merchants_cms.model.user.InsuranceModel;
import com.byc.merchants.merchants_cms.model.user.UpdateMerModel;
import com.byc.merchants.merchants_cms.result.JsonResult;
import com.byc.merchants.merchants_cms.service.store.InsuranceUService;
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
 * @Date: 2018/9/21 14:29i
 * @Description:
 */
@RestController
@RequestMapping("/insuranceMo")
@Api(value = "保险门店完善接口", tags = {"保险门店完善接口"})
@Slf4j
public class InsuranceUController extends BaseController {

    @Autowired
    private InsuranceUService insuranceUService;


    /**
     *@描述 获取保险门店完善信息
     *@参数
     *@返回值
     *@创建人  胡丛
     *@创建时间  2018/9/10
     *@修改人和其它信息
     */
    @ApiOperation(value="获取保险门店完善信息", notes="获取保险门店完善信息")
    @RequestMapping(value = "insuranceU",method = RequestMethod.POST)
    public ResponseEntity<JsonResult> insuranceU(@CurrentUser Integer merId){
        log.info("获取保险门店完善信息参数:"+merId);
        JsonResult result = new JsonResult();
        try {
            Map<String,Object> resultMap = new HashMap<String,Object>();
            InsuranceModel insuranceModel =insuranceUService.selectStoreById(merId);
            resultMap.put("result",insuranceModel);
            result =dealSuccess (resultMap);
        } catch (Exception e) {
            result = dealException(e);
        }
        return ResponseEntity.ok(result);
    }

    /**
     *@描述 修改保险门店Logo
     *@参数
     *@返回值
     *@创建人  胡丛
     *@创建时间  2018/9/10
     *@修改人和其它信息
     */
    @ApiOperation(value="修改保险门店Logo", notes="修改保险门店Logo")
    @RequestMapping(value = "updateinsuranceLogo",method = RequestMethod.POST)
    public ResponseEntity<JsonResult> updateinsuranceLogo(InsuranceModel model,@CurrentUser Integer merId){
        log.info("修改保险门店Logo参数:"+model);
        log.info("商户编号:"+merId);
        model.setMer_id(merId);
        JsonResult result = new JsonResult();
        try {
            Map<String,Object> resultMap = new HashMap<String,Object>();
            insuranceUService.updateInsuranceLogo(model);
            resultMap.put("result","编辑成功");
            result =dealSuccess (resultMap);
        } catch (Exception e) {
            result = dealException(e);
        }
        return ResponseEntity.ok(result);
    }

    /**
     *@描述 修改保险门店Nmae
     *@参数
     *@返回值
     *@创建人  胡丛
     *@创建时间  2018/9/10
     *@修改人和其它信息
     */
    @ApiOperation(value="修改保险门店Nmae", notes="修改保险门店Nmae")
    @RequestMapping(value = "updateinsuranceNmae",method = RequestMethod.POST)
    public ResponseEntity<JsonResult> updateinsuranceNmae(InsuranceModel model,@CurrentUser Integer merId){
        log.info("修改保险门店Nmae参数:"+model);
        log.info("商户编号:"+merId);
        model.setMer_id(merId);
        JsonResult result = new JsonResult();
        try {
            Map<String,Object> resultMap = new HashMap<String,Object>();
            insuranceUService.updateInsuranceName(model);
            resultMap.put("result","编辑成功");
            result =dealSuccess (resultMap);
        } catch (Exception e) {
            result = dealException(e);
        }
        return ResponseEntity.ok(result);
    }

    /**
     *@描述 修改保险门店介绍
     *@参数
     *@返回值
     *@创建人  胡丛
     *@创建时间  2018/9/10
     *@修改人和其它信息
     */
    @ApiOperation(value="修改保险门店介绍", notes="修改保险门店介绍")
    @RequestMapping(value = "updateinsuranceintrduce",method = RequestMethod.POST)
    public ResponseEntity<JsonResult> updateinsuranceintrduce(InsuranceModel model,@CurrentUser Integer merId){
        log.info("修改保险门店介绍参数:"+model);
        log.info("商户编号:"+merId);
        model.setMer_id(merId);
        JsonResult result = new JsonResult();
        try {
            Map<String,Object> resultMap = new HashMap<String,Object>();
            insuranceUService.updateInsuranceIntroduce(model);
            resultMap.put("result","编辑成功");
            result =dealSuccess (resultMap);
        } catch (Exception e) {
            result = dealException(e);
        }
        return ResponseEntity.ok(result);
    }

    /**
     *@描述 修改保险门店客服电话
     *@参数
     *@返回值
     *@创建人  胡丛
     *@创建时间  2018/9/10
     *@修改人和其它信息
     */
    @ApiOperation(value="修改保险门店客服电话", notes="修改保险门店客服电话")
    @RequestMapping(value = "updateinsurancePhone",method = RequestMethod.POST)
    public ResponseEntity<JsonResult> updateinsurancePhone(InsuranceModel model,@CurrentUser Integer merId){
        log.info("修改保险门店客服电话参数:"+model);
        log.info("商户编号:"+merId);
        model.setMer_id(merId);
        JsonResult result = new JsonResult();
        try {
            Map<String,Object> resultMap = new HashMap<String,Object>();
            insuranceUService.updateInsurancePhone(model);
            resultMap.put("result","编辑成功");
            result =dealSuccess (resultMap);
        } catch (Exception e) {
            result = dealException(e);
        }
        return ResponseEntity.ok(result);
    }

    /**
     *@描述 修改保险门店地址
     *@参数
     *@返回值
     *@创建人  胡丛
     *@创建时间  2018/9/10
     *@修改人和其它信息
     */
    @ApiOperation(value="修改保险门店地址", notes="修改保险门店地址")
    @RequestMapping(value = "updateinsuranceAddress",method = RequestMethod.POST)
    public ResponseEntity<JsonResult> updateinsuranceAddress(InsuranceModel model,@CurrentUser Integer merId){
        log.info("修改保险门店地址参数:"+model);
        log.info("商户编号:"+merId);
        model.setMer_id(merId);
        JsonResult result = new JsonResult();
        try {
            Map<String,Object> resultMap = new HashMap<String,Object>();
            insuranceUService.updateInsuranceAddress(model);
            resultMap.put("result","编辑成功");
            result =dealSuccess (resultMap);
        } catch (Exception e) {
            result = dealException(e);
        }
        return ResponseEntity.ok(result);
    }

    /**
     *@描述 修改保险门店首页banner
     *@参数
     *@返回值
     *@创建人  胡丛
     *@创建时间  2018/9/10
     *@修改人和其它信息
     */
    @ApiOperation(value="修改保险门店首页banner", notes="修改保险门店首页banner")
    @RequestMapping(value = "updateinsuranceBnaner",method = RequestMethod.POST)
    public ResponseEntity<JsonResult> updateinsuranceBnaner(InsuranceModel model,@CurrentUser Integer merId){
        log.info("修改保险门店首页banner参数:"+model);
        log.info("商户编号:"+merId);
        model.setMer_id(merId);
        JsonResult result = new JsonResult();
        try {
            Map<String,Object> resultMap = new HashMap<String,Object>();
            insuranceUService.updateInsuranceBanner(model);
            resultMap.put("result","编辑成功");
            result =dealSuccess (resultMap);
        } catch (Exception e) {
            result = dealException(e);
        }
        return ResponseEntity.ok(result);
    }

}
