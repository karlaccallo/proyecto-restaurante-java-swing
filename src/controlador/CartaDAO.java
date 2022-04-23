/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import extras.Mensajes;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import modelo.Carta;
import util.Conexionbd;

/**
 *
 * @author kccalloc
 */
public class CartaDAO {
    
     //Retorname Usuarios
    public static ResultSet getDataCarta() {
        ResultSet rs = null;
        try {
            String query = " select cartaid,nombre,p.descripcion,precio,descuento, "
                    + "c.descripcion categoria, p.habilitado, estado from carta p "
                    + "inner join categoria c on p.categoriaid=c.categoriaid";

            PreparedStatement pst = Conexionbd.ConBD().prepareStatement(query);
            rs = pst.executeQuery();
            Conexionbd.cerrarBD(Conexionbd.ConBD());
        } catch (Exception e) {
            Mensajes.msjmuestra("Error al Listar Carta " + e.getMessage());
        }
        return rs;
    }
    public static ResultSet getDataCartaByDescripcion(String cartaDesc) {
        ResultSet rs = null;
        try {
            String query = "select cartaid,nombre,p.descripcion,precio,descuento, "
                     + "c.descripcion categoria, p.habilitado, estado " +
                        "  from carta p inner join categoria c on p.categoriaid=c.categoriaid" +
                        "  where UPPER(p.descripcion) like UPPER('%"+cartaDesc+"%')";
            PreparedStatement pst = Conexionbd.ConBD().prepareStatement(query);

            rs = pst.executeQuery();
            Conexionbd.cerrarBD(Conexionbd.ConBD());
        } catch (Exception e) {
            Mensajes.msjmuestra("Error al Listar Carta " + e.getMessage());
        }
        return rs;
    }
     public static Carta getCartaByID(int cartaId) {

        Carta obj = new Carta();

        try {
             String query = " select cartaid,nombre,p.descripcion,precio,descuento, "
                    + "c.descripcion categoria, p.habilitado, estado from carta p "
                    + "inner join categoria c on p.categoriaid=c.categoriaid where p.cartaid=?";
            PreparedStatement pst = Conexionbd.ConBD().prepareStatement(query);
            pst.setInt(1, cartaId);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                obj.setCartaId(rs.getInt(1));
                obj.setNombre(rs.getString(2));
                obj.setDescripcion(rs.getString(3));
                obj.setPrecio(rs.getDouble(4));
                obj.setDescuento(rs.getDouble(5));
                obj.setCategoria(rs.getString(6));
                obj.setHabilitado(rs.getString(7));
                obj.setEstado(rs.getString(8));
            }
            Conexionbd.cerrarBD(Conexionbd.ConBD());
        } catch (Exception e) {
           
            Mensajes.msjmuestra("Error: " + e.getMessage());
        }
        return obj;
    }

    public static Carta getCartaByNombre(String cartaDesc) {

        Carta obj = new Carta();

        try {
             String query = "select cartaid,nombre,p.descripcion,precio,descuento, "
                     + "c.descripcion categoria, p.habilitado, estado " +
                        "  from carta p inner join categoria c on p.categoriaid=c.categoriaid" +
                        "  where UPPER(p.nombre) = UPPER('"+cartaDesc+"')";
            PreparedStatement pst = Conexionbd.ConBD().prepareStatement(query);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                obj.setCartaId(rs.getInt(1));
                obj.setNombre(rs.getString(2));
                obj.setDescripcion(rs.getString(3));
                obj.setPrecio(rs.getDouble(4));
                obj.setDescuento(rs.getDouble(5));
                obj.setCategoria(rs.getString(6));
                obj.setHabilitado(rs.getString(7));
                obj.setEstado(rs.getString(8));
            }
            Conexionbd.cerrarBD(Conexionbd.ConBD());
        } catch (Exception e) {
           
            Mensajes.msjmuestra("Error BD: " + e.getMessage());
        }
        return obj;
    }
    
    public static ResultSet getDataCategoria() {
        ResultSet rs = null;
        try {
            String query = "select descripcion from categoria";
            PreparedStatement pst = Conexionbd.ConBD().prepareStatement(query);
            rs = pst.executeQuery();
            Conexionbd.cerrarBD(Conexionbd.ConBD());
        } catch (Exception e) {
           
            Mensajes.msjmuestra("Error al Listar usuarios " + e.getMessage());
        }
        return rs;
    }

    public static int getIDcategoriaxDescrpcion(String categoria) {
        int idCategoria = 0;

        try {
            String query = " select categoriaid from categoria where descripcion=?";
            PreparedStatement pst = Conexionbd.ConBD().prepareStatement(query);
            pst.setString(1, categoria);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                idCategoria = (rs.getInt(1));
            }
        } catch (Exception e) {
            
            Mensajes.msjmuestra("Error: " + e.getMessage());
        }
        return idCategoria;
    }
    
    public static boolean newCarta(Carta obj) {
        boolean ok = false;
        try {
            String query = "insert into carta(CartaId,Nombre,Descripcion,Precio,Descuento,"
                    + "CategoriaId,Habilitado,Estado) values(?,?,?,?,?,?,'1',?)";
            PreparedStatement pst = Conexionbd.ConBD().prepareStatement(query);
            pst.setInt(1, generarIdCarta());
            pst.setString(2, obj.getNombre());
            pst.setString(3, obj.getDescripcion());
            pst.setDouble(4, obj.getPrecio());
            pst.setDouble(5, obj.getDescuento());
            pst.setInt(6, obj.getCategoriaId());
            pst.setString(7, obj.getEstado());
            if (pst.executeUpdate() > 0) {
                ok = true;
            }
            Conexionbd.cerrarBD(Conexionbd.ConBD());
        } catch (Exception e) {
           
            Mensajes.msjmuestra("Error al guardar " + e.getMessage());
        }
        return ok;
    }

    public static boolean actualizarCarta(Carta obj) {
        boolean ok = false;

        try {
             String query = "update carta set Nombre=?,Descripcion=?,Precio=?,Descuento=?,CategoriaId=?,estado=?"
                    + " where CartaId=?";
            PreparedStatement pst = Conexionbd.ConBD().prepareStatement(query);
            pst.setString(1, obj.getNombre());
            pst.setString(2, obj.getDescripcion());
            pst.setDouble(3, obj.getPrecio());
            pst.setDouble(4, obj.getDescuento());
            pst.setInt(5, obj.getCategoriaId());
            pst.setString(6, obj.getEstado());
             pst.setInt(7, obj.getCartaId());
             
            if (pst.executeUpdate() > 0) {
                ok = true;
            }
            Conexionbd.cerrarBD(Conexionbd.ConBD());
        } catch (Exception e) {
           
            Mensajes.msjmuestra("Error:" + e.getMessage());
        }
        return ok;
    }
    
    public static int generarIdCarta() {
        int nro = 0;
        try {
            String query = "SELECT MAX(cartaid)+1 AS id FROM carta";
            PreparedStatement pst = Conexionbd.ConBD().prepareStatement(query);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                nro = rs.getInt(1);
            }
            nro = nro + 1;
            Conexionbd.cerrarBD(Conexionbd.ConBD());
        } catch (Exception e) {
          
            Mensajes.msjmuestra("Error al generar id " + e.getMessage());
        }
        return nro;
    }
     public static int getIDCategoriaPorNombre(String categoria) {
        int categoriaid = 0;

        try {
            String query = " select categoriaid from categoria where descripcion=?";
            PreparedStatement pst = Conexionbd.ConBD().prepareStatement(query);
            pst.setString(1, categoria);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                categoriaid = (rs.getInt(1));
            }
        } catch (Exception e) {
            
            Mensajes.msjmuestra("Error: " + e.getMessage());
        }
        return categoriaid;
    }
     
     public static boolean deleteCarta(int cod) {
        boolean ok = false;
        try {
            String query = "delete from carta where cartaid=?";
            PreparedStatement pst = Conexionbd.ConBD().prepareStatement(query);
            pst.setInt(1, cod);

            if (pst.executeUpdate() > 0) {
                ok = true;
            }
            Conexionbd.cerrarBD(Conexionbd.ConBD());
        } catch (Exception e) {
           
            Mensajes.msjmuestra("Error al Eliminar " + e.getMessage());
        }
        return ok;
    }
}
