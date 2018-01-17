package com.nissho.vn.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nissho.vn.model.Product;
import com.nissho.vn.service.CategoryService;
import com.nissho.vn.service.ProductService;
import com.sun.jndi.url.corbaname.corbanameURLContextFactory;

@Controller
public class Index {
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private CategoryService categoryService;
	
	
	
	@SuppressWarnings("unchecked")
	@GetMapping(value = "/")
	public String index(Model model, HttpServletRequest request) {
		
		model.addAttribute("listProducts", productService.getAllProducts());
		model.addAttribute("listCategories", categoryService.getAllCategories());
		
		if(request.getSession().getAttribute("listProductIdOrdered") != null) {
			List<String> listProductIdOrdered = (List<String>) request.getAttribute("listProductIdOrdered");
			model.addAttribute("listProductIdOrdered", listProductIdOrdered);
		}
		
		return "index";
	}
	
	@GetMapping(value = "/findOne/{productCode}")
	public String showDetail(@ModelAttribute("productCode") String productCode, Model model) {
		model.addAttribute("product", productService.findOne(productCode));
		return "productDetail";
	}
	
	@SuppressWarnings("unchecked")
	@PostMapping("/addToCart")
	@ResponseBody
	public String addToCart(@RequestParam("productCode") String productCode,Model model, HttpServletRequest request) {
		List<String> listProductIdOrdered;
		
		if(request.getSession().getAttribute("listProductIdOrdered") != null) {
			listProductIdOrdered = (List<String>) request.getSession().getAttribute("listProductIdOrdered");
		} else {
			listProductIdOrdered = new ArrayList<String>();
		}
		
		listProductIdOrdered.add(productCode);
		request.getSession().setAttribute("listProductIdOrdered", listProductIdOrdered);
		
		return "index";
	}
	
	
}
