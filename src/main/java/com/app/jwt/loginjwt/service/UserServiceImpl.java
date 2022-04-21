package com.app.jwt.loginjwt.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
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
public class UserServiceImpl implements UserService, UserDetailsService {
	
	@Autowired
	private UserRepository userRepository ;
	@Autowired
	private RoleRepository roleRepository ; 
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByUsername(username);
		if (user == null) 
		{
			log.error("user not found in the database");
			throw new UsernameNotFoundException("User not found in database");
		}
		else 
		{
			log.info("user found in the databse : {} ",username); 	
		}
		Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
		user.getRoles().forEach(role -> 
		{
			authorities.add(new SimpleGrantedAuthority(role.getName()));
		});
		return new org.springframework.security.core.userdetails.
				User(user.getUsername(),user.getPassword(),authorities);
	}
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
