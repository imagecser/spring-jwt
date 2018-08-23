package com.zsuun.springjwt.controller;

import com.zsuun.springjwt.entity.User;
import com.zsuun.springjwt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class UserController {

    @Autowired
    private UserService service;

    @PostMapping("/user")
    public ResponseEntity saveUser(@RequestBody User user) {
        service.saveUser(user);
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("/user/{username}")
    public ResponseEntity getUser(@PathVariable String username) {
        return new ResponseEntity(service.findUserByUsername(username), HttpStatus.OK);
    }
}
