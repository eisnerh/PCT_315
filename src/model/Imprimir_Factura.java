/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author treznor
 */
public class Imprimir_Factura extends javax.swing.JFrame {

    /**
     * Creates new form Imprimir_Factura
     */
    public Imprimir_Factura() {
        initComponents();
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLblTitulo1 = new javax.swing.JLabel();
        jLblTitulo2 = new javax.swing.JLabel();
        jLblTitulo3 = new javax.swing.JLabel();
        jLblTitulo4 = new javax.swing.JLabel();
        jLblTitulo5 = new javax.swing.JLabel();
        jLblTitulo6 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jTxtFTotal = new javax.swing.JTextField();
        jLblTotal = new javax.swing.JLabel();
        jLblIVI = new javax.swing.JLabel();
        jLblNumero = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jBtnVolver = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(523, 530));
        setMinimumSize(new java.awt.Dimension(523, 530));
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jTable1.setFont(new java.awt.Font("Arial Black", 0, 11)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Cantidad", "Descripcion", "Precio"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 229, 499, 172));

        jLblTitulo1.setFont(new java.awt.Font("Arial Black", 0, 20)); // NOI18N
        jLblTitulo1.setText("CABINAS EL TROPICO");
        getContentPane().add(jLblTitulo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(35, 6, -1, -1));

        jLblTitulo2.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        jLblTitulo2.setText("César González Salas");
        getContentPane().add(jLblTitulo2, new org.netbeans.lib.awtextra.AbsoluteConstraints(71, 31, -1, -1));

        jLblTitulo3.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        jLblTitulo3.setText("Ced : 1-1006-0032");
        getContentPane().add(jLblTitulo3, new org.netbeans.lib.awtextra.AbsoluteConstraints(95, 54, -1, -1));

        jLblTitulo4.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        jLblTitulo4.setText("Guatuso, San Carlos");
        getContentPane().add(jLblTitulo4, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 75, 187, -1));

        jLblTitulo5.setFont(new java.awt.Font("Arial Black", 0, 11)); // NOI18N
        jLblTitulo5.setText("Señor :");
        getContentPane().add(jLblTitulo5, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 142, -1, -1));

        jLblTitulo6.setFont(new java.awt.Font("Arial Black", 0, 11)); // NOI18N
        jLblTitulo6.setText("Dirección :");
        getContentPane().add(jLblTitulo6, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 168, -1, -1));

        jTextField1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 139, 421, -1));

        jTextField2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 165, 421, -1));

        jLabel1.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        jLabel1.setText("FACTURA CONTADO");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(356, 22, -1, -1));

        jTable2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null}
            },
            new String [] {
                "Dia", "Mes", "Año"
            }
        ));
        jScrollPane2.setViewportView(jTable2);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(337, 43, 174, 50));

        jLabel2.setFont(new java.awt.Font("Arial Black", 0, 11)); // NOI18N
        jLabel2.setText("Cédula :");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 194, -1, -1));

        jTextField3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 191, 421, -1));

        jTxtFTotal.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(jTxtFTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(343, 407, 168, -1));

        jLblTotal.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        jLblTotal.setText("Total ¢");
        getContentPane().add(jLblTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 408, 55, -1));

        jLblIVI.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        jLblIVI.setText("I.V.I");
        getContentPane().add(jLblIVI, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 408, -1, -1));

        jLblNumero.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        jLblNumero.setForeground(new java.awt.Color(255, 0, 0));
        jLblNumero.setText("Nº");
        getContentPane().add(jLblNumero, new org.netbeans.lib.awtextra.AbsoluteConstraints(303, 448, -1, -1));

        jTextField4.setForeground(new java.awt.Color(255, 0, 0));
        jTextField4.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(jTextField4, new org.netbeans.lib.awtextra.AbsoluteConstraints(343, 451, 168, -1));

        jBtnVolver.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        jBtnVolver.setText("Volver");
        jBtnVolver.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jBtnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnVolverActionPerformed(evt);
            }
        });
        getContentPane().add(jBtnVolver, new org.netbeans.lib.awtextra.AbsoluteConstraints(415, 500, 96, -1));

        jButton1.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        jButton1.setText("Imprimir");
        jButton1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 500, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBtnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnVolverActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jBtnVolverActionPerformed

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
            java.util.logging.Logger.getLogger(Imprimir_Factura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Imprimir_Factura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Imprimir_Factura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Imprimir_Factura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Imprimir_Factura().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnVolver;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLblIVI;
    private javax.swing.JLabel jLblNumero;
    private javax.swing.JLabel jLblTitulo1;
    private javax.swing.JLabel jLblTitulo2;
    private javax.swing.JLabel jLblTitulo3;
    private javax.swing.JLabel jLblTitulo4;
    private javax.swing.JLabel jLblTitulo5;
    private javax.swing.JLabel jLblTitulo6;
    private javax.swing.JLabel jLblTotal;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTxtFTotal;
    // End of variables declaration//GEN-END:variables
}
