package fundamentos;

import javax.swing.JOptionPane;

public class ConversaoStringNumero {
	
	public static void main(String[] args) {
		
		var message1 = "Digite o primeiro numero: ";
		var message2 = "Digite o segundo numero";
		
		String valor1 = JOptionPane.showInputDialog(message1);
		String valor2 = JOptionPane.showInputDialog(message2);
		
		System.out.println(valor1 + valor2);
		
		double numero1 = Double.parseDouble(valor1);
		double numero2 = Double.parseDouble(valor2);
		
		double soma = numero1 + numero2;
		
		System.out.println(soma);
		
	}

}
