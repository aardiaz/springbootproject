package com.bway.springdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bway.springdemo.model.User;
import com.bway.springdemo.repository.UserRepository;

@Controller
public class SignupController {
	
	@Autowired  //UserService us = new UserServiceImpl();
	private UserRepository  userRepository;
	
	
	@RequestMapping(value="/userSignup", method=RequestMethod.GET)
	public String getSignuForm(Model model) {
		
		model.addAttribute("usermodel", new User());
		return "signup";
	}
	
	@RequestMapping(value = "/userSignup", method=RequestMethod.POST)
	public String saveUser(@ModelAttribute User user,Model model) {
		
		
		
		user.setPassword(DigestUtils.md5DigestAsHex(user.getPassword().getBytes()));
		userRepository.save(user);
		
		model.addAttribute("usermodel", new User());
		return "login";
	}
 
	@GetMapping("/rest")
	public String getRestForm() {
		
		return "rest";
	}
	
	
}
