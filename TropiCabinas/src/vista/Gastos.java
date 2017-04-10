/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.DBConnection;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.table.TableModel;
import static vista.Personas_frm.modeloTipo;

/**
 *
 * @author treznor
 */

public class Gastos extends javax.swing.JFrame {
    DefaultListModel modelo = new DefaultListModel();
    

public final class Gastos1 extends javax.swing.JFrame {


    /**
     * Creates new form Gastos
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

    String categoria;

    public Gastos1() {
        initComponents();
        con = DBConnection.getConnection();
        sqlSelect = "SELECT `gasto_id`, `tipo_gasto`, `monto_gasto`, `fecha_gasto`, `factura_gasto`, `colaborador_empleado_id` FROM `gasto_operativo` order BY `gasto_id`";
        sqlInsert = "INSERT INTO `gasto_operativo`(`gasto_id`, `tipo_gasto`, `monto_gasto`, `fecha_gasto`, `factura_gasto`, `colaborador_empleado_id`) VALUES ('";
        sqlDelete = "DELETE FROM `gasto_operativo` WHERE `gasto_id` = ";

        modeloTipo = new DefaultComboBoxModel();

        llena_combo(); // llenar los datos al ejecutar el programa

        //Group radio buttons.
        ButtonGroup group = new ButtonGroup();
        group.add(jRadioBtnIngresar);
        group.add(jRadioBtnEditar);

    }

    public void llena_combo() { // static para poder llamarlo desde el otro frame o JDialog
        try {
            modeloTipo.removeAllElements(); // eliminamos lo elementos
            Statement stmt;
            stmt = con.createStatement();
            String queryComboEstado = "SELECT `tipo_gasto` FROM `gasto_operativo`";
            rs = stmt.executeQuery(queryComboEstado);
            while (rs.next()) {
                modeloTipo.addElement(rs.getString("tipo_gasto"));

            }
            jComboBTipogasto.setModel(modeloTipo); // seteamos el modelo y se cargan los datos

        } catch (HeadlessException | SQLException ex) {
            JOptionPane.showMessageDialog(this, ex);
        }

    }

    private void initState() {
        jTxtFMonto.setEnabled(false);
        jTxtFFecha.setEnabled(false);
        jTxtFFactura.setEnabled(false);
        jTxtFColaborador.setEnabled(false);
        jBtnIngresar.setEnabled(false);
        jBtnLimpiar.setEnabled(false);
        jTable1.setEnabled(false);
        jTxtFNumFac.setEnabled(false);
        jBtnBuscar.setEnabled(false);
        jBtnEditar.setEnabled(false);
        jBtnGuardar.setEnabled(false);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLblTipoGasto = new javax.swing.JLabel();
        jLblMonto = new javax.swing.JLabel();
        jLblFecha = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTxtFMonto = new javax.swing.JTextField();
        jTxtFFecha = new javax.swing.JTextField();
        jTxtFFactura = new javax.swing.JTextField();
        jTxtFColaborador = new javax.swing.JTextField();
        jBtnIngresar = new javax.swing.JButton();
        jBtnLimpiar = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jComboBTipogasto = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jRadioBtnIngresar = new javax.swing.JRadioButton();
        jRadioBtnEditar = new javax.swing.JRadioButton();
        jBtnBuscar = new javax.swing.JButton();
        jLblNumerofac = new javax.swing.JLabel();
        jTxtFNumFac = new javax.swing.JTextField();
        jBtnEditar = new javax.swing.JButton();
        jBtnGuardar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Gastos");

        jLabel1.setFont(new java.awt.Font("Dialog", 3, 16)); // NOI18N
        jLabel1.setText("Ingreso De Gastos ");

        jLblTipoGasto.setFont(new java.awt.Font("Dialog", 3, 16)); // NOI18N
        jLblTipoGasto.setText("Tipo De Gasto");

        jLblMonto.setFont(new java.awt.Font("Dialog", 3, 16)); // NOI18N
        jLblMonto.setText("Monto");

        jLblFecha.setFont(new java.awt.Font("Dialog", 3, 16)); // NOI18N
        jLblFecha.setText("Fecha Del Gasto");

        jLabel5.setFont(new java.awt.Font("Dialog", 3, 16)); // NOI18N
        jLabel5.setText("Número De Factura");

        jLabel6.setFont(new java.awt.Font("Dialog", 3, 16)); // NOI18N
        jLabel6.setText("Colaborador");

        jTxtFMonto.setFont(new java.awt.Font("Dialog", 3, 16)); // NOI18N

        jTxtFFecha.setFont(new java.awt.Font("Dialog", 3, 16)); // NOI18N

        jTxtFFactura.setFont(new java.awt.Font("Dialog", 3, 16)); // NOI18N

        jTxtFColaborador.setFont(new java.awt.Font("Dialog", 3, 16)); // NOI18N

        jBtnIngresar.setFont(new java.awt.Font("Dialog", 3, 16)); // NOI18N
        jBtnIngresar.setText("Guardar");
        jBtnIngresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnIngresarActionPerformed(evt);
            }
        });

        jBtnLimpiar.setFont(new java.awt.Font("Dialog", 3, 16)); // NOI18N
        jBtnLimpiar.setText("Limpiar");
        jBtnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnLimpiarActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Dialog", 3, 16)); // NOI18N
        jButton3.setText("Salir");

        jComboBTipogasto.setFont(new java.awt.Font("Dialog", 3, 16)); // NOI18N
        jComboBTipogasto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBTipogastoActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Tipo De Gasto", "Monto", "Fecha", "Numero De Factura", "Colaborador"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jRadioBtnIngresar.setFont(new java.awt.Font("Dialog", 3, 16)); // NOI18N
        jRadioBtnIngresar.setText("Ingresar Gastos");
        jRadioBtnIngresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioBtnIngresarActionPerformed(evt);
            }
        });

        jRadioBtnEditar.setFont(new java.awt.Font("Dialog", 3, 16)); // NOI18N
        jRadioBtnEditar.setText("Editar Gastos");
        jRadioBtnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioBtnEditarActionPerformed(evt);
            }
        });

        jBtnBuscar.setFont(new java.awt.Font("Dialog", 3, 16)); // NOI18N
        jBtnBuscar.setText("Buscar");

        jLblNumerofac.setFont(new java.awt.Font("Dialog", 3, 16)); // NOI18N
        jLblNumerofac.setText("Buscar número de factura");

        jTxtFNumFac.setFont(new java.awt.Font("Dialog", 3, 16)); // NOI18N
        jTxtFNumFac.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTxtFNumFacKeyReleased(evt);
            }
        });

        jBtnEditar.setFont(new java.awt.Font("Dialog", 3, 16)); // NOI18N
        jBtnEditar.setText("Editar");

        jBtnGuardar.setFont(new java.awt.Font("Dialog", 3, 16)); // NOI18N
        jBtnGuardar.setText("Guardar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLblTipoGasto)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLblMonto)
                            .addComponent(jLblFecha)
                            .addComponent(jLabel6))
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTxtFMonto)
                            .addComponent(jTxtFFecha)
                            .addComponent(jTxtFFactura)
                            .addComponent(jTxtFColaborador)
                            .addComponent(jComboBTipogasto, 0, 208, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jBtnIngresar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jBtnLimpiar)))
                        .addGap(18, 42, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 518, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jBtnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(23, 23, 23)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jBtnGuardar)
                                        .addGap(0, 0, Short.MAX_VALUE)))))
                        .addGap(16, 16, 16))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jRadioBtnEditar)
                            .addComponent(jRadioBtnIngresar))
                        .addGap(278, 278, 278)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLblNumerofac)
                            .addComponent(jTxtFNumFac, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, 26, Short.MAX_VALUE)
                        .addComponent(jBtnBuscar)
                        .addGap(229, 229, 229))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)

                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jRadioBtnIngresar)
                            .addComponent(jLblNumerofac))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jBtnBuscar)
                            .addComponent(jTxtFNumFac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jRadioBtnEditar)
                        .addGap(18, 18, 18)))

                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioBtnIngresar)
                    .addComponent(jLblNumerofac))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jRadioBtnEditar)
                        .addComponent(jTxtFNumFac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)

                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLblTipoGasto)
                            .addComponent(jComboBTipogasto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLblMonto)
                            .addComponent(jTxtFMonto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLblFecha)
                            .addComponent(jTxtFFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jTxtFFactura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jTxtFColaborador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jBtnIngresar)
                        .addComponent(jBtnLimpiar))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jBtnGuardar)
                        .addComponent(jBtnEditar)))
                .addGap(24, 24, 24)
                .addComponent(jButton3)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBTipogastoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBTipogastoActionPerformed
        // TODO add your handling code here:

        categoria = (String) jComboBTipogasto.getSelectedItem();


    }//GEN-LAST:event_jComboBTipogastoActionPerformed

    private void jBtnIngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnIngresarActionPerformed
        // TODO add your handling code here:

        String sql = sqlInsert + jComboBTipogasto.getSelectedItem() + "','" + jTxtFMonto.getText() + "','" + jTxtFFecha.getText() + "','" + jTxtFFactura.getText() + "','" + jTxtFColaborador.getText() + "')";
        try {
            pst = con.prepareStatement(sql);
        } catch (SQLException ex) {
            Logger.getLogger(Gastos.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            pst.execute();
        } catch (SQLException ex) {
            Logger.getLogger(Gastos.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_jBtnIngresarActionPerformed

    private void jRadioBtnIngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioBtnIngresarActionPerformed
        // TODO add your handling code here:
        if (jRadioBtnIngresar.isSelected()) {

            jTxtFMonto.setEnabled(true);
            jTxtFFecha.setEnabled(true);
            jTxtFFactura.setEnabled(true);
            jTxtFColaborador.setEnabled(true);
            jBtnIngresar.setEnabled(true);
            jBtnLimpiar.setEnabled(true);
        }


    }//GEN-LAST:event_jRadioBtnIngresarActionPerformed

    private void jRadioBtnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioBtnEditarActionPerformed
        // TODO add your handling code here:

        jTable1.setEnabled(true);
        jTxtFNumFac.setEnabled(true);
        jBtnBuscar.setEnabled(true);
        jBtnEditar.setEnabled(true);
        jBtnGuardar.setEnabled(true);


    }//GEN-LAST:event_jRadioBtnEditarActionPerformed

    private void jBtnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnLimpiarActionPerformed
        // TODO add your handling code here:
        jTxtFMonto.setText("");
        jTxtFFecha.setText("");
        jTxtFFactura.setText("");
        jTxtFColaborador.setText("");


    }//GEN-LAST:event_jBtnLimpiarActionPerformed

    private void jTxtFNumFacKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTxtFNumFacKeyReleased
        // TODO add your handling code here:
        
        Connection cn;
        if (this.jBtnBuscar.getText().isEmpty()){
            modelo.clear();
        }else{
           try {
            Statement stmt;
            stmt = con.createStatement();
            String queryLista = "SELECT `tipo_gasto`,`monto`,`Fecha`,`Numero_Factura`,`Colaborador` FROM `gasto_operativo`";
            rs = stmt.executeQuery(queryLista);
            while (rs.next()) {
                modelo.addElement(rs.getString("tipo_gasto, monto, fecha, Numero_Factura, Colaborador"));

            }
            jTable1.setModel((TableModel) modelo); // seteamos el modelo y se cargan los datos

        } catch (HeadlessException | SQLException ex) {
            JOptionPane.showMessageDialog(this, ex);
        }
        }
            
    }//GEN-LAST:event_jTxtFNumFacKeyReleased

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
            java.util.logging.Logger.getLogger(Gastos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Gastos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Gastos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Gastos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Gastos().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jBtnBuscar;
    private javax.swing.JButton jBtnEditar;
    private javax.swing.JButton jBtnGuardar;
    private javax.swing.JButton jBtnIngresar;
    private javax.swing.JButton jBtnLimpiar;
    private javax.swing.JButton jButton3;
    private javax.swing.JComboBox jComboBTipogasto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLblFecha;
    private javax.swing.JLabel jLblMonto;
    private javax.swing.JLabel jLblNumerofac;
    private javax.swing.JLabel jLblTipoGasto;
    private javax.swing.JRadioButton jRadioBtnEditar;
    private javax.swing.JRadioButton jRadioBtnIngresar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTxtFColaborador;
    private javax.swing.JTextField jTxtFFactura;
    private javax.swing.JTextField jTxtFFecha;
    private javax.swing.JTextField jTxtFMonto;
    private javax.swing.JTextField jTxtFNumFac;
    // End of variables declaration//GEN-END:variables
}
