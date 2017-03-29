/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

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
 */
public class AgregarProveedor_frm extends javax.swing.JInternalFrame {

    /**
     * Creates new form Personas_frm
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

    private String id_Persona;

    //declarar static e instanciarla en tu contructor`
    static DefaultComboBoxModel modeloTipo;

    public AgregarProveedor_frm() {
        initComponents();
        con = DBConnection.getConnection();
        sqlSelect = "SELECT `idpersona`, `nombre`, `cedula`, `telefono`, `direccion`, `tipo_persona_idtipo_persona` FROM `persona` order BY `nombre`";
        sqlSelect_Valor = "SELECT `idpersona`, `nombre`, `cedula`, `telefono`, `direccion`, `tipo_persona_idtipo_persona` FROM `persona` WHERE `nombre` = '";
        sqlInsert = "INSERT INTO `persona`(`nombre`, `cedula`, `telefono`, `direccion`, `tipo_persona_idtipo_persona`) VALUES ('";
        sqlDelete = "DELETE FROM `persona` WHERE `idpersona` = ";
        
        modeloTipo = new DefaultComboBoxModel();

        llena_combo(); // llenar los datos al ejecutar el programa
    }
    
    public void llena_combo() { // static para poder llamarlo desde el otro frame o JDialog
    try {
            modeloTipo.removeAllElements(); // eliminamos lo elementos
            Statement stmt;
            stmt = con.createStatement();
            String queryComboEstado = "SELECT `desc_persona` FROM `tipo_persona`";
            rs = stmt.executeQuery(queryComboEstado);
            while (rs.next()) {
                modeloTipo.addElement(rs.getString("desc_persona"));
                
            }
            cmbTipoPersona.setModel(modeloTipo); // seteamos el modelo y se cargan los datos

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
        lbl_idPersona.setText("");
        txtNombre_Apellidos.setText("");
        nuevo.setEnabled(true);
        guardar.setEnabled(false);
        buscar.setEnabled(true);
        editar.setEnabled(false);
        borrar.setEnabled(false);

    }

    private void agregarPersona() {
        try {
            int P = JOptionPane.showConfirmDialog(null, " Quiere agregar otro dato ?", "Confirmación", JOptionPane.YES_NO_OPTION);
            if (P == 0) {
                

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
                try {
                    String sql_persona = "SELECT * FROM `persona` WHERE `nombre` LIKE '%" + txtNombre_Apellidos.getText() + "%'";
                    pst = con.prepareStatement(sql_persona);
                    rs = pst.executeQuery();
                    if (rs.next()) {
                        String sel1 = rs.getString("idpersona");
                        String sel2 = rs.getString("nombre");
                        String sel3 = rs.getString("cedula");
                        String sel4 = rs.getString("telefono");
                        String sel5 = rs.getString("direccion");
                        String sel6 = rs.getString("tipo_persona_idtipo_persona");
                        lbl_id_persona.setText(sel1);
                        txtNombre_Apellidos.setText(sel2);
                        txtCedula.setText(sel3);
                        txtDireccion.setText(sel4);
                        txtPhone.setText(sel5);
                        lbl_idPersona.setText(sel6);
                        cmbTipoPersona.setSelectedIndex(Integer.parseInt(sel6) - 1);
                    }
                } catch (SQLException | NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, e);
                }
            }
            if (P == 1) {
                String sql = sqlInsert + txtNombre_Apellidos.getText() + "','" + txtCedula.getText() + "','" + txtPhone.getText() + "','" + txtDireccion.getText() + "','" + txtClasificación.getText() + "')";
                pst = con.prepareStatement(sql);
                pst.execute();
                JOptionPane.showMessageDialog(this, "Guardado con Exito saved", "Gasto Operativo", JOptionPane.INFORMATION_MESSAGE);
                try {
                    String sql_persona = "SELECT * FROM `persona` WHERE `nombre` LIKE '%" + txtNombre_Apellidos.getText() + "%'";
                    pst = con.prepareStatement(sql_persona);
                    rs = pst.executeQuery();
                    if (rs.next()) {
                        String sel1 = rs.getString("idpersona");
                        String sel2 = rs.getString("nombre");
                        String sel3 = rs.getString("cedula");
                        String sel4 = rs.getString("telefono");
                        String sel5 = rs.getString("direccion");
                        String sel6 = rs.getString("tipo_persona_idtipo_persona");
                        lbl_id_persona.setText(sel1);
                        txtNombre_Apellidos.setText(sel2);
                        txtCedula.setText(sel3);
                        txtDireccion.setText(sel4);
                        txtPhone.setText(sel5);
                        lbl_idPersona.setText(sel6);
                        cmbTipoPersona.setSelectedIndex(Integer.parseInt(sel6) - 1);
                    }
                } catch (SQLException | NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, e);
                }
            }
        } catch (HeadlessException | SQLException ex) {
            JOptionPane.showMessageDialog(this, ex);
        }
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
        cedula = new javax.swing.JLabel();
        txtCedula = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        nombreUsuario = new javax.swing.JLabel();
        direccion = new javax.swing.JLabel();
        telefono = new javax.swing.JLabel();
        txtDireccion = new javax.swing.JTextField();
        cmbTipoPersona = new javax.swing.JComboBox<>();
        txtClasificación = new javax.swing.JTextField();
        nombreApellidos = new javax.swing.JLabel();
        clasificación = new javax.swing.JLabel();
        txtPhone = new javax.swing.JTextField();
        Persona = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        nuevo = new javax.swing.JButton();
        guardar = new javax.swing.JButton();
        editar = new javax.swing.JButton();
        borrar = new javax.swing.JButton();
        buscar = new javax.swing.JButton();
        lbl_idPersona = new javax.swing.JLabel();
        lbl_id_persona = new javax.swing.JLabel();

        setClosable(true);
        setForeground(java.awt.Color.gray);
        setMaximizable(true);
        setResizable(true);
        setTitle("Agregar Persona");

        txtNombre_Apellidos.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        txtNombre_Apellidos.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        cedula.setFont(new java.awt.Font("Modern No. 20", 1, 18)); // NOI18N
        cedula.setForeground(java.awt.Color.darkGray);
        cedula.setText("Cedula");

        txtCedula.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        txtCedula.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel4.setFont(new java.awt.Font("Roboto Black", 1, 16)); // NOI18N
        jLabel4.setForeground(java.awt.Color.darkGray);
        jLabel4.setText("Colaborador:");

        nombreUsuario.setFont(new java.awt.Font("Roboto Black", 1, 16)); // NOI18N
        nombreUsuario.setForeground(java.awt.Color.darkGray);
        nombreUsuario.setText("nombreUsuario");

        direccion.setFont(new java.awt.Font("Modern No. 20", 1, 18)); // NOI18N
        direccion.setForeground(java.awt.Color.darkGray);
        direccion.setText("Direccion");

        telefono.setFont(new java.awt.Font("Modern No. 20", 1, 18)); // NOI18N
        telefono.setForeground(java.awt.Color.darkGray);
        telefono.setText("Télefono o Celular");

        txtDireccion.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        txtDireccion.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        cmbTipoPersona.setFont(new java.awt.Font("Dialog", 1, 16));
        cmbTipoPersona.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbTipoPersona.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        cmbTipoPersona.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbTipoPersonaActionPerformed(evt);
            }
        });

        txtClasificación.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        txtClasificación.setToolTipText("");
        txtClasificación.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        nombreApellidos.setFont(new java.awt.Font("Modern No. 20", 1, 18)); // NOI18N
        nombreApellidos.setForeground(java.awt.Color.darkGray);
        nombreApellidos.setText("Nombre y Apellidos");

        clasificación.setFont(new java.awt.Font("Modern No. 20", 1, 18)); // NOI18N
        clasificación.setForeground(java.awt.Color.darkGray);
        clasificación.setText("Clasificación");

        txtPhone.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        txtPhone.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        Persona.setFont(new java.awt.Font("Modern No. 20", 1, 18)); // NOI18N
        Persona.setForeground(java.awt.Color.darkGray);
        Persona.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Market-Research.png"))); // NOI18N

        nuevo.setBackground(new java.awt.Color(204, 204, 204));
        nuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/CRUD/multiple_accounts.png"))); // NOI18N
        nuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nuevoActionPerformed(evt);
            }
        });

        guardar.setBackground(new java.awt.Color(204, 204, 204));
        guardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/CRUD/document_save.png"))); // NOI18N
        guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarActionPerformed(evt);
            }
        });

        editar.setBackground(new java.awt.Color(204, 204, 204));
        editar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/CRUD/edit.png"))); // NOI18N
        editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editarActionPerformed(evt);
            }
        });

        borrar.setBackground(new java.awt.Color(204, 204, 204));
        borrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/CRUD/dustbin.png"))); // NOI18N
        borrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                borrarActionPerformed(evt);
            }
        });

        buscar.setBackground(new java.awt.Color(204, 204, 204));
        buscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/CRUD/searching-magnifying-glass.png"))); // NOI18N
        buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addComponent(nuevo)
                .addGap(18, 18, 18)
                .addComponent(guardar)
                .addGap(18, 18, 18)
                .addComponent(borrar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(editar)
                .addGap(24, 24, 24)
                .addComponent(buscar)
                .addContainerGap(414, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(buscar)
                    .addComponent(nuevo)
                    .addComponent(guardar)
                    .addComponent(borrar)
                    .addComponent(editar))
                .addContainerGap())
        );

        lbl_idPersona.setFont(new java.awt.Font("Modern No. 20", 1, 18)); // NOI18N
        lbl_idPersona.setForeground(java.awt.Color.darkGray);
        lbl_idPersona.setText("jLabel1");

        lbl_id_persona.setFont(new java.awt.Font("Modern No. 20", 1, 18)); // NOI18N
        lbl_id_persona.setForeground(java.awt.Color.darkGray);
        lbl_id_persona.setText("lblIdPersona");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(cmbTipoPersona, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtClasificación, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(lbl_id_persona))
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_idPersona)
                    .addComponent(nombreUsuario))
                .addContainerGap(423, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(10, 10, 10)
                            .addComponent(nombreApellidos)
                            .addGap(259, 259, 259)
                            .addComponent(cedula))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(260, 260, 260)
                            .addComponent(direccion))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(590, 590, 590)
                            .addComponent(Persona, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(10, 10, 10)
                            .addComponent(txtNombre_Apellidos, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(260, 260, 260)
                            .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(430, 430, 430)
                            .addComponent(txtCedula, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(10, 10, 10)
                            .addComponent(telefono))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(10, 10, 10)
                            .addComponent(clasificación))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(10, 10, 10)
                            .addComponent(txtPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(257, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(nombreUsuario))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtClasificación, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmbTipoPersona, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbl_id_persona)
                            .addComponent(lbl_idPersona))))
                .addGap(61, 61, 61))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(nombreApellidos)
                                .addComponent(cedula))
                            .addGap(70, 70, 70)
                            .addComponent(direccion)
                            .addGap(60, 60, 60)
                            .addComponent(Persona, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(100, 100, 100)
                            .addComponent(txtNombre_Apellidos, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(190, 190, 190)
                            .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(100, 100, 100)
                            .addComponent(txtCedula, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(160, 160, 160)
                            .addComponent(telefono))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(250, 250, 250)
                            .addComponent(clasificación))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(190, 190, 190)
                            .addComponent(txtPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGap(0, 30, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmbTipoPersonaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbTipoPersonaActionPerformed
        // TODO add your handling code here:

        try {
            
            String sqlConsulta_TPersona = "SELECT `idtipo_persona`, `desc_persona` FROM `tipo_persona` WHERE `desc_persona` = '" + cmbTipoPersona.getSelectedItem() + "'";
            pst = con.prepareStatement(sqlConsulta_TPersona);
            rs = pst.executeQuery();
            if (rs.next()) {
                String add1 = rs.getString("idtipo_persona");
                txtClasificación.setText(add1);

                String tipoPersonaSeleccionada;
                tipoPersonaSeleccionada = (String) cmbTipoPersona.getSelectedItem();

                if (tipoPersonaSeleccionada.equals("Cliente")) {
                    JOptionPane.showMessageDialog(Persona, "Bienvenido", tipoPersonaSeleccionada, JOptionPane.WARNING_MESSAGE);
                    
                }
                if (tipoPersonaSeleccionada.equals("Colaborador")) {
                    agregarPersona();
                    JOptionPane.showMessageDialog(Persona, "Tipo Persona", tipoPersonaSeleccionada, JOptionPane.WARNING_MESSAGE);
                    Colaborador_frm colaborador = new Colaborador_frm();
                    colaborador.setVisible(true);

                    Colaborador_frm.id_persona.setText(lbl_id_persona.getText());

                }
                if (tipoPersonaSeleccionada.equals("Proveedor")) {
                    JOptionPane.showMessageDialog(Persona, "Tipo Persona", tipoPersonaSeleccionada, JOptionPane.WARNING_MESSAGE);
                }

            }

        } catch (SQLException | HeadlessException | IOException e) {
            JOptionPane.showMessageDialog(null, e);

        }
    }//GEN-LAST:event_cmbTipoPersonaActionPerformed

    private void nuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nuevoActionPerformed
        // TODO add your handling code here:
        txtNombre_Apellidos.setEnabled(true);
        txtDireccion.setEnabled(true);
        txtPhone.setEnabled(true);
        txtClasificación.setEnabled(true);
        txtCedula.setEnabled(true);
        cmbTipoPersona.setEnabled(true);
        lbl_idPersona.setText("");
        txtNombre_Apellidos.setText("");
        txtPhone.setText("");
        txtClasificación.setText("");
        txtPhone.setText("");
        txtNombre_Apellidos.requestDefaultFocus();
        nuevo.setEnabled(false);
        guardar.setEnabled(true);
        buscar.setEnabled(false);
        editar.setEnabled(false);
        borrar.setEnabled(false);
    }//GEN-LAST:event_nuevoActionPerformed

    private void guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarActionPerformed

        agregarPersona();
    }//GEN-LAST:event_guardarActionPerformed

    private void editarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editarActionPerformed
        // TODO add your handling code here:

        try {
            int P = JOptionPane.showConfirmDialog(null, " Quiere editar este dato ?", "Confirmación", JOptionPane.YES_NO_OPTION);
            if (P == 0) {

                Statement stmt;
                stmt = con.createStatement();

                String Pru = "UPDATE `persona` SET `nombre` = '" + txtNombre_Apellidos.getText() + "',`cedula` = '" + txtCedula.getText() + "', `telefono` = '" + txtPhone.getText() + "',`direccion`='" + txtPhone.getText() + "',`tipo_persona_idtipo_persona`='" + txtClasificación.getText() + "' WHERE `idpersona`='" + lbl_idPersona.getText() + "'";
                pst = con.prepareStatement(Pru);
                pst.execute();
                JOptionPane.showMessageDialog(this, "Guardado con Exito saved", "Tipo de Usuario", JOptionPane.INFORMATION_MESSAGE);
                txtNombre_Apellidos.setText("");

                if (P == 1) {
                    txtNombre_Apellidos.setText("");

                }
            }

        } catch (HeadlessException | SQLException ex) {
            JOptionPane.showMessageDialog(this, ex);

        }
    }//GEN-LAST:event_editarActionPerformed

    private void borrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_borrarActionPerformed
        // TODO add your handling code here:
        try {
            int P = JOptionPane.showConfirmDialog(null, " Seguro que quiere eliminar ?", "Confirmation", JOptionPane.YES_NO_OPTION);
            if (P == 0) {

                //DELETE FROM `Horario_frm` WHERE `horario_id` = 4
                String sql = sqlDelete + lbl_idPersona.getText() + "";
                //String sql =
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

    private void buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarActionPerformed
        // TODO add your handling code here:
        Buscar_Persona_frm buscar_Persona_frm;
        try {
            buscar_Persona_frm = new Buscar_Persona_frm();
            buscar_Persona_frm.setVisible(true);
        } catch (IOException ex) {
            Logger.getLogger(Persona_frm.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_buscarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Persona;
    private javax.swing.JButton borrar;
    private javax.swing.JButton buscar;
    private javax.swing.JLabel cedula;
    private javax.swing.JLabel clasificación;
    private javax.swing.JComboBox<String> cmbTipoPersona;
    private javax.swing.JLabel direccion;
    private javax.swing.JButton editar;
    private javax.swing.JButton guardar;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lbl_idPersona;
    private javax.swing.JLabel lbl_id_persona;
    private javax.swing.JLabel nombreApellidos;
    public static javax.swing.JLabel nombreUsuario;
    private javax.swing.JButton nuevo;
    private javax.swing.JLabel telefono;
    private javax.swing.JTextField txtCedula;
    private javax.swing.JTextField txtClasificación;
    private javax.swing.JTextField txtDireccion;
    public static javax.swing.JTextField txtNombre_Apellidos;
    private javax.swing.JTextField txtPhone;
    // End of variables declaration//GEN-END:variables
}
