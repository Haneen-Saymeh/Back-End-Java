import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class App {

	public static void main(String[] args) throws FileNotFoundException {
		String fileName= "C:\\Users\\LENOVO\\Desktop\\fav.txt";
		File myFile = new File(fileName);
		Scanner in = new Scanner(myFile);
		
		while(in.hasNextLine()) {
			String line = in.nextLine();
			System.out.println(line);
		}
		in.close();
		
	

	}

}
