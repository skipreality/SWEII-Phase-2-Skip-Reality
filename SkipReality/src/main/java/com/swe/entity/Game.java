package com.swe.entity;

//import javax.persistence.Entity;
//import javax.persistence.Id;

//@Entity
public class Game {
	
	//@Id
	private String ID;
	private String Name;
	private String Type;
	
	
	
	
	public Game() {
		super();

	}
	
	public Game(String iD, String name, String type) {
		super();
		ID = iD;
		Name = name;
		Type = type;
	}
	
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getType() {
		return Type;
	}
	public void setType(String type) {
		Type = type;
	}
	
	
	

}
