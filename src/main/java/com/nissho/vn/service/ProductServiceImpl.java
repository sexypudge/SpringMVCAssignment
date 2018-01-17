package com.nissho.vn.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nissho.vn.dao.ProductDao;
import com.nissho.vn.model.Product;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductDao productDao;
	
	public List<Product> getAllProducts() {
		return productDao.getAllProducts();
	}

	public Product findOne(String code) {
		return productDao.findOne(code);
	}

}
