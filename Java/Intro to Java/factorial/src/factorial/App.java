package factorial;

public class App {

	public static void main(String[] args) {
		int value =5;
		System.out.println(factorial(3));

	}
	
	public static int factorial(int value) {
		if (value ==1) {
			return 1;
		}
		
		return factorial(value-1)*value;
	}

}
