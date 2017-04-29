package com.swe.model;

import java.sql.Connection;


import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.PreparedStatement;


public class AddUserModel {
	
	public void TheQueryUser(String query){
        Connection connect = null;
        java.sql.Statement st = null;
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
            connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/myproject","root","");
            System.out.println("Connection Please Wait.. Or Press OK");
            st = connect.createStatement();
            st.executeUpdate(query);
            
            System.out.println("User Has Been Added To DB");

        }catch (Exception exc){
        	 System.out.println("Error While Trying To Register");
        }
    }
	
	public void TheQueryAccount(String query) {
        Connection connect = null;
        java.sql.Statement st = null;
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
            connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/myproject","root","");
            System.out.println("Connection Please Wait.. Or Press OK");
            st = connect.createStatement();
            st.executeUpdate(query);
            
            System.out.println("Account Has Been Added To DB");

        }catch (Exception exc){
        	 System.out.println("Error While Trying To Register An Account");
        }
    }
	
	public ResultSet TheQueryResult(String query) throws SQLException {
        Connection connect = null;
        java.sql.Statement st = null;
        ResultSet rs = null;
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
            connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/myproject","root","");
            st = connect.createStatement();
            rs = st.executeQuery(query);

            System.out.println("Accounts Has Been Retrieved From DB");

        }catch (Exception exc){
        	 System.out.println("Error While Trying To Retrieve Accounts From DB");
        }
		
        
		return rs ;
    }
    
  
        public void addUser_DB(String Name,String Password,String ID,String Type) {
        TheQueryUser("INSERT INTO register_user_info (User_Name,Password,User_ID,User_Type) VALUES ('" + Name + "','" + Password + "','" + ID + "','" + Type + "');");
        TheQueryAccount("INSERT INTO user_account (UserName,Password) VALUES ('" + Name + "','" + Password + "');");
    }
        
        public ResultSet Result(String Name, String Password) throws SQLException {
        	ResultSet rs = null;
        	PreparedStatement st=null;
        	String SQL = "SELECT * FROM user_account WHERE User_Name=? and Password=?";
        	st.setString(1, Name);
        	st.setString(2, Password);
        	rs = TheQueryResult(SQL);

			return rs;
        	
        }
    
}



