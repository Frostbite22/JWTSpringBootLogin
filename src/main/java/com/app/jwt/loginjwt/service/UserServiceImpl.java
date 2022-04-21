package com.app.jwt.loginjwt.service;

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
	
	@Autowired
	private UserRepository userRepository ;
	@Autowired
	private RoleRepository roleRepository ; 
	@Override
	public User save(User user) {
		log.info("Saving user to the database",user.getName());
		return userRepository.save(user);
	}

	@Override
	public Role saveRole(Role role) {
		log.info("Saving user to the database",role.getName());
		return roleRepository.save(role);
		
	}

	@Override
	public void addRoleToUser(String username, String roleName) {
		log.info("Add role {} to {} ",roleName,username);

		User user = userRepository.findByUsername(username);
		Role role = roleRepository.findByName(roleName);
		user.getRoles().add(role);
	}

	@Override
	public User getUser(String username) {
		log.info("Fetching User {}",username);

		return userRepository.findByUsername(username);
	}

	@Override
	public List<User> getUsers() {
		log.info("Fetching all users");

		return userRepository.findAll() ;
	}

}
