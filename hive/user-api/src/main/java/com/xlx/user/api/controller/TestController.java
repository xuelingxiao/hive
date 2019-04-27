package com.xlx.user.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@RestController
public class TestController {

    @GetMapping("/page_error.html")
    public Object errorPage(HttpServletRequest request) throws Exception {
        Map<String, String> map = new HashMap<>();
        map.put("message", request.getAttribute("javax.servlet.error.message").toString());
        map.put("code", request.getAttribute("javax.servlet.error.status_code").toString());
        throw new Exception("this is a exception");
        //return map;
    }
}
