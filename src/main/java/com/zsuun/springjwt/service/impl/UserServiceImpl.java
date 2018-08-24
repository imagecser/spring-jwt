package com.zsuun.springjwt.service.impl;

import com.zsuun.springjwt.domain.entity.User;
import com.zsuun.springjwt.repository.UserRepository;
import com.zsuun.springjwt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @CachePut(value = "user", key = "#user.username")
    public User saveUser(User user) {
        if (userRepository.findByUsername(user.getUsername()) == null)
            return userRepository.save(user);
        return null;
    }

    public User findUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public List<User> findAllUser() {
        return userRepository.findAll();
    }

    public void deleteUser(String username) {
        userRepository.deleteByUsername(username);
    }
}
