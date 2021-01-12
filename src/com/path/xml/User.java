package com.path.xml;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class User {
	
	private String name;
	private String pass;
	
	private ArrayList<User> users = new ArrayList<User>();
	
	public User() {}
	
	public User(String name, String pass) {
		this.name  = name;
		this.pass = pass;
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public ArrayList<User> getUsers() {
		return users;
	}
	
	@XmlElementWrapper(name = "users")
    @XmlElement(name = "user")
	public void setUsers(ArrayList<User> users) {
		this.users = users;
	}
}
