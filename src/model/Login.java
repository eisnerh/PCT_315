/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import controller.conexionDB;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import net.sf.jcarrierpigeon.WindowPosition;
import net.sf.jtelegraph.Telegraph;
import net.sf.jtelegraph.TelegraphEnvelope;
import net.sf.jtelegraph.TelegraphQueue;
import net.sf.jtelegraph.TelegraphType;

/**
 *
 * @author Cesar Gonzalez Salas, Eisner Lopez Acevedo
 */
public class Login extends javax.swing.JFrame {

    /**
     * Creates new form Login
     */
    
    Connection conn = null;
    ResultSet rs = null;
    PreparedStatement pst = null;

    BufferedImage img = null;

    int xMouse;
    int yMouse;
    
    public Login() {
        
        initComponents();

        //inicializar la conexión
        conn = (com.mysql.jdbc.Connection) conexionDB.conexionDB();
        //poner el fondo blanco
        this.setBackground(new Color(0, 0, 0, 0));
        //centrar el JFrame
        setLocationRelativeTo(null);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        user = new javax.swing.JTextField();
        pass = new javax.swing.JPasswordField();
        Logo = new javax.swing.JLabel();
        w1 = new javax.swing.JLabel();
        w2 = new javax.swing.JLabel();
        main = new javax.swing.JLabel();
        signIn = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(620, 350));
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(user, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 110, 270, 40));
        getContentPane().add(pass, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 180, 270, 40));

        Logo.setIcon(new javax.swing.ImageIcon("/home/ace/project/Proyecto_Cabinas_Eltropico/src/Icons/eagle14.png")); // NOI18N
        getContentPane().add(Logo, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 210, 300, 70));

        w1.setIcon(new javax.swing.ImageIcon("/home/ace/project/Proyecto_Cabinas_Eltropico/src/Icons/c1.png")); // NOI18N
        w1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                w1MouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                w1MouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                w1MouseEntered(evt);
            }
        });
        getContentPane().add(w1, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 10, -1, -1));

        w2.setIcon(new javax.swing.ImageIcon("/home/ace/project/Proyecto_Cabinas_Eltropico/src/Icons/m1.png")); // NOI18N
        w2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                w2MouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                w2MouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                w2MouseEntered(evt);
            }
        });
        getContentPane().add(w2, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 10, -1, -1));

        main.setIcon(new javax.swing.ImageIcon("/home/ace/project/Proyecto_Cabinas_Eltropico/src/Icons/admin-login.png")); // NOI18N
        main.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mainMouseClicked(evt);
            }
        });
        getContentPane().add(main, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        signIn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                signInMouseClicked(evt);
            }
        });
        getContentPane().add(signIn, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 240, 80, 30));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void w1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_w1MouseClicked
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_w1MouseClicked

    private void w1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_w1MouseExited
        // TODO add your handling code here:
        w1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/c1.png")));
    }//GEN-LAST:event_w1MouseExited

    private void w1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_w1MouseEntered
        // TODO add your handling code here:
        w1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/c2.png")));
    }//GEN-LAST:event_w1MouseEntered

    private void w2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_w2MouseClicked
        // TODO add your handling code here:
        this.setState(Login.ICONIFIED);
        w2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/m1.png")));
    }//GEN-LAST:event_w2MouseClicked

    private void w2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_w2MouseExited
        // TODO add your handling code here:
        w2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/m1.png")));
    }//GEN-LAST:event_w2MouseExited

    private void w2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_w2MouseEntered
        // TODO add your handling code here:
        w2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/m2.png")));
        
    }//GEN-LAST:event_w2MouseEntered

    private void mainMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mainMouseClicked
        // TODO add your handling code here:
        executeLogin();
    }//GEN-LAST:event_mainMouseClicked

    private void signInMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_signInMouseClicked
        // TODO add your handling code here:
        executeLogin();
    }//GEN-LAST:event_signInMouseClicked

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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Logo;
    private javax.swing.JLabel main;
    private javax.swing.JPasswordField pass;
    private javax.swing.JLabel signIn;
    private javax.swing.JTextField user;
    private javax.swing.JLabel w1;
    private javax.swing.JLabel w2;
    // End of variables declaration//GEN-END:variables

    

    

    private void executeLogin() {
        String a = user.getText();
        String b = pass.getText();

        if (a.length() == 0 && b.length() == 0) {
            Telegraph tele = new Telegraph("Mensaje", 
                    "<html><body style='color:red;font-size:13px'><b> Agregar usuario y contraseña!</b></body></html>", TelegraphType.APPLICATION_WARNING, WindowPosition.TOPRIGHT, 500);
            TelegraphQueue q = new TelegraphQueue();
            TelegraphEnvelope qa = new TelegraphEnvelope();
            q.add(tele);
        } else if (a.length() == 0) {
            Telegraph tele = new Telegraph("Mensaje", "<html><body style='color:red;font-size:13px'><b> Favor escribir el nombre del usuario!</b></body></html>", TelegraphType.APPLICATION_WARNING, WindowPosition.TOPRIGHT, 500);
            TelegraphQueue q = new TelegraphQueue();
            q.add(tele);
        } else if (b.length() == 0) {
            Telegraph tele = new Telegraph("Mensaje", "<html><body style='color:red;font-size:13px'><b> Favor escribir una contraseña valida!</b></body></html>", TelegraphType.APPLICATION_WARNING, WindowPosition.TOPRIGHT, 500);
            TelegraphQueue q = new TelegraphQueue();
            q.add(tele);
        } else {

            String str = "select * from tbl_usuario where usuario=? and password=?";
            try {

                pst = (PreparedStatement) conn.prepareStatement(str);
                pst.setString(1, user.getText());

                pst.setString(2, pass.getText());
                rs = pst.executeQuery();
                if (rs.next()) {

                    Telegraph tele = new Telegraph("Mensaje", "<html><body style='color:green;font-size:13px'><b>Login Exitoso!</b></body></html>", TelegraphType.NOTIFICATION_DONE, WindowPosition.TOPRIGHT, 1500);
                    TelegraphQueue q = new TelegraphQueue();
                    TelegraphEnvelope qa = new TelegraphEnvelope();
                    Pantalla_principal principal = new Pantalla_principal();
                    principal.setVisible(true);
                    q.add(tele);
                    
                } else {
                    Telegraph tele = new Telegraph("Mensaje", "<html><body style='color:red;font-size:13px'><b> Access Denied!</b></body></html>", TelegraphType.NOTIFICATION_ERROR, WindowPosition.TOPRIGHT, 1500);
                    TelegraphQueue q = new TelegraphQueue();
                    TelegraphEnvelope qa = new TelegraphEnvelope();
                    q.add(tele);
                    user.setText("");
                    pass.setText("");
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex);
            }
        }
    }
}
