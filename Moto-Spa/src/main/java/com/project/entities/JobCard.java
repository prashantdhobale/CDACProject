package com.project.entities;

import java.sql.Time;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="jobcard")
public class JobCard {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private int id;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
	@Column(name="schedule_date")
	private Date date;
	@Column(name="schedule_time")
	private Time time;
	@Column(name="user_id")
	private int userId;
	@Column(name="vehicle_id")
	private int vehicleId;
	@Column(name="service_id")
	private int serviceId;
	@Column(name="shop_id")
	private int shopId;
	
	public JobCard() {
		// TODO Auto-generated constructor stub
	}

public JobCard(int id, Date date, Time time, int userId, int vehicleId, int serviceId, int shopId) {
	super();
	this.id = id;
	this.date = date;
	this.time = time;
	this.userId = userId;
	this.vehicleId = vehicleId;
	this.serviceId = serviceId;
	this.shopId = shopId;
}

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public Date getDate() {
	return date;
}

public void setDate(Date date) {
	this.date = date;
}

public Time getTime() {
	return time;
}

public void setTime(Time time) {
	this.time = time;
}

public int getUserId() {
	return userId;
}

public void setUserId(int userId) {
	this.userId = userId;
}

public int getVehicleId() {
	return vehicleId;
}

public void setVehicleId(int vehicleId) {
	this.vehicleId = vehicleId;
}

public int getServiceId() {
	return serviceId;
}

public void setServiceId(int serviceId) {
	this.serviceId = serviceId;
}

public int getShopId() {
	return shopId;
}

public void setShopId(int shopId) {
	this.shopId = shopId;
}

@Override
public String toString() {
	return "JobCard [id=" + id + ", date=" + date + ", time=" + time + ", userId=" + userId + ", vehicleId=" + vehicleId
			+ ", serviceId=" + serviceId + ", shopId=" + shopId + "]";
}
	
	

	
}


