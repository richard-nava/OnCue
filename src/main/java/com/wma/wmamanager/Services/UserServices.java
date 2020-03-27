package com.wma.wmamanager.Services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.wma.wmamanager.entity.SignInTime;
import com.wma.wmamanager.entity.User;
import com.wma.wmamanager.repository.ClassAssociationRepo;
import com.wma.wmamanager.repository.ClassRepository;
import com.wma.wmamanager.repository.OrgRepository;
import com.wma.wmamanager.repository.TimestampRepository;
import com.wma.wmamanager.repository.UserRepository;

public class UserServices {
	
	@Autowired
	ClassAssociationRepo assoRepo;
	
	@Autowired
	OrgRepository orgRepo;
	
	@Autowired
	ClassRepository classRepo;
	
	@Autowired
	UserRepository userRepo;
	
	@Autowired
	TimestampRepository timeRepo;
	
	public SignInTime signIn(int pin, RedirectAttributes redirect){
		SignInTime clockIn = new SignInTime();
		Optional<User> focus = userRepo.pinSignIn(pin);
		if(focus.isPresent()) {
			
			redirect.addFlashAttribute("error", "User already exists.");
			
		}
		
		return clockIn;
	}
	

}
