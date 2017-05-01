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
import modelo.contructor.Modelo_ClienteEmpresa;
import modelo.contructor.Modelo_Persona;
import modelo.formularios.Interfaz_ClienteEmpresa;
import modelo.formularios.Interfaz_Persona;
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
        //txtClasificación es no visible para la obtencion del id del tipo de persona.
        txtClasificación.setVisible(false);
        modeloTipo = new DefaultComboBoxModel();
        //Busca el ID del tipo de persona.
        TipoPersona();
        labelsInvisibles();
    }

    private void limpiar() {
        txtNombre_Apellidos.setText("");
        txtCedula.setText("");
        txtPhone.setText("");
        txtDireccion.setText("");
        txtCodigoCliente.setText("");
    }
    
    private void labelsInvisibles()
    {
        boolean valor = false;
        jLabel4.setVisible(valor);
        lbl_idCliente.setVisible(valor);
        nombreUsuario.setVisible(valor);
        lbl_id_persona.setVisible(valor);
        txtClasificación.setVisible(valor);
    }

    public void getNumeroCodigo() {
        String NuevoNumero;
        txtCodigoCliente.setText("");
        lbl_idCliente.setText("");
        Interfaz_Persona func = new Interfaz_Persona();
        NuevoNumero = func.getNumeroCodigo();
        txtCodigoCliente.setText(txtNombre_Apellidos.getText() + NuevoNumero);
    }

    private void TipoPersona() {

        String Clasificación;
        txtClasificación.setText("");
        Interfaz_Persona func = new Interfaz_Persona();
        Clasificación = func.SeleccionarCliente();
        txtClasificación.setText(Clasificación);

    }

    private void agregarPersona() {
        try {
            int P = JOptionPane.showConfirmDialog(null, " Quiere agregar otro dato ?", "Confirmaci\u00F3n", JOptionPane.YES_NO_OPTION);
            if (P == 1) {
                this.dispose();
                if (txtNombre_Apellidos.getText().equals("")) {
                    JOptionPane.showMessageDialog(this, "Favor ingresa el Nombre y Apellidos ", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                if (txtDireccion.getText().equals("")) {
                    JOptionPane.showMessageDialog(this, "Favor ingresa la Direccion", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                if (txtPhone.getText().equals("")) {
                    JOptionPane.showMessageDialog(this, "Favor ingresa el n\u00FAmero de Tel\u00E9fono o Celular ", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                if (txtClasificación.getText().equals("")) {
                    JOptionPane.showMessageDialog(this, "Favor ingresa la clasificaci\u00F3n de la persona ", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                if (txtCedula.getText().equals("")) {
                    JOptionPane.showMessageDialog(this, "Favor ingresa el n\u00FAmero de c\u00E9dula!", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                Statement stmt;
                stmt = con.createStatement();

                //Inicio de la Función para Agregar Persona
                Modelo_Persona dtsPersona = new Modelo_Persona();
                Interfaz_Persona func = new Interfaz_Persona();
                dtsPersona.setNombre(txtNombre_Apellidos.getText());
                dtsPersona.setCedula(txtCedula.getText());
                dtsPersona.setTelefono(txtPhone.getText());
                dtsPersona.setDireccion(txtDireccion.getText());
                dtsPersona.setTipo_persona_idtipo_persona(txtClasificación.getText());
                func.insertar(dtsPersona);
                //Fin Agregar Persona

                //Inicio de la Función para Agregar Cliente
                Modelo_ClienteEmpresa dtsClientes = new Modelo_ClienteEmpresa();
                Interfaz_ClienteEmpresa funcInterfaz_Clientes = new Interfaz_ClienteEmpresa();
                dtsClientes.setCodigo_cliente(txtCodigoCliente.getText());

                funcInterfaz_Clientes.insertarCliente(dtsClientes);
                //Fin Agregar Proveedor

                JOptionPane.showMessageDialog(this, "Guardado con Exito saved", "Cliente", JOptionPane.INFORMATION_MESSAGE);
                this.dispose();

            } else {
                limpiar();
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
        jLabel4 = new javax.swing.JLabel();
        nombreUsuario = new javax.swing.JLabel();
        direccion = new javax.swing.JLabel();
        telefono = new javax.swing.JLabel();
        txtDireccion = new javax.swing.JTextField();
        txtClasificación = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        nuevo = new javax.swing.JButton();
        guardar = new javax.swing.JButton();
        editar = new javax.swing.JButton();
        buscar = new javax.swing.JButton();
        lbl_idCliente = new javax.swing.JLabel();
        lbl_id_persona = new javax.swing.JLabel();
        nombreUsuario1 = new javax.swing.JLabel();
        txtCodigoCliente = new javax.swing.JTextField();
        txtPhone = new javax.swing.JFormattedTextField();
        txtCedula = new javax.swing.JFormattedTextField();
        jCheckBox1 = new javax.swing.JCheckBox();
        nombreApellidos = new javax.swing.JLabel();
        cedula = new javax.swing.JLabel();
        Persona = new javax.swing.JLabel();

        setClosable(true);
        setForeground(java.awt.Color.gray);
        setMaximizable(true);
        setResizable(true);
        setTitle("Agregar Cliente");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtNombre_Apellidos.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        txtNombre_Apellidos.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        getContentPane().add(txtNombre_Apellidos, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 360, 30));

        jLabel4.setFont(new java.awt.Font("Roboto Black", 1, 16)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(238, 238, 238));
        jLabel4.setText("CodigoCliente");
        jLabel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 340, 50, 30));

        nombreUsuario.setFont(new java.awt.Font("Roboto Black", 1, 16)); // NOI18N
        nombreUsuario.setForeground(new java.awt.Color(238, 238, 238));
        nombreUsuario.setText("CodigoClasificación");
        nombreUsuario.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(nombreUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 340, 110, 30));

        direccion.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        direccion.setForeground(java.awt.Color.darkGray);
        direccion.setText("Direccion");
        getContentPane().add(direccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, -1, -1));

        telefono.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        telefono.setForeground(java.awt.Color.darkGray);
        telefono.setText("Télefono o Celular");
        getContentPane().add(telefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 150, -1, -1));

        txtDireccion.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        txtDireccion.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        getContentPane().add(txtDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, 580, 30));

        txtClasificación.setEditable(false);
        txtClasificación.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        txtClasificación.setToolTipText("");
        txtClasificación.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(txtClasificación, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 380, 50, 30));

        nuevo.setBackground(new java.awt.Color(204, 204, 204));
        nuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/multiple_accounts.png"))); // NOI18N
        nuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nuevoActionPerformed(evt);
            }
        });

        guardar.setBackground(new java.awt.Color(204, 204, 204));
        guardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/save-icon-silhouette.png"))); // NOI18N
        guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarActionPerformed(evt);
            }
        });

        editar.setBackground(new java.awt.Color(204, 204, 204));
        editar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/edit.png"))); // NOI18N
        editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editarActionPerformed(evt);
            }
        });

        buscar.setBackground(new java.awt.Color(204, 204, 204));
        buscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/searching-magnifying-glass.png"))); // NOI18N
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
                .addContainerGap()
                .addComponent(nuevo)
                .addGap(18, 18, 18)
                .addComponent(guardar)
                .addGap(18, 18, 18)
                .addComponent(editar)
                .addGap(18, 18, 18)
                .addComponent(buscar)
                .addContainerGap(24, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(editar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(nuevo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(guardar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(buscar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 20, 330, 60));

        lbl_idCliente.setFont(new java.awt.Font("Modern No. 20", 1, 18)); // NOI18N
        lbl_idCliente.setForeground(new java.awt.Color(238, 238, 238));
        lbl_idCliente.setText("jLabel1");
        lbl_idCliente.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(lbl_idCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 340, 50, 30));

        lbl_id_persona.setFont(new java.awt.Font("Modern No. 20", 1, 18)); // NOI18N
        lbl_id_persona.setForeground(new java.awt.Color(238, 238, 238));
        lbl_id_persona.setText("lblIdPersona");
        lbl_id_persona.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(lbl_id_persona, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 380, 50, 30));

        nombreUsuario1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        nombreUsuario1.setForeground(java.awt.Color.darkGray);
        nombreUsuario1.setText("Código Usuario");
        getContentPane().add(nombreUsuario1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 280, -1, -1));

        txtCodigoCliente.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        txtCodigoCliente.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        getContentPane().add(txtCodigoCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 300, 580, 30));

        txtPhone.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        txtPhone.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtPhoneFocusLost(evt);
            }
        });
        getContentPane().add(txtPhone, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 170, 210, 30));

        txtCedula.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        txtCedula.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtCedulaFocusLost(evt);
            }
        });
        getContentPane().add(txtCedula, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, 270, 30));

        jCheckBox1.setText("Betar Cliente");
        getContentPane().add(jCheckBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 340, 160, 30));

        nombreApellidos.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        nombreApellidos.setForeground(java.awt.Color.darkGray);
        nombreApellidos.setText("Nombre y Apellidos");
        getContentPane().add(nombreApellidos, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, -1, -1));

        cedula.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        cedula.setForeground(java.awt.Color.darkGray);
        cedula.setText("Cedula");
        getContentPane().add(cedula, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, -1, -1));

        Persona.setFont(new java.awt.Font("Modern No. 20", 1, 18)); // NOI18N
        Persona.setForeground(java.awt.Color.darkGray);
        Persona.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/Market-Research.png"))); // NOI18N
        Persona.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(Persona, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 20, -1, 110));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void nuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nuevoActionPerformed
        // TODO add your handling code here:
        limpiar();

    }//GEN-LAST:event_nuevoActionPerformed

    private void guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarActionPerformed
        //Variable que almacena el tipo de persona

        agregarPersona();
    }//GEN-LAST:event_guardarActionPerformed

    private void editarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editarActionPerformed
        // TODO add your handling code here:

        try {
            int P = JOptionPane.showConfirmDialog(null, " Quiere editar este dato ?", "Confirmaci\u00F3n", JOptionPane.YES_NO_OPTION);
            if (P == 0) {

                Statement stmt;
                stmt = con.createStatement();

                String Pru = "UPDATE `persona` SET `nombre` = '" + txtNombre_Apellidos.getText() + "',`cedula` = '" + txtCedula.getText() + "', `telefono` = '" + txtPhone.getText() + "',`direccion`='" + txtPhone.getText() + "',`tipo_persona_idtipo_persona`='" + txtClasificación.getText() + "' WHERE `idpersona`='" + lbl_idCliente.getText() + "'";
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
        Frm_BusquedaAgregarClientes form;
        form = new Frm_BusquedaAgregarClientes();
        escritorio.add(form);
        form.toFront();
        form.setVisible(true);
    }//GEN-LAST:event_buscarActionPerformed

    private void txtPhoneFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPhoneFocusLost
        // TODO add your handling code here:
        getNumeroCodigo();
    }//GEN-LAST:event_txtPhoneFocusLost

    private void txtCedulaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCedulaFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCedulaFocusLost

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Persona;
    private javax.swing.JButton buscar;
    private javax.swing.JLabel cedula;
    private javax.swing.JLabel direccion;
    private javax.swing.JButton editar;
    private javax.swing.JButton guardar;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    public static javax.swing.JLabel lbl_idCliente;
    public static javax.swing.JLabel lbl_id_persona;
    private javax.swing.JLabel nombreApellidos;
    public static javax.swing.JLabel nombreUsuario;
    public static javax.swing.JLabel nombreUsuario1;
    private javax.swing.JButton nuevo;
    private javax.swing.JLabel telefono;
    public static javax.swing.JFormattedTextField txtCedula;
    private javax.swing.JTextField txtClasificación;
    public static javax.swing.JTextField txtCodigoCliente;
    public static javax.swing.JTextField txtDireccion;
    public static javax.swing.JTextField txtNombre_Apellidos;
    public static javax.swing.JFormattedTextField txtPhone;
    // End of variables declaration//GEN-END:variables
}
