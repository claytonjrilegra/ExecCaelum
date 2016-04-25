package Jdbc;

import java.sql.DriverManager;
import java.sql.SQLException;


public class ConnectionFactory {
	
	public java.sql.Connection getConnection() {
	     try {
	         return DriverManager.getConnection(
	 "jdbc:mysql://localhost/caelumjava", "root", "eumsmo");
	     } catch (SQLException e) {
	         throw new RuntimeException(e);
	     }
	 }

}
