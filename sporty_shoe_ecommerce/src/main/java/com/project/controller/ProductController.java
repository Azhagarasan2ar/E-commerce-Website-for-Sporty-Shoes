package com.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.entity.Product;
import com.project.service.AdminService;
import com.project.service.ProductService;

@Controller
public class ProductController {
	
	@Autowired
	ProductService productservice;
	
	@Autowired
	AdminService adminservice;
	
	@GetMapping("/index")
	public String listProductCategory(Model model)
	{
		List<String> categories=productservice.getCategories();
		for(String category:categories)
		{
			List<Product> products=productservice.getProductsByCategory(category);
			model.addAttribute(category, products);
		
		}
	
		return "index";
	}
	
	@PostMapping("/login")
	public String listProductCategory(@RequestParam(name="name") String name,@RequestParam(name="password") String password,Model model)
	{
		if(adminservice.toCheck(name, password))
		{	
			return "redirect:index";
		}
	
		model.addAttribute("error", "Incorrect Password");
		return "adminlogin";
		
	}
	
	
	@GetMapping("/index/addProduct")
	public String getaddProductHtml() 
	{
		return "addProduct";
		
	}
	
	@PostMapping("/index/addProduct")
	public String saveProduct(@RequestParam(name="product_name",required=false) String productName,
								@RequestParam(name="product_price",required=false) String productPrice,
								@RequestParam(name="product_category",required=false) String productCategory,
								Model model)
	{
		if(!productName.isEmpty()&&!productPrice.isEmpty()&&!productCategory.isEmpty())
		{
			productservice.saveProduct(productName, productPrice, productCategory);
		}
		return "addProduct";
		
	}
	
	@GetMapping("/index/deleteProduct")
	public String getdeleteProductHtml(Model model)
	{
		List<Product> products=productservice.listProduct();
		model.addAttribute("products", products);
		return "deleteProduct";
		
	}
	
	@PostMapping("/index/deleteProduct")
	public String deleteProduct(@RequestParam(name="product_id",required=false,defaultValue="0") int id,  Model model)
	{
		if(id!=0)
		{
			productservice.delete(id);
		}
		List<Product> products=productservice.listProduct();
		model.addAttribute("products", products);
		return "deleteProduct";
		
	}
}

