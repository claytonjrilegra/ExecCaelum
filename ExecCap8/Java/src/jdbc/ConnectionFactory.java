package jdbc;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConnectionFactory {
    public Connection getConnection() {
    System.out.println("Conectando ao banco");
    try {
         
            DriverManager.registerDriver(new com.mysql.jdbc.Driver()); //Essa linha foi a diferença
            return DriverManager.getConnection("jdbc:mysql://localhost/caelumjava", "root", "eumsmo");
            } catch(SQLException e) {
                e.printStackTrace();
                throw new RuntimeException(e);
             
        }
         
    }
}