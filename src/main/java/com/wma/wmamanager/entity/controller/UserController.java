package com.wma.wmamanager.entity.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
import com.wma.wmamanager.entity.User;
import com.wma.wmamanager.repository.ClassRepository;
import com.wma.wmamanager.repository.OrgRepository;
import com.wma.wmamanager.repository.UserRepository;
import com.wma.wmamanager.entity.Class;


@Controller
@SessionAttributes ({"loggedInUser","org","thisclass"})
public class UserController {
	
	
	// ************** Repositories **************
	@Autowired
	UserRepository repo;
	
	@Autowired
	OrgRepository orgRepo;
	
	@Autowired
	ClassRepository classRepo;
	
	
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
				model.addAttribute("msg", "Welcome to your profile, ");
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
	@GetMapping("organization")
	String organization(@RequestParam Long id, Model model) {
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
	String viewStudents(){
		return "view-students";
		
	}
	
	@GetMapping("add-student")
	String addStudent(@SessionAttribute("org") Organization org, Model model) {
		model.addAttribute("student", new User());
		model.addAttribute("classes", classRepo.getByOrg(org.getId()));
		return"add-student";
	}
	
	@PostMapping("addstudent")
	String addThisStudent(@ModelAttribute User student, @SessionAttribute("org") Organization org, @SessionAttribute("thisclass") Class aClass, RedirectAttributes redirect) {
		Optional<User> newStudent = repo.getByEmail(student.getEmail());
		
		if(newStudent.isPresent()) {
			
			redirect.addFlashAttribute("error", "Student already exists.");
			return "redirect:/signup";
		}
		student.setRole("Student");
		repo.save(student);
		redirect.addFlashAttribute("msg", "Student Registration Successful!");		
		return"organization";
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
	String studentsInClass(@RequestParam Long id, Model model) {
		return "class-page";
	}
	
	
}

	
	
	


