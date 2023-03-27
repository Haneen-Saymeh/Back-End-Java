package tutorial9;

import java.util.Scanner;

public class application {

	public static void main(String[] args) {
		Scanner input= new Scanner(System.in);
		System.out.println("Enter your command!");
		String text=input.nextLine();
		
		switch(text) {
		case "start":
			System.out.println("Start the machine!");
			break;
			
		case "stop":
			System.out.println("Stop the machine");
			break;
			
		default:
			System.out.println("Command is not recognized");
		}

	}

}
