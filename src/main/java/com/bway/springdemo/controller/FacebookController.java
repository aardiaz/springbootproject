package com.bway.springdemo.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class FacebookController {

	@RequestMapping(value = "/facebook", method = RequestMethod.GET)
	public String fbLogin() {

		return "redirect:https://www.facebook.com/dialog/oauth?client_id=236002198023225&redirect_uri=http://localhost:8080/authorize/facebook&response_type=code&scope=email";
	}

	@RequestMapping(value = "/authorize/facebook", method = RequestMethod.GET)
	public String saveFbUser(String code, Model model, HttpServletRequest request) {

		return "redirect:/list";
	}

}
