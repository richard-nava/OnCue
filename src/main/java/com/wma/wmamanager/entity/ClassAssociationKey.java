package com.wma.wmamanager.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Table(name="tracker")
@Embeddable
public class ClassAssociationKey implements Serializable {

	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	Long id;
	
	@Column(name="user_id")
	Long userId;
	
	@Column(name="class_id")
	Long classId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getClassId() {
		return classId;
	}

	public void setClassId(Long classId) {
		this.classId = classId;
	}
	
	

}
