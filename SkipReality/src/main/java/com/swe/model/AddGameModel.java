package com.swe.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class AddGameModel{
    
    public void TheQueryGame(String query) {
    Connection connect = null;
    Statement st = null;
    
    try{
        Class.forName("com.mysql.jdbc.Driver");
        connect= DriverManager.getConnection("jdbc:mysql://localhost:3306/myproject","root","");
        System.out.println("Connection Please Wait.. Or Press OK");
        st = connect.createStatement();
        st.executeUpdate(query);
        System.out.println("Game Has Been Added");
        
    }catch (Exception exc) {
        System.out.println("Error While Trying To Add The Game");
        }
    }

    ////////////////////////////////////////////////////////////////
    public ArrayList<String> search(String query, String gname) throws SQLException {
    ArrayList<String> result = new ArrayList<>(); 
    String returnresult = "";
    Connection con = null;
    Statement st = null;
    ResultSet res = null;
    try {
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/myproject","root","");
        st = con.createStatement();
        res = st.executeQuery(query);
        
        while (res.next()){
            returnresult = res.getString(gname);
            result.add(returnresult);
        }
        
    } catch (Exception exc){
        //JOptionPane.showMessageDialog(null, exc.getMessage());
     
    }
    
    return result;
}   
    
    public void addGame_DB(String nameg,String idg,String typeg) {
    TheQueryGame("INSERT INTO game (GName,GID,GType) VALUES ('" + nameg + "','" + idg + "','" + typeg + "');");
}
    
 ////////////////////////////////////////////////////////////   
    public ArrayList<String> retgame_DB() throws SQLException {
    ArrayList<String> Return_Query_Result = new ArrayList<>();
    Return_Query_Result= search("SELECT * FROM game","Gname");
    return Return_Query_Result;
}
	public AddGameModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ArrayList<String> findrecords()
	{   ArrayList<String> o=new ArrayList<String>();
		o.add("math");
		o.add("general_information");
		o.add("G3");
		o.add("G4");
		return o;
		
	}
    
    

}

