package com.example.demo.dao;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.Alien;

//Create interface that works with Alien DB and has a integer Primary Key. 
public interface AlienRepo extends CrudRepository<Alien, Integer>
{
	
}