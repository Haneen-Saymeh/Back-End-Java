package demo3;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class App {

	public static void main(String[] args) {
		try {
			openFile();
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
		}

	}
	
	public static void openFile() throws FileNotFoundException {
		File myFile = new File("sth.txt");
		FileReader fr = new FileReader(myFile);
	}

}
