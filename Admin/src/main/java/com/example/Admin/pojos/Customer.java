package com.example.Admin.pojos;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;


@Entity
public class Customer {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int customerId;
	private String customerName;
	private double customerBalance;
	
	@OneToOne(cascade = CascadeType.ALL, mappedBy = "customer")
    private Cart cart;
	
	public Customer(){}

	public Customer(String customerName, double customerBalance) {
		super();
		this.customerName = customerName;
		this.customerBalance = customerBalance;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public double getCustomerBalance() {
		return customerBalance;
	}

	public void setCustomerBalance(double customerBalance) {
		this.customerBalance = customerBalance;
	}

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", customerName=" + customerName + ", customerBalance="
				+ customerBalance + "]";
	}

}
