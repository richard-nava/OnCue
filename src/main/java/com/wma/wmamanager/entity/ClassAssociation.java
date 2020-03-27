package com.wma.wmamanager.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="classesAssociated")
public class ClassAssociation {
	
	@Id
	@Column(name="class_assoc_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	Long id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@MapsId("user_id")
	@JoinColumn(name = "user_id")
	User user;

	@ManyToOne(fetch = FetchType.LAZY)
	@MapsId("class_id")
	@JoinColumn(name = "class_id")
	Class classTaken;
	
	@OneToMany
	private List<SignInTime> signIn;


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

	
	public List<SignInTime> getSignIn() {
		return signIn;
	}

	public void setSignIn(List<SignInTime> signIn) {
		this.signIn = signIn;
	}

	@Override
	public String toString() {
		return "ClassAssociation [id=" + id + ", user=" + user + ", classTaken=" + classTaken + "]";
	}
	
	
	
}
