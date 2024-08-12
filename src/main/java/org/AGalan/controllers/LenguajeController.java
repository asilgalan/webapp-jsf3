package org.AGalan.controllers;


import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.context.FacesContext;
import jakarta.faces.event.ValueChangeEvent;
import jakarta.inject.Named;


import java.io.Serializable;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

@Named
@SessionScoped
public class LenguajeController implements Serializable {
    private static final long serialVersionUID = 1L;
    private Locale locale;
    private String lenguaje;
    private Map<String,String> lenguajesSoportado;

   @PostConstruct
   public void init() {
       locale= FacesContext.getCurrentInstance().getViewRoot().getLocale();
       lenguajesSoportado=new HashMap<>();
      lenguajesSoportado.put("English","en");
       lenguajesSoportado.put("Spanish","es");
   }

    public void seleccionar(ValueChangeEvent event){
       String nuevo=event.getNewValue().toString();
       lenguajesSoportado.values().forEach( v ->{
           if(v.equals(nuevo)){
               this.locale=new Locale(nuevo);
               FacesContext.getCurrentInstance().getViewRoot().setLocale(this.locale);
           }
       });
    }

    public Locale getLocale() {
        return locale;
    }

    public void setLocale(Locale locale) {
        this.locale = locale;
    }

    public String getLenguaje() {
        return lenguaje;
    }

    public void setLenguaje(String languaje) {
        this.lenguaje = languaje;
    }

    public Map<String, String> getLenguajesSoportado() {
        return lenguajesSoportado;
    }

    public void setLenguajesSoportado(Map<String, String> lenguajesSoportado) {
        this.lenguajesSoportado = lenguajesSoportado;
    }
}
