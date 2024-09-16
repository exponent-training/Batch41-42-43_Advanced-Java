package com.zuul.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zuul.demo.model.Product;

@Service
public class HomeServiceImpl implements HomeService{
	
	@Autowired
	private ProductFeignClient productFeignClient;

	@Override
	public Product findProduct(String name) {
		// TODO Auto-generated method stub
		Product product = productFeignClient.findProductByName(name);
		return product;
	}

}
