package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
    
    private static final String DB_URL = "jdbc:mysql://localhost:3306/mapa";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "root";

 
    public static Connection getConnection() {
        Connection connection = null;
        try {
            
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
        } catch (ClassNotFoundException e) {
            System.out.println("Driver JDBC não encontrado.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Falha ao conectar ao banco de dados.");
            e.printStackTrace();
        }
        return connection;
    }
}
