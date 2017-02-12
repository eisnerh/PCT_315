/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.planilla;

import controller.conexionDB;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author ace
 */
public class statEmpleado extends javax.swing.JFrame {

    /**
     * Creates new form statEmpleado
     */
    private String text = "Estados de los empleados, "
            + "ya sea Activo o Inactivo...";
    //Variables para las conecciones a la base de datos.

    Connection con = null;
    ResultSet rs = null;
    PreparedStatement pst = null;
    
    
    public statEmpleado() {
        initComponents();
        id_empleado.setText(text);
        id_empleado.setVisible(false);
        //inicialización de las variables de la coneccion a la base de datos
        con = conexionDB.conexionDB();
        //llama al procedimiento de obtener la información.
        Get_Data();
        //centra la ventana para que se inicie en el centro del escritorio
        setLocationRelativeTo(null);
    }
    
    private void Get_Data() {

        //Select sobre el estatus_empleado y se le asigna el valor a la columna de la tabla del formulario.
        String sql = "SELECT estado_empleado as 'Estado Empleado' FROM estatus_empleado WHERE 1 ORDER BY estado_empleado";
        
        try {
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            tbl_estadoEmpleado.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            
        }
    }
    
    private void Reset() {
        
        txt_stat_emp.setText("");
        btnGuardar.setEnabled(true);
        btnActualizar.setEnabled(false);
        btnDelete.setEnabled(false);
        id_empleado.setText(text);
        Get_Data();
        
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
        tbl_estadoEmpleado = new javax.swing.JTable();
        btnGuardar = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        id_empleado = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txt_stat_emp = new javax.swing.JTextField();
        fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tbl_estadoEmpleado.setFont(new java.awt.Font("Roboto Black", 0, 12)); // NOI18N
        tbl_estadoEmpleado.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Estado Empleado"
            }
        ));
        tbl_estadoEmpleado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_estadoEmpleadoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_estadoEmpleado);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 150, 600, 100));

        btnGuardar.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icons/diskette.png"))); // NOI18N
        btnGuardar.setText("Guardar");
        btnGuardar.setMaximumSize(new java.awt.Dimension(99, 32));
        btnGuardar.setPreferredSize(new java.awt.Dimension(99, 32));
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        getContentPane().add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 10, 120, -1));

        btnActualizar.setFont(new java.awt.Font("Roboto Black", 0, 18)); // NOI18N
        btnActualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icons/rotate.png"))); // NOI18N
        btnActualizar.setText("Editar");
        btnActualizar.setMaximumSize(new java.awt.Dimension(99, 32));
        btnActualizar.setMinimumSize(new java.awt.Dimension(99, 32));
        btnActualizar.setPreferredSize(new java.awt.Dimension(99, 32));
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });
        getContentPane().add(btnActualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 10, 120, -1));

        btnDelete.setFont(new java.awt.Font("Dialog", 3, 18)); // NOI18N
        btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icons/office-material.png"))); // NOI18N
        btnDelete.setText("Borrar");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });
        getContentPane().add(btnDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 10, 120, -1));

        id_empleado.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        id_empleado.setAutoscrolls(true);
        id_empleado.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(id_empleado, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 60, 46));

        jLabel2.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel2.setText("Status del Empleado");
        jLabel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 600, 80));

        txt_stat_emp.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        getContentPane().add(txt_stat_emp, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 600, 60));

        fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icons/FondoAzul.png"))); // NOI18N
        getContentPane().add(fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 610, 300));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        try {
            con = conexionDB.conexionDB();
            if (txt_stat_emp.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Favor ingresa el nuevo estado del empleado", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            Statement stmt;
            stmt = con.createStatement();
            //SELECT estado_empleado as 'Estado Empleado' FROM estatus_empleado WHERE 1 ORDER BY estado_empleado
            String sql1 = "SELECT estado_empleado FROM estatus_empleado WHERE estado_empleado= '" + txt_stat_emp.getText() + "'";
            rs = stmt.executeQuery(sql1);
            if (rs.next()) {
                JOptionPane.showMessageDialog(this, "Estado existente.", "Error", JOptionPane.ERROR_MESSAGE);
                txt_stat_emp.setText("");
                txt_stat_emp.requestDefaultFocus();
                return;
            }
            String sql = "INSERT INTO estatus_empleado(estado_empleado) VALUES ('" + txt_stat_emp.getText() + "')";
            
            pst = con.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(this, "Successfully saved", "Doctor Record", JOptionPane.INFORMATION_MESSAGE);
            Reset();
            
        } catch (HeadlessException | SQLException ex) {
            JOptionPane.showMessageDialog(this, ex);
            
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void tbl_estadoEmpleadoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_estadoEmpleadoMouseClicked
        // TODO add your handling code here:
        try {
            con = conexionDB.conexionDB();
            int row = tbl_estadoEmpleado.getSelectedRow();
            String tabla_click = tbl_estadoEmpleado.getModel().getValueAt(row, 0).toString();
            //SELECT `estado_empleado` FROM `estatus_empleado` WHERE `estado_empleado` = 'Activo'
            String sql = "SELECT `id_estado_empleado`,`estado_empleado` FROM `estatus_empleado` WHERE `estado_empleado` = '" + tabla_click + "'";
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            if (rs.next()) {
                String add1 = rs.getString("id_estado_empleado");
                id_empleado.setText(add1);
                String add2 = rs.getString("estado_empleado");
                txt_stat_emp.setText(add2);
                btnGuardar.setEnabled(false);
                btnActualizar.setEnabled(true);
                btnDelete.setEnabled(true);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex);
        }
    }//GEN-LAST:event_tbl_estadoEmpleadoMouseClicked

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        // TODO add your handling code here:
        try {
            con = conexionDB.conexionDB();

            //UPDATE `estatus_empleado` SET `estado_empleado`='A' WHERE `estado_empleado` = 'Cualquiera'
            String sql = "UPDATE `estatus_empleado` SET `estado_empleado`='" + txt_stat_emp.getText() + "' WHERE `id_estado_empleado` = '" + id_empleado.getText() + "'";
            
            pst = con.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(this, "Successfully updated", "Estado Empleado Record", JOptionPane.INFORMATION_MESSAGE);
            Reset();
            
        } catch (HeadlessException | SQLException ex) {
            JOptionPane.showMessageDialog(this, ex);
        }
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:
        try {
            int P = JOptionPane.showConfirmDialog(null, " Are you sure want to delete ?", "Confirmation", JOptionPane.YES_NO_OPTION);
            if (P == 0) {
                con = conexionDB.conexionDB();
                String sql = "DELETE FROM `estatus_empleado` WHERE `id_estado_empleado` =  '" + id_empleado.getText() + "'";
                pst = con.prepareStatement(sql);
                pst.execute();
                JOptionPane.showMessageDialog(this, "Successfully deleted", "Record", JOptionPane.INFORMATION_MESSAGE);
                
                Reset();
            }
        } catch (HeadlessException | SQLException ex) {
            JOptionPane.showMessageDialog(this, ex);
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(statEmpleado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(statEmpleado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(statEmpleado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(statEmpleado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new statEmpleado().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JLabel fondo;
    private javax.swing.JLabel id_empleado;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbl_estadoEmpleado;
    private javax.swing.JTextField txt_stat_emp;
    // End of variables declaration//GEN-END:variables
}