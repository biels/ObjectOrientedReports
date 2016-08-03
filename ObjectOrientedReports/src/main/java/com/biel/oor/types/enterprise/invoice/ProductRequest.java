package com.biel.oor.types.enterprise.invoice;

public class ProductRequest {
	private Product product;
	private int amount;
	
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public double getTotalPrice(){
		return product.getPrice() * amount;
	}
	
}
