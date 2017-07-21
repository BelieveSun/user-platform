package com.believe.sun.user.config;

import com.believe.sun.shiro.annotation.CacheValue;
import com.believe.sun.shiro.annotation.CacheValueMethodArgumenResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import java.util.List;

/**
 * Created by sungj on 17-7-21.
 */
@Configuration
public class WebConfig extends WebMvcConfigurationSupport {
    @Autowired
    private CacheValueMethodArgumenResolver cacheValueMethodArgumenResolver;


    @Override
    protected void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
        argumentResolvers.add(cacheValueMethodArgumenResolver);
    }

}
