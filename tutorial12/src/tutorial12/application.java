package tutorial12;

class Robot{
	public void speak(String name) {
		System.out.println("Hello "  + name);
	}
	
	public void jump(int heihgt) {
		System.out.println("can jump " + heihgt + " height");
	}
}

public class application {

	public static void main(String[] args) {
		Robot Sam=new Robot();
		Sam.speak("Haninz");
		Sam.jump(7);

	}

}
