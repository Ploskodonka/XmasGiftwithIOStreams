package com.epam.tanya_adnokulova.java.lesson6.task1;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ShowMenu {
	private Gift gift = new Gift();
	
	public void giftMenu() throws ClassNotFoundException, FileNotFoundException, IOException {
		int option = -1;
		Scanner in = new Scanner(System.in);
	
		do {
			System.out.println("Choose an option:");
			System.out.println("1. Create gift");
			System.out.println("2. Sort candies by weight");
			System.out.println("3. Find candy");
			System.out.println("4. Show gift");
			System.out.println("5. Save to 'X-masGift.txt'");
			System.out.println("6. Load from 'X-masGift.txt'");
			
			try {
				option = in.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("Wrong option!");
				in.next();
				option = -1;
			}
		
			switch(option) {
				case 1:
					int type = -1;
					do {
						System.out.println("Choose the type of candy:\n1. Caramel candy\n2. Chocolate candy\n3. Truffle candy");
						try {
							type = in.nextInt();
						} catch (InputMismatchException e) {
							System.out.println(e);
							in.next();
							break;
						}
						
						System.out.print("Enter the name of candy: ");
						String name = in.next();
						System.out.print("Enter the color of candy: ");
						String color = in.next();
						System.out.print("Enter the weight of candy: ");
						double weight = in.nextDouble();
						if (weight <= 0) {
							System.out.println("Weight cannot be negative!");
							type = -1;
							break;
						}
						
						switch(type) {
							case 1:
								gift.addCandy(new CaramelCandy(name, color, weight));
								break;
							case 2: 
								gift.addCandy(new ChocolateCandy(name, color, weight));
								break;
							case 3:
								gift.addCandy(new TruffleCandy(name, color, weight));
								break;
							default: 
								System.out.println("Unknown type of candy");
								break;
						}
					System.out.println("Enter 1 to continue 'gift creation', 0 to return to menu");
					
					try {
						type = in.nextInt();
					} catch (InputMismatchException e) {
						System.out.println(e);
						in.next();
					}
					
					if (type == 0) {
						gift.showGift();
						System.out.println("_________________________________");
						System.out.println("Total gift weight: " + gift.getTotalWeight());
					}
					} while (type != 0);
					break;
				case 2:
					gift.sortByWeight();
					break;
				case 3:
					int search = 0;
					System.out.println("Choose a field to search:\n1. Name\n2. Color\n3. Weight range");
					try {
						search = in.nextInt();
					} catch (InputMismatchException e) {
						System.out.println(e);
						in.next();
					}
					
					switch (search) {
						case 1:
							gift.findByName();
							break;
						case 2:
							gift.findByColor();
							break;
						case 3:
							gift.findByWeight();
							break;
						default:
							System.out.println("Unknown operation");
							break;
					}
					break;
				case 4:
					gift.showGift();
					break;
				case 5:
					IO.objectOutput(gift);
					break;
				case 6:
					gift = IO.objectInput();
					break;
				default:
					System.out.println("Unknown operation");
					break;
			}
		
			System.out.println("Enter 1 to continue, 0 to exit the application");
			try {
				option = in.nextInt();
			} catch (InputMismatchException e) {
				System.out.println(e);
				in.next();
			}
		}
		while(option != 0);
		in.close();
	}

}
