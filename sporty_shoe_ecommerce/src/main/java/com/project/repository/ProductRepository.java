package com.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.project.entity.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product,Integer>{

	
	List<Product> findByproductCategory(@Param("productCategory") String product);
	
	@Query("SELECT DISTINCT p.productCategory from Product p")
	List<Object> findCategory();
	
	
}