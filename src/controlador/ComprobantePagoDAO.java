/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import extras.Mensajes;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import modelo.ComprobantePago;
import util.Conexionbd;

/**
 *
 * @author kccalloc
 */
public class ComprobantePagoDAO {

    public static int getNumeroPedidoRegistrado() {
        int nroPedido = 0;
        try {
            String query = "SELECT MAX(numPedido) AS numPedido FROM NotaPedido";
            PreparedStatement pst = Conexionbd.ConBD().prepareStatement(query);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                nroPedido = rs.getInt(1);
            }
            Conexionbd.cerrarBD(Conexionbd.ConBD());
        } catch (Exception e) {

            Mensajes.msjmuestra("Error al obtener el numero de pedido " + e.getMessage());
        }
        return nroPedido;
    }

    public static boolean grabarComprobante(ComprobantePago obj) {

        boolean ok = false;
        java.util.Date utilDate = new java.util.Date();
        int idCliente=ComprobantePagoDAO.getIdClienteByDNI(obj.getDniCliente());

        try {
            String query = "insert into ComprobantePago values(?,?,?,?,?,?,?,?)";
            PreparedStatement pst = Conexionbd.ConBD().prepareStatement(query);
            pst.setTimestamp(1, new java.sql.Timestamp(utilDate.getTime()));
            pst.setInt(2, obj.getNumPedido());
            pst.setDouble(3, obj.getSubTotal());
            pst.setDouble(4, obj.getIGV());
            pst.setDouble(5, obj.getTotal());
            pst.setInt(6, idCliente);
            pst.setInt(7, obj.getEmpleadoId());
            pst.setInt(8, obj.getTipoComID());

            if (pst.executeUpdate() > 0) {
                ok = true;
                NotaPedidoDAO.actualizarEstadoPedidoToProcesado(obj.getNumPedido());
            }
            Conexionbd.cerrarBD(Conexionbd.ConBD());
        } catch (Exception e) {
            Mensajes.msjmuestra("Error al grabar comprobante:" + e.getMessage());
        }
        return ok;
    }

    public static String getNombresClienteByDNI(String dni) {
        String nombre = "";

        ResultSet rs = null;
        try {
            String query = "select clientename from cliente where numDoc=?";
            PreparedStatement pst = Conexionbd.ConBD().prepareStatement(query);
            pst.setString(1, dni);
            rs = pst.executeQuery();
             if (rs.next()) {
                nombre = (rs.getString(1));
            }
            Conexionbd.cerrarBD(Conexionbd.ConBD());
        } catch (Exception e) {

            Mensajes.msjmuestra("Error: " + e.getMessage());
        }
        return nombre;
    }
    
    public static int getIdClienteByDNI(String dni) {
        int id = 0;

        ResultSet rs = null;
        try {
            String query = "select clienteId from cliente where numDoc=?";
            PreparedStatement pst = Conexionbd.ConBD().prepareStatement(query);
            pst.setString(1, dni);
            rs = pst.executeQuery();
             if (rs.next()) {
                id = (rs.getInt(1));
            }
            Conexionbd.cerrarBD(Conexionbd.ConBD());
        } catch (Exception e) {

            Mensajes.msjmuestra("Error: " + e.getMessage());
        }
        return id;
    }
    
     public static int generarNumeroComprobante() {
        int numComprobante = 0;
        try {
            String query = "SELECT MAX(NumComprobante) AS NumComprobante FROM ComprobantePago";
            PreparedStatement pst = Conexionbd.ConBD().prepareStatement(query);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                numComprobante = rs.getInt(1)+1;
            }
            Conexionbd.cerrarBD(Conexionbd.ConBD());
        } catch (Exception e) {

            Mensajes.msjmuestra("Error al obtener el numero de comprobante de pago " + e.getMessage());
        }
        return numComprobante;
    }
     
     public static boolean existePedidoGrabado(int numPedido) {
        boolean existe = false;
        
        try {
            String query = "select NumPedido from ComprobantePago c where NumPedido='"+numPedido+"'";
            PreparedStatement pst = Conexionbd.ConBD().prepareStatement(query);
            ResultSet rs = pst.executeQuery();
            existe = rs.next();
            Conexionbd.cerrarBD(Conexionbd.ConBD());
        } catch (Exception e) {
            Mensajes.msjmuestra("Error en base de datos " + e.getMessage());
        }
        return existe;
    }
     
}
