package fundamentos;

public class DesafiosLogicos {
	
	public static void main(String[] args) {
		// Trabalho na terça (V ou F)
		// Trabalho na quinta (V ou F)
		
		boolean trabalho1 = false;
		boolean trabalho2 = true;
		
		boolean comprouTV50 = trabalho1 && trabalho2;
		boolean comprouTV32 = trabalho1 ^ trabalho2;
		
		System.out.println("Comprou TV 50 ? "+ comprouTV50);
		System.out.println("Comprou TV 32 ? "+ comprouTV32);
		
	}
	
}
