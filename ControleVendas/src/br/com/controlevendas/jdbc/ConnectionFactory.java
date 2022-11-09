
package br.com.controlevendas.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;


public class ConnectionFactory {
    
    public Connection getConnection(){
        
        try {
            
            return DriverManager.getConnection("jdbc:mysql://", "", "");
            
        }catch(Exception erro){
            
            throw new RuntimeException(erro);
        }
        
    }
    
}
