package com.example.Admin.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Admin.pojos.Products;

public interface ProductRepository extends JpaRepository<Products, Integer> {
	
}
