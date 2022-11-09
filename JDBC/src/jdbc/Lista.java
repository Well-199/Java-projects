package jdbc;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Lista {

    public static void main(String[] args) {
        
        try {
            
            ConnectionFactory connectionFactory = new ConnectionFactory();
            
            // connection pega o retorno da execução do metodo getConnection()
            Connection connection = connectionFactory.getConnection();
            
            String sql = "select id, nome, descricao from produto";
            
            PreparedStatement stmt = connection.prepareStatement(sql);
            
            stmt.execute();
            
            ResultSet resultados = stmt.getResultSet();
            
            while(resultados.next()){
                
                Integer id = resultados.getInt("id");
                String nome = resultados.getString("nome");
                String descricao = resultados.getString("descricao");
                
                System.out.println("___________________________________");
                System.out.println("| "+id+" | "+nome+" | "+descricao+" |");
                System.out.println("___________________________________");
                
            }
            
            connection.close();
            
        } catch (SQLException e) {
            
            System.out.println("Erro na conexão: "+e);
        }
        
    }
    
}
