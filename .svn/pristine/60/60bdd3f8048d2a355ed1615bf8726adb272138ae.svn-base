package com.byc.merchants.merchants_cms.controller.store;

import com.byc.merchants.merchants_cms.annoation.CurrentUser;
import com.byc.merchants.merchants_cms.controller.BaseController;
import com.byc.merchants.merchants_cms.model.image.StoreImageModel;
import com.byc.merchants.merchants_cms.model.user.UpdateMerModel;
import com.byc.merchants.merchants_cms.result.JsonResult;
import com.byc.merchants.merchants_cms.service.store.StoreService;
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
 * @Date: 2018/9/11 09:11
 * @Description: 商铺接口
 */
@RestController
@RequestMapping("/store")
@Api(value = "商铺接口", tags = {"商铺接口"})
@Slf4j
public class StoreController extends BaseController{

    @Autowired
    private StoreService storeService;

    /**
     *@描述 编辑商户门店logo
     *@参数
     *@返回值
     *@创建人  胡丛
     *@创建时间  2018/9/10
     *@修改人和其它信息
     */
    @ApiOperation(value="编辑商户门店logo", notes="编辑商户门店logo")
    @RequestMapping(value = "updateStoreLogo",method = RequestMethod.POST)
    public ResponseEntity<JsonResult> updateStoreLogo(UpdateMerModel model, @CurrentUser Integer merId){
        log.info("编辑商户门店logo:"+model);
        model.setMer_id(merId);
        JsonResult result = new JsonResult();
        try {
            Map<String,Object> resultMap = new HashMap<String,Object>();
            storeService.updateStoreLogo(model);
            resultMap.put("result","logo修改成功");
            result =dealSuccess (resultMap);
        } catch (Exception e) {
            result = dealException(e);
        }
        return ResponseEntity.ok(result);
    }

    /**
     *@描述 编辑商户门店名字
     *@参数
     *@返回值
     *@创建人  胡丛
     *@创建时间  2018/9/10
     *@修改人和其它信息
     */
    @ApiOperation(value="编辑商户门店名字", notes="编辑商户门店名字")
    @RequestMapping(value = "updateStoreName",method = RequestMethod.POST)
    public ResponseEntity<JsonResult> updateStoreName(UpdateMerModel model,@CurrentUser Integer merId){
        log.info("编辑商户门店名字:"+model);
        model.setMer_id(merId);
        JsonResult result = new JsonResult();
        try {
            Map<String,Object> resultMap = new HashMap<String,Object>();
            storeService.updateStoreName(model);
            resultMap.put("result","名字修改成功");
            result =dealSuccess (resultMap);
        } catch (Exception e) {
            result = dealException(e);
        }
        return ResponseEntity.ok(result);
    }

    /**
     *@描述 编辑商户门店简介
     *@参数
     *@返回值
     *@创建人  胡丛
     *@创建时间  2018/9/10
     *@修改人和其它信息
     */
    @ApiOperation(value="编辑商户门店简介", notes="编辑商户门店简介")
    @RequestMapping(value = "updateStoreIntroduce",method = RequestMethod.POST)
    public ResponseEntity<JsonResult> updateStoreIntroduce(UpdateMerModel model,@CurrentUser Integer merId){
        log.info("编辑商户门店简介:"+model);
        model.setMer_id(merId);
        JsonResult result = new JsonResult();
        try {
            Map<String,Object> resultMap = new HashMap<String,Object>();
            storeService.updateStoreIntroduce(model);
            resultMap.put("result","简介修改成功");
            result =dealSuccess (resultMap);
        } catch (Exception e) {
            result = dealException(e);
        }
        return ResponseEntity.ok(result);
    }

    /**
     *@描述 编辑商户门店客服电话
     *@参数
     *@返回值
     *@创建人  胡丛
     *@创建时间  2018/9/10
     *@修改人和其它信息
     */
    @ApiOperation(value="编辑商户门店客服电话", notes="编辑商户门店客服电话")
    @RequestMapping(value = "updateStorePhone",method = RequestMethod.POST)
    public ResponseEntity<JsonResult> updateStorePhone(UpdateMerModel model,@CurrentUser Integer merId){
        log.info("编辑商户门店客服电话:"+model);
        model.setMer_id(merId);
        JsonResult result = new JsonResult();
        try {
            Map<String,Object> resultMap = new HashMap<String,Object>();
            storeService.updateStorePhone(model);
            resultMap.put("result","客服电话修改成功");
            result =dealSuccess (resultMap);
        } catch (Exception e) {
            result = dealException(e);
        }
        return ResponseEntity.ok(result);
    }

    /**
     *@描述 编辑商户门店地址
     *@参数
     *@返回值
     *@创建人  胡丛
     *@创建时间  2018/9/10
     *@修改人和其它信息
     */
    @ApiOperation(value="编辑商户门店地址", notes="编辑商户门店地址")
    @RequestMapping(value = "updateStoreAddress",method = RequestMethod.POST)
    public ResponseEntity<JsonResult> updateStoreAddress(UpdateMerModel model,@CurrentUser Integer merId){
        log.info("编辑商户门店地址:"+model);
        model.setMer_id(merId);
        JsonResult result = new JsonResult();
        try {
            Map<String,Object> resultMap = new HashMap<String,Object>();
            storeService.updateStoreAddress(model);
            resultMap.put("result","地址修改成功");
            result =dealSuccess (resultMap);
        } catch (Exception e) {
            result = dealException(e);
        }
        return ResponseEntity.ok(result);
    }

    /**
     *@描述 编辑商户门店销售品牌
     *@参数
     *@返回值
     *@创建人  胡丛
     *@创建时间  2018/9/10
     *@修改人和其它信息
     */
    @ApiOperation(value="编辑商户门店销售品牌", notes="编辑商户门店销售品牌")
    @RequestMapping(value = "updateStoreBrand",method = RequestMethod.POST)
    public ResponseEntity<JsonResult> updateStoreBrand(UpdateMerModel model,@CurrentUser Integer merId){
        log.info("编辑商户门店销售品牌:"+model);
        model.setMer_id(merId);
        JsonResult result = new JsonResult();
        try {
            Map<String,Object> resultMap = new HashMap<String,Object>();
            storeService.updateStoreBrand(model);
            resultMap.put("result","销售品牌修改成功");
            result =dealSuccess (resultMap);
        } catch (Exception e) {
            result = dealException(e);
        }
        return ResponseEntity.ok(result);
    }


    /**
     *@描述 编辑商户门店活动
     *@参数
     *@返回值
     *@创建人  胡丛
     *@创建时间  2018/9/10
     *@修改人和其它信息
     */
    @ApiOperation(value="编辑商户门店活动", notes="编辑商户门店活动")
    @RequestMapping(value = "updateStoreActive",method = RequestMethod.POST)
    public ResponseEntity<JsonResult> updateStoreActive(UpdateMerModel model,@CurrentUser Integer merId){
        log.info("编辑商户门店活动:"+model);
        model.setMer_id(merId);
        JsonResult result = new JsonResult();
        try {
            Map<String,Object> resultMap = new HashMap<String,Object>();
            storeService.updateStoreBrand(model);
            resultMap.put("result","门店活动修改成功");
            result =dealSuccess (resultMap);
        } catch (Exception e) {
            result = dealException(e);
        }
        return ResponseEntity.ok(result);
    }

    /**
     *@描述 编辑商户门店二维码
     *@参数
     *@返回值
     *@创建人  胡丛
     *@创建时间  2018/9/10
     *@修改人和其它信息
     */
    @ApiOperation(value="编辑商户门店二维码", notes="编辑商户门店二维码")
    @RequestMapping(value = "updateStoreErcode",method = RequestMethod.POST)
    public ResponseEntity<JsonResult> updateStoreErcode(UpdateMerModel model,@CurrentUser Integer merId){
        log.info("编辑商户门店二维码:"+model);
        model.setMer_id(merId);
        JsonResult result = new JsonResult();
        try {
            Map<String,Object> resultMap = new HashMap<String,Object>();
            storeService.updateStoreErcode(model);
            resultMap.put("result","二维码修改成功");
            result =dealSuccess (resultMap);
        } catch (Exception e) {
            result = dealException(e);
        }
        return ResponseEntity.ok(result);
    }

    /**
     *@描述 编辑商户门店首页图
     *@参数
     *@返回值
     *@创建人  胡丛
     *@创建时间  2018/9/10
     *@修改人和其它信息
     */
    @ApiOperation(value="编辑商户门店首页图", notes="编辑商户门店首页图")
    @RequestMapping(value = "updateStoreIndex",method = RequestMethod.POST)
    public ResponseEntity<JsonResult> updateStoreIndex(StoreImageModel model,@CurrentUser Integer merId){
        log.info("编辑商户门店首页图:"+model);
        model.setMer_id(merId);
        JsonResult result = new JsonResult();
        try {
            Map<String,Object> resultMap = new HashMap<String,Object>();
            storeService.updateStoreIndex(model);
            resultMap.put("result","首页图修改成功");
            result =dealSuccess (resultMap);
        } catch (Exception e) {
            result = dealException(e);
        }
        return ResponseEntity.ok(result);
    }
}
