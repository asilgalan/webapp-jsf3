package Entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;


import java.time.LocalDate;

@Entity
@Table(name = "productos")
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     private Long id;
     @Basic
     @NotEmpty(message = "introduza un nombre ")
     private String nombre;
     @NotNull(message = "introduzca el precio")
     @Min(1)
     private int precio;
    @NotEmpty(message = "introduzca el Sku")
    @Size(min=4,max=15)
     private String sku;
    @NotNull(message = "Introduzca la fecha")
     @Column(name ="fecha_registro")
     private LocalDate fechaRegistro;
    @NotNull(message = "Introduzca la categoria")
     @ManyToOne(fetch = FetchType.LAZY)
     private Categoria categoria;

    public Producto() {
    }

    public Producto(String nombre) {
        this.nombre = nombre;
    }

    public Producto(String nombre, int precio, String sku, LocalDate fechaRegistro) {
        this.nombre = nombre;
        this.precio = precio;
        this.sku = sku;
        this.fechaRegistro = fechaRegistro;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public LocalDate getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(LocalDate fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
//    @PrePersist
//    public void prePersist() {
//        fechaRegistro = LocalDate.now();
//    }

    @Override
    public String toString() {
        return "Producto{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", precio=" + precio +
                ", sku='" + sku + '\'' +
                ", fechaRegistro=" + fechaRegistro +
                '}';
    }
}
