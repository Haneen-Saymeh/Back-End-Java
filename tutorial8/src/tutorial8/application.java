package tutorial8;

import java.util.Scanner;

public class application {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
//		System.out.println("Enter a number");
//		int value = input.nextInt();
//		
//		while (value != 5) {
//			System.out.println("Enter a number again!");
//			value=input.nextInt();
//		}
		int value=0;
		do {
			System.out.println("Enter a number!");
			value= input.nextInt();
		}
		while (value !=5);
			
		System.out.println("You got 5!!!");
		
		

	}

}

