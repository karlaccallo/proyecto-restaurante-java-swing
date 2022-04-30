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
import modelo.Usuario;
import util.Conexionbd;

/**
 *
 * @author Kccalloc
 */
public class UsuarioDAO {

    //Metodo Login
    public static int inlogin(Usuario ou) {
        int valor = 0;
        try {
            String query = "SELECT * FROM Usuario WHERE Usuario = ? AND Password = ?";
            PreparedStatement pst = Conexionbd.ConBD().prepareStatement(query);
            pst.setString(1, ou.getUsuario());
            pst.setString(2, ou.getPassword());
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                valor = 1;
            }
            Conexionbd.cerrarBD(Conexionbd.ConBD());
        } catch (Exception e) {

            System.out.println("Error: " + e.getMessage());
            Mensajes.msjmuestra(e.getMessage());
        }
        return valor;
    }

    //Retorname Usuarios
    public static ResultSet getDataUsuario() {
        ResultSet rs = null;
        try {
            String query = "select usuarioID,usuario,password,ISNULL(e.nombre +' '+e.apellido,'') "
                    + "nombres,rol,u.habilitado "
                    + "FROM usuario u left join empleado e on u.empleadoid=e.empleadoid";

            PreparedStatement pst = Conexionbd.ConBD().prepareStatement(query);
            rs = pst.executeQuery();
            Conexionbd.cerrarBD(Conexionbd.ConBD());
        } catch (SQLException e) {

            Mensajes.msjmuestra("Error al Listar Usuarios " + e.getMessage());
        }
        return rs;
    }

    public static int generarCodUsuario() {
        int nro = 0;
        try {
            String query = "SELECT MAX(usuarioid) AS id FROM usuario";
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

    public static boolean newusuario(Usuario ou) {
        boolean ok = false;
        try {
            String query = "insert into usuario(usuario,password,rol,habilitado,empleadoid) values(?,?,?,'1',?)";
            PreparedStatement pst = Conexionbd.ConBD().prepareStatement(query);
            pst.setString(1, ou.getUsuario());
            pst.setString(2, ou.getPassword());
            pst.setString(3, ou.getRol());
            pst.setInt(4, ou.getEmpleadoId());
            if (pst.executeUpdate() > 0) {
                ok = true;
            }
            Conexionbd.cerrarBD(Conexionbd.ConBD());
        } catch (Exception e) {

            Mensajes.msjmuestra("Error al guardar " + e.getMessage());
        }
        return ok;
    }

    public static boolean actualizarUsuario(Usuario ou) {
        boolean ok = false;

        try {
            String query = "update usuario set usuario=?,password=?,rol=?,empleadoid=? where usuarioid=?";
            PreparedStatement pst = Conexionbd.ConBD().prepareStatement(query);
            pst.setString(1, ou.getUsuario());
            pst.setString(2, ou.getPassword());
            pst.setString(3, ou.getRol());
            pst.setInt(4, ou.getEmpleadoId());
            pst.setInt(5, ou.getUsuarioId());
            if (pst.executeUpdate() > 0) {
                ok = true;
            }
            Conexionbd.cerrarBD(Conexionbd.ConBD());
        } catch (Exception e) {

            Mensajes.msjmuestra("Error:" + e.getMessage());
        }
        return ok;
    }

    public static Usuario getUsuarioByID(int codusuario) {

        Usuario u = new Usuario();

        try {
            String query = "select UsuarioID,usuario,password,ISNULL(e.nombre +' '+e.apellido,'') "
                    + "nombres,rol, u.habilitado "
                    + "FROM usuario u left join empleado e on u.empleadoid=e.empleadoid where usuarioid=?";
            PreparedStatement pst = Conexionbd.ConBD().prepareStatement(query);
            pst.setInt(1, codusuario);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                u.setUsuarioId(rs.getInt(1));
                u.setUsuario(rs.getString(2));
                u.setPassword(rs.getString(3));
                u.setEmpleadoName(rs.getString(4));
                u.setRol(rs.getString(5));
                u.setHabilitado(rs.getString(6));
            }
            Conexionbd.cerrarBD(Conexionbd.ConBD());
        } catch (Exception e) {

            Mensajes.msjmuestra("Error: " + e.getMessage());
        }
        return u;
    }

    public static Usuario getUsuarioByNomUsu(String codusuario) {

        Usuario u = new Usuario();

        try {
            String query = "select UsuarioID,usuario,password,ISNULL(e.nombre +' '+e.apellido,'') "
                    + "nombres,rol, u.habilitado "
                    + "FROM usuario u left join empleado e on u.empleadoid=e.empleadoid where usuario=?";
            PreparedStatement pst = Conexionbd.ConBD().prepareStatement(query);
            pst.setString(1, codusuario);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                u.setUsuarioId(rs.getInt(1));
                u.setUsuario(rs.getString(2));
                u.setPassword(rs.getString(3));
                u.setEmpleadoName(rs.getString(4));
                u.setRol(rs.getString(5));
                u.setHabilitado(rs.getString(6));
            }
            Conexionbd.cerrarBD(Conexionbd.ConBD());
        } catch (Exception e) {

            Mensajes.msjmuestra("Error: " + e.getMessage());
        }
        return u;
    }

    public static boolean deleteUsuario(int codusuario) {
        boolean ok = false;
        try {
            String query = "delete from usuario where usuarioid=?";
            PreparedStatement pst = Conexionbd.ConBD().prepareStatement(query);
            pst.setInt(1, codusuario);

            if (pst.executeUpdate() > 0) {
                ok = true;
            }
            Conexionbd.cerrarBD(Conexionbd.ConBD());
        } catch (Exception e) {

            Mensajes.msjmuestra("Error al Eliminar " + e.getMessage());
        }
        return ok;
    }

    public static ResultSet getDataEmpleado() {
        ResultSet rs = null;
        try {
            String query = "select nombre +' ' + apellido as nombres from empleado";
            PreparedStatement pst = Conexionbd.ConBD().prepareStatement(query);
            rs = pst.executeQuery();
            Conexionbd.cerrarBD(Conexionbd.ConBD());
        } catch (Exception e) {

            Mensajes.msjmuestra("Error al Listar usuarios " + e.getMessage());
        }
        return rs;
    }

    public static int getIDempleadoxNombre(String empleado) {
        int idempleado = 0;

        try {
            String query = " select empleadoid from empleado where nombre +' ' + apellido=?";
            PreparedStatement pst = Conexionbd.ConBD().prepareStatement(query);
            pst.setString(1, empleado);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                idempleado = (rs.getInt(1));
            }
        } catch (Exception e) {

            Mensajes.msjmuestra("Error: " + e.getMessage());
        }
        return idempleado;
    }

    public static String getNombreCamareroByNombreUsuario(String usuario) {
        String nombre = "";
        try {
            String query = "select e.nombre +' '+e.apellido nombres FROM usuario u " +
                            "join empleado e on u.empleadoid=e.empleadoid where usuario=?";
            PreparedStatement pst = Conexionbd.ConBD().prepareStatement(query);
            pst.setString(1, usuario);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                nombre = (rs.getString(1));
            }
        } catch (Exception e) {

            Mensajes.msjmuestra("Error: " + e.getMessage());
        }
        return nombre;
    }

}
