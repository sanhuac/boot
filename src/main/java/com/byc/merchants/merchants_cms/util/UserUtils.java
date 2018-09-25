package com.byc.merchants.merchants_cms.util;

/**
 * created by pht on 2018/9/7 0007
 */

import com.byc.merchants.merchants_cms.config.PropertiesConfig;
import com.byc.merchants.merchants_cms.exception.UnifiedException;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * 关于用户的工具类
 *
 * @author pht
 * @program merchants_cms
 * @date 2018/9/7 0007
 */
public class UserUtils {

    private static final String DESKEY = PropertiesConfig.getProperties("config/config.properties", "encryption_key");


    /**
     * 登录密码校验
     *
     * @param password
     * @return
     */
    public static String checkPassword(String password) throws UnifiedException {
        if (ValidatorUtils.isNull(password)) {
            throw new UnifiedException(200002);
        }
        //密码解密
        try {
            password = DesUtils.decrypt(password, DESKEY);
        } catch (Exception e) {
            e.printStackTrace();
            throw new UnifiedException(200003);
        }
        //校验长度
        if (password.length() > 20 || password.length() < 6) {
            throw new UnifiedException(200007);
        }
        return password;
    }

    /**
     * 获取session
     *
     * @return
     */
    public static HttpSession getSession() {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        HttpSession session = request.getSession();
        return session;
    }
}
