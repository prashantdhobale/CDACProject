package com.project.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="repair_shop")
public class RepairShop {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private int id;
	@Column(name="shop_name")
	private String shopName;
	@Column(name="shop_email")
	private String shopEmail;
	@Column
	private String contact;
	@Column
	private String city;
	@Column
	private String address;
	@Column
	private String details;
	@Column
	private int rating;
	

	
	public RepairShop() {
		
	}

	
	

	public RepairShop(int id, String shopName, String shopEmail, String contact, String city, String address,
		String details, int rating) {
	super();
	this.id = id;
	this.shopName = shopName;
	this.shopEmail = shopEmail;
	this.contact = contact;
	this.city = city;
	this.address = address;
	this.details = details;
	this.rating = rating;
}




	public RepairShop(int id, String shopName, String shopEmail, String contact, String city, String address,
			String details, int rating, List<JobCard> jobCards) {
		super();
		this.id = id;
		this.shopName = shopName;
		this.shopEmail = shopEmail;
		this.contact = contact;
		this.city = city;
		this.address = address;
		this.details = details;
		this.rating = rating;
		
	}





	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getShopName() {
		return shopName;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	public String getShopEmail() {
		return shopEmail;
	}

	public void setShopEmail(String shopEmail) {
		this.shopEmail = shopEmail;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	@Override
	public String toString() {
		return "RepairShop [id=" + id + ", shopName=" + shopName + ", shopEmail=" + shopEmail + ", contact=" + contact
				+ ", city=" + city + ", address=" + address + ", details=" + details + ", rating=" + rating + "]";
	}
		
	
}


