package com.xlx.user.repository.controller;

import com.xlx.user.repository.mongo.SpringDataMongoTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MongoTestController {

    @Autowired
    private SpringDataMongoTest test;

    @GetMapping("/mongo/test")
    public String test(){
        test.print();
        return "yes";
    }
}
