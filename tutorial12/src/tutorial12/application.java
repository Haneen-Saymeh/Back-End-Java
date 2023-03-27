package tutorial12;

class Robot{
	public void speak(String name) {
		System.out.println("Hello "  + name);
	}
	
	public void jump(int heihgt) {
		System.out.println("can jump " + heihgt + " height");
	}
	
	public void move(String direction, double distance) {
		System.out.println("moving "+ distance+ " meters. In the direction of "+ direction);
	}
}

public class application {

	public static void main(String[] args) {
		Robot Sam=new Robot();
		Sam.speak("Haninz");
		Sam.jump(7);
		Sam.move("west", 17.5);
//		different string varaible name than class method
		String something="Tony";   
		Sam.speak(something);

	}

}
