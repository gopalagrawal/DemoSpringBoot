package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Alien;


//JpaRepository extends CrudRepository ... uses json data for ops. 
public interface AlienJPARepo extends JpaRepository<Alien, Integer> {
	List<Alien>findByTech(String tech);  
}
