/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import net.proteanit.sql.DbUtils;

import controlador.DetallePedidoDAO;
import extras.Mensajes;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import javax.swing.JComboBox;
import javax.swing.JTable;
import modelo.Carta;
import modelo.DetallePedido;

public class IfrmPedidosCocina extends javax.swing.JInternalFrame {

    public IfrmPedidosCocina() {
        initComponents();
        //de aqui es para la lista doble click
        tblDetallePedido.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent Mouse_evt) {
                JTable table = (JTable) Mouse_evt.getSource();
                Point point = Mouse_evt.getPoint();
                int row = table.rowAtPoint(point);
                if (Mouse_evt.getClickCount() == 1) {
                    //          Mensajes.msjmuestra(""+tblusu.getValueAt(tblusu.getSelectedRow(), 1));
                    pasarDatosFila();
                }
            }
        });
        //finaliza
        //controles(grabar,cancelar,nuevo,editar,eliminar,buscar,tabla,habilita)
        controles(false, false, true, true, true, false);

        //cargar combo
        ResultSet rsCtegoria;
        rsCtegoria = DetallePedidoDAO.getDataEstadoDetallePedido();
        cargarcomboCategoria(cboEstado, rsCtegoria);
        //final combo
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblDetallePedido = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        txtCartaId = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        btngrabar = new javax.swing.JButton();
        btneditar = new javax.swing.JButton();
        cboEstado = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        btncancelar = new javax.swing.JButton();
        txtDescripcion = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtNumPedido = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Sistema de ventas SVA 1.1 / Formulario de Pedidos de cocina");
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

        tblDetallePedido.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tblDetallePedido.setGridColor(new java.awt.Color(255, 204, 102));
        tblDetallePedido.setRowHeight(20);
        jScrollPane1.setViewportView(tblDetallePedido);

        jLabel1.setText("CartaId");

        jLabel2.setText("Nombre:");

        btngrabar.setText("Grabar");
        btngrabar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btngrabarActionPerformed(evt);
            }
        });

        btneditar.setText("Editar");
        btneditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneditarActionPerformed(evt);
            }
        });

        jLabel5.setText("Estado:");

        btncancelar.setText("Cancelar");
        btncancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncancelarActionPerformed(evt);
            }
        });

        jLabel7.setText("Descripción:");

        jLabel8.setText("Numero pedido:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addComponent(jLabel7))
                        .addGap(40, 40, 40)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(txtNombre, javax.swing.GroupLayout.DEFAULT_SIZE, 634, Short.MAX_VALUE)
                                .addGap(353, 353, 353))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtCartaId, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(52, 52, 52)
                                .addComponent(jLabel8)
                                .addGap(18, 18, 18)
                                .addComponent(txtNumPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(94, 94, 94)
                                .addComponent(jLabel5)
                                .addGap(26, 26, 26)
                                .addComponent(cboEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtDescripcion)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1073, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btngrabar, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btncancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(25, 25, 25)
                                .addComponent(btneditar, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btngrabar)
                    .addComponent(btneditar)
                    .addComponent(btncancelar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 255, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtCartaId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(txtNumPedido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(cboEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(56, 56, 56))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void pasarDatosFila() {
        if (tblDetallePedido.isEnabled()) {
            int filaseleccionada = tblDetallePedido.getSelectedRow();

            int numpedido = (int) tblDetallePedido.getValueAt(filaseleccionada, 0);
            int cartaid = (int) tblDetallePedido.getValueAt(filaseleccionada, 1);
            DetallePedido odet = new DetallePedido();
            odet = DetallePedidoDAO.getDataDetallePedidoByCartaAndPedido(cartaid, numpedido);
            
            txtCartaId.setText("" + odet.getCartaId());
            txtNumPedido.setText(odet.getNumPedido()+ "");
            txtNombre.setText(odet.getNombrePlato());
            txtDescripcion.setText(odet.getDescripcionPlato());
            cboEstado.setSelectedItem(odet.getNombreEstado());
        }

    }


    private void formInternalFrameOpened(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameOpened
        listarPedidosSolicitados();
    }//GEN-LAST:event_formInternalFrameOpened

    private void btngrabarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btngrabarActionPerformed

        if (validarcampos()) {
            grabar();
            listarPedidosSolicitados();
        } else {
            Mensajes.msjmuestra("complete los datos");
        }

    }//GEN-LAST:event_btngrabarActionPerformed

    private void btneditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneditarActionPerformed
        //controles(grabar,cancelar,nuevo,editar,eliminar,buscar,tabla,habilita)
        if (txtNombre.getText().equals("")) {
            Mensajes.msjmuestra("Favor de seleccionar una fila a actualizar");
        } else {
            controles(true, true, false, false, false, true);
        }

    }//GEN-LAST:event_btneditarActionPerformed

    public void listarPedidosSolicitados() {
        try {
            tblDetallePedido.setModel(DbUtils.resultSetToTableModel(DetallePedidoDAO.getDataDetallePedidoSolicitadoCocina()));
        } catch (Exception e) {
            Mensajes.msjmuestra("Error View al listar carta!!!");
        }
    }

    public void grabar() {

        try {
            //Campos de tipo Objeto

            DetallePedido obj = new DetallePedido();
            obj.setCartaId(Integer.parseInt(txtCartaId.getText()));
            obj.setNumPedido(Integer.parseInt(txtNumPedido.getText()));
            obj.setEstadoDetalleId(DetallePedidoDAO.getIDEstadoPorNombre(cboEstado.getSelectedItem().toString()));
   
            if (DetallePedidoDAO.actualizarDetallePedido(obj) == true) {
                Mensajes.msjmuestra("Actualizado Correctamente!!!");
            }
        } catch (Exception e) {
            Mensajes.msjmuestra("Error View al Actualizado!!!");
        }

        //controles(grabar,cancelar,nuevo,editar,eliminar,buscar,tabla,habilita)
        controles(false, false, true, true, true, false);

    }

    public static void cargarcomboEstado(JComboBox combo) {
        combo.addItem("DISPONIBLE");
        combo.addItem("NO DISPONIBLE");
    }

    public static void cargarcomboCategoria(JComboBox combo, ResultSet rs) {
        try {
//         combo.removeAllItems();
            while (rs.next()) {
                combo.addItem(rs.getString("descripcion"));
            }//Fin while
            rs.close();//Cierro el ResultSet
        } catch (Exception ex) {
            System.out.println(ex.getMessage());//Capturo e imprimo el error
        }//Fin try
    }//fin funcion


    private void btncancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncancelarActionPerformed
        this.cerrarVentana();
    }//GEN-LAST:event_btncancelarActionPerformed

    public void controles(boolean grabar, boolean cancelar, boolean nuevo, boolean editar, boolean tabla, boolean habilita) {
        btngrabar.setVisible(grabar);
        btncancelar.setVisible(cancelar);
        btneditar.setVisible(editar);
        tblDetallePedido.setEnabled(tabla);
        habilitarcontroles(habilita);
    }

    public void habilitarcontroles(boolean estado) {
        txtCartaId.setEditable(false);
        txtNombre.setEditable(estado);
        txtNumPedido.setEditable(estado);
        txtDescripcion.setEditable(estado);
        cboEstado.setEditable(false);
    }

    public void limpiar() {
        txtCartaId.setText("0");
        txtNombre.setText("");
        txtNumPedido.setText("");
        cboEstado.setSelectedIndex(0);
    }

    public boolean validarcampos() {
        if (txtCartaId.getText().equals("")) {
            return false;
        } else if (txtNombre.getText().equals("")) {
            return false;

        } else if (txtNumPedido.getText().equals("")) {
            return false;
        }
        return true;
    }

    void cerrarVentana() {
        this.dispose();
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btncancelar;
    private javax.swing.JButton btneditar;
    private javax.swing.JButton btngrabar;
    private javax.swing.JComboBox<String> cboEstado;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblDetallePedido;
    private javax.swing.JTextField txtCartaId;
    private javax.swing.JTextField txtDescripcion;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtNumPedido;
    // End of variables declaration//GEN-END:variables
}
