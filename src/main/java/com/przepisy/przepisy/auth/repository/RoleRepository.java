package com.przepisy.przepisy.auth.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.przepisy.przepisy.auth.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long>{
}