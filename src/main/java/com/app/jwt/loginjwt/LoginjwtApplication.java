package com.app.jwt.loginjwt;

import java.util.ArrayList;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.app.jwt.loginjwt.domain.Role;
import com.app.jwt.loginjwt.domain.User;
import com.app.jwt.loginjwt.service.UserService;

@SpringBootApplication
public class LoginjwtApplication {

	public static void main(String[] args) {
		SpringApplication.run(LoginjwtApplication.class, args);
	}
	
	@Bean
	CommandLineRunner run(UserService userService)
	{
		return args -> 
		{
			userService.saveRole(new Role(null, "ROLE_USER"));
			userService.saveRole(new Role(null, "ROLE_ADMIN"));
			
			userService.save(new User(null,"lasaad zaa","za3","1234",new ArrayList<>()));
			userService.save(new User(null,"dali jj","jjd","1234",new ArrayList<>()));

			userService.addRoleToUser("za3","ROLE_USER");
			userService.addRoleToUser("jjd","ROLE_ADMIN");
			userService.addRoleToUser("jjd","ROLE_USER");
		
		};
	}
	
	@Bean
	PasswordEncoder passwordEncoder() 
	{
		return new BCryptPasswordEncoder() ; 
	}

}
