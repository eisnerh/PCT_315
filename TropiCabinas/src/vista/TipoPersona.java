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
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import modelo.contructor.Modelo_TipoPersona;
import modelo.formularios.Form_TipoPersona;

/**
 *
 * @author Eisner López Acevedo <eisner.lopez at gmail.com>
 * @author Cesar Gonzalez Salas <cgonzalez816 at gmail.com>
 */
public class TipoPersona extends javax.swing.JInternalFrame {

    /**
     * Creates new form TipoPersona
     */
    private final DBConnection myLink = new DBConnection();
    private final Connection conexion = DBConnection.getConnection();
    private final String sSQL = "";
    ResultSet rs = null;
    PreparedStatement pst = null;
    public Integer totalregistros;
    //declaración del modelo para Turno u Horario
    //declarar static e instanciarla en tu contructor`
    static DefaultComboBoxModel modeloTipoPersona;
    
    public String var1 = "";

    public TipoPersona() {
        initComponents();
        modeloTipoPersona = new DefaultComboBoxModel();
        comboTipoPersona();
    }

    private void comboTipoPersona() { //para poder llamarlo desde el otro frame o JDialog
        try {
            modeloTipoPersona.removeAllElements(); // eliminamos lo elementos
            Statement stmt;
            stmt = conexion.createStatement();
            String queryComboTipoPersona = "SELECT DISTINCT "
                    + "desc_persona "
                    + "FROM "
                    + "pct3.tipo_persona "
                    + "ORDER BY desc_persona;";
            rs = stmt.executeQuery(queryComboTipoPersona);
            while (rs.next()) {
                modeloTipoPersona.addElement(rs.getString(1));
            }
            comboTipoPersona.setModel(modeloTipoPersona); // seteamos el modelo y se cargan los datos
        } catch (HeadlessException | SQLException ex) {
            JOptionPane.showMessageDialog(this, ex);
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
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel1 = new javax.swing.JPanel();
        btnGuardar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnBorrar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txt_Tipo_Persona = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        comboTipoPersona = new javax.swing.JComboBox<>();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setLayout(new java.awt.GridBagLayout());

        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/CRUD/save-icon-silhouette.png"))); // NOI18N
        btnGuardar.setMaximumSize(new java.awt.Dimension(82, 58));
        btnGuardar.setMinimumSize(new java.awt.Dimension(82, 58));
        btnGuardar.setPreferredSize(new java.awt.Dimension(82, 58));
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(14, 14, 24, 0);
        jPanel1.add(btnGuardar, gridBagConstraints);

        btnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/CRUD/edit.png"))); // NOI18N
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(14, 12, 24, 0);
        jPanel1.add(btnEditar, gridBagConstraints);

        btnBorrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/CRUD/dustbin.png"))); // NOI18N
        btnBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(14, 12, 24, 25);
        jPanel1.add(btnBorrar, gridBagConstraints);

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setFont(new java.awt.Font("HP Simplified Light", 1, 14)); // NOI18N
        jLabel1.setText("Tipo Persona");

        txt_Tipo_Persona.setFont(new java.awt.Font("Hack", 0, 14)); // NOI18N
        txt_Tipo_Persona.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_Tipo_PersonaFocusLost(evt);
            }
        });
        txt_Tipo_Persona.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_Tipo_PersonaKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_Tipo_Persona)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txt_Tipo_Persona, javax.swing.GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE)
                .addContainerGap())
        );

        comboTipoPersona.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        comboTipoPersona.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboTipoPersonaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(comboTipoPersona, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(comboTipoPersona, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(41, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        
        try {
            if (txt_Tipo_Persona.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Favor ingresa un tipo de persona", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            Statement stmt;
            stmt = conexion.createStatement();
            String sql1 = "SELECT `desc_persona` FROM `tipo_persona` WHERE `desc_persona` = '" + txt_Tipo_Persona.getText() + "'";
            rs = stmt.executeQuery(sql1);
            if (rs.next()) {
                JOptionPane.showMessageDialog(this, "Tipo Persona Existente.", "Error", JOptionPane.ERROR_MESSAGE);
                txt_Tipo_Persona.setText("");
                return;
            }
        } catch (HeadlessException | SQLException ex) {
            JOptionPane.showMessageDialog(this, ex);
        }
        Modelo_TipoPersona dts = new Modelo_TipoPersona();
        Form_TipoPersona func = new Form_TipoPersona();
        dts.setDesc_persona(txt_Tipo_Persona.getText());
        if (func.insertar(dts)) {
            JOptionPane.showMessageDialog(rootPane, "El tipo de persona creado satisfactoriamente");
        }
        txt_Tipo_Persona.setText("");
        comboTipoPersona();
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        // TODO add your handling code here:
        initComponents();
        if (txt_Tipo_Persona.getText().length() == 0) {
            JOptionPane.showConfirmDialog(rootPane, "Debes ingresar un tipo persona");
            txt_Tipo_Persona.requestFocus();
            return;
        }
        Modelo_TipoPersona dts = new Modelo_TipoPersona();
        Form_TipoPersona func = new Form_TipoPersona();
        dts.setDesc_persona(txt_Tipo_Persona.getText());
        if (func.editar(dts)) {
            JOptionPane.showMessageDialog(rootPane, "Tipo de Persona editado satisfactoriamente");
        }
        txt_Tipo_Persona.setText("");
        comboTipoPersona();
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarActionPerformed
        // TODO add your handling code here:
        initComponents();
        if (!txt_Tipo_Persona.getText().equals("")) {
            int confirmacion = JOptionPane.showConfirmDialog(rootPane, "Estás seguro de Eliminar el dato?", "Confirmar", JOptionPane.YES_NO_OPTION, 2);

            if (confirmacion == 0) {
                Modelo_TipoPersona dts = new Modelo_TipoPersona();
                Form_TipoPersona func = new Form_TipoPersona();

                dts.setDesc_persona(txt_Tipo_Persona.getText());
                func.eliminar(dts);
            }
        }
        txt_Tipo_Persona.setText("");
    }//GEN-LAST:event_btnBorrarActionPerformed

    private void txt_Tipo_PersonaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_Tipo_PersonaFocusLost
        // TODO add your handling code here:
        
    }//GEN-LAST:event_txt_Tipo_PersonaFocusLost

    private void txt_Tipo_PersonaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_Tipo_PersonaKeyPressed
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if (Character.isDigit(c)) {
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(this, "Ingresa Solo Letras.\n Gracias!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_txt_Tipo_PersonaKeyPressed

    private void comboTipoPersonaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboTipoPersonaActionPerformed
        // TODO add your handling code here:
        try {
            String sql = "SELECT `idtipo_persona`, `desc_persona` FROM `tipo_persona` WHERE `desc_persona` = '" + comboTipoPersona.getSelectedItem().toString() + "'";
            pst = conexion.prepareStatement(sql);
            rs = pst.executeQuery();
            if (rs.next()) {
                String add1 = rs.getString("idtipo_persona");
                String add2 = rs.getString("desc_persona");
                var1 = add1;
                txt_Tipo_Persona.setText(add2);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_comboTipoPersonaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBorrar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JComboBox<String> comboTipoPersona;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JTextField txt_Tipo_Persona;
    // End of variables declaration//GEN-END:variables
}
