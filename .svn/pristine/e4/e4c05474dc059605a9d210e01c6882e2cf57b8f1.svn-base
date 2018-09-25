package com.byc.merchants.merchants_cms.util;

import com.aliyun.oss.OSSClient;
import com.byc.merchants.merchants_cms.constant.Constant;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.multipart.MultipartFile;

import java.util.Calendar;

/**
 * @Auther: 胡丛
 * @Date: 2018/9/5 17:07
 * @Description: 阿里云Oss工具类
 */
@Slf4j
public class OssUtil {


    private static String accessid = Constant.ACCESSID;


    private static String accesskey = Constant.ACCESSKEY;


    private static String bucket = Constant.BUCKET;


    private static String endpoint = Constant.ENDPOINT;


    private static String oss_prefix = Constant.OSS_PREFIX;

    /**
     *@描述 图片上传
     *@参数 MultipartFile  type
     *@返回值
     *@创建人  胡丛
     *@创建时间  2018/9/5
     *@修改人和其它信息
     */
    public static String upload(MultipartFile files,String type){
        String key = "";
        OSSClient ossClient = new OSSClient(endpoint, accessid,accesskey);
        try {
            key = getKey(type);
            ossClient.putObject(bucket, key,files.getInputStream());
            //上传成功后，将地址封装到sysImages，进行添加数据库
            log.info("阿里图片地址:"+getKey(type));
        } catch (Exception e1) {
            System.out.println("上传失败");
            e1.printStackTrace();
        }

        return oss_prefix+key;
    }

    /**
     *@描述 获取短连接
     *@参数 type
     *@返回值 key
     *@创建人  胡丛
     *@创建时间  2018/9/5
     *@修改人和其它信息
     */
    private static String getKey(String type){
        Calendar now = Calendar.getInstance();
        String key=type+"/"+now.get(Calendar.YEAR)+"/"+(now.get(Calendar.MONTH) + 1)+"/"+now.get(Calendar.DAY_OF_MONTH)+"/"+now.getTimeInMillis()+".data";
        return key;
    }

}
