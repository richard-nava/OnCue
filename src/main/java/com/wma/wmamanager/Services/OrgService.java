package com.wma.wmamanager.Services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wma.wmamanager.entity.User;
import com.wma.wmamanager.entity.Class;
import com.wma.wmamanager.entity.ClassAssociation;
import com.wma.wmamanager.entity.SignInTime;
import com.wma.wmamanager.repository.ClassAssociationRepo;
import com.wma.wmamanager.repository.ClassRepository;
import com.wma.wmamanager.repository.OrgRepository;
import com.wma.wmamanager.repository.TimestampRepository;
import com.wma.wmamanager.repository.UserRepository;

@Service
public class OrgService {
	
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
	
	// get all students in the organization
	public List<User> getOrgUsers(Long orgId){
		List<User> students = new ArrayList<>();
		List<Class> orgClasses = classRepo.getByOrg(orgId);
		orgClasses.forEach(orgClass -> {
			List<ClassAssociation> associations = assoRepo.findAllByClassTaken(orgClass);
			associations.stream()
				.filter(association -> !students.contains(association.getUser()))
				.forEach(item->students.add(item.getUser()));
		});
		return students;
	}
	
	
	public List<SignInTime> getTimes(Long studId){
		List<SignInTime> times = new ArrayList<>();
		List<ClassAssociation> matches = assoRepo.findByStudId(studId);
		
		
		return times;
	}
	

}
