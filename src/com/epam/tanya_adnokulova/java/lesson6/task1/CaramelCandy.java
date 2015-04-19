package com.epam.tanya_adnokulova.java.lesson6.task1;

public class CaramelCandy extends Candy {
	private static final long serialVersionUID = 1L;

	public CaramelCandy(String name, String color, double weight) {
		super(name, color, weight);
		setType("Caramel candy");
	}
}
