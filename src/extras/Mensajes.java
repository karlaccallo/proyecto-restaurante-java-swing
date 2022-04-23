/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package extras;

import javax.swing.JOptionPane;

/**
 *
 * @author Padin
 */
public class Mensajes {
    //Metodo que muestra mensajes
    public static void msjmuestra(String contenido){
        JOptionPane.showMessageDialog(null, contenido);
    }
    
      public static String miInput(String contenido){
        String ingreso= JOptionPane.showInputDialog(contenido);
        return ingreso;
    }
    
}
