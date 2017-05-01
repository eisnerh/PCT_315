/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.dbConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import modelo.contructor.Modelo_Persona;
import modelo.contructor.Modelo_Proveedor;
import modelo.formularios.Interfaz_Persona;
import modelo.formularios.Interfaz_Proveedor;
import static vista.Frm_Inicio.escritorio;

/**
 *
 * @author Eisner López Acevedo <eisner.lopez at gmail.com>
 * @author Cesar Gonzalez Salas <cgonzalez816 at gmail.com>
 */
public class Frm_Agregar_Proveedor extends javax.swing.JInternalFrame {

    /**
     * Creates new form Personas_frm
     */
    Connection con = null;
    ResultSet rs = null;
    PreparedStatement pst = null;
    ResultSet rs2 = null;
    PreparedStatement pst2 = null;
    public static String IdProveedor;
    public static String IdPersona;
    String sqlInsert;
    String sqlDelete;
    //declarar static e instanciarla en tu contructor`
    static DefaultComboBoxModel modeloTipo;

    public Frm_Agregar_Proveedor() {
        initComponents();
        con = dbConnection.getConnection();
        lbl_idPersona.setVisible(false);
        lbl_id_persona.setVisible(false);
        //modelamos el JComboBox con los valores de las tabla tipo Persona.
        modeloTipo = new DefaultComboBoxModel();
        TipoPersona(); // llenar los datos al ejecutar el programa
        txtClasificación.setVisible(false);
        lbl_idPersona.setVisible(false);
        lbl_id_persona.setVisible(false);
    }

    public void getNumeroCodigo() {
        String NuevoNumero;
        txtCodigoCliente.setText("");
        lbl_idPersona.setText("");
        Interfaz_Persona func = new Interfaz_Persona();
        NuevoNumero = func.getNumeroCodigo();
        txtCodigoCliente.setText(txtNombre_Apellidos.getText() + NuevoNumero);
    }

    public final void TipoPersona() { // static para poder llamarlo desde el otro frame o JDialog
        String Clasificación;
        txtClasificación.setText("");
        Interfaz_Persona func = new Interfaz_Persona();
        Clasificación = func.SeleccionarTipoPersona();
        txtClasificación.setText(Clasificación);
    }

    private void limpiar() {
        txtNombre_Apellidos.setText("");
        txtCedula.setText("");
        txtPhone.setText("");
        txtDireccion.setText("");
        txtCodigoCliente.setText("");
    }

    private void agregarPersona() {
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
            if (txtCodigoCliente.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Favor ingresa la clasificaci\u00F3n de la persona ", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if (txtCedula.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Favor ingresa el n\u00FAmero de c\u00E9dula!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
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

            //Inicio de la Función para Agregar Proveedor
            Modelo_Proveedor dtsProveedor = new Modelo_Proveedor();
            Interfaz_Proveedor funcProveedor = new Interfaz_Proveedor();
            dtsProveedor.setDesc_proveedor(txtCodigoCliente.getText());
            funcProveedor.insertar(dtsProveedor);
            //Fin Agregar Proveedor

            JOptionPane.showMessageDialog(this, "Guardado con Exito saved", "Proveedor", JOptionPane.INFORMATION_MESSAGE);
            this.dispose();
        } else {
            limpiar();
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
        direccion = new javax.swing.JLabel();
        telefono = new javax.swing.JLabel();
        txtDireccion = new javax.swing.JTextField();
        txtClasificación = new javax.swing.JTextField();
        nombreApellidos = new javax.swing.JLabel();
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
        setTitle("Agregar Proveedor");
        setMaximumSize(new java.awt.Dimension(111, 33));
        setPreferredSize(new java.awt.Dimension(667, 423));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtNombre_Apellidos.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        txtNombre_Apellidos.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        getContentPane().add(txtNombre_Apellidos, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 360, 40));

        cedula.setFont(new java.awt.Font("Modern No. 20", 1, 18)); // NOI18N
        cedula.setForeground(java.awt.Color.darkGray);
        cedula.setText("Cedula");
        getContentPane().add(cedula, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 82, -1, -1));

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

        txtClasificación.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        txtClasificación.setToolTipText("");
        txtClasificación.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        getContentPane().add(txtClasificación, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 330, 20, 40));

        nombreApellidos.setFont(new java.awt.Font("Modern No. 20", 1, 18)); // NOI18N
        nombreApellidos.setForeground(java.awt.Color.darkGray);
        nombreApellidos.setText("Nombre y Apellidos");
        getContentPane().add(nombreApellidos, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 82, -1, -1));

        Persona.setFont(new java.awt.Font("Modern No. 20", 1, 18)); // NOI18N
        Persona.setForeground(java.awt.Color.darkGray);
        Persona.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Market-Research.png"))); // NOI18N
        getContentPane().add(Persona, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 250, 110, 110));

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
                .addGap(64, 64, 64)
                .addComponent(nuevo)
                .addGap(18, 18, 18)
                .addComponent(guardar)
                .addGap(18, 18, 18)
                .addComponent(editar)
                .addGap(18, 18, 18)
                .addComponent(buscar)
                .addContainerGap(514, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {buscar, editar, guardar, nuevo});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(buscar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(nuevo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(editar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(guardar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {buscar, editar, guardar, nuevo});

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        lbl_idPersona.setFont(new java.awt.Font("Modern No. 20", 1, 18)); // NOI18N
        lbl_idPersona.setForeground(java.awt.Color.darkGray);
        lbl_idPersona.setText("jLabel1");
        getContentPane().add(lbl_idPersona, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 330, -1, -1));

        lbl_id_persona.setFont(new java.awt.Font("Modern No. 20", 1, 18)); // NOI18N
        lbl_id_persona.setForeground(java.awt.Color.darkGray);
        lbl_id_persona.setText("lblIdPersona");
        getContentPane().add(lbl_id_persona, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 330, -1, -1));

        nombreUsuario1.setFont(new java.awt.Font("Roboto Black", 1, 16)); // NOI18N
        nombreUsuario1.setForeground(java.awt.Color.darkGray);
        nombreUsuario1.setText("Nombre empresa proveedor");
        getContentPane().add(nombreUsuario1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, -1, -1));

        txtCodigoCliente.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        txtCodigoCliente.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        getContentPane().add(txtCodigoCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 280, 440, 40));

        txtCedula.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        getContentPane().add(txtCedula, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 110, 220, 40));

        txtPhone.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        getContentPane().add(txtPhone, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, 220, 40));

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
        JOptionPane.showMessageDialog(this, IdPersona + ", " + IdProveedor);
        //Editar Persona
        Modelo_Persona dtsPersona = new Modelo_Persona();
        Interfaz_Persona funcPersona = new Interfaz_Persona();

        dtsPersona.setNombre(txtNombre_Apellidos.getText());
        dtsPersona.setCedula(txtCedula.getText());
        dtsPersona.setTelefono(txtPhone.getText());
        dtsPersona.setDireccion(txtDireccion.getText());

        dtsPersona.setIdpersona(IdPersona);
        if (funcPersona.editar(dtsPersona)) {

        }
        //Fin Editar Persona
        //Editar Proveedor
        Modelo_Proveedor dtsProveedor = new Modelo_Proveedor();
        Interfaz_Proveedor funcProveedor = new Interfaz_Proveedor();

        dtsProveedor.setDesc_proveedor(txtCodigoCliente.getText());
        dtsProveedor.setIdproveedor(IdProveedor);
        if (funcProveedor.editar(dtsProveedor)) {

        }
    }//GEN-LAST:event_editarActionPerformed

    private void buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarActionPerformed
        Frm_BusquedaAgregarProveedor form;
        form = new Frm_BusquedaAgregarProveedor();
        escritorio.add(form);
        form.toFront();
        form.setVisible(true);
    }//GEN-LAST:event_buscarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Persona;
    private javax.swing.JButton buscar;
    private javax.swing.JLabel cedula;
    private javax.swing.JLabel direccion;
    private javax.swing.JButton editar;
    private javax.swing.JButton guardar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lbl_idPersona;
    private javax.swing.JLabel lbl_id_persona;
    private javax.swing.JLabel nombreApellidos;
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
