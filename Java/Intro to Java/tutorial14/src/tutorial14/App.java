package tutorial14;

import java.util.Objects;

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

	@Override
	public int hashCode() {
		return Objects.hash(code, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Machine other = (Machine) obj;
		return code == other.code && Objects.equals(name, other.name);
	}
	
	
}

public class App {

	public static void main(String[] args) {
		Machine m1= new Machine();
		Machine m2= new Machine("yogi");
		Machine m3= new Machine("yoo",666);
		Machine m5= new Machine("yoo",666);
		System.out.println(m3.name);
		System.out.println(m3.code);
		System.out.println(m1.name);
		System.out.println(m1.code);
		
		System.out.println(m3==m5);  //false
		System.out.println(m3);
		System.out.println(m5);
		System.out.println(m3.equals(m5));
		System.out.println(m3);
		System.out.println(m5);
		m3=m5;
		System.out.println(m3==m5);
		System.out.println(m3);
		System.out.println(m5);
		
		Double d1=7.5;
		Double d2= 7.5;
		System.out.println(d1==d2);
		System.out.println(d1.equals(d2));
		
		Integer int1=5;
		Integer int2=5;
		System.out.println(int1==int2);
		System.out.println(int1.equals(int2));
		
		String s1="Hi";
		String s2="Hiz";
		
		System.out.println(s1==s2);
		System.out.println(s1.equals(s2));

		

	}

}
