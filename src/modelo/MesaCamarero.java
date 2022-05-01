/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.Date;

/**
 *
 * @author kccalloc
 */
public class MesaCamarero {
    
    private Date fechaInicio;
    private Date fechaFin;
    private int empleadoId;
    private int numMesa;
    private String nombreCamarero;

    public MesaCamarero() {
    }

    public MesaCamarero(Date fechaInicio, Date fechaFin, int empleadoId, int numMesa, String nombreCamarero) {
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.empleadoId = empleadoId;
        this.numMesa = numMesa;
        this.nombreCamarero = nombreCamarero;
    }

    
    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
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

    public String getNombreCamarero() {
        return nombreCamarero;
    }

    public void setNombreCamarero(String nombreCamarero) {
        this.nombreCamarero = nombreCamarero;
    }
    
    
}
