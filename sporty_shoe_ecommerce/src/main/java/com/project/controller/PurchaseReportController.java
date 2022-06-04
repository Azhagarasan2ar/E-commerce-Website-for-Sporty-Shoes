package com.project.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.entity.PurchaseReport;
import com.project.service.PurchaseReportService;

@Controller
public class PurchaseReportController {

	@Autowired
	PurchaseReportService purchaseservice;
	
	@GetMapping("/index/purchasereport")
	public String listReport(Model model)
	{
		
		List<PurchaseReport> report=purchaseservice.getReport();
		model.addAttribute("report", report);
		
		return "purchaseReport";
	}
	
	@GetMapping("/index/purchasereport/dateandcategory")
	public String getByDateByCategory(@RequestParam(name="date",required=false) String date,@RequestParam(name="category",required=false) String categoryName,Model model)
	{
		if(categoryName!=null&&date!=null)
		{
			SimpleDateFormat formatedate=new SimpleDateFormat("yyyy-MM-dd");
			try {
				Date mydate=formatedate.parse(date);
			
				List<PurchaseReport> report=purchaseservice.getReportByDateByCategory(mydate, categoryName);
				if(report.isEmpty())
				{
					model.addAttribute("error", "no record");
				}
				model.addAttribute("report", report);
				return "purchaseReport";
				
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		
		return "redirect:";
	}

	
	
}

