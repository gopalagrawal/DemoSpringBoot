package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.dao.AlienJPARepo; //JpaRepository ... JSON based. 
import com.example.demo.model.Alien;

@Controller  //@RestController => @ResponseBody decorator applied to each method.  
public class AlienFormController {

	@Autowired
	AlienJPARepo repo;  //Defines Crud interface. 
	
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
	
	// Process get alien -----------------
	@RequestMapping("/getAlien") 
	public ModelAndView getAlien(int aid) { 
		Alien alien = repo.findById(aid).orElse(null);
		
		List<Alien> alien_list = new ArrayList<Alien>();
		if (alien != null) alien_list.add(alien); //else it's an empty list

		ModelAndView mv = new ModelAndView("showAliens");
		mv.addObject("alienlist", alien_list);
		return mv; 
	}
	
	
	//======== REST API FUNCTIONS BELOW ========================
	// jackson-core lib converts the alien objects to json response. 
	
	//For below REST pt, we place restriction to only supports xml response, no other format allowed. 
	@RequestMapping(path="/aliens", produces={"application/xml"})   
	@ResponseBody
	public List<Alien> getAllAliens() {
		return repo.findAll();  
	}
	
	@RequestMapping("/alien/{aid}") //By default, a RequestMapping => GetMapping. 
	@ResponseBody
	public Optional<Alien> getSpecificAlien(@PathVariable("aid") int aid) {
		return repo.findById(aid);
	}
	
	@RequestMapping("/aliens/tech/{tech}") 
	@ResponseBody
	public List<Alien> getAliensByTech(@PathVariable("tech") String tech) {
		return repo.findByTech(tech);
	}	
	
	@PostMapping(path="/alien")  //can also restrict w/... consumes={"application/json"} or xml etc. 
	@ResponseBody
	//@RequestBody in params -> accept raw json data in Post request w/ content: application/json
	public Alien addAlienUsingRest(@RequestBody Alien alien) {
		System.out.println(alien.toString());
		repo.save(alien);
		return alien;
	}
	
	@DeleteMapping("/alien/{aid}")
	@ResponseBody
	public String deleteAlien(@PathVariable int aid) {
		Alien a = repo.getOne(aid);
		repo.delete(a);
		return "Deleted";
	}
	
	
	@PutMapping( path="/alien", consumes="application/json") //for save/update
	@ResponseBody
	public Alien updateAlien(@RequestBody Alien newAlien) {
		System.out.println("upDateAlien: " + newAlien.toString());
		repo.save(newAlien);
		return newAlien;
	}
}
