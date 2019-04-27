package com.xlx.user.api.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

/**
 * mvc的配置
 */
@Configuration
public class MyConfig implements WebMvcConfigurer {

    /**
     * 消息转化器, 设置json为优先级(默认就是json, 这里仅演示), 添加一个新的消息转化器
     * @param converters
     */
    @Override
    public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.set(0,new MappingJackson2HttpMessageConverter());
        converters.add(new Properties2HttpMessageConverter());
    }

}
