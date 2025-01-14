package com.example.Customer.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Customer.pojo.Cart;

public interface CartRepository extends JpaRepository<Cart, Integer>{
	
	public Cart findByCustomerCustomerId(int id);
}
