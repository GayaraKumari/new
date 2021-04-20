package com.gayara.model;
import java.sql.*;
public class Register {
	
	
	//bd
	public static Connection connect()
	{
	 Connection con = null;

	 try
	 {
	 Class.forName("com.mysql.jdbc.Driver");
	 con= DriverManager.getConnection("jdbc:mysql://127.0.0.1:3307/register",
	 "root", "");
	 //For testing
	 System.out.print("Successfully connected");
	 }
	 catch(Exception e)
	 {
		 System.out.print("Not connected");
	 }

	 return con;
	}
	
	
	
	
	
	

	public String insertuserdetails(String Name, String Email, String Address, String Username,String Password)
	{
	 String output = "";
	try
	 {
	 Connection con = connect();
	 if (con == null)
	 {
	 return "Error while connecting to the database";
	 }
	 // create a prepared statement
	 String query = " insert into signup values (?, ?, ?, ?, ?, ?)";
	 PreparedStatement preparedStmt = con.prepareStatement(query);
	 // binding values
	 preparedStmt.setInt(1, 0);
	 preparedStmt.setString(2, Name);
	 preparedStmt.setString(3, Email);
	 preparedStmt.setString(4, Address);
	 preparedStmt.setString(5, Username);
	 preparedStmt.setString(6, Password);
	
	
	//execute the statement
	 preparedStmt.execute();
	 con.close();
	 output = "Inserted successfully";
	 }
	catch (Exception e)
	 {
	 output = "Error while inserting";
	 System.err.println(e.getMessage());
	 }
	return output;
	}
	
	
	
	

}
