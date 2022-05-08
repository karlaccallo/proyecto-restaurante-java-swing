/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.text.ParseException;
import javax.swing.JOptionPane;

/**
 *
 * @author kccalloc
 */
public class Utileria {

    public static java.util.Date getDateUtil(String cadFecha) {
        java.util.Date date = null;
        try {
            date = new java.text.SimpleDateFormat("dd-MM-yyyy").parse(cadFecha);
        } catch (ParseException e) {
            System.out.println("Hubo un error al obtener la fecha" + e.getMessage());
        }
        return date;
    }

    public static String getFechaActualToString() {
        java.util.Date f = new java.util.Date();
        int año = f.getYear() + 1900;
        int mes = f.getMonth() + 1;
        int dia = f.getDate();
        return dia + "-" + mes + "-" + año;
    }
    
    public static void salir(){
        int salir=JOptionPane.showConfirmDialog(null,"Realmente desea salir...?",
                "confirmar salida", 
                JOptionPane.YES_NO_OPTION);
        if(salir==0){
            System.exit(0);
        }else{
             JOptionPane.showMessageDialog(null,"Usted cancelo su salida...");
        }
    }
}
