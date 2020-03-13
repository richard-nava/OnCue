package com.wma.wmamanager.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Membership {
	
	@Id
	@Column
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Column
	private String name;
	private String daysAvailable;
	private String maxDays;
	
	
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDaysAvailable() {
		return daysAvailable;
	}
	public void setDaysAvailable(String daysAvailable) {
		this.daysAvailable = daysAvailable;
	}
	public String getMaxDays() {
		return maxDays;
	}
	public void setMaxDays(String maxDays) {
		this.maxDays = maxDays;
	}

	
	


}
