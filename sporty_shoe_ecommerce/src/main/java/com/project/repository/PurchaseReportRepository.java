package com.project.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.project.entity.PurchaseReport;

@Repository
public interface PurchaseReportRepository extends CrudRepository<PurchaseReport,Integer> {
	
	@Query("SELECT purchase FROM PurchaseReport purchase INNER JOIN User user ON purchase.user.userId=user.userId INNER JOIN Product product ON purchase.product.productId=product.productId")
	List<PurchaseReport> findPurchaseReport();
	
	@Query("SELECT purchase FROM PurchaseReport purchase INNER JOIN User user ON purchase.user.userId=user.userId INNER JOIN Product product ON purchase.product.productId=product.productId"
			+ " WHERE purchase.purchaseReportDate= :date AND product.productCategory = :categoryName")	
	List<PurchaseReport> findPurchaseReportByDateByCategory(@Param("date") Date date,@Param("categoryName") String categoryName);
	

}
