package br.com.controlevendas.dao;

import br.com.controlevendas.jdbc.ConnectionFactory;
import br.com.controlevendas.model.Vendas;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.ResultSet;
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
                    + "(cliente_id, data_venda, total_venda)"
                    + " values (?, ?, ?)";
            
            PreparedStatement stmt = con.prepareStatement(sql);
            
            stmt.setInt(1, obj.getCliente().getId());
            stmt.setString(2, obj.getData_venda());
            stmt.setDouble(3, obj.getTotal_venda());
            
            stmt.execute();
            stmt.close();
            
            JOptionPane.showMessageDialog(null, "Venda adicionada com sucesso!!!");
            
            
        } catch (SQLException e) {
            
            JOptionPane.showMessageDialog(null, "Erro ao adicionar venda: "+e);
            
        }
        
    }
    
    // Retorna a ultima venda
    public int retornaUltimaVenda(){
        
        int idvenda = 0;
        
        try {
            
            String sql = "select max(id) id from tb_vendas";
            
            PreparedStatement stmt = con.prepareStatement(sql);
            
            ResultSet res = stmt.executeQuery();
            
            if(res.next()){
                
                Vendas p = new Vendas();
                
                // inseri o valor do id no atributo id da classe Vendas
                p.setId(res.getInt("id"));
                
                // Pega o valor que acabou de ser adicionado no atributo id da classe vendas e retorna em idvenda
                idvenda = p.getId();
                
            }
            
            return idvenda;
            
        } catch (SQLException e) {
            
            JOptionPane.showMessageDialog(null, "Erro ao buscar venda: "+e);
            return idvenda;
        }
        
    }
    
}
