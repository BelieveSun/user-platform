package com.believe.sun.user.config;

import org.apache.commons.httpclient.util.DateParseException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;


/**
 * Created by sungj on 17-6-5.
 */
@SpringBootApplication(scanBasePackages = {"com.believe.sun.user","com.believe.sun.shiro"})
public class ServletInitializer extends SpringBootServletInitializer {

    private static Class<ServletInitializer> applicationClass = ServletInitializer.class;
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {

        return builder.sources(applicationClass);
    }



    public static void main(String [] args) throws DateParseException {
        SpringApplication.run(ServletInitializer.class,args);

    }
}
