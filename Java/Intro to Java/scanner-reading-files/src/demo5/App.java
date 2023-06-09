package demo5;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class App {

	public static void main(String[] args) {
		File myFile = new File("sth.txt");
		BufferedReader br=null;
		try {
			FileReader reader = new FileReader(myFile);
			br= new BufferedReader(reader);
			String line;
			while((line=br.readLine())!=null) {
				System.out.println(line);
			}
			
			
		} catch (FileNotFoundException e) {
			System.out.println("File not found "+ myFile.toString());
		} catch (IOException e) {
		   System.out.println("can't read file " + myFile.toString());
		}
		 
		//  always run after try and catch, weather excpetion caught or not
		finally {
			try {
				br.close();
			} catch (IOException e) {
				System.out.println("Unable to close file"+ myFile.toString());
			}
			catch(NullPointerException ex) {
				
			}
		}
		
		

	}

}
