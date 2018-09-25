package com.byc.merchants.merchants_cms.controller.upload;

import com.byc.merchants.merchants_cms.constant.Constant;
import com.byc.merchants.merchants_cms.util.OssUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


/**
 * @Auther: 胡丛
 * @Date: 2018/9/5 13:44
 * @Description:
 */
@RestController
@RequestMapping("/test")
@Slf4j
@Api(value = "图片上传", tags = {"图片上传"})
public class UploadController {


    @RequestMapping(value = "/upload", method = RequestMethod.POST, consumes = "multipart/*", headers = "content-type=multipart/form-data")
    @ApiOperation(value = "单张图片上传接口", notes = "图片上传接口")
    public String test(@RequestParam(value = "单张图片上传", required = true) MultipartFile files) {
        System.out.println(Constant.ACCESSID);
        String mer = OssUtil.upload(files, "mer");
        return mer;
    }
}
