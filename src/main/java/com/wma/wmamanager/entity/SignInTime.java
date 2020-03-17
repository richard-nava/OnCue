package com.wma.wmamanager.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class SignInTime {
	
	@Id
	Long id;

	
	LocalDateTime timestamp;
}
