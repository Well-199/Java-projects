package teste.basico;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import modelo.basico.Usuario;

public class AlterarUsuario1 {
    
    public static void main(String[] args) {
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA");
        EntityManager em = emf.createEntityManager();
        
        em.getTransaction().begin();
        
        Usuario usuario = em.find(Usuario.class, 1L);
        
        em.getTransaction().commit();
        
        System.out.println(usuario.getEmail());
        
        usuario.setNome("Fer");
        usuario.setEmail("fer@gmail.com");
        
        em.merge(usuario);
        
        String nome = usuario.getNome();
        String email = usuario.getEmail();
        
        System.out.println(nome+" | "+email);
        
        em.close();
        emf.close();
        
    }
    
}
