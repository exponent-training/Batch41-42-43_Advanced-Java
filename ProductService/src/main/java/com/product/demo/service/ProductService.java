package com.product.demo.service;

import java.util.List;

import com.product.demo.entity.Product;

public interface ProductService {
  
	List<Product> fetchAllProducts();
	
	void saveProduct(Product product);
	
	Product getProduct(String name);
}
