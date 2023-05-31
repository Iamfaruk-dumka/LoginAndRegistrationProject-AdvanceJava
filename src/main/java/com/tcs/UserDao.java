package com.tcs;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserDao {

	public static int saveData(Userdata user) throws FileNotFoundException, IOException {
		int res =0;
		
		// create connection
		try {
			
			Connection connection = TestConnection.createConnection();
			PreparedStatement preparedStatement = connection.prepareStatement("insert into user1 values(?,?,?,?) ");
			
			System.out.println(user);
			preparedStatement.setString(1, user.getUsername());
			preparedStatement.setString(2, user.getPassword());
			preparedStatement.setString(3, user.getCpassword());
			preparedStatement.setString(4, user.getEmail());
			res=preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return res;
	}
	
	//login logic
	
	public static boolean checkLogin(String username, String password, String email) throws FileNotFoundException, IOException {
		boolean result = false;
		
		try {
			Connection connection = TestConnection.createConnection();
			Statement statement= connection.createStatement();
			ResultSet set = statement.executeQuery("select password,email from user1 where password='"+password+"'and email ='"+email+"' ");
			
			if(set.next())
			{
				result=true;
			}

			
		} catch (SQLException e) {
			
			e.printStackTrace();
			result = false;
		}
		
		
		return result;
	}

	
	// password Reset Logic here 
	public static int passwordReset(String email, String cpassword) throws FileNotFoundException, IOException {
		
		int res =0;
		
		try {
			
			Connection connection = TestConnection.createConnection();
			Statement statement = connection.createStatement();
			res = statement.executeUpdate("update user1 set password='"+cpassword+"' where email ='"+email+"' ");
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
		return res;
	}

	
	// fetch All Data
	
	public static ResultSet listOfUser() throws FileNotFoundException, IOException {
	
		ResultSet set = null;
		
		Connection connection =TestConnection.createConnection();
		
		try {
			Statement statement = connection.createStatement();
			set =statement.executeQuery("select username , password , cpassword, email from user1");
			
			
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
		
		return set;
	}

	


}
