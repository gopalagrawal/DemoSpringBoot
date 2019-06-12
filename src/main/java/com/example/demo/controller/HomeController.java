package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.Alien;

@Controller
public class HomeController {
	
	@Value("${message.default.welcome}")
	private String welcomemsg;
	
	@RequestMapping("home") //even "/home" will work. 
	public ModelAndView  home(Alien alien) {		
		System.out.println(welcomemsg + " " + alien.getAname() );

		ModelAndView mv = new ModelAndView();
		mv.addObject("welcomemsg", welcomemsg);
		mv.addObject("alien", alien);
		mv.setViewName("home");
		return mv;
		
	}
}
