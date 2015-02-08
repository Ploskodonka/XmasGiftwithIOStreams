package com.epam.tanya_adnokulova.java.lesson2.task4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Gift {
	private List<Candy> candyList = new ArrayList<Candy>();
	Scanner in = new Scanner(System.in);
	
	public void addCandy(Candy candy) {
		candyList.add(candy);
	}
	
	/*
	 * Displays the full list of candies in a gift
	 */
	public void showGift() {
		if (candyList.isEmpty()) {
			System.out.println("There's no candies yet!");
			return;
		}
		System.out.println("The gift contains:");
		for (Candy i : candyList) 
			System.out.println(i.toString());
	}
	
	public double getTotalWeight() {
		double totalWeight = 0.0;
		for(Candy i : candyList)
			totalWeight += i.getWeight();
		return totalWeight;
	}
	
	public void sortByWeight() {
		Collections.sort(candyList, new WeightComparator());
	}
	
	/*
	 * Displays the list of candies for a given name
	 */
	public void findByName() {
		String findName;
		System.out.print("Enter name: ");
		try {
			findName = in.nextLine();
		} catch (InputMismatchException e) {
			System.out.println(e);
			return;
		}
		
		System.out.println("The search result for candy name '" + findName + "':");
		for(Candy i : candyList) {
			if (i.getName().equals(findName)) 
				System.out.println(i.getName() + " " + i.getType() + " " + i.getColor() + " " + i.getWeight());
			else
				System.out.println("There's no candies with '" + findName + "' name");
		}
	}
	
	/*
	 * Displays the list of candies for a given color
	 */
	public void findByColor() {
		String findColor;
		System.out.print ("Enter color: ");
		try {
			findColor = in.nextLine();
		} catch (InputMismatchException e) {
			System.out.println(e);
			return;
		}
		
		System.out.println("The search result for candy color '" + findColor + "':");
		for(Candy i : candyList) {
			if (i.getColor().equals(findColor)) 
				System.out.println(i.getColor() + " " + i.getName() + " " + i.getType() + " " + i.getWeight());
			else
				System.out.println("There's no candies with '" + findColor + "' color");
		}
	}
	
	/*
	 * Displays the list of candies for a given range of weight
	 */
	public void findByWeight() {
		double weight;
		double lowerWeight, upperWeight;
		System.out.print("Enter the lower weight: ");
		try {
			lowerWeight = in.nextDouble();
		} catch (InputMismatchException e) {
			System.out.println(e);
			return;
		}
		
		System.out.print("Enter the upper weight: ");
		try {
			upperWeight = in.nextDouble();
		} catch (InputMismatchException e) {
			System.out.println(e);
			return;
		}
		
		System.out.println("The search result for candy weight from " + lowerWeight + " to " + upperWeight + ":");
		for(Candy i : candyList) {
			weight = i.getWeight();
			if (weight >= lowerWeight && weight <= upperWeight) 
				System.out.println(i.getWeight() + " " + i.getName() + " " + i.getColor() + " " + i.getType());
			else
				System.out.println("There's no candies with weight range from " + lowerWeight + " to " + upperWeight);
		}
	}
	

}
