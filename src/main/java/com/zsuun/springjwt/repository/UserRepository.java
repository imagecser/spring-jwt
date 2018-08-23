package com.zsuun.springjwt.repository;


import com.zsuun.springjwt.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Component
public interface UserRepository extends JpaRepository<User, String> {
    User findByUsername(String username);
}
