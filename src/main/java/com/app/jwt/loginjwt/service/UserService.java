package com.app.jwt.loginjwt.service;

import java.util.List;

import com.app.jwt.loginjwt.domain.Role;
import com.app.jwt.loginjwt.domain.User;

public interface UserService {
	User save(User user) ;
	Role saveRole(Role role); 
	void addRoleToUser(String username, String roleName);
	User getUser(String username); 
	List<User> getUsers(); 
}
