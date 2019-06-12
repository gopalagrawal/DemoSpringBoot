package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.dao.AlienRepo;
import com.example.demo.model.Alien;

@Controller
public class AlienFormController {

	@Autowired
	AlienRepo repo;  //Defines Crud interface. 
	
	//Show Form
	@RequestMapping("/")  
	public String home() {
		return "addAlienForm";
	}
	
	// Process Form
	@RequestMapping("/addAlien") 
	public ModelAndView addAlien(Alien alien) { //data comes from form
		repo.save(alien); 	// 'repo' interface was defined to work with <Alien DB, Integer PK>
							// Spring Boot will create the necessary objects to do the CRUD ops. 
		
		List<Alien> alien_list = (List<Alien>) repo.findAll();
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("alienlist", alien_list);
		mv.setViewName("showAliens");
		return mv; 
	}
}
