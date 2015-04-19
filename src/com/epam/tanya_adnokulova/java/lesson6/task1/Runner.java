package com.epam.tanya_adnokulova.java.lesson6.task1;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Runner {

	public static void main(String[] args) throws ClassNotFoundException, FileNotFoundException, IOException {
		ShowMenu run = new ShowMenu();
		run.giftMenu();
	}
}
