package com.epam.tanya_adnokulova.java.lesson6.task1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


public class IO {
	public static void objectOutput(Gift gift) throws IOException, FileNotFoundException {
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		try {
			File myFile = new File("X-masGift.txt");
			if (!myFile.exists()) 
				myFile.createNewFile();
			fos = new FileOutputStream(myFile);
			oos = new ObjectOutputStream(fos);
			oos.writeObject(gift);
			System.out.println("Object has been succesfully added to file");
		} finally {
			oos.flush();
			oos.close();
		}
	}
	
	public static Gift objectInput() throws IOException, ClassNotFoundException, FileNotFoundException {
		  FileInputStream fis = null;
		  ObjectInputStream ois = null;
		  try {
			  fis = new FileInputStream("X-masGift.txt");
			  ois = new ObjectInputStream(fis);
			  System.out.println("Text file has been succesfully read into object");
			  return (Gift) ois.readObject();
		  } finally {
			  ois.close();
		  }
	}
}
