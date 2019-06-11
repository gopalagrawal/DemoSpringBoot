package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class DemoSpringBootApplication {

	public static void main(String[] args) {
		System.out.println("Welcome to Spring Boot .... ");
		
		// init spring container. 
		ConfigurableApplicationContext ctx = SpringApplication.run(DemoSpringBootApplication.class, args);
		
		// "Dependency Injection" of something that behaves as an 'alien' from spring container 
		// IF:   Alien annotation was only @Component (not prototype). 
		// THEN: This bean was created only once in spring container. 
		// ELSE: New Alien object created each time on demand.
		Alien a = ctx.getBean(Alien.class);
		Alien b = ctx.getBean(Alien.class);	
		
		// a and b refer to same bean object. 
		a.setAid(1); a.setAname("Gopal"); a.setTech("Java");
		System.out.println( "a => " + a.getAid() + " : " + a.getAname() + " : " + a.getTech() );		
		System.out.println( "b => " + b.getAid() + " : " + b.getAname() + " : " + b.getTech() );
		
	}

}
