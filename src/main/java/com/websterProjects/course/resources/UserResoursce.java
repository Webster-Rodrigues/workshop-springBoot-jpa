package com.websterProjects.course.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.websterProjects.course.entities.User;
import com.websterProjects.course.services.UserService;

@RestController //Define que essa classe é um recurso web controlado por um controlodaor REST
@RequestMapping(value = "/users")
public class UserResoursce {
	
	@Autowired
	private UserService service;
	
	@GetMapping // Indica que o método responde requisição do tipo GET http
	public ResponseEntity<List<User>> findAll(){
		List<User> list  = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<User> findById(@PathVariable Long id){
		User obj =  service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	
	@PostMapping
	public ResponseEntity<User> insert(@RequestBody User obj){ // Sinaliza que o obj vai chegar como json na hora da requisição e depois json desserializado objeto
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}
}
