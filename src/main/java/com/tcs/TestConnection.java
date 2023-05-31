package com.tcs;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class TestConnection {

	public static Connection createConnection() throws FileNotFoundException , IOException {
		Connection connection = null;
		try {
			
			//load the properties file
			Properties properties = new Properties();
			properties.load(new FileInputStream("C:\\Users\\kohinoor\\WebApplication\\LoginSignUpManagement\\connection-info.properties"));
			
			
			// load the data from properties file
			Class.forName(properties.getProperty("driver"));
			connection=DriverManager.getConnection(properties.getProperty("url"),properties.getProperty("username"),properties.getProperty("password"));
			
			
		} catch (ClassNotFoundException  | SQLException e) {
			e.printStackTrace();
		}
		
		return connection;
	}

}
