
public class App {

	public static void main(String[] args) {
		Animal animal = Animal.Cat;
		Animal animal3= Animal.valueOf("Dog");
		Animal animal2= Animal.Mouse;
		switch(animal) {
		case Cat:
			System.out.println("is cat!");
			break;
		case Dog:
			System.out.println("is dog!");
			break;
		case Mouse:
			System.out.println("is mouse!");
			break;
		default:
			break;
			
		}
		
		animal.Cat.setName("batboot");
		System.out.println(animal.Cat.getName());
		System.out.println(animal2.Mouse);
		System.out.println(animal2.Mouse.name());
		System.out.println(animal3);
		

	}

}
