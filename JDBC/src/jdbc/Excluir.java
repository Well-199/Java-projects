package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Excluir {
    
    public static void main(String[] args) {
        
        try {
            
            ConnectionFactory connectionFactory = new ConnectionFactory();
            Connection connection = connectionFactory.getConnection();
            
            String sql = "delete from produto where id = ?";
            
            PreparedStatement stmt = connection.prepareStatement(sql);
            
            int id = 10;
            
            stmt.setInt(1, id);
            
            stmt.execute();
            
            System.out.println("Produto "+id+" excluido com sucesso!!!");
            
            stmt.close();
            
        } catch (SQLException e) {
            
            System.out.println("Erro ao excluir: "+e);
        }
        
    }
    
}
