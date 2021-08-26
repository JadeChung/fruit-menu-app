package wk5;


import java.sql.DriverManager;
import java.sql.SQLException;

public class Menu {

	public static void main(String[] args) {
		
	final String connectionStr = "jdbc:mysql://localhost:3306/fruits_db";
	
	try {
		 DriverManager.getConnection(connectionStr, "root", "#Irregularshit1");
		System.out.println("Connected successfully");
	} catch (SQLException e) {
		System.out.println("Connection error!");
		e.printStackTrace();
	}
	}

}
