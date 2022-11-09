package fundamentos;

import java.util.Scanner;

public class DesafioCalculadora {
    
    public static void main(String[] args) {
        
        Scanner entrada = new Scanner(System.in);
        
        System.out.println("Informe o primeiro número:.... ");
        double num1 = entrada.nextDouble();
        
        System.out.println("Informe o segundo número:.... ");
        double num2 = entrada.nextDouble();
        
        System.out.println("Informe a operação:..... ");
        String op = entrada.next();
        
        double resultado = 0.00;
        
        System.out.println(num1);
        System.out.println(num2);
        System.out.println(op);
        
        if("+".equals(op)) {
            resultado = num1 + num2;
        }
        
        if("-".equals(op)) {
            resultado = num1 - num2;
        }
        
        if("/".equals(op)) {
            resultado = num1 / num2;
        }
        
        if("*".equals(op)) {
            resultado = num1 * num2;
        }
        
        System.out.println("Resultado: "+ String.valueOf(resultado));
        
        
        entrada.close();
        
    }

}
