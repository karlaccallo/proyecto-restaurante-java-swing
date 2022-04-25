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
public class ComprobantePago {

    //Atributos
    private int NumComprobante;
    private Date FechaEmision;
    private int NumPedido;
    private double SubTotal;
    private double IGV;
    private double Total;
    private int ClienteId;
    private int EmpleadoId;
    private int TipoComID;
    private String dniCliente;
    private String estadoPedido;
    //Constructor
    public ComprobantePago() {
    }

    public ComprobantePago(int NumComprobante, Date FechaEmision, int NumPedido, double SubTotal, double IGV, double Total, int ClienteId, int EmpleadoId, int TipoComID, String dniCliente, String estadoPedido) {
        this.NumComprobante = NumComprobante;
        this.FechaEmision = FechaEmision;
        this.NumPedido = NumPedido;
        this.SubTotal = SubTotal;
        this.IGV = IGV;
        this.Total = Total;
        this.ClienteId = ClienteId;
        this.EmpleadoId = EmpleadoId;
        this.TipoComID = TipoComID;
        this.dniCliente = dniCliente;
        this.estadoPedido = estadoPedido;
    }

    public int getNumComprobante() {
        return NumComprobante;
    }

    public void setNumComprobante(int NumComprobante) {
        this.NumComprobante = NumComprobante;
    }

    public Date getFechaEmision() {
        return FechaEmision;
    }

    public void setFechaEmision(Date FechaEmision) {
        this.FechaEmision = FechaEmision;
    }

    public int getNumPedido() {
        return NumPedido;
    }

    public void setNumPedido(int NumPedido) {
        this.NumPedido = NumPedido;
    }

    public double getSubTotal() {
        return SubTotal;
    }

    public void setSubTotal(double SubTotal) {
        this.SubTotal = SubTotal;
    }

    public double getIGV() {
        return IGV;
    }

    public void setIGV(double IGV) {
        this.IGV = IGV;
    }

    public double getTotal() {
        return Total;
    }

    public void setTotal(double Total) {
        this.Total = Total;
    }

    public int getClienteId() {
        return ClienteId;
    }

    public void setClienteId(int ClienteId) {
        this.ClienteId = ClienteId;
    }

    public int getEmpleadoId() {
        return EmpleadoId;
    }

    public void setEmpleadoId(int EmpleadoId) {
        this.EmpleadoId = EmpleadoId;
    }

    public int getTipoComID() {
        return TipoComID;
    }

    public void setTipoComID(int TipoComID) {
        this.TipoComID = TipoComID;
    }

    public String getDniCliente() {
        return dniCliente;
    }

    public void setDniCliente(String dniCliente) {
        this.dniCliente = dniCliente;
    }

    public String getEstadoPedido() {
        return estadoPedido;
    }

    public void setEstadoPedido(String estadoPedido) {
        this.estadoPedido = estadoPedido;
    }

   
}
