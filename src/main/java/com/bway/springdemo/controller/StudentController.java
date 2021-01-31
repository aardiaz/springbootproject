package com.bway.springdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.bway.springdemo.model.Student;
import com.bway.springdemo.repository.StudentRepository;

@Controller
public class StudentController {
	
	@Autowired
	private StudentRepository  studentRepo;
	
	@GetMapping("/student")
	public String getStudentForm(Model model) {
		
		model.addAttribute("studentmodel",new Student());
		
		return "studentForm";
	}
	
	
	@PostMapping("/student")
	public String saveStudent(@ModelAttribute Student student) {
		
		studentRepo.save(student);
		
		return "redirect:/student";
	}
	
	@GetMapping("/list")
	public String getAllStudents(Model model) {
		
		model.addAttribute("slist",studentRepo.findAll());
		
		return "list";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteStudent(@PathVariable int id) {
		
		studentRepo.deleteById(id);
		
		return "redirect:/list";
	}
	
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable int   id, Model model) {
		model.addAttribute("studentmodel", studentRepo.getOne(id));
		
		return "editForm";
	}
	
	@PostMapping("/update")
	public String update(@ModelAttribute Student student) {
		
		studentRepo.save(student);
		
		return  "redirect:/list";
	}

}
