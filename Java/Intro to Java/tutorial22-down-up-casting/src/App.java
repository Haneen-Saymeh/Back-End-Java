import java.util.ArrayList;

class Machine{
	public void start() {
		System.out.println("Machine started");
	}

	
	public String toString() {
		return "I am machine";
	}
	
	
}

class Camera extends Machine{

	@Override
	public void start() {
		System.out.println("Camera started");
	}
	
	public void snap() {
		System.out.println("Photo taken");
	}
	
	public String toString() {
		return "I am Camera";
	}
	
}





public class App {

	public static void main(String[] args) {
		Machine machine1= new Machine();
		Camera camera1= new Camera();
		
		machine1.start();
		camera1.start();
		camera1.snap();
//		upcasting
//		polymorphism
//		type of the object(machine) determined what methods we can access
//		and object or sublcass we refere to determine what type of methods implementation
		Machine machine2= camera1;
		machine2.start();
//		error
//		machine1.snap();
		
//		downcasting
		Machine machine3= new Camera();
		Camera camera2=(Camera)machine3;
		camera2.start();
		camera2.snap();
//		can't do this, run time error. can't downcast to object with both type and reference to super-class
//		Machine machine4= new Machine();
//		Camera camera3= (Camera) machine4;
		
		
		
		// Generics and wildcars//
		ArrayList<Machine> list1= new ArrayList();
		ArrayList<Camera> list2= new ArrayList();
		
		list1.add(new Machine());
		list2.add(new Camera());
		
		showlist(list1);
		showlist(list2);
		showlistagain(list1);
		showlistagain(list2);
		
		
	}
	
	public static void showlist(ArrayList<?> list) {
		for(Object item: list) {
			System.out.println(item);
			
		}
		
	}
	
	public static void showlistagain(ArrayList<? extends Machine> list) {
		for(Machine item: list) {
			System.out.println(item);
			item.start();
			
		}
		
	}

}
