package com.bway.springdemo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.bway.springdemo.model.Student;
import com.bway.springdemo.repository.StudentRepository;

@RestController
public class StudentRestAPI {
	
	@Autowired
	private StudentRepository  stdRepo;
	
	@GetMapping("/student/list")
	public List<Student> getAllStud() {
		
		return stdRepo.findAll();
	}
	
	@GetMapping("/student/{id}")
	 public Optional<Student> getOneStudent(@PathVariable int id) {
		 
		return stdRepo.findById(id);
	 }
	
	@PostMapping("/student/add")
	public String addStud(@RequestBody Student s) {
		
		stdRepo.save(s);
		return "success";
	}
	
	@GetMapping("/student/delete/{id}")
	public String deletStud(@PathVariable int id) {
		stdRepo.deleteById(id);
		return "delete success";
	}
	
	
	@GetMapping("/student/j2o")
	public String jsonToObject() {
		
		RestTemplate  retmp = new RestTemplate();
		Student s = retmp.getForObject("http://localhost:8080/student/5", Student.class);
		
		return "FName = "+s.getFname() +"  City = "+s.getAddress().getCity();
	}
	
	@GetMapping("/student/json/list")
	public String jsonListToObjectList() {
		RestTemplate  tmp = new RestTemplate();
		Student[] slist = tmp.getForObject("http://localhost:8080/student/list", Student[].class);
		
		return "FName = "+slist[0].getFname() +"  City = "+slist[0].getAddress().getCity();
		
	}
	
}
