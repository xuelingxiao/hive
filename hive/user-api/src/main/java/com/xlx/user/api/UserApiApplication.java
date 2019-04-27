package com.xlx.user.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.context.WebServerInitializedEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class UserApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserApiApplication.class, args);
    }

    /**
     * 注册事件监听器, 查看使用的内嵌容器类型
     * @param event
     */
    @EventListener(WebServerInitializedEvent.class)
    public void init(WebServerInitializedEvent event){
        System.out.println(event.getWebServer().getClass());
    }

}
