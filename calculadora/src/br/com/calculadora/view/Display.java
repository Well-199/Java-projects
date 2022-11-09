package br.com.calculadora.view;

import java.awt.Color;

import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

import br.com.calculadora.model.Memoria;
import br.com.calculadora.model.MemoriaObservador;

@SuppressWarnings("serial")
public class Display extends JPanel implements MemoriaObservador {
	
	private final JLabel label;
	
	// CONSTRUTOR RECEBE O MESMO NOME DA CLASSE Display
	public Display() {
		
		// Se fosse passa o nome da cor tipo GRAY usaria apenas Color
		// Mas como passo parametros tenho que usar o new para construir o objeto
		setBackground(new Color(46, 49, 50));
		
		label = new JLabel(Memoria.getInstancia().getTextoAtual());
		label.setForeground(Color.WHITE);
		label.setFont(new Font("courier", Font.PLAIN, 30));
		
		setLayout(new FlowLayout(FlowLayout.RIGHT, 10, 22));
		
		// Metodo add do JPanel adicina o label na tela
		add(label);
		
	}
	
	@Override
	public void valorAlterado(String novoValor) {
		
	}

}
