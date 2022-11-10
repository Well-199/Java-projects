package br.com.controlevendas.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import br.com.controlevendas.jdbc.ConnectionFactory;
import br.com.controlevendas.model.Fornecedores;
import br.com.controlevendas.model.Produtos;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class ProdutosDao {
    
    private Connection con;
    
    public ProdutosDao() {
        this.con = new ConnectionFactory().getConnection();
    }
    
    // Cadastro de produto
    public void cadastrarProduto(Produtos obj) {
        
        try {
            
            String sql = "insert into tb_produtos "
                    + "(descricao, preco, qtd_estoque, for_id) "
                    + "values (?, ?, ?, ?)";
            
            // Organiza os valores que serao inseridos no sql
            PreparedStatement stmt = con.prepareStatement(sql);
            
            stmt.setString(1, obj.getDescricao());
            stmt.setDouble(2, obj.getPreco());
            stmt.setInt(3, obj.getQtd_estoque());
            stmt.setInt(4, obj.getFornecedor().getId());
            
            // executa o sql
            stmt.execute();
            
            // fecha a conexão
            stmt.close();
            
            JOptionPane.showMessageDialog(null,"Produto Cadastrado com Sucesso!!!");
            
        } catch (SQLException e) {
            
            JOptionPane.showMessageDialog(null,"Erro ao cadastrar produto: "+e);
            
        }
        
    }
    
    // Lista os produtos cadastrados
    public List<Produtos> listarProdutos(){
        
        try {
            
            // 1 - Criar a Lista
            List<Produtos> lista = new ArrayList<>();
            
            // 2 - Criar o comando SQL
            String sql = "select "
                    + "tb_produtos.id, "
                    + "tb_produtos.descricao, "
                    + "tb_produtos.preco, "
                    + "tb_produtos.qtd_estoque, "
                    + "tb_fornecedores.nome "
                    + "from tb_produtos inner join tb_fornecedores "
                    + "on (tb_produtos.for_id = tb_fornecedores.id)";
            
            // 3 - inicia a conexão com banco de dados
            PreparedStatement stmt = con.prepareStatement(sql);
            
            // 4 - Executa o comando SQL e armazena o retorno em rs
            ResultSet rs = stmt.executeQuery();
            
            // Faz um loop na lista e monta um array de objetos
            while (rs.next()) {
                
                Produtos obj = new Produtos();
                Fornecedores f = new Fornecedores();
                
                obj.setId(rs.getInt("tb_produtos.id"));
                obj.setDescricao(rs.getString("tb_produtos.descricao"));
                obj.setPreco(rs.getDouble("tb_produtos.preco"));
                obj.setQtd_estoque(rs.getInt("tb_produtos.qtd_estoque"));
                
                // Pega o nome do fornecedor e seta no objeto fornecedor
                f.setNome(rs.getString("tb_fornecedores.nome"));
                
                // objeto produtos recebe o objeto fornecedores
                obj.setFornecedor(f);
                
                lista.add(obj);
                
            }
            
            return lista;
            
            
        } catch (SQLException erro) {
            
            JOptionPane.showMessageDialog(null, "Erro "+ erro);
            return null;
        }
        
    }
    
    // Método alterar produto
    public void alterarProduto(Produtos obj){
        
        try {
            
            // 1 - Criar o comando SQL
            String sql = "update tb_produtos "
                    + "set descricao=?, preco=?, qtd_estoque=?, for_id=? "
                    + "where id=?";
            
            // 2 - Conectar com o banco de dados
            PreparedStatement stmt = con.prepareStatement(sql);
            
            // 3 - Organizar os valores que serao inseridos no SQL
           stmt.setString(1, obj.getDescricao());
           stmt.setDouble(2, obj.getPreco());
           stmt.setInt(3, obj.getQtd_estoque());
           stmt.setInt(4, obj.getFornecedor().getId());

           stmt.setInt(5, obj.getId());
           
           // 4 - Executar o comando SQL
           stmt.execute();
           
           // 5 - Fechar a conexão com o banco de dados
           stmt.close();
           
            JOptionPane.showMessageDialog(null, "Alterado com sucesso!!!");
            
        } catch (SQLException erro){
            
            JOptionPane.showMessageDialog(null, "Erro ao alterar :( "+ erro);
            
        }
        
    }
    
    // Metodo excluir produto
    public void excluirProduto(Produtos obj) {
        
        try {
            
            String sql = "delete from tb_produtos where id=?";
            
            PreparedStatement stmt = con.prepareStatement(sql);
            
            stmt.setInt(1, obj.getId());
            
            stmt.execute();
            stmt.close();
            
            JOptionPane.showMessageDialog(null, "Excluido com sucesso!!!");
            
        } catch (SQLException e) {
            
            JOptionPane.showMessageDialog(null, "Erro eo excluir: "+e);
            
        }
        
    }
    
    // Busca de Produto por nome
    public List<Produtos> buscaProdutoPorNome(String descricao){
        
        try {
            
            // 1 criar a lista
            List<Produtos> lista = new ArrayList<>();
            
            // 2 criar o comando SQL
            String sql = "select tb_produtos.*, tb_fornecedores.nome "
                    + "from tb_produtos inner join tb_fornecedores "
                    + "on (tb_produtos.for_id=tb_fornecedores.id) where descricao like ?";
            
            // 3 inicia a conexão com o banco de dados
            PreparedStatement stmt = con.prepareStatement(sql);
            
            // 4 seta o parametro nome no parametro esperado no sql em ?
            stmt.setString(1, descricao);
            
            // 5 Executa a o sql e retorna a consulta e rs
            ResultSet res = stmt.executeQuery();
            
            while(res.next()){
                
                Produtos obj = new Produtos();
                Fornecedores f = new Fornecedores();
                
                obj.setId(res.getInt("id"));
                obj.setDescricao(res.getString("descricao"));
                obj.setPreco(res.getDouble("preco"));
                obj.setQtd_estoque(res.getInt("qtd_estoque"));
                
                // Pega o nome do fornecedor e seta no objeto fornecedor
                f.setNome(res.getString("tb_fornecedores.nome"));
                
                // objeto produtos recebe o objeto fornecedores
                obj.setFornecedor(f);
                
                lista.add(obj);
            }
            
            return lista;
            
        } catch (SQLException e) {
            
            JOptionPane.showMessageDialog(null, "Erro na consulta: "+ e);
            return null;
            
        }
         
    }
    
    // Busca Produto por Código
    public Produtos buscaProdutoPorCodigo(int id){
        
        try {
            
            String sql = "select * from tb_produtos where id=?";
            
            PreparedStatement stmt = con.prepareStatement(sql);
            
            stmt.setInt(1, id);
            
            ResultSet res = stmt.executeQuery();
            
            Produtos obj = new Produtos();
            
            if(res.next()){
                
                obj.setId(res.getInt("id"));
                obj.setDescricao(res.getString("descricao"));
                obj.setPreco(res.getDouble("preco"));
                obj.setQtd_estoque(res.getInt("qtd_estoque"));

            }
            
            return obj;
            
        } catch (SQLException e) {
            
            JOptionPane.showMessageDialog(null, "Erro na consulta: "+ e);
            return null;
            
        }
         
    }
    
    // Metodo de baixa no estoque (Atualiza o estoque)
    public void baixaEstoque(int id, int qtd_nova){
        
        try {
            
            String sql = "update tb_produtos set qtd_estoque=? where id=?";
            
            PreparedStatement stmt = con.prepareStatement(sql);
            
            stmt.setInt(1, qtd_nova);
            stmt.setInt(2, id);
           
            stmt.execute();
            stmt.close();
            
        } catch (SQLException e) {
            
            JOptionPane.showMessageDialog(null, "ERRO: "+e);
            
        }
        
    }
    
    // Metodo que retorna o estoque atualizado
    public int retornaEstoqueAtual(int id){
        
        int qtd_estoque = 0;
        
        try {
            
            String sql = "select qtd_estoque from tb_produtos where id=?";
            
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, id);
            
            ResultSet res = stmt.executeQuery();
            
            if(res.next()){
                
                Produtos p = new Produtos();
                
                qtd_estoque = (res.getInt("qtd_estoque"));
                
            }
            
            return qtd_estoque;
            
        } catch (SQLException e) {
            
            JOptionPane.showMessageDialog(null, "ERRO: "+e);
            return qtd_estoque;
            
        }
        
    }
    
}
