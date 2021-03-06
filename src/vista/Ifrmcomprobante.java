/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.UsuarioDAO;
import controlador.NotaPedidoDAO;
import controlador.ComprobantePagoDAO;
import controlador.DetallePedidoDAO;
import extras.Mensajes;
import static extras.Mensajes.miInput;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ButtonGroup;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import javax.swing.table.DefaultTableModel;
import modelo.ComprobantePago;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;
import util.Conexionbd;
import util.Utileria;

/**
 *
 * @author alumno
 */
public class Ifrmcomprobante extends javax.swing.JInternalFrame {

    String dniCliente;
    int cont;
    int numpedi;
    int tipoComprobante = 0;

    ButtonGroup bg = new ButtonGroup();
    DefaultTableModel mdl = new DefaultTableModel();

    public Ifrmcomprobante() {
        initComponents();

        btngrabar.setEnabled(false);
        btnImprimir.setEnabled(false);
        bg.add(rbdbol);
        bg.add(rbdfact);
    }

    private void cabeceraDetalle() {
        tbldata.setModel(mdl);
        mdl.addColumn("CODIGO");
        mdl.addColumn("DESCRIPCION");
        mdl.addColumn("PRECIO");
        mdl.addColumn("CANTIDAD");
        mdl.addColumn("IMPORTE");

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btngrabar = new javax.swing.JButton();
        txttotal = new javax.swing.JTextField();
        txtigv = new javax.swing.JTextField();
        txtsubtotal = new javax.swing.JTextField();
        lblnumero = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        lblcli = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtfecha = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbldata = new javax.swing.JTable();
        btnlimp1 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnbuscar = new javax.swing.JButton();
        rbdbol = new javax.swing.JRadioButton();
        rbdfact = new javax.swing.JRadioButton();
        btnpedido = new javax.swing.JButton();
        lblempleado = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        btnImprimir = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Sistema de ventas SVA 1.1 / Formulario de Comprobante");
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameOpened(evt);
            }
        });

        btngrabar.setText("Grabar Comprobante");
        btngrabar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btngrabarActionPerformed(evt);
            }
        });

        lblnumero.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel1.setText("NUMERO:");

        jLabel5.setText("Fecha de Registro :");

        jLabel9.setText("Camarero:");

        lblcli.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel6.setText("Cliente :");

        txtfecha.setEditable(false);

        tbldata.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tbldata);

        btnlimp1.setText("Limpiar");
        btnlimp1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnlimp1ActionPerformed(evt);
            }
        });

        jLabel8.setText("Tipo :");

        jLabel12.setText("Total :  S/.");

        jLabel13.setText("IGV:  S/.");

        jLabel2.setText("Subtotal : S/.");

        btnbuscar.setText("Buscar...");
        btnbuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbuscarActionPerformed(evt);
            }
        });

        rbdbol.setText("Boleta");

        rbdfact.setText("Factura");

        btnpedido.setText("Cargar Pedido");
        btnpedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnpedidoActionPerformed(evt);
            }
        });

        lblempleado.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btnImprimir.setText("Imprimir Comprobante");
        btnImprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImprimirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jScrollPane1))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btngrabar, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnImprimir, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnlimp1, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(lblnumero, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lblcli, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(rbdfact))
                                        .addGap(18, 18, 18)
                                        .addComponent(btnbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(rbdbol)
                                            .addGap(425, 425, 425))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtfecha, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lblempleado, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(btnpedido, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(536, 536, 536)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtsubtotal, javax.swing.GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE)
                                    .addComponent(txtigv)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                                .addComponent(txttotal, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtfecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(lblempleado, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(lblnumero, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel6)
                                .addComponent(btnbuscar))
                            .addComponent(lblcli, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(rbdbol)
                            .addComponent(rbdfact)
                            .addComponent(btnpedido))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btngrabar)
                    .addComponent(btnlimp1)
                    .addComponent(btnImprimir))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtsubtotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(txtigv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txttotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addContainerGap(54, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private String getNombreClienteByDNI(String dni) {
        String cliente = ComprobantePagoDAO.getNombresClienteByDNI(dni);
        return cliente;
    }

    private void grabar() {

        if (rbdbol.isSelected() == true) {
            tipoComprobante = 1;
        }
        if (rbdfact.isSelected() == true) {
            tipoComprobante = 2;
        }

        ComprobantePago obj = new ComprobantePago();
        obj.setTotal(Double.parseDouble(txttotal.getText()));
        obj.setSubTotal(Double.parseDouble(txtsubtotal.getText()));
        obj.setIGV(Double.parseDouble(txtigv.getText()));
        obj.setNumPedido(numpedi);
        obj.setEmpleadoId(NotaPedidoDAO.getIDempleadoxNumPedido(numpedi));
        obj.setDniCliente(dniCliente);
        obj.setTipoComID(tipoComprobante);

        try {
            ComprobantePagoDAO.grabarComprobante(obj);
            System.out.println("vista.IfrmComprobante.grabar()--Grabado Correctamente!!!");
            Mensajes.msjmuestra("Comprobante grabado correctamente!!!");

        } catch (Exception e) {
            System.out.println("vista.IfrmComprobante.grabar()--Error View al grabar!!!");
        }
    }

    private void limpiar() {
        mdl.setRowCount(0);
        mdl.setColumnCount(0);
        this.cabeceraDetalle();
        txtigv.setText("");
        txtsubtotal.setText("");
        txttotal.setText("");
        btngrabar.setEnabled(false);
        btnImprimir.setEnabled(false);
       lblnumero.setText("" + ComprobantePagoDAO.generarNumeroComprobante());
    }

    //////////////////////////
    private void btngrabarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btngrabarActionPerformed
        if (rbdbol.isSelected() == false && rbdfact.isSelected() == false) {
            Mensajes.msjmuestra("Favor de selecionar un tipo de comprobante");
            return;
        }
        if (lblcli.getText().length() == 0) {
            Mensajes.msjmuestra("Favor de elegir un cliente");
        } else {
            if (ComprobantePagoDAO.existePedidoGrabado(numpedi)) {
                Mensajes.msjmuestra("El pedido indicado ya tiene comprobante de pago generado!!!");
            } else {
                this.grabar();
                 btnImprimir.setEnabled(true);
            }

        }
    }//GEN-LAST:event_btngrabarActionPerformed

    private void btnlimp1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnlimp1ActionPerformed
        lblcli.setText("");
        limpiar();
    }//GEN-LAST:event_btnlimp1ActionPerformed

    private void formInternalFrameOpened(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameOpened

        txtfecha.setText(Utileria.getFechaActualToString());
        FrmLogin oa = new FrmLogin();
        String nombreUsuario = oa.nombUsu;
        lblempleado.setText(UsuarioDAO.getNombreCamareroByNombreUsuario(nombreUsuario));
        lblnumero.setText("" + ComprobantePagoDAO.generarNumeroComprobante());

        txtigv.setEditable(false);
        txtsubtotal.setEditable(false);
        txttotal.setEditable(false);
        this.cabeceraDetalle();

    }//GEN-LAST:event_formInternalFrameOpened

    private void btnbuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbuscarActionPerformed
        dniCliente = miInput("Ingrese DNI de Cliente");
        lblcli.setText(this.getNombreClienteByDNI(dniCliente));

    }//GEN-LAST:event_btnbuscarActionPerformed
    private void llenandoDetalle() {

        try {
            ResultSet rs = DetallePedidoDAO.getDetallePedidoByNumeroPedido(numpedi);
            int column = 5;
            Object data[] = new Object[column];
            while (rs.next()) {
                for (int i = 0; i < column; i++) {
                    data[i] = rs.getString(i + 1);
                }
                mdl.addRow(data);
            }

        } catch (Exception e) {
            Mensajes.msjmuestra("Error al obtener los detalles del comprobante " + e.getMessage());
        }
    }
    private void btnpedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnpedidoActionPerformed

        String pedido = miInput("Ingrese numero de pedido a cargar...");

        if (pedido.equals("")) {
            Mensajes.msjmuestra("Favor de ingresar n??mero de pedido");
        } else {
            limpiar();

            try {
                numpedi = Integer.parseInt(pedido);
                this.llenandoDetalle();
                double total = NotaPedidoDAO.getTotalValorNotaPedidoByNumPedido(numpedi);
                double igv = Math.round(((total * 0.18)*100.0)/100.0);
                txtsubtotal.setText("" + (total - igv));
                txtigv.setText("" + igv);
                txttotal.setText("" + total);
                if (total > 0) {
                    btngrabar.setEnabled(true);
                } else {
                    Mensajes.msjmuestra("N??mero de pedido no existe");
                }
            } catch (NumberFormatException e) {

                Mensajes.msjmuestra("Favor de ingresar un n??mero de pedido v??lido");
                System.out.println("vista.IfrmComprobante.obtenerpedido()" + e.getMessage());
            }
        }
    }//GEN-LAST:event_btnpedidoActionPerformed

    private void btnImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImprimirActionPerformed
         try {
            JasperReport reporte = null;
            String path = System.getProperty("user.dir")+"\\src\\reportes\\comprobante.jasper";
            reporte = (JasperReport)JRLoader.loadObjectFromFile(path);
          
            Map parametro=new HashMap();
            parametro.put("numero", Integer.parseInt(lblnumero.getText()));
            JasperPrint jprint = JasperFillManager.fillReport(reporte, parametro, Conexionbd.ConBD());
            JasperViewer view = new JasperViewer(jprint, false);
            view.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            view.setVisible(true);
        } catch (JRException ex) {
            Logger.getLogger(IfrmMenu.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_btnImprimirActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnImprimir;
    private javax.swing.JButton btnbuscar;
    private javax.swing.JButton btngrabar;
    private javax.swing.JButton btnlimp1;
    private javax.swing.JButton btnpedido;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblcli;
    private javax.swing.JLabel lblempleado;
    private javax.swing.JLabel lblnumero;
    private javax.swing.JRadioButton rbdbol;
    private javax.swing.JRadioButton rbdfact;
    private javax.swing.JTable tbldata;
    private javax.swing.JTextField txtfecha;
    private javax.swing.JTextField txtigv;
    private javax.swing.JTextField txtsubtotal;
    private javax.swing.JTextField txttotal;
    // End of variables declaration//GEN-END:variables
}
