/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import com.sun.glass.events.KeyEvent;
import controller.ConexionDB;
import java.awt.HeadlessException;
import java.awt.image.BufferedImage;
import java.io.IOException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author ace
 */
public class Login_frm extends javax.swing.JFrame {

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

    public static String ps_NombreEmpleado;
    public static String ps_idEmpleado;
    BufferedImage img = null;

    int xMouse;
    int yMouse;

    public Login_frm() throws IOException {
        initComponents();

        //inicialización de las variables de la coneccion a la base de datos
        con = ConexionDB.conexionDB();
        //centra la ventana para que se inicie en el centro del escritorio
        this.setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txt_User = new javax.swing.JTextField();
        txt_Pass = new javax.swing.JPasswordField();
        c1 = new javax.swing.JLabel();
        lbl_idUsuario = new javax.swing.JLabel();
        lbl_colaborador_empleado_id = new javax.swing.JLabel();
        lbl_Entrar = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Login");
        setUndecorated(true);
        setResizable(false);
        setType(java.awt.Window.Type.UTILITY);
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txt_User.setFont(new java.awt.Font("Laksaman", 1, 16)); // NOI18N
        txt_User.setForeground(new java.awt.Color(0, 0, 0));
        txt_User.setBorder(null);
        txt_User.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_UserKeyPressed(evt);
            }
        });
        getContentPane().add(txt_User, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 30, 220, 40));

        txt_Pass.setFont(new java.awt.Font("Laksaman", 1, 16)); // NOI18N
        txt_Pass.setForeground(new java.awt.Color(0, 0, 0));
        txt_Pass.setBorder(null);
        txt_Pass.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_PassKeyPressed(evt);
            }
        });
        getContentPane().add(txt_Pass, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 80, 220, 40));

        c1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icons/c1.png"))); // NOI18N
        c1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                c1MouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                c1MouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                c1MouseEntered(evt);
            }
        });
        getContentPane().add(c1, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 10, -1, -1));

        lbl_idUsuario.setFont(new java.awt.Font("Laksaman", 1, 16)); // NOI18N
        lbl_idUsuario.setText("Usuario:");
        getContentPane().add(lbl_idUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 120, -1));

        lbl_colaborador_empleado_id.setText("jLabel1");
        getContentPane().add(lbl_colaborador_empleado_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 90, -1, -1));

        lbl_Entrar.setFont(new java.awt.Font("Laksaman", 1, 16)); // NOI18N
        lbl_Entrar.setText("Contraseña:");
        getContentPane().add(lbl_Entrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 130, 60));

        jButton1.setFont(new java.awt.Font("Laksaman", 1, 18)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icons/CRUD/login.png"))); // NOI18N
        jButton1.setText("Entrar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 130, 220, 50));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void c1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_c1MouseClicked
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_c1MouseClicked

    private void c1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_c1MouseEntered
        // TODO add your handling code here:
        c1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icons/c2.png")));
    }//GEN-LAST:event_c1MouseEntered

    private void c1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_c1MouseExited
        // TODO add your handling code here:
        c1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icons/c1.png")));
    }//GEN-LAST:event_c1MouseExited

    private void txt_PassKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_PassKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            // Enter was pressed. Your code goes here.
            executeLogin();
        }
    }//GEN-LAST:event_txt_PassKeyPressed

    private void txt_UserKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_UserKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            // Enter was pressed. Your code goes here.
            executeLogin();
        }
    }//GEN-LAST:event_txt_UserKeyPressed

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_formKeyPressed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        executeLogin();
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(Login_frm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new Login_frm().setVisible(true);
            } catch (IOException ex) {
                Logger.getLogger(Login_frm.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel c1;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel lbl_Entrar;
    private javax.swing.JLabel lbl_colaborador_empleado_id;
    private javax.swing.JLabel lbl_idUsuario;
    private javax.swing.JPasswordField txt_Pass;
    private javax.swing.JTextField txt_User;
    // End of variables declaration//GEN-END:variables

    private void executeLogin() {
        String a = txt_User.getText();
        String b = String.valueOf(txt_Pass.getPassword());
        if (a.length() == 0 && b.length() == 0) {
            JOptionPane.showMessageDialog(rootPane, "Ingresar Usuario y Contraseña");
            txt_User.requestFocus();
        }
        if (a.length() == 0) {
            JOptionPane.showMessageDialog(rootPane, "Ingresar Usuario");
            txt_User.requestFocus();
        }
        if (b.length() == 0) {
            JOptionPane.showMessageDialog(rootPane, "Ingresar Contraseña");
            txt_Pass.requestFocus();
        }
        try {

            String str = "SELECT `usuario`.`usuario`, `usuario`.`password`, "
                    + "`usuario`.`colaborador_empleado_id` as 'empleado_id' , "
                    + "`persona`.`nombre` as `nombre` "
                    + "FROM `pct3`.`usuario` AS `usuario`, "
                    + "`pct3`.`colaborador` AS `colaborador`, "
                    + "`pct3`.`persona` AS `persona` "
                    + "WHERE `usuario`.`colaborador_empleado_id` = "
                    + "`colaborador`.`empleado_id` AND "
                    + "`colaborador`.`persona_idpersona` = "
                    + "`persona`.`idpersona` AND "
                    + "`usuario`.`usuario` = '" + a
                    + "' AND `usuario`.`password` = '" + b + "'";
            pst = con.prepareStatement(str);
            rs = pst.executeQuery();

            if (rs.next()) {
                String nombre_persona = rs.getString("nombre");
                String id_colaborador = rs.getString("empleado_id");
                ps_NombreEmpleado = rs.getString("nombre");
                ps_idEmpleado = rs.getString("empleado_id");
                System.out.println(nombre_persona);
                System.out.println(id_colaborador);

                Principal_frm p = new Principal_frm();

                p.setVisible(true);
                this.hide();

                Principal_frm.Nombre_Empleado.setText(nombre_persona);
                Principal_frm.IdEmpleado.setText(id_colaborador);
            } else {
                int opcion = JOptionPane.showConfirmDialog(this, "Usuario o Contraseña Incorrecta", "Desea Salir", JOptionPane.YES_NO_OPTION);
                if (opcion == 0) { //The ISSUE is here
                    System.exit(0);
                } else {
                    System.out.print("no");

                    txt_User.setText("");
                    txt_Pass.setText("");
                }
            }

        } catch (SQLException | IOException | HeadlessException e) {
        }
    }
}
