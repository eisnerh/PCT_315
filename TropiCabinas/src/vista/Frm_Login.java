/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import com.sun.glass.events.KeyEvent;
import controlador.dbConnection;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.formularios.Interfaz_Usuario;

/**
 *
 * @author Eisner López Acevedo <eisner.lopez at gmail.com>
 * @author Cesar Gonzalez Salas <cgonzalez816 at gmail.com>
 */
public class Frm_Login extends javax.swing.JFrame {

    /**
     * Creates new form puesto
     */
    Connection con = null;
    ResultSet rs = null;
    PreparedStatement pst = null;

    /**
     * Creacion de variables estaticas las cuales se van a exportar al
     * formulario inicio para realizar el primer filtro y bloqueo de menus
     */
    public static String ps_NombreEmpleado;
    public static String ps_idEmpleado;
    public static String ps_descripcion_puesto;
    BufferedImage img = null;
    //Se cargan los valores de int 'x' o 'y' para conocer la ubicación del mouse
    //y cambiar la imagen de minimizar al momento de pasar por la ventana
    //del formuario.
    int xMouse;
    int yMouse;

    public Frm_Login() throws IOException {
        initComponents();
        //inicialización de las variables de la coneccion a la base de datos
        con = dbConnection.getConnection();
        //centra la ventana para que se inicie en el centro del escritorio
        this.setLocationRelativeTo(null);
    }

    private void mostrar(String login, String password) {
        try {
            if (txt_User.getText().length() == 0) {
                JOptionPane.showMessageDialog(rootPane, "Ingresar Usuario");
                txt_User.requestFocus();
            } else if (txt_Pass.getText().length() == 0) {
                JOptionPane.showMessageDialog(rootPane, "Ingresar Contrase\u00F1a");
                txt_Pass.requestFocus();
            } else {
            DefaultTableModel modelo;
            Interfaz_Usuario func = new Interfaz_Usuario();
            modelo = func.login(login, password);
            

            if (func.totalregistros > 0) {
                    Frm_Inicio p = new Frm_Inicio();
                    p.setVisible(true);
                    this.dispose();
                    ps_NombreEmpleado = (modelo.getValueAt(0, 3)).toString();
                    ps_idEmpleado = (modelo.getValueAt(0, 2)).toString();
                    ps_descripcion_puesto = (modelo.getValueAt(0, 5)).toString();
                    Frm_Inicio.Nombre_Empleado.setText(ps_NombreEmpleado);
                    Frm_Inicio.IdEmpleado.setText(ps_idEmpleado);
                    Frm_Inicio.lblacceso.setText((modelo.getValueAt(0, 4)).toString());
                    Frm_Inicio.lblPuesto.setText(ps_descripcion_puesto);
                    if (Frm_Inicio.lblPuesto.getText().equals("Administrador")) {
                    } else {
                        Frm_Inicio.mnuConfiguraciones.setEnabled(false);
                        Frm_Inicio.mnuHerramientas.setEnabled(false);
                    }
                } else {
                    int opcion = JOptionPane.showConfirmDialog(this, "Usuario o Contrase\u00F1a Incorrecta", "Desea Salir", JOptionPane.YES_NO_OPTION);
                    if (opcion == 1) { //The ISSUE is here
                        System.exit(0);
                    } else {
                        txt_User.setText("");
                        txt_Pass.setText("");
                    }
                }
            
            JOptionPane.showMessageDialog(null, "Total Registros " + Integer.toString(func.totalregistros));
            }
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(rootPane, e);
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

        txt_User = new javax.swing.JTextField();
        txt_Pass = new javax.swing.JPasswordField();
        c1 = new javax.swing.JLabel();
        lbl_idUsuario = new javax.swing.JLabel();
        lbl_colaborador_empleado_id = new javax.swing.JLabel();
        lbl_Entrar = new javax.swing.JLabel();
        btnEntrar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Login");
        setAlwaysOnTop(true);
        setBackground(new java.awt.Color(102, 102, 102));
        setUndecorated(true);
        setResizable(false);
        setType(java.awt.Window.Type.UTILITY);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txt_User.setFont(new java.awt.Font("Laksaman", 1, 16)); // NOI18N
        txt_User.setBorder(null);
        txt_User.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_UserKeyPressed(evt);
            }
        });
        getContentPane().add(txt_User, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 30, 220, 40));

        txt_Pass.setFont(new java.awt.Font("Laksaman", 1, 16)); // NOI18N
        txt_Pass.setBorder(null);
        txt_Pass.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_PassKeyPressed(evt);
            }
        });
        getContentPane().add(txt_Pass, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 80, 220, 40));

        c1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/c1.png"))); // NOI18N
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
        getContentPane().add(c1, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 10, -1, -1));

        lbl_idUsuario.setFont(new java.awt.Font("Laksaman", 1, 16)); // NOI18N
        lbl_idUsuario.setText("Usuario:");
        getContentPane().add(lbl_idUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 120, -1));
        getContentPane().add(lbl_colaborador_empleado_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, -1, -1));

        lbl_Entrar.setFont(new java.awt.Font("Laksaman", 1, 16)); // NOI18N
        lbl_Entrar.setText("Contraseña:");
        getContentPane().add(lbl_Entrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 130, 60));

        btnEntrar.setFont(new java.awt.Font("Laksaman", 1, 18)); // NOI18N
        btnEntrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/CRUD/login.png"))); // NOI18N
        btnEntrar.setText("Entrar");
        btnEntrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEntrarActionPerformed(evt);
            }
        });
        getContentPane().add(btnEntrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 130, 220, 50));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void c1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_c1MouseClicked
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_c1MouseClicked

    private void c1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_c1MouseEntered
        // TODO add your handling code here:
        c1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/c2.png")));
    }//GEN-LAST:event_c1MouseEntered

    private void c1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_c1MouseExited
        // TODO add your handling code here:
        c1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/c1.png")));
    }//GEN-LAST:event_c1MouseExited

    private void txt_PassKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_PassKeyPressed
        // TODO add your handling code here:
        // Habilita la tecla enter
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            // Enter was pressed. Your code goes here.
            mostrar(txt_User.getText(), txt_Pass.getText());
        }
    }//GEN-LAST:event_txt_PassKeyPressed

    private void txt_UserKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_UserKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            // Enter was pressed. Your code goes here.
            mostrar(txt_User.getText(), txt_Pass.getText());
        }
    }//GEN-LAST:event_txt_UserKeyPressed

    private void btnEntrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEntrarActionPerformed
        // TODO add your handling code here:
        mostrar(txt_User.getText(), txt_Pass.getText());
    }//GEN-LAST:event_btnEntrarActionPerformed

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
            java.util.logging.Logger.getLogger(Frm_Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            try {
                new Frm_Login().setVisible(true);
            } catch (IOException ex) {
                Logger.getLogger(Frm_Login.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEntrar;
    private javax.swing.JLabel c1;
    private javax.swing.JLabel lbl_Entrar;
    private javax.swing.JLabel lbl_colaborador_empleado_id;
    private javax.swing.JLabel lbl_idUsuario;
    private javax.swing.JPasswordField txt_Pass;
    private javax.swing.JTextField txt_User;
    // End of variables declaration//GEN-END:variables
}
