/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Date;
import jxl.write.DateTime;

/**
 *
 * @author kccalloc
 */
public class DetallePedido {
    //Atributos
    private int cartaId;
    private int numPedido;
    private int cantidad;
    private double precio;
    private double importe;
    private int estadoDetalleId;
    private Date fechaHoraTermino;
    
    private String nombreEstado;
    private String nombrePlato;
    private String descripcionPlato;
    private Date fechaHoraPedido;
    private int mesa;
  
    //Constructor
    
    //Constructor
    public DetallePedido() {
    }

    public DetallePedido(int cartaId, int numPedido, int cantidad, double precio, double importe, int estadoDetalleId, Date fechaHoraTermino, String nombreEstado, String nombrePlato, String descripcionPlato, Date fechaHoraPedido, int mesa) {
        this.cartaId = cartaId;
        this.numPedido = numPedido;
        this.cantidad = cantidad;
        this.precio = precio;
        this.importe = importe;
        this.estadoDetalleId = estadoDetalleId;
        this.fechaHoraTermino = fechaHoraTermino;
        this.nombreEstado = nombreEstado;
        this.nombrePlato = nombrePlato;
        this.descripcionPlato = descripcionPlato;
        this.fechaHoraPedido = fechaHoraPedido;
        this.mesa = mesa;
    }

    public int getCartaId() {
        return cartaId;
    }

    public void setCartaId(int cartaId) {
        this.cartaId = cartaId;
    }

    public int getNumPedido() {
        return numPedido;
    }

    public void setNumPedido(int numPedido) {
        this.numPedido = numPedido;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public double getImporte() {
        return importe;
    }

    public void setImporte(double importe) {
        this.importe = importe;
    }

    public int getEstadoDetalleId() {
        return estadoDetalleId;
    }

    public void setEstadoDetalleId(int estadoDetalleId) {
        this.estadoDetalleId = estadoDetalleId;
    }

    public Date getFechaHoraTermino() {
        return fechaHoraTermino;
    }

    public void setFechaHoraTermino(Date fechaHoraTermino) {
        this.fechaHoraTermino = fechaHoraTermino;
    }

    public String getNombreEstado() {
        return nombreEstado;
    }

    public void setNombreEstado(String nombreEstado) {
        this.nombreEstado = nombreEstado;
    }

    public String getNombrePlato() {
        return nombrePlato;
    }

    public void setNombrePlato(String nombrePlato) {
        this.nombrePlato = nombrePlato;
    }

    public String getDescripcionPlato() {
        return descripcionPlato;
    }

    public void setDescripcionPlato(String descripcionPlato) {
        this.descripcionPlato = descripcionPlato;
    }

    public Date getFechaHoraPedido() {
        return fechaHoraPedido;
    }

    public void setFechaHoraPedido(Date fechaHoraPedido) {
        this.fechaHoraPedido = fechaHoraPedido;
    }

    public int getMesa() {
        return mesa;
    }

    public void setMesa(int mesa) {
        this.mesa = mesa;
    }

    
}
