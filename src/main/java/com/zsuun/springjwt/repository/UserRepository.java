package com.zsuun.springjwt.repository;


import com.zsuun.springjwt.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface UserRepository extends JpaRepository<User, String> {
    User findByUsername(String username);

    void deleteByUsername(String username);
}
