package com.byc.merchants.merchants_cms.interceptor;

/**
 * created by pht on 2018/9/7 0007
 */

import com.byc.merchants.merchants_cms.handler.CurrentUserMethodArgumentResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import java.util.List;

/**
 * 拦截器管理
 *
 * @author pht
 * @program merchants_cms
 * @date 2018/9/7 0007
 */
@Configuration
public class WebMvcConfigurer extends WebMvcConfigurationSupport {

    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        //添加跨域拦截器
        registry.addInterceptor(corsInterceptor()).addPathPatterns("/**");
        //添加防sql注入拦截器
        registry.addInterceptor(sqlInjectInterceptor()).addPathPatterns("/**");
        //注册拦截器
        InterceptorRegistration login = registry.addInterceptor(loginIntercetor());
        //添加拦截路径(拦截所有)
        login.addPathPatterns("/**");
        //排除拦截路径
        login.excludePathPatterns("/swagger-resources/**", "/webjars/**", "/v2/**", "/swagger-ui.html/**", "/swagger-ui.html#/**")
                .excludePathPatterns("/csrf", "/");
        super.addInterceptors(registry);
    }

    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**")
                .addResourceLocations("classpath:/META-INF/resources/")
                .addResourceLocations("classpath:/resources/")
                .addResourceLocations("classpath:/static/")
                .addResourceLocations("classpath:/public/");


        registry.addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");

        super.addResourceHandlers(registry);
    }

    @Bean
    public LoginIntercetor loginIntercetor() {

        return new LoginIntercetor();
    }

    @Bean
    public CORSInterceptor corsInterceptor() {
        return new CORSInterceptor();
    }

    @Bean
    public SqlInjectInterceptor sqlInjectInterceptor() {
        return new SqlInjectInterceptor();
    }

    /**
     * 注入bean
     *
     * @return
     */
    @Bean
    public CurrentUserMethodArgumentResolver currentUserMethodArgumentResolver() {
        return new CurrentUserMethodArgumentResolver();
    }

    /**
     * 添加处理器
     *
     * @param argumentResolvers
     */
    @Override
    protected void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
        argumentResolvers.add(new CurrentUserMethodArgumentResolver());
    }


}
