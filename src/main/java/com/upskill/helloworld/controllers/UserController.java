package com.upskill.helloworld.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.upskill.helloworld.models.User;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @GetMapping(value = "/user")
    public User user() {
        return createUser();
    }

    @GetMapping(value = "/users/{name}/{active}")
    public User userVarName(@PathVariable("name") String name, @PathVariable("active") boolean active) {
        User x = new User();
        x.setName(name);
        x.setActive(active);
        return x;
    }

    @GetMapping(value = "/users/{id}")
    public User userVarName(@PathVariable("id") int id) {
        User x = new User();
        x.setId(id);
        return x;
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
        Random random = new Random();
        User user = new User();
        user.setId(random.nextInt(100));
        user.setName("Ming Xiang");
        String[] roles = {"admin", "superadmin"};
        user.setRoles(roles);
        user.setActive(true);
        return user;
    }
}