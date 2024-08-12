package repositorio;
import java.util.*;
public interface CrudRepositorio <T>{

    List<T> mostrar();
    T porId(Long id);
    void guardar(T t);
    void eliminar(Long id);
}
