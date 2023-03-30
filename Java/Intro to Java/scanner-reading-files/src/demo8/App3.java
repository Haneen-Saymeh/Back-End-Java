package demo8;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class App3 {

	public static void main(String[] args) {
		File file= new File("new.txt");
		// we use try with resources to solve the problems of closing files we use it instead of demo5 code
		try (BufferedWriter br= new BufferedWriter(new FileWriter(file))){
			br.write("大家好");
			br.newLine();
			br.write("怎么样");
			
		} catch (IOException e) {
			System.out.println("unable to read: "+file.toString());
		}

	}

}
