
public class Account {
	long number;
	String name;
	float balance;
	
	public Account() {
		
	}
	
	public Account(long number, String name, float balance) {
		this.number=number;
		this.name=name;
		this.balance=balance;
	}
	
	public void deposite(float amount) {
		this.balance=this.balance+amount;
		System.out.println("Amount deposited: "+ amount + "|" +"Total Balance: "+ this.balance);
		
	}
	
	public void withdraw(float amount) {
		if (this.balance>=amount) {
			this.balance=this.balance-amount;
			System.out.println("Withdrawn amount: "+ amount+ "Remaining Balance: "+ this.balance);
		}
		
		else {
			System.out.println("Balance is not suffecient!");
		}
	}
	
	public void getBalance() {
		System.out.println("Account number: "+ this.number + " | " + "Accout Name: "+this.name+
				" | "+ "Account balance: "+ this.balance);
	}

}
