package demo7;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class App {

	public static void main(String[] args) {
		File file= new File("sth.txt");
		// we use try with resources to solve the problems of closing files we use it instead of demo5 code
		try (BufferedReader br= new BufferedReader(new FileReader(file))){
			String line;
			
			while ((line=br.readLine())!=null) {
				System.out.println(line);
			}
			
		} catch (FileNotFoundException e) {
			System.out.println("file not found: "+ file.toString());
		} catch (IOException e) {
			System.out.println("unable to read: "+file.toString());
		}

	}

}
