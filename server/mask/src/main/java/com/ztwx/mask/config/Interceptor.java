package com.ztwx.mask.config;

import com.ztwx.mask.config.interceptors.SessionInterceptor;
import com.ztwx.mask.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Arrays;

@Configuration
public class Interceptor implements WebMvcConfigurer {

    @Autowired
    private Setting setting;

    @Autowired
    private UserService userService;

    @Override
    public void addInterceptors(InterceptorRegistry interceptorRegistry){
        interceptorRegistry.addInterceptor(
                new SessionInterceptor(this.userService,this.setting)
        ).addPathPatterns(
                Arrays.asList("/**/m/**")
        );

    }

}
