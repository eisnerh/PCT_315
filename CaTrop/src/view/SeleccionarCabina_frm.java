/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.ConexionDB;
import java.awt.Color;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author ace
 */
public class SeleccionarCabina_frm extends javax.swing.JFrame {

    /**
     * Creates new form SeleccionarCabina
     */
    // Se crea un array de botones
    private final List<JButton> botones;
    // Se agrega un indice para prueba del nombre, aunque debería leer el nombre de la cabina.
    JButton b[];
    String cambiarFuncion[] = new String[6];
    
    Connection con = null;
    ResultSet rs = null;
    PreparedStatement pst = null;

    public SeleccionarCabina_frm() {
        initComponents();
        agregarCabinas.setOpaque(false);
        opciones.setOpaque(false);
        initComponents();
        setLocationRelativeTo(null);
        botones = new ArrayList<>();
    con = ConexionDB.conexionDB();
    Get_Data();
    
    }
    
    private void Get_Data() {
        //Select sobre el estatus_empleado y se le asigna el valor a la columna de la tabla del formulario.
        
        String sqlQuery = "SELECT `descripcion_cabina`, `estado_cabina` FROM `cabina` ORDER BY `estado_cabina` ";
        int totalRegistros;
        agregarCabinas.removeAll();
        try {
            pst = con.prepareStatement(sqlQuery);

            rs = pst.executeQuery();
            totalRegistros = 0;
            while (rs.next()) {
                String nombreCabina = rs.getString(1);
                JButton btn = new JButton(nombreCabina);
                agregarCabinas.add(btn);
                
                if (rs.getString(2).equals("Ocupado")) {
                    btn.setBackground(Color.red);
                    btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icons/Cabina/racing.png"))); // NOI18N
                }
                if (rs.getString(2).equals("Libre")) {
                    btn.setBackground(Color.green);
                    btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icons/Cabina/house.png"))); // NOI18N
                }
                if (rs.getString(2).equals("Limpieza")) {
                    btn.setBackground(Color.yellow);
                    btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icons/Cabina/wiping.png"))); // NOI18N
                }
                if (rs.getString(2).equals("Bloqueo")) {
                    btn.setBackground(Color.yellow);
                    btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icons/Cabina/blocked.png"))); // NOI18N
                }
                btn.addActionListener(new ActionListener() {
                    

                    @Override
                    public void actionPerformed(java.awt.event.ActionEvent e) {
                        try {
                            Principal_frm p = new Principal_frm();
                            p.setVisible(true);
                        } catch (IOException ex) {
                            Logger.getLogger(SeleccionarCabina_frm.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                });
                totalRegistros++;
                
            }
            
            agregarCabinas.updateUI();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);

        }
    }
    
    private void Get_Bloqueo() {
        //Select sobre el estatus_empleado y se le asigna el valor a la columna de la tabla del formulario.
        
        String sqlQuery = "SELECT `descripcion_cabina`, `estado_cabina` FROM `cabina` ORDER BY `estado_cabina` ";
        int totalRegistros;
        agregarCabinas.removeAll();
        try {
            pst = con.prepareStatement(sqlQuery);

            rs = pst.executeQuery();
            totalRegistros = 0;
            while (rs.next()) {
                String nombreCabina = rs.getString(1);
                JButton btn = new JButton(nombreCabina);
                agregarCabinas.add(btn);
                
                if (rs.getString(2).equals("Ocupado")) {
                    btn.setBackground(Color.red);
                    btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icons/Cabina/racing.png"))); // NOI18N
                }
                if (rs.getString(2).equals("Libre")) {
                    btn.setBackground(Color.green);
                    btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icons/Cabina/house.png"))); // NOI18N
                }
                if (rs.getString(2).equals("Limpieza")) {
                    btn.setBackground(Color.yellow);
                    btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icons/Cabina/wiping.png"))); // NOI18N
                }
                if (rs.getString(2).equals("Bloqueo")) {
                    btn.setBackground(Color.yellow);
                    btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icons/Cabina/blocked.png"))); // NOI18N
                }
                btn.addActionListener(new ActionListener() {


                    @Override
                    public void actionPerformed(java.awt.event.ActionEvent e) {
                        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                    }
                });
                totalRegistros++;
                
            }
            
            agregarCabinas.updateUI();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);

        }
    }
    
    private void Get_Libre() {
        //Select sobre el estatus_empleado y se le asigna el valor a la columna de la tabla del formulario.
        
        String sqlQuery = "SELECT `descripcion_cabina`, `estado_cabina` FROM `cabina` WHERE `estado_cabina` = 'Libre' order by `descripcion_cabina` ";
        int totalRegistros;
        agregarCabinas.removeAll();
        try {
            pst = con.prepareStatement(sqlQuery);

            rs = pst.executeQuery();
            totalRegistros = 0;
            while (rs.next()) {
                String nombreCabina = rs.getString(1);
                JButton btn = new JButton(nombreCabina);
                agregarCabinas.add(btn);
                
                if (rs.getString(2).equals("Ocupado")) {
                    btn.setBackground(Color.red);
                    btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icons/Cabina/racing.png"))); // NOI18N
                }
                if (rs.getString(2).equals("Libre")) {
                    btn.setBackground(Color.green);
                    btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icons/Cabina/house.png"))); // NOI18N
                }
                if (rs.getString(2).equals("Limpieza")) {
                    btn.setBackground(Color.yellow);
                    btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icons/Cabina/wiping.png"))); // NOI18N
                }
                if (rs.getString(2).equals("Bloqueo")) {
                    btn.setBackground(Color.yellow);
                    btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icons/Cabina/blocked.png"))); // NOI18N
                }
                btn.addActionListener(new ActionListener() {

                    @Override
                    public void actionPerformed(java.awt.event.ActionEvent e) {
                        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                    }
                });
                totalRegistros++;
                
            }
            
            agregarCabinas.updateUI();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);

        }
    }
    
    private void Get_Ocupado() {
        //Select sobre el estatus_empleado y se le asigna el valor a la columna de la tabla del formulario.
        
        String sqlQuery = "SELECT `descripcion_cabina`, `estado_cabina` FROM `pct3`.`cabina` AS `cabina` WHERE `estado_cabina` = 'Ocupado' ORDER BY `descripcion_cabina` ASC";
        int totalRegistros;
        agregarCabinas.removeAll();
        try {
            pst = con.prepareStatement(sqlQuery);

            rs = pst.executeQuery();
            totalRegistros = 0;
            while (rs.next()) {
                String nombreCabina = rs.getString(1);
                JButton btn = new JButton(nombreCabina);
                agregarCabinas.add(btn);
                
                if (rs.getString(2).equals("Ocupado")) {
                    btn.setBackground(Color.red);
                    btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icons/Cabina/racing.png"))); // NOI18N
                }
                if (rs.getString(2).equals("Libre")) {
                    btn.setBackground(Color.green);
                    btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icons/Cabina/house.png"))); // NOI18N
                }
                if (rs.getString(2).equals("Limpieza")) {
                    btn.setBackground(Color.yellow);
                    btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icons/Cabina/wiping.png"))); // NOI18N
                }
                if (rs.getString(2).equals("Bloqueo")) {
                    btn.setBackground(Color.yellow);
                    btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icons/Cabina/blocked.png"))); // NOI18N
                }
                btn.addActionListener(new ActionListener() {
                   

                    @Override
                    public void actionPerformed(java.awt.event.ActionEvent e) {
                        System.out.println("Ocupado");
                    }
                });
                
                totalRegistros++;
                
            }
            
            agregarCabinas.updateUI();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);

        }
    }
    
    private void Get_Limpieza() {
        //Select sobre el estatus_empleado y se le asigna el valor a la columna de la tabla del formulario.
        
        String sqlQuery = "SELECT `descripcion_cabina`, `estado_cabina` FROM `pct3`.`cabina` AS `cabina` WHERE `estado_cabina` = 'Limpieza' ORDER BY `descripcion_cabina` ASC";
        int totalRegistros;
        agregarCabinas.removeAll();
        try {
            pst = con.prepareStatement(sqlQuery);

            rs = pst.executeQuery();
            totalRegistros = 0;
            while (rs.next()) {
                String nombreCabina = rs.getString(1);
                JButton btn = new JButton(nombreCabina);
                agregarCabinas.add(btn);
                
                if (rs.getString(2).equals("Ocupado")) {
                    btn.setBackground(Color.red);
                    btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icons/Cabina/racing.png"))); // NOI18N
                }
                if (rs.getString(2).equals("Libre")) {
                    btn.setBackground(Color.green);
                    btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icons/Cabina/house.png"))); // NOI18N
                }
                if (rs.getString(2).equals("Limpieza")) {
                    btn.setBackground(Color.yellow);
                    btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icons/Cabina/wiping.png"))); // NOI18N
                }
                if (rs.getString(2).equals("Bloqueo")) {
                    btn.setBackground(Color.yellow);
                    btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icons/Cabina/blocked.png"))); // NOI18N
                }
                btn.addActionListener(new ActionListener() {
                   

                    @Override
                    public void actionPerformed(java.awt.event.ActionEvent e) {
                        try {
                            Principal_frm p = new Principal_frm();
                            p.setVisible(true);
                        } catch (IOException ex) {
                            Logger.getLogger(SeleccionarCabina_frm.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                });
                
                totalRegistros++;
                
            }
            
            agregarCabinas.updateUI();
            
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

        bgOpciones = new javax.swing.ButtonGroup();
        opciones = new javax.swing.JPanel();
        Ocupado = new javax.swing.JRadioButton();
        Todos = new javax.swing.JRadioButton();
        Sencilla = new javax.swing.JRadioButton();
        Vacio = new javax.swing.JRadioButton();
        Limpieza = new javax.swing.JRadioButton();
        Bloqueado = new javax.swing.JRadioButton();
        Doble = new javax.swing.JRadioButton();
        agregarCabinas = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Selección de Cábinas");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        opciones.setBackground(new java.awt.Color(0, 51, 51));
        opciones.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        Ocupado.setBackground(new java.awt.Color(0, 51, 51));
        bgOpciones.add(Ocupado);
        Ocupado.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        Ocupado.setForeground(new java.awt.Color(251, 251, 251));
        Ocupado.setText("Ocupado");
        Ocupado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OcupadoActionPerformed(evt);
            }
        });

        Todos.setBackground(new java.awt.Color(0, 51, 51));
        bgOpciones.add(Todos);
        Todos.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        Todos.setForeground(new java.awt.Color(251, 251, 251));
        Todos.setText("Todos");
        Todos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TodosActionPerformed(evt);
            }
        });

        Sencilla.setBackground(new java.awt.Color(0, 51, 51));
        bgOpciones.add(Sencilla);
        Sencilla.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        Sencilla.setForeground(new java.awt.Color(251, 251, 251));
        Sencilla.setText("Hab. Doble");
        Sencilla.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SencillaActionPerformed(evt);
            }
        });

        Vacio.setBackground(new java.awt.Color(0, 51, 51));
        bgOpciones.add(Vacio);
        Vacio.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        Vacio.setForeground(new java.awt.Color(251, 251, 251));
        Vacio.setText("Vacio");
        Vacio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VacioActionPerformed(evt);
            }
        });

        Limpieza.setBackground(new java.awt.Color(0, 51, 51));
        bgOpciones.add(Limpieza);
        Limpieza.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        Limpieza.setForeground(new java.awt.Color(251, 251, 251));
        Limpieza.setText("Limpieza");
        Limpieza.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LimpiezaActionPerformed(evt);
            }
        });

        Bloqueado.setBackground(new java.awt.Color(0, 51, 51));
        bgOpciones.add(Bloqueado);
        Bloqueado.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        Bloqueado.setForeground(new java.awt.Color(251, 251, 251));
        Bloqueado.setText("Bloqueado");
        Bloqueado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BloqueadoActionPerformed(evt);
            }
        });

        Doble.setBackground(new java.awt.Color(0, 51, 51));
        bgOpciones.add(Doble);
        Doble.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        Doble.setForeground(new java.awt.Color(251, 251, 251));
        Doble.setText("Hab. Sencilla");
        Doble.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DobleActionPerformed(evt);
            }
        });

        agregarCabinas.setLayout(new java.awt.GridLayout(0, 3));

        javax.swing.GroupLayout opcionesLayout = new javax.swing.GroupLayout(opciones);
        opciones.setLayout(opcionesLayout);
        opcionesLayout.setHorizontalGroup(
            opcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(opcionesLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(opcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Sencilla)
                    .addComponent(Doble)
                    .addComponent(Ocupado)
                    .addComponent(Vacio)
                    .addComponent(Todos)
                    .addComponent(Limpieza)
                    .addComponent(Bloqueado))
                .addContainerGap(595, Short.MAX_VALUE))
            .addGroup(opcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(opcionesLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(agregarCabinas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        opcionesLayout.setVerticalGroup(
            opcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(opcionesLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(Todos)
                .addGap(18, 18, 18)
                .addComponent(Ocupado)
                .addGap(18, 18, 18)
                .addComponent(Vacio)
                .addGap(18, 18, 18)
                .addComponent(Limpieza)
                .addGap(18, 18, 18)
                .addComponent(Bloqueado)
                .addGap(18, 18, 18)
                .addComponent(Doble)
                .addGap(18, 18, 18)
                .addComponent(Sencilla)
                .addGap(0, 55, Short.MAX_VALUE))
            .addGroup(opcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(opcionesLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(agregarCabinas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        getContentPane().add(opciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 700, 400));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void OcupadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OcupadoActionPerformed
        // TODO add your handling code here:
        agregarCabinas.removeAll();
        Get_Ocupado();
    }//GEN-LAST:event_OcupadoActionPerformed

    private void TodosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TodosActionPerformed
        // TODO add your handling code here:
        agregarCabinas.removeAll();
        Get_Data();
    }//GEN-LAST:event_TodosActionPerformed

    private void VacioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VacioActionPerformed
        // TODO add your handling code here:
        agregarCabinas.removeAll();
        Get_Libre();
    }//GEN-LAST:event_VacioActionPerformed

    private void LimpiezaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LimpiezaActionPerformed
        // TODO add your handling code here:
        agregarCabinas.removeAll();
        Get_Limpieza();
    }//GEN-LAST:event_LimpiezaActionPerformed

    private void BloqueadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BloqueadoActionPerformed
        // TODO add your handling code here:
        agregarCabinas.removeAll();
    }//GEN-LAST:event_BloqueadoActionPerformed

    private void DobleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DobleActionPerformed
        // TODO add your handling code here:
        agregarCabinas.removeAll();
    }//GEN-LAST:event_DobleActionPerformed

    private void SencillaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SencillaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SencillaActionPerformed

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
            java.util.logging.Logger.getLogger(SeleccionarCabina_frm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new SeleccionarCabina_frm().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton Bloqueado;
    private javax.swing.JRadioButton Doble;
    private javax.swing.JRadioButton Limpieza;
    private javax.swing.JRadioButton Ocupado;
    private javax.swing.JRadioButton Sencilla;
    private javax.swing.JRadioButton Todos;
    private javax.swing.JRadioButton Vacio;
    private javax.swing.JPanel agregarCabinas;
    private javax.swing.ButtonGroup bgOpciones;
    private javax.swing.JPanel opciones;
    // End of variables declaration//GEN-END:variables

    private static abstract class ActionListener implements java.awt.event.ActionListener {

        public ActionListener() {
        }
    }

    

    
}
