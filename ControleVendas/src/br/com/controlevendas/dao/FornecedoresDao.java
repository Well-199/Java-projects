package br.com.controlevendas.dao;

import java.sql.Connection;
import br.com.controlevendas.jdbc.ConnectionFactory;
import br.com.controlevendas.model.Fornecedores;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class FornecedoresDao {
    
    private Connection con;
    
    public FornecedoresDao() {
        
        this.con = new ConnectionFactory().getConnection();
        
    }
    
    // Cadastro de fornecedor
    public void cadastrarFornecedor(Fornecedores obj){
        
        try {
            
            // 1 - Criar o comando SQL
            String sql = "insert into tb_fornecedores "
                    + "(nome, cnpj, email, telefone, celular, cep, "
                    + "endereco, numero, complemento, bairro, cidade, estado) "
                    + "values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            
            // 2 - Conectar com o banco de dados
            PreparedStatement stmt = con.prepareStatement(sql);
            
            // 3 - Organizar os valores que serao inseridos no SQL
            stmt.setString(1, obj.getNome());
            stmt.setString(2, obj.getCnpj());
            stmt.setString(3, obj.getEmail());
            stmt.setString(4, obj.getTelefone());
            stmt.setString(5, obj.getCelular());
            stmt.setString(6, obj.getCep());
            stmt.setString(7, obj.getEndereco());
            stmt.setInt(8, obj.getNumero());
            stmt.setString(9, obj.getComplemento());
            stmt.setString(10, obj.getBairro());
            stmt.setString(11, obj.getCidade());
            stmt.setString(12, obj.getUf());
           
            // 4 - Executar o comando SQL
            stmt.execute();

            // 5 - Fechar a conexão com o banco de dados
            stmt.close();

            JOptionPane.showMessageDialog(null, "Cadastrado com sucesso!!!");
            
        } catch (SQLException erro){
            
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar :( "+ erro);
            
        }
        
    }
    
    // Listar fornecedores
    public List<Fornecedores> listarFornecedores(){
        
        try {
            
            // 1 - Criar a Lista
            List<Fornecedores> lista = new ArrayList<>();
            
            // 2 - Criar o comando SQL
            String sql = "select * from tb_fornecedores";
            
            // 3 - inicia a conexão com banco de dados
            PreparedStatement stmt = con.prepareStatement(sql);
            
            // 4 - Executa o comando SQL e armazena o retorno em rs
            ResultSet rs = stmt.executeQuery();
            
            // Faz um loop na lista e monta um array de objetos
            while (rs.next()) {
                
                Fornecedores obj = new Fornecedores();
                
                obj.setId(rs.getInt("id"));
                obj.setNome(rs.getString("nome"));
                obj.setCnpj(rs.getString("cnpj"));
                obj.setEmail(rs.getString("email"));
                obj.setTelefone(rs.getString("telefone"));
                obj.setCelular(rs.getString("celular"));
                obj.setCep(rs.getString("cep"));
                obj.setEndereco(rs.getString("endereco"));
                obj.setNumero(rs.getInt("numero"));
                obj.setComplemento(rs.getString("complemento"));
                obj.setBairro(rs.getString("bairro"));
                obj.setCidade(rs.getString("cidade"));
                obj.setUf(rs.getString("estado"));
                
                lista.add(obj);
                
            }
            
            return lista;
            
            
        } catch (SQLException erro) {
            
            JOptionPane.showMessageDialog(null, "Erro "+ erro);
            return null;
        }
        
    }
    
    // Excluir fornecedor
    public void excluirFornecedor(Fornecedores obj){
        
        try {
            
            // 1 - Cria o comando SQL
            String sql = "delete from tb_fornecedores where id = ?";
            
            // 2 - Inicia a conexão com o banco de dados
            PreparedStatement stmt = con.prepareStatement(sql);
            
            // 3 -seta no sql o id esperado como parametro em ? na posição 1
            stmt.setInt(1, obj.getId());
            
            // 4 -Executa o comando SQL
            stmt.execute();
            
            // 5 - Encerra a conexão com o banco de dados
            stmt.close();
            
            JOptionPane.showMessageDialog(null, "Excluido com sucesso!!!");
            
        } catch (Exception e) {
            
            JOptionPane.showMessageDialog(null, "Erro ao excluir"+ e);
            
        }
        
    }
    
    // Alterar fornecedor
    public void alterarFornecedor(Fornecedores obj){
        
        try {
            
            // 1 - Criar o comando SQL
            String sql = "update tb_fornecedores set "
                    + "nome=?, cnpj=?, email=?, telefone=?, celular=?, cep=?, "
                    + "endereco=?, numero=?, complemento=?, bairro=?, cidade=?, estado=? "
                    + "where id = ?";
            
            // 2 - Conectar com o banco de dados
            PreparedStatement stmt = con.prepareStatement(sql);
            
            // 3 - Organizar os valores que serao inseridos no SQL
           stmt.setString(1, obj.getNome());
           stmt.setString(2, obj.getCnpj());
           stmt.setString(3, obj.getEmail());
           stmt.setString(4, obj.getTelefone());
           stmt.setString(5, obj.getCelular());
           stmt.setString(6, obj.getCep());
           stmt.setString(7, obj.getEndereco());
           stmt.setInt(8, obj.getNumero());
           stmt.setString(9, obj.getComplemento());
           stmt.setString(10, obj.getBairro());
           stmt.setString(11, obj.getCidade());
           stmt.setString(12, obj.getUf());
           
           stmt.setInt(13, obj.getId());
           
           // 4 - Executar o comando SQL
           stmt.execute();
           
           // 5 - Fechar a conexão com o banco de dados
           stmt.close();
           
            JOptionPane.showMessageDialog(null, "Alterado com sucesso!!!");
            
        } catch (SQLException erro){
            
            JOptionPane.showMessageDialog(null, "Erro ao alterar :( "+ erro);
            
        }
        
    }
    
    // Busca fornecedor pelo nome / razão social
    public List<Fornecedores> buscaFornecedorPorNome(String nome){
        
        try {
            
            // 1 criar a lista
            List<Fornecedores> lista = new ArrayList<>();
            
            // 2 criar o comando SQL
            String sql = "select * from tb_fornecedores where nome like ?";
            
            // 3 inicia a conexão com o banco de dados
            PreparedStatement stmt = con.prepareStatement(sql);
            
            // 4 seta o parametro nome no parametro esperado no sql em ?
            stmt.setString(1, nome);
            
            // 5 Executa a o sql e retorna a consulta e rs
            ResultSet res = stmt.executeQuery();
            
            while(res.next()){
                
                Fornecedores obj = new Fornecedores();
                
                obj.setId(res.getInt("id"));
                obj.setNome(res.getString("nome"));
                obj.setCnpj(res.getString("cnpj"));
                obj.setEmail(res.getString("email"));
                obj.setTelefone(res.getString("telefone"));
                obj.setCelular(res.getString("celular"));
                obj.setCep(res.getString("cep"));
                obj.setEndereco(res.getString("endereco"));
                obj.setNumero(res.getInt("numero"));
                obj.setComplemento(res.getString("complemento"));
                obj.setBairro(res.getString("bairro"));
                obj.setCidade(res.getString("cidade"));
                obj.setUf(res.getString("estado"));
                
                lista.add(obj);
            }
            
            return lista;
            
        } catch (SQLException e) {
            
            JOptionPane.showMessageDialog(null, "Erro na consulta: "+ e);
            return null;
            
        }
         
    }
    
    // Busca fornecedor pelo CNPJ
    public Fornecedores buscaFornecedorPorCNPJ(String cnpj){
        
        try {
            
            String sql = "select * from tb_fornecedores where cnpj=?";
            
            PreparedStatement stmt = con.prepareStatement(sql);
            
            stmt.setString(1, cnpj);
            
            ResultSet res = stmt.executeQuery();
            
            Fornecedores fornecedores = new Fornecedores();
            
            if(res.next()){
                
                fornecedores.setId(res.getInt("id"));
                fornecedores.setNome(res.getString("nome"));
                fornecedores.setCnpj(res.getString("cnpj"));
                fornecedores.setEmail(res.getString("email"));
                fornecedores.setTelefone(res.getString("telefone"));
                fornecedores.setCelular(res.getString("celular"));
                fornecedores.setCep(res.getString("cep"));
                fornecedores.setEndereco(res.getString("endereco"));
                fornecedores.setNumero(res.getInt("numero"));
                fornecedores.setComplemento(res.getString("complemento"));
                fornecedores.setBairro(res.getString("bairro"));
                fornecedores.setCidade(res.getString("cidade"));
                fornecedores.setUf(res.getString("estado"));
                
            }
            
            return fornecedores;
          
        } catch (SQLException e) {
            
            JOptionPane.showMessageDialog(null, "Erro ao busca CNPJ"+ e);
            return null;
        }
        
    }
    
    // Retorna um objeto fornecedor pelo nome
    public Fornecedores buscaObjetoFornecedor(String nome){
        
        try {
            
            String sql = "select * from tb_fornecedores where nome=?";
            
            PreparedStatement stmt = con.prepareStatement(sql);
            
            stmt.setString(1, nome);
            
            ResultSet res = stmt.executeQuery();
            
            Fornecedores fornecedores = new Fornecedores();
            
            if(res.next()){
                
                fornecedores.setId(res.getInt("id"));
                fornecedores.setNome(res.getString("nome"));
                fornecedores.setCnpj(res.getString("cnpj"));
                fornecedores.setEmail(res.getString("email"));
                fornecedores.setTelefone(res.getString("telefone"));
                fornecedores.setCelular(res.getString("celular"));
                fornecedores.setCep(res.getString("cep"));
                fornecedores.setEndereco(res.getString("endereco"));
                fornecedores.setNumero(res.getInt("numero"));
                fornecedores.setComplemento(res.getString("complemento"));
                fornecedores.setBairro(res.getString("bairro"));
                fornecedores.setCidade(res.getString("cidade"));
                fornecedores.setUf(res.getString("estado"));
                
            }
            
            return fornecedores;
          
        } catch (SQLException e) {
            
            JOptionPane.showMessageDialog(null, "Erro ao busca Descrição"+ e);
            return null;
        }
        
    }
       
}
