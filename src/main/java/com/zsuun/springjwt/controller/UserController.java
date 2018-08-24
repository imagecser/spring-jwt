package com.zsuun.springjwt.controller;

import com.zsuun.springjwt.domain.entity.User;
import com.zsuun.springjwt.domain.exception.Jwt4xxControllerException;
import com.zsuun.springjwt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService service;

    @GetMapping()
    public List<User> findAllUser() {
        return service.findAllUser();
    }

    @PostMapping()
    public void saveUser(@RequestBody User user) {
        if (service.saveUser(user) != user) {
            throw new Jwt4xxControllerException("Username exists");
        }
    }

    @GetMapping("/{username}")
    public User getUser(@PathVariable String username) {
        return service.findUserByUsername(username);
    }

    @DeleteMapping("/{username}")
    public void deleteUser(@PathVariable String username) {
        service.deleteUser(username);
    }

    @GetMapping("/username")
    public boolean isUsernameExists(@Valid String search) {
        return service.findUserByUsername(search) != null;
    }
}
