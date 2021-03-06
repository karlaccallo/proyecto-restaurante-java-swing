/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import extras.Mensajes;
import java.beans.PropertyVetoException;
import javax.swing.JInternalFrame;
import util.Utileria;

public class FrmPrincipal extends javax.swing.JFrame {

    //Vriable Globales de Tipo JIFrame
    IfrmUsuarios oufrmusu;
    IfrmCarta oufrmmcarta;
    IfrmMenu oufrmmmenu;
    IfrmPedidosCocina oufrmmpedSolCocina;
    IfrmNotapedido oufrmNotaPedido;
    Ifrmcomprobante oufrmComprobante;
    IfrmPedidosPendientes oufrmPedidosPendientes;
    IfrmConfiguracionMesas oufrmConfiguracionMesas;
    IfrmReporteVentas oufrmReporteVentas;


    public FrmPrincipal() {
        initComponents();

    }

    //Verificamos si el formulario ya fue abierto
    public boolean estacerrado(Object objetos) {
        JInternalFrame[] finterno = miescritorio.getAllFrames();
        boolean cerrado = true;
        int i = 0;
        while (i < finterno.length && cerrado) {
            if (finterno[i] == objetos) {
                cerrado = false;
            }
            i++;
        }
        return cerrado;
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        miescritorio = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        menuTablas = new javax.swing.JMenu();
        subMenuUsuario = new javax.swing.JMenuItem();
        subMenuMantCarta = new javax.swing.JMenuItem();
        menuMenu = new javax.swing.JMenu();
        subMenuLaCarta = new javax.swing.JCheckBoxMenuItem();
        menuPeticiones = new javax.swing.JMenu();
        subMenuPedidos = new javax.swing.JCheckBoxMenuItem();
        subMenuComprobante = new javax.swing.JCheckBoxMenuItem();
        subMenuPedidosPendientes = new javax.swing.JCheckBoxMenuItem();
        menuCocina = new javax.swing.JMenu();
        subMenuPedidosSolicitados = new javax.swing.JCheckBoxMenuItem();
        menuMesas = new javax.swing.JMenu();
        subMenuConfigMesas = new javax.swing.JCheckBoxMenuItem();
        menuReportes = new javax.swing.JMenu();
        subMenuReporte = new javax.swing.JCheckBoxMenuItem();
        menuSalir = new javax.swing.JMenu();
        jCheckBoxMenuItem1 = new javax.swing.JCheckBoxMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout miescritorioLayout = new javax.swing.GroupLayout(miescritorio);
        miescritorio.setLayout(miescritorioLayout);
        miescritorioLayout.setHorizontalGroup(
            miescritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 516, Short.MAX_VALUE)
        );
        miescritorioLayout.setVerticalGroup(
            miescritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 309, Short.MAX_VALUE)
        );

        menuTablas.setText("Mantenimiento");

        subMenuUsuario.setText("Usuarios");
        subMenuUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subMenuUsuarioActionPerformed(evt);
            }
        });
        menuTablas.add(subMenuUsuario);

        subMenuMantCarta.setText("Carta");
        subMenuMantCarta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subMenuMantCartaActionPerformed(evt);
            }
        });
        menuTablas.add(subMenuMantCarta);

        jMenuBar1.add(menuTablas);

        menuMenu.setText("Menu");

        subMenuLaCarta.setSelected(true);
        subMenuLaCarta.setText("La Carta");
        subMenuLaCarta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subMenuLaCartaActionPerformed(evt);
            }
        });
        menuMenu.add(subMenuLaCarta);

        jMenuBar1.add(menuMenu);

        menuPeticiones.setText("Peticiones");

        subMenuPedidos.setSelected(true);
        subMenuPedidos.setText("Solicitar Pedidos");
        subMenuPedidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subMenuPedidosActionPerformed(evt);
            }
        });
        menuPeticiones.add(subMenuPedidos);

        subMenuComprobante.setSelected(true);
        subMenuComprobante.setText("Generar Comprobante");
        subMenuComprobante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subMenuComprobanteActionPerformed(evt);
            }
        });
        menuPeticiones.add(subMenuComprobante);

        subMenuPedidosPendientes.setSelected(true);
        subMenuPedidosPendientes.setText("Peticiones pendientes");
        subMenuPedidosPendientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subMenuPedidosPendientesActionPerformed(evt);
            }
        });
        menuPeticiones.add(subMenuPedidosPendientes);

        jMenuBar1.add(menuPeticiones);

        menuCocina.setText("Cocina");

        subMenuPedidosSolicitados.setSelected(true);
        subMenuPedidosSolicitados.setText("Pedidos Solicitados");
        subMenuPedidosSolicitados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subMenuPedidosSolicitadosActionPerformed(evt);
            }
        });
        menuCocina.add(subMenuPedidosSolicitados);

        jMenuBar1.add(menuCocina);

        menuMesas.setText("Mesas");

        subMenuConfigMesas.setSelected(true);
        subMenuConfigMesas.setText("Configuracion Mesas");
        subMenuConfigMesas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subMenuConfigMesasActionPerformed(evt);
            }
        });
        menuMesas.add(subMenuConfigMesas);

        jMenuBar1.add(menuMesas);

        menuReportes.setText("Reportes");

        subMenuReporte.setSelected(true);
        subMenuReporte.setText("Reportes ventas");
        subMenuReporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subMenuReporteActionPerformed(evt);
            }
        });
        menuReportes.add(subMenuReporte);

        jMenuBar1.add(menuReportes);

        menuSalir.setText("Salir");

        jCheckBoxMenuItem1.setSelected(true);
        jCheckBoxMenuItem1.setText("Salir");
        jCheckBoxMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxMenuItem1ActionPerformed(evt);
            }
        });
        menuSalir.add(jCheckBoxMenuItem1);

        jMenuBar1.add(menuSalir);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(miescritorio)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(miescritorio)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void subMenuUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subMenuUsuarioActionPerformed
        if (estacerrado(oufrmusu)) {
            oufrmusu = new IfrmUsuarios();
            miescritorio.add(oufrmusu);
            oufrmusu.show();
        } else {
            try {
                oufrmusu.setMaximum(true);
                oufrmusu.setMaximum(false);
            } catch (PropertyVetoException ex) {
                Mensajes.msjmuestra("Error en " + ex.getMessage());
            }
        }
    }//GEN-LAST:event_subMenuUsuarioActionPerformed

    private void subMenuConfigMesasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subMenuConfigMesasActionPerformed

        if (estacerrado(oufrmConfiguracionMesas)) {
            oufrmConfiguracionMesas = new IfrmConfiguracionMesas();
            miescritorio.add(oufrmConfiguracionMesas);
            oufrmConfiguracionMesas.show();
        } else {
            try {
                oufrmConfiguracionMesas.setMaximum(true);
                oufrmConfiguracionMesas.setMaximum(false);
            } catch (PropertyVetoException ex) {
                Mensajes.msjmuestra("Error en " + ex.getMessage());
            }
        }
    }//GEN-LAST:event_subMenuConfigMesasActionPerformed

    private void subMenuPedidosSolicitadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subMenuPedidosSolicitadosActionPerformed
        if (estacerrado(oufrmmpedSolCocina)) {
            oufrmmpedSolCocina = new IfrmPedidosCocina();
            miescritorio.add(oufrmmpedSolCocina);
            oufrmmpedSolCocina.show();
        } else {
            try {
                oufrmmpedSolCocina.setMaximum(true);
                oufrmmpedSolCocina.setMaximum(false);
            } catch (PropertyVetoException ex) {
                Mensajes.msjmuestra("Error en " + ex.getMessage());
            }
        }
    }//GEN-LAST:event_subMenuPedidosSolicitadosActionPerformed

    private void subMenuMantCartaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subMenuMantCartaActionPerformed
        if (estacerrado(oufrmmcarta)) {
            oufrmmcarta = new IfrmCarta();
            miescritorio.add(oufrmmcarta);
            oufrmmcarta.show();
        } else {
            try {
                oufrmmcarta.setMaximum(true);
                oufrmmcarta.setMaximum(false);
            } catch (PropertyVetoException ex) {
                Mensajes.msjmuestra("Error en " + ex.getMessage());
            }
        }
    }//GEN-LAST:event_subMenuMantCartaActionPerformed

    private void subMenuLaCartaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subMenuLaCartaActionPerformed
        if (estacerrado(oufrmmcarta)) {
            oufrmmmenu = new IfrmMenu();
            miescritorio.add(oufrmmmenu);
            oufrmmmenu.show();
        } else {
            try {
                oufrmmmenu.setMaximum(true);
                oufrmmmenu.setMaximum(false);
            } catch (PropertyVetoException ex) {
                Mensajes.msjmuestra("Error en " + ex.getMessage());
            }
        }
    }//GEN-LAST:event_subMenuLaCartaActionPerformed

    private void subMenuPedidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subMenuPedidosActionPerformed
        if (estacerrado(oufrmNotaPedido)) {
            oufrmNotaPedido = new IfrmNotapedido();
            miescritorio.add(oufrmNotaPedido);
            oufrmNotaPedido.show();
        } else {
            try {
                oufrmNotaPedido.setMaximum(true);
                oufrmNotaPedido.setMaximum(false);
            } catch (PropertyVetoException ex) {
                Mensajes.msjmuestra("Error en " + ex.getMessage());
            }
        }
    }//GEN-LAST:event_subMenuPedidosActionPerformed

    private void subMenuComprobanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subMenuComprobanteActionPerformed
        if (estacerrado(oufrmComprobante)) {
            oufrmComprobante = new Ifrmcomprobante();
            miescritorio.add(oufrmComprobante);
            oufrmComprobante.show();
        } else {
            try {
                oufrmComprobante.setMaximum(true);
                oufrmComprobante.setMaximum(false);
            } catch (PropertyVetoException ex) {
                Mensajes.msjmuestra("Error en " + ex.getMessage());
            }
        }
    }//GEN-LAST:event_subMenuComprobanteActionPerformed

    private void subMenuPedidosPendientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subMenuPedidosPendientesActionPerformed

        if (estacerrado(oufrmPedidosPendientes)) {
            oufrmPedidosPendientes = new IfrmPedidosPendientes();
            miescritorio.add(oufrmPedidosPendientes);
            oufrmPedidosPendientes.show();
        } else {
            try {
                oufrmPedidosPendientes.setMaximum(true);
                oufrmPedidosPendientes.setMaximum(false);
            } catch (PropertyVetoException ex) {
                Mensajes.msjmuestra("Error en " + ex.getMessage());
            }
        }
    }//GEN-LAST:event_subMenuPedidosPendientesActionPerformed

    private void jCheckBoxMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxMenuItem1ActionPerformed
        Utileria.salir();
    }//GEN-LAST:event_jCheckBoxMenuItem1ActionPerformed

    private void subMenuReporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subMenuReporteActionPerformed
        if (estacerrado(oufrmReporteVentas)) {
            oufrmReporteVentas = new IfrmReporteVentas();
            miescritorio.add(oufrmReporteVentas);
            oufrmReporteVentas.show();
        } else {
            try {
                oufrmReporteVentas.setMaximum(true);
                oufrmReporteVentas.setMaximum(false);
            } catch (PropertyVetoException ex) {
                Mensajes.msjmuestra("Error en " + ex.getMessage());
            }
        }
    }//GEN-LAST:event_subMenuReporteActionPerformed

//    /**
//     * @param args the command line arguments
//     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new FrmPrincipal().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem1;
    private javax.swing.JMenuBar jMenuBar1;
    public javax.swing.JMenu menuCocina;
    public javax.swing.JMenu menuMenu;
    public javax.swing.JMenu menuMesas;
    public javax.swing.JMenu menuPeticiones;
    public javax.swing.JMenu menuReportes;
    public javax.swing.JMenu menuSalir;
    public javax.swing.JMenu menuTablas;
    private javax.swing.JDesktopPane miescritorio;
    private javax.swing.JCheckBoxMenuItem subMenuComprobante;
    private javax.swing.JCheckBoxMenuItem subMenuConfigMesas;
    private javax.swing.JCheckBoxMenuItem subMenuLaCarta;
    private javax.swing.JMenuItem subMenuMantCarta;
    private javax.swing.JCheckBoxMenuItem subMenuPedidos;
    private javax.swing.JCheckBoxMenuItem subMenuPedidosPendientes;
    private javax.swing.JCheckBoxMenuItem subMenuPedidosSolicitados;
    private javax.swing.JCheckBoxMenuItem subMenuReporte;
    private javax.swing.JMenuItem subMenuUsuario;
    // End of variables declaration//GEN-END:variables
}
