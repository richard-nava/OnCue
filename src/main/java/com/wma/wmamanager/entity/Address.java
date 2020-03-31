package com.wma.wmamanager.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="address")
public class Address {
	
	@Id
	@Column(name="address_id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long address_id; 
	
	@OneToOne
	@JoinColumn(name="user_id", referencedColumnName = "user_id")
	private User user;
	
	@OneToOne
	@JoinColumn(name="org_id", referencedColumnName = "id")
	private Organization org;
	
	@Column
	private String street;
	
	@Column
	private String state;
	
	@Column
	private String city;
	
	@Column
	private String zip;

	
	
	// ************ Getters/Setters ************
	

	public User getUser() {
		return user;
	}

	public long getAddress_id() {
		return address_id;
	}

	public void setAddress_id(long address_id) {
		this.address_id = address_id;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Organization getOrg() {
		return org;
	}

	public void setOrg(Organization org) {
		this.org = org;
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
