package com.epam.tanya_adnokulova.java.lesson2.task4;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ShowMenu {
	private Gift gift = new Gift();
	
	public void giftMenu() {
		int option = -1;
		Scanner in = new Scanner(System.in);
	
		do {
			System.out.println("Choose an option:");
			System.out.println("1. Create a gift");
			System.out.println("2. Sort candies by weight");
			System.out.println("3. Find candy");
			System.out.println("4. Show gift");
			
			try{
				option = in.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("Wrong option!");
				option = -1;
			}
		
			switch(option) {
				case 1:
					int type = -1;
					while (type != 0) {
						System.out.println("Choose the type of candy:\n1) Caramel candy\n2) Chocolate candy\n3) Truffle candy");
						try {
							type = in.nextInt();
						} catch (InputMismatchException e) {
							System.out.println("Wrong option!");
							type = -1;
						}
						
						System.out.print("Enter the name of candy: ");
						String name = in.nextLine();
						System.out.print("Enter the color of candy: ");
						String color = in.nextLine();
						System.out.print("Enter the weight of candy: ");
						double weight = in.nextDouble();
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
								System.out.println("Unknown operation");
								break;
						}
					System.out.println("Enter 1 to continue 'gift creation', 0 to return to menu");
					type = in.nextInt();
					if (type == 0) {
						gift.showGift();
						System.out.println("_________________________________");
						System.out.println("Total gift weight: " + gift.getTotalWeight());
					}
					}
					break;
				case 2:
					gift.sortByWeight();
					break;
				case 3:
					System.out.println("Choose a field to search:\n1) Name\n2) Color\n3) Weight range");
					int search = in.nextInt();
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
				default:
					System.out.println("Unknown operation");
					break;
			}
		
			System.out.println("Enter 1 to continue, 0 to exit the application");
			option = in.nextInt();
		}
		while(option != 0);
		in.close();
	}

}
