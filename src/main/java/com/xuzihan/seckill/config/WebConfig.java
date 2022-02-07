package com.xuzihan.seckill.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.List;

/**
 * @author ZihanXu
 * @version 1.0
 */

@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {

    @Autowired
    WebConfigHandler webConfigHandler;

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
        argumentResolvers.add(webConfigHandler);
    }
}
