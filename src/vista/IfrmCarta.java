/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import net.proteanit.sql.DbUtils;

import controlador.CartaDAO;
import extras.Mensajes;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import javax.swing.JComboBox;
import javax.swing.JTable;
import modelo.Carta;

public class IfrmCarta extends javax.swing.JInternalFrame {

    public IfrmCarta() {
        initComponents();
        //de aqui es para la lista doble click
        tblCarta.addMouseListener(new MouseAdapter() {
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
        //controles(grabar,cancelar,nuevo,editar,eliminar,buscar,tabla,habilita)
        controles(false, false, true, true, true, true, true, false);

        //cargar combo
        ResultSet rsCtegoria;
        rsCtegoria = CartaDAO.getDataCategoria();
        cargarcomboEstado(cboEstado);
        cargarcomboCategoria(cboCategoria, rsCtegoria);
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
        tblCarta = new javax.swing.JTable();
        cboEstado = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        txtCartaId = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        btngrabar = new javax.swing.JButton();
        btneditar = new javax.swing.JButton();
        btneliminar = new javax.swing.JButton();
        btnbuscar = new javax.swing.JButton();
        cboCategoria = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        btnnuevo = new javax.swing.JButton();
        btncancelar = new javax.swing.JButton();
        txtbuscar = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtDescripcion = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtPrecio = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtDescuento = new javax.swing.JTextField();

        setClosable(true);
        setIconifiable(true);
        setTitle("Sistema de ventas SVA 1.1 / Formulario Mantenimiento de Carta");
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

        tblCarta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tblCarta);

        jLabel1.setText("CartaId");

        jLabel2.setText("Nombre:");

        jLabel3.setText("Estado:");

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

        btneliminar.setText("Eliminar");
        btneliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneliminarActionPerformed(evt);
            }
        });

        btnbuscar.setText("Buscar");
        btnbuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbuscarActionPerformed(evt);
            }
        });

        jLabel5.setText("Categoria:");

        btnnuevo.setText("Nuevo");
        btnnuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnnuevoActionPerformed(evt);
            }
        });

        btncancelar.setText("Cancelar");
        btncancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncancelarActionPerformed(evt);
            }
        });

        jLabel6.setText("Ingrese plato a buscar");

        jLabel7.setText("Descripción:");

        txtPrecio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPrecioKeyTyped(evt);
            }
        });

        jLabel8.setText("Precio:");

        jLabel9.setText("Descuento:");

        txtDescuento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDescuentoKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btngrabar, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btncancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnnuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btneditar, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btneliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtbuscar, javax.swing.GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addComponent(jLabel5)
                            .addComponent(jLabel7))
                        .addGap(40, 40, 40)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtDescripcion)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(cboCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(28, 28, 28)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cboEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txtCartaId, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txtNombre)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel8)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(26, 26, 26)
                                        .addComponent(jLabel9)))
                                .addGap(10, 10, 10)
                                .addComponent(txtDescuento, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btngrabar)
                    .addComponent(btneditar)
                    .addComponent(btneliminar)
                    .addComponent(btnbuscar)
                    .addComponent(btncancelar)
                    .addComponent(btnnuevo)
                    .addComponent(txtbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 254, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtCartaId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(txtDescuento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(cboCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(cboEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void pasarDatosFila() {
        if (tblCarta.isEnabled()) {
            int filaseleccionada = tblCarta.getSelectedRow();

            int codigo = (int) tblCarta.getValueAt(filaseleccionada, 0);
            Carta ocarta = new Carta();
            ocarta = CartaDAO.getCartaByID(codigo);

            txtCartaId.setText("" + ocarta.getCartaId());
            txtNombre.setText(ocarta.getNombre());
            txtPrecio.setText(ocarta.getPrecio() + "");
            txtDescripcion.setText(ocarta.getDescripcion());
            txtDescuento.setText(ocarta.getDescuento() + "");
            cboEstado.setSelectedItem(ocarta.getEstado());
            cboCategoria.setSelectedItem(ocarta.getCategoria());

        }

    }


    private void formInternalFrameOpened(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameOpened
        listarPlatos();
    }//GEN-LAST:event_formInternalFrameOpened

    private void btngrabarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btngrabarActionPerformed

        if (validarcampos()) {
            grabar();
            listarPlatos();
        } else {
            Mensajes.msjmuestra("complete los datos");
        }

    }//GEN-LAST:event_btngrabarActionPerformed

    private void btneditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneditarActionPerformed
        //controles(grabar,cancelar,nuevo,editar,eliminar,buscar,tabla,habilita)
        if (txtNombre.getText().equals("")) {
            Mensajes.msjmuestra("Favor de seleccionar una fila a actualizar");
        } else {
            controles(true, true, false, false, false, false, false, true);
        }

    }//GEN-LAST:event_btneditarActionPerformed

    public void listarPlatos() {
        try {
            tblCarta.setModel(DbUtils.resultSetToTableModel(CartaDAO.getDataCarta()));
        } catch (Exception e) {
            Mensajes.msjmuestra("Error View al listar carta!!!");
        }
    }

    public void grabar() {
        if (txtCartaId.getText().equals("0")) {
            try {
                //Campos de tipo Objeto
                Carta obj = new Carta();
                obj.setNombre(txtNombre.getText());
                obj.setDescripcion(txtDescripcion.getText());
                obj.setEstado(cboEstado.getSelectedItem().toString());
                obj.setCategoriaId(CartaDAO.getIDCategoriaPorNombre(cboCategoria.getSelectedItem().toString()));

                if (txtPrecio.getText().length() > 0) {
                    obj.setPrecio(Double.parseDouble(txtPrecio.getText()));
                } else {
                    obj.setPrecio(0.0);
                }
                if (txtDescuento.getText().length() > 0) {
                    obj.setDescuento(Double.parseDouble(txtDescuento.getText()));
                } else {
                    obj.setDescuento(0.0);
                }
                if (CartaDAO.newCarta(obj) == true) {
                    Mensajes.msjmuestra("Grabado Correctamente!!!");
                }
            } catch (Exception e) {
                Mensajes.msjmuestra("Error View al grabar!!!");
            }

        } else {
            try {
                //Campos de tipo Objeto

                Carta obj = new Carta();
                obj.setCartaId(Integer.parseInt(txtCartaId.getText()));
                obj.setNombre(txtNombre.getText());
                obj.setDescripcion(txtDescripcion.getText());
                obj.setEstado(cboEstado.getSelectedItem().toString());
                obj.setCategoriaId(CartaDAO.getIDCategoriaPorNombre(cboCategoria.getSelectedItem().toString()));
                obj.setNombre(txtDescripcion.getText());
                if (txtPrecio.getText().length() > 0) {
                    obj.setPrecio(Double.parseDouble(txtPrecio.getText()));
                } else {
                    obj.setPrecio(0.0);
                }
                if (txtDescuento.getText().length() > 0) {
                    obj.setDescuento(Double.parseDouble(txtDescuento.getText()));
                } else {
                    obj.setDescuento(0.0);
                }
                if (CartaDAO.actualizarCarta(obj) == true) {
                    Mensajes.msjmuestra("Actualizado Correctamente!!!");
                }
            } catch (Exception e) {
                Mensajes.msjmuestra("Error View al Actualizado!!!");
            }
        }
        //controles(grabar,cancelar,nuevo,editar,eliminar,buscar,tabla,habilita)
        controles(false, false, true, true, true, true, true, false);

    }

    public static void cargarcomboEstado(JComboBox combo) {
        combo.addItem("DISPONIBLE");
        combo.addItem("NO DISPONIBLE");
    }

    public static void cargarcomboCategoria(JComboBox combo, ResultSet rs) {
        try {
            while (rs.next()) {
                combo.addItem(rs.getString("descripcion"));
            }
            rs.close();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());//Capturo e imprimo el error
        }
    }


    private void btneliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneliminarActionPerformed

        if (txtNombre.getText().equals("")) {
            Mensajes.msjmuestra("Favor de seleccionar una fila a eliminar");
        } else {
            try {
                int codigo = Integer.parseInt(txtCartaId.getText());
                if (CartaDAO.deleteCarta(codigo) == true) {
                    Mensajes.msjmuestra("Eliminado Correctamente!!!");
                    listarPlatos();
                }
            } catch (Exception e) {
                Mensajes.msjmuestra("Error View al Eliminado!!!");
            }
        }
    }//GEN-LAST:event_btneliminarActionPerformed

    private void btnbuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbuscarActionPerformed
        Carta ocarta = new Carta();

        try {
            String busqueda = txtbuscar.getText();

            try {
                tblCarta.setModel(DbUtils.resultSetToTableModel(CartaDAO.getDataCartaByDescripcion(busqueda)));
            } catch (Exception e) {
                Mensajes.msjmuestra("Error View al listar carta!!!");
            }

        } catch (Exception e) {
            Mensajes.msjmuestra("Elemento no encontrado:" + e.getMessage());
        }

    }//GEN-LAST:event_btnbuscarActionPerformed

    private void btnnuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnnuevoActionPerformed
        //controles(grabar,cancelar,nuevo,editar,eliminar,buscar,tabla,habilita)
        controles(true, true, false, false, false, false, false, true);
        this.limpiar();
    }//GEN-LAST:event_btnnuevoActionPerformed

    private void btncancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncancelarActionPerformed
        this.cerrarVentana();
    }//GEN-LAST:event_btncancelarActionPerformed

    private void txtPrecioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPrecioKeyTyped
        char c = evt.getKeyChar();
        if (((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE)
                && (c != '.')) {
            evt.consume();
        }
        if (c == '.' && txtPrecio.getText().contains(".")) {
            evt.consume();
        }
    }//GEN-LAST:event_txtPrecioKeyTyped

    private void txtDescuentoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDescuentoKeyTyped
        char c = evt.getKeyChar();
        if (((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE)
                && (c != '.')) {
            evt.consume();
        }
        if (c == '.' && txtDescuento.getText().contains(".")) {
            evt.consume();
        }
    }//GEN-LAST:event_txtDescuentoKeyTyped

    public void controles(boolean grabar, boolean cancelar, boolean nuevo, boolean editar, boolean eliminar, boolean buscar, boolean tabla, boolean habilita) {
        btngrabar.setVisible(grabar);
        btncancelar.setVisible(cancelar);
        btnnuevo.setVisible(nuevo);
        btneditar.setVisible(editar);
        btneliminar.setVisible(eliminar);
        btnbuscar.setVisible(buscar);
        tblCarta.setEnabled(tabla);
        habilitarcontroles(habilita);
    }

    public void habilitarcontroles(boolean estado) {
        txtCartaId.setEditable(false);
        txtNombre.setEditable(estado);
        txtPrecio.setEditable(estado);
        txtDescripcion.setEditable(estado);
        txtDescuento.setEditable(estado);
        cboEstado.setEditable(false);
        cboCategoria.setEditable(false);
    }

    public void limpiar() {
        txtCartaId.setText("0");
        txtNombre.setText("");
        txtPrecio.setText("");
        txtDescuento.setText("");
        cboEstado.setSelectedIndex(0);
        cboCategoria.setSelectedIndex(0);
    }

    public boolean validarcampos() {
        if (txtCartaId.getText().equals("")) {
            return false;
        } else if (txtNombre.getText().equals("")) {
            return false;

        } else if (txtPrecio.getText().equals("")) {
            return false;
        }
        return true;
    }

    void cerrarVentana() {
        this.dispose();
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnbuscar;
    private javax.swing.JButton btncancelar;
    private javax.swing.JButton btneditar;
    private javax.swing.JButton btneliminar;
    private javax.swing.JButton btngrabar;
    private javax.swing.JButton btnnuevo;
    private javax.swing.JComboBox<String> cboCategoria;
    private javax.swing.JComboBox<String> cboEstado;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblCarta;
    private javax.swing.JTextField txtCartaId;
    private javax.swing.JTextField txtDescripcion;
    private javax.swing.JTextField txtDescuento;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtPrecio;
    private javax.swing.JTextField txtbuscar;
    // End of variables declaration//GEN-END:variables
}
