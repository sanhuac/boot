package com.byc.merchants.merchants_cms.interceptor;

/**
 * created by pht on 2018/9/7 0007
 */

import com.alibaba.fastjson.JSON;
import com.byc.merchants.merchants_cms.annoation.LoginNotRequired;
import com.byc.merchants.merchants_cms.controller.BaseController;
import com.byc.merchants.merchants_cms.exception.UnifiedException;
import com.byc.merchants.merchants_cms.model.login.LoginToken;
import com.byc.merchants.merchants_cms.result.JsonResult;
import com.byc.merchants.merchants_cms.service.redis.RedisService;
import com.byc.merchants.merchants_cms.service.user.UserService;
import com.byc.merchants.merchants_cms.util.ValidatorUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.invoke.MethodHandle;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * 登录拦截器
 *
 * @author pht
 * @program merchants_cms
 * @date 2018/9/7 0007
 */
@Slf4j
public class LoginIntercetor extends BaseController implements HandlerInterceptor {

    @Autowired
    private UserService userService;
    public final static String ACCESS_TOKEN = "accessId";


    /**
     * 拦截之前
     *
     * @param request  请求
     * @param response 响应
     * @param handler  被映射的对象
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (!(handler instanceof HandlerMethod)){
            return true;
        }
        HandlerMethod handle = (HandlerMethod) handler;
        Method method = handle.getMethod();
        LoginNotRequired annotation = method.getAnnotation(LoginNotRequired.class);
        if (annotation != null) {
            return true;
        }
        String accessToken = request.getParameter(ACCESS_TOKEN);
        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("method", method.getName());
        resultMap.put("accessId", accessToken);
        log.info("登录拦截信息:" + resultMap);
        //accessId为空
        if (ValidatorUtils.isNull(accessToken)) {
            JsonResult result = dealException(new UnifiedException(200014));
            result.setResult(resultMap);
            this.returnJson(response, JSON.toJSONString(result));
            return false;
        }

        //从redis中取值token
        LoginToken token = userService.selectToken(accessToken);
        if (ValidatorUtils.isNull(token)) {
            JsonResult result = dealException(new UnifiedException(200014));
            result.setResult(resultMap);
            this.returnJson(response, JSON.toJSONString(result));
            return false;
        }

        // 当前登录用户@CurrentUser
        if (!ValidatorUtils.isEmpty(accessToken)) {
            token = userService.selectToken(accessToken);
            Integer merId = null;
            if (!ValidatorUtils.isNull(token)) {
                merId = token.getMer_id();
            }
            request.setAttribute("mer_id", merId);
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }

    private void returnJson(HttpServletResponse response, String json) throws Exception {
        PrintWriter writer = null;
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=utf-8");
        try {
            writer = response.getWriter();
            writer.print(json);

        } catch (IOException e) {
            log.error("response error", e);
        } finally {
            if (writer != null) {
                writer.close();
            }
        }
    }
}
