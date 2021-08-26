package wk5;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class connection {

   
    private final static String URL = "jdbc:mysql://localhost:3306/fruits_db";
    private final static String USERNAME = "root";
    private final static String PASSWORD = "#Irregularshit1";
    public static Connection connection;
    public static connection instance;
    
    public static Connection getConnection(){
        if(instance == null){
            try{
                connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
                instance = new connection();
                System.out.println("Connection successful.");
            }catch(SQLException e){
                e.printStackTrace();

            }
        }

        return connection;
    }
    
}
