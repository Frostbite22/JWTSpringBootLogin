package com.app.jwt.loginjwt.service;

import java.util.Collection;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.jwt.loginjwt.domain.Role;
import com.app.jwt.loginjwt.domain.User;
import com.app.jwt.loginjwt.repository.RoleRepository;
import com.app.jwt.loginjwt.repository.UserRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class UserServiceImpl implements UserService {
	
	private UserRepository userRepository ;
	private RoleRepository roleRepository ; 
	@Override
	public User save(User user) {
		return userRepository.save(user);
	}

	@Override
	public Role saveRole(Role role) {
		return roleRepository.save(role);
		
	}

	@Override
	public void addRoleToUser(String username, String roleName) {
		User user = userRepository.findByUsername(username);
		Role role = roleRepository.findByName(roleName);
		user.getRoles().add(role);
	}

	@Override
	public User getUser(String username) {
		return userRepository.findByUsername(username);
	}

	@Override
	public List<User> getUsers() {
		
		return userRepository.findAll();
	}

}
