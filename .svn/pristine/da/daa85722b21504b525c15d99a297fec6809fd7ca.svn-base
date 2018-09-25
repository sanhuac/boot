package com.byc.merchants.merchants_cms.interceptor;/**
 * created by pht on 2018/9/19 0019
 */

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Enumeration;

/**
 * 写个防sql注入的拦截器,不知道有用不
 *
 * @author pht
 * @program merchants_cms
 * @date 2018/9/19 0019
 */
@Slf4j
public class SqlInjectInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        log.info("防sql注入拦截器开始执行....");
        //获取请求中的所有参数
        Enumeration<String> parameterNames = request.getParameterNames();
        while (parameterNames.hasMoreElements()) {
            //获取当前参数的名字
            String element = parameterNames.nextElement();
            //获取参数值
            String[] parameterValues = request.getParameterValues(element);
            //遍历参数值
            for (String value : parameterValues) {
                //做校验
                if (checkSqlInject(value)) {
                    response.setContentType("text/html;charset=UTF-8");
                    response.getWriter().print("参数含有非法字符,请检查后再提交");
                    return false;
                }
                //跨站xss清理
                value = clearXss(value);
            }
        }
        return true;
    }

    /**
     * 处理跨站
     *
     * @param value
     */
    private String clearXss(String value) {
        if (value == null || "".equals(value)) {
            return value;
        }
        value = value.replaceAll("<", "<").replaceAll(">", ">");
        value = value.replaceAll("\\(", "(").replace("\\)", ")");
        value = value.replaceAll("'", "'");
        value = value.replaceAll("eval\\((.*)\\)", "");
        value = value.replaceAll("[\\\"\\\'][\\s]*javascript:(.*)[\\\"\\\']",
                "\"\"");
        value = value.replace("script", "");
        return value;
    }

    /**
     * 检验是否有非法字符
     *
     * @param value
     * @return
     */
    private boolean checkSqlInject(String value) {
//        if (value == null || "".equals(value)) {
//            return true;
//        }
        String xssStr = "and|or|select|update|delete|drop|truncate|%20|=|--|;|'|%|#|+|,|//|\\|!=|(|)";
        String[] xssArr = xssStr.split("\\|");

        //判断是否包含
        for (String s : xssArr) {
            if (value.contains(s)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
