package com.upskill.helloworld.controllers;

import java.util.ArrayList;
import java.util.List;

import com.upskill.helloworld.models.User;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    public ArrayList<User> userList = new ArrayList<>();

    @GetMapping(value = "/users/{id}")
    public User showUser(@PathVariable("id") int id) {
        ArrayList<User> users = seedUsers();
        for (User user : users) {
            if (user.getId() == id) {
                return user;
            }
        }
        return null;
    }

    @GetMapping(value = "/users/{name}/{active}")
    public User userVarName(@PathVariable("name") String name, @PathVariable("active") boolean active) {
        User x = new User();
        x.setName(name);
        x.setActive(active);
        return x;
    }

    @GetMapping(value = "/users")
    public List<User> users(@RequestParam(name = "active", required = false)Boolean active, @RequestParam(name = "name", required = false)String name) {
        ArrayList<User> users = seedUsers();
        ArrayList<User> result = new ArrayList<>();
        for (User user : users) {
            // System.out.println(user.getName());
            if(name != null && active != null){
                if(user.getName().equalsIgnoreCase(name) && user.getActive() == active){
                    result.add(user);
                }
            }else if(name != null){
                if(user.getName().equalsIgnoreCase(name)){
                    result.add(user);
                }
            }else if(active != null){
                if(user.getActive() == active){
                    result.add(user);
                }
            }
        }
        if(!result.isEmpty()){
            return result;
        }else{
            return users;
        }
    }

    @GetMapping(value = "/user2")
    public List<User> users2() {
        ArrayList<User> list = new ArrayList<>();
        list.add(createUser());
        list.add(createUser());
        list.add(createUser());
        return list;
    }

    @PostMapping(value="/users")
    public User create(@RequestBody User user){
        User x = new User();
        x.setName(user.getName());
        x.setActive(user.getActive());
        String[] roles = {"user"};
        x.setRoles(roles);
        return x;
    }

    @PostMapping(value="/update_user")
    public List<User> update(@RequestBody User user){
        
        if(user.getId() != null){
            for (int i = 0 ; i < userList.toArray().length; i++) {
                if(userList.get(i).getId() == user.getId()){
                    if(user.getName() != null){
                        userList.get(i).setName(user.getName());
                    }
                    if(user.getRoles() != null){
                        userList.get(i).setRoles(user.getRoles());
                    }
                    if(user.getActive() != null){
                        userList.get(i).setActive(user.getActive());
                    }
                }
            }
        }else{
            for (int i = 0 ; i < userList.toArray().length; i++) {
                if(userList.get(i).getName().equalsIgnoreCase(user.getName())){
                    if(user.getRoles() != null){
                        userList.get(i).setRoles(user.getRoles());
                    }
                    if(user.getActive() != null){
                        userList.get(i).setActive(user.getActive());
                    }
                }
            }
        }

        return userList;
    }

    User createUser(){
        User user = new User();
        user.setName("Test User");
        String[] roles = {"admin", "superadmin"};
        user.setRoles(roles);
        user.setActive(true);
        return user;
    }

    ArrayList<User> seedUsers(){
        boolean active = true;
        // ArrayList<User> users = new ArrayList<>();
        for(int id = 1; id < 12; id++){
            User user = createUser();
            user.setId(id);
            user.setActive(active);
            userList.add(user);
            active = !active;
        }

        userList.get(0).setName("Ming Hao");
        userList.get(2).setName("Izzad");
        userList.get(4).setName("Zakwan");
        userList.get(5).setName("Faiz");
        userList.get(7).setName("Ashraf");
        userList.get(10).setName("Hazel");

        return userList;
    }
}