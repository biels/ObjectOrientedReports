package com.biel.oor.types.enterprise.invoice;

import java.util.ArrayList;

public class Product {
	private String name;
	private String description;
	private double price;
	private double discountRate = 0F;
	//Support for nested products
	private ArrayList<Product> products = new ArrayList<Product>();
	
	//Edit getters to match view's needs. Add getters for priceBeforeDiscount... 
	//Maybe merge product and productrequest into InvoiceProduct
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	protected double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public double getDiscountRate() {
		return discountRate;
	}
	public void setDiscountRate(double discountRate) {
		this.discountRate = discountRate;
	}
	public ArrayList<Product> getProducts() {
		return products;
	}
	public void setProducts(ArrayList<Product> products) {
		this.products = products;
	}
	
	public String getPriceFormatted(){
		return InvoiceReportController.formatCurrencyField(getPrice());
	}
}
