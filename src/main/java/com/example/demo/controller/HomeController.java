package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	@RequestMapping("/home")
	public String home() {
		System.out.println("WELCOME TO HOME PAGE");
		return "home";  
		//not mentioning .jsp here since we might move to different tech with diff. extension
		//instead define the prefix/suffix in application.properties 
	}
}
