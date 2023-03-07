package com.example.web_admin.config;


import com.example.web_admin.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 1. 编写拦截器，实现HandlerInterceptor接口
 * 2. 拦截器注册到容器中（实现WebMvcConfigurer的addInterceptors）
 * 3. 制定拦截规则（如果拦截所有，静态所有都会被拦截）
 */
@Configuration
public class AdminWebConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor())
                .addPathPatterns("/**")  //**相当于拦截所有请求，包括静态资源
                .excludePathPatterns("/","/login","/css/**","/fonts/**","/images/**","/js/**"); //放行请求


    }
}
