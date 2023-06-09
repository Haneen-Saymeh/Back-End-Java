package serialization;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class WriteObjects {

	public static void main(String[] args) {
		System.out.println("writing objcts....");
		Person sam= new Person(5,"sam");
		Person li= new Person(7,"li");
		Person[] people = {new Person(3,"wang"), new Person(7,"li"), new Person(6,"loli")};
		System.out.println(sam);
		System.out.println(li);
		
		try(FileOutputStream fs= new FileOutputStream("people.bin")){
			ObjectOutputStream os= new ObjectOutputStream(fs);
//			os.writeObject(sam);
//			os.writeObject(li);
			os.writeObject(people);
			os.close();
			
			
		} catch (FileNotFoundException e) {
			System.out.println("file not found");
		} catch (IOException e) {
			System.out.println("can't read file");
		}

	}

}
