package com.byc.merchants.merchants_cms.constant;

import com.byc.merchants.merchants_cms.config.PropertiesConfig;

/**
 * @Auther: 胡丛
 * @Date: 2018/9/5 18:00
 * @Description:
 */
public class Constant {

    public static Constant getInstance() {
        return new Constant();
    }

    public static final String ACCESSID = PropertiesConfig.getProperties("oss.properties", "accessid");

    public static final String ACCESSKEY = PropertiesConfig.getProperties("oss.properties", "accesskey");

    public static final String BUCKET = PropertiesConfig.getProperties("oss.properties", "bucket");

    public static final String ENDPOINT = PropertiesConfig.getProperties("oss.properties", "endpoint");

    public static final String OSS_PREFIX = PropertiesConfig.getProperties("oss.properties", "oss_prefix");

    //未知错误
    public static final String UNKNOWN = "unknown";

    //客户端des加密秘钥
    public static final String DESKEY = PropertiesConfig.getProperties("config/config.properties", "encryption_key");
    //提现最低限额
    public static final String MIN_WITHDRAW_AMOUNT = PropertiesConfig.getProperties("config", "MIN_WITHDRAW_AMOUNT");
    //图片前缀
    public String PIC_URL_PREFIX = PropertiesConfig.getProperties("aliyunoss", "oss_prefix");//链接前缀

}
