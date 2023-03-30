package abstractClass;

public class Car extends Machine{
	

	@Override
	public void start() {
		System.out.println("car started");
		
	}

	@Override
	public void shutdown() {
		System.out.println("Car is shutting down!");
		
	}

}
