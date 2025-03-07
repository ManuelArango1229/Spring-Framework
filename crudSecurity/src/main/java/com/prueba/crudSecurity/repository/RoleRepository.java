package com.prueba.crudSecurity.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.prueba.crudSecurity.models.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
}
