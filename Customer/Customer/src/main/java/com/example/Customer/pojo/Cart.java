package com.example.Customer.pojo;

import java.util.*;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @OneToOne
    @JoinColumn(name = "customer_id", referencedColumnName = "customerId")
    private Customer customer;
    
    @ManyToMany
    @JoinTable(
        name = "cart_product", 
        joinColumns = @JoinColumn(name = "cart_id"), 
        inverseJoinColumns = @JoinColumn(name = "product_id")
    )
    @JsonManagedReference
    private List<Products> products = new ArrayList<>(); // Initialize the list
    
    public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public List<Products> getProducts() {
		return products;
	}

	public void setProducts(List<Products> products) {
		this.products = products;
	}

	private int quantity=0;
    private double totalPrice=0;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

	@Override
	public String toString() {
		return "Cart [id=" + id + ", customer=" + customer + ", products=" + products + ", quantity=" + quantity
				+ ", totalPrice=" + totalPrice + "]";
	}
    
}