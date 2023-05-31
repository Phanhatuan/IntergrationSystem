package com.example.testconnection2db.dive.dev.secondary.controller;

import com.example.testconnection2db.dive.dev.secondary.models.UserDetail;
import com.example.testconnection2db.dive.dev.secondary.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    UserRepository userRepository;

    @GetMapping("/users")
    List<UserDetail> getUsers(){
        return userRepository.findAll();
    }

    @PostMapping(path = "/users")
    List<UserDetail> addUser (@RequestBody UserDetail userDetail) throws Exception{
        userRepository.save(userDetail);
        return userRepository.findAll();
    }
}
