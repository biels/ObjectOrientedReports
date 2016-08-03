package com.biel.oor.types.enterprise.invoice;

import java.util.ArrayList;

public class Product {
	private String name;
	private String description;
	private float price;
	private float discountRate = 0F;
	private float taxRate = 0F;
	//Support for nested products
	private ArrayList<Product> products = new ArrayList<Product>();
	
}
