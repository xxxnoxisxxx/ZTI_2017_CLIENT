package com.zti.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.zti.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}