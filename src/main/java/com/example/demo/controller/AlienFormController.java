package com.example.demo.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.dao.AlienRepo;
import com.example.demo.model.Alien;

@Controller
public class AlienFormController {

	@Autowired
	AlienRepo repo;  //Defines Crud interface. 
	
	//Show Form --------------------------
	@RequestMapping("/")  
	public String home() {
		return "addAlienForm";
	}
	
	// Process add alien -----------------
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
	
	// Process get alien ------------------
	@RequestMapping("/getAlien") 
	public ModelAndView getAlien(@RequestParam("aid") int id) { 
		
		Alien alien = (Alien) repo.findById(id).orElse(null);
		
		List<Alien> alienlist = (alien == null) ? new ArrayList<>() : Arrays.asList(alien); 
		ModelAndView mv = new ModelAndView("showAliens");
		mv.addObject("alienlist", alienlist );
		
		return mv; 
	}
}
