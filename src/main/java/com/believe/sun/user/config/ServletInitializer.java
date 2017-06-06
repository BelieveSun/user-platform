package com.believe.sun.user.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;


/**
 * Created by sungj on 17-6-5.
 */
@SpringBootApplication(scanBasePackages = {"com.believe.sun"})
@PropertySource("classpath:application.properties")
public class ServletInitializer extends SpringBootServletInitializer {

    private static Class<ServletInitializer> applicationClass = ServletInitializer.class;
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {

        return builder.sources(applicationClass);
    }

    public static void main(String [] args){
        SpringApplication.run(ServletInitializer.class,args);
    }
}
