package service;

import Entities.Categoria;
import Entities.Producto;
import jakarta.ejb.Local;


import java.util.*;

@Local
public interface ProductoService {
    List<Producto> mostrar();
    Optional<Producto> porId(Long id);
    void guardar(Producto producto);
    void eliminar(Long id);
    List<Categoria> listarCategorias();
    Optional<Categoria> porIdCategoria(Long id);
}
