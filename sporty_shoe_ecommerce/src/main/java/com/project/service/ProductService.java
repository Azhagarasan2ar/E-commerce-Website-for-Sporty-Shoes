package com.project.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.entity.Product;
import com.project.repository.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	ProductRepository productrepo;
	
	
	public List<Product> getProductsByCategory(String categary)
	{
		List<Product> products=new ArrayList<Product>();
		
		productrepo.findByproductCategory(categary).forEach(product -> products.add(product));
		return products;
	}

	public List<String> getCategories()
	{
		List<String> categoryList=new ArrayList<String>();
		
		
		for(Object obj:productrepo.findCategory())
		{
			String category=(String)obj;
			categoryList.add(category);
		}
		return categoryList;
	}
	
	public void saveProduct(String productName,String productPrice,String productCategory)
	{
		Product product=new Product();
		product.setProductName(productName);
		product.setProductPrice(Double.parseDouble(productPrice));
		product.setProductCategory(productCategory);
		
		productrepo.save(product);
	}
	
	public void delete(int id)
	{
		productrepo.deleteById(id);
	}
	
	public List<Product> listProduct()
	{
		List<Product> productsList=new ArrayList<Product>();
		productrepo.findAll().forEach(product -> productsList.add(product));
		return productsList;
	}
}
	

