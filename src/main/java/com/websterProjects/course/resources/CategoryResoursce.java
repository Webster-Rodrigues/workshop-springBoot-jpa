package com.websterProjects.course.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.websterProjects.course.entities.Category;
import com.websterProjects.course.services.CategoryService;

@RestController //Define que essa classe é um recurso web controlado por um controlodaor REST
@RequestMapping(value = "/categories")
public class CategoryResoursce {
	
	@Autowired
	private CategoryService service;
	
	@GetMapping // Indica que o método responde requisição do tipo GET http
	public ResponseEntity<List<Category>> findAll(){
		List<Category> list  = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Category> findById(@PathVariable Long id){
		Category obj =  service.findById(id);
		return ResponseEntity.ok().body(obj);
		
	}
}
