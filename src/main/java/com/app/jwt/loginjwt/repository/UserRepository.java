package com.app.jwt.loginjwt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.jwt.loginjwt.domain.User;

public interface UserRepository extends JpaRepository<User,Long>{
	User findByUsername(String username) ;
}
