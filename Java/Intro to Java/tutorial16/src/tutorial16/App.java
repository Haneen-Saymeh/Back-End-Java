package tutorial16;
class Frog{
	
	int id;
	String name;
	
	public Frog(String name, int id) {
		this.name=name;
		this.id=id;
	}
	public String toString() {
		StringBuilder sb= new StringBuilder();
		sb.append(id).append(":").append(name);
		return sb.toString();
	}
	
}
public class App {

	public static void main(String[] args) {
		
		String info= "";
		info +="Hello, ";
		info += "My name is Hanin!";
		System.out.println(info);
		
//		more better method is to use string builder
		StringBuilder s = new StringBuilder();
		s.append("Hello, ");
		s.append("my name is Hanin!");
		System.out.println(s.toString());
		
//		chaining method
		StringBuilder sb=new StringBuilder();
		sb.append("Hello, ").append("my name is Hanin!");
		System.out.println(sb.toString());
		
		Frog frog1= new Frog("yoyo",5);
		System.out.println(frog1);

	}

}
