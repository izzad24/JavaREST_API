package com.upskill.helloworld.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PublicController {

    @GetMapping(value = "/")
    public String index() {
        return "Hello Izzad";
    }
    
    @GetMapping(value = "/welcome")
    public String welcome() {
        return "Welcome Izzad";
    }
    
    @GetMapping(value = "/goodbye")
    public String goodbye() {
        return "Goodbye Izzad";
    }

    @GetMapping(value = "/empty_json")
    public String emptyJson() {
        return "{}";
    }
    
    @GetMapping(value = "/json")
    public String json() {
        return "{\"id\": 12, \"name\": \"Ming Xiang\"}";
    }
    
    @GetMapping(value = "/single_user")
    public String singleUser() {
        return "{ \"id\": 60, \"name\": \"Ming Xiang\", \"roles\" : [\"admin\", \"superadmin\"], \"active\" : true }";
    }
}