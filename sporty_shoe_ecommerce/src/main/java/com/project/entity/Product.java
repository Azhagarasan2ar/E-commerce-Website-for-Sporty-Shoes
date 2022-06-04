package com.project.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity
@Table(name="product_details")
public class Product {
	
	@Id
	@GeneratedValue
	@Column(name="id")
	private int productId;
	
	@Column(name="product_name")
	private String productName;
	
	@Column(name="price")
	private double productPrice;
	
	@Column(name="category")
	private String productCategory;

	@OneToMany(mappedBy="product",cascade=CascadeType.ALL)
	private List<PurchaseReport> purchasereport;


	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}

	public String getProductCategory() {
		return productCategory;
	}

	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}

	public List<PurchaseReport> getPurchasereport() {
		return purchasereport;
	}

	public void setPurchasereport(List<PurchaseReport> purchasereport) {
		this.purchasereport = purchasereport;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", productPrice=" + productPrice
				+ ", productCategory=" + productCategory + ", purchasereport=" + purchasereport + "]";
	}
	
	
}

