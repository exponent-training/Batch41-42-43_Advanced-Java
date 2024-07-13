package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringbootCommandLineRunnerexample4Application implements CommandLineRunner {

	
	
	@Autowired
	private RoleRepository roleRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringbootCommandLineRunnerexample4Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		  System.out.println("Run Method Calling.");
		  Role role = new Role();
		  role.setId(1);role.setRoleName("admin");
		  roleRepository.save(role);
	}

}
