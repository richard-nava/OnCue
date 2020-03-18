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

@Entity
public class ClassAssociation {
	
	//@EmbeddedId
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	Long id;
	
	@ManyToOne
	@MapsId("student_id")
	@JoinColumn(name = "student_id")
	User user;

	@ManyToOne
	@MapsId("class_id")
	@JoinColumn(name = "class_id")
	Class classTaken;
	
	
	
}
