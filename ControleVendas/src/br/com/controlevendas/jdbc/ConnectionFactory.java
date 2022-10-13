
package br.com.controlevendas.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConnectionFactory {
    
    public Connection getConnection(){
        
        try {
            
            return DriverManager.getConnection();
            
        }catch(SQLException erro){
            
            throw new RuntimeException(erro);
        }
        
    }
    
}
