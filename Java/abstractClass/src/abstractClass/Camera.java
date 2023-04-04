package abstractClass;

public class Camera extends Machine {

	@Override
	public void start() {
		System.out.println("camera started");
		
	}

	@Override
	public void shutdown() {
		System.out.println("Camera is shutting down!");
		
	}
	
	

}
