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
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import modelo.contructor.Modelo_Colaborador;
import modelo.contructor.Modelo_Persona;
import modelo.contructor.Modelo_Proveedor;
import modelo.formularios.Interfaz_Colaborador;
import modelo.formularios.Interfaz_Persona;
import modelo.formularios.Interfaz_Proveedor;
import static vista.Frm_Agregar_Proveedor.IdPersona;
import static vista.Frm_Agregar_Proveedor.IdProveedor;
import static vista.Frm_Agregar_Proveedor.txtCodigoCliente;
import static vista.Frm_Inicio.escritorio;

/**
 *
 * @author Eisner López Acevedo <eisner.lopez at gmail.com>
 * @author Cesar Gonzalez Salas <cgonzalez816 at gmail.com>
 */
public class Frm_Agregar_Colaborador extends javax.swing.JInternalFrame {

    /**
     * Creates new form Personas_frm
     */
    Connection con = null;
    ResultSet rs = null;
    PreparedStatement pst = null;
    ResultSet rs2 = null;
    PreparedStatement pst2 = null;
    public String txtClasificación;
    public String FechaContrato, FechaDespido;
    //declarar static e instanciarla en tu contructor`
    static DefaultComboBoxModel modeloPuesto;
    static DefaultComboBoxModel modeloHorario;

    public Frm_Agregar_Colaborador() {
        initComponents();
        con = dbConnection.getConnection();
        modeloPuesto = new DefaultComboBoxModel();
        llena_comboPuesto(); // llenar los datos al ejecutar el programa
        modeloHorario = new DefaultComboBoxModel();
        llena_comboHorario(); // llenar los datos al ejecutar el programa
        //Selecciona el valor por defecto de empleado.
        TipoPersona();
        //Seleciona el valor por defecto de tipo de puesto
        TipoPuesto();
        //Selecciona el tipo de horario por defecto en este caso Diurno.
        TipoTurno();
        ocultarLabels();
        
    }

    public static void ocultarLabels()
    {
        optDespedido.setVisible(false);
        txtFechaDespido.setVisible(false);
        txtFechaContrato.setVisible(false);
        lbl_IDPersona.setVisible(false);
        lbl_idPuesto.setVisible(false);
        lbl_idHorario.setVisible(false);
        lbl_idColaborador.setVisible(false);
    }
    
    public static void mostrarLabels()
    {
        optDespedido.setVisible(true);
        txtFechaDespido.setVisible(true);
        txtFechaContrato.setVisible(true);
        lblFechaContrato.setVisible(false);
        txtContrato.setVisible(false);
    }
    
    public final void llena_comboPuesto() { // static para poder llamarlo desde el otro frame o JDialog
        try {
            modeloPuesto.removeAllElements(); // eliminamos lo elementos
            Statement stmt;
            stmt = con.createStatement();
            String queryComboPuesto = "SELECT puesto_id, descripcion_puesto FROM pct3.puesto;";
            rs = stmt.executeQuery(queryComboPuesto);
            while (rs.next()) {
                modeloPuesto.addElement(rs.getString("descripcion_puesto"));
                if (rs.getString("descripcion_puesto").equals("Empleado")) {
                    modeloPuesto.setSelectedItem(rs.getString("descripcion_puesto"));
                }
            }
            cmbPuesto.setModel(modeloPuesto); // seteamos el modelo y se cargan los datos
        } catch (HeadlessException | SQLException ex) {
            JOptionPane.showMessageDialog(this, ex);
        }
    }

    //Metodo para llenar el combo horario
    public final void llena_comboHorario() { // static para poder llamarlo desde el otro frame o JDialog
        try {
            modeloHorario.removeAllElements(); // eliminamos lo elementos
            Statement stmt;
            stmt = con.createStatement();
            String queryComboHorario = "SELECT * FROM pct3.horario;";
            rs = stmt.executeQuery(queryComboHorario);
            while (rs.next()) {
                modeloHorario.addElement(rs.getString("descripcion_horario"));
                if (rs.getString("descripcion_horario").equals("Diurno")) {
                    modeloHorario.setSelectedItem(rs.getString("descripcion_horario"));
                }
            }
            cmbHorario.setModel(modeloHorario); // seteamos el modelo y se cargan los datos

        } catch (HeadlessException | SQLException ex) {
            JOptionPane.showMessageDialog(this, ex);
        }
    }
    //Fin Metodo combo Horario

    //Metodo TipoPuesto
    private void TipoPuesto() {
        // TODO add your handling code here:
        lbl_idPuesto.setText("");
        try {
            String sqlConsulta_TPuesto = "SELECT "
                    + "puesto_id, "
                    + "descripcion_puesto "
                    + "FROM "
                    + "pct3.puesto "
                    + "WHERE "
                    + "`descripcion_puesto` = '" + cmbPuesto.getSelectedItem() + "'";
            pst = con.prepareStatement(sqlConsulta_TPuesto);
            rs = pst.executeQuery();
            if (rs.next()) {
                String add1 = rs.getString(1);
                lbl_idPuesto.setText(add1);
                String TipoPuestoSeleccionado;
                TipoPuestoSeleccionado = (String) cmbPuesto.getSelectedItem();
            }

        } catch (SQLException | HeadlessException e) {
            JOptionPane.showMessageDialog(null, e);

        }
    }

    private void obtenerFechaContrato() {
        Calendar cal;
        int d, m, a;

        cal = txtContrato.getCalendar();

        d = cal.get(Calendar.DAY_OF_MONTH);
        m = cal.get(Calendar.MONTH);
        a = cal.get(Calendar.YEAR) - 1900;
        Format formatter = new SimpleDateFormat("yyyy-MM-dd");
        String s = formatter.format(txtContrato.getDate());
        FechaContrato = s;

    }

    //Metodo TipoTurno
    private void TipoTurno() {
        // TODO add your handling code here:
        lbl_idHorario.setText("");
        try {
            String sqlConsulta_THorario = "SELECT * FROM pct3.horario "
                    + "WHERE "
                    + "`descripcion_horario` = '" + cmbHorario.getSelectedItem() + "'";
            pst = con.prepareStatement(sqlConsulta_THorario);
            rs = pst.executeQuery();
            if (rs.next()) {
                String add1 = rs.getString(1);
                lbl_idHorario.setText(add1);
                String tipoHorarioSeleccionado;
                tipoHorarioSeleccionado = (String) cmbHorario.getSelectedItem();
            }

        } catch (SQLException | HeadlessException e) {
            JOptionPane.showMessageDialog(null, e);

        }
    }

    //Inicio metodo TipoPersona
    private void TipoPersona() {
        String Clasificación;
        txtClasificación = "";
        Interfaz_Persona func = new Interfaz_Persona();
        Clasificación = func.SeleccionarColaborador();
        txtClasificación = Clasificación;
    }

    private void limpiar() {
        txtFechaDespido.setText("0000-00-00");
        txtNombre_Apellidos.setText("");
        txtCedula.setText("");
        txtPhone.setText("");
        txtDireccion.setText("");
        txtObservarciones.setText("");
    }

    //Metodo para insertar en la Tabla Personas y Colaborador.
    private void agregarPersona() {
        
            obtenerFechaContrato();
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
                dtsPersona.setTipo_persona_idtipo_persona(txtClasificación);
                func.insertar(dtsPersona);
                //Fin Agregar Persona

                //Inicio de la Función para Agregar Colaborador
                Modelo_Colaborador dtsColaborador = new Modelo_Colaborador();
                Interfaz_Colaborador funcColaborador = new Interfaz_Colaborador();
                dtsColaborador.setFecha_contrato(FechaContrato);
                dtsColaborador.setHorario_horario_id(lbl_idHorario.getText());
                dtsColaborador.setObservaciones(" " + txtObservarciones.getText());
                dtsColaborador.setPuesto_puesto_id(lbl_idPuesto.getText());
                funcColaborador.insertar(dtsColaborador);
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

        cedula = new javax.swing.JLabel();
        direccion = new javax.swing.JLabel();
        telefono = new javax.swing.JLabel();
        txtDireccion = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        nuevo = new javax.swing.JButton();
        guardar = new javax.swing.JButton();
        editar = new javax.swing.JButton();
        buscar = new javax.swing.JButton();
        Persona = new javax.swing.JLabel();
        nombreApellidos = new javax.swing.JLabel();
        txtNombre_Apellidos = new javax.swing.JTextField();
        lblFechaContrato = new javax.swing.JLabel();
        txtObservarciones = new javax.swing.JTextField();
        direccion1 = new javax.swing.JLabel();
        cmbPuesto = new javax.swing.JComboBox<>();
        lblPuesto = new javax.swing.JLabel();
        lblHorario = new javax.swing.JLabel();
        cmbHorario = new javax.swing.JComboBox<>();
        lbl_idHorario = new javax.swing.JLabel();
        lbl_idPuesto = new javax.swing.JLabel();
        txtContrato = new com.toedter.calendar.JDateChooser();
        txtCedula = new javax.swing.JFormattedTextField();
        txtPhone = new javax.swing.JFormattedTextField();
        lbl_IDPersona = new javax.swing.JLabel();
        optDespedido = new javax.swing.JCheckBox();
        txtFechaDespido = new javax.swing.JLabel();
        txtFechaContrato = new javax.swing.JLabel();
        lbl_idColaborador = new javax.swing.JLabel();

        setClosable(true);
        setForeground(java.awt.Color.gray);
        setMaximizable(true);
        setResizable(true);
        setTitle("Agregar Colaborador");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cedula.setFont(new java.awt.Font("Modern No. 20", 1, 18)); // NOI18N
        cedula.setForeground(java.awt.Color.darkGray);
        cedula.setText("Cedula");
        getContentPane().add(cedula, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, -1, -1));

        direccion.setFont(new java.awt.Font("Modern No. 20", 1, 18)); // NOI18N
        direccion.setForeground(java.awt.Color.darkGray);
        direccion.setText("Direccion");
        getContentPane().add(direccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 260, -1, -1));

        telefono.setFont(new java.awt.Font("Modern No. 20", 1, 18)); // NOI18N
        telefono.setForeground(java.awt.Color.darkGray);
        telefono.setText("Télefono o Celular");
        getContentPane().add(telefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 170, -1, -1));

        txtDireccion.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        txtDireccion.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        getContentPane().add(txtDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 280, 440, 40));

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

        Persona.setFont(new java.awt.Font("Modern No. 20", 1, 18)); // NOI18N
        Persona.setForeground(java.awt.Color.darkGray);
        Persona.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Persona.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/empleados.png"))); // NOI18N

        nombreApellidos.setFont(new java.awt.Font("Modern No. 20", 1, 18)); // NOI18N
        nombreApellidos.setForeground(java.awt.Color.darkGray);
        nombreApellidos.setText("Nombre y Apellidos");

        txtNombre_Apellidos.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        txtNombre_Apellidos.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(134, 134, 134)
                        .addComponent(nuevo)
                        .addGap(18, 18, 18)
                        .addComponent(guardar)
                        .addGap(18, 18, 18)
                        .addComponent(editar)
                        .addGap(18, 18, 18)
                        .addComponent(buscar))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(nombreApellidos))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(txtNombre_Apellidos, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addComponent(Persona, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nuevo)
                            .addComponent(guardar)
                            .addComponent(editar)
                            .addComponent(buscar))
                        .addGap(16, 16, 16)
                        .addComponent(nombreApellidos)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtNombre_Apellidos, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(Persona, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 690, 170));

        lblFechaContrato.setFont(new java.awt.Font("Roboto Black", 1, 16)); // NOI18N
        lblFechaContrato.setForeground(java.awt.Color.darkGray);
        lblFechaContrato.setText("Fecha Contrato");
        getContentPane().add(lblFechaContrato, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 170, -1, -1));

        txtObservarciones.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        txtObservarciones.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        getContentPane().add(txtObservarciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 360, 440, 40));

        direccion1.setFont(new java.awt.Font("Modern No. 20", 1, 18)); // NOI18N
        direccion1.setForeground(java.awt.Color.darkGray);
        direccion1.setText("Observaciones");
        getContentPane().add(direccion1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 340, -1, -1));

        cmbPuesto.setFont(new java.awt.Font("Dialog", 1, 16));
        cmbPuesto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbPuesto.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        cmbPuesto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbPuestoActionPerformed(evt);
            }
        });
        getContentPane().add(cmbPuesto, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 280, 200, 40));

        lblPuesto.setFont(new java.awt.Font("Modern No. 20", 1, 18)); // NOI18N
        lblPuesto.setForeground(java.awt.Color.darkGray);
        lblPuesto.setText("Puesto");
        getContentPane().add(lblPuesto, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 250, -1, -1));

        lblHorario.setFont(new java.awt.Font("Modern No. 20", 1, 18)); // NOI18N
        lblHorario.setForeground(java.awt.Color.darkGray);
        lblHorario.setText("Horario");
        getContentPane().add(lblHorario, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 330, -1, -1));

        cmbHorario.setFont(new java.awt.Font("Dialog", 1, 16));
        cmbHorario.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbHorario.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        cmbHorario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbHorarioActionPerformed(evt);
            }
        });
        getContentPane().add(cmbHorario, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 360, 200, 40));

        lbl_idHorario.setBackground(new java.awt.Color(0, 0, 0));
        lbl_idHorario.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        lbl_idHorario.setForeground(new java.awt.Color(0, 0, 0));
        lbl_idHorario.setText("Horario: ");
        getContentPane().add(lbl_idHorario, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 460, -1, -1));

        lbl_idPuesto.setBackground(new java.awt.Color(0, 0, 0));
        lbl_idPuesto.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        lbl_idPuesto.setForeground(new java.awt.Color(0, 0, 0));
        lbl_idPuesto.setText("Puesto: ");
        getContentPane().add(lbl_idPuesto, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 440, -1, -1));
        getContentPane().add(txtContrato, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 200, 200, 40));

        txtCedula.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        getContentPane().add(txtCedula, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 200, 260, 40));

        txtPhone.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        getContentPane().add(txtPhone, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 200, 190, 40));

        lbl_IDPersona.setBackground(new java.awt.Color(0, 0, 0));
        lbl_IDPersona.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        lbl_IDPersona.setForeground(new java.awt.Color(0, 0, 0));
        lbl_IDPersona.setText("Persona:");
        getContentPane().add(lbl_IDPersona, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 400, -1, -1));

        optDespedido.setText("Despedido");
        optDespedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                optDespedidoActionPerformed(evt);
            }
        });
        getContentPane().add(optDespedido, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 420, 190, 50));

        txtFechaDespido.setBorder(javax.swing.BorderFactory.createTitledBorder("Fecha de Despido"));
        getContentPane().add(txtFechaDespido, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 410, 190, 60));

        txtFechaContrato.setBorder(javax.swing.BorderFactory.createTitledBorder("Fecha Contrato"));
        getContentPane().add(txtFechaContrato, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 410, 190, 60));

        lbl_idColaborador.setBackground(new java.awt.Color(0, 0, 0));
        lbl_idColaborador.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        lbl_idColaborador.setForeground(new java.awt.Color(0, 0, 0));
        lbl_idColaborador.setText("Colaborador:");
        getContentPane().add(lbl_idColaborador, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 420, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void nuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nuevoActionPerformed
        limpiar();
    }//GEN-LAST:event_nuevoActionPerformed
    //Inicio Boton Guardar
    private void guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarActionPerformed

        agregarPersona();

    }//GEN-LAST:event_guardarActionPerformed

    private void editarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editarActionPerformed
        JOptionPane.showMessageDialog(this, lbl_IDPersona.getText() + ", " + lbl_idColaborador.getText());
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
        Modelo_Colaborador dtsColaborador = new Modelo_Colaborador();
        Interfaz_Colaborador funcProveedor = new Interfaz_Colaborador();
        dtsColaborador.setObservaciones(txtObservarciones.getText());
        dtsColaborador.setHorario_horario_id(lbl_idHorario.getText());
        dtsColaborador.setPuesto_puesto_id(lbl_idPuesto.getText());
        //ID'S
        dtsColaborador.setEmpleado_id(lbl_idColaborador.getText());
        dtsColaborador.setPersona_idpersona(lbl_IDPersona.getText());
        
        if (funcProveedor.editar(dtsColaborador)) {
            
        }
    }//GEN-LAST:event_editarActionPerformed

    private void buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarActionPerformed
        
        Frm_BusquedaAgregarColaboradores form;
        form = new Frm_BusquedaAgregarColaboradores();
        escritorio.add(form);
        form.toFront();
        form.setVisible(true);
        mostrarLabels();
    }//GEN-LAST:event_buscarActionPerformed

    private void cmbPuestoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbPuestoActionPerformed
        TipoPuesto();
    }//GEN-LAST:event_cmbPuestoActionPerformed

    private void cmbHorarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbHorarioActionPerformed
        TipoTurno();
    }//GEN-LAST:event_cmbHorarioActionPerformed

    private void optDespedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_optDespedidoActionPerformed
        // TODO add your handling code here:
        Calendar c1 = GregorianCalendar.getInstance();
        SimpleDateFormat sdf;
        sdf = new SimpleDateFormat("yyyy-MM-dd");
        c1.add(Calendar.DATE, 0);
        txtFechaDespido.setText(sdf.format(c1.getTime()));
        
        //Editar Colaborador
        Modelo_Colaborador dtsColaborador = new Modelo_Colaborador();
        Interfaz_Colaborador funcProveedor = new Interfaz_Colaborador();
        dtsColaborador.setFecha_despido(txtFechaDespido.getText());
        //ID'S
        dtsColaborador.setEmpleado_id(lbl_idColaborador.getText());
        dtsColaborador.setPersona_idpersona(lbl_IDPersona.getText());
        
        if (funcProveedor.editarDespido(dtsColaborador)) {
            
        }
        
    }//GEN-LAST:event_optDespedidoActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Persona;
    private javax.swing.JButton buscar;
    private javax.swing.JLabel cedula;
    private javax.swing.JComboBox<String> cmbHorario;
    private javax.swing.JComboBox<String> cmbPuesto;
    private javax.swing.JLabel direccion;
    private javax.swing.JLabel direccion1;
    private javax.swing.JButton editar;
    private javax.swing.JButton guardar;
    private javax.swing.JPanel jPanel1;
    public static javax.swing.JLabel lblFechaContrato;
    private javax.swing.JLabel lblHorario;
    private javax.swing.JLabel lblPuesto;
    public static javax.swing.JLabel lbl_IDPersona;
    public static javax.swing.JLabel lbl_idColaborador;
    public static javax.swing.JLabel lbl_idHorario;
    public static javax.swing.JLabel lbl_idPuesto;
    private javax.swing.JLabel nombreApellidos;
    private javax.swing.JButton nuevo;
    public static javax.swing.JCheckBox optDespedido;
    private javax.swing.JLabel telefono;
    public static javax.swing.JFormattedTextField txtCedula;
    public static com.toedter.calendar.JDateChooser txtContrato;
    public static javax.swing.JTextField txtDireccion;
    public static javax.swing.JLabel txtFechaContrato;
    public static javax.swing.JLabel txtFechaDespido;
    public static javax.swing.JTextField txtNombre_Apellidos;
    public static javax.swing.JTextField txtObservarciones;
    public static javax.swing.JFormattedTextField txtPhone;
    // End of variables declaration//GEN-END:variables
}
