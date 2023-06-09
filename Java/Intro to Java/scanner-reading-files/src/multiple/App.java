package multiple;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;

public class App {

	public static void main(String[] args) {
		Test test= new Test();
//		try {
//			test.run();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (ParseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		
//		try {
//			test.run();
//		} catch (IOException | ParseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		// we can just put Exception because its the parent class for all exceptions
		try {
			test.run();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// file not found was added first because its child class of ioexpection if we have parent
		// it will catch all its sub-classes excpetions
		try {
			test.input();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//it only included the parent class
		try {
			test.input();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
