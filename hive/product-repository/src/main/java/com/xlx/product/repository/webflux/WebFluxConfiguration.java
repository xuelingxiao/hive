//package com.xlx.product.repository.webflux;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.reactive.function.server.RouterFunction;
//import org.springframework.web.reactive.function.server.ServerResponse;
//
//import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
//import static org.springframework.web.reactive.function.server.RouterFunctions.route;
//
//@Configuration
//public class WebFluxConfiguration {
//
//    @Bean
//    public RouterFunction<ServerResponse> findAndSave(ProductHandler productHandler) {
//        return route(GET("/product/findAndSave"),productHandler::findAndSave);
//    }
//
//    @Bean
//    public RouterFunction<ServerResponse> findAndSaveWithWrite(ProductHandler productHandler) {
//        return route(GET("/product/findAndSaveWithWrite"),productHandler::findAndSaveWithWrite);
//    }
//}
