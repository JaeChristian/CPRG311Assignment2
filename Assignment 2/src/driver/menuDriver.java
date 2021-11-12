package driver;

import java.io.FileNotFoundException;
import java.util.Scanner;

import problemdomain.XMLParser;

public class menuDriver {
	private Scanner input = new Scanner(System.in);
	private boolean looping = true;
	
	public menuDriver() throws FileNotFoundException {
		boolean valid;
		String str;
		while(looping) {
			valid = false;
			System.out.println("-------------------------------------");
			System.out.println("Welcome to Group 1's XML Parser!");
			System.out.println("1 Parse your own file\n2 Parse a sample file");
			while(!valid) {
				str = input.nextLine();
				switch(str) {
				case "1": 
					valid = true;
					customFile();
					break;
				case "2": 
					valid = true;
					sampleFile();
					break;
				default: 
					valid = false;
					System.out.println("Please input a valid option!");
				}
			}
		}
	}
	
	/**
	 * Method ran if the user wants to parse their own file (JAR ONLY)
	 * @throws FileNotFoundException
	 * 			if file not found.
	 */
	public void customFile() throws FileNotFoundException {
		String file = "";
		String choice = "";
		boolean located = false;
		while(!located) {
			System.out.println("Please input the name of your XML file");
			file = input.nextLine();
			while(!file.contains(".xml")) {
				System.out.println("Please input an XMl file");
				file = input.nextLine();
			}
			try {
				XMLParser parser = new XMLParser(file);
				System.out.println("\nTry again?");
				input.nextLine();
				located = true;
			}
			catch (Exception ex){
				System.out.println("\nError - Cannot locate file, try again.\n");
				
				located = false;
			}
		}
	}
	
	/**
	 * Method ran if user wants to parse a sample built in file. 
	 * @throws FileNotFoundException
	 * 				if file not found.
	 */
	public void sampleFile() throws FileNotFoundException {
		String file = "";
		int choice = 0;
		boolean located = false;
		boolean valid = false;
		while(!located) {
			System.out.println("Please input which sample file you want 1-2");
			while(!valid) {
				file = input.nextLine();
				switch(file) {
				case "1":
					choice = 1;
					valid = true;
					break;
				case "2":
					choice = 2;
					valid = true;
					break;
				default: 
					System.out.println("Please pick a file between 1-2");
					valid = false;
				}
			}
			try {
				if(choice == 1) {
					XMLParser parser = new XMLParser("/sample1.xml", true);
				}
				else {
					XMLParser parser = new XMLParser("/sample2.xml", true);
				}
				System.out.println("\nTry again?");
				input.nextLine();
				located = true;
			}
			catch (Exception ex){
				System.out.println("\nError - Cannot locate file, try again.\n");
				
				located = false;
			}
		}
	}
}
