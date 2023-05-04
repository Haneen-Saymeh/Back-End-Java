
class Machine{
	public void start() {
		System.out.println("Machine is starting ....");
	}
}


interface Plant{
	public void grow();
}



public class App {

	public static void main(String[] args) {
		Machine destroyer= new Machine() {
			@Override public void start(){
				System.out.println("Machine destroyer is starting");
			}
		};
		
		destroyer.start();
		
		Plant plant= new Plant() {
			@Override public void grow() {
				System.out.println("plant is growing");
			}
		};
		
		plant.grow();

	}

}
