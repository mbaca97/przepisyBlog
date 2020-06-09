package com.przepisy.przepisy.auth.service;

import com.przepisy.przepisy.auth.model.User;

public interface UserService {
    void save(User user);

    User findByUsername(String username);
}