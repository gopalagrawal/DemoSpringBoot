package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;



// Define Alien to be a spring component
@Component
@Scope("prototype")  //Alien object created on demand when prototype scope. 
public class Alien {
	private int aid;
	private String aname;
	private String tech;
	
	@Autowired  //will auto inject Laptop dependency into Alien
	@Qualifier("lap1") //Give me Laptop of type "lap1"
	private Laptop laptop;
	
	public Alien() {
		super();
		System.out.println("Alien created");
	}
	
	public Laptop getLaptop() { return laptop; }
	public void setLaptop(int id, String brand) { 
		laptop.setLid(id);
		laptop.setBrand(brand);
	}

	public int getAid() { return aid; }
	public void setAid(int aid) { this.aid = aid; }
	
	public String getAname() { return aname; }
	public void setAname(String aname) { this.aname = aname; }
	
	public String getTech() { return tech; }
	public void setTech(String tech) { this.tech = tech; }

	public void show() {
		System.out.println("Alien:Show");
		laptop.compile();
	}

	@Override
	public String toString() {
		return "Alien [aid=" + aid + ", aname=" + aname + ", tech=" + tech + "]";
	}
	
	
}
