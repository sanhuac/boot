package com.byc.merchants.merchants_cms.config;

import com.byc.merchants.merchants_cms.constant.Constant;
import com.byc.merchants.merchants_cms.dao.extra.CfgParamsMapper;
import com.byc.merchants.merchants_cms.redis.enums.RedisKeyEnum;
import com.byc.merchants.merchants_cms.service.redis.RedisService;
import com.byc.merchants.merchants_cms.springboot.SpringContext;
import com.byc.merchants.merchants_cms.util.ValidatorUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

/**
 * 资源读取工具类
 *
 * @author lgh
 */
@Slf4j
public class PropertiesConfig {

    private final static Map<String, ResourceBundle> PROPERTY_POOL = new HashMap<String, ResourceBundle>();

    private static RedisService redisService = SpringContext.getBean(RedisService.class);

    private static CfgParamsMapper paramsMapper = null;


    public static final String getProperties(String fileName, String key) {

        //try catch一下 防止未知异常
        try {
            int index = fileName.indexOf(".");
            if (index > 0) {
                //说明有后缀,是本地文件,就在文件中找
                fileName = fileName.substring(0, index > 0 ? index : fileName.length());
                if (!PROPERTY_POOL.containsKey(fileName)) {
                    PROPERTY_POOL.put(fileName, ResourceBundle.getBundle(fileName));
                }
                return PROPERTY_POOL.get(fileName).getString(key);
            } else {
                //说明没有后缀 那就是redis中的,或数据库中的
                //从redis中取值
                String value = redisService.getMapField(RedisKeyEnum.CONFIG.KEY, fileName + "_" + key, String.class);
                if (ValidatorUtils.isNotNull(value)) {
                    return value;
                }

                //为空就在数据库找
                if (paramsMapper == null) {
                    paramsMapper = SpringContext.getBean(CfgParamsMapper.class);
                }
                //查询参数
                value = paramsMapper.getValue(fileName, key);
                //存到redis中
                redisService.addMap(RedisKeyEnum.CONFIG.KEY, fileName + "_" + key, value);
                return value;
            }
        } catch (Exception e) {
            log.info("redis获取内容异常:" + e.getMessage());
            return Constant.UNKNOWN;
        }

    }

    public static final ResourceBundle getProperties(String fileName) {
        try {
            int index = fileName.indexOf(".");
            fileName = fileName.substring(0, index > 0 ? index : fileName.length());
            if (!PROPERTY_POOL.containsKey(fileName)) {
                PROPERTY_POOL.put(fileName, ResourceBundle.getBundle(fileName));
            }
            return PROPERTY_POOL.get(fileName);
        } catch (Exception e) {
            return null;
        }
    }

    public final static void reload() {
        clear();
    }

    public final static void clear() {
        PROPERTY_POOL.clear();
    }
}
