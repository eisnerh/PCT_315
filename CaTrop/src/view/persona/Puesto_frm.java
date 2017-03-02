/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.persona;

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
public class Puesto_frm extends javax.swing.JFrame {

    /**
     * Creates new form Puesto_frm
     */
    Connection con = null;
    ResultSet rs = null;
    PreparedStatement pst = null;

    String puesto;
    String hsencilla;
    String hextra;
    String idpuesto;

    public Puesto_frm() throws IOException {
        initComponents();
        setLocationRelativeTo(null);

        //inicialización de las variables de la coneccion a la base de datos
        con = ConexionDB.conexionDB();
        //llama al procedimiento de obtener la información.
        Get_Data();
        //centra la ventana para que se inicie en el centro del escritorio

        initState();
    }

    private void initState() {
        txtPuesto.setEnabled(false);
        txtHoraE.setEnabled(false);
        txtHoraS.setEnabled(false);
        txtPuesto.setText("");
        txtHoraE.setText("");
        txtHoraS.setText("");
        nuevo.setEnabled(true);
        guardar.setEnabled(false);
        buscar.setEnabled(true);
        editar.setEnabled(false);
        borrar.setEnabled(false);
        Get_Data();

    }

    private void Get_Data() {
        //Select sobre el estatus_empleado y se le asigna el valor a la columna de la tabla del formulario.
        String sql = "SELECT `descripcion_puesto` as 'Puesto', `pago_hora_sencilla` as 'Hora Sencilla', `pago_hora_extra` as 'Hora Extra' FROM `puesto` ORDER BY `descripcion_puesto` ";
        String sql2 = "SELECT `puesto_id`, `descripcion_puesto`, `pago_hora_sencilla`, `pago_hora_extra` FROM `puesto`";
        try {
            pst = con.prepareStatement(sql);
            PreparedStatement pst2 = con.prepareStatement(sql2);
            rs = pst.executeQuery();
            ResultSet rs2 = pst2.executeQuery();
            tblPuesto.setModel(DbUtils.resultSetToTableModel(rs));
            int columna_idpuesto = rs2.findColumn("puesto_id");
            int columna_Puesto = rs2.findColumn("descripcion_puesto");
            int columna_hs = rs2.findColumn("pago_hora_sencilla");
            int columna_he = rs2.findColumn("pago_hora_extra");

            boolean lleno = rs2.next();
            while (lleno) {
                puesto = rs2.getString(columna_Puesto);
                hsencilla = rs2.getString(columna_hs);
                hextra = rs2.getString(columna_he);
                idpuesto = rs2.getString(columna_idpuesto);
                System.out.println("" + puesto + " , " + hsencilla + " , ");
                lleno = rs2.next(); //se verifica si hay otro registro
            }

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

        id_puesto = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtPuesto = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtHoraS = new javax.swing.JFormattedTextField();
        jLabel3 = new javax.swing.JLabel();
        txtHoraE = new javax.swing.JFormattedTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPuesto = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        nuevo = new javax.swing.JButton();
        guardar = new javax.swing.JButton();
        editar = new javax.swing.JButton();
        borrar = new javax.swing.JButton();
        buscar = new javax.swing.JButton();
        fondo = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Puesto Disponibles");
        setUndecorated(true);
        setResizable(false);
        setType(java.awt.Window.Type.UTILITY);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        id_puesto.setText("jLabel4");
        getContentPane().add(id_puesto, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 110, -1, -1));

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jLabel1.setText("Monto Hora Sencilla:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 80, -1, -1));

        txtPuesto.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        getContentPane().add(txtPuesto, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 20, 270, 40));

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jLabel2.setText("Monto Hora Doble:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 130, -1, -1));

        txtHoraS.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        txtHoraS.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        getContentPane().add(txtHoraS, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 120, 270, 40));

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jLabel3.setText("Descripcion Puesto:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 30, -1, -1));

        txtHoraE.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        txtHoraE.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        getContentPane().add(txtHoraE, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 70, 270, 40));

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Listas de Puestos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 0, 14), new java.awt.Color(255, 255, 255))); // NOI18N

        tblPuesto.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        tblPuesto.setModel(new javax.swing.table.DefaultTableModel(
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
        tblPuesto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblPuestoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblPuesto);

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

        jMenu1.setText("File");

        jMenu3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icons/exit-sign.png"))); // NOI18N
        jMenu3.setText("Salir");
        jMenu3.addMenuKeyListener(new javax.swing.event.MenuKeyListener() {
            public void menuKeyPressed(javax.swing.event.MenuKeyEvent evt) {
                jMenu3MenuKeyPressed(evt);
            }
            public void menuKeyReleased(javax.swing.event.MenuKeyEvent evt) {
            }
            public void menuKeyTyped(javax.swing.event.MenuKeyEvent evt) {
            }
        });
        jMenu3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu3MouseClicked(evt);
            }
        });
        jMenu1.add(jMenu3);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenu3MenuKeyPressed(javax.swing.event.MenuKeyEvent evt) {//GEN-FIRST:event_jMenu3MenuKeyPressed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jMenu3MenuKeyPressed

    private void jMenu3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu3MouseClicked
        // TODO add your handling code here:
        int result;
        result = JOptionPane.showConfirmDialog(null, "¿Seguro que quiere salir?",
                "Confirm Quit", JOptionPane.YES_NO_OPTION);
        if (result == JOptionPane.YES_OPTION) {
            dispose();
        }
    }//GEN-LAST:event_jMenu3MouseClicked

    private void nuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nuevoActionPerformed
        // TODO add your handling code here:
        txtPuesto.setText("");
        txtHoraE.setText("");
        txtHoraS.setText("");
        txtPuesto.setEnabled(true);
        txtHoraE.setEnabled(true);
        txtHoraS.setEnabled(true);
        txtPuesto.requestDefaultFocus();
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
                if (txtPuesto.getText().equals("")) {
                    JOptionPane.showMessageDialog(this, "Favor ingresa el puesto del colaborador", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                if (txtHoraE.getText().equals("")) {
                    JOptionPane.showMessageDialog(this, "Favor ingresa el monto de la hora extra", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                if (txtHoraS.getText().equals("")) {
                    JOptionPane.showMessageDialog(this, "Favor ingresa el monto de la hora sencilla", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                Statement stmt;
                stmt = con.createStatement();
                String sql1 = "SELECT `descripcion_puesto`, `pago_hora_sencilla`, `pago_hora_extra` FROM `puesto` WHERE `descripcion_puesto` = '" + txtPuesto.getText() + "'";
                rs = stmt.executeQuery(sql1);
                if (rs.next()) {
                    JOptionPane.showMessageDialog(this, "Puesto ya existe.", "Error", JOptionPane.ERROR_MESSAGE);
                    txtPuesto.setText("");
                    txtPuesto.requestDefaultFocus();
                    txtHoraE.setText("");
                    txtHoraS.setText("");
                    return;
                }

                //INSERT INTO `Puesto_frm`(`descripcion_puesto`, `pago_hora_sencilla`, `pago_hora_extra`) VALUES ('Administrador',5000,10000)
                String sql = "INSERT INTO `puesto`(`descripcion_puesto`, `pago_hora_sencilla`, `pago_hora_extra`) VALUES (" + "'" + txtPuesto.getText() + "'," + txtHoraS.getText() + "," + txtHoraE.getText() + ")";
                pst = con.prepareStatement(sql);
                pst.execute();
                JOptionPane.showMessageDialog(this, "Guardado con Exito saved", "Tipo de Usuario", JOptionPane.INFORMATION_MESSAGE);
                txtPuesto.setText("");
                txtHoraE.setText("");
                txtHoraS.setText("");
            }
            if (P == 1) {
                //INSERT INTO `Puesto_frm`(`descripcion_puesto`, `pago_hora_sencilla`, `pago_hora_extra`) VALUES ('Administrador',5000,10000)
                String sql = "INSERT INTO `puesto`(`descripcion_puesto`, `pago_hora_sencilla`, `pago_hora_extra`) VALUES (" + "'" + txtPuesto.getText() + "'," + txtHoraS.getText() + "," + txtHoraE.getText() + ")";
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
                String sql1 = "SELECT `descripcion_puesto`, `pago_hora_sencilla`, `pago_hora_extra` FROM `puesto` WHERE `descripcion_puesto` = '" + txtPuesto.getText() + "'";
                rs = stmt.executeQuery(sql1);
                if (rs.next()) {
                    JOptionPane.showMessageDialog(this, "Puesto ya existe.", "Error", JOptionPane.ERROR_MESSAGE);
                    txtPuesto.setText("");
                    txtPuesto.requestDefaultFocus();
                    txtHoraE.setText("");
                    txtHoraS.setText("");
                    return;
                }

                //INSERT INTO `Puesto_frm`(`descripcion_puesto`, `pago_hora_sencilla`, `pago_hora_extra`) VALUES ('Administrador',5000,10000)
                String sql = "UPDATE `puesto` SET `descripcion_puesto` = '" + txtPuesto.getText() + "',`pago_hora_sencilla`='" + txtHoraS.getText() + "',`pago_hora_extra`='" + txtHoraE.getText() + "' WHERE `puesto_id`= '" + id_puesto.getText() + "'";
                pst = con.prepareStatement(sql);
                pst.execute();
                JOptionPane.showMessageDialog(this, "Guardado con Exito saved", "Tipo de Usuario", JOptionPane.INFORMATION_MESSAGE);
                txtPuesto.setText("");
                txtHoraE.setText("");
                txtHoraS.setText("");
            }

            if (P == 1) {
                con = ConexionDB.conexionDB();

                //            UPDATE `Puesto_frm` SET `descripcion_puesto` =     "Admini"      ,`pago_hora_sencilla`=    5000,              `pago_hora_extra`=7000                WHERE `puesto_id`=2
                String sql = "UPDATE `puesto` SET `descripcion_puesto` = '" + txtPuesto.getText() + "',`pago_hora_sencilla`='" + txtHoraS.getText() + "',`pago_hora_extra`='" + txtHoraE.getText() + "' WHERE `puesto_id`= '" + id_puesto.getText() + "'";
                pst = con.prepareStatement(sql);
                pst.execute();
                JOptionPane.showMessageDialog(this, "Guardado con exito", "Estado Empleado Record", JOptionPane.INFORMATION_MESSAGE);

                initComponents();
                Get_Data();
            }

        } catch (HeadlessException | SQLException ex) {
            JOptionPane.showMessageDialog(this, ex);
        }

    }//GEN-LAST:event_editarActionPerformed

    private void buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarActionPerformed
        // TODO add your handling code here:
        txtPuesto.setEnabled(true);
        txtHoraE.setEnabled(true);
        txtHoraS.setEnabled(true);
        txtPuesto.setText("");
        txtHoraE.setText("");
        txtHoraS.setText("");
        nuevo.setEnabled(false);
        guardar.setEnabled(false);
        buscar.setEnabled(false);
        editar.setEnabled(true);
        borrar.setEnabled(true);
    }//GEN-LAST:event_buscarActionPerformed

    private void tblPuestoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPuestoMouseClicked
        // TODO add your handling code here:
        try {
            con = ConexionDB.conexionDB();
            int row = tblPuesto.getSelectedRow();
            String tabla_click = tblPuesto.getModel().getValueAt(row, 0).toString();
            //SELECT `estado_empleado` FROM `estatus_empleado` WHERE `estado_empleado` = 'Activo'
            String sql = "SELECT `puesto_id`, `descripcion_puesto`, `pago_hora_sencilla`, `pago_hora_extra` FROM `puesto` WHERE `descripcion_puesto` = '" + tabla_click + "'";
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            if (rs.next()) {
                String add1 = rs.getString("puesto_id");
                id_puesto.setText(add1);
                String add2 = rs.getString("descripcion_puesto");
                String add3 = rs.getString("pago_hora_sencilla");
                String add4 = rs.getString("pago_hora_extra");
                txtPuesto.setText(add2);
                txtHoraE.setText(add3);
                txtHoraS.setText(add4);
                System.out.println(add1);

            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex);
        }
    }//GEN-LAST:event_tblPuestoMouseClicked

    private void borrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_borrarActionPerformed
        // TODO add your handling code here:
        try {
            int P = JOptionPane.showConfirmDialog(null, " Seguro que quiere eliminar ?", "Confirmation", JOptionPane.YES_NO_OPTION);
            if (P == 0) {
                con = ConexionDB.conexionDB();
                String sql = "DELETE FROM `puesto` WHERE `puesto_id`='" + id_puesto.getText() + "'";
                pst = con.prepareStatement(sql);
                pst.execute();
                JOptionPane.showMessageDialog(this, "Successfully deleted", "Record", JOptionPane.INFORMATION_MESSAGE);

                initState();
                Get_Data();
            }
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
            java.util.logging.Logger.getLogger(Puesto_frm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            try {
                new Puesto_frm().setVisible(true);
            } catch (IOException ex) {
                Logger.getLogger(Puesto_frm.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton borrar;
    private javax.swing.JButton buscar;
    private javax.swing.JButton editar;
    private javax.swing.JLabel fondo;
    private javax.swing.JButton guardar;
    private javax.swing.JLabel id_puesto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton nuevo;
    private javax.swing.JTable tblPuesto;
    private javax.swing.JFormattedTextField txtHoraE;
    private javax.swing.JFormattedTextField txtHoraS;
    private javax.swing.JTextField txtPuesto;
    // End of variables declaration//GEN-END:variables
}
