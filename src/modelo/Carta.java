/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author kccalloc
 */
public class Carta {
    //Atributos
    private int cartaId;
    private String nombre;
    private String descripcion;
    private double precio;
    private double descuento;
    private int categoriaId;
    private String habilitado;
    private String estado;
    private String categoria;

  
    //Constructor
    
    //Constructor
    public Carta() {
    }

    public Carta(int cartaId, String nombre, String descripcion, double precio, double descuento, int categoriaId, String habilitado, String estado, String categoria) {
        this.cartaId = cartaId;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.descuento = descuento;
        this.categoriaId = categoriaId;
        this.habilitado = habilitado;
        this.estado = estado;
        this.categoria=categoria;
    }

    public int getCartaId() {
        return cartaId;
    }

    public void setCartaId(int cartaId) {
        this.cartaId = cartaId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public double getDescuento() {
        return descuento;
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }

    public int getCategoriaId() {
        return categoriaId;
    }

    public void setCategoriaId(int categoriaId) {
        this.categoriaId = categoriaId;
    }

    public String getHabilitado() {
        return habilitado;
    }

    public void setHabilitado(String habilitado) {
        this.habilitado = habilitado;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
      public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

}
