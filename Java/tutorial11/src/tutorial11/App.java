package tutorial11;

class Person{
	String name;
	int age;
	
	void speak() {
		System.out.println("Hello, my name is "+name+". I am "+ age + " years old.");
	}
	
	void sayHello() {
		System.out.println("Hello");
	}
	
	int retirement() {
		 int leftYears=65-age;
		 return leftYears;
	}
	
	int getAge() {
		return age;
	}
	
	String getName() {
		return name;
	}
}

public class App {

	public static void main(String[] args) {
		Person person1= new Person();
		person1.name="haninz";
		person1.age=27;
		person1.speak();
		person1.sayHello();
		
		System.out.println(person1.name);
		int years=person1.retirement();
		System.out.println("number of left years: "+ years);
		int age= person1.getAge();
		String name=person1.getName();
		System.out.println("the name is: " + name);
		System.out.println("the age is: " + age);


	}

}
