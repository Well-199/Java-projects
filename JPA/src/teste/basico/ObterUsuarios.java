package teste.basico;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import modelo.basico.Usuario;

public class ObterUsuarios {
    
    public static void main(String[] args) {
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA");
        EntityManager em = emf.createEntityManager();
        
        String jpql = "select u from Usuario u";
        TypedQuery<Usuario> query = em.createQuery(jpql, Usuario.class);
        query.setMaxResults(5);
        
        List<Usuario> usuarios = query.getResultList();
        
        for(Usuario usuario: usuarios){
            
            Long id = usuario.getId();
            String nome = usuario.getNome();
            String email = usuario.getEmail();
            
            System.out.println("ID: "+ id + " | Nome: "+ nome + " | E-mail: "+ email);
            
        }
        
        em.close();
        emf.close();
        
    }
    
}
