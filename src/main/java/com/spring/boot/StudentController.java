package com.spring.boot;

import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

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
	
	@GetMapping("profile/{id}") 
	public String showProfileId(@PathVariable("id") Long id,Model model) {
		Optional<Student> s = studentRepo.findById(id);
		model.addAttribute("student", s);
		return "profile";
	}
	
	@GetMapping("editprofile/{id}") 
	public String showEditProfile(@PathVariable("id") Long id,Model model) {
		Optional<Student> s = studentRepo.findById(id);
		model.addAttribute("student", s);
		return "edit_profile";
	}
	

	@PostMapping("submit_registration_form")
	public String processRegister(Student student) {
		studentRepo.save(student);
		return "register_success";
	}


	@PostMapping("success-login")
	public ModelAndView processLogin(Student student) {
		ModelAndView mV =  new ModelAndView("profile");
		Student s = studentRepo.findByEmail(student.getEmail());

		mV.addObject("student", s);
		String username = s.getEmail();
		String password = s.getPassword();
		
		if(Objects.equals(username, student.getEmail()) && (Objects.equals(password, student.getPassword()))) { 
			  return mV;
		} else {
			return null;
		}
	}

	
	@PostMapping("success_edit_details")
	public String processEditDetails(Student student) {
		studentRepo.save(student);
		return "profile";
	}
}
