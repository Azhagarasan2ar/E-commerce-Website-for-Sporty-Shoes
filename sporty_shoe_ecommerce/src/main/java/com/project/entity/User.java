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
@Table(name="user_details")
public class User {

	@Id
	@GeneratedValue
	@Column(name="user_id")
	private int userId;
	
	@Column(name="user_name")
	private String userName;
	
	@Column(name="password")
	private String userPassword;
	
	@Column(name="city")
	private String userCity;
	
	@Column(name="email_address")
	private String userEmailAddress;
	
	@OneToMany(mappedBy="user",cascade=CascadeType.ALL)
	private List<PurchaseReport> purchasereport;

	public int getUserId() {
		return userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getUserCity() {
		return userCity;
	}

	public void setUserCity(String userCity) {
		this.userCity = userCity;
	}

	public String getUserEmailAddress() {
		return userEmailAddress;
	}

	public void setUserEmailAddress(String userEmailAddress) {
		this.userEmailAddress = userEmailAddress;
	}

	public List<PurchaseReport> getPurchasereport() {
		return purchasereport;
	}

	public void setPurchasereport(List<PurchaseReport> purchasereport) {
		this.purchasereport = purchasereport;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", userPassword=" + userPassword + ", userCity="
				+ userCity + ", userEmailAddress=" + userEmailAddress + ", purchasereport=" + purchasereport + "]";
	}
	
	
}
