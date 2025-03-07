package com.prueba.crudSecurity.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prueba.crudSecurity.models.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
