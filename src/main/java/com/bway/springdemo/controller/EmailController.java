package com.bway.springdemo.controller;

import java.io.File;
import java.io.IOException;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EmailController {
	
	@Autowired
    private JavaMailSender javaMailSender;

	@GetMapping("/email")
	public String emailForm() {
		
		return "email";
	}
	
	
	@PostMapping("/email")
	public String sendEmail(HttpServletRequest  request, Model model) throws MessagingException, IOException {
		
		String toEmail = request.getParameter("to");
		String subject = request.getParameter("subject");
		String body	  = request.getParameter("message");
		
//		SimpleMailMessage msg = new SimpleMailMessage();
//        msg.setTo(toEmail);
//        
//        msg.setSubject(subject);
//        msg.setText(body);
//
//        javaMailSender.send(msg);
		sendEmailWithAttachment(toEmail, subject, body);
		
        model.addAttribute("msg","email sent!!");
		
		return "email";
	}
	
	 void sendEmailWithAttachment(String to,String subjet,String body) throws MessagingException, IOException {

	        MimeMessage msg = javaMailSender.createMimeMessage();

	        // true = multipart message
	        MimeMessageHelper helper = new MimeMessageHelper(msg, true);
	        
	        helper.setTo(to);

	        helper.setSubject(subjet);

	        // default = text/plain
	        //helper.setText("Check attachment for image!");

	        // true = text/html
	        helper.setText(body, true);

	        // hard coded a file path
	        FileSystemResource file = new FileSystemResource(new File("F:\\javaWS_8am\\springmvcdemo-1\\src\\main\\resources\\static\\imgs\\101.jpg"));

	        helper.addAttachment("my_photo.png", file);

	        javaMailSender.send(msg);

	    }
	
}
