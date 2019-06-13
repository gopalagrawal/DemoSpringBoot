package com.example.demo.dao;
// THE SPRING JPA MAGIC //

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.Alien;

//Create interface that works with Alien DB and has a integer Primary Key. 
public interface AlienRepo extends CrudRepository<Alien, Integer>
{
	//Define our custom methods beyond those defined in CrudRepo
	
	List<Alien>findByTech(String tech);  
		// Custom Methods should start with "findby" or "getby" 
		// appended by Captialized property name. 
		// Then Operation like GreaterThan or LessThan if required
	
	List<Alien>findByAidGreaterThan(int id);
	
	@Query("from Alien where tech=?1 order by aname")  //complex query example
	List<Alien>findByTechSorted(String tech); 
}

/*
Spring boot will automaticaly generate class based on above interface to implement
our custom methods or CrudRepo methods. abstract
*/





