/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import controller.conexionDB;
import static controller.conexionDB.conexionDB;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author ace
 */
public class Precios extends javax.swing.JFrame {

    /**
     * Creates new form Precios
     */
    Connection con=null;
ResultSet rs=null;
PreparedStatement pst=null;
    public Precios() {
        initComponents();
        
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblDesc = new javax.swing.JLabel();
        lblTitulo = new javax.swing.JLabel();
        lblMonto = new javax.swing.JLabel();
        btnGuardar = new javax.swing.JButton();
        txtMontoPrecio = new javax.swing.JTextField();
        txtDesc_Precio = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblDesc.setFont(new java.awt.Font("Dialog", 3, 18)); // NOI18N
        lblDesc.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblDesc.setText("Monto");
        getContentPane().add(lblDesc, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 370, -1));

        lblTitulo.setFont(new java.awt.Font("Dialog", 3, 18)); // NOI18N
        lblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo.setText("Precios");
        lblTitulo.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        getContentPane().add(lblTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 20, 370, 30));

        lblMonto.setFont(new java.awt.Font("Dialog", 3, 18)); // NOI18N
        lblMonto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblMonto.setText("Descripción del Precio");
        getContentPane().add(lblMonto, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 370, -1));

        btnGuardar.setFont(new java.awt.Font("Liberation Sans", 3, 18)); // NOI18N
        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        getContentPane().add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, -1, -1));

        txtMontoPrecio.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(txtMontoPrecio, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, 350, 40));

        txtDesc_Precio.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(txtDesc_Precio, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, 350, 40));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        // TODO add your handling code here:
        try{
            con=conexionDB.conexionDB();
            if (txtDesc_Precio.getText().equals("")) {
                JOptionPane.showMessageDialog( this, "Escriba una detalle para tipo de precio","Error", JOptionPane.ERROR_MESSAGE);
                return;

            }
            if (txtMontoPrecio.getText().equals("")) {
                JOptionPane.showMessageDialog( this, "Escriba un monto","Error", JOptionPane.ERROR_MESSAGE);
                return;

            }
   Statement stmt;
       stmt= con.createStatement();
       String sql1="Select precio_id from precios where Desc_Precio= '" + txtDesc_Precio.getText() + "'";
      rs=stmt.executeQuery(sql1);
      if(rs.next()){
        JOptionPane.showMessageDialog( this, "Esta descripción ya existe. Cambie el dato","Error", JOptionPane.ERROR_MESSAGE);
        txtDesc_Precio.setText("");
        txtDesc_Precio.requestDefaultFocus();
       return;
      }
            String sql= "insert into precios (Desc_Precio,Precio)values('"+ txtDesc_Precio.getText() + "','"+ txtMontoPrecio.getText()  + "')";

            pst=con.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(this,"Guardado con Exito","Precio Record",JOptionPane.INFORMATION_MESSAGE);
            btnGuardar.setEnabled(false);

        }catch(HeadlessException | SQLException ex){
            JOptionPane.showMessageDialog(this,ex);
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

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
            java.util.logging.Logger.getLogger(Precios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Precios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Precios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Precios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Precios().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGuardar;
    private javax.swing.JLabel lblDesc;
    private javax.swing.JLabel lblMonto;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JTextField txtDesc_Precio;
    private javax.swing.JTextField txtMontoPrecio;
    // End of variables declaration//GEN-END:variables
}
