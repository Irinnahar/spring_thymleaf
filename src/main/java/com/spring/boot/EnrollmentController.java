package com.spring.boot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class EnrollmentController {
	@Autowired
	private EnrollmentRepository enrollmentRepo;
	

	@GetMapping("payment")
	public String showPayment(
			@RequestParam(value = "id", required = false) String id,
	        @RequestParam(value = "name", required = false) String name,
	        @RequestParam(value = "duration", required = false) String duration,
	        @RequestParam(value = "fee", required = false) String fee,
	        @RequestParam(value = "date", required = false) String date,
			Model model) {
		model.addAttribute("name", name);
		model.addAttribute("id", id);
		model.addAttribute("duration", duration);
		model.addAttribute("fee", fee);
		model.addAttribute("date", date);

		model.addAttribute("enrollmentForm", new Enrollment());
		return "payment";
	}
	
	@GetMapping("/enrollment")
	public String enrollmentForm(Model model) {
		model.addAttribute("enrollmentForm", new Enrollment());
		return "payment";
	}
	
	  @PostMapping("/enrollment")
	    public String submissionResult(@ModelAttribute("enrollmentForm") Enrollment enrollment) {
	        return "success_enrollment";
	    }
}
