package jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;

public class Inserir {
    
    public static void main(String[] args) {
        
        try {
            
            ConnectionFactory connectionFactory = new ConnectionFactory();
            Connection connection = connectionFactory.getConnection();
            
            String sql = "insert into produto (nome, descricao) values ('Mesa escritório' , 'Mesa com gavetas 1.50mts') ";
            
            Statement stmt = connection.createStatement();

            stmt.execute(sql, Statement.RETURN_GENERATED_KEYS);
            
            ResultSet result = stmt.getGeneratedKeys();
            
            while(result.next()){
                
                int id = result.getInt(1);
                
                System.out.println("Produto "+id+" inserido com sucesso!!!");
                
            }
            
            stmt.close();
            
        } catch (SQLException e) {
            
            System.out.println("Erro ao inserir dados: "+e);
            
        }
        
    }
    
}
