package com.app.jwt.loginjwt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.jwt.loginjwt.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User,Long>{
	User findByUsername(String username) ;
}
