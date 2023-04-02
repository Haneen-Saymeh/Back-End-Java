
public class Robot {
	private int id;
	
	private class Brain{
		public void think() {
			System.out.println("Robot "  + id+ " is thinking ");
		}
	}
	
	static class Battery{
		public void chargr() {
			System.out.println("Battery is charging!");
		}
	}
	
	public Robot(int id) {
		this.id=id;
	}
	
	public void start() {
		System.out.println("Robot is starting " + id);
		Brain brain= new Brain();
		brain.think();
		final String name="hanz";
		class Temp{
			public void doSth() {
				System.out.println("id is: " + id);
				System.out.println("my name is  "+ name);
			}
		}
		Temp temp = new Temp();
		temp.doSth();
	}

}
