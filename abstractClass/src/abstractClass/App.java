package abstractClass;

public class App {

	public static void main(String[] args) {
		Car car=new Car();
		Camera camera = new Camera();
		car.setID(5);
		System.out.println(car.getID());
		
		car.run();
		camera.run();

	}

}
