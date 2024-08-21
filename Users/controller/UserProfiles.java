package com.meal360.web.Users.controller;

import com.meal360.web.Users.model.Users;
import com.meal360.web.Users.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class UserProfiles {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/user")
    public String user(){

        return this.toString();
    }

    @GetMapping("/users/v1/all")
    public List<Users> getAll(){
        return userRepository.findAll();
    }

/*    @GetMapping("/users/v1/db")
    public List<Users> getAll(){
        return userRepository.findOne("foo").;
    }*/

}
