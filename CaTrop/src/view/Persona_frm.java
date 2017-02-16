/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import com.sun.glass.events.KeyEvent;
import controller.ConexionDB;
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
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author ace
 */
public final class Persona_frm extends javax.swing.JFrame {

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

    private String id_Persona;

    public JLabel getLbl_Gasto_Operativo_id() {
        return lbl_Gasto_Operativo_id;
    }

    public void setLbl_Gasto_Operativo_id(JLabel lbl_Gasto_Operativo_id) {
        this.lbl_Gasto_Operativo_id = lbl_Gasto_Operativo_id;
    }

    public JLabel getLbl_id_persona() {
        return lbl_id_persona;
    }

    public void setLbl_id_persona(JLabel lbl_id_persona) {
        this.lbl_id_persona = lbl_id_persona;
    }

    //declarar static e instanciarla en tu contructor`
    static DefaultComboBoxModel modelo;

    public Persona_frm() throws IOException {
        initComponents();

        //inicialización de las variables de la coneccion a la base de datos
        con = ConexionDB.conexionDB();
        //llama al procedimiento de obtener la información.

        //centra la ventana para que se inicie en el centro del escritorio
        setLocationRelativeTo(null);
        initState();
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
        nuevo.setEnabled(true);
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
        Persona = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        nuevo = new javax.swing.JButton();
        guardar = new javax.swing.JButton();
        editar = new javax.swing.JButton();
        borrar = new javax.swing.JButton();
        buscar = new javax.swing.JButton();
        volver = new javax.swing.JButton();
        fondo = new javax.swing.JLabel();
        lbl_Gasto_Operativo_id = new javax.swing.JLabel();
        lbl_id_persona = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        mnuSalir = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Agregar Nueva Persona");
        setMaximumSize(new java.awt.Dimension(818, 401));
        setMinimumSize(new java.awt.Dimension(818, 401));
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(818, 401));
        setResizable(false);
        setType(java.awt.Window.Type.UTILITY);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtNombre_Apellidos.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
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

        cmbTipoPersona.setFont(new java.awt.Font("Dialog", 1, 16));
        cmbTipoPersona.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbTipoPersona.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbTipoPersonaActionPerformed(evt);
            }
        });
        getContentPane().add(cmbTipoPersona, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 220, 200, 40));

        txtClasificación.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        getContentPane().add(txtClasificación, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 220, 200, 40));

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jLabel7.setText("Nombre y Apellidos");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 10, -1, -1));

        jLabel8.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jLabel8.setText("Clasificación");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 190, -1, -1));

        txtPhone.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        getContentPane().add(txtPhone, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 130, 200, 40));

        Persona.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icons/usuario.png"))); // NOI18N
        getContentPane().add(Persona, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 190, 150, 150));

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

        volver.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icons/CRUD/volver.png"))); // NOI18N
        volver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                volverActionPerformed(evt);
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
                    .addComponent(volver))
                .addContainerGap(12, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(volver)
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

        fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icons/FondoAzul.png"))); // NOI18N
        getContentPane().add(fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 850, 380));

        lbl_Gasto_Operativo_id.setText("jLabel1");
        getContentPane().add(lbl_Gasto_Operativo_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 290, -1, -1));

        lbl_id_persona.setText("jLabel1");
        getContentPane().add(lbl_id_persona, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 290, -1, -1));

        jMenu1.setText("File");

        mnuSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icons/exit-sign.png"))); // NOI18N
        mnuSalir.setMnemonic(KeyEvent.VK_X);
        mnuSalir.setText("Salir");
        mnuSalir.setBorderPainted(false);
        mnuSalir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        mnuSalir.setName(""); // NOI18N
        mnuSalir.addMenuKeyListener(new javax.swing.event.MenuKeyListener() {
            public void menuKeyPressed(javax.swing.event.MenuKeyEvent evt) {
                mnuSalirMenuKeyPressed(evt);
            }
            public void menuKeyReleased(javax.swing.event.MenuKeyEvent evt) {
            }
            public void menuKeyTyped(javax.swing.event.MenuKeyEvent evt) {
            }
        });
        mnuSalir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mnuSalirMouseClicked(evt);
            }
        });
        jMenu1.add(mnuSalir);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mnuSalirMenuKeyPressed(javax.swing.event.MenuKeyEvent evt) {//GEN-FIRST:event_mnuSalirMenuKeyPressed


    }//GEN-LAST:event_mnuSalirMenuKeyPressed

    private void mnuSalirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mnuSalirMouseClicked
        // TODO add your handling code here:
        dispose();

    }//GEN-LAST:event_mnuSalirMouseClicked

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
                con = ConexionDB.conexionDB();
                Statement stmt;
                stmt = con.createStatement();

                String Pru = "UPDATE `persona` SET `nombre` = '" + txtNombre_Apellidos.getText() + "',`cedula` = '" + txtCedula.getText() + "', `telefono` = '" + txtPhone.getText() + "',`direccion`='" + txtPhone.getText() + "',`tipo_persona_idtipo_persona`='" + txtClasificación.getText() + "' WHERE `idpersona`='" + lbl_Gasto_Operativo_id.getText() + "'";
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

        } catch (IOException ex) {
            Logger.getLogger(Persona_frm.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_editarActionPerformed

    public void accion_buscar() {
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
        editar.setEnabled(false);
        borrar.setEnabled(false);
    }
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

    private void borrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_borrarActionPerformed
        // TODO add your handling code here:
        try {
            int P = JOptionPane.showConfirmDialog(null, " Seguro que quiere eliminar ?", "Confirmation", JOptionPane.YES_NO_OPTION);
            if (P == 0) {
                con = ConexionDB.conexionDB();
                //DELETE FROM `Horario_frm` WHERE `horario_id` = 4
                String sql = sqlDelete + lbl_Gasto_Operativo_id.getText() + "";
                //String sql = "DELETE FROM `horario` WHERE `horario_id`='" + lbl_Horario_id.getText() + "'";
                pst = con.prepareStatement(sql);
                pst.execute();
                JOptionPane.showMessageDialog(this, "Successfully deleted", "Record", JOptionPane.INFORMATION_MESSAGE);
                initState();

            }
            initState();

        } catch (HeadlessException | SQLException ex) {
            JOptionPane.showMessageDialog(this, ex);

        } catch (IOException ex) {
            Logger.getLogger(Persona_frm.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_borrarActionPerformed

    private void volverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_volverActionPerformed
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
    }//GEN-LAST:event_volverActionPerformed

    private void txtCedulaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCedulaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCedulaActionPerformed

    private void agregarPersona() {
        try {
            int P = JOptionPane.showConfirmDialog(null, " Quiere agregar otro dato ?", "Confirmación", JOptionPane.YES_NO_OPTION);
            if (P == 0) {
                con = ConexionDB.conexionDB();

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
                    //SELECT `idpersona`, `nombre`, `cedula`, `telefono`, `direccion`, `tipo_persona_idtipo_persona` FROM `persona` WHERE 1
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
                        lbl_Gasto_Operativo_id.setText(sel6);
                        cmbTipoPersona.setSelectedIndex(Integer.parseInt(sel6) - 1);

                    }

                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e);

                }

            }
            if (P == 1) {
                String sql = sqlInsert + txtNombre_Apellidos.getText() + "','" + txtCedula.getText() + "','" + txtPhone.getText() + "','" + txtDireccion.getText() + "','" + txtClasificación.getText() + "')";
                pst = con.prepareStatement(sql);
                pst.execute();
                JOptionPane.showMessageDialog(this, "Guardado con Exito saved", "Gasto Operativo", JOptionPane.INFORMATION_MESSAGE);

                try {
                    //SELECT `idpersona`, `nombre`, `cedula`, `telefono`, `direccion`, `tipo_persona_idtipo_persona` FROM `persona` WHERE 1
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
                        lbl_Gasto_Operativo_id.setText(sel6);
                        cmbTipoPersona.setSelectedIndex(Integer.parseInt(sel6) - 1);

                    }

                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e);

                }

            }

        } catch (HeadlessException | SQLException ex) {
            JOptionPane.showMessageDialog(this, ex);

        } catch (IOException ex) {
            Logger.getLogger(Persona_frm.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

    }
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

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);

        }
    }//GEN-LAST:event_cmbTipoPersonaActionPerformed

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
            java.util.logging.Logger.getLogger(Persona_frm.class
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

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            try {
                new Persona_frm().setVisible(true);

            } catch (IOException ex) {
                Logger.getLogger(Persona_frm.class
                        .getName()).log(Level.SEVERE, null, ex);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Persona;
    private javax.swing.JButton borrar;
    private javax.swing.JButton buscar;
    private javax.swing.JComboBox<String> cmbTipoPersona;
    private javax.swing.JButton editar;
    private javax.swing.JLabel fondo;
    private javax.swing.JButton guardar;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lbl_Gasto_Operativo_id;
    private javax.swing.JLabel lbl_id_persona;
    private javax.swing.JMenu mnuSalir;
    private javax.swing.JButton nuevo;
    private javax.swing.JTextField txtCedula;
    private javax.swing.JTextField txtClasificación;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtNombre_Apellidos;
    private javax.swing.JTextField txtPhone;
    private javax.swing.JButton volver;
    // End of variables declaration//GEN-END:variables
}
