package com.example.Admin.controllers;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.Admin.pojos.Cart;
import com.example.Admin.pojos.Customer;
import com.example.Admin.pojos.Products;
import com.example.Admin.repositories.CartRepository;
import com.example.Admin.repositories.CustomerRepository;
import com.example.Admin.repositories.ProductRepository;

@RestController
public class productController {
	
	@Autowired
	ProductRepository repo;
	
	@Autowired
	CustomerRepository repo1;
	
	@Autowired
	CartRepository	repo2;
	
	@PostMapping("/addproduct")
	public void addProduct(@RequestBody Products p){
		repo.save(p);
	}
	
	@DeleteMapping("/deleteproduct/{productNo}")
	public void deleteProduct(@PathVariable int productNo){
		repo.deleteById(productNo);
	}
	
	@GetMapping("/getallproducts")
	public List<Products> getAllProducts() {
		List<Products> list = repo.findAll();
		return list;	
	}
	
	@PostMapping("/addcustomer")
	public void addProduct(@RequestBody Customer c){
		repo1.save(c);
		Cart c1 = new Cart();
		c1.setCustomer(c);
		repo2.save(c1);
	}
	
	@GetMapping("/getallcustomers")
	public List<Customer> getAllCustomers() {
		List<Customer> list = repo1.findAll();
		return list;	
	}
	
	@DeleteMapping("/deletecustomer/{customerId}")
	public void deleteCustomer(@PathVariable int customerId){
		repo1.deleteById(customerId);
	}
	
	 public Products updateProduct(int productId, String newName, Double newPrice,
			 Double newDiscount,int newQuantity) {
	        
	        Optional<Products> optionalProduct = repo.findById(productId);

	        if (optionalProduct.isPresent()) {
	            
	            Products product = optionalProduct.get();
	            product.setProductName(newName);
	            product.setProductDiscount(newDiscount);
	            product.setProductQuantity(newQuantity);
	            product.setProductPrice(newPrice);

	            return repo.save(product);
	        } else {
	            throw new RuntimeException("Product with ID " + productId + " not found");
	        }
	    }
	
	@PutMapping("updateproduct/{id}")
    public Products updateProduct(@PathVariable int id, @RequestBody Products updatedProduct) {
        return updateProduct(id, updatedProduct.getProductName(), updatedProduct.getProductPrice(),
        		updatedProduct.getProductDiscount(),updatedProduct.getProductQuantity());
    }

}
