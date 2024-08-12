package org.AGalan.controllers;


import Entities.Categoria;
import Entities.Producto;
import jakarta.enterprise.context.RequestScoped;
import jakarta.enterprise.inject.Model;
import jakarta.enterprise.inject.Produces;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import service.ProductoService;


import java.util.*;
import java.util.stream.Collectors;

@RequestScoped
@Named("productoController")
public class ProductoController {
private List<Producto>  productosEncontrados=new ArrayList<>();
    private String searchTerm;
    private Producto producto;
    private Long id;
    @Inject
    private ProductoService service;
    @Inject
    private FacesContext facesContext;
    @Produces
    @Model
    public String titulo(){
        return "JavaServer Faces ";
    }
    @Produces
    @RequestScoped
    @Named("listado")
    public List<Producto> productoList(){
     return service.mostrar();

    }
    @Produces
    @Model
    public List<Categoria> categoriaList(){
        return service.listarCategorias();
    }
    @Produces
    @Model
    public  Producto producto(){
        this.producto=new Producto();

        if(id !=null && id>0){
           service.porId(id).ifPresent(p -> {
                this.producto=p;
            });
        }
           return  producto;


    }
public String editar(Long id){
        this.id=id;
        return "form.xhtml";
}
    public String guardar(){
        System.out.println(producto);
        service.guardar(producto);
        if(producto.getId() !=null && producto.getId()>0){
            facesContext.addMessage(null,new FacesMessage("Producto "+producto.getNombre()+ " actualizado con exito"));
        }else{
            facesContext.addMessage(null,new FacesMessage("Producto "+producto.getNombre()+ " guardado con exito"));
        }
        return "index";
    }
public String eliminar(Producto producto){
        service.eliminar(producto.getId());
    facesContext.addMessage(null,new FacesMessage("Producto "+producto.getNombre()+ " eliminado con exito"));
        return "index";
}

    public String buscar() {
        productosEncontrados = productoList().stream()
                .filter(p -> p.getNombre() != null && p.getNombre().equalsIgnoreCase(searchTerm))
                .collect(Collectors.toList());

        if (!productosEncontrados.isEmpty()) {
            return "buscar";
        } else {
            facesContext.addMessage(null, new FacesMessage("El Producto con nombre '" + searchTerm + "' no existe"));
            return "index";
        }
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSearchTerm() {
        return searchTerm;
    }

    public void setSearchTerm(String searchTerm) {
        this.searchTerm = searchTerm;
    }

    public List<Producto> getProductosEncontrados() {
        return productosEncontrados;
    }

    public void setProductosEncontrados(List<Producto> productosEncontrados) {
        this.productosEncontrados = productosEncontrados;
    }
}
