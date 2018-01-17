package com.nissho.vn.service;

import java.util.List;

import com.nissho.vn.model.Product;

public interface ProductService {
	List<Product> getAllProducts();
	Product findOne(String code);
}
