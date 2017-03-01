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
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author ace
 */
public class Gasto_Operativo_frm extends javax.swing.JFrame {

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

    public Gasto_Operativo_frm() throws IOException {
        initComponents();

        //inicialización de las variables de la coneccion a la base de datos
        con = ConexionDB.conexionDB();
        //llama al procedimiento de obtener la información.
        Get_Data();
        //centra la ventana para que se inicie en el centro del escritorio
        setLocationRelativeTo(null);
        initState();
        fechas();
        sqlSelect = "SELECT * FROM `gasto_operativo` ORDER BY `descripcion_gasto`";
        sqlSelect_Valor = "SELECT `gasto_id`, `descripcion_gasto`, `monto_gasto`, `fecha_gasto`, `factura_gasto`, `colaborador_empleado_id` FROM `gasto_operativo` WHERE descripcion_gasto = '";

        ////INSERT INTO `Horario_frm`(`descripcion_horario`) VALUES (" ")
        sqlInsert = "INSERT INTO `gasto_operativo`(`descripcion_gasto`, `monto_gasto`, `fecha_gasto`, `factura_gasto`, `colaborador_empleado_id`) VALUES ('";
        sqlDelete = "DELETE FROM `gasto_operativo` WHERE `gasto_id` = ";
    }

    public void fechas() {
        Date h = new Date();
        //SimpleDateFormat formato_Fecha = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        String date = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        SimpleDateFormat formato_Hora = new SimpleDateFormat("HH:mm:ss a", Locale.getDefault());
        //fechahora = new Date();

        //return formato_Fecha.format(fec);
        System.out.println(formato_Hora.format(h));
        txtFecha_Gasto.setText(date);
    }

    private void initState() {
        txtDetalle_Gasto.setEnabled(false);
        txtFecha_Gasto.setEnabled(false);
        txtN_Factura.setEnabled(false);
        txtPersona.setEnabled(false);
        txt_MontoGasto.setEnabled(false);
        lbl_Gasto_Operativo_id.setText("");
        txtDetalle_Gasto.setText("");
        nuevo.setEnabled(true);
        guardar.setEnabled(false);
        buscar.setEnabled(true);
        editar.setEnabled(false);
        borrar.setEnabled(false);
        Get_Data();

    }

    private void Get_Data() {
        //Select sobre el estatus_empleado y se le asigna el valor a la columna de la tabla del formulario.
        fechas();
        String sql = "SELECT `gasto_operativo`.`descripcion_gasto`, `gasto_operativo`.`monto_gasto`, `gasto_operativo`.`fecha_gasto`, `gasto_operativo`.`factura_gasto`, `gasto_operativo`.`colaborador_empleado_id`, `persona`.`nombre` FROM `pct3`.`colaborador` AS `colaborador`, `pct3`.`persona` AS `persona`, `pct3`.`gasto_operativo` AS `gasto_operativo` WHERE `colaborador`.`persona_idpersona` = `persona`.`idpersona` AND `gasto_operativo`.`colaborador_empleado_id` = `colaborador`.`empleado_id` AND `gasto_operativo`.`fecha_gasto` = '" + txtFecha_Gasto.getText() + "'";

        try {
            pst = con.prepareStatement(sql);

            rs = pst.executeQuery();

            tblTipoPersona.setModel(DbUtils.resultSetToTableModel(rs));

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);

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

        txtDetalle_Gasto = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txt_MontoGasto = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtPersona = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtFecha_Gasto = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtN_Factura = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblTipoPersona = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        nuevo = new javax.swing.JButton();
        guardar = new javax.swing.JButton();
        editar = new javax.swing.JButton();
        borrar = new javax.swing.JButton();
        buscar = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        fondo = new javax.swing.JLabel();
        lbl_id_persona = new javax.swing.JLabel();
        lbl_Gasto_Operativo_id = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        mnuSalir = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Gastos Operativos");
        setUndecorated(true);
        setResizable(false);
        setType(java.awt.Window.Type.UTILITY);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtDetalle_Gasto.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        getContentPane().add(txtDetalle_Gasto, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 40, 200, 40));

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jLabel3.setText("Monto del Gasto");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 10, -1, -1));

        txt_MontoGasto.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        getContentPane().add(txt_MontoGasto, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 40, 200, 40));

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jLabel4.setText("Fecha Gasto");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 10, -1, -1));

        txtPersona.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        txtPersona.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPersonaActionPerformed(evt);
            }
        });
        txtPersona.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPersonaKeyTyped(evt);
            }
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtPersonaKeyPressed(evt);
            }
        });
        getContentPane().add(txtPersona, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 130, 440, 40));

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jLabel6.setText("Factura #");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 100, -1, -1));

        txtFecha_Gasto.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        getContentPane().add(txtFecha_Gasto, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 40, 200, 40));

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jLabel7.setText("Detalle Gasto");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 10, -1, -1));

        jLabel8.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jLabel8.setText("Persona");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 100, -1, -1));

        txtN_Factura.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        txtN_Factura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtN_FacturaActionPerformed(evt);
            }
        });
        getContentPane().add(txtN_Factura, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 130, 200, 40));

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Listas de Puestos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 0, 14), new java.awt.Color(255, 255, 255))); // NOI18N

        tblTipoPersona.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        tblTipoPersona.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Puesto", "Hora Sencilla", "Hora Extra"
            }
        ));
        tblTipoPersona.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblTipoPersonaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblTipoPersona);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 190, 730, 220));

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

        fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icons/FondoAzul.png"))); // NOI18N
        getContentPane().add(fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 850, 420));

        lbl_id_persona.setText("jLabel1");
        getContentPane().add(lbl_id_persona, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 100, -1, -1));

        lbl_Gasto_Operativo_id.setText("jLabel1");
        getContentPane().add(lbl_Gasto_Operativo_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 110, -1, -1));

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
        txtDetalle_Gasto.setEnabled(true);

        txtFecha_Gasto.setEnabled(true);
        txtN_Factura.setEnabled(true);
        txtPersona.setEnabled(true);
        txt_MontoGasto.setEnabled(true);

        lbl_Gasto_Operativo_id.setText("");
        txtDetalle_Gasto.setText("");
        txtN_Factura.setText("");
        txtPersona.setText("");
        txtN_Factura.setText("");

        txtDetalle_Gasto.requestDefaultFocus();
        nuevo.setEnabled(false);
        guardar.setEnabled(true);
        buscar.setEnabled(false);
        editar.setEnabled(false);
        borrar.setEnabled(false);
    }//GEN-LAST:event_nuevoActionPerformed

    private void guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarActionPerformed
        // TODO add your handling code here:
        try {
            int P = JOptionPane.showConfirmDialog(null, " Quiere agregar otro dato ?", "Confirmación", JOptionPane.YES_NO_OPTION);
            if (P == 0) {
                con = ConexionDB.conexionDB();

                if (txtDetalle_Gasto.getText().equals("")) {
                    JOptionPane.showMessageDialog(this, "Favor ingresa el  detalle del gasto ", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                if (txtFecha_Gasto.getText().equals("")) {
                    JOptionPane.showMessageDialog(this, "Favor ingresa la fecha del gasto ", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                if (txtN_Factura.getText().equals("")) {
                    JOptionPane.showMessageDialog(this, "Favor ingresa el número de la factura ", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                if (txtPersona.getText().equals("")) {
                    JOptionPane.showMessageDialog(this, "Favor ingresa el nombre de la persona que realizo el gasto ", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                if (txt_MontoGasto.getText().equals("")) {
                    JOptionPane.showMessageDialog(this, "Favor ingresa el  valor del gasto!", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                Statement stmt;
                stmt = con.createStatement();
                
                String sql1 = sqlSelect_Valor + txtN_Factura.getText() + "'";
                rs = stmt.executeQuery(sql1);
                if (rs.next()) {
                    JOptionPane.showMessageDialog(this, "Valor ya existe.", "Error", JOptionPane.ERROR_MESSAGE);
                    txtDetalle_Gasto.setText("");
                    txtDetalle_Gasto.requestDefaultFocus();
                    return;
                }
                String sql = "INSERT INTO `gasto_operativo`(`descripcion_gasto`, `monto_gasto`, `fecha_gasto`, `factura_gasto`, `colaborador_empleado_id`) VALUES ('" + txtDetalle_Gasto.getText() + "','" + txt_MontoGasto.getText() + "','" + txtFecha_Gasto.getText() + "','" + txtN_Factura.getText() + "','" +lbl_id_persona.getText() + "')";
                pst = con.prepareStatement(sql);
                pst.execute();
                JOptionPane.showMessageDialog(this, "Guardado con Exito saved", "Gasto Operativo", JOptionPane.INFORMATION_MESSAGE);
                txtDetalle_Gasto.setText("");
                Get_Data();

            }
            if (P == 1) {
                String sql = "INSERT INTO `gasto_operativo`(`descripcion_gasto`, `monto_gasto`, `fecha_gasto`, `factura_gasto`, `colaborador_empleado_id`) VALUES ('" + txtDetalle_Gasto.getText() + "','" + txt_MontoGasto.getText() + "','" + txtFecha_Gasto.getText() + "','" + txtN_Factura.getText() + "','" +lbl_id_persona.getText() + "')";
                pst = con.prepareStatement(sql);
                pst.execute();
                JOptionPane.showMessageDialog(this, "Guardado con Exito saved", "Gasto Operativo", JOptionPane.INFORMATION_MESSAGE);
                txtDetalle_Gasto.setText("");
                Get_Data();
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
                con = ConexionDB.conexionDB();
                Statement stmt;
                stmt = con.createStatement();
//                String sql1 = sqlSelect_Valor + txtDetalle_Gasto.getText() + "'";
//                rs = stmt.executeQuery(sql1);
//                if (rs.next()) {
//                    JOptionPane.showMessageDialog(this, "Dato existente.", "Error", JOptionPane.ERROR_MESSAGE);
//                    txtDetalle_Gasto.setText("");
//                    txtDetalle_Gasto.requestDefaultFocus();
//
//                    return;
//                }
                String Pru = "UPDATE `gasto_operativo` SET `descripcion_gasto` = '" + txtDetalle_Gasto.getText() + "',`monto_gasto` = '" + txt_MontoGasto.getText() + "', `fecha_gasto` = '"+ txtFecha_Gasto.getText() + "',`factura_gasto`='" + txtN_Factura.getText() +"',`colaborador_empleado_id`='" + lbl_id_persona.getText() +  "' WHERE `gasto_id`='" + lbl_Gasto_Operativo_id.getText() + "'";
                
                pst = con.prepareStatement(Pru);
                pst.execute();
                JOptionPane.showMessageDialog(this, "Guardado con Exito saved", "Tipo de Usuario", JOptionPane.INFORMATION_MESSAGE);
                txtDetalle_Gasto.setText("");
                Get_Data();
                if (P == 1) {
                    txtDetalle_Gasto.setText("");
                    Get_Data();
                }
            }

        } catch (HeadlessException | SQLException ex) {
            JOptionPane.showMessageDialog(this, ex);
        }

    }//GEN-LAST:event_editarActionPerformed

    private void buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarActionPerformed
        // TODO add your handling code here:
        txtDetalle_Gasto.setEnabled(true);
        txtFecha_Gasto.setEnabled(true);
        txtN_Factura.setEnabled(true);
        txtPersona.setEnabled(true);
        txt_MontoGasto.setEnabled(true);
        txtDetalle_Gasto.setText("");
        
        txtFecha_Gasto.setText("");
        txtN_Factura.setText("");
        txtPersona.setText("");
        txt_MontoGasto.setText("");

        nuevo.setEnabled(false);
        guardar.setEnabled(false);
        buscar.setEnabled(false);
        editar.setEnabled(true);
        borrar.setEnabled(true);
    }//GEN-LAST:event_buscarActionPerformed

    private void tblTipoPersonaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblTipoPersonaMouseClicked
        // TODO add your handling code here:
        try {
            con = ConexionDB.conexionDB();
            int row = tblTipoPersona.getSelectedRow();
            String tabla_click = tblTipoPersona.getModel().getValueAt(row, 0).toString();
            //SELECT `estado_empleado` FROM `estatus_empleado` WHERE `estado_empleado` = 'Activo'
            String sql = sqlSelect_Valor + tabla_click + "'";
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            if (rs.next()) {
                String add1 = rs.getString("gasto_id");
                lbl_Gasto_Operativo_id.setText(add1);
                String add2 = rs.getString("descripcion_gasto");
                txtDetalle_Gasto.setText(add2);
                String add3 = rs.getString("monto_gasto");
                txt_MontoGasto.setText(add3);
                String add4 = rs.getString("fecha_gasto");
                txtFecha_Gasto.setText(add4);
                String add5 = rs.getString("factura_gasto");
                txtN_Factura.setText(add5);
                String add6 = rs.getString("colaborador_empleado_id");
                lbl_id_persona.setText(add6);
                if (lbl_id_persona.getText().length()!=0)
                {
                    String sql2 = "SELECT `colaborador`.`empleado_id` as 'idEmpleado', `persona`.`nombre` as 'Nombre' FROM `pct3`.`colaborador` AS `colaborador`, `pct3`.`persona` AS `persona` WHERE `colaborador`.`persona_idpersona` = `persona`.`idpersona` AND `colaborador`.`empleado_id` = '"+ lbl_id_persona.getText() +"'";
                    pst2 = con.prepareStatement(sql2);
                    rs2 = pst.executeQuery();
                    if (rs2.next())
                    {
                        String add7 = rs2.getString(6);
                        txtPersona.setText(add7);
                    }
                }
                System.out.println(add1);
                System.out.println(add6);

            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex);
        }
    }//GEN-LAST:event_tblTipoPersonaMouseClicked

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
                Get_Data();
            }
            initState();
            Get_Data();

        } catch (HeadlessException | SQLException ex) {
            JOptionPane.showMessageDialog(this, ex);
      }
    }//GEN-LAST:event_borrarActionPerformed

    private void txtPersonaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPersonaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPersonaActionPerformed

    private void txtN_FacturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtN_FacturaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtN_FacturaActionPerformed

    private void txtPersonaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPersonaKeyPressed
        // TODO add your handling code here:

        
    }//GEN-LAST:event_txtPersonaKeyPressed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        txtDetalle_Gasto.setEnabled(false);

        txtFecha_Gasto.setEnabled(false);
        txtN_Factura.setEnabled(false);
        txtPersona.setEnabled(false);
        txt_MontoGasto.setEnabled(false);

        lbl_Gasto_Operativo_id.setText("");
        txtDetalle_Gasto.setText("");
        txtN_Factura.setText("");
        txtPersona.setText("");
        txtN_Factura.setText("");

        txtDetalle_Gasto.requestDefaultFocus();
        nuevo.setEnabled(true);
        guardar.setEnabled(false);
        buscar.setEnabled(false);
        editar.setEnabled(false);
        borrar.setEnabled(false);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtPersonaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPersonaKeyTyped
        // TODO add your handling code here:
        try {
            //SELECT `persona`.`nombre`, `colaborador`.`empleado_id` FROM `pct3`.`colaborador` AS `colaborador`, `pct3`.`persona` AS `persona` WHERE `colaborador`.`persona_idpersona` = `persona`.`idpersona` AND `persona`.`nombre` LIKE "%Thom
            String sql_persona = "SELECT `persona`.`nombre` AS 'Nombre', `colaborador`.`empleado_id` AS 'EMPLEADO_ID' FROM `pct3`.`colaborador` AS `colaborador`, `pct3`.`persona` AS `persona` WHERE `colaborador`.`persona_idpersona` = `persona`.`idpersona` AND `persona`.`nombre` LIKE '%" + txtPersona.getText() + "%'";
            pst = con.prepareStatement(sql_persona);

            rs = pst.executeQuery();
            if (rs.next()) {
                String add1 = rs.getString("EMPLEADO_ID");
                lbl_id_persona.setText(add1);

                System.out.println(add1);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);

        }
    }//GEN-LAST:event_txtPersonaKeyTyped

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
            java.util.logging.Logger.getLogger(Gasto_Operativo_frm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            try {
                new Gasto_Operativo_frm().setVisible(true);
            } catch (IOException ex) {
                Logger.getLogger(Gasto_Operativo_frm.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton borrar;
    private javax.swing.JButton buscar;
    private javax.swing.JButton editar;
    private javax.swing.JLabel fondo;
    private javax.swing.JButton guardar;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_Gasto_Operativo_id;
    private javax.swing.JLabel lbl_id_persona;
    private javax.swing.JMenu mnuSalir;
    private javax.swing.JButton nuevo;
    private javax.swing.JTable tblTipoPersona;
    private javax.swing.JTextField txtDetalle_Gasto;
    private javax.swing.JTextField txtFecha_Gasto;
    private javax.swing.JTextField txtN_Factura;
    private javax.swing.JTextField txtPersona;
    private javax.swing.JTextField txt_MontoGasto;
    // End of variables declaration//GEN-END:variables
}
