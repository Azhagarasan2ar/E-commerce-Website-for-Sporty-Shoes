package com.project.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;



@Entity
@Table(name="purchase_report")
public class PurchaseReport {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="purchase_Id")
	private int PurchaseReportId;
	
	@Column(name="purchase_number")
	private int PurchaseReportNumber;
	
	@Column(name="customer_name")
	private String purchaseReportName;
	
	@Column(name="product_purchased")
	private String purchaseReportProduct;
	
	@Temporal(TemporalType.DATE)
	@Column(name="purchased_on")
	private Date purchaseReportDate;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="user_id")
	private User user;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="product_id")
	private Product product;
	

	
	
	public int getPurchaseReportId() {
		return PurchaseReportId;
	}

	public void setPurchaseReportId(int purchaseReportId) {
		PurchaseReportId = purchaseReportId;
	}

	public int getPurchaseReportNumber() {
		return PurchaseReportNumber;
	}

	public void setPurchaseReportNumber(int purchaseReportNumber) {
		PurchaseReportNumber = purchaseReportNumber;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public String getPurchaseReportName() {
		return purchaseReportName;
	}

	public void setPurchaseReportName(String purchaseReportName) {
		this.purchaseReportName = purchaseReportName;
	}

	public String getPurchaseReportProduct() {
		return purchaseReportProduct;
	}

	public void setPurchaseReportProduct(String purchaseReportProduct) {
		this.purchaseReportProduct = purchaseReportProduct;
	}

	public Date getPurchaseReportDate() {
		return purchaseReportDate;
	}

	public void setPurchaseReportDate(Date purchaseReportDate) {
		this.purchaseReportDate = purchaseReportDate;
	}
	
	

	@Override
	public String toString() {
		return "PurchaseReport [PurchaseReportId=" + PurchaseReportId + ", PurchaseReportNumber=" + PurchaseReportNumber
				+ ", purchaseReportName=" + purchaseReportName + ", purchaseReportProduct=" + purchaseReportProduct
				+ ", purchaseReportDate=" + purchaseReportDate + ", user=" + user + ", product=" + product + "]";
	}
	
	
	

}
