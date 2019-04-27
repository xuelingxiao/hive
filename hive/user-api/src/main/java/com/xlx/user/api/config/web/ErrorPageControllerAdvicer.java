package com.xlx.user.api.config.web;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.HandlerMethod;

@RestControllerAdvice(basePackages = {"com.xlx.common.test"})
public class ErrorPageControllerAdvicer  {

    @ExceptionHandler(Exception.class)
    public String errorPage(Exception ex, HandlerMethod method){
        return "异常了..."+ex.getMessage()+method.getShortLogMessage();
    }


}
