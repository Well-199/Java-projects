package aulapratica1;

public class ClienteApp {
    
    public static void main(String[] args) {
        
       ClientePF clientePF = new ClientePF();
       ClientePJ clientePJ = new ClientePJ();
       
       clientePF.setNome("Nanda Lira");
       clientePF.setEndereco("Rua agua marinha 144");
       clientePF.setCpf("306.999.333-22");
       
       clientePJ.setNome("Marunaka produtos alimenticios");
       clientePJ.setEndereco("Rua dos bolivianos 380");
       clientePJ.setCnpj("34.013.802/0001-58");
       
       System.out.println(clientePF.getNome()+" - "+clientePF.getEndereco()+" - "+clientePF.getCpf());
       System.out.println(clientePJ.getNome()+" - "+clientePJ.getEndereco()+" - "+clientePJ.getCnpj());
        
    }
    
}
