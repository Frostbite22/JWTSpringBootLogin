package com.app.jwt.loginjwt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.jwt.loginjwt.domain.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role,Long> {
	Role findByName(String name);
}
