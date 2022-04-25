/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import extras.Mensajes;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;
import modelo.NotaPedido;
import util.Conexionbd;

/**
 *
 * @author kccalloc
 */
public class NotaPedidoDAO {

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

    public static int grabarPedido(NotaPedido obj) {

        boolean ok = false;
        int numPedido = 0;
        java.util.Date utilDate = new java.util.Date();

        try {
            String query = "insert into NotaPedido values(?,?,?,?,1,'',1)";
            PreparedStatement pst = Conexionbd.ConBD().prepareStatement(query);
            pst.setTimestamp(1, new java.sql.Timestamp(utilDate.getTime()));
            pst.setDouble(2, obj.getMontoPagar());
            pst.setInt(3, obj.getEmpleadoId());
            pst.setInt(4, obj.getNumMesa());

            if (pst.executeUpdate() > 0) {
                ok = true;
                numPedido = getNumeroPedidoRegistrado();
            }
            Conexionbd.cerrarBD(Conexionbd.ConBD());
        } catch (Exception e) {

            Mensajes.msjmuestra("Error:" + e.getMessage());
        }

        return numPedido;
    }

    public static ResultSet getNumeroMesaByNombreCamarero(String camarero) {
        int idEmpleado = UsuarioDAO.getIDempleadoxNombre(camarero);

        ResultSet rs = null;
        try {
            String query = "select numMesa from mesa m inner join MesaCamarero mc on m.MesaId=mc.MesaId "
                    + "where EmpleadoId=? and GETDATE() between FechaInicio and FechaFin";
            PreparedStatement pst = Conexionbd.ConBD().prepareStatement(query);
            pst.setInt(1, idEmpleado);
            rs = pst.executeQuery();
            Conexionbd.cerrarBD(Conexionbd.ConBD());
        } catch (Exception e) {

            Mensajes.msjmuestra("Error: " + e.getMessage());
        }
        return rs;
    }

    public static ResultSet getDetallePedidoByNumeroPedido(int numero) {
        ResultSet rs = null;
        String query = "select c.cartaid,c.descripcion,dp.precio,dp.cantidad, importe from DetallePedido as dp "
                + "inner join carta as c on dp.cartaid=c.cartaid where dp.NumPedido= ?";
        try {
            PreparedStatement pst = Conexionbd.ConBD().prepareStatement(query);
            pst.setInt(1, numero);
            rs = pst.executeQuery();

            Conexionbd.cerrarBD(Conexionbd.ConBD());
        } catch (Exception e) {
            Mensajes.msjmuestra("Error: " + e.getMessage());
        }
        return rs;
    }

    public static double getTotalValorNotaPedidoByNumPedido(int nroPedido) {
        double monto = 0;
        try {
            String query = "SELECT montopagar FROM NotaPedido where numpedido =?";
            PreparedStatement pst = Conexionbd.ConBD().prepareStatement(query);
            pst.setInt(1, nroPedido);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                monto = rs.getDouble(1);
            }
            Conexionbd.cerrarBD(Conexionbd.ConBD());
        } catch (Exception e) {

            Mensajes.msjmuestra("Error al obtener el monto de pedido " + e.getMessage());
        }
        return monto;
    }

    public static boolean actualizarEstadoPedidoToProcesado(int numPedido) {
        boolean ok = false;

        try {
            String query = "update NotaPedido set EstadoId =2 where NumPedido =?";
            PreparedStatement pst = Conexionbd.ConBD().prepareStatement(query);
            pst.setInt(1, numPedido);
            if (pst.executeUpdate() > 0) {
                ok = true;
            }
            Conexionbd.cerrarBD(Conexionbd.ConBD());
        } catch (Exception e) {

            Mensajes.msjmuestra("Error:" + e.getMessage());
        }
        return ok;
    }
}
