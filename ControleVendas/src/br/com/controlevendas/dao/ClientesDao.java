
package br.com.controlevendas.dao;

import br.com.controlevendas.jdbc.ConnectionFactory;
import br.com.controlevendas.model.Clientes;
import br.com.controlevendas.model.WebServiceCep;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;


public class ClientesDao {
    
    private final Connection con;
    
    // Método construtor que recebe o mesmo nome da classe
    public ClientesDao(){
        
        this.con = new ConnectionFactory().getConnection();
                
    }
    
    // Verifica se o cliente ja exeiste
    public void clienteJaExiste(String cpf, Clientes obj){
        
        try {
            
            String sql = "select * from tb_clientes where cpf=?";
            
            // Inicia a conexão com o banco
            PreparedStatement stmt = con.prepareStatement(sql);
            
            // seta o cpf como parametro na busca
            stmt.setString(1, cpf.replace(" ", ""));
            
            // executa o comando sql e pega o retorno
            ResultSet res = stmt.executeQuery();

            if(res.next()){
                JOptionPane.showMessageDialog(null, "Cliente ja cadastrado");
            }
            else{
                cadastrarCliente(obj);
            }
            
            
        } catch (SQLException e) {
            
            JOptionPane.showMessageDialog(null, "Erro: "+e);
        }
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
    
    // Método alterar cliente
    public void alterarCliente(Clientes obj){
        
        try {
            
            // 1 - Criar o comando SQL
            String sql = "update tb_clientes set "
                    + "nome=?, rg=?, cpf=?, email=?, telefone=?, celular=?, cep=?, "
                    + "endereco=?, numero=?, complemento=?, bairro=?, cidade=?, estado=? "
                    + "where id = ?";
            
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
           
           stmt.setInt(14, obj.getId());
           
           // 4 - Executar o comando SQL
           stmt.execute();
           
           // 5 - Fechar a conexão com o banco de dados
           stmt.close();
           
            JOptionPane.showMessageDialog(null, "Alterado com sucesso!!!");
            
        } catch (SQLException erro){
            
            JOptionPane.showMessageDialog(null, "Erro ao alterar :( "+ erro);
            
        }
        
    }
    
    // Método excluir cliente
    public void excluirCliente(Clientes obj){
        
        try {
            
            // 1 - Cria o comando SQL
            String sql = "delete from tb_clientes where id = ?";
            
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
    
    // Lista clientes
    public List<Clientes> listarClientes(){
        
        try {
            
            // 1 - Criar a Lista
            List<Clientes> lista = new ArrayList<>();
            
            // 2 - Criar o comando SQL
            String sql = "select * from tb_clientes";
            
            // 3 - inicia a conexão com banco de dados
            PreparedStatement stmt = con.prepareStatement(sql);
            
            // 4 - Executa o comando SQL e armazena o retorno em rs
            ResultSet rs = stmt.executeQuery();
            
            // Faz um loop na lista e monta um array de objetos
            while (rs.next()) {
                
                Clientes obj = new Clientes();
                
                // obj tem acesso aos metodos setters da classe clientes
                // e aqui eu seto o valor de cada retorno da coluna do banco
                // em um novo objeto que é construido uma cada loop
                // ao final eu inisiro os objetos em uma lista
                
                obj.setId(rs.getInt("id"));
                obj.setNome(rs.getString("nome"));
                obj.setRg(rs.getString("rg"));
                obj.setCpf(rs.getString("cpf"));
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
    
    // Busca de cliente por nome
    public List<Clientes> buscaClientePorNome(String nome){
        
        try {
            
            // 1 criar a lista
            List<Clientes> lista = new ArrayList<>();
            
            // 2 criar o comando SQL
            String sql = "select * from tb_clientes where nome like ?";
            
            // 3 inicia a conexão com o banco de dados
            PreparedStatement stmt = con.prepareStatement(sql);
            
            // 4 seta o parametro nome no parametro esperado no sql em ?
            stmt.setString(1, nome);
            
            // 5 Executa a o sql e retorna a consulta e rs
            ResultSet res = stmt.executeQuery();
            
            // getInt: metodo de ResultSet para acessa o valor do tipo numerico retornado na consulta
            // getString: metodo de ResultSet para acessa o valor do tipo texto retornado na consulta
            
            while(res.next()){
                
                Clientes obj = new Clientes();
                
                obj.setId(res.getInt("id"));
                obj.setNome(res.getString("nome"));
                obj.setRg(res.getString("rg"));
                obj.setCpf(res.getString("cpf"));
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
    
    // Busca cliente por CPF
    public Clientes buscaClientePorCPF(String cpf){
        
        try {
            
            String sql = "select * from tb_clientes where cpf=?";
            
            PreparedStatement stmt = con.prepareStatement(sql);
            
            stmt.setString(1, cpf);
            
            ResultSet res = stmt.executeQuery();
            
            Clientes clientes = new Clientes();
            
            if(res.next()){
                
                clientes.setId(res.getInt("id"));
                clientes.setNome(res.getString("nome"));
                clientes.setRg(res.getString("rg"));
                clientes.setCpf(res.getString("cpf"));
                clientes.setEmail(res.getString("email"));
                clientes.setTelefone(res.getString("telefone"));
                clientes.setCelular(res.getString("celular"));
                clientes.setCep(res.getString("cep"));
                clientes.setEndereco(res.getString("endereco"));
                clientes.setNumero(res.getInt("numero"));
                clientes.setComplemento(res.getString("complemento"));
                clientes.setBairro(res.getString("bairro"));
                clientes.setCidade(res.getString("cidade"));
                clientes.setUf(res.getString("estado"));
                
            }
            
            return clientes;
          
        } catch (SQLException e) {
            
            JOptionPane.showMessageDialog(null, "Erro ao busca CPF"+ e);
            return null;
        }
        
    }
    
    // Busca por CEP
    public Clientes buscaCep(String cep) {
       
        WebServiceCep webServiceCep = WebServiceCep.searchCep(cep);
       

        Clientes obj = new Clientes();

        if (webServiceCep.wasSuccessful()) {
            
            obj.setEndereco(webServiceCep.getLogradouroFull());
            obj.setCidade(webServiceCep.getCidade());
            obj.setBairro(webServiceCep.getBairro());
            obj.setUf(webServiceCep.getUf());
            
            return obj;
            
        } else {
            
            JOptionPane.showMessageDialog(null, "Erro numero: " + webServiceCep.getResulCode());
            JOptionPane.showMessageDialog(null, "Descrição do erro: " + webServiceCep.getResultText());
            return null;
            
        }

    }
    
}
