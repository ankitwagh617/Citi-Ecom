package com.example.Admin.pojos;

import java.util.*;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;


@Entity
public class Products {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int productNo;
	private String productName;
	private double productPrice;
	private int productQuantity;
	private double productDiscount;
	

	@ManyToMany(mappedBy = "products")
    private List<Cart> carts = new ArrayList<>();
	
	public Products() {}
	public Products(String productName, double productPrice, int productQuantity,
			double productDiscount) {
		super();
		;
		this.productName = productName;
		this.productPrice = productPrice;
		this.productQuantity = productQuantity;
		this.productDiscount = productDiscount;
	}
	public int getProductNo() {
		return productNo;
	}
	public void setProductNo(int productNo) {
		this.productNo = productNo;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public double getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}
	public int getProductQuantity() {
		return productQuantity;
	}
	public void setProductQuantity(int productQuantity) {
		this.productQuantity = productQuantity;
	}
	public double getProductDiscount() {
		return productDiscount;
	}
	public void setProductDiscount(double productDiscount) {
		this.productDiscount = productDiscount;
	}
	public List<Cart> getCarts() {
		return carts;
	}
	public void setCarts(List<Cart> carts) {
		this.carts = carts;
	}
	@Override
	public String toString() {
		return "Products [productNo=" + productNo + ", productName=" + productName + ", productPrice=" + productPrice
				+ ", productQuantity=" + productQuantity + ", productDiscount=" + productDiscount + ", carts=" + carts
				+ "]";
	}
	
	
	
	

}
