package com.spring.boot;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class StudentController {

	@Autowired
	private StudentRepository studentRepo;

	@GetMapping("")
	public String viewHomepage() {
		return "index";
	}
	
	@GetMapping("register")
	public String showRegistrationForm(Model model) {
		model.addAttribute("student", new Student());
		return "signup";
	}

	@GetMapping("login")
	public String showLogin(Model model) {
		model.addAttribute("student", new Student());
		return "login";
	}
	
	@GetMapping("profile")
	public String showProfile(Model model) {
		model.addAttribute("student", new Student());
		return "profile";
	}
	

	@PostMapping("submit_registration_form")
	public String processRegister(Student student) {
//		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
//	    String encodedPassword = passwordEncoder.encode(student.getPassword());
//	    student.setPassword(encodedPassword);
	     
		studentRepo.save(student);
		return "register_success";
	}

	@PostMapping("success-login")
	public String processLogin(Student student) {
		Student s = studentRepo.findByEmail(student.getEmail());
		String username = s.getEmail();
		String password = s.getPassword();
		
		if(Objects.equals(username, student.getEmail()) && (Objects.equals(password, student.getPassword()))) { 
			  return "home";
		} else {
			return null;
		}
	}

	@PostMapping("logout")
	public String processLogout() {
		return "login";
	}
}
