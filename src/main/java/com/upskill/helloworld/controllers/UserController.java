package com.upskill.helloworld.controllers;

import java.util.ArrayList;
import java.util.List;

import com.upskill.helloworld.models.User;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @GetMapping(value = "/user")
    public User user() {
        return createUser();
    }

    @GetMapping(value = "/users")
    public User[] users() {
        User[] arr = {
            createUser(),
            createUser(),
        };
        return arr;
    }

    @GetMapping(value = "/user2")
    public List<User> users2() {
        ArrayList<User> list = new ArrayList<>();
        list.add(createUser());
        list.add(createUser());
        list.add(createUser());
        return list;
    }

    User createUser(){
        User user = new User();
        user.id = 60;
        user.name = "Ming Xiang";
        String[] roles = {"admin", "superadmin"};
        user.roles = roles;
        user.active = true;
        return user;
    }
}