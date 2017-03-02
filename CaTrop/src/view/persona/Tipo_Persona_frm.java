/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.persona;

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
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author ace
 */
public class Tipo_Persona_frm extends javax.swing.JFrame {

    /**
     * Creates new form puesto
     */
    Connection con = null;
    ResultSet rs = null;
    PreparedStatement pst = null;
    String sqlSelect;
    String sqlSelect_Valor;
    String sqlInsert;
    String sqlDelete;

    public Tipo_Persona_frm() throws IOException {
        initComponents();
        

        //inicialización de las variables de la coneccion a la base de datos
        con = ConexionDB.conexionDB();
        //llama al procedimiento de obtener la información.
        Get_Data();
        //centra la ventana para que se inicie en el centro del escritorio
        setLocationRelativeTo(null);
        initState();
        sqlSelect = "SELECT `desc_persona` as Descripción de Persona FROM `tipo_persona` ORDER BY `desc_persona`";
        sqlSelect_Valor = "SELECT `idtipo_persona`, `desc_persona` FROM `tipo_persona` WHERE `desc_persona` = '";

        ////INSERT INTO `Horario_frm`(`descripcion_horario`) VALUES (" ")
        sqlInsert = "INSERT INTO `tipo_persona`(`desc_persona`) VALUES ('";
        sqlDelete = "DELETE FROM `tipo_persona` WHERE `idtipo_persona` = ";
    }

    private void initState() {
        txtTipo_Persona.setEnabled(false);
        lbl_Horario_id.setText("");
        txtTipo_Persona.setText("");
        nuevo.setEnabled(true);
        guardar.setEnabled(false);
        buscar.setEnabled(true);
        editar.setEnabled(false);
        borrar.setEnabled(false);
        Get_Data();

    }

    private void Get_Data() {
        //Select sobre el estatus_empleado y se le asigna el valor a la columna de la tabla del formulario.
        String sql = "SELECT `desc_persona` as 'Descripción de Persona' FROM `tipo_persona` ORDER BY `desc_persona`";

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

        txtTipo_Persona = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblTipoPersona = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        nuevo = new javax.swing.JButton();
        guardar = new javax.swing.JButton();
        editar = new javax.swing.JButton();
        borrar = new javax.swing.JButton();
        buscar = new javax.swing.JButton();
        fondo = new javax.swing.JLabel();
        lbl_Horario_id = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        mnuSalir = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Tipo Persona");
        setUndecorated(true);
        setResizable(false);
        setType(java.awt.Window.Type.UTILITY);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtTipo_Persona.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        getContentPane().add(txtTipo_Persona, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 100, 270, 40));

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jLabel3.setText("Tipo de Persona");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 70, -1, -1));

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

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 180, 450, 120));

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
                    .addComponent(borrar))
                .addContainerGap(12, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(nuevo)
                .addGap(18, 18, 18)
                .addComponent(guardar)
                .addGap(18, 18, 18)
                .addComponent(editar)
                .addGap(18, 18, 18)
                .addComponent(buscar)
                .addGap(18, 18, 18)
                .addComponent(borrar)
                .addContainerGap(47, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 90, 350));

        fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icons/FondoAzul.png"))); // NOI18N
        getContentPane().add(fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 650, 350));

        lbl_Horario_id.setText("jLabel1");
        getContentPane().add(lbl_Horario_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 110, -1, -1));

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
        txtTipo_Persona.setText("");
        txtTipo_Persona.setEnabled(true);
        txtTipo_Persona.requestDefaultFocus();
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
                if (txtTipo_Persona.getText().equals("")) {
                    JOptionPane.showMessageDialog(this, "Favor ingresa el  valor ", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                Statement stmt;
                stmt = con.createStatement();
                String sql1 = sqlSelect_Valor + txtTipo_Persona.getText() + "'";
                rs = stmt.executeQuery(sql1);
                if (rs.next()) {
                    JOptionPane.showMessageDialog(this, "Valor ya existe.", "Error", JOptionPane.ERROR_MESSAGE);
                    txtTipo_Persona.setText("");
                    txtTipo_Persona.requestDefaultFocus();
                    return;
                }
                //INSERT INTO `puesto`(`descripcion_puesto`, `pago_hora_sencilla`, `pago_hora_extra`) VALUES ('Administrador',5000,10000)
                //INSERT INTO `Horario_frm`(`descripcion_horario`) VALUES (" ")
                String sql = sqlInsert + txtTipo_Persona.getText() + "')";
                pst = con.prepareStatement(sql);
                pst.execute();
                JOptionPane.showMessageDialog(this, "Guardado con Exito saved", "Tipo de Usuario", JOptionPane.INFORMATION_MESSAGE);
                txtTipo_Persona.setText("");
                Get_Data();

            }
            if (P == 1) {
                //INSERT INTO `puesto`(`descripcion_puesto`, `pago_hora_sencilla`, `pago_hora_extra`) VALUES ('Administrador',5000,10000)
                String sql = sqlInsert + txtTipo_Persona.getText() + "')";
                pst = con.prepareStatement(sql);
                pst.execute();
                JOptionPane.showMessageDialog(this, "Guardado con Exito saved", "Tipo de Usuario", JOptionPane.INFORMATION_MESSAGE);
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
                String sql1 = sqlSelect_Valor + txtTipo_Persona.getText() + "'";
                rs = stmt.executeQuery(sql1);
                if (rs.next()) {
                    JOptionPane.showMessageDialog(this, "Dato existente.", "Error", JOptionPane.ERROR_MESSAGE);
                    txtTipo_Persona.setText("");
                    txtTipo_Persona.requestDefaultFocus();

                    return;
                }
                //UPDATE `tipo_persona` SET `desc_persona`=[value-2] WHERE 1
                String sql = "UPDATE `tipo_persona` SET `desc_persona` = '" + txtTipo_Persona.getText() + "' WHERE `idtipo_persona`= '" + lbl_Horario_id.getText() + "'";
                pst = con.prepareStatement(sql);
                pst.execute();
                JOptionPane.showMessageDialog(this, "Guardado con Exito saved", "Tipo de Usuario", JOptionPane.INFORMATION_MESSAGE);
                txtTipo_Persona.setText("");
                Get_Data();
                if (P == 1) {
                    txtTipo_Persona.setText("");
                    Get_Data();
                }
            }

        } catch (HeadlessException | SQLException ex) {
            JOptionPane.showMessageDialog(this, ex);
        }

    }//GEN-LAST:event_editarActionPerformed

    private void buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarActionPerformed
        // TODO add your handling code here:
        txtTipo_Persona.setEnabled(true);

        txtTipo_Persona.setText("");

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
                String add1 = rs.getString("idtipo_persona");
                lbl_Horario_id.setText(add1);
                String add2 = rs.getString("desc_persona");

                txtTipo_Persona.setText(add2);

                System.out.println(add1);

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
                String sql = sqlDelete + lbl_Horario_id.getText() + "";
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
            java.util.logging.Logger.getLogger(Tipo_Persona_frm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            try {
                new Tipo_Persona_frm().setVisible(true);
            } catch (IOException ex) {
                Logger.getLogger(Tipo_Persona_frm.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton borrar;
    private javax.swing.JButton buscar;
    private javax.swing.JButton editar;
    private javax.swing.JLabel fondo;
    private javax.swing.JButton guardar;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_Horario_id;
    private javax.swing.JMenu mnuSalir;
    private javax.swing.JButton nuevo;
    private javax.swing.JTable tblTipoPersona;
    private javax.swing.JTextField txtTipo_Persona;
    // End of variables declaration//GEN-END:variables
}