package com.wma.wmamanager.entity;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

@Entity
@Table(name="classesAssociated")
public class ClassAssociation {
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	Long id;
	
	@ManyToOne
	@MapsId("user_id")
	@JoinColumn(name = "user_id")
	User user;

	@ManyToOne
	@MapsId("class_id")
	@JoinColumn(name = "class_id")
	Class classTaken;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Class getClassTaken() {
		return classTaken;
	}

	public void setClassTaken(Class classTaken) {
		this.classTaken = classTaken;
	}
	
	
}
