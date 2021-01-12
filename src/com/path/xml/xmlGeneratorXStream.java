package com.path.xml;

import java.util.ArrayList;

import com.thoughtworks.xstream.XStream;

public class xmlGeneratorXStream {

	public static void main(String[] args) 
	{
		ArrayList<User> users = new ArrayList<>();
		User user1 = new User("Ali", "123");
		User user2 = new User("Alim", "1234");
		User user3 = new User("Alim2", "1235");
		
		users.add(user1);
		users.add(user2);
		users.add(user3);
		
	
		XStream xstream = new XStream();
		xstream.alias("user1", User.class);
		
	//	xstream.alias("users", users.getClass());
	//	xstream.addImplicitCollection(users.getClass(), "users");

		String xml = xstream.toXML(users);
		System.out.println(xml);
	}

}
