/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import com.sun.glass.events.KeyEvent;
import controlador.DBConnection;
import java.awt.HeadlessException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

/**
 *
 * @author Eisner López Acevedo <eisner.lopez at gmail.com>
 * @author Cesar Gonzalez Salas <cgonzalez816 at gmail.com>
 */
public final class Buscar_Persona_frm extends javax.swing.JFrame {

    /**
     * Creates new form puesto
     */
    Connection con = null;
    ResultSet rs = null;
    PreparedStatement pst = null;
    ResultSet rs2 = null;
    PreparedStatement pst2 = null;
    String sqlSelect;
    String sqlSelect_Valor;
    String sqlInsert;
    String sqlDelete;
    //declarar static e instanciarla en tu contructor`
    static DefaultComboBoxModel modelo;

    public Buscar_Persona_frm() throws IOException {
        initComponents();

        //inicialización de las variables de la coneccion a la base de datos
        con = DBConnection.getConnection();
        //llama al procedimiento de obtener la información.
        //centra la ventana para que se inicie en el centro del escritorio
        setLocationRelativeTo(null);
        //initState();
        sqlSelect = "SELECT `idpersona`, `nombre`, `cedula`, `telefono`, `direccion`, `tipo_persona_idtipo_persona` FROM `persona` order BY `nombre`";
        sqlSelect_Valor = "SELECT `idpersona`, `nombre`, `cedula`, `telefono`, `direccion`, `tipo_persona_idtipo_persona` FROM `persona` WHERE `nombre` = '";
        sqlInsert = "INSERT INTO `persona`(`nombre`, `cedula`, `telefono`, `direccion`, `tipo_persona_idtipo_persona`) VALUES ('";
        sqlDelete = "DELETE FROM `persona` WHERE `idpersona` = ";

        modelo = new DefaultComboBoxModel();
        llena_combo(); // llenar los datos al ejecutar el programa
    }

    public void llena_combo() { // static para poder llamarlo desde el otro frame o JDialog

        try {
            modelo.removeAllElements(); // eliminamos lo elementos

            Statement stmt;
            stmt = con.createStatement();

            String sql1 = "SELECT `desc_persona` FROM `tipo_persona`";
            rs = stmt.executeQuery(sql1);

            while (rs.next()) {
                modelo.addElement(rs.getString("desc_persona"));
            }
            cmbTipoPersona.setModel(modelo); // seteamos el modelo y se cargan los datos

        } catch (HeadlessException | SQLException ex) {
            JOptionPane.showMessageDialog(this, ex);
        }
    }

    private void initState() {
        txtNombre_Apellidos.setEnabled(false);
        txtDireccion.setEnabled(false);
        txtPhone.setEnabled(false);
        txtClasificación.setEnabled(false);
        txtCedula.setEnabled(false);
        cmbTipoPersona.setEnabled(false);
        lbl_Gasto_Operativo_id.setText("");
        txtNombre_Apellidos.setText("");
        nuevo.setEnabled(false);
        guardar.setEnabled(false);
        buscar.setEnabled(true);
        editar.setEnabled(false);
        borrar.setEnabled(false);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtNombre_Apellidos = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtCedula = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtDireccion = new javax.swing.JTextField();
        cmbTipoPersona = new javax.swing.JComboBox<>();
        txtClasificación = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtPhone = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        nuevo = new javax.swing.JButton();
        guardar = new javax.swing.JButton();
        editar = new javax.swing.JButton();
        borrar = new javax.swing.JButton();
        buscar = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        lbl_id_persona = new javax.swing.JLabel();
        lbl_Gasto_Operativo_id = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Buscar Datos de Personas");
        setMinimumSize(new java.awt.Dimension(818, 401));
        setUndecorated(true);
        setResizable(false);
        setType(java.awt.Window.Type.UTILITY);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtNombre_Apellidos.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        txtNombre_Apellidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombre_ApellidosActionPerformed(evt);
            }
        });
        txtNombre_Apellidos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombre_ApellidosKeyTyped(evt);
            }
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNombre_ApellidosKeyPressed(evt);
            }
        });
        getContentPane().add(txtNombre_Apellidos, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 40, 360, 40));

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jLabel3.setText("Cedula");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 10, -1, -1));

        txtCedula.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        txtCedula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCedulaActionPerformed(evt);
            }
        });
        getContentPane().add(txtCedula, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 40, 270, 40));

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jLabel4.setText("Direccion");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 100, -1, -1));

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jLabel6.setText("Télefono o Celular");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 100, -1, -1));

        txtDireccion.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        getContentPane().add(txtDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 130, 440, 40));

        cmbTipoPersona.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        cmbTipoPersona.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbTipoPersona.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbTipoPersonaActionPerformed(evt);
            }
        });
        getContentPane().add(cmbTipoPersona, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 220, 200, 40));

        txtClasificación.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        txtClasificación.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtClasificaciónActionPerformed(evt);
            }
        });
        txtClasificación.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtClasificaciónKeyTyped(evt);
            }
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtClasificaciónKeyPressed(evt);
            }
        });
        getContentPane().add(txtClasificación, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 220, 200, 40));

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jLabel7.setText("Nombre y Apellidos");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 10, -1, -1));

        jLabel8.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jLabel8.setText("Clasificación");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 190, -1, -1));

        txtPhone.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        txtPhone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPhoneActionPerformed(evt);
            }
        });
        getContentPane().add(txtPhone, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 130, 200, 40));

        nuevo.setBackground(new java.awt.Color(204, 204, 204));
        nuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icons/CRUD/store-new-badges.png"))); // NOI18N
        nuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nuevoActionPerformed(evt);
            }
        });

        guardar.setBackground(new java.awt.Color(204, 204, 204));
        guardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icons/CRUD/save-icon-silhouette.png"))); // NOI18N
        guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarActionPerformed(evt);
            }
        });

        editar.setBackground(new java.awt.Color(204, 204, 204));
        editar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icons/CRUD/edit.png"))); // NOI18N
        editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editarActionPerformed(evt);
            }
        });

        borrar.setBackground(new java.awt.Color(204, 204, 204));
        borrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icons/CRUD/dustbin.png"))); // NOI18N
        borrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                borrarActionPerformed(evt);
            }
        });

        buscar.setBackground(new java.awt.Color(204, 204, 204));
        buscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icons/CRUD/searching-magnifying-glass.png"))); // NOI18N
        buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarActionPerformed(evt);
            }
        });

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icons/CRUD/volver.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nuevo)
                    .addComponent(guardar)
                    .addComponent(editar)
                    .addComponent(buscar)
                    .addComponent(borrar)
                    .addComponent(jButton1))
                .addContainerGap(12, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(nuevo)
                .addGap(18, 18, 18)
                .addComponent(guardar)
                .addGap(18, 18, 18)
                .addComponent(editar)
                .addGap(18, 18, 18)
                .addComponent(buscar)
                .addGap(18, 18, 18)
                .addComponent(borrar)
                .addContainerGap(59, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 90, 420));

        lbl_id_persona.setText("jLabel1");
        getContentPane().add(lbl_id_persona, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 290, -1, -1));

        lbl_Gasto_Operativo_id.setText("jLabel1");
        getContentPane().add(lbl_Gasto_Operativo_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 300, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void nuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nuevoActionPerformed
        // TODO add your handling code here:
        txtNombre_Apellidos.setEnabled(true);

        txtDireccion.setEnabled(true);
        txtPhone.setEnabled(true);
        txtClasificación.setEnabled(true);
        txtCedula.setEnabled(true);
        cmbTipoPersona.setEnabled(true);
        lbl_Gasto_Operativo_id.setText("");
        txtNombre_Apellidos.setText("");
        txtPhone.setText("");
        txtClasificación.setText("");
        txtPhone.setText("");
        txtNombre_Apellidos.requestDefaultFocus();
        nuevo.setEnabled(false);
        guardar.setEnabled(false);
        buscar.setEnabled(false);
        editar.setEnabled(false);
        borrar.setEnabled(false);
    }//GEN-LAST:event_nuevoActionPerformed

    private void guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarActionPerformed
        // TODO add your handling code here:
        try {
            int P = JOptionPane.showConfirmDialog(null, " Quiere agregar otro dato ?", "Confirmación", JOptionPane.YES_NO_OPTION);
            if (P == 0) {
                con = DBConnection.getConnection();

                if (txtNombre_Apellidos.getText().equals("")) {
                    JOptionPane.showMessageDialog(this, "Favor ingresa el Nombre y Apellidos ", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                if (txtDireccion.getText().equals("")) {
                    JOptionPane.showMessageDialog(this, "Favor ingresa la Direccion", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                if (txtPhone.getText().equals("")) {
                    JOptionPane.showMessageDialog(this, "Favor ingresa el número de Teléfono o Celular ", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                if (txtClasificación.getText().equals("")) {
                    JOptionPane.showMessageDialog(this, "Favor ingresa la clasificación de la persona ", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                if (txtCedula.getText().equals("")) {
                    JOptionPane.showMessageDialog(this, "Favor ingresa el número de cédula!", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                Statement stmt;
                stmt = con.createStatement();

                String sql1 = sqlSelect_Valor + txtNombre_Apellidos.getText() + "'";
                rs = stmt.executeQuery(sql1);
                if (rs.next()) {
                    JOptionPane.showMessageDialog(this, "Valor ya existe.", "Error", JOptionPane.ERROR_MESSAGE);
                    txtNombre_Apellidos.setText("");
                    txtNombre_Apellidos.requestDefaultFocus();
                    return;
                }
                //                      `nombre`,                               `cedula`,                       `telefono`, `direccion`, `tipo_persona_idtipo_persona`
                String sql = sqlInsert + txtNombre_Apellidos.getText() + "','" + txtCedula.getText() + "','" + txtPhone.getText() + "','" + txtDireccion.getText() + "','" + txtClasificación.getText() + "')";
                pst = con.prepareStatement(sql);
                pst.execute();
                JOptionPane.showMessageDialog(this, "Guardado con Exito saved", "Gasto Operativo", JOptionPane.INFORMATION_MESSAGE);
                txtNombre_Apellidos.setText("");
            }
            if (P == 1) {
                String sql = sqlInsert + txtNombre_Apellidos.getText() + "','" + txtCedula.getText() + "','" + txtPhone.getText() + "','" + txtDireccion.getText() + "','" + txtClasificación.getText() + "')";
                pst = con.prepareStatement(sql);
                pst.execute();
                JOptionPane.showMessageDialog(this, "Guardado con Exito saved", "Gasto Operativo", JOptionPane.INFORMATION_MESSAGE);
                txtNombre_Apellidos.setText("");
                initState();
            }

        } catch (HeadlessException | SQLException ex) {
            JOptionPane.showMessageDialog(this, ex);

        }

    }//GEN-LAST:event_guardarActionPerformed

    private void editarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editarActionPerformed
        // TODO add your handling code here:

        try {
            int P = JOptionPane.showConfirmDialog(null, " Quiere editar este dato ?", "Confirmación", JOptionPane.YES_NO_OPTION);
            if (P == 0) {
                con = DBConnection.getConnection();
                Statement stmt;
                stmt = con.createStatement();
                
                String Pru = "UPDATE `persona` SET `nombre` = '" + txtNombre_Apellidos.getText() + "',`cedula` = '" + txtCedula.getText() + "', `telefono` = '" + txtPhone.getText() + "',`direccion`='" + txtPhone.getText() + "',`tipo_persona_idtipo_persona`='" + txtClasificación.getText() + "' WHERE `idpersona`='" + lbl_Gasto_Operativo_id.getText() + "'";
                pst = con.prepareStatement(Pru);
                pst.execute();
                JOptionPane.showMessageDialog(this, "Guardado con Exito saved", "Tipo de Usuario", JOptionPane.INFORMATION_MESSAGE);
                txtNombre_Apellidos.setText("");

                if (P == 1) {

                    txtNombre_Apellidos.setText("");
                    txtDireccion.setText("");
                    txtPhone.setText("");
                    txtClasificación.setText("");
                    txtCedula.setText("");

                }
            }

        } catch (HeadlessException | SQLException ex) {
            JOptionPane.showMessageDialog(this, ex);

        }

    }//GEN-LAST:event_editarActionPerformed

    private void buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarActionPerformed
        // TODO add your handling code here:
        txtNombre_Apellidos.setEnabled(true);
        txtDireccion.setEnabled(true);
        txtPhone.setEnabled(true);
        txtClasificación.setEnabled(true);
        txtCedula.setEnabled(true);
        cmbTipoPersona.setEnabled(true);

        txtNombre_Apellidos.setText("");
        txtDireccion.setText("");
        txtPhone.setText("");
        txtClasificación.setText("");
        txtCedula.setText("");

        nuevo.setEnabled(false);
        guardar.setEnabled(false);
        buscar.setEnabled(false);
        editar.setEnabled(true);
        borrar.setEnabled(true);
    }//GEN-LAST:event_buscarActionPerformed

    private void borrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_borrarActionPerformed
        // TODO add your handling code here:
        try {
            int P = JOptionPane.showConfirmDialog(null, " Seguro que quiere eliminar ?", "Confirmation", JOptionPane.YES_NO_OPTION);
            if (P == 0) {
                con = DBConnection.getConnection();
                
                String sql = sqlDelete + lbl_id_persona.getText() + "";
                //DELETE FROM `persona` WHERE 1
                pst = con.prepareStatement(sql);
                pst.execute();
                JOptionPane.showMessageDialog(this, "Successfully deleted", "Record", JOptionPane.INFORMATION_MESSAGE);
                initState();

            }
            initState();

        } catch (HeadlessException | SQLException ex) {
            JOptionPane.showMessageDialog(this, ex);

        }
    }//GEN-LAST:event_borrarActionPerformed

    private void txtClasificaciónActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtClasificaciónActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtClasificaciónActionPerformed

    private void txtPhoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPhoneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPhoneActionPerformed

    private void txtClasificaciónKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtClasificaciónKeyPressed
        // TODO add your handling code here:


    }//GEN-LAST:event_txtClasificaciónKeyPressed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        txtNombre_Apellidos.setEnabled(false);

        txtDireccion.setEnabled(false);
        txtPhone.setEnabled(false);
        txtClasificación.setEnabled(false);
        txtCedula.setEnabled(false);

        lbl_Gasto_Operativo_id.setText("");
        txtNombre_Apellidos.setText("");
        txtPhone.setText("");
        txtClasificación.setText("");
        txtPhone.setText("");

        txtNombre_Apellidos.requestDefaultFocus();
        nuevo.setEnabled(true);
        guardar.setEnabled(false);
        buscar.setEnabled(false);
        editar.setEnabled(false);
        borrar.setEnabled(false);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtClasificaciónKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtClasificaciónKeyTyped
        // TODO add your handling code here:
        try {
            //SELECT `persona`.`nombre`, `colaborador`.`empleado_id` FROM `pct3`.`colaborador` AS `colaborador`, `pct3`.`persona` AS `persona` WHERE `colaborador`.`persona_idpersona` = `persona`.`idpersona` AND `persona`.`nombre` LIKE "%Thom
            String sql_persona = "SELECT `persona`.`nombre` AS 'Nombre', `colaborador`.`empleado_id` AS 'EMPLEADO_ID' FROM `pct3`.`colaborador` AS `colaborador`, `pct3`.`persona` AS `persona` WHERE `colaborador`.`persona_idpersona` = `persona`.`idpersona` AND `persona`.`nombre` LIKE '%" + txtClasificación.getText() + "%'";
            pst = con.prepareStatement(sql_persona);

            rs = pst.executeQuery();
            if (rs.next()) {
                String add1 = rs.getString("EMPLEADO_ID");
                lbl_id_persona.setText(add1);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);

        }
    }//GEN-LAST:event_txtClasificaciónKeyTyped

    private void txtCedulaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCedulaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCedulaActionPerformed

    private void cmbTipoPersonaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbTipoPersonaActionPerformed
        // TODO add your handling code here:
        try {
            //SELECT `persona`.`nombre`, `colaborador`.`empleado_id` FROM `pct3`.`colaborador` AS `colaborador`, `pct3`.`persona` AS `persona` WHERE `colaborador`.`persona_idpersona` = `persona`.`idpersona` AND `persona`.`nombre` LIKE "%Thom
            String sqlConsulta_TPersona = "SELECT `idtipo_persona`, `desc_persona` FROM `tipo_persona` WHERE `desc_persona` = '" + cmbTipoPersona.getSelectedItem() + "'";
            pst = con.prepareStatement(sqlConsulta_TPersona);

            rs = pst.executeQuery();
            if (rs.next()) {
                String add1 = rs.getString("idtipo_persona");
                txtClasificación.setText(add1);
                System.out.println(add1);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);

        }
    }//GEN-LAST:event_cmbTipoPersonaActionPerformed

    private void txtNombre_ApellidosKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombre_ApellidosKeyTyped


    }//GEN-LAST:event_txtNombre_ApellidosKeyTyped

    private void txtNombre_ApellidosKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombre_ApellidosKeyPressed
        // TODO add your handling code here:

    }//GEN-LAST:event_txtNombre_ApellidosKeyPressed

    private void txtNombre_ApellidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombre_ApellidosActionPerformed
        // TODO add your handling code here:
        try {
            //SELECT `idpersona`, `nombre`, `cedula`, `telefono`, `direccion`, `tipo_persona_idtipo_persona` FROM `persona` WHERE 1
            String sql_persona = "SELECT * FROM `persona` WHERE `nombre` LIKE '%" + txtNombre_Apellidos.getText() + "%'";
            pst = con.prepareStatement(sql_persona);
            rs = pst.executeQuery();
            if (rs.next()) {
                String add1 = rs.getString("idpersona");
                String add2 = rs.getString("nombre");
                String add3 = rs.getString("cedula");
                String add4 = rs.getString("telefono");
                String add5 = rs.getString("direccion");
                String add6 = rs.getString("tipo_persona_idtipo_persona");

                lbl_id_persona.setText(add1);
                txtNombre_Apellidos.setText(add2);
                txtCedula.setText(add3);
                txtDireccion.setText(add4);
                txtPhone.setText(add5);
                lbl_Gasto_Operativo_id.setText(add6);
                cmbTipoPersona.setSelectedIndex(Integer.parseInt(add6) - 1);

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);

        }
    }//GEN-LAST:event_txtNombre_ApellidosActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;

                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Buscar_Persona_frm.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            try {
                new Buscar_Persona_frm().setVisible(true);

            } catch (IOException ex) {
                Logger.getLogger(Buscar_Persona_frm.class
                        .getName()).log(Level.SEVERE, null, ex);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton borrar;
    private javax.swing.JButton buscar;
    private javax.swing.JComboBox<String> cmbTipoPersona;
    private javax.swing.JButton editar;
    private javax.swing.JButton guardar;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lbl_Gasto_Operativo_id;
    private javax.swing.JLabel lbl_id_persona;
    private javax.swing.JButton nuevo;
    private javax.swing.JTextField txtCedula;
    private javax.swing.JTextField txtClasificación;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtNombre_Apellidos;
    private javax.swing.JTextField txtPhone;
    // End of variables declaration//GEN-END:variables
}
