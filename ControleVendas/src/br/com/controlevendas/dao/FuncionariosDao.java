package br.com.controlevendas.dao;

import java.sql.Connection;
import br.com.controlevendas.jdbc.ConnectionFactory;
import br.com.controlevendas.model.Funcionarios;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

public class FuncionariosDao {
    
    private final Connection con;
    
    // Método construtor que recebe o mesmo nome da classe
    public FuncionariosDao() {
        
        this.con = new ConnectionFactory().getConnection();
        
    }
    
    // Metodo cadastrar funcionario
    public void cadastrarFuncionario(Funcionarios obj){
        
        try {
            
            // 1 - Criar o comando SQL
            String sql = "insert into tb_funcionarios "
                    + "(nome, rg, cpf, email, senha, cargo, nivel_acesso, "
                    + "telefone, celular, cep, "
                    + "endereco, numero, complemento, bairro, cidade, estado) "
                    + "values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            
            // 2 - Conectar com o banco de dados
            PreparedStatement stmt = con.prepareStatement(sql);
            
            // 3 - Organizar os valores que serao inseridos no SQL
           stmt.setString(1, obj.getNome());
           stmt.setString(2, obj.getRg());
           stmt.setString(3, obj.getCpf());
           stmt.setString(4, obj.getEmail());
           stmt.setString(5, obj.getSenha());
           stmt.setString(6, obj.getCargo());
           stmt.setString(7, obj.getNivel_acesso());
           stmt.setString(8, obj.getTelefone());
           stmt.setString(9, obj.getCelular());
           stmt.setString(10, obj.getCep());
           stmt.setString(11, obj.getEndereco());
           stmt.setInt(12, obj.getNumero());
           stmt.setString(13, obj.getComplemento());
           stmt.setString(14, obj.getBairro());
           stmt.setString(15, obj.getCidade());
           stmt.setString(16, obj.getUf());
           
           // 4 - Executar o comando SQL
           stmt.execute();
           
           // 5 - Fechar a conexão com o banco de dados
           stmt.close();
           
            JOptionPane.showMessageDialog(null, "Cadastrado com sucesso!!!");
            
        } catch (SQLException erro){
            
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar :( "+ erro);
            
        }
        
    }
    
    // Metodo listar funcionarios
    public List<Funcionarios> listarFuncionarios(){
        
        try {
            
            // 1 - Criar a Lista
            List<Funcionarios> lista = new ArrayList<>();
            
            // Criar comando SQL
            String sql = "select * from tb_funcionarios";
            
            // Inicia a conexão com o banco
            PreparedStatement stmt = con.prepareStatement(sql);
            
            // Executa o SQL e armazena o retorno
            ResultSet result = stmt.executeQuery();
            
            while(result.next()){
                
                Funcionarios funcionario = new Funcionarios();
                
                funcionario.setId(result.getInt("id"));
                funcionario.setNome(result.getString("nome"));
                funcionario.setRg(result.getString("rg"));
                funcionario.setCpf(result.getString("cpf"));
                funcionario.setEmail(result.getString("email"));
                
                funcionario.setSenha(result.getString("senha"));
                funcionario.setCargo(result.getString("cargo"));
                funcionario.setNivel_acesso(result.getString("nivel_acesso"));
                
                funcionario.setTelefone(result.getString("telefone"));
                funcionario.setCelular(result.getString("celular"));
                funcionario.setCep(result.getString("cep"));
                funcionario.setEndereco(result.getString("endereco"));
                funcionario.setNumero(result.getInt("numero"));
                funcionario.setComplemento(result.getString("complemento"));
                funcionario.setBairro(result.getString("bairro"));
                funcionario.setCidade(result.getString("cidade"));
                funcionario.setUf(result.getString("estado"));
                
                lista.add(funcionario);
                
            }
            
            return lista;
            
            
        } catch (SQLException e) {
            
            JOptionPane.showMessageDialog(null, "Erro ao listar: "+e);
            return null;
            
        }
        
    }
    
    // Metodo Alterar Funcionario
    public void alterarFuncionario(Funcionarios funcionario){
        
        try {
            
            // Cria o comando SQL
            String sql = "update tb_funcionarios set nome=?, rg=?, cpf=?,"
                    + "email=?, senha=?, cargo=?, nivel_acesso=?, telefone=?,"
                    + "celular=?, cep=?, endereco=?, numero=?, complemento=?,"
                    + "bairro=?, cidade=?, estado=? where id=?";
            
            // Iniciar a conexão com o banco de dados
            PreparedStatement stmt = con.prepareStatement(sql);
            
            // Organizar os valores que serão inseridos no banco
            stmt.setString(1, funcionario.getNome());
            stmt.setString(2, funcionario.getRg());
            stmt.setString(3, funcionario.getCpf());
            stmt.setString(4, funcionario.getEmail());
            
            stmt.setString(5, funcionario.getSenha());
            stmt.setString(6, funcionario.getCargo());
            stmt.setString(7, funcionario.getNivel_acesso());
            
            stmt.setString(8, funcionario.getTelefone());
            stmt.setString(9, funcionario.getCelular());
            stmt.setString(10, funcionario.getCep());
            stmt.setString(11, funcionario.getEndereco());
            stmt.setInt(12, funcionario.getNumero());
            stmt.setString(13, funcionario.getComplemento());
            stmt.setString(14, funcionario.getBairro());
            stmt.setString(15, funcionario.getCidade());
            stmt.setString(16, funcionario.getUf());
            
            // prepara o id que sera alterado
            stmt.setInt(17, funcionario.getId());
            
            // após organizar os dados que serao enviados nos parametros esperado no SQL
            // executa o comando SQL
            stmt.execute();
            
            // Como não retorna nada fecha a conexão
            stmt.close();
            
            JOptionPane.showMessageDialog(null, "Alterado com sucesso!!");
            
        } catch (SQLException e) {
            
            JOptionPane.showMessageDialog(null, "Erro ao alterar: "+e);
            
        }
        
    }
    
    // Metodo excluir funcionario
    public void excluirFuncionario(Funcionarios funcionario){
        
        try {
            
            // Cria o comando SQL
            String sql = "delete from tb_funcionarios where id = ?";
            
            // Inicia a conexão com o banco de dados
            PreparedStatement stmt = con.prepareStatement(sql);
            
            // pega o retorno do getId e seta no comando SQL no parametro ?
            stmt.setInt(1, funcionario.getId());
            
            // Executa o comando e fecha a conexão
            stmt.execute();
            stmt.close();
            
        } catch (SQLException e) {
            
            JOptionPane.showMessageDialog(null, "Erro ao excluir: "+e);
            
        }
        
    }
    
    // Busca funcionario por nome
    public List<Funcionarios> buscaFuncionarioPorNome(String nome){
        
        try {
            
            // 1 criar a lista
            List<Funcionarios> lista = new ArrayList<>();

            // cria o sql e organiza os dados
            String sql = "select * from tb_funcionarios where nome like ?";

            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, nome);

            ResultSet res = stmt.executeQuery();
            
            while(res.next()){
                
                Funcionarios funcionario = new Funcionarios();
                
                funcionario.setId(res.getInt("id"));
                funcionario.setNome(res.getString("nome"));
                funcionario.setRg(res.getString("rg"));
                funcionario.setCpf(res.getString("cpf"));
                funcionario.setEmail(res.getString("email"));
                
                funcionario.setSenha(res.getString("senha"));
                funcionario.setCargo(res.getString("cargo"));
                funcionario.setNivel_acesso(res.getString("nivel_acesso"));
                
                funcionario.setTelefone(res.getString("telefone"));
                funcionario.setCelular(res.getString("celular"));
                funcionario.setCep(res.getString("cep"));
                funcionario.setEndereco(res.getString("endereco"));
                funcionario.setNumero(res.getInt("numero"));
                funcionario.setComplemento(res.getString("complemento"));
                funcionario.setBairro(res.getString("bairro"));
                funcionario.setCidade(res.getString("cidade"));
                funcionario.setUf(res.getString("estado"));
                
                lista.add(funcionario);
                
            }
            
            return lista;
            
        } catch (SQLException e) {
            
            JOptionPane.showMessageDialog(null, "Erro ao listar dados"+e);
            return null;
            
        }
        
    }
    
    // Busca Funcionarios por CPF
    public Funcionarios buscaFuncionarioPorCPF(String cpf){
        
        try {
            
            String sql = "select * from tb_funcionarios where cpf=?";
            
            PreparedStatement stmt = con.prepareStatement(sql);
            
            stmt.setString(1, cpf);
            
            ResultSet res = stmt.executeQuery();
            
            Funcionarios funcionarios = new Funcionarios();
            
            if(res.next()){
                
                funcionarios.setId(res.getInt("id"));
                funcionarios.setNome(res.getString("nome"));
                funcionarios.setRg(res.getString("rg"));
                funcionarios.setCpf(res.getString("cpf"));
                funcionarios.setEmail(res.getString("email"));
                
                funcionarios.setSenha(res.getString("senha"));
                funcionarios.setCargo(res.getString("cargo"));
                funcionarios.setNivel_acesso(res.getString("nivel_acesso"));
            
                funcionarios.setTelefone(res.getString("telefone"));
                funcionarios.setCelular(res.getString("celular"));
                funcionarios.setCep(res.getString("cep"));
                funcionarios.setEndereco(res.getString("endereco"));
                funcionarios.setNumero(res.getInt("numero"));
                funcionarios.setComplemento(res.getString("complemento"));
                funcionarios.setBairro(res.getString("bairro"));
                funcionarios.setCidade(res.getString("cidade"));
                funcionarios.setUf(res.getString("estado"));
                
            }
            
            return funcionarios;
          
        } catch (SQLException e) {
            
            JOptionPane.showMessageDialog(null, "Erro ao busca CPF"+ e);
            return null;
        }
        
    }
    
    // Busca cep
    public Funcionarios buscaCep(String cep){
        
        Funcionarios obj = new Funcionarios();
        
        return obj;
    }
}
