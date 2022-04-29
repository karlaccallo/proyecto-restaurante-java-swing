/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.text.ParseException;

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
}
