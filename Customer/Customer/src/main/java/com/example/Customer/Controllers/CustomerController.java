package com.example.Customer.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.Customer.Repositories.CartRepository;
import com.example.Customer.Repositories.CustomerRepository;
import com.example.Customer.Repositories.ProductRepository;
import com.example.Customer.pojo.Cart;
import com.example.Customer.pojo.Customer;
import com.example.Customer.pojo.Products;



@RestController
public class CustomerController {
	
	@Autowired
	CustomerRepository repo;
	
	@Autowired
	ProductRepository repo1;
	
	@Autowired
	CartRepository repo2;

	 @PostMapping("addproducttocart/{customerId}/cart/{productNo}")
	 public String addProductToCart(@PathVariable int customerId,@PathVariable int productNo) {
		 
		 Cart cart =  repo2.findByCustomerCustomerId(customerId);
		 Products product = repo1.getReferenceById(productNo);
		 cart.setQuantity(cart.getQuantity()+1);
		 cart.setTotalPrice(cart.getTotalPrice()+product.getProductPrice());
		 cart.getProducts().add(product);
		 repo2.save(cart);
		 return "Item added to Cart";
	 }
	 
	 @GetMapping("viewcart/{customerId}")
	 public List<Products> viewproducts(@PathVariable int customerId){
		 Cart cart =  repo2.findByCustomerCustomerId(customerId);
		 List<Products> list = cart.getProducts();
		 return list;
	 }
	 
	 @DeleteMapping("removeproductfromcart/{customerId}/cart/{productNo}")
	 public String viewproducts(@PathVariable int customerId,@PathVariable int productNo){
		 Cart cart =  repo2.findByCustomerCustomerId(customerId);
		 Products product = repo1.getReferenceById(productNo);
		 cart.setQuantity(cart.getQuantity() > 0 ? cart.getQuantity()-1:cart.getQuantity());
		 cart.setTotalPrice(cart.getTotalPrice()-product.getProductPrice());
		 cart.getProducts().remove(product);
		 repo2.save(cart);
		 return "Item removed from Cart";
	 }
	 
	 @PostMapping("addbalance/{customerId}")
	 public String addBalance(@PathVariable int customerId, @RequestBody int credit) {
		 
		 Customer customer =  repo.getReferenceById(customerId);
		 customer.setCustomerBalance(customer.getCustomerBalance()+credit);
		 repo.save(customer);
		 return "Balance updated successfully";
	 }
	 
	 @GetMapping("/getallproducts")
     public List<Products> getAllProducts() {
		List<Products> list = repo1.findAll();
		return list;	
	 }
	 
	 @GetMapping("/gettotalbalance/{customerId}")
     public double getBalance(@PathVariable int customerId) {
		 double balance = 0;
		 Customer cust = repo.getReferenceById(customerId);
		 balance = cust.getCustomerBalance();
		 return balance;
	 }
	 
	 @GetMapping("/placeorder/{customerId}")
     public String payBill(@PathVariable int customerId) {
		 
		 Customer cust = repo.getReferenceById(customerId);
		 Cart cart =  repo2.findByCustomerCustomerId(customerId);
		 double balance =  cust.getCustomerBalance();
		 double cartbalance = cart.getTotalPrice();
		 double diff = balance-cartbalance;
		 System.out.println(diff);
		 if(balance > cartbalance) {
			 cust.setCustomerBalance(diff);
			 repo.save(cust);
			 return "Order Placed Successfully";
		 }
		 return "Inufficient Balance";
	 }
}
