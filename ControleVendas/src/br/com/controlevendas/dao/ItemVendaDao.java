package br.com.controlevendas.dao;

import br.com.controlevendas.jdbc.ConnectionFactory;
import br.com.controlevendas.model.ItemVenda;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.sql.PreparedStatement;

public class ItemVendaDao {
    
    private final Connection con;
    
    // Método construtor que recebe o mesmo nome da classe
    public ItemVendaDao(){
        
        this.con = new ConnectionFactory().getConnection();
                
    }
    
    // Metodo cadastrar itens da venda
    public void cadastraItem(ItemVenda obj){
        
        try {
            
            String sql = "insert into tb_itensvendas "
                    + "(venda_id, produto_id, qtd, subtotal) "
                    + "values (?, ?, ?, ?)";
            
            PreparedStatement stmt = con.prepareStatement(sql);
            
            stmt.setInt(1, obj.getVenda().getId());
            stmt.setInt(2, obj.getProduto().getId());
            stmt.setInt(3, obj.getQtd());
            stmt.setDouble(4, obj.getSubtotal());
            
            stmt.execute();
            stmt.close();
              
        } catch (SQLException e) {
            
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar Item: "+e);
            
        }
        
    }
    
}
