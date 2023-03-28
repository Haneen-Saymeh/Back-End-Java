import java.util.Scanner;

public class Bank {

	public static void main(String[] args) {
		Account acc= null;
		Scanner input=new Scanner(System.in);
		
		while(true) {
			System.out.println("1. Create Account");
			System.out.println("2. Deposite");
			System.out.println("3. Withdraw");
			System.out.println("4. Details");
			System.out.println("5. Exit");
			System.out.print("Choose an option");
			
			int option=input.nextInt();
			switch(option) {
			case 1:
				if (acc==null) {
					System.out.print("Enter account number");
					int number=input.nextInt();
					input.nextLine();
					System.out.print("Enter account name");
					String name=input.nextLine();
					System.out.print("Enter initial deposite");
					float balance=input.nextFloat();
					acc=new Account(number, name, balance);	
					System.out.println("Account created");
				}
				
				else {
					System.out.print("Account already exist");
				}
				break;
				
			case 2:
				if (acc!=null) {
					System.out.print("Enter amount of money you want to deposite");
					float amount = input.nextFloat();
					acc.deposite(amount);
				}
				
				else {
					System.out.print("Create account first");
				}
				
				break;
				
			case 3:
				if (acc!=null) {
					System.out.print("Enter amount of money you want to withdraw");
					float amount = input.nextFloat();
					acc.withdraw(amount);
				}
				
				else {
					System.out.print("Create account first");
				}
				break;
				
			case 4:
				if (acc!=null) {
					acc.getBalance();
				}
				
				else {
					System.out.print("Create account first");
				}
				
				break;
				
			case 5:
				System.out.print("Thanks for using our bank, bye!");
				System.exit(0);
				break;
				
			default:
				System.out.print("Invalid option!");
			}
			System.out.print("--------------------------");
		}

	}

}
