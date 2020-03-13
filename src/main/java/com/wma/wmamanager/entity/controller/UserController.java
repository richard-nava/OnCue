package com.wma.wmamanager.entity.controller;

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
import com.wma.wmamanager.repository.OrgRepository;
import com.wma.wmamanager.repository.UserRepository;

@Controller
@SessionAttributes ({"loggedInUser"})
public class UserController {
	
	@Autowired
	UserRepository repo;
	
	@Autowired
	OrgRepository orgRepo;
	
	
	// ************** General Mapping **************
	@GetMapping("profile")
	String profile(@SessionAttribute("loggedInUser") User user, Model model) {
		model.addAttribute("orgs",repo.findById(user.getId()).get().getOrganizations());
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
		return "organization";
	}
	
}

	
	
	


