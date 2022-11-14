package br.com.controlevendas.dao;

import br.com.controlevendas.jdbc.ConnectionFactory;
import br.com.controlevendas.model.Clientes;
import br.com.controlevendas.model.Vendas;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import java.sql.PreparedStatement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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
    
    // Filtar vendas posr data
    public List<Vendas> listarVendasPorPeriodo(LocalDate data_inicial, LocalDate data_final){
        
        try {
            
            List<Vendas> lista = new ArrayList<>();
            
            String sql = ""
                    + "select "
                    + "v.id, date_format(v.data_venda, '%d/%m/%Y') as data_formatada, c.nome, v.total_venda "
                    + "from "
                    + "tb_vendas as v "
                    + "inner join "
                    + "tb_clientes as c "
                    + "on (v.cliente_id = c.id) "
                    + "where v.data_venda BETWEEN ? AND ?";
            
            // where data_venda entre (BETWEEN) duas datas
            
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, data_inicial.toString());
            stmt.setString(2, data_final.toString());
            
            ResultSet res = stmt.executeQuery();
            
            while(res.next()){
                
                Vendas obj = new Vendas();
                Clientes cliente = new Clientes();
                
                obj.setId(res.getInt("v.id"));
                obj.setData_venda(res.getString("data_formatada"));
                cliente.setNome(res.getString("c.nome"));
                obj.setTotal_venda(res.getDouble("v.total_venda"));
                
                obj.setCliente(cliente);
                
                lista.add(obj);
                
            }
            
            return lista;
            
        } catch (SQLException e) {
            
            JOptionPane.showMessageDialog(null, "Erro: "+e);
            
            return null;
            
        }
        
    }
    
}
