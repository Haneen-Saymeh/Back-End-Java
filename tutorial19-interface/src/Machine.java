
public class Machine implements Info {
	String model;
	
	public Machine(String model) {
		this.model = model;
	}

	@Override
	public void showInfo() {
		System.out.println("Machine model is: " + model);
		
	}

}
