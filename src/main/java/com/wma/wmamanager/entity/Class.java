package com.wma.wmamanager.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@SuppressWarnings("serial")
@Entity
@Table(name="Class")
public class Class implements Serializable{
	
	@Id
	@Column
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long class_id;
	
	@Column
	private String class_name;
	
	@Column
	private boolean active;
	
	@ManyToOne(fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "org_id", nullable = false)
	private Organization org;
	
	private String description;
	
	@ManyToMany(mappedBy = "classesAssociated", cascade = CascadeType.REMOVE)
	//@OnDelete(action = OnDeleteAction.CASCADE)
	private List<User> students;
	
	
	@Column
	private Boolean monday;
	@Column
	private Boolean tuesday;
	@Column
	private Boolean wednesday;
	@Column
	private Boolean thursday;
	@Column
	private Boolean friday;
	@Column
	private Boolean saturday;
	@Column
	private Boolean sunday;
	
	// *********** Construcors *********** 
	public Class() {}

	// *********** Getters/Setters *********** 
	public Long getClass_id() {
		return class_id;
	}
	public void setClass_id(Long class_id) {
		this.class_id = class_id;
	}
	public String getClass_name() {
		return class_name;
	}
	public void setClass_name(String class_name) {
		this.class_name = class_name;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public Organization getOrg() {
		return org;
	}
	public void setOrg(Organization org) {
		this.org = org;
	}
	public long getClass_Id() {
		return class_id;
	}
	public void setClass_Id(long class_id) {
		this.class_id = class_id;
	}
	public String getName() {
		return class_name;
	}
	public void setName(String class_name) {
		this.class_name = class_name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public List<User> getStudents() {
		return students;
	}
	public void setStudents(List<User> students) {
		this.students = students;
	}

	public Boolean getMonday() {
		return monday;
	}

	public void setMonday(Boolean monday) {
		this.monday = monday;
	}

	public Boolean getTuesday() {
		return tuesday;
	}

	public void setTuesday(Boolean tuesday) {
		this.tuesday = tuesday;
	}

	public Boolean getWednesday() {
		return wednesday;
	}

	public void setWednesday(Boolean wednesday) {
		this.wednesday = wednesday;
	}

	public Boolean getThursday() {
		return thursday;
	}

	public void setThursday(Boolean thursday) {
		this.thursday = thursday;
	}

	public Boolean getFriday() {
		return friday;
	}

	public void setFriday(Boolean friday) {
		this.friday = friday;
	}

	public Boolean getSaturday() {
		return saturday;
	}

	public void setSaturday(Boolean saturday) {
		this.saturday = saturday;
	}

	public Boolean getSunday() {
		return sunday;
	}

	public void setSunday(Boolean sunday) {
		this.sunday = sunday;
	}

	
}
