/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

//import extras.Mensajes;
import extras.Mensajes;
import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Padin
 */
public class Conexionbd {
 
    //MODIFICAR LOS VALORES SEGUN SU BASE DE DATOS Y USUARIO Y PASSWORD
    public static final String URL = "jdbc:sqlserver://localhost:1433;databaseName=BDRestaurante";
    public static final String USER = "sa";
    public static final String CLAVE = "123456";

    public static Connection ConBD(){

    Connection cn=null;
    
        try{
             Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            cn = (Connection) DriverManager.getConnection(URL, USER, CLAVE);
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return cn;
        
    }   
    
    public static void cerrarBD(Connection cn){
        try {
            if(cn!=null)cn.close();
        } catch (Exception e) {
            Mensajes.msjmuestra(e.getMessage());
        }
    }
    
}
