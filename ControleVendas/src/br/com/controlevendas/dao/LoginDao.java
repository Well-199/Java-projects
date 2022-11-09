package br.com.controlevendas.dao;

import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.sql.PreparedStatement;
import br.com.controlevendas.jdbc.ConnectionFactory;
import br.com.controlevendas.view.FrmLogin;
import br.com.controlevendas.view.FrmMenu;

public class LoginDao {
    
    private final Connection con;
    
    public LoginDao() {
        this.con = new ConnectionFactory().getConnection();
    }
    
    // Metodo para o funcionario logar no sistema
    public void efetuarLogin(String email, String senha) {
        
        try {
            
            // Cria o caomando SQL
            String sql = "select * from tb_funcionarios where email=? and senha=?";
            
            // Inicia a conaxão coma o banco de dados
            PreparedStatement stmt = con.prepareStatement(sql);
            
            // Organiza o email e a senha que sera enviado como parametro para o SQL
            stmt.setString(1, email);
            stmt.setString(2, senha);
            
            ResultSet res = stmt.executeQuery();
            
            if(res.next()){
                
                JOptionPane.showMessageDialog(null, "Seja bem vindo ao sistema");
                FrmMenu home = new FrmMenu();
                FrmLogin login = new FrmLogin();
                
                // metodo pra esconder a tela de login quando o usuario conseguir acessar a home
                login.dispose();
                
                // Adiciona na variavel publica usuariologado o nome do usuario que retorna na query
                home.usuariologado = res.getString("nome");
                
                // Metodo que abre o painel Home
                home.setVisible(true);
                        
            } else {
                
                JOptionPane.showMessageDialog(null, "usuario /ou senha incorretos");
                
            }
               
        } catch (SQLException e) {
            
            JOptionPane.showMessageDialog(null, "Erro ao tentar efetuar o login "+e);
        }
        
    }
    
}
