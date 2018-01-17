package com.nissho.vn.dao;

import java.util.List;

import com.nissho.vn.model.Product;

public interface ProductDao {
	List<Product> getAllProducts();
	Product findOne(String code);
}
