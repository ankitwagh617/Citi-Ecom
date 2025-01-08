package com.example.Admin.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Admin.pojos.Cart;

public interface CartRepository extends JpaRepository<Cart, Integer>{
	
	public Cart findByCustomerCustomerId(int id);
}
