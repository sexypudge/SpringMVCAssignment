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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nissho.vn.model.Product;
import com.nissho.vn.service.CategoryService;
import com.nissho.vn.service.ProductService;

@Controller
public class ProductController {

	@Autowired
	private ProductService productService;

	@Autowired
	private CategoryService categoryService;

	@SuppressWarnings("unchecked")
	@GetMapping(value = "/")
	public String index(Model model, HttpServletRequest request) {
		model.addAttribute("listProducts", productService.getAllProducts());
		model.addAttribute("listCategories", categoryService.getAllCategories());

		if (request.getSession().getAttribute("listProductIdOrdered") != null) {
			List<String> listProductIdOrdered = (List<String>) request.getSession()
					.getAttribute("listProductIdOrdered");
			model.addAttribute("listProductIdOrdered", listProductIdOrdered);
		}

		return "index";
	}

	@SuppressWarnings("unchecked")
	@GetMapping(value = "/findOne/{productCode}")
	public String showDetail(@ModelAttribute("productCode") String productCode, Model model,
			HttpServletRequest request) {
		if (request.getSession().getAttribute("listProductIdOrdered") != null) {
			List<String> listProductIdOrdered = (List<String>) request.getSession()
					.getAttribute("listProductIdOrdered");
			model.addAttribute("listProductIdOrdered", listProductIdOrdered);
		}
		model.addAttribute("product", productService.findOne(productCode));
		return "productDetail";
	}

	@SuppressWarnings("unchecked")
	@PostMapping("/addToCart")
	@ResponseBody
	public String addToCart(@RequestParam("productCode") String productCode, Model model, HttpServletRequest request) {
		List<String> listProductIdOrdered;

		if (request.getSession().getAttribute("listProductIdOrdered") != null) {
			listProductIdOrdered = (List<String>) request.getSession().getAttribute("listProductIdOrdered");
		} else {
			listProductIdOrdered = new ArrayList<String>();
		}

		listProductIdOrdered.add(productCode);
		request.getSession().setAttribute("listProductIdOrdered", listProductIdOrdered);

		return "index";
	}

	@SuppressWarnings("unchecked")
	@GetMapping("/checkoutCart")
	public String checkoutCart(Model model, HttpServletRequest request) {
		if (request.getSession().getAttribute("listProductIdOrdered") != null) {
			List<String> listProductIdOrdered = (List<String>) request.getSession()
					.getAttribute("listProductIdOrdered");
			List<Product> products = new ArrayList<Product>();

			listProductIdOrdered.forEach(str -> {
				products.add(productService.findOne(str));
			});

			model.addAttribute("products", products);

		}
		return "orderDetail";
	}

	@PostMapping(value = "/filter")
	@ResponseBody
	public String filter(@RequestParam("ctgCode") String ctgCode, Model model, HttpServletRequest request) {
		if (ctgCode == null || "".equals(ctgCode)) {
			return "index";
		} else {
			return ctgCode;
		}
	}

	@SuppressWarnings("unchecked")
	@GetMapping(value = "/searchProduct/{ctgCode}")
	public String searchProduct(@ModelAttribute("ctgCode") String ctgCode, Model model, HttpServletRequest request) {
		List<Product> listProductByCtgCode = productService.getProductByCtgCode(ctgCode);
		model.addAttribute("listProducts", listProductByCtgCode);
		model.addAttribute("listCategories", categoryService.getAllCategories());
		model.addAttribute("ctgCode", ctgCode);
		if (request.getSession().getAttribute("listProductIdOrdered") != null) {
			List<String> listProductIdOrdered = (List<String>) request.getSession()
					.getAttribute("listProductIdOrdered");
			model.addAttribute("listProductIdOrdered", listProductIdOrdered);
		}
		return "index";
	}
}
