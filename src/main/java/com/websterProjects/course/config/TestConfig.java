package com.websterProjects.course.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.websterProjects.course.entities.User;
import com.websterProjects.course.repositories.UserRepository;

//Classe específica de configuração

@Configuration //Sinaliza ao Spring que essa classe é uma classe de configuração 
@Profile("test") //Spring só roda essa configuração quando estiver no perfil de teste (definido no application.properties)
public class TestConfig implements CommandLineRunner {
	
	@Autowired //Resolve problema de dependência, tornando fraca
	private UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {
		
		User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
		User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456"); 
		
		userRepository.saveAll(Arrays.asList(u1,u2));

		
	}
	
	
	
}
