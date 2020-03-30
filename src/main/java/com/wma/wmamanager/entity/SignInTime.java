package com.wma.wmamanager.entity;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="sign_in_time")
public class SignInTime {
	
	@Id
	@Column
	@GeneratedValue(strategy=GenerationType.AUTO)
	Long id;
	
	@Column
	int pin;
	
	@Column(name="timestamp")
	LocalDateTime timestamp;
	
	@Column(name="day")
	String day;
	
	@Column(name="time")
	String time;
	
	@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "class_assoc_id", referencedColumnName = "class_assoc_id")
	private ClassAssociation classAssoc;
	
	// ******** Constructors ********
	public SignInTime() {}

	
	// ******** Getters/Setters ********
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}


	public int getPin() {
		return pin;
	}


	public void setPin(int pin) {
		this.pin = pin;
	}


	public ClassAssociation getClassAssoc() {
		return classAssoc;
	}


	public void setClassAssoc(ClassAssociation classAssoc) {
		this.classAssoc = classAssoc;
	}
	
	public String getDay() {
		return day;
	}


	public void setDay(String day) {
//		LocalDateTime focus = this.getTimestamp();
//		DateTimeFormatter form = DateTimeFormatter.ofPattern("MM-dd-yyyy");
//		String formday = focus.format(form);
		this.day = day;
	}


	public String getTime() {
		return time;
	}


	public void setTime(String time) {
//		LocalDateTime focus = this.getTimestamp();
//		DateTimeFormatter form = DateTimeFormatter.ofPattern("HH:mm:ss");
//		String formatTime = focus.format(form);
		this.time = time;
	}


	
	public String getFormatDay() {
		LocalDateTime focus = this.getTimestamp();
		DateTimeFormatter form = DateTimeFormatter.ofPattern("MM-dd-yyyy");
		String day = focus.format(form);
		return day;
	}
	
	public String getFormatTime() {
		LocalDateTime focus = this.getTimestamp();
		DateTimeFormatter form = DateTimeFormatter.ofPattern("HH:mm:ss");
		String time = focus.format(form);
		return time;
	}
	
	
	@Override
	public String toString() {
		return "SignInTime [id=" + id + ", pin=" + pin + ", timestamp=" + timestamp + ", classAssoc=" + classAssoc
				+ "]";
	}
	
	
	
}

