package com.websterProjects.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.websterProjects.course.entities.Product;

//Interface responsável por instânciar obj Repository com operações para trabalhar com o usuário 
public interface ProductRepository extends JpaRepository<Product, Long> {

}
