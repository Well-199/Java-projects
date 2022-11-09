package br.com.controlevendas.dao;

import br.com.controlevendas.jdbc.ConnectionFactory;
import br.com.controlevendas.model.Vendas;
import java.sql.SQLException;
import java.sql.Connection;
import javax.swing.JOptionPane;
import java.sql.PreparedStatement;

public class VendasDao {
    
    private final Connection con;
    
    // Método construtor que recebe o mesmo nome da classe
    public VendasDao(){
        
        this.con = new ConnectionFactory().getConnection();
                
    }
    
    // Cadastrar Venda
    public void cadastrarVenda(Vendas obj){
        
        try {
            
            String sql = "insert into tb_vendas "
                    + "(cliente_id, data_venda, total_venda, observacoes)"
                    + " values (?, ?, ?, ?)";
            
            
            
        } catch (SQLException e) {
            
            JOptionPane.showMessageDialog(null, "Erro ao adicionar venda: "+e);
            
        }
        
    }
    
}
