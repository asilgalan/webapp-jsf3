package service;

import Entities.Categoria;
import Entities.Producto;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import repositorio.CrudRepositorio;

import java.util.List;
import java.util.Optional;
@Stateless
public class ProductoServiceImpl implements ProductoService {
    @Inject
    private CrudRepositorio<Producto> repositorio;
    @Inject
    CrudRepositorio<Categoria> categoriaRepositorio;
    @Override
    public List<Producto> mostrar() {
        return repositorio.mostrar();
    }

    @Override
    public Optional<Producto> porId(Long id) {
        try{
            return Optional.of(repositorio.porId(id));
        }catch (Exception e){
            e.printStackTrace();
            return Optional.empty();
        }

    }

    @Override
    public void guardar(Producto producto) {
        repositorio.guardar(producto);
    }

    @Override
    public void eliminar(Long id) {
        repositorio.eliminar(id);
    }

    @Override
    public List<Categoria> listarCategorias() {
        return categoriaRepositorio.mostrar();
    }

    @Override
    public Optional<Categoria> porIdCategoria(Long id) {
        return Optional.ofNullable(categoriaRepositorio.porId(id));
    }
}
