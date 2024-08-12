import jakarta.enterprise.context.RequestScoped;
import jakarta.enterprise.inject.Produces;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.PersistenceUnit;

@RequestScoped
public class ProducerEntityManager {

    @PersistenceContext(name="ejemploJpa")
    private EntityManager em;

    @Produces
    @RequestScoped
    public EntityManager getEntityManager() {

        if (em == null) {
            System.out.println("Hubo un error");
            throw new IllegalStateException("EntityManager no está inicializado.");

        }
        return em;
    }
    public void close(){
        if(em.isOpen()){
            em.close();
            System.out.println("Cerrando el EntityManager");
        }
    }
}
