package com.example.Admin.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Admin.pojos.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer>{

}
