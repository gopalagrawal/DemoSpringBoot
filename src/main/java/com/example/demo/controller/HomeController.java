package com.example.demo.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	@Value("${message.default.welcome}")
	private String welcomemsg;
	
	@RequestMapping("/home")
	public String home(HttpServletRequest req, HttpServletResponse res) {
		String name = req.getParameter("name");
		
		System.out.println(welcomemsg + " " + name);
		
		//now we can send data to user either in req object, session, cookies etc. 
		HttpSession s = req.getSession();
		s.setAttribute("welcomemsg", welcomemsg);
		s.setAttribute("name", name);
		
		return "home";  
	}
}
