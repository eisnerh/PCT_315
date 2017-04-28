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
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import modelo.contructor.Modelo_ClienteEmpresa;
import modelo.contructor.Modelo_Usuario;
import modelo.formularios.Interfaz_ClienteEmpresa;
import modelo.formularios.Interfaz_Usuario;
import static vista.Frm_Agregar_Usuario.idColaborador;
import static vista.Frm_Inicio.escritorio;

/**
 *
 * @author Eisner López Acevedo <eisner.lopez at gmail.com>
 * @author Cesar Gonzalez Salas <cgonzalez816 at gmail.com>
 */
public class Frm_Agregar_Cliente extends javax.swing.JInternalFrame {

    /**
     * Creates new form Personas_frm
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
    
    private String id_Persona;

    //declarar static e instanciarla en tu contructor`
    static DefaultComboBoxModel modeloTipo;
    
    public Frm_Agregar_Cliente() {
        initComponents();
        con = dbConnection.getConnection();
        sqlSelect = "SELECT `idpersona`, `nombre`, `cedula`, `telefono`, `direccion`, `tipo_persona_idtipo_persona` FROM `persona` order BY `nombre`";
        sqlSelect_Valor = "SELECT `idpersona`, `nombre`, `cedula`, `telefono`, `direccion`, `tipo_persona_idtipo_persona` FROM `persona` WHERE `nombre` = '";
        sqlInsert = "INSERT INTO `persona`(`nombre`, `cedula`, `telefono`, `direccion`, `tipo_persona_idtipo_persona`) VALUES ('";
        sqlDelete = "DELETE FROM `persona` WHERE `idpersona` = ";
        //txtClasificación es no visible para la obtencion del id del tipo de persona.
        txtClasificación.setVisible(false);
        modeloTipo = new DefaultComboBoxModel();
        llena_combo(); // llenar los datos al ejecutar el programa
        //Busca el ID del tipo de persona.
        TipoPersona();
    }
    
    public void getNumeroCodigo() {
        try {
            txtCodigoCliente.setText("");
            lbl_idPersona.setText("");
            Statement stmt;
            stmt = con.createStatement();
            String queryCuentaCliente = "SELECT max(idpersona) as numeroPersona FROM pct3.persona;";
            rs = stmt.executeQuery(queryCuentaCliente);
            while (rs.next()) {
                int numero = rs.getInt("numeroPersona");
                lbl_idPersona.setText(Integer.toString(numero + 1));
            }
            txtCodigoCliente.setText(txtNombre_Apellidos.getText() + lbl_idPersona.getText());
            cmbTipoPersona.setModel(modeloTipo); // seteamos el modelo y se cargan los datos
        } catch (HeadlessException | SQLException ex) {
            JOptionPane.showMessageDialog(this, ex);
        }
    }

    //Llena el JComboBox con los datos almacenados en la BD para Tipo Persona
    //Inicio del Metodo Llena_Combo
    public final void llena_combo() { // static para poder llamarlo desde el otro frame o JDialog
        try {
            modeloTipo.removeAllElements(); // eliminamos lo elementos
            Statement stmt;
            stmt = con.createStatement();
            String queryComboEstado = "SELECT `desc_persona` FROM `tipo_persona`";
            rs = stmt.executeQuery(queryComboEstado);
            while (rs.next()) {
                modeloTipo.addElement(rs.getString("desc_persona"));
                //Se consulta si el tipo de persona corresponde al valor predefinido
                if (rs.getString("desc_persona").equals("Cliente")) {
                    modeloTipo.setSelectedItem(rs.getString("desc_persona"));
                }
            }
            cmbTipoPersona.setModel(modeloTipo); // seteamos el modelo y se cargan los datos
        } catch (HeadlessException | SQLException ex) {
            JOptionPane.showMessageDialog(this, ex);
        }
    }
    //Inicio del Metodo Tipo Persona

    private void TipoPersona() {
        try {
            String sqlConsulta_TPersona = "SELECT "
                    + "`idtipo_persona`, "
                    + "`desc_persona` "
                    + "FROM "
                    + "`tipo_persona` "
                    + "WHERE `desc_persona` = '" + cmbTipoPersona.getSelectedItem() + "'";
            pst = con.prepareStatement(sqlConsulta_TPersona);
            rs = pst.executeQuery();
            if (rs.next()) {
                String add1 = rs.getString("idtipo_persona");
                txtClasificación.setText(add1);
            }
            
        } catch (SQLException | HeadlessException e) {
            JOptionPane.showMessageDialog(null, e);
            
        }
    }
    
    private void initState() {
        txtNombre_Apellidos.setEnabled(false);
        txtDireccion.setEnabled(false);
        txtPhone.setEnabled(false);
        txtClasificación.setEnabled(false);
        txtCedula.setEnabled(false);
        cmbTipoPersona.setEnabled(false);
        lbl_idPersona.setText("");
        txtNombre_Apellidos.setText("");
        nuevo.setEnabled(true);
        guardar.setEnabled(false);
        buscar.setEnabled(true);
        editar.setEnabled(false);

        
    }
    
    private void agregarPersona() {
        try {
            int P = JOptionPane.showConfirmDialog(null, " Quiere agregar otro dato ?", "Confirmación", JOptionPane.YES_NO_OPTION);
            if (P == 0) {
                if (txtNombre_Apellidos.getText().equals("")) {
                    JOptionPane.showMessageDialog(this, "Favor ingresa el Nombre y Apellidos ", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                if (txtDireccion.getText().equals("")) {
                    JOptionPane.showMessageDialog(this, "Favor ingresa la Direccion", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                if (txtPhone.getText().equals("")) {
                    JOptionPane.showMessageDialog(this, "Favor ingresa el número de Teléfono o Celular ", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                if (txtClasificación.getText().equals("")) {
                    JOptionPane.showMessageDialog(this, "Favor ingresa la clasificación de la persona ", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                if (txtCedula.getText().equals("")) {
                    JOptionPane.showMessageDialog(this, "Favor ingresa el número de cédula!", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                
                Statement stmt;
                stmt = con.createStatement();
                
            }
            if (P == 0 || P == 1) {
                String sql = sqlInsert + txtNombre_Apellidos.getText() + "','" + txtCedula.getText() + "','" + txtPhone.getText() + "','" + txtDireccion.getText() + "','" + txtClasificación.getText() + "')";
                String sql2 = "INSERT INTO `pct3`.`cliente_empresa` "
                        + "(`empresa_id`, "
                        + "`codigo_cliente`, "
                        + "`estado_cliente`, "
                        + "`persona_idpersona`) "
                        + "VALUES "
                        + "(null, "
                        + "'" + txtCodigoCliente.getText() + "', "
                        + "0 ,"
                        + "(SELECT max(idpersona) FROM pct3.persona))";
                pst = con.prepareStatement(sql);
                pst.execute();
                int in = JOptionPane.showConfirmDialog(this, "Guardado con Exito saved", "Gasto Operativo", JOptionPane.YES_OPTION);
                if (in == 0) {
                    pst = con.prepareStatement(sql2);
                    pst.execute();
                }
                
            }
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

        txtNombre_Apellidos = new javax.swing.JTextField();
        cedula = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        nombreUsuario = new javax.swing.JLabel();
        direccion = new javax.swing.JLabel();
        telefono = new javax.swing.JLabel();
        txtDireccion = new javax.swing.JTextField();
        cmbTipoPersona = new javax.swing.JComboBox<>();
        txtClasificación = new javax.swing.JTextField();
        nombreApellidos = new javax.swing.JLabel();
        clasificación = new javax.swing.JLabel();
        Persona = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        nuevo = new javax.swing.JButton();
        guardar = new javax.swing.JButton();
        editar = new javax.swing.JButton();
        buscar = new javax.swing.JButton();
        lbl_idPersona = new javax.swing.JLabel();
        lbl_id_persona = new javax.swing.JLabel();
        nombreUsuario1 = new javax.swing.JLabel();
        txtCodigoCliente = new javax.swing.JTextField();
        txtCedula = new javax.swing.JFormattedTextField();
        txtPhone = new javax.swing.JFormattedTextField();

        setClosable(true);
        setForeground(java.awt.Color.gray);
        setMaximizable(true);
        setResizable(true);
        setTitle("Agregar Cliente");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtNombre_Apellidos.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        txtNombre_Apellidos.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        getContentPane().add(txtNombre_Apellidos, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 360, 40));

        cedula.setFont(new java.awt.Font("Modern No. 20", 1, 18)); // NOI18N
        cedula.setForeground(java.awt.Color.darkGray);
        cedula.setText("Cedula");
        getContentPane().add(cedula, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 82, -1, -1));

        jLabel4.setFont(new java.awt.Font("Roboto Black", 1, 16)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(238, 238, 238));
        jLabel4.setText("CodigoCliente");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(7, 343, -1, -1));

        nombreUsuario.setFont(new java.awt.Font("Roboto Black", 1, 16)); // NOI18N
        nombreUsuario.setForeground(new java.awt.Color(238, 238, 238));
        nombreUsuario.setText("CodigoClasificación");
        getContentPane().add(nombreUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(161, 343, -1, -1));

        direccion.setFont(new java.awt.Font("Modern No. 20", 1, 18)); // NOI18N
        direccion.setForeground(java.awt.Color.darkGray);
        direccion.setText("Direccion");
        getContentPane().add(direccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 172, -1, -1));

        telefono.setFont(new java.awt.Font("Modern No. 20", 1, 18)); // NOI18N
        telefono.setForeground(java.awt.Color.darkGray);
        telefono.setText("Télefono o Celular");
        getContentPane().add(telefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, -1, -1));

        txtDireccion.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        txtDireccion.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        getContentPane().add(txtDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 190, 440, 40));

        cmbTipoPersona.setFont(new java.awt.Font("Dialog", 1, 16));
        cmbTipoPersona.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbTipoPersona.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        cmbTipoPersona.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbTipoPersonaActionPerformed(evt);
            }
        });
        getContentPane().add(cmbTipoPersona, new org.netbeans.lib.awtextra.AbsoluteConstraints(7, 291, 200, 40));

        txtClasificación.setEditable(false);
        txtClasificación.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        txtClasificación.setToolTipText("");
        txtClasificación.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        getContentPane().add(txtClasificación, new org.netbeans.lib.awtextra.AbsoluteConstraints(219, 290, 20, 40));

        nombreApellidos.setFont(new java.awt.Font("Modern No. 20", 1, 18)); // NOI18N
        nombreApellidos.setForeground(java.awt.Color.darkGray);
        nombreApellidos.setText("Nombre y Apellidos");
        getContentPane().add(nombreApellidos, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 82, -1, -1));

        clasificación.setFont(new java.awt.Font("Modern No. 20", 1, 18)); // NOI18N
        clasificación.setForeground(java.awt.Color.darkGray);
        clasificación.setText("Clasificación");
        getContentPane().add(clasificación, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, -1, -1));

        Persona.setFont(new java.awt.Font("Modern No. 20", 1, 18)); // NOI18N
        Persona.setForeground(java.awt.Color.darkGray);
        Persona.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Market-Research.png"))); // NOI18N
        getContentPane().add(Persona, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 270, 130, 110));

        nuevo.setBackground(new java.awt.Color(204, 204, 204));
        nuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/CRUD/multiple_accounts.png"))); // NOI18N
        nuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nuevoActionPerformed(evt);
            }
        });

        guardar.setBackground(new java.awt.Color(204, 204, 204));
        guardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/CRUD/document_save.png"))); // NOI18N
        guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarActionPerformed(evt);
            }
        });

        editar.setBackground(new java.awt.Color(204, 204, 204));
        editar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/CRUD/edit.png"))); // NOI18N
        editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editarActionPerformed(evt);
            }
        });

        buscar.setBackground(new java.awt.Color(204, 204, 204));
        buscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/CRUD/searching-magnifying-glass.png"))); // NOI18N
        buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(92, 92, 92)
                .addComponent(nuevo)
                .addGap(18, 18, 18)
                .addComponent(guardar)
                .addGap(18, 18, 18)
                .addComponent(editar)
                .addGap(18, 18, 18)
                .addComponent(buscar)
                .addContainerGap(229, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(editar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(nuevo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(guardar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 700, -1));

        lbl_idPersona.setFont(new java.awt.Font("Modern No. 20", 1, 18)); // NOI18N
        lbl_idPersona.setForeground(new java.awt.Color(238, 238, 238));
        lbl_idPersona.setText("jLabel1");
        getContentPane().add(lbl_idPersona, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 370, -1, -1));

        lbl_id_persona.setFont(new java.awt.Font("Modern No. 20", 1, 18)); // NOI18N
        lbl_id_persona.setForeground(new java.awt.Color(238, 238, 238));
        lbl_id_persona.setText("lblIdPersona");
        getContentPane().add(lbl_id_persona, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 370, -1, -1));

        nombreUsuario1.setFont(new java.awt.Font("Roboto Black", 1, 16)); // NOI18N
        nombreUsuario1.setForeground(java.awt.Color.darkGray);
        nombreUsuario1.setText("Código Usuario");
        getContentPane().add(nombreUsuario1, new org.netbeans.lib.awtextra.AbsoluteConstraints(262, 251, -1, -1));

        txtCodigoCliente.setEditable(false);
        txtCodigoCliente.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        txtCodigoCliente.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        getContentPane().add(txtCodigoCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(262, 290, 200, 40));

        txtCedula.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        txtCedula.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtCedulaFocusLost(evt);
            }
        });
        getContentPane().add(txtCedula, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 100, 270, 40));

        txtPhone.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        getContentPane().add(txtPhone, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, 240, 40));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmbTipoPersonaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbTipoPersonaActionPerformed
        TipoPersona();
    }//GEN-LAST:event_cmbTipoPersonaActionPerformed

    private void nuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nuevoActionPerformed
        // TODO add your handling code here:
        txtNombre_Apellidos.setEnabled(true);
        txtDireccion.setEnabled(true);
        txtPhone.setEnabled(true);
        txtClasificación.setEnabled(true);
        txtCedula.setEnabled(true);
        cmbTipoPersona.setEnabled(true);
        lbl_idPersona.setText("");
        txtNombre_Apellidos.setText("");
        txtPhone.setText("");
        txtClasificación.setText("");
        txtPhone.setText("");
        txtNombre_Apellidos.requestDefaultFocus();
        nuevo.setEnabled(false);
        guardar.setEnabled(true);
        buscar.setEnabled(false);
        editar.setEnabled(false);

    }//GEN-LAST:event_nuevoActionPerformed

    private void guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarActionPerformed
        //Variable que almacena el tipo de persona
        String tipoPersonaSeleccionada;
        tipoPersonaSeleccionada = (String) cmbTipoPersona.getSelectedItem();
        //Se consulta si es Empleado o Proveedor, si son diferentes abren el form correspondiente
        switch (tipoPersonaSeleccionada) {
            case "Empleado":
                this.dispose();
                JOptionPane.showMessageDialog(this, "Abriremos el Formulario para agregar Colaborador");
                Frm_Agregar_Colaborador agregarColaborador = new Frm_Agregar_Colaborador();
                escritorio.add(agregarColaborador);
                agregarColaborador.toFront();
                agregarColaborador.setVisible(true);
                break;
            case "Proveedor":
                this.dispose();
                JOptionPane.showMessageDialog(this, "Abriremos el Formulario para agregar Proveedores");
                Frm_Agregar_Proveedor agregar_Proveedor = new Frm_Agregar_Proveedor();
                escritorio.add(agregar_Proveedor);
                agregar_Proveedor.toFront();
                agregar_Proveedor.setVisible(true);
                break;
            default:
                agregarPersona();
                break;
        }
    }//GEN-LAST:event_guardarActionPerformed

    private void editarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editarActionPerformed
        // TODO add your handling code here:

        try {
            int P = JOptionPane.showConfirmDialog(null, " Quiere editar este dato ?", "Confirmación", JOptionPane.YES_NO_OPTION);
            if (P == 0) {
                
                Statement stmt;
                stmt = con.createStatement();
                
                String Pru = "UPDATE `persona` SET `nombre` = '" + txtNombre_Apellidos.getText() + "',`cedula` = '" + txtCedula.getText() + "', `telefono` = '" + txtPhone.getText() + "',`direccion`='" + txtPhone.getText() + "',`tipo_persona_idtipo_persona`='" + txtClasificación.getText() + "' WHERE `idpersona`='" + lbl_idPersona.getText() + "'";
                pst = con.prepareStatement(Pru);
                pst.execute();
                JOptionPane.showMessageDialog(this, "Guardado con Exito saved", "Tipo de Usuario", JOptionPane.INFORMATION_MESSAGE);
                txtNombre_Apellidos.setText("");
                
                if (P == 1) {
                    txtNombre_Apellidos.setText("");
                    
                }
            }
            
        } catch (HeadlessException | SQLException ex) {
            JOptionPane.showMessageDialog(this, ex);
            
        }
    }//GEN-LAST:event_editarActionPerformed

    private void buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarActionPerformed
        // TODO add your handling code here:
        Frm_BusquedaClientes form;
        form = new Frm_BusquedaClientes();
        escritorio.add(form);
        form.toFront();
        form.setVisible(true);
    }//GEN-LAST:event_buscarActionPerformed

    private void txtCedulaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCedulaFocusLost
        // TODO add your handling code here:
        String querySQL = "SELECT "
                + "MAX(empresa_id) + 1 AS nuevo "
                + "FROM "
                + "pct3.cliente_empresa";
        try {
            Statement st = con.createStatement();
            rs = st.executeQuery(querySQL);
            while (rs.next()) {
                String add1 = rs.getString(1);
                txtCodigoCliente.setText(txtNombre_Apellidos.getText() + add1);
            }
        } catch (SQLException e) {
            JOptionPane.showConfirmDialog(rootPane, e);
        }
    }//GEN-LAST:event_txtCedulaFocusLost


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Persona;
    private javax.swing.JButton buscar;
    private javax.swing.JLabel cedula;
    private javax.swing.JLabel clasificación;
    private javax.swing.JComboBox<String> cmbTipoPersona;
    private javax.swing.JLabel direccion;
    private javax.swing.JButton editar;
    private javax.swing.JButton guardar;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lbl_idPersona;
    private javax.swing.JLabel lbl_id_persona;
    private javax.swing.JLabel nombreApellidos;
    public static javax.swing.JLabel nombreUsuario;
    public static javax.swing.JLabel nombreUsuario1;
    private javax.swing.JButton nuevo;
    private javax.swing.JLabel telefono;
    private javax.swing.JFormattedTextField txtCedula;
    private javax.swing.JTextField txtClasificación;
    private javax.swing.JTextField txtCodigoCliente;
    private javax.swing.JTextField txtDireccion;
    public static javax.swing.JTextField txtNombre_Apellidos;
    private javax.swing.JFormattedTextField txtPhone;
    // End of variables declaration//GEN-END:variables
}
