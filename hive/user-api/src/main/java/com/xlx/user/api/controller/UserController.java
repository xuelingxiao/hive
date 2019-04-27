package com.xlx.user.api.controller;

import com.xlx.user.api.config.Person;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @PostMapping(value = "/properties",produces = "application/properties+person")
    public Object properties(@RequestBody Person person){
        return person;
    }
    @PostMapping(value = "/person",produces = "application/json",consumes ="application/properties+person" )
    public Object person(@RequestBody Person person){
        return person;
    }
}
