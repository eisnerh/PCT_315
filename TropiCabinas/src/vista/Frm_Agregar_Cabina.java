/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.dbConnection;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.contructor.Modelo_Cabina;
import modelo.formularios.Interfaz_Cabina;

/**
 *
 * @author Eisner López Acevedo <eisner.lopez at gmail.com>
 * @author Cesar Gonzalez Salas <cgonzalez816 at gmail.com>
 */
public final class Frm_Agregar_Cabina extends javax.swing.JInternalFrame {

    /**
     * Creates new form Frm_Agregar_Cabina
     */
    Connection connection = dbConnection.getConnection();
    ResultSet rs = null;
    PreparedStatement pst = null;
    ResultSet rs2 = null;
    PreparedStatement pst2 = null;
    public String estado_Cabina;
    static DefaultComboBoxModel modeloEstado = new DefaultComboBoxModel();
    static DefaultComboBoxModel modeloTipo = new DefaultComboBoxModel();

    public Frm_Agregar_Cabina() {
        initComponents();
        cabina_di.setVisible(false);
        this.setSize(623, 445);
        comboEstado();
        comboTipoCabina();
        //Se asigna el valor del combo a una variable fija llamada estado_Cabina
        estado_Cabina = cmbEstadoCabina.getSelectedItem().toString();
        EstadoCabina.setText(cmbEstadoCabina.getSelectedItem().toString());
        TipoCabina.setText(cmbTipoCabina.getSelectedItem().toString());
        mostrarCabina("");
    }

    public void comboTipoCabina() { // static para poder llamarlo desde el otro frame o JDialog

        try {
            modeloTipo.removeAllElements(); // eliminamos lo elementos
            Statement stmt;
            stmt = connection.createStatement();
            String queryComboEstado = "SELECT distinct tipo_cabina as tipoCabina, precio FROM pct3.cabina AS cabina ORDER BY tipo_cabina ASC";
            rs = stmt.executeQuery(queryComboEstado);
            while (rs.next()) {
                modeloTipo.addElement(rs.getString("tipoCabina"));
                txtPrecio.setText(rs.getString("precio"));
                //Se consulta si el tipo de persona corresponde al valor predefinido
                if (rs.getString("tipoCabina").equals("Sencilla")) {
                    modeloTipo.setSelectedItem(rs.getString("tipoCabina"));
                }
            }
            cmbTipoCabina.setModel(modeloTipo); // seteamos el modelo y se cargan los datos

        } catch (HeadlessException | SQLException ex) {
            JOptionPane.showMessageDialog(this, ex);
        }
    }

    void ocultar_columnas() {
        tablaCabina.getColumnModel().getColumn(0).setMaxWidth(0);
        tablaCabina.getColumnModel().getColumn(0).setMinWidth(0);
        tablaCabina.getColumnModel().getColumn(0).setPreferredWidth(0);
    }

    public void limpiar() {
        cabina_di.setText("");
        txtNombreCabina.setText("");
        txtPrecio.setText("");
        cmbEstadoCabina.getModel().setSelectedItem(0);
        cmbTipoCabina.getModel().setSelectedItem(0);
    }

    public void comboEstado() { // static para poder llamarlo desde el otro frame o JDialog

        try {
            modeloEstado.removeAllElements(); // eliminamos lo elementos
            Statement stmt;
            stmt = connection.createStatement();

            String queryComboEstado = "select distinct(`estado_cabina`) from cabina group by `estado_cabina` ";
            rs = stmt.executeQuery(queryComboEstado);
            while (rs.next()) {
                modeloEstado.addElement(rs.getString(1));
                //Se consulta si el tipo de persona corresponde al valor predefinido
                if (rs.getString(1).equals("Libre")) {
                    modeloTipo.setSelectedItem(rs.getString(1));
                }
            }

            cmbEstadoCabina.setModel(modeloEstado); // seteamos el modelo y se cargan los datos

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

        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        cmbLibre = new javax.swing.JRadioButton();
        cmbOcupado = new javax.swing.JRadioButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtNombreCabina = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        cmbEstadoCabina = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        cmbTipoCabina = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        txtPrecio = new javax.swing.JFormattedTextField();
        jPanel1 = new javax.swing.JPanel();
        btnGuardar = new javax.swing.JButton();
        btnNuevo = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaCabina = new javax.swing.JTable();
        jButton7 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        Buscar_NombreCabina = new javax.swing.JTextField();
        lbltotalregistros = new javax.swing.JLabel();
        EstadoCabina = new javax.swing.JLabel();
        TipoCabina = new javax.swing.JLabel();
        cabina_di = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setTitle("Agregar Cabinas");

        jPanel2.setLayout(new java.awt.GridLayout(5, 2, 1, 1));

        cmbLibre.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        cmbLibre.setText("Libre");
        cmbLibre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbLibreActionPerformed(evt);
            }
        });

        cmbOcupado.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        cmbOcupado.setText("Ocupado");
        cmbOcupado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbOcupadoActionPerformed(evt);
            }
        });

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Cabina/racing.png"))); // NOI18N

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Cabina/blocked.png"))); // NOI18N

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmbOcupado)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addGap(18, 18, 18)
                .addComponent(cmbLibre)
                .addGap(14, 14, 14))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel6))
                        .addGap(31, 31, 31))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(cmbOcupado)
                            .addComponent(cmbLibre))
                        .addGap(22, 22, 22))))
        );

        jPanel2.add(jPanel4);
        jPanel2.add(jLabel8);

        jLabel2.setFont(new java.awt.Font("Dialog", 3, 16)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Nombre Cabina:");
        jPanel2.add(jLabel2);

        txtNombreCabina.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jPanel2.add(txtNombreCabina);

        jLabel3.setFont(new java.awt.Font("Dialog", 3, 16)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Estado Actual de la Cábina:");
        jPanel2.add(jLabel3);

        cmbEstadoCabina.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbEstadoCabina.setSelectedIndex(-1);
        cmbEstadoCabina.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbEstadoCabinaActionPerformed(evt);
            }
        });
        jPanel2.add(cmbEstadoCabina);

        jLabel5.setFont(new java.awt.Font("Dialog", 3, 16)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Tipo Cabina");
        jPanel2.add(jLabel5);

        cmbTipoCabina.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbTipoCabina.setSelectedIndex(-1);
        cmbTipoCabina.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbTipoCabinaActionPerformed(evt);
            }
        });
        jPanel2.add(cmbTipoCabina);

        jLabel4.setFont(new java.awt.Font("Dialog", 3, 16)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Precio");
        jPanel2.add(jLabel4);

        txtPrecio.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("###0.###"))));
        txtPrecio.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jPanel2.add(txtPrecio);

        jPanel1.setLayout(new java.awt.GridLayout(1, 5, 1, 1));

        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/CRUD/save-icon-silhouette.png"))); // NOI18N
        btnGuardar.setToolTipText("Guardar Cabina");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        jPanel1.add(btnGuardar);

        btnNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/CRUD/searching-magnifying-glass.png"))); // NOI18N
        btnNuevo.setToolTipText("Buscar Cabina");
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });
        jPanel1.add(btnNuevo);

        btnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/CRUD/edit.png"))); // NOI18N
        btnEditar.setToolTipText("Editar Cabina");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });
        jPanel1.add(btnEditar);

        tablaCabina.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tablaCabina.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaCabinaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaCabina);

        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/CRUD/volver.png"))); // NOI18N
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Hack", 1, 14)); // NOI18N
        jLabel1.setText("Buscar");

        Buscar_NombreCabina.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        Buscar_NombreCabina.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                Buscar_NombreCabinaKeyPressed(evt);
            }
        });

        lbltotalregistros.setText("jLabel9");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Buscar_NombreCabina)
                .addContainerGap())
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton7)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbltotalregistros)
                .addGap(188, 188, 188))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Buscar_NombreCabina)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbltotalregistros)
                .addContainerGap())
        );

        TipoCabina.setText("jLabel6");

        cabina_di.setFont(new java.awt.Font("Dialog", 3, 16)); // NOI18N
        cabina_di.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cabina_di.setText("cabina_id");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 614, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(EstadoCabina)
                        .addGap(268, 268, 268)
                        .addComponent(TipoCabina)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cabina_di, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(EstadoCabina)
                            .addComponent(TipoCabina)
                            .addComponent(cabina_di, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmbEstadoCabinaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbEstadoCabinaActionPerformed
        // TODO add your handling code here:
        cmbEstadoCabina.setSelectedIndex(0);
        estado_Cabina = (cmbEstadoCabina.getSelectedItem().toString());
    }//GEN-LAST:event_cmbEstadoCabinaActionPerformed

    private void cmbTipoCabinaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbTipoCabinaActionPerformed
        // TODO add your handling code here:
        try {
            // TODO add your handling code here:
            //TipoCabina.setText(tipoCabina.getSelectedItem().toString());
            Statement stmt;
            stmt = connection.createStatement();
            String queryComboEstado = "SELECT DISTINCT tipo_cabina as tipoCabina, precio FROM pct3.cabina AS cabina WHERE tipo_cabina = '" + cmbTipoCabina.getSelectedItem().toString() + "' ORDER BY tipo_cabina ASC";
            rs = stmt.executeQuery(queryComboEstado);
            while (rs.next()) {
                String add1 = rs.getString("tipoCabina");
                String add2 = rs.getString("precio");

                txtPrecio.setText(add2);
                TipoCabina.setText(add1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Frm_Agregar_Cabina.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_cmbTipoCabinaActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        if (txtNombreCabina.getText().length() == 0) {
            JOptionPane.showMessageDialog(rootPane, "Debes ingresar un N\u00FAmero de Habitaci\u00F3n");
            txtNombreCabina.requestFocus();
            return;
        }
        if (estado_Cabina.length() == 0) {
            JOptionPane.showMessageDialog(rootPane, "Debes ingresar una descripci\u00F3n para la Habitaci\u00F3n Habitaci\u00F3n");
            cmbEstadoCabina.requestFocus();
            return;
        }

        if (TipoCabina.getText().length() == 0) {
            JOptionPane.showMessageDialog(rootPane, "Debes ingresar un precio diario para la Habitaci\u00F3n Habitaci\u00F3n");
            cmbTipoCabina.requestFocus();
            return;
        }

        if (txtPrecio.getText().length() == 0) {
            JOptionPane.showMessageDialog(rootPane, "Debes ingresar una Precio para la Habitaci\u00F3n Habitaci\u00F3n");
            txtPrecio.requestFocus();
            return;
        }

        Modelo_Cabina dts = new Modelo_Cabina();
        Interfaz_Cabina func = new Interfaz_Cabina();

        dts.setId_cabina(null);

        dts.setDescripcionCabina(txtNombreCabina.getText());
        dts.setEstado_cabina(estado_Cabina);

        dts.setPrecio(txtPrecio.getText());

        dts.setTipo_cabina(TipoCabina.getText());

        if (func.insertar(dts)) {
            JOptionPane.showMessageDialog(rootPane, "La habitaci\u00F3n fue registrada satisfactoriamente");
            mostrarCabina("");
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        // TODO add your handling code here:
        this.setSize(1095, 447);
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        // TODO add your handling code here:
        if (txtNombreCabina.getText().length() == 0) {
            JOptionPane.showMessageDialog(rootPane, "Debes ingresar un N\u00FAmero de Habitaci\u00F3n");
            txtNombreCabina.requestFocus();
            return;
        }
        if (estado_Cabina.length() == 0) {
            JOptionPane.showMessageDialog(rootPane, "Debes ingresar una descripci\u00F3n para la Habitaci\u00F3n Habitaci\u00F3n");
            cmbEstadoCabina.requestFocus();
            return;
        }

        if (TipoCabina.getText().length() == 0) {
            JOptionPane.showMessageDialog(rootPane, "Debes ingresar un precio diario para la Habitaci\u00F3n Habitaci\u00F3n");
            cmbTipoCabina.requestFocus();
            return;
        }

        if (txtPrecio.getText().length() == 0) {
            JOptionPane.showMessageDialog(rootPane, "Debes ingresar una Precio para la Habitaci\u00F3n Habitaci\u00F3n");
            txtPrecio.requestFocus();
            return;
        }
        Modelo_Cabina dts = new Modelo_Cabina();
        Interfaz_Cabina func = new Interfaz_Cabina();

        dts.setId_cabina(cabina_di.getText());
        dts.setDescripcionCabina(txtNombreCabina.getText());
        dts.setEstado_cabina(estado_Cabina);

        dts.setPrecio(txtPrecio.getText());

        dts.setTipo_cabina(TipoCabina.getText());

        if (func.editar(dts)) {
            JOptionPane.showMessageDialog(rootPane, "La habitaci\u00F3n fue editada satisfactoriamente");
            mostrarCabina("");
        }
        limpiar();

    }//GEN-LAST:event_btnEditarActionPerformed

    private void mostrarCabina(String buscar) {
        try {
            DefaultTableModel modelo;
            Interfaz_Cabina func = new Interfaz_Cabina();
            modelo = func.mostrarCabina(buscar);
            tablaCabina.setModel(modelo);
            ocultar_columnas();
            lbltotalregistros.setText("Total Registros " + Integer.toString(func.totalRegistros));
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(rootPane, e);
        }
    }
    private void tablaCabinaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaCabinaMouseClicked
        // TODO add your handling code here:
        int fila = tablaCabina.getSelectedRow();
        cabina_di.setText(tablaCabina.getValueAt(fila, 0).toString());
        txtNombreCabina.setText(tablaCabina.getValueAt(fila, 1).toString());
        EstadoCabina.setText(tablaCabina.getValueAt(fila, 2).toString());
        cmbEstadoCabina.getModel().setSelectedItem(tablaCabina.getValueAt(fila, 2).toString());
        txtPrecio.setText(tablaCabina.getValueAt(fila, 3).toString());
        TipoCabina.setText(tablaCabina.getValueAt(fila, 4).toString());
        cmbTipoCabina.getModel().setSelectedItem(tablaCabina.getValueAt(fila, 4).toString());
        this.setSize(623, 445);
    }//GEN-LAST:event_tablaCabinaMouseClicked

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        this.setSize(623, 445);
    }//GEN-LAST:event_jButton7ActionPerformed

    private void cmbOcupadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbOcupadoActionPerformed
        // TODO add your handling code here:
        if (txtNombreCabina.getText().length() == 0) {
            JOptionPane.showMessageDialog(rootPane, "Debes ingresar un N\u00FAmero de Habitaci\u00F3n");
            txtNombreCabina.requestFocus();
            return;
        }
        if (estado_Cabina.length() == 0) {
            JOptionPane.showMessageDialog(rootPane, "Debes ingresar una descripci\u00F3n para la Habitaci\u00F3n Habitaci\u00F3n");
            cmbEstadoCabina.requestFocus();
            return;
        }

        if (TipoCabina.getText().length() == 0) {
            JOptionPane.showMessageDialog(rootPane, "Debes ingresar un precio diario para la Habitaci\u00F3n Habitaci\u00F3n");
            cmbTipoCabina.requestFocus();
            return;
        }

        if (txtPrecio.getText().length() == 0) {
            JOptionPane.showMessageDialog(rootPane, "Debes ingresar una Precio para la Habitaci\u00F3n Habitaci\u00F3n");
            txtPrecio.requestFocus();
            return;
        }
        Modelo_Cabina dts = new Modelo_Cabina();
        Interfaz_Cabina func = new Interfaz_Cabina();

        dts.setId_cabina(cabina_di.getText());
        func.ocupar(dts);
        JOptionPane.showMessageDialog(rootPane, "El estado actual de la cabina '" + txtNombreCabina.getText() + "' ahora es 'Ocupado'");
        mostrarCabina("");
    }//GEN-LAST:event_cmbOcupadoActionPerformed

    private void cmbLibreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbLibreActionPerformed
        // TODO add your handling code here:

        if (txtNombreCabina.getText().length() == 0) {
            JOptionPane.showMessageDialog(rootPane, "Debes ingresar un N\u00FAmero de Habitaci\u00F3n");
            txtNombreCabina.requestFocus();
            return;
        }
        if (estado_Cabina.length() == 0) {
            JOptionPane.showMessageDialog(rootPane, "Debes ingresar una descripci\u00F3n para la Habitaci\u00F3n Habitaci\u00F3n");
            cmbEstadoCabina.requestFocus();
            return;
        }

        if (TipoCabina.getText().length() == 0) {
            JOptionPane.showMessageDialog(rootPane, "Debes ingresar un precio diario para la Habitaci\u00F3n Habitaci\u00F3n");
            cmbTipoCabina.requestFocus();
            return;
        }

        if (txtPrecio.getText().length() == 0) {
            JOptionPane.showMessageDialog(rootPane, "Debes ingresar una Precio para la Habitaci\u00F3n Habitaci\u00F3n");
            txtPrecio.requestFocus();
            return;
        }

        Modelo_Cabina dts = new Modelo_Cabina();
        Interfaz_Cabina func = new Interfaz_Cabina();

        dts.setId_cabina(cabina_di.getText());
        func.desocupar(dts);
        JOptionPane.showMessageDialog(rootPane, "El estado actual de la cabina '" + txtNombreCabina.getText() + "' ahora es Libre");
        mostrarCabina("");
    }//GEN-LAST:event_cmbLibreActionPerformed

    private void Buscar_NombreCabinaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Buscar_NombreCabinaKeyPressed
        // TODO add your handling code here:
        mostrarCabina(Buscar_NombreCabina.getText());
    }//GEN-LAST:event_Buscar_NombreCabinaKeyPressed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Buscar_NombreCabina;
    private javax.swing.JLabel EstadoCabina;
    private javax.swing.JLabel TipoCabina;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JLabel cabina_di;
    private javax.swing.JComboBox<String> cmbEstadoCabina;
    private javax.swing.JRadioButton cmbLibre;
    private javax.swing.JRadioButton cmbOcupado;
    private javax.swing.JComboBox<String> cmbTipoCabina;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbltotalregistros;
    private javax.swing.JTable tablaCabina;
    private javax.swing.JTextField txtNombreCabina;
    private javax.swing.JFormattedTextField txtPrecio;
    // End of variables declaration//GEN-END:variables
}
