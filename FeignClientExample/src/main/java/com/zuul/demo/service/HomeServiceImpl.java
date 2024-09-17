package com.zuul.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.zuul.demo.model.Product;

@Service
public class HomeServiceImpl implements HomeService{
	
	@Autowired
	private ProductFeignClient productFeignClient;

	@Override
	@HystrixCommand(fallbackMethod = "callProductFetchAndGetData" )
	public Product findProduct(String name) {
		// TODO Auto-generated method stub
		Product product = productFeignClient.findProductByName(name);
		return product;
	}
	
	public Product callProductFetchAndGetData(String name) {
		Product product = new Product();
		product.setName("Service is Down.");
		return product;
	}

}
