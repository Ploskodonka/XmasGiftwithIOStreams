package com.epam.tanya_adnokulova.java.lesson2.task4;

import java.util.Comparator;

public class WeightComparator implements Comparator<Candy> {
	public int compare(Candy candy1, Candy candy2) {
		return (int) (candy1.getWeight() - candy2.getWeight());
	}
}
