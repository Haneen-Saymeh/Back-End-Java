package serialization;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class ReadObjects {

	public static void main(String[] args) {
		System.out.println("reading objects");
		try(FileInputStream fi = new FileInputStream("people.bin")){
			ObjectInputStream os = new ObjectInputStream(fi);
//			Person person1 = (Person) os.readObject();
//			Person person2= (Person) os.readObject();
			Person[] people= (Person[]) os.readObject();
			os.close();
//			System.out.println(person1);
//			System.out.println(person2);
			
			for(Person person:people) {
				System.out.println(person);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
