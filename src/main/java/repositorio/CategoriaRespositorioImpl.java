package repositorio;

import Entities.Categoria;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;

import java.util.List;

@RequestScoped
public class CategoriaRespositorioImpl implements CrudRepositorio<Categoria> {
    @Inject
    private EntityManager em;

    @Override
    public List<Categoria> mostrar() {
        return em.createQuery("Select c from Categoria c", Categoria.class).getResultList();
    }

    @Override
    public Categoria porId(Long id) {
        return em.find(Categoria.class, id);
    }

    @Override
    public void guardar(Categoria categoria) {
         if(categoria.getId() != null && categoria.getId()>0){
            em.merge(categoria);
         }else{
             em.persist(categoria);
         }
    }

    @Override
    public void eliminar(Long id) {
     Categoria categoria = porId(id);
     em.remove(categoria);
    }
}
