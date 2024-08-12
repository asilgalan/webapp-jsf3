package Converters;

import Entities.Categoria;
import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.faces.convert.Converter;
import service.ProductoService;

import java.util.Optional;


@RequestScoped
@Named("categoriaConverter")
public class CategoriaConverter implements Converter<Categoria> {

    @Inject
    private ProductoService service;
    @Override
    public Categoria getAsObject(FacesContext facesContext, UIComponent uiComponent, String id) {
        if(id == null || id.isEmpty()){
            return null;
        }
        Optional<Categoria> categoria=service.porIdCategoria(Long.valueOf(id));

        if(categoria.isPresent()){
            return categoria.get();
        }
          return null;
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Categoria categoria) {
        if(categoria == null){
            return "0";
        }
        return categoria.getId().toString();
    }
}
