package tutorial13;


class Frog{
	private String name;
	private int age;
	
	public int getAge() {
		return age;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name=name;
	}
	
	public void setAge(int age) {
		this.age=age;
	}
}
public class App {

	public static void main(String[] args) {
		Frog frog1= new Frog();
		frog1.setAge(15);
		frog1.setName("dodi");
		System.out.println(frog1.getAge());
		System.out.println(frog1.getName());
		

	}

}
