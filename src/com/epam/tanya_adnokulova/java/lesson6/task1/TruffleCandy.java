package com.epam.tanya_adnokulova.java.lesson6.task1;

public class TruffleCandy extends Candy {
	private static final long serialVersionUID = 1L;

	public TruffleCandy(String name, String color, double weight) {
		super(name, color, weight);
		setType("Truffle candy");
	}
}
