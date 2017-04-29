package com.swe.entity;

//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;

//@Entity
public class User {
	
	
	//@GeneratedValue(strategy=GenerationType.AUTO)
	//private Integer SequenceID;
	private String Name;
	//@Id
	private String ID;
	private String Password;
	private String Type;
	
	
	
	
	public User() {
		super();
		
		//SequenceID = 0;
		Name = "";
		ID = "";
		Password = "";
		Type = "";
	}
	
	public User(String Name, String Password) {
		super();
		this.Name = Name;
		this.Password = Password;
	}

	public User(String name, String iD, String password, String type) {
		super();
		//SequenceID = sequenceID;
		Name = name;
		ID = iD;
		Password = password;
		Type = type;
	}
	
	
	/*public Integer getSequenceID() {
		return SequenceID;
	}
	public void setSequenceID(Integer sequenceID) {
		SequenceID = sequenceID;
	}*/
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public String getType() {
		return Type;
	}
	public void setType(String type) {
		Type = type;
	}
	
	
	
}	