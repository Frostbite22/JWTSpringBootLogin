package com.app.jwt.loginjwt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.jwt.loginjwt.domain.Role;

public interface RoleRepository extends JpaRepository<Role,Long> {
	Role findByName(String name);
}
