/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import extras.Mensajes;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import modelo.MesaCamarero;
import util.Conexionbd;

/**
 *
 * @author kccalloc
 */
public class MesaCamareroDAO {
    
    
    public static ResultSet getDataNumeroMesas() {
       
        ResultSet rs = null;
        try {
            String query = "select numMesa from mesa";
            PreparedStatement pst = Conexionbd.ConBD().prepareStatement(query);
            rs = pst.executeQuery();
            Conexionbd.cerrarBD(Conexionbd.ConBD());
        } catch (Exception e) {

            Mensajes.msjmuestra("Error: " + e.getMessage());
        }
        return rs;
    }
    
     public static ResultSet getDataMesaCamarero() {
        ResultSet rs = null;
        try {
            String query = "select m.NumMesa, e.Nombre +' '+e.Apellido as Camarero, mc.FechaInicio, mc.FechaFin" +
                            " from MesaCamarero mc inner join Mesa m on m.MesaId=mc.MesaId" +
                            " inner join empleado e on e.EmpleadoId=mc.EmpleadoId order by FechaInicio desc";

            PreparedStatement pst = Conexionbd.ConBD().prepareStatement(query);
            rs = pst.executeQuery();
            Conexionbd.cerrarBD(Conexionbd.ConBD());
        } catch (Exception e) {
            Mensajes.msjmuestra("Error al Listar las configuraciones de mesas y camareros " + e.getMessage());
        }
        return rs;
    }
     
      public static boolean grabarConfiguracionMesaCamarero(MesaCamarero obj) {

        boolean ok = false;
        Date inicio= obj.getFechaInicio();
        Date fin= obj.getFechaFin();
        inicio.setHours(0);
        inicio.setMinutes(0);
        inicio.setSeconds(0);
        fin.setHours(23);
        fin.setMinutes(58);
        fin.setSeconds(58);
        
        try {
            String query = "insert into MesaCamarero values(?,?,?,?)";
            PreparedStatement pst = Conexionbd.ConBD().prepareStatement(query);
            pst.setInt(1, obj.getNumMesa());
            pst.setInt(2, obj.getEmpleadoId());
            pst.setTimestamp(3, new java.sql.Timestamp(inicio.getTime()));
            pst.setTimestamp(4, new java.sql.Timestamp(fin.getTime()));
            
            if (pst.executeUpdate() > 0) {
                ok = true;
            }
            Conexionbd.cerrarBD(Conexionbd.ConBD());
        } catch (SQLException e) {

            Mensajes.msjmuestra("Error en base de datos:" + e.getMessage());
        }
        return ok;
    }
      
      public static ResultSet getDataMesaCamareroByInicioFin(Date inicio, Date fin) {
        ResultSet rs = null;
        inicio.setHours(-1);
        inicio.setMinutes(0);
        inicio.setSeconds(0);
        fin.setHours(23);
        fin.setMinutes(58);
        fin.setSeconds(58);
        
        try {
            String query = "select m.NumMesa, e.Nombre +' '+e.Apellido as Camarero, mc.FechaInicio, mc.FechaFin" +
                            " from MesaCamarero mc inner join Mesa m on m.MesaId=mc.MesaId" +
                            " inner join empleado e on e.EmpleadoId=mc.EmpleadoId "
                             + " where FechaInicio between ? and ?"
                            + " order by FechaInicio desc";

            PreparedStatement pst = Conexionbd.ConBD().prepareStatement(query);
            pst.setTimestamp(1, new java.sql.Timestamp(inicio.getTime()));
            pst.setTimestamp(2, new java.sql.Timestamp(fin.getTime()));
            rs = pst.executeQuery();
            Conexionbd.cerrarBD(Conexionbd.ConBD());
        } catch (Exception e) {
            Mensajes.msjmuestra("Error al Listar las configuraciones de mesas y camareros " + e.getMessage());
        }
        return rs;
    }
      
      public static ResultSet getDataReporteVentasByInicioFin(Date inicio, Date fin) {
        ResultSet rs = null;
        inicio.setHours(0);
        inicio.setMinutes(0);
        inicio.setSeconds(0);
        fin.setHours(23);
        fin.setMinutes(58);
        fin.setSeconds(58);
        
        try {
            String query = "select e.Nombre+' '+e.Apellido CAMARERO, np.NumMesa MESA,COUNT(c.NumComprobante) CANTIDAD, SUM(c.Total) MONTO " +
                            "from ComprobantePago c " +
                            "inner join Empleado e on c.EmpleadoId=e.EmpleadoId " +
                            "inner join NotaPedido np on np.NumPedido=c.NumPedido " +
                            "where c.FechaEmision between ? and ? " +
                            "group by e.Nombre+' '+e.Apellido, np.NumMesa " +
                            "order by np.NumMesa";

            PreparedStatement pst = Conexionbd.ConBD().prepareStatement(query);
            pst.setTimestamp(1, new java.sql.Timestamp(inicio.getTime()));
            pst.setTimestamp(2, new java.sql.Timestamp(fin.getTime()));
            rs = pst.executeQuery();
            Conexionbd.cerrarBD(Conexionbd.ConBD());
        } catch (Exception e) {
            Mensajes.msjmuestra("Error al traer reporte de ventas " + e.getMessage());
        }
        return rs;
    }
}
