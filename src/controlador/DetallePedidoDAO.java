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
import modelo.Carta;
import modelo.DetallePedido;
import util.Conexionbd;

/**
 *
 * @author kccalloc
 */
public class DetallePedidoDAO {
    
     //Retorname Usuarios
    public static ResultSet getDataDetallePedidoSolicitadoCocina() {
        ResultSet rs = null;
        try {
            String query = "select np.numpedido,dp.cartaid, c.Nombre, c.Descripcion, dp.Cantidad, np.FechaHoraSolicitud,"
                    + "np.NumMesa, edp.Descripcion, ct.Descripcion " +
                            "from DetallePedido dp " +
                            "inner join EstadoDetallePedido edp on dp.EstadoDetalleId=edp.EstadoIDetalleId " +
                            "inner join notapedido np on np.NumPedido=dp.NumPedido " +
                            "inner join carta c on c.CartaId=dp.CartaId " +
                            "inner join Categoria ct on ct.CategoriaId=c.CategoriaId " +
                            "where ct.Descripcion not in ('BEBIDAS','POSTRES') " +
                            "and UPPER(edp.Descripcion) in ('iniciado','en proceso') " +
                            "order by np.FechaHoraSolicitud,np.NumMesa";

            PreparedStatement pst = Conexionbd.ConBD().prepareStatement(query);
            rs = pst.executeQuery();
            Conexionbd.cerrarBD(Conexionbd.ConBD());
        } catch (Exception e) {
            Mensajes.msjmuestra("Error al Listar Pedidos " + e.getMessage());
        }
        return rs;
    }
    public static ResultSet getDataEstadoDetallePedido() {
        ResultSet rs = null;
        try {
            String query = "select descripcion from EstadoDetallePedido where habilitado ='1'";
            PreparedStatement pst = Conexionbd.ConBD().prepareStatement(query);

            rs = pst.executeQuery();
            Conexionbd.cerrarBD(Conexionbd.ConBD());
        } catch (Exception e) {
            Mensajes.msjmuestra("Error al Listar Carta " + e.getMessage());
        }
        return rs;
    }
  
    public static boolean actualizarDetallePedido(DetallePedido obj) {
        boolean ok = false;
        
        java.util.Date utilDate = new java.util.Date();
       // java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
        
        try {
             String query = "update DetallePedido set EstadoDetalleId=?, fechahoratermino=?"
                    + " where CartaId=? and NumPedido=?";
            PreparedStatement pst = Conexionbd.ConBD().prepareStatement(query);
            pst.setInt(1, obj.getEstadoDetalleId());
           // pst.setDate(2, sqlDate);
           pst.setTimestamp(2, new java.sql.Timestamp(utilDate.getTime()));
            pst.setInt(3, obj.getCartaId());
            pst.setInt(4, obj.getNumPedido());
             
            if (pst.executeUpdate() > 0) {
                ok = true;
            }
            Conexionbd.cerrarBD(Conexionbd.ConBD());
        } catch (Exception e) {
           
            Mensajes.msjmuestra("Error:" + e.getMessage());
        }
        return ok;
    }

     public static int getIDEstadoPorNombre(String estado) {
        int id = 0;

        try {
            String query = " select EstadoIDetalleId from EstadoDetallePedido where descripcion=?";
            PreparedStatement pst = Conexionbd.ConBD().prepareStatement(query);
            pst.setString(1, estado);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                id = (rs.getInt(1));
            }
        } catch (Exception e) {
            
            Mensajes.msjmuestra("Error: " + e.getMessage());
        }
        return id;
    }
     
        public static DetallePedido getDataDetallePedidoByCartaAndPedido(int idcarta,int numPedido) {
        DetallePedido obj = new DetallePedido();
        ResultSet rs = null;
        try {
            String query = "select np.numpedido,dp.cartaid,c.Nombre, c.Descripcion, dp.Cantidad, edp.Descripcion " +
                            "from DetallePedido dp " +
                            "inner join EstadoDetallePedido edp on dp.EstadoDetalleId=edp.EstadoIDetalleId " +
                            "inner join notapedido np on np.NumPedido=dp.NumPedido " +
                            "inner join carta c on c.CartaId=dp.CartaId " +
                            "where np.numpedido='"+numPedido+"' and  dp.cartaid='"+idcarta+"'";

            PreparedStatement pst = Conexionbd.ConBD().prepareStatement(query);
            rs = pst.executeQuery();
            if (rs.next()) {
                obj.setNumPedido(rs.getInt(1));
                obj.setCartaId(rs.getInt(2));
                obj.setNombrePlato(rs.getString(3));
                obj.setDescripcionPlato(rs.getString(4));
                obj.setCantidad(rs.getInt(5));
                obj.setNombreEstado(rs.getString(6));
            }
            Conexionbd.cerrarBD(Conexionbd.ConBD());
        } catch (Exception e) {
            Mensajes.msjmuestra("Error al Listar Pedidos " + e.getMessage());
        }
        return obj;
    }
}
