package com.path.xml;

import java.io.File;
import java.util.ArrayList;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;

public class XmUsingJaxb {

	public static void main(String[] args) throws Exception {
		
		User user = new User();
		
		ArrayList<User> users = new ArrayList<>();
		User user1 = new User("Ali", "123");
		User user2 = new User("Alim", "1234");
		User user3 = new User("Alim2", "1235");
		
		users.add(user1);
		users.add(user2);
		users.add(user3);
		
		user.setUsers(users);
		
		personToXMLExample("E:/new.xml", user);

	}

	private static void personToXMLExample(String filename, User u) throws Exception 
	{
		
	    File file = new File(filename);
	    JAXBContext jaxbContext = JAXBContext.newInstance(User.class);

	    Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

	    jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
	    
		
	    jaxbMarshaller.marshal(u, file);
	    jaxbMarshaller.marshal(u, System.out);
	}
	
}
