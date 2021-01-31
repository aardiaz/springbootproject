package com.bway.springdemo.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
import com.bway.springdemo.utilities.VerifyRecaptcha;

@Controller
public class LoginController {

	@Autowired
	private UserRepository userRepository;

	@RequestMapping(value = "/userlogin", method = RequestMethod.GET)
	public String loginForm(Model model) {

		model.addAttribute("usermodel", new User());

		return "login";
	}

	@RequestMapping(value = "/userlogin", method = RequestMethod.POST)
	public String userLogin(@ModelAttribute User user, Model model, HttpSession session, HttpServletRequest request)
			throws IOException {

		String gcode = request.getParameter("g-recaptcha-response");
		boolean result = VerifyRecaptcha.verify(gcode);

		if (result) {

			user.setPassword(DigestUtils.md5DigestAsHex(user.getPassword().getBytes()));

			if (userRepository.findByUserNameAndPassword(user.getUserName(), user.getPassword()) != null) {

				session.setAttribute("activeuser", user.getUserName());
				session.setMaxInactiveInterval(120);

				model.addAttribute("un", user.getUserName());

				return "home";
			}else {
				model.addAttribute("msg", "user not found!!");
				model.addAttribute("usermodel", new User());

				return "login";
			}
		}

		model.addAttribute("msg", "you are not human !!");
		model.addAttribute("usermodel", new User());

		return "login";
	}

	@GetMapping("/logout")
	public String logout(HttpSession session) {

		session.invalidate();

		return "login";
	}
}
