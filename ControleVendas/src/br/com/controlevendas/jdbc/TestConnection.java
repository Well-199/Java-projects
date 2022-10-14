
package br.com.controlevendas.jdbc;

import javax.swing.JOptionPane;


public class TestConnection {
    
    public static void main(String[] args){
        
        try {
            
            new ConnectionFactory().getConnection();
            JOptionPane.showMessageDialog(null, "CONECTADO COM SUCESSO!!!");
            
        } catch (Exception erro){
            
            JOptionPane.showMessageDialog(null, "ERRO AO CONECTAR COM BANCO DE DADOS: " + erro);
            
        }
        
    }
    
}
