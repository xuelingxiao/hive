package com.xlx.user.api.config.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.server.ErrorPage;
import org.springframework.boot.web.server.ErrorPageRegistrar;
import org.springframework.boot.web.server.ErrorPageRegistry;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;

/*
* 自定义的错误页配置(Spring Boot方式)
 */
@Configuration
public class ErrorPageConfig implements ErrorPageRegistrar {

    @Value("${hive.web.error_page.path:/error}")
    private String path;

    @Override
    public void registerErrorPages(ErrorPageRegistry registry) {
        registry.addErrorPages(new ErrorPage(HttpStatus.NOT_FOUND,this.path));
    }
}
