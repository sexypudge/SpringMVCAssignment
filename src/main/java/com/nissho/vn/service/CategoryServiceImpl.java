package com.nissho.vn.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nissho.vn.dao.CategoryDao;
import com.nissho.vn.model.Category;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {
	
	@Autowired
	private CategoryDao categoryDao;
	
	public List<Category> getAllCategories() {
		return categoryDao.getAllCategories();
	}
	
}
