
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import  java.sql.SQLException;

/**
 *
 * @author conta
 */
public class Conexao {
    
    private final String DRIVER = "com.mysql.jdbc.Driver";
    private final String URL = "jdbc:mysql:/localhost:3306/ControleDeRelatorio";
    private final String USER = "root";
    private final String PASS = "152839";
    
    public Connection getConnection() {
        
        try {
            
            Class.forName(DRIVER);
            return DriverManager.getConnection(URL, USER, PASS);

        } catch (ClassNotFoundException e) {
            System.out.println("Driver não localizado.");
            return null;
            
        } catch (SQLException e) {
            System.out.println("Ocorreuy um erro ao acessar o banco: " + e.getMessage());
            return null;
        }
    }
    
    private static void closeConnection(Connection con) {
        try {
            if (con != null) {
                con.close();
            }
        } catch (SQLException e) {
            System.out.println("Erro ao fechar a conexão: " + e.getMessage());
        }
    } 
}
