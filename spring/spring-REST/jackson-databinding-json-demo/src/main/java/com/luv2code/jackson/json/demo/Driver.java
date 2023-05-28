package com.luv2code.jackson.json.demo;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
public class Driver {

	public static void main(String[] args) {
		
		try {
			// create object mapper
			ObjectMapper mapper = new ObjectMapper();
			
			Student theStudent=
					mapper.readValue(new File("data/sample-full.json"), Student.class);
			Address theAddress = theStudent.getAddress();
			
			System.out.println(theStudent.getFirstName()+" " + theStudent.getLastName());
			
			System.out.println("street: "+ theAddress.getStreet());
			System.out.println("city: "+ theAddress.getCity());
			System.out.println("Zip: "+ theAddress.getZip());
			System.out.println("State: "+ theAddress.getState());
			System.out.println("Country: "+ theAddress.getCountry());
			
			String[] langs= theStudent.getLanguages();
			
			for (String lang: langs) {
				System.out.println(lang);
				
			}

	}
		catch(Exception exc) {
			exc.printStackTrace();
		}
			
		}

}
