package com.websterProjects.course.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.websterProjects.course.entities.User;

@RestController //Define que essa classe é um recurso web controlado por um controlodaor REST
@RequestMapping(value = "/users")
public class UserResoursce {
	
	@GetMapping // Indica que o método responde requisição do tipo GET http
	public ResponseEntity<User> findAll(){
		User u = new User(1L, "André", "andre@gmail.com", "11999999", "15161521");
		return ResponseEntity.ok().body(u);
	}
}
