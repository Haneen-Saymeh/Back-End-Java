package tutorial14;
class Machine{
	String name;
	int code;
	public Machine() {
		this("haninz",7);
		System.out.println("first constructor is running");
		
	}
	
	public Machine(String name) {
		System.out.println("2nd constructor is running");

		this.name=name;
	}
	
	public Machine(String name, int code) {
		System.out.println("3rd constructor is running");

		this.name=name;
		this.code=code;
	}
	
}

public class App {

	public static void main(String[] args) {
		Machine m1= new Machine();
		Machine m2= new Machine("yogi");
		Machine m3= new Machine("yoo",666);
		System.out.println(m3.name);
		System.out.println(m3.code);
		System.out.println(m1.name);
		System.out.println(m1.code);

		

	}

}
