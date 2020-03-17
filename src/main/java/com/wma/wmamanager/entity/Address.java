package com.wma.wmamanager.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Address {
	
	@Id
	@Column
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long address_id; 
	
	@Column
	private String street;
	
	@Column
	private String state;
	
	@Column
	private String city;
	
	@Column
	private String zip;

	
	
	// ************ Getters/Setters ************
	public Long getAddress_Id() {
		return address_id;
	}

	public void setAddress_Id(Long address_id) {
		this.address_id = address_id;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}
	
	
	
}
