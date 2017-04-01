/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.ConexionDB;
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
import modelo.contructor.mCabina;
import modelo.formularios.fCabina;

/**
 *
 * @author Eisner López Acevedo <eisner.lopez at gmail.com>
 * @author Cesar Gonzalez Salas <cgonzalez816 at gmail.com>
 */
public final class Agregar_Cabina extends javax.swing.JInternalFrame {

    /**
     * Creates new form Agregar_Cabina
     */
    Connection connection = ConexionDB.conexionDB();
    ResultSet rs = null;
    PreparedStatement pst = null;
    ResultSet rs2 = null;
    PreparedStatement pst2 = null;

    private String id_Persona;
    private String estado_Cabina;
    static DefaultComboBoxModel modeloEstado = new DefaultComboBoxModel();
    static DefaultComboBoxModel modeloTipo = new DefaultComboBoxModel();
    public Agregar_Cabina() {
        initComponents();
        cabina_di.setVisible(false);
        
        this.setSize(623, 445);
        comboEstado();
        comboTipoCabina();
        //Se asigna el valor del combo a una variable fija llamada estado_Cabina
        estado_Cabina = estadoCabina.getSelectedItem().toString();
        EstadoCabina.setText(estadoCabina.getSelectedItem().toString());
        TipoCabina.setText(tipoCabina.getSelectedItem().toString());
        
        Get_Data();
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
            }
            tipoCabina.setModel(modeloTipo); // seteamos el modelo y se cargan los datos

        } catch (HeadlessException | SQLException ex) {
            JOptionPane.showMessageDialog(this, ex);
        }
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
            }

            estadoCabina.setModel(modeloEstado); // seteamos el modelo y se cargan los datos

        } catch (HeadlessException | SQLException ex) {
            JOptionPane.showMessageDialog(this, ex);
        }
    }

    public void mostrar(String buscar) {
        try {
            DefaultTableModel modelo;
            fCabina func = new fCabina();
            modelo = func.mostrarCabina(buscar);

            tablaCabina.setModel(modelo);
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(rootPane, e);
        }
    }

    private void Get_Data() {
        //Select sobre el estatus_empleado y se le asigna el valor a la columna de la tabla del formulario.

        String sql = "SELECT * FROM `cabina` ORDER BY `estado_cabina`";
        DefaultTableModel tableModel;
        //creación de un array para definir las columnas
        String[] columnas = {"descripcion_cabina", "estado_cabina", "precio", "tipo_cabina"};
        //creación de un array para definir los registros que se incluiran por medio del codigo
        String[] registro = new String[4];

        tableModel = new DefaultTableModel(null, columnas);
        try {
            pst = connection.prepareStatement(sql);

            rs = pst.executeQuery();

            while (rs.next()) {
                registro[0] = rs.getString("descripcion_cabina");
                registro[1] = rs.getString("estado_cabina");
                registro[2] = rs.getString("precio");
                registro[3] = rs.getString("tipo_cabina");
                tableModel.addRow(registro);
            }

            tablaCabina.setModel(tableModel);

        } catch (SQLException e) {
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
        estadoCabina = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        tipoCabina = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        txtPrecio = new javax.swing.JFormattedTextField();
        jPanel1 = new javax.swing.JPanel();
        Salir = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnNuevo = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnVolver = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaCabina = new javax.swing.JTable();
        jButton7 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        Buscar_NombreCabina = new javax.swing.JTextField();
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

        estadoCabina.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        estadoCabina.setSelectedIndex(-1);
        estadoCabina.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                estadoCabinaActionPerformed(evt);
            }
        });
        jPanel2.add(estadoCabina);

        jLabel5.setFont(new java.awt.Font("Dialog", 3, 16)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Tipo Cabina");
        jPanel2.add(jLabel5);

        tipoCabina.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        tipoCabina.setSelectedIndex(-1);
        tipoCabina.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tipoCabinaActionPerformed(evt);
            }
        });
        jPanel2.add(tipoCabina);

        jLabel4.setFont(new java.awt.Font("Dialog", 3, 16)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Precio");
        jPanel2.add(jLabel4);

        txtPrecio.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("###0.###"))));
        txtPrecio.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jPanel2.add(txtPrecio);

        jPanel1.setLayout(new java.awt.GridLayout(1, 5, 1, 1));

        Salir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/Salir.png"))); // NOI18N
        Salir.setText("Salir");
        Salir.setToolTipText("Nueva Cabina");
        Salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SalirActionPerformed(evt);
            }
        });
        jPanel1.add(Salir);

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

        btnVolver.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/Salir.png"))); // NOI18N
        btnVolver.setToolTipText("Eliminar Cabina");
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });
        jPanel1.add(btnVolver);

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

        Buscar_NombreCabina.setFont(new java.awt.Font("Hack", 1, 14)); // NOI18N
        Buscar_NombreCabina.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Buscar_NombreCabinaActionPerformed(evt);
            }
        });
        Buscar_NombreCabina.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                Buscar_NombreCabinaKeyReleased(evt);
            }
        });

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
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE))
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

    private void cmbLibreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbLibreActionPerformed
        // TODO add your handling code here:

        if (txtNombreCabina.getText().length() == 0) {
            JOptionPane.showMessageDialog(rootPane, "Debes ingresar un Número de Habitación");
            txtNombreCabina.requestFocus();
            return;
        }
        if(estado_Cabina.length() == 0)
        {
            JOptionPane.showMessageDialog(rootPane, "Debes ingresar una descripción para la Habitación Habitación");
            estadoCabina.requestFocus();
            return;
        }

        if (TipoCabina.getText().length() == 0) {
            JOptionPane.showMessageDialog(rootPane, "Debes ingresar un precio diario para la Habitación Habitación");
            tipoCabina.requestFocus();
            return;
        }

        if (txtPrecio.getText().length() == 0) {
            JOptionPane.showMessageDialog(rootPane, "Debes ingresar una Precio para la Habitación Habitación");
            txtPrecio.requestFocus();
            return;
        }

        mCabina dts = new mCabina();
        fCabina func = new fCabina();

        dts.setId_cabina(cabina_di.getText());
        func.desocupar(dts);
        JOptionPane.showMessageDialog(rootPane, "El estado actual de la cabina '" + txtNombreCabina.getText() + "' ahora es Libre");
        mostrar("");
    }//GEN-LAST:event_cmbLibreActionPerformed

    private void cmbOcupadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbOcupadoActionPerformed
        // TODO add your handling code here:
        if (txtNombreCabina.getText().length() == 0) {
            JOptionPane.showMessageDialog(rootPane, "Debes ingresar un Número de Habitación");
            txtNombreCabina.requestFocus();
            return;
        }
        if (estado_Cabina.length() == 0) {
            JOptionPane.showMessageDialog(rootPane, "Debes ingresar una descripción para la Habitación Habitación");
            estadoCabina.requestFocus();
            return;
        }

        if (TipoCabina.getText().length() == 0) {
            JOptionPane.showMessageDialog(rootPane, "Debes ingresar un precio diario para la Habitación Habitación");
            tipoCabina.requestFocus();
            return;
        }

        if (txtPrecio.getText().length() == 0) {
            JOptionPane.showMessageDialog(rootPane, "Debes ingresar una Precio para la Habitación Habitación");
            txtPrecio.requestFocus();
            return;
        }
        mCabina dts = new mCabina();
        fCabina func = new fCabina();

        dts.setId_cabina(cabina_di.getText());
        func.ocupar(dts);
        JOptionPane.showMessageDialog(rootPane, "El estado actual de la cabina '" + txtNombreCabina.getText() + "' ahora es 'Ocupado'");
        mostrar("");
    }//GEN-LAST:event_cmbOcupadoActionPerformed

    private void estadoCabinaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_estadoCabinaActionPerformed
        // TODO add your handling code here:
        estado_Cabina = (estadoCabina.getSelectedItem().toString());
    }//GEN-LAST:event_estadoCabinaActionPerformed

    private void tipoCabinaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tipoCabinaActionPerformed
        // TODO add your handling code here:
        try {
            // TODO add your handling code here:
            //TipoCabina.setText(tipoCabina.getSelectedItem().toString());
            Statement stmt;
            stmt = connection.createStatement();
            String queryComboEstado = "SELECT DISTINCT tipo_cabina as tipoCabina, precio FROM pct3.cabina AS cabina WHERE tipo_cabina = '"+ tipoCabina.getSelectedItem().toString() +"' ORDER BY tipo_cabina ASC";
            rs = stmt.executeQuery(queryComboEstado);
            while (rs.next()) {
                String add1 = rs.getString("tipoCabina");
                String add2 = rs.getString("precio");
                
                txtPrecio.setText(add2);
                TipoCabina.setText(add1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AgregarCabina_frm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_tipoCabinaActionPerformed

    private void SalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SalirActionPerformed
        this.dispose();
    }//GEN-LAST:event_SalirActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        if (txtNombreCabina.getText().length() == 0) {
            JOptionPane.showMessageDialog(rootPane, "Debes ingresar un Número de Habitación");
            txtNombreCabina.requestFocus();
            return;
        }
        if (estado_Cabina.length() == 0) {
            JOptionPane.showMessageDialog(rootPane, "Debes ingresar una descripción para la Habitación Habitación");
            estadoCabina.requestFocus();
            return;
        }

        if (TipoCabina.getText().length() == 0) {
            JOptionPane.showMessageDialog(rootPane, "Debes ingresar un precio diario para la Habitación Habitación");
            tipoCabina.requestFocus();
            return;
        }

        if (txtPrecio.getText().length() == 0) {
            JOptionPane.showMessageDialog(rootPane, "Debes ingresar una Precio para la Habitación Habitación");
            txtPrecio.requestFocus();
            return;
        }

        mCabina dts = new mCabina();
        fCabina func = new fCabina();

        dts.setId_cabina(null);

        dts.setDescripcionCabina(txtNombreCabina.getText());
        dts.setEstado_cabina(estado_Cabina);

        dts.setPrecio(txtPrecio.getText());

        dts.setTipo_cabina(TipoCabina.getText());

        if (func.insertar(dts)) {
            JOptionPane.showMessageDialog(rootPane, "La habitación fue registrada satisfactoriamente");
            mostrar("");
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        // TODO add your handling code here:
        this.setSize(1095, 447);
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        // TODO add your handling code here:
        if (txtNombreCabina.getText().length() == 0) {
            JOptionPane.showMessageDialog(rootPane, "Debes ingresar un Número de Habitación");
            txtNombreCabina.requestFocus();
            return;
        }
        if (estado_Cabina.length() == 0) {
            JOptionPane.showMessageDialog(rootPane, "Debes ingresar una descripción para la Habitación Habitación");
            estadoCabina.requestFocus();
            return;
        }

        if (TipoCabina.getText().length() == 0) {
            JOptionPane.showMessageDialog(rootPane, "Debes ingresar un precio diario para la Habitación Habitación");
            tipoCabina.requestFocus();
            return;
        }

        if (txtPrecio.getText().length() == 0) {
            JOptionPane.showMessageDialog(rootPane, "Debes ingresar una Precio para la Habitación Habitación");
            txtPrecio.requestFocus();
            return;
        }
        mCabina dts = new mCabina();
        fCabina func = new fCabina();

        dts.setId_cabina(null);

        dts.setDescripcionCabina(txtNombreCabina.getText());
        dts.setEstado_cabina(estado_Cabina);

        dts.setPrecio(txtPrecio.getText());

        dts.setTipo_cabina(TipoCabina.getText());

        if (func.editar(dts)) {
            JOptionPane.showMessageDialog(rootPane, "La habitación fue editada satisfactoriamente");
            mostrar("");
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void tablaCabinaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaCabinaMouseClicked
        // TODO add your handling code here:
        try {
            connection = ConexionDB.conexionDB();
            int row = tablaCabina.getSelectedRow();
            String tabla_click = tablaCabina.getModel().getValueAt(row, 0).toString();
            String sql = "SELECT * FROM `cabina` WHERE `descripcion_cabina` = '" + tabla_click + "'";
            pst = connection.prepareStatement(sql);
            rs = pst.executeQuery();
            if (rs.next()) {
                String registro1 = rs.getString("cabina_id");
                cabina_di.setText(registro1);
                String registro2 = rs.getString("descripcion_cabina");
                txtNombreCabina.setText(registro2);
                String registro3 = rs.getString("estado_cabina");
                estado_Cabina = (registro3);
                estadoCabina.getModel().setSelectedItem(registro3);
                String registro4 = rs.getString("precio");
                txtPrecio.setText(registro4);
                String registro5 = rs.getString("tipo_cabina");
                TipoCabina.setText(registro5);
                tipoCabina.getModel().setSelectedItem(registro5);
                this.setSize(623, 445);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, ex);
        }
    }//GEN-LAST:event_tablaCabinaMouseClicked

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        this.setSize(623, 445);
    }//GEN-LAST:event_jButton7ActionPerformed

    private void Buscar_NombreCabinaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Buscar_NombreCabinaActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_Buscar_NombreCabinaActionPerformed

    private void Buscar_NombreCabinaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Buscar_NombreCabinaKeyReleased
        // TODO add your handling code here:
        try {

            String sql_persona = "SELECT * FROM `cabina` WHERE `descripcion_cabina` LIKE '%" + Buscar_NombreCabina.getText() + "%'";
            pst = connection.prepareStatement(sql_persona);
            rs = pst.executeQuery();
            if (rs.next()) {
                String registro1 = rs.getString("cabina_id");
                cabina_di.setText(registro1);
                String registro2 = rs.getString("descripcion_cabina");
                txtNombreCabina.setText(registro2);
                String registro3 = rs.getString("estado_cabina");
                estado_Cabina = (registro3);
                estadoCabina.getModel().setSelectedItem(registro3);
                String registro4 = rs.getString("precio");
                txtPrecio.setText(registro4);
                String registro5 = rs.getString("tipo_cabina");
                TipoCabina.setText(registro5);
                tipoCabina.getModel().setSelectedItem(registro5);

            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);

        }
    }//GEN-LAST:event_Buscar_NombreCabinaKeyReleased

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_btnVolverActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Buscar_NombreCabina;
    private javax.swing.JLabel EstadoCabina;
    private javax.swing.JButton Salir;
    private javax.swing.JLabel TipoCabina;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JButton btnVolver;
    private javax.swing.JLabel cabina_di;
    private javax.swing.JRadioButton cmbLibre;
    private javax.swing.JRadioButton cmbOcupado;
    private javax.swing.JComboBox<String> estadoCabina;
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
    private javax.swing.JTable tablaCabina;
    private javax.swing.JComboBox<String> tipoCabina;
    private javax.swing.JTextField txtNombreCabina;
    private javax.swing.JFormattedTextField txtPrecio;
    // End of variables declaration//GEN-END:variables
}
