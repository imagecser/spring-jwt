package com.zsuun.springjwt.service;

import com.zsuun.springjwt.domain.entity.User;

import java.util.List;

public interface UserService {

    User saveUser(User user);

    User findUserByUsername(String username);

    List<User> findAllUser();

    void deleteUser(String username);
}
