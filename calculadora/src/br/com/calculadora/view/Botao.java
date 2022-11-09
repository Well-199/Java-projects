package br.com.calculadora.view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JButton;

@SuppressWarnings("serial")
public class Botao extends JButton {
	
	// Método construtor recebe o mesmo nome da classe
	public Botao(String texto, Color cor) {
		
		setText(texto);
		setOpaque(true);
		setBackground(cor);
		setFont(new Font("courier", Font.PLAIN, 25));
		setForeground(Color.WHITE);
		setBorder(BorderFactory.createLineBorder(Color.BLACK));
		
	}
	
}
