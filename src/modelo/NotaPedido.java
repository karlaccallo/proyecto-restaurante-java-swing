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
public class NotaPedido {

    //Atributos
    private Date fechaHoraPedido;
    private double montoPagar;
    private int empleadoId;
    private int numMesa;
    private int estadoId;
    private String observacion;
    private int clienteId;

    //Constructor
    public NotaPedido() {
    }

    public NotaPedido(Date fechaHoraPedido, double montoPagar, int empleadoId, int numMesa, int estadoId, String observacion, int clienteId) {
        this.fechaHoraPedido = fechaHoraPedido;
        this.montoPagar = montoPagar;
        this.empleadoId = empleadoId;
        this.numMesa = numMesa;
        this.estadoId = estadoId;
        this.observacion = observacion;
        this.clienteId = clienteId;
    }

    public Date getFechaHoraPedido() {
        return fechaHoraPedido;
    }

    public void setFechaHoraPedido(Date fechaHoraPedido) {
        this.fechaHoraPedido = fechaHoraPedido;
    }

    public double getMontoPagar() {
        return montoPagar;
    }

    public void setMontoPagar(double montoPagar) {
        this.montoPagar = montoPagar;
    }

    public int getEmpleadoId() {
        return empleadoId;
    }

    public void setEmpleadoId(int empleadoId) {
        this.empleadoId = empleadoId;
    }

    public int getNumMesa() {
        return numMesa;
    }

    public void setNumMesa(int numMesa) {
        this.numMesa = numMesa;
    }

    public int getEstadoId() {
        return estadoId;
    }

    public void setEstadoId(int estadoId) {
        this.estadoId = estadoId;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public int getClienteId() {
        return clienteId;
    }

    public void setClienteId(int clienteId) {
        this.clienteId = clienteId;
    }

}
