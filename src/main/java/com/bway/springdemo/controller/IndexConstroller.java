package com.bway.springdemo.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bway.springdemo.model.User;

@Controller // request processing
public class IndexConstroller {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index(Model model) {

		model.addAttribute("usermodel", new User());

		return "login";
	}
	
	@GetMapping("/restapi")
	public String getRestForm() {
		
		return "restApi";
	}

}
