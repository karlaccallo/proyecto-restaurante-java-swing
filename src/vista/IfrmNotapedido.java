package vista;

import controlador.CartaDAO;
import controlador.DetallePedidoDAO;
import controlador.NotaPedidoDAO;
import controlador.UsuarioDAO;
import modelo.NotaPedido;
import extras.Mensajes;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import util.Utileria;

/**
 *
 * @author alumno
 */
public class IfrmNotapedido extends javax.swing.JInternalFrame {

    int cont;

    DefaultTableModel mdl = new DefaultTableModel();
    DefaultComboBoxModel cbmd = new DefaultComboBoxModel();

    public IfrmNotapedido() {
        initComponents();
    }

    private void cabeceraDetalle() {
        tbldata.setModel(mdl);
        mdl.addColumn("CODIGO");
        mdl.addColumn("CANTIDAD");
        mdl.addColumn("PRECIO");
        mdl.addColumn("IMPORTE");
    }

    void mimensaje(String msn) {
        JOptionPane.showMessageDialog(null, msn);
    }

    public static void cargarcomboCategoria(JComboBox combo, ResultSet rs) {
        try {
            while (rs.next()) {
                combo.addItem(rs.getString("descripcion"));
            }
            rs.close();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void cargarcomboMesa(String camarero) {

        try {
            ResultSet rs;
            rs = NotaPedidoDAO.getNumeroMesaByNombreCamarero(camarero);
            while (rs.next()) {
                cboNumMesa.addItem(rs.getString("numMesa"));
            }
            rs.close();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

    }

    public void cargarComboCarta(String categoria) {

        try {
            cbmd = new DefaultComboBoxModel();
            cboCarta.setModel(cbmd);
            ResultSet rsCarta;
            rsCarta = CartaDAO.getNombrePlatoByCategoria(categoria);
            while (rsCarta.next()) {
                cbmd.addElement(rsCarta.getString("nombre"));
            }
            rsCarta.close();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSeparator1 = new javax.swing.JSeparator();
        lblnumero = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        lblCamarero = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtFecha = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtValorPedido = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        cboCategoria = new javax.swing.JComboBox();
        jLabel11 = new javax.swing.JLabel();
        cboCarta = new javax.swing.JComboBox();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtIdCarta = new javax.swing.JTextField();
        txtPrecio = new javax.swing.JTextField();
        txtCantidad = new javax.swing.JTextField();
        txtImporte = new javax.swing.JTextField();
        btnGrabar = new javax.swing.JButton();
        btnAgregar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbldata = new javax.swing.JTable();
        cboNumMesa = new javax.swing.JComboBox();
        jLabel15 = new javax.swing.JLabel();
        btnTotal = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JSeparator();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Sistema de ventas SVA 1.1 / Formulario de Nota de Pedido");
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

        lblnumero.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel1.setText("Número Pedido:");

        jLabel9.setText("Camarero:");

        lblCamarero.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel5.setText("Fecha de Registro :");

        txtFecha.setEditable(false);

        jLabel6.setText("Valor Pedido:  S/.");

        jLabel10.setText("Categoria :");

        cboCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboCategoriaActionPerformed(evt);
            }
        });

        jLabel11.setText("Carta Polleria :");

        cboCarta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboCartaActionPerformed(evt);
            }
        });

        jLabel12.setText("Cantidad :");

        jLabel13.setText("Codigo :");

        jLabel14.setText("Precio :  S/.");

        jLabel2.setText("Importe :  S/.");

        txtCantidad.setMaximumSize(new java.awt.Dimension(4, 4));
        txtCantidad.setMinimumSize(new java.awt.Dimension(1, 1));
        txtCantidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCantidadKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCantidadKeyTyped(evt);
            }
        });

        btnGrabar.setText("Grabar Pedido");
        btnGrabar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGrabarActionPerformed(evt);
            }
        });

        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

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

        jLabel15.setText("Numero Mesa:");

        btnTotal.setText("Totalizar");
        btnTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTotalActionPerformed(evt);
            }
        });

        btnLimpiar.setText("Limpiar");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnGrabar, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jSeparator3)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtIdCarta, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(31, 31, 31)
                                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(56, 56, 56)
                                .addComponent(cboCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(92, 92, 92)
                                .addComponent(jLabel12)
                                .addGap(18, 18, 18)
                                .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtImporte, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                                .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cboCarta, javax.swing.GroupLayout.PREFERRED_SIZE, 417, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(43, 43, 43)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtValorPedido, javax.swing.GroupLayout.DEFAULT_SIZE, 185, Short.MAX_VALUE)
                                    .addComponent(lblCamarero, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblnumero, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cboNumMesa, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtFecha, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(20, 20, 20))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblnumero, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(lblCamarero, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboNumMesa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtValorPedido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(cboCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboCarta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(txtIdCarta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14)
                    .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)
                    .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(txtImporte, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAgregar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnTotal)
                    .addComponent(btnGrabar)
                    .addComponent(btnLimpiar))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE)
                .addGap(43, 43, 43))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public int grabarPedido() {
        int idEmpleado = UsuarioDAO.getIDempleadoxNombre(lblCamarero.getText());
        double montoPagar = Double.parseDouble(txtValorPedido.getText());
        String sMesa = cboNumMesa.getSelectedItem().toString();
        int mesa = Integer.parseInt(sMesa);
        NotaPedido obj = new NotaPedido();
        obj.setMontoPagar(montoPagar);
        obj.setNumMesa(mesa);
        obj.setEmpleadoId(idEmpleado);
        int numeroPedido = NotaPedidoDAO.grabarPedido(obj);
        return numeroPedido;
    }

    public boolean grabarDetallePedido(int numeroPedido, int carta, int cant, double precio, double imp) {
        boolean ok = false;
        try {
            if (DetallePedidoDAO.grabarDetallePedido(numeroPedido, carta, cant, precio, imp) == true) {
                ok = true;
                System.out.println("vista.IfrmNotapedido.grabarDetallePedido()--Grabado Correctamente!!!");
            }
        } catch (Exception e) {
            System.out.println("vista.IfrmNotapedido.grabarDetallePedido()--Error View al grabar!!!");
        }
        return ok;
    }

    public void limpiar() {
        mdl.setRowCount(0);
        mdl.setColumnCount(0);
        this.cabeceraDetalle();
        txtCantidad.setText("");
        txtIdCarta.setText("");
        txtImporte.setText("");
        txtPrecio.setText("");
        txtValorPedido.setText("");
        cboCarta.setSelectedIndex(0);
        cboCategoria.setSelectedIndex(0);

        btnGrabar.setEnabled(false);
        btnTotal.setEnabled(false);

    }
    private void formInternalFrameOpened(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameOpened

        txtFecha.setText(Utileria.getFechaActualToString());
        FrmLogin oa = new FrmLogin();
        String nombreUsuario = oa.nombUsu;
        lblCamarero.setText(UsuarioDAO.getNombreCamareroByNombreUsuario(nombreUsuario));
        lblnumero.setText("0");

        txtIdCarta.setEditable(false);
        txtPrecio.setEditable(false);
        txtValorPedido.setEditable(false);
        txtImporte.setEditable(false);

        this.cabeceraDetalle();

        ResultSet rsCtegoria;
        rsCtegoria = CartaDAO.getDataCategoria();
        cargarcomboCategoria(cboCategoria, rsCtegoria);
        cargarcomboMesa(lblCamarero.getText());

        btnGrabar.setEnabled(false);
        btnTotal.setEnabled(false);
    }//GEN-LAST:event_formInternalFrameOpened

    private void cboCartaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboCartaActionPerformed
        txtIdCarta.setText("" + CartaDAO.getIdCartaByNombre(cboCarta.getSelectedItem().toString()));
        txtPrecio.setText("" + CartaDAO.getPrecioCartaById(Integer.parseInt(txtIdCarta.getText())));
        txtCantidad.setText("");
        txtCantidad.grabFocus();

    }//GEN-LAST:event_cboCartaActionPerformed

    private void cboCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboCategoriaActionPerformed

        this.cargarComboCarta(cboCategoria.getSelectedItem().toString());
        txtImporte.setText("");
    }//GEN-LAST:event_cboCategoriaActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed

        if (txtCantidad.getText().length() > 0) {
            int cod = Integer.parseInt(txtIdCarta.getText());
            int cant = Integer.parseInt(txtCantidad.getText());
            double prec = Double.parseDouble(txtPrecio.getText());
            double imp = Double.parseDouble(txtImporte.getText());

            mdl.addRow(new Object[]{cod, cant, prec, imp});
            btnTotal.setEnabled(true);
            btnGrabar.setEnabled(false);
        } else {
            Mensajes.msjmuestra("Favor de ingresar la cantidad");
        }
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnGrabarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGrabarActionPerformed

        if (cboNumMesa.getSelectedItem()==null) {
            Mensajes.msjmuestra("Su usuario no tiene mesas configuradas.\nFavor de contactar con su gerente!!! ");
        } else {
            int numPedido = this.grabarPedido();
            int carta = 0;
            int cant = 0;
            double prec = 0.0;
            double imp = 0.0;
            boolean grabado = false;

            for (int f = 0; f < mdl.getRowCount(); f++) {
                for (int c = 0; c < mdl.getColumnCount(); c++) {
                    if (c == 0) {
                        carta = Integer.parseInt(mdl.getValueAt(f, c).toString());
                    }
                    if (c == 1) {
                        cant = Integer.parseInt(mdl.getValueAt(f, c).toString());
                    }
                    if (c == 2) {
                        prec = Double.parseDouble(mdl.getValueAt(f, c).toString());
                    }
                    if (c == 3) {
                        imp = Double.parseDouble(mdl.getValueAt(f, c).toString());
                    }
                }
                grabado = this.grabarDetallePedido(numPedido, carta, cant, prec, imp);
            }

            if (grabado) {
                Mensajes.msjmuestra("Pedido grabado correctamente:\n Su número de pedido es: " + numPedido);
            } else {
                Mensajes.msjmuestra("Ocurrió un error al grabar el pedido.");
            }
            mdl.setRowCount(0);
            mdl.setColumnCount(0);

            this.cabeceraDetalle();
            limpiar();
        }
    }//GEN-LAST:event_btnGrabarActionPerformed

    private void btnTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTotalActionPerformed

        double total = 0.0;
        for (int i = 0; i < mdl.getRowCount(); i++) {
            total = total + Double.parseDouble(mdl.getValueAt(i, 3).toString());
        }
        txtValorPedido.setText("" + total);
        btnGrabar.setEnabled(true);
    }//GEN-LAST:event_btnTotalActionPerformed


    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        this.limpiar();

    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void txtCantidadKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCantidadKeyReleased
        if (txtCantidad.getText().length() > 0) {
            double precio = Double.parseDouble(txtPrecio.getText());
            int cant = Integer.parseInt(txtCantidad.getText());
            txtImporte.setText("" + precio * cant);
        }

    }//GEN-LAST:event_txtCantidadKeyReleased

    private void txtCantidadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCantidadKeyTyped
        char c = evt.getKeyChar();
        if (((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE)) {
            evt.consume();
        }
        if (txtCantidad.getText().length() > 4) {
            evt.consume();
        }
    }//GEN-LAST:event_txtCantidadKeyTyped

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnGrabar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnTotal;
    private javax.swing.JComboBox cboCarta;
    private javax.swing.JComboBox cboCategoria;
    private javax.swing.JComboBox cboNumMesa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JLabel lblCamarero;
    private javax.swing.JLabel lblnumero;
    private javax.swing.JTable tbldata;
    private javax.swing.JTextField txtCantidad;
    private javax.swing.JTextField txtFecha;
    private javax.swing.JTextField txtIdCarta;
    private javax.swing.JTextField txtImporte;
    private javax.swing.JTextField txtPrecio;
    private javax.swing.JTextField txtValorPedido;
    // End of variables declaration//GEN-END:variables
}
