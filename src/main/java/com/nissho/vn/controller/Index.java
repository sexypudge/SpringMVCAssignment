package com.nissho.vn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nissho.vn.service.ProductService;

@Controller
public class Index {
	
	@Autowired
	private ProductService productService;
	
	@GetMapping(value = "/")
	public String index(Model model) {
		model.addAttribute("listProducts", productService.getAllProducts());
		return "index";
	}
	
	
}
