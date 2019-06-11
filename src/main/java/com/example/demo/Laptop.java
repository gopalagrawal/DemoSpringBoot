package com.example.demo;

import org.springframework.stereotype.Component;

@Component("lap1")  //lap1 = name of this component. default = "laptop" (small case). 
public class Laptop {
	private int lid; //laptop id
	private String brand;
	
	
	//---------------
	public Laptop() {
		super();
		System.out.println("Laptop Created");
	}

	public int getLid() {
		return lid;
	}
	public void setLid(int lid) {
		this.lid = lid;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	} 
	
	@Override
	public String toString() {
		return "Laptop [lid=" + lid + ", brand=" + brand + "]";
	}
	
	public void compile() {
		System.out.println(toString() + " Compiling ... ");
	}
	
}
