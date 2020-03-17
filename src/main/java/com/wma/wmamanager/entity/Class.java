package com.wma.wmamanager.entity;

import java.io.Serializable;
import java.util.List;

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

@SuppressWarnings("serial")
@Entity
@Table(name="Class")
public class Class implements Serializable{
	
	@Id
	@Column
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long class_id;
	
	@Column
	private String class_name;
	
	@Column
	private boolean active;
	
	@ManyToOne(fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "org_id", nullable = false)
	private Organization org;
	
	private String description;
	
	@ManyToMany(mappedBy = "classesAssociated")
	private List<User> students;
	
	// *********** Constructors *********** 
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
	public Long getClass_Id() {
		return class_id;
	}
	public void setClass_Id(Long class_id) {
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
	
	

}
