package tutorial7;

import java.util.Scanner;

public class application {

	public static void main(String[] args) {
//		Scanner input= new Scanner(System.in);
		Scanner numberIn= new Scanner(System.in);
		System.out.println("Enter a line of text plzzz!");
//		String line= input.nextLine();
		int value = numberIn.nextInt();
		
//		System.out.println("You entered: "+ line);
		System.out.println("You entered: "+ value);

	}

}
