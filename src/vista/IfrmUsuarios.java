/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import net.proteanit.sql.DbUtils;
import controlador.UsuarioDAO;
import extras.Mensajes;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import javax.swing.JComboBox;
import javax.swing.JTable;
import modelo.Usuario;

public class IfrmUsuarios extends javax.swing.JInternalFrame {

    public IfrmUsuarios() {
        initComponents();
        //de aqui es para la lista doble click
        tblusu.addMouseListener(new MouseAdapter() {
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
        controles(false, false, true, true, true, true, true, false);

        //cargar combo
        ResultSet rsE;
        rsE = UsuarioDAO.getDataEmpleado();
        cargarcomboPerfil(cborol);
        cargarcomboEmpleado(cboEmpleado, rsE);
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
        tblusu = new javax.swing.JTable();
        cborol = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtcod = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtusu = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtpass = new javax.swing.JTextField();
        btngrabar = new javax.swing.JButton();
        btneditar = new javax.swing.JButton();
        btneliminar = new javax.swing.JButton();
        btnbuscar = new javax.swing.JButton();
        cboEmpleado = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        btnnuevo = new javax.swing.JButton();
        btncancelar = new javax.swing.JButton();
        txtbuscar = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
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

        tblusu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tblusu);

        jLabel4.setText("Password:");

        jLabel1.setText("Codigo:");

        jLabel2.setText("Usuario:");

        jLabel3.setText("Rol:");

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

        jLabel5.setText("Empleado:");

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

        jLabel6.setText("Ingrese nombre de usuario a buscar");

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
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btncancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnnuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btneditar, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btneliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addComponent(jLabel5))
                        .addGap(40, 40, 40)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtusu)
                            .addComponent(txtcod, javax.swing.GroupLayout.DEFAULT_SIZE, 221, Short.MAX_VALUE)
                            .addComponent(cboEmpleado, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(119, 119, 119)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtpass, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cborol, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE))))
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
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtcod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(cborol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtusu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(txtpass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(cboEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(45, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void pasarDatosFila() {
        if (tblusu.isEnabled()) {
            int filaseleccionada = tblusu.getSelectedRow();

            int codigo = (int) tblusu.getValueAt(filaseleccionada, 0);
            Usuario ou = new Usuario();
            ou = UsuarioDAO.getUsuarioByID(codigo);

            txtcod.setText("" + ou.getUsuarioId());
            txtusu.setText(ou.getUsuario());
            txtpass.setText(ou.getPassword());
            cborol.setSelectedItem(ou.getRol());
            if (ou.getEmpleadoName().length() > 0) {
                cboEmpleado.setSelectedItem(ou.getEmpleadoName());
            } else {
                cboEmpleado.setSelectedIndex(0);
            }
        }

    }


    private void formInternalFrameOpened(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameOpened
        listarUsuarios();
    }//GEN-LAST:event_formInternalFrameOpened

    private void btngrabarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btngrabarActionPerformed

        if (validarcampos()) {
            grabar();
            listarUsuarios();
        } else {
            Mensajes.msjmuestra("complete los datos");
        }

    }//GEN-LAST:event_btngrabarActionPerformed

    private void btneditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneditarActionPerformed
        //controles(grabar,cancelar,nuevo,editar,eliminar,buscar,tabla,habilita)
        if (txtusu.getText().equals("")) {
            Mensajes.msjmuestra("Favor de seleccionar una fila a actualizar");
        } else {
            controles(true, true, false, false, false, false, false, true);
        }

    }//GEN-LAST:event_btneditarActionPerformed

    public void listarUsuarios() {
        try {
            tblusu.setModel(DbUtils.resultSetToTableModel(UsuarioDAO.getDataUsuario()));
        } catch (Exception e) {
            Mensajes.msjmuestra("Error View al listar usuarios!!!");
        }
    }

    public void grabar() {
        if (txtcod.getText().equals("0")) {
            try {
                //Campos de tipo Objeto
                Usuario ou = new Usuario();
                ou.setUsuario(txtusu.getText());
                ou.setPassword(txtpass.getText());
                ou.setRol(cborol.getSelectedItem().toString());
                ou.setEmpleadoId(UsuarioDAO.getIDempleadoxNombre(cboEmpleado.getSelectedItem().toString()));
                if (UsuarioDAO.newusuario(ou) == true) {
                    Mensajes.msjmuestra("Grabado Correctamente!!!");
                }
            } catch (Exception e) {
                Mensajes.msjmuestra("Error View al grabar!!!");
            }

        } else {
            try {
                //Campos de tipo Objeto
                Usuario ou = new Usuario();
                ou.setUsuario(txtusu.getText());
                ou.setPassword(txtpass.getText());
                ou.setUsuarioId(Integer.parseInt(txtcod.getText()));
                ou.setRol(cborol.getSelectedItem().toString());
                ou.setEmpleadoId(UsuarioDAO.getIDempleadoxNombre(cboEmpleado.getSelectedItem().toString()));
                if (UsuarioDAO.actualizarUsuario(ou) == true) {
                    Mensajes.msjmuestra("Actualizado Correctamente!!!");
                }
            } catch (Exception e) {
                Mensajes.msjmuestra("Error View al Actualizado!!!");
            }
        }
        //controles(grabar,cancelar,nuevo,editar,eliminar,buscar,tabla,habilita)
        controles(false, false, true, true, true, true, true, false);

    }

    public static void cargarcomboPerfil(JComboBox combo) {
        combo.addItem("ADMIN");
        combo.addItem("VENTAS");
        combo.addItem("COCINA");
    }

    public static void cargarcomboEmpleado(JComboBox combo, ResultSet rs) {
        try {
//         combo.removeAllItems();
            combo.addItem("-Seleccione-");
            while (rs.next()) {
                combo.addItem(rs.getString("nombres"));
            }//Fin while
            rs.close();//Cierro el ResultSet
        } catch (Exception ex) {
            System.out.println(ex.getMessage());//Capturo e imprimo el error
        }//Fin try
    }//fin funcion


    private void btneliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneliminarActionPerformed

        if (txtusu.getText().equals("")) {
            Mensajes.msjmuestra("Favor de seleccionar una fila a eliminar");
        } else {
            try {
                int codigo = Integer.parseInt(txtcod.getText());
                if (UsuarioDAO.deleteUsuario(codigo) == true) {
                    Mensajes.msjmuestra("Eliminado Correctamente!!!");
                    listarUsuarios();
                }
            } catch (Exception e) {
                Mensajes.msjmuestra("Error View al Eliminado!!!");
            }
        }


    }//GEN-LAST:event_btneliminarActionPerformed

    private void btnbuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbuscarActionPerformed
        Usuario ou = new Usuario();

        try {
            String buscar = txtbuscar.getText();
            if (buscar.length() > 0) {
                ou = UsuarioDAO.getUsuarioByNomUsu(buscar);
                if (ou.getUsuario().length() > 0) {
                    txtcod.setText("" + ou.getUsuarioId());
                    txtusu.setText(ou.getUsuario());
                    txtpass.setText(ou.getPassword());
                    cborol.setSelectedItem(ou.getRol());
                    cboEmpleado.setSelectedItem(ou.getEmpleadoName());
                } else {
                    Mensajes.msjmuestra("Codigo de usuario no Registrado");
                }
            } else {
                Mensajes.msjmuestra("Ingres codigo de usuario a buscar");
            }

        } catch (Exception e) {
            Mensajes.msjmuestra("Codigo de usuario no Registrado:" + e.getMessage());
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

    public void controles(boolean grabar, boolean cancelar, boolean nuevo, boolean editar, boolean eliminar, boolean buscar, boolean tabla, boolean habilita) {
        btngrabar.setVisible(grabar);
        btncancelar.setVisible(cancelar);
        btnnuevo.setVisible(nuevo);
        btneditar.setVisible(editar);
        btneliminar.setVisible(eliminar);
        btnbuscar.setVisible(buscar);
        tblusu.setEnabled(tabla);
        habilitarcontroles(habilita);
    }

    public void habilitarcontroles(boolean estado) {
        txtcod.setEditable(false);
        txtusu.setEditable(estado);
        txtpass.setEditable(estado);
        cborol.setEditable(false);
        cboEmpleado.setEditable(false);
    }

    public void limpiar() {
        txtcod.setText("0");
        txtusu.setText("");
        txtpass.setText("");
        cborol.setSelectedIndex(0);
        cboEmpleado.setSelectedIndex(0);
    }

    public boolean validarcampos() {
        if (txtcod.getText().equals("")) {
            return false;
        } else if (txtusu.getText().equals("")) {
            return false;

        } else if (txtpass.getText().equals("")) {
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
    private javax.swing.JComboBox<String> cboEmpleado;
    private javax.swing.JComboBox<String> cborol;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblusu;
    private javax.swing.JTextField txtbuscar;
    private javax.swing.JTextField txtcod;
    private javax.swing.JTextField txtpass;
    private javax.swing.JTextField txtusu;
    // End of variables declaration//GEN-END:variables
}
