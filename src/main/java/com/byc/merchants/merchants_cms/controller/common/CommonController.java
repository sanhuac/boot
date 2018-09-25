package com.byc.merchants.merchants_cms.controller.common;

import com.byc.merchants.merchants_cms.bean.common.Area;
import com.byc.merchants.merchants_cms.controller.BaseController;
import com.byc.merchants.merchants_cms.model.common.AreaModel;
import com.byc.merchants.merchants_cms.model.sms.SmsCode;
import com.byc.merchants.merchants_cms.result.JsonResult;
import com.byc.merchants.merchants_cms.service.common.AreaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Auther: 胡丛
 * @Date: 2018/9/7 16:35
 * @Description:
 */
@RestController
@RequestMapping("/common")
@Api(value = "公共模块接口",tags = {"公共模块接口"})
@Slf4j
public class CommonController extends BaseController{

    @Autowired
    private AreaService areaService;


    @ApiOperation(value="获取省市区编码", notes="获取省市区编码")
    @RequestMapping(value = "areaCodes", method = RequestMethod.POST)
    public ResponseEntity<JsonResult> getCode(AreaModel areaModel){
        log.info("获取地区编码参数:"+areaModel);
        JsonResult result = new JsonResult();
        try {
            List<Area> areas = areaService.subArea(areaModel.getArea_no());
            Map<String,Object> resultMap = new HashMap<String,Object>();
            resultMap.put("area_list",areas);
            result =dealSuccess (resultMap);
        } catch (Exception e) {
            result = dealException(e);
        }
        return ResponseEntity.ok(result);

    }

}
