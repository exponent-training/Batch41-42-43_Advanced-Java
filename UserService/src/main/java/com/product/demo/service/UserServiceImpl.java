package com.product.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.product.demo.model.Product;

@Service
public class UserServiceImpl implements UserServiceI{

	@Autowired
	private RestTemplate restTemplate;
	
	@Override
	public Product getProduct(String name) {
		// TODO Auto-generated method stub
		Product product = restTemplate.getForObject("http://localhost:9001/find/"+name, Product.class);
		if(product == null) {
			Product product1 = new Product();
		   	product1.setMsg("Not Found");
		   	return product1;
		}
		return product;
	}

}
