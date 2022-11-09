package aulapratica1;

public class ContaCorrenteApp {
    
    public static void main(String[] args) {
        
        ContaCorrente contaCorrente = new ContaCorrente();
        
        contaCorrente.setNumero(2345);
        contaCorrente.setAgencia(3456);
        
        System.out.println(contaCorrente.getNumero()+" - "+contaCorrente.getAgencia());
        
        contaCorrente.setNumero(30000);
        contaCorrente.setAgencia(45678);
        contaCorrente.setLimite(2345.69F);
        
        System.out.println(contaCorrente.getNumero()+" - "+contaCorrente.getAgencia()+" - "+contaCorrente.getLimite());
        
    }
    
}
