package fundamentos;

public class TipoStringEquals {
	
	public static void main(String[] args) {
		
		System.out.println("2" == "2");
		
		String s = new String("2");
		
		// Metodo equals analiza só o conteudo e não a estrutura 
		// um é objeto o outro uma variavel mas o conteudo é o mesmo a estrutura não
		System.out.println("2".equals(s));
		
	}
	
}
