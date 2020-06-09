package com.przepisy.przepisy.auth.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.przepisy.przepisy.auth.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}