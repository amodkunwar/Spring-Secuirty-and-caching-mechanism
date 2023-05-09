package com.amod.security.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.amod.security.dto.Product;
import com.amod.security.entity.UserInfo;
import com.amod.security.repository.UserRepository;

import jakarta.annotation.PostConstruct;

@Service
public class ProductService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	List<Product> productList = new ArrayList<>();

	@PostConstruct
	public List<Product> getAllProduct() {

		Product product = new Product();
		product.setProductId(1);
		product.setName("productName");
		product.setPrice(1000);
		product.setQty(2);
		productList.add(product);
		return productList;
	}

	public List<Product> getProducts() {
		return getAllProduct();
	}

	public Product getProduct(int id) {
		List<Product> collect = productList.stream().filter(pro -> pro.getProductId() == id)
				.collect(Collectors.toList());
		return collect.get(0);
	}

	public String addUser(UserInfo userInfo) {
		userInfo.setPassword(passwordEncoder.encode(userInfo.getPassword()));
		userRepository.save(userInfo);
		return "User added in the system";
	}
	
}
