package com.wma.wmamanager.entity.controller;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.wma.wmamanager.entity.Organization;
import com.wma.wmamanager.entity.SignInTime;
import com.wma.wmamanager.entity.User;
import com.wma.wmamanager.repository.AddressRepository;
import com.wma.wmamanager.repository.ClassAssociationRepo;
import com.wma.wmamanager.repository.ClassRepository;
import com.wma.wmamanager.repository.OrgRepository;
import com.wma.wmamanager.repository.TimestampRepository;
import com.wma.wmamanager.repository.UserRepository;
import com.wma.wmamanager.Services.OrgService;
import com.wma.wmamanager.entity.Address;
import com.wma.wmamanager.entity.Class;
import com.wma.wmamanager.entity.ClassAssociation;


@Controller
@SessionAttributes ({"loggedInUser","org","thisclass","stud","orgs"})
public class UserController {
	
	
	// ************** Repositories **************
	@Autowired
	private UserRepository repo;
	
	@Autowired
	private OrgRepository orgRepo;
	
	@Autowired
	private ClassRepository classRepo;
	
	@Autowired
	private ClassAssociationRepo assoRepo;
	
	@Autowired
	private TimestampRepository timeRepo;
	
	@Autowired
	private OrgService orgService;
	
	@Autowired
	private AddressRepository adRepo;
	
	
	// ************** General Mapping **************
	@GetMapping("profile")
	String profile(@SessionAttribute("loggedInUser") User user, @SessionAttribute("org") Organization org,  Model model) {
		List<Organization> stuff = orgRepo.getByUser(user.getId());
		model.addAttribute("orgs", stuff);
		return "profile";
	}
	
	@GetMapping(value= {"/","home"})
	String home() {
		return "home";
	}
	
	
	// ************** Sign Up **************
	@GetMapping("signup")
	String register(Model model) {

		model.addAttribute("user", new User());

		return "signup";
	}
	
	
	@PostMapping("signup")
	String register(@ModelAttribute User user,
						RedirectAttributes redirect){

		Optional<User> newuser = repo.getByEmail(user.getEmail());
		if(newuser.isPresent()) {
			
			redirect.addFlashAttribute("error", "User already exists.");
			return "redirect:/signup";
		}
		user.setRole("Admin");
		System.out.println(user.getFirstName()+"**********"+user.getEmail());


		repo.save(user);
		redirect.addFlashAttribute("msg", "Registration Successful!");
		
		return "redirect:/login";
		
	}
	
	
	
	// ************** Login/Logout **************
	@GetMapping("login")
	String login(){
		return "login";
	}
	
	@PostMapping("login")
		String login(@RequestParam String email, @RequestParam String password, Model model) {
			
		Optional<User> usr = repo.login(email,password);
			if(usr.isPresent()) {
				model.addAttribute("loggedInUser", usr.get());
				model.addAttribute("orgs", usr.get().getOrganizations());

				return "profile";
			}
			model.addAttribute("error", "Invalid credentials");
			return "login";
			
		}
	
	@GetMapping("logout")
	String logout(SessionStatus status, Model model) {
		status.setComplete();
		model.addAttribute("loggedInUser", "");
		model.addAttribute("msg", "Farewell!");
		return "login";
	}
	
	
	
	// ************** Organization Registration **************
	
	
	
	@GetMapping("new-organization")
	String newOrg(Model model) {
		model.addAttribute("org", new Organization());
		return "new-organization";
	}
	
	@PostMapping("registerNewOrg")
	String orgRegistration(@ModelAttribute Organization org, 
							@SessionAttribute("loggedInUser") User user,
							RedirectAttributes redirect) {
		
		
		Optional<Organization> newOrg = orgRepo.getByOrgName(org.getOrgName());
		if(newOrg.isPresent()) {
			redirect.addFlashAttribute("error", "User already exists.");
			return "redirect:/new-organization";
		}
		org.setUser(user);
		orgRepo.save(org);
		redirect.addFlashAttribute("msg", "Organization Registration Successful!");
		return "redirect:/profile";
	}
	
	// ************** Organization Management **************
	
	@GetMapping("organization-settings")
	String orgSettings(Model model, @SessionAttribute("org") Organization o) {
		model.addAttribute("updatedOrg", new Organization());
		model.addAttribute("orgAddress", new Address());
		model.addAttribute("classesOffered", classRepo.getByOrg(o.getId()));
		return "organization-settings";
	}
	
	
	@PostMapping("updateOrgDetails")
	String editOrg(@ModelAttribute("updatedOrg") Organization o, @SessionAttribute("org") Organization main, RedirectAttributes redirect, Model model) {
		
		Optional<Organization> latest = orgRepo.findById(main.getId());
			if(latest.isPresent()){
				latest.get().setOrgName(o.getOrgName());
				latest.get().setDescription(o.getDescription());
				orgRepo.save(latest.get());
				model.addAttribute("org", latest.get());
				redirect.addAttribute("id",latest.get().getId());
			}
		return "redirect:/organization-settings";
	}
	
	@PostMapping("editOrgAddress")
	String editOrgAddress(@ModelAttribute("orgAddress") Address ad, @SessionAttribute("org")Organization main, RedirectAttributes redirect, Model model) {
		Organization focus = orgRepo.findById(main.getId()).get();
		ad.setOrg(focus);
		adRepo.save(ad);
		model.addAttribute("org", focus);
		redirect.addAttribute("id",focus.getId());
		return "redirect:/organization-settings";
	}
	
	
	@GetMapping("organization")
	String organization(@RequestParam long id, Model model) {
		model.addAttribute("org", orgRepo.findById(id).get());
		model.addAttribute("classes", classRepo.getByOrg(orgRepo.findById(id).get().getId()));
		return "organization";
	}
	
	@GetMapping("thisOrg")
	String thisOrg(@SessionAttribute("org") Organization org, Model model) {
		List<Class> stuff=  classRepo.getByOrg(org.getId());
		model.addAttribute("classes", stuff);
		return "organization";
	}
	
	
	@GetMapping("add-class")
	String addClass(Model model) {
		model.addAttribute("newClass", new Class());
		return "add-class";
	}
	
	@GetMapping("view-students")
	String viewStudents(Model model, @SessionAttribute("org") Organization org){
		model.addAttribute("students", orgService.getOrgUsers(org.getId()));
		return "view-students";
		
	}
	
	@GetMapping("add-student")
	String addStudent(@SessionAttribute("org") Organization org, Model model) {
		model.addAttribute("student", new User());
		model.addAttribute("classes", classRepo.getByOrg(org.getId()));
		return"add-student";
	}
	
	@PostMapping("addstudent")
	String addThisStudent(@ModelAttribute User student, @SessionAttribute("org") Organization org, RedirectAttributes redirect) {
		Optional<User> newStudent = repo.getByEmail(student.getEmail());
		
		if(newStudent.isPresent()) {
			
			redirect.addFlashAttribute("error", "Student already exists.");
			return "redirect:/signup";
		}
		student.setRole("Student");
		repo.save(student);
		ClassAssociation i = new ClassAssociation();
		redirect.addFlashAttribute("msg", "Student Registration Successful!");		
		return "organization";
	}
	
	@GetMapping("delete-org")
	String deleteOrg() {
		return "delete-org";
	}

	@PostMapping("deleteOrgConfirm")
	String deleteOrgConfirm(Model model, @SessionAttribute("org") Organization s, RedirectAttributes redirect) {
		System.out.println("****************" + s.getOrgName() + s.getId() + "****************" );
		orgService.deleteOrg(s);
		model.addAttribute("org", "");
		redirect.addFlashAttribute("msg", "Organization successfully deleted.");
		return "redirect:/profile";
	}
	
	// ************** Classes Management **************
	
	@PostMapping("create-class")
	String createClass(@ModelAttribute Class newClass, @SessionAttribute("org") Organization org,
							RedirectAttributes redirect) {
		
		Optional<Class> newCl = classRepo.getByName(newClass.getClass_name(),org.getId());
		if(newCl.isPresent()) {
			
			redirect.addFlashAttribute("error", "Class already exists.");
			return "redirect:/organization";
		}
		newClass.setOrg(org);
		newClass.setActive(true);
		classRepo.save(newClass);
		redirect.addFlashAttribute("msg", "Class registration Successful!");	
		
		return "redirect:/thisOrg";
	}
	
	@GetMapping("class-page")
	String classPage(@RequestParam Long id, @SessionAttribute("org") Organization org, Model model) {
		model.addAttribute("thisclass", classRepo.findById(id).get());
		
		return "class-page";
	}
	
	@GetMapping("view-classStudents")
	String studentsInClass(@RequestParam Long id, Model model, @SessionAttribute("org") Organization o) {
		model.addAttribute("students", orgService.getOrgUsers(o.getId()));
		return "class-page";
	}
	
	// ************** Sign-In Management **************
	
	@GetMapping("class-signin")
	String classSignIn(Model model, @RequestParam Long id){
		model.addAttribute("thisclass", classRepo.findById(id).get());
		return "class-signin";
	}
	
	@GetMapping("org-signin")
	String orgSignIn(Model model){
		model.addAttribute("student", new SignInTime());
		return "org-signin";
		
	}
	
	@PostMapping("orgSignIn")
	String orgSignForm(Model model,@ModelAttribute("student") SignInTime time, RedirectAttributes redirect) {
		
		Optional<User> focus = repo.pinSignIn(time.getPin());
		if(!focus.isPresent()) {
			model.addAttribute("msg","Invalid PIN");
			return "redirect:/org-signin";
		}
		
		List<ClassAssociation> focusClasses = assoRepo.findByStudId(focus.get().getId());
		List<ClassAssociation> availableClasses = focusClasses
				.stream().filter(association -> {
					return (LocalDate.now().getDayOfWeek().equals(DayOfWeek.MONDAY) && association.getClassTaken().getMonday()) ||
							(LocalDate.now().getDayOfWeek().equals(DayOfWeek.TUESDAY) && association.getClassTaken().getTuesday()) ||
							(LocalDate.now().getDayOfWeek().equals(DayOfWeek.WEDNESDAY) && association.getClassTaken().getWednesday()) ||
							(LocalDate.now().getDayOfWeek().equals(DayOfWeek.THURSDAY) && association.getClassTaken().getThursday()) ||
							(LocalDate.now().getDayOfWeek().equals(DayOfWeek.FRIDAY) && association.getClassTaken().getFriday()) ||
							(LocalDate.now().getDayOfWeek().equals(DayOfWeek.SATURDAY) && association.getClassTaken().getSaturday()) ||
							(LocalDate.now().getDayOfWeek().equals(DayOfWeek.WEDNESDAY) && association.getClassTaken().getSunday());
				}).collect(Collectors.toList());
		
		if(availableClasses.size()==0) {
			redirect.addFlashAttribute("error", "Sorry, " + focus.get().getFirstName() + ". You have no available classes today.");
			return "redirect:/org-signin";
		}
		
		if(availableClasses.size()>1) {
			return "org-signin-multi";
		}
		
		
		
		for(ClassAssociation i:availableClasses) {
			LocalDateTime current = LocalDateTime.now();
			time.setTimestamp(LocalDateTime.now());
			time.setClassAssoc(i);
			DateTimeFormatter dayform = DateTimeFormatter.ofPattern("MM-dd-yyyy");
			DateTimeFormatter timeform = DateTimeFormatter.ofPattern("HH:mm:ss");
			String day = current.format(dayform);
			String currenttime = current.format(timeform);
			time.setTime(currenttime);
			time.setDay(day);
			timeRepo.save(time);
		}
		redirect.addFlashAttribute("msg", "You have successfully signed in!");
		return "redirect:/org-signin";
		
	}
	
	
	
	// ************** Student Profile Management **************

	@GetMapping("addToClass")
	String addToClass(Model model, @SessionAttribute("org") Organization o){
		model.addAttribute("classes", classRepo.getByOrg(o.getId()));
		model.addAttribute("student", new User());
		return "addToClass";
	}
	
	@PostMapping("confirmAddClass")
	String confirmAddclass(@ModelAttribute("student") User s, @SessionAttribute("stud")User main, RedirectAttributes redirect, Model model) {
		Optional<User> latest = repo.findById(main.getId());
		if(latest.isPresent()){
			List<Class> newClasses = s.getClassesAssociated();
			List<Class> currentClasses = main.getClassesAssociated();
			
			for(Class i:newClasses) {
				if(currentClasses.contains(i)) {
					redirect.addFlashAttribute("error", main.getFirstName() + " is already attending this class.");
					return "redirect:/addToClass?id=" + String.valueOf(main.getId());
				}
			}
			
			main.getClassesAssociated().addAll(newClasses);
			repo.save(main);
			
		}
		
		
		return "redirect:/student-file?id=" + String.valueOf(main.getId());
	}
	
	@GetMapping("student-file")
	String studentFile(@RequestParam Long id, Model model) {
		model.addAttribute("stud", repo.findById(id).get());
		model.addAttribute("times", timeRepo.getSignInTimes(repo.findById(id).get().getPin()));
		model.addAttribute("student", new User());
		model.addAttribute("address", new Address());
		return "student-file";
	}
	
	@PostMapping("editStud")
	String editStud(@ModelAttribute("student") User user, @SessionAttribute("stud")User main, RedirectAttributes redirect, Model model) {
		
		Optional<User> latest = repo.findById(main.getId());
			if(latest.isPresent()){
				latest.get().setFirstName(user.getFirstName());
				latest.get().setLastName(user.getLastName());
				latest.get().setPin(user.getPin());
				latest.get().setEmail(user.getEmail());
				repo.save(latest.get());
				model.addAttribute("stud", latest.get());
				redirect.addAttribute("id",latest.get().getId());
			}
		return "redirect:/student-file";
	}
	
	@PostMapping("editStudAddress")
	String editStudAddress(@ModelAttribute("address") Address ad, @SessionAttribute("stud")User main, RedirectAttributes redirect, Model model) {
		User focus = repo.findById(main.getId()).get();
		ad.setUser(focus);
		adRepo.save(ad);
		model.addAttribute("stud", focus);
		redirect.addAttribute("id",focus.getId());
		return "redirect:/student-file";
	}
	
	@GetMapping("deleteStudent")
	String deleteStudent(Model model, @SessionAttribute("stud") User s, RedirectAttributes redirect) {
		repo.delete(s);
		redirect.addFlashAttribute("msg", "Student successfully deleted.");
		return "redirect:/profile";
	}
	
	// ************** Profile Management **************
	
	@GetMapping("profile-settings")
	String profileSettings(Model model) {
		model.addAttribute("address", new Address());
		return "profile-settings";
	}
	
	@PostMapping("orgEdit")
	String orgEdit(RedirectAttributes redirect) {
		return "redirect:/profile-settings";
	}
	
	// ************** Test Pages **************
	@GetMapping("testprofile")
	String testProfile(){
		return "testprofile";
	}
}

	
	
	


