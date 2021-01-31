package com.bway.springdemo.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class GalleryController {

	@GetMapping("/gallery")
	public String gallery(Model model, HttpSession session) {

		if (session.getAttribute("activeuser") == null) {

			return "login";
		}

		File dir = new File("F:\\javaWS_8am\\springmvcdemo-1\\src\\main\\resources\\static\\imgs");
		String[] imgNameList = dir.list();
		model.addAttribute("imgList", imgNameList);

		return "galleryForm";
	}

	@GetMapping("/upload")
	public String uploadForm(HttpSession session) {

		if (session.getAttribute("activeuser") == null) {

			return "login";
		}

		return "uploadForm";
	}

	@PostMapping("/upload")
	public String uploadImage(@RequestParam("file") MultipartFile file, Model model,HttpSession session) {

		if (session.getAttribute("activeuser") == null) {

			return "login";
		}

		if (!file.isEmpty()) {
			try {
				FileOutputStream fout = new FileOutputStream(
						"F:\\javaWS_8am\\springmvcdemo-1\\src\\main\\resources\\static\\imgs\\"
								+ file.getOriginalFilename());
				fout.write(file.getBytes());
				fout.close();
				model.addAttribute("msg", "file upload success");
				return "uploadForm";
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		model.addAttribute("msg", "failed!!");
		return "uploadForm";
	}

}
