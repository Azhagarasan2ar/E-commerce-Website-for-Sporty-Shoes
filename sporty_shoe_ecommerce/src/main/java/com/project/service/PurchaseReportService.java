package com.project.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.entity.PurchaseReport;
import com.project.repository.PurchaseReportRepository;

@Service
public class PurchaseReportService {

	@Autowired
	PurchaseReportRepository purchaserepo;
	
	public List<PurchaseReport> getReport()
	{
		return purchaserepo.findPurchaseReport();
	}
	
	public List<PurchaseReport> getReportByDateByCategory(Date date,String CategoryName)
	{
		return purchaserepo.findPurchaseReportByDateByCategory(date,CategoryName);
	}
}
