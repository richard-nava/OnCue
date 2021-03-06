package com.wma.wmamanager.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@SuppressWarnings("serial")
@Entity
@Table(name="User")
public class User implements Serializable {
	
	@Id
	@Column(name="user_id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	@OneToMany(mappedBy = "user", fetch = FetchType.EAGER,
            cascade = CascadeType.ALL)	
	private List<Organization> organizations;
	
	@ManyToMany
	@LazyCollection(LazyCollectionOption.FALSE)
	@JoinTable(name="classesAssociated",joinColumns=@JoinColumn(name="user_id"),
	inverseJoinColumns = @JoinColumn(name="class_id"))
	private List<Class> classesAssociated;
	
	@OneToOne(mappedBy="user")
	private Address address;
	
	@Column(name="firstName")
	private String firstName;
	
	@Column(name="lastName")
	private String lastName;
	
	@Column(name="username")
	private String username;
	
	@Column(name="pin")
	private int pin;
	
	@Column(name="email", unique=true)
	private String email;
	
	@Column(name="phone")
	private String phone;
	
	@Column(name="password")
	private String password;
	
	@Column(name="image")
	private String image;
	
	@Column(name="role")
	private String role;
	
	
	
	// ********** Constructors **********
	
	public User() {}
	
	
	// ********** Getters/Setters **********
	
	public long getId() {
		return id;
	}
	
	
	public String getRole() {
		return role;
	}


	public void setRole(String role) {
		this.role = role;
	}


	public List<Organization> getOrganizations() {
		return organizations;
	}


	public void setOrganizations(List<Organization> organizations) {
		this.organizations = organizations;
	}


	public int getPin() {
		return pin;
	}
	public void setPin(int pin) {
		this.pin = pin;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}


	public List<Class> getClassesAssociated() {
		return classesAssociated;
	}


	public void setClassesAssociated(List<Class> classesAssociated) {
		this.classesAssociated = classesAssociated;
	}
	

	public Address getAddress() {
		return address;
	}


	public void setAddress(Address address) {
		this.address = address;
	}


	@Override
	public String toString() {
		return firstName + " " + lastName + " - Pin: " + pin + " - Email: " + email;
	}

	

}
