package aulapratica1;

public class PessoaApp {
    
    public static void main(String[] args) {
        
        Pessoa pessoa = new Pessoa();
        
        pessoa.setCodigo(10000);
        pessoa.setNome("Wellington");

        System.out.println(pessoa.getCodigo()+" | "+pessoa.getNome());
    }
    
}
