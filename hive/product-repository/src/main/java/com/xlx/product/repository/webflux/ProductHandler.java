//package com.xlx.product.repository.webflux;
//
//import com.xlx.product.repository.service.ProductService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//import org.springframework.web.reactive.function.server.ServerRequest;
//import org.springframework.web.reactive.function.server.ServerResponse;
//import reactor.core.publisher.Mono;
//
//@Component
//public class ProductHandler {
//
//    @Autowired
//    ProductService productService;
//
//    public Mono<ServerResponse> findAndSave(ServerRequest serverRequest){
//        return ServerResponse.ok().body(subscriber -> productService.findAndSave(), String.class);
//    }
//
//    public Mono<ServerResponse> findAndSaveWithWrite(ServerRequest serverRequest){
//        return ServerResponse.ok().body(subscriber -> productService.findAndSaveWithWrite(),String.class);
//    }
//
//}
