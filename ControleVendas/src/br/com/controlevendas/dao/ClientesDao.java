
package br.com.controlevendas.dao;

import br.com.controlevendas.jdbc.ConnectionFactory;
import br.com.controlevendas.model.Clientes;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class ClientesDao {
    
    private Connection con;
    
    // Método construtor que recebe o mesmo nome da classe
    public ClientesDao(){
        
        this.con = new ConnectionFactory().getConnection();
                
    }
    
    public void cadastrarCliente(Clientes obj){
        
        try {
            
            // 1 - Criar o comando SQL
            String sql = "insert into tb_clientes "
                    + "(nome, rg, cpf, email, telefone, celular, cep, "
                    + "endereco, numero, complemento, bairro, cidade, estado) "
                    + "values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            
            // 2 - Conectar com o banco de dados
            PreparedStatement stmt = con.prepareStatement(sql);
            
            // 3 - Organizar os valores que serao inseridos no SQL
           stmt.setString(1, obj.getNome());
           stmt.setString(2, obj.getRg());
           stmt.setString(3, obj.getCpf());
           stmt.setString(4, obj.getEmail());
           stmt.setString(5, obj.getTelefone());
           stmt.setString(6, obj.getCelular());
           stmt.setString(7, obj.getCep());
           stmt.setString(8, obj.getEndereco());
           stmt.setInt(9, obj.getNumero());
           stmt.setString(10, obj.getComplemento());
           stmt.setString(11, obj.getBairro());
           stmt.setString(12, obj.getCidade());
           stmt.setString(13, obj.getUf());
           
           // 4 - Executar o comando SQL
           stmt.execute();
           
           // 5 - Fechar a conexão com o banco de dados
           stmt.close();
           
            JOptionPane.showMessageDialog(null, "Cadastrado com sucesso!!!");
            
        } catch (SQLException erro){
            
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar :( "+ erro);
            
        }
        
    }
    
    public void alterarCliente(){
        
    }
    
    public void excluirCliente(){
        
    }
    
}
