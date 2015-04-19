package com.epam.tanya_adnokulova.java.lesson6.task1;

import java.io.Serializable;


public abstract class Candy implements Serializable {

	private static final long serialVersionUID = 1L;
	private String candyName; 
	private String candyType;
	private String candyColor;
	private double candyWeight;
	
	public Candy() {
		this.candyName = "Default name";
		this.candyColor = "Default color";
		this.candyWeight = 10;
	}
	
	public Candy (String name, String color, double weight) {
		if (name.isEmpty() || color.isEmpty())
			System.out.println("You've entered wrong data!");
		
		if (weight <= 0) 
			throw new IllegalArgumentException("Can't create " + weight + "gramms of " + name);
		
		this.candyName = name;
		this.candyColor = color;
		this.candyWeight = weight;
		
	}
	
	public String getName() {
		return candyName;
	}
	
	public String getType() {
		return candyType;
	}
	
	public String getColor() {
		return candyColor;
	}
	
	public double getWeight() {
		return candyWeight;
	}
	
	public void setName(String name) {
		this.candyName = name;
	}
	
	public void setType(String type) {
		this.candyType = type;
	}
	
	public void setColor(String color) {
		this.candyColor = color;
	}
	
	public void setWeight(double weight) {
		this.candyWeight = weight;
	}
	
	public String toString() {
		return (candyColor + " " + candyType + " '" + candyName + "' " + candyWeight);
	}
}
