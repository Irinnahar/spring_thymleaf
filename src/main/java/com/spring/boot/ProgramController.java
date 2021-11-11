
package com.spring.boot;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProgramController {

	@Autowired
	private ProgramRepository programRepo;

	@GetMapping("homepage")
	public String listUsers(Model model) {
		model.addAttribute("program", new Program());

		List<Program> programs = new ArrayList<Program>();
		programRepo.findAll().forEach(program -> programs.add(program));

		model.addAttribute("programList", programs);
		System.out.print(programs);
		return "home";
	}

	@GetMapping("program")
	public String showProgramForm(Model model) {
		model.addAttribute("program", new Program());
		return "program_add";
	}

	@PostMapping("program-added")
	public String processProgramAdd(Program program) {
		programRepo.save(program);
		return "home";
	}
}
