package com.example.demo.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
	
	@Value("${message.default.welcome}")
	private String welcomemsg;
	
	
	//public String home(HttpServletRequest req, HttpServletResponse res) {
	//
	// Let's get rid of req, res objects. Automapped by springboot from req parameter. 
	// If req.param is different than name used here (or having multiple params),  
	//		map with ... ( @RequestParam("name") String myName, ...... )
	// else if single param with same name: 
	//		map with ... ( String name ..... 
	//
	@RequestMapping("home") //even "/home" will work. 
	public ModelAndView  home(String name, HttpSession s) {		
		System.out.println(welcomemsg + " " + name);
		
		//s.setAttribute("welcomemsg", welcomemsg);
		//s.setAttribute("name", name);
		//return "home";  
		
		//Let's use ModelAndView Instead of session. 
		ModelAndView mv = new ModelAndView();
		mv.addObject("welcomemsg", welcomemsg);
		mv.addObject("name", name);
		mv.setViewName("home");
		return mv;
		
	}
}
