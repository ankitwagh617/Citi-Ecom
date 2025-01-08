package com.example.Customer.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Customer.pojo.Products;

public interface ProductRepository extends JpaRepository<Products, Integer>{

}
