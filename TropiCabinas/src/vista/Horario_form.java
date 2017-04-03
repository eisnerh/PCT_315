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
import modelo.contructor.Modelo_Horario;
import modelo.formularios.Form_Horario;

/**
 *
 * @author Eisner López Acevedo <eisner.lopez at gmail.com>
 * @author Cesar Gonzalez Salas <cgonzalez816 at gmail.com>
 */
public class Horario_form extends javax.swing.JInternalFrame {

    /**
     * Creates new form Horario_form
     */
    private final DBConnection myLink = new DBConnection();
    private final Connection conexion = DBConnection.getConnection();
    private final String sSQL = "";
    ResultSet rs = null;
    PreparedStatement pst = null;
    public Integer totalregistros;
    //declaración del modelo para Turno u Horario
    static DefaultComboBoxModel modeloTurno = new DefaultComboBoxModel();
    public String var1 = "";

    public Horario_form() {
        initComponents();
        comboTurno();
    }

    private void comboTurno() { //para poder llamarlo desde el otro frame o JDialog
        try {
            modeloTurno.removeAllElements(); // eliminamos lo elementos
            Statement stmt;
            stmt = conexion.createStatement();

            String queryComboTurno = "SELECT "
                    + "COUNT(*), descripcion_horario AS descripcion "
                    + "FROM "
                    + "horario "
                    + "GROUP BY descripcion_horario "
                    + "ORDER BY descripcion_horario;";
            rs = stmt.executeQuery(queryComboTurno);
            while (rs.next()) {
                modeloTurno.addElement(rs.getString("descripcion"));
            }
            Combo_turno.setModel(modeloTurno); // seteamos el modelo y se cargan los datos

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

        jPanel3 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        btnGuardar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnBorrar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtDescripcionHorario = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        Combo_turno = new javax.swing.JComboBox<>();

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Horarios");

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setLayout(new java.awt.GridBagLayout());

        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/CRUD/save-icon-silhouette.png"))); // NOI18N
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
        jLabel1.setText("Turnos:");

        txtDescripcionHorario.setFont(new java.awt.Font("Hack", 0, 14)); // NOI18N
        txtDescripcionHorario.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtDescripcionHorarioFocusLost(evt);
            }
        });
        txtDescripcionHorario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtDescripcionHorarioKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtDescripcionHorario)
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
                .addComponent(txtDescripcionHorario, javax.swing.GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE)
                .addContainerGap())
        );

        Combo_turno.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        Combo_turno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Combo_turnoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Combo_turno, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Combo_turno, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

    private void txtDescripcionHorarioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDescripcionHorarioKeyPressed
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if (Character.isDigit(c)) {
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(this, "Ingresa Solo Letras.\n Gracias!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_txtDescripcionHorarioKeyPressed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        // TODO add your handling code here:
        if (txtDescripcionHorario.getText().length() == 0) {
            JOptionPane.showConfirmDialog(rootPane, "Debes ingresar un Turno para el Horario");
            txtDescripcionHorario.requestFocus();
            return;
        }
        try {
            if (txtDescripcionHorario.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Favor ingresa un turno", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            Statement stmt;
            stmt = conexion.createStatement();

            String sql1 = "SELECT `descripcion_horario` FROM `horario` WHERE `descripcion_horario` = '" + txtDescripcionHorario.getText() + "'";
            rs = stmt.executeQuery(sql1);
            if (rs.next()) {
                JOptionPane.showMessageDialog(this, "Horario existente.", "Error", JOptionPane.ERROR_MESSAGE);
                txtDescripcionHorario.setText("");
                return;
            }
        } catch (HeadlessException | SQLException ex) {
            JOptionPane.showMessageDialog(this, ex);

        }

        Modelo_Horario dts = new Modelo_Horario();
        Form_Horario func = new Form_Horario();
        dts.setDescripcionHorario(txtDescripcionHorario.getText());
        if (func.insertar(dts)) {
            JOptionPane.showMessageDialog(rootPane, "el cliente fue registrado satisfactoriamente");
        }
        txtDescripcionHorario.setText("");
        comboTurno();
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        // TODO add your handling code here:
        if (txtDescripcionHorario.getText().length() == 0) {
            JOptionPane.showConfirmDialog(rootPane, "Debes ingresar un Turno para el Horario");
            txtDescripcionHorario.requestFocus();
            return;
        }

        Modelo_Horario dts = new Modelo_Horario();
        Form_Horario func = new Form_Horario();
        dts.setDescripcionHorario(txtDescripcionHorario.getText());

        if (func.editar(dts)) {
            JOptionPane.showMessageDialog(rootPane, "El Horario fue editado satisfactoriamente");

        }
        txtDescripcionHorario.setText("");

        comboTurno();
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarActionPerformed
        // TODO add your handling code here:
        if (!txtDescripcionHorario.getText().equals("")) {
            int confirmacion = JOptionPane.showConfirmDialog(rootPane, "Estás seguro de Eliminar el dato?", "Confirmar", JOptionPane.YES_NO_OPTION, 2);

            if (confirmacion == 0) {
                Modelo_Horario dts = new Modelo_Horario();
                Form_Horario func = new Form_Horario();

                dts.setDescripcionHorario(txtDescripcionHorario.getText());
                func.eliminar(dts);

            }

        }
        txtDescripcionHorario.setText("");
    }//GEN-LAST:event_btnBorrarActionPerformed

    private void Combo_turnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Combo_turnoActionPerformed
        // TODO add your handling code here:
        try {
            //SELECT `idpersona`, `nombre`, `cedula`, `telefono`, `direccion`, `tipo_persona_idtipo_persona` FROM `persona` WHERE 1
            String sql = "SELECT `horario_id`, `descripcion_horario` FROM `horario` WHERE `descripcion_horario` = '" + Combo_turno.getSelectedItem().toString() + "'";
            pst = conexion.prepareStatement(sql);
            rs = pst.executeQuery();
            if (rs.next()) {
                String add1 = rs.getString("horario_id");
                String add2 = rs.getString("descripcion_horario");

                var1 = add1;
                txtDescripcionHorario.setText(add2);

            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);

        }

    }//GEN-LAST:event_Combo_turnoActionPerformed

    private void txtDescripcionHorarioFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtDescripcionHorarioFocusLost
        // TODO add your handling code here:
        try {
            if (txtDescripcionHorario.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Favor ingresa un turno", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            Statement stmt;
            stmt = conexion.createStatement();

            String sql1 = "SELECT `descripcion_horario` FROM `horario` WHERE `descripcion_horario` = '" + txtDescripcionHorario.getText() + "'";
            rs = stmt.executeQuery(sql1);
            if (rs.next()) {
                JOptionPane.showMessageDialog(this, "Horario existente.", "Error", JOptionPane.ERROR_MESSAGE);
                txtDescripcionHorario.setText("");
            }
        } catch (HeadlessException | SQLException ex) {
            JOptionPane.showMessageDialog(this, ex);

        }
    }//GEN-LAST:event_txtDescripcionHorarioFocusLost


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> Combo_turno;
    private javax.swing.JButton btnBorrar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JTextField txtDescripcionHorario;
    // End of variables declaration//GEN-END:variables
}
