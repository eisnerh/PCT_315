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
    String sqlSelect;
    String sqlSelect_Valor;
    String sqlInsert;
    String sqlDelete;

    private String id_Persona;

    //declarar static e instanciarla en tu contructor`
    static DefaultComboBoxModel modeloTipoPersona;
    static DefaultComboBoxModel modeloPuesto;
    static DefaultComboBoxModel modeloHorario;

    public Frm_Agregar_Colaborador() {
        initComponents();
        con = dbConnection.getConnection();
        sqlSelect = "SELECT `idpersona`, `nombre`, `cedula`, `telefono`, `direccion`, `tipo_persona_idtipo_persona` FROM `persona` order BY `nombre`";
        sqlSelect_Valor = "SELECT `idpersona`, `nombre`, `cedula`, `telefono`, `direccion`, `tipo_persona_idtipo_persona` FROM `persona` WHERE `nombre` = '";
        sqlInsert = "INSERT INTO `persona`(`nombre`, `cedula`, `telefono`, `direccion`, `tipo_persona_idtipo_persona`) VALUES ('";
        sqlDelete = "DELETE FROM `persona` WHERE `idpersona` = ";

        modeloTipoPersona = new DefaultComboBoxModel();
        llena_comboPersona(); // llenar los datos al ejecutar el programa
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
    }

    public final void llena_comboPersona() { // static para poder llamarlo desde el otro frame o JDialog
        try {
            modeloTipoPersona.removeAllElements(); // eliminamos lo elementos
            Statement stmt;
            stmt = con.createStatement();
            String queryComboEstado = "SELECT `desc_persona` FROM `tipo_persona`";
            rs = stmt.executeQuery(queryComboEstado);
            while (rs.next()) {
                modeloTipoPersona.addElement(rs.getString("desc_persona"));
                if (rs.getString("desc_persona").equals("Empleado")) {
                    modeloTipoPersona.setSelectedItem(rs.getString(1));
                }
            }
            cmbTipoPersona.setModel(modeloTipoPersona); // seteamos el modelo y se cargan los datos

        } catch (HeadlessException | SQLException ex) {
            JOptionPane.showMessageDialog(this, ex);
        }
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
                String tipoPersonaSeleccionada;
                tipoPersonaSeleccionada = (String) cmbTipoPersona.getSelectedItem();
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
        lbl_idHorario.setText("");
        txtNombre_Apellidos.setText("");
        nuevo.setEnabled(true);
        guardar.setEnabled(false);
        buscar.setEnabled(true);
        editar.setEnabled(false);
    }
    //Metodo para insertar en la Tabla Personas y Colaborador.
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
                txtFechaDespido.setText("0000-00-00");
                String sql = sqlInsert
                        + txtNombre_Apellidos.getText()
                        + "','" + txtCedula.getText()
                        + "','" + txtPhone.getText()
                        + "','" + txtDireccion.getText()
                        + "','" + txtClasificación.getText()
                        + "')";
                String sqlColaborador = "INSERT INTO `pct3`.`colaborador` "
                        + "(`fecha_contrato`, "
                        + "`fecha_despido`, "
                        + "`persona_idpersona`, "
                        + "`puesto_puesto_id`, "
                        + "`horario_horario_id`) "
                        + "VALUES ('" + txtFechaContrato.getText() + "', "
                        + "'" + txtFechaDespido.getText() + "', "
                        + "(SELECT max(idpersona) FROM pct3.persona), "
                        + "'" + lbl_idPuesto.getText() + "', '" + lbl_idHorario.getText() + "');";
                pst = con.prepareStatement(sql);
                pst.execute();
                int in = JOptionPane.showConfirmDialog(this, "Guardado con Exito saved", "Gasto Operativo", JOptionPane.YES_OPTION);
                if (in == 0) {
                    pst = con.prepareStatement(sqlColaborador);
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

        cedula = new javax.swing.JLabel();
        txtCedula = new javax.swing.JTextField();
        direccion = new javax.swing.JLabel();
        telefono = new javax.swing.JLabel();
        txtDireccion = new javax.swing.JTextField();
        txtPhone = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        nuevo = new javax.swing.JButton();
        guardar = new javax.swing.JButton();
        editar = new javax.swing.JButton();
        buscar = new javax.swing.JButton();
        Persona = new javax.swing.JLabel();
        nombreApellidos = new javax.swing.JLabel();
        txtNombre_Apellidos = new javax.swing.JTextField();
        clasificación = new javax.swing.JLabel();
        cmbTipoPersona = new javax.swing.JComboBox<>();
        nombreUsuario1 = new javax.swing.JLabel();
        txtFechaContrato = new javax.swing.JTextField();
        txtObservarciones = new javax.swing.JTextField();
        direccion1 = new javax.swing.JLabel();
        cmbPuesto = new javax.swing.JComboBox<>();
        clasificación1 = new javax.swing.JLabel();
        clasificación2 = new javax.swing.JLabel();
        cmbHorario = new javax.swing.JComboBox<>();
        lbl_idHorario = new javax.swing.JLabel();
        nombreUsuario2 = new javax.swing.JLabel();
        txtFechaDespido = new javax.swing.JTextField();
        lbl_idPuesto = new javax.swing.JLabel();
        txtClasificación = new javax.swing.JLabel();

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

        txtCedula.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        txtCedula.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        txtCedula.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtCedulaFocusLost(evt);
            }
        });
        getContentPane().add(txtCedula, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 200, 270, 40));

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

        txtPhone.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        txtPhone.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        txtPhone.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtPhoneKeyPressed(evt);
            }
        });
        getContentPane().add(txtPhone, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 200, 200, 40));

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

        clasificación.setFont(new java.awt.Font("Modern No. 20", 1, 18)); // NOI18N
        clasificación.setForeground(java.awt.Color.darkGray);
        clasificación.setText("Clasificación");

        cmbTipoPersona.setFont(new java.awt.Font("Dialog", 1, 16));
        cmbTipoPersona.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbTipoPersona.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        cmbTipoPersona.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbTipoPersonaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Persona, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nombreApellidos)
                    .addComponent(txtNombre_Apellidos, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(nuevo)
                        .addGap(18, 18, 18)
                        .addComponent(guardar)
                        .addGap(18, 18, 18)
                        .addComponent(editar)))
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(88, 88, 88)
                        .addComponent(clasificación))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(cmbTipoPersona, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(buscar)))
                .addContainerGap(230, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Persona, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(buscar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(clasificación))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nuevo)
                            .addComponent(guardar)
                            .addComponent(editar))
                        .addGap(18, 18, 18)
                        .addComponent(nombreApellidos)
                        .addGap(10, 10, 10)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNombre_Apellidos, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmbTipoPersona, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(15, 15, 15))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        nombreUsuario1.setFont(new java.awt.Font("Roboto Black", 1, 16)); // NOI18N
        nombreUsuario1.setForeground(java.awt.Color.darkGray);
        nombreUsuario1.setText("Fecha Contrato");
        getContentPane().add(nombreUsuario1, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 170, -1, -1));

        txtFechaContrato.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        txtFechaContrato.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        getContentPane().add(txtFechaContrato, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 200, 200, 40));

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

        clasificación1.setFont(new java.awt.Font("Modern No. 20", 1, 18)); // NOI18N
        clasificación1.setForeground(java.awt.Color.darkGray);
        clasificación1.setText("Puesto");
        getContentPane().add(clasificación1, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 250, -1, -1));

        clasificación2.setFont(new java.awt.Font("Modern No. 20", 1, 18)); // NOI18N
        clasificación2.setForeground(java.awt.Color.darkGray);
        clasificación2.setText("Horario");
        getContentPane().add(clasificación2, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 330, -1, -1));

        cmbHorario.setFont(new java.awt.Font("Dialog", 1, 16));
        cmbHorario.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbHorario.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        cmbHorario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbHorarioActionPerformed(evt);
            }
        });
        getContentPane().add(cmbHorario, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 360, 200, 40));

        lbl_idHorario.setFont(new java.awt.Font("Roboto Black", 1, 8)); // NOI18N
        lbl_idHorario.setForeground(new java.awt.Color(238, 238, 238));
        lbl_idHorario.setText("Horario: ");
        getContentPane().add(lbl_idHorario, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 450, -1, -1));

        nombreUsuario2.setFont(new java.awt.Font("Roboto Black", 1, 16)); // NOI18N
        nombreUsuario2.setForeground(java.awt.Color.darkGray);
        nombreUsuario2.setText("Fecha Despido:");
        getContentPane().add(nombreUsuario2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 430, -1, -1));

        txtFechaDespido.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        txtFechaDespido.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        getContentPane().add(txtFechaDespido, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 430, 200, 40));

        lbl_idPuesto.setFont(new java.awt.Font("Roboto Black", 1, 8)); // NOI18N
        lbl_idPuesto.setForeground(new java.awt.Color(238, 238, 238));
        lbl_idPuesto.setText("Puesto: ");
        getContentPane().add(lbl_idPuesto, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 430, -1, -1));

        txtClasificación.setForeground(new java.awt.Color(238, 238, 238));
        txtClasificación.setText("jLabel1");
        getContentPane().add(txtClasificación, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 460, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //Ejecuta el Metodo TipoPersona
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
        lbl_idHorario.setText("");
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
    //Inicio Boton Guardar
    private void guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarActionPerformed
        String tipoPersonaSeleccionada;
        tipoPersonaSeleccionada = (String) cmbTipoPersona.getSelectedItem();
        switch (tipoPersonaSeleccionada) {
            case "Cliente":
                this.dispose();
                JOptionPane.showMessageDialog(this, "Abriremos el Formulario para agregar Clientes");
                Frm_Agregar_Cliente agregarCliente = new Frm_Agregar_Cliente();
                escritorio.add(agregarCliente);
                agregarCliente.toFront();
                agregarCliente.setVisible(true);
                break;
            case "Proveedor":
                this.dispose();
                JOptionPane.showMessageDialog(this, "Abriremos el Formulario para agregar Proveedores");
                Frm_Agregar_Proveedor agregar_Proveedor = new Frm_Agregar_Proveedor();
                escritorio.add(agregar_Proveedor);
                agregar_Proveedor.toFront();
                agregar_Proveedor .setVisible(true);
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

                String Pru = "UPDATE `persona` SET `nombre` = '" + txtNombre_Apellidos.getText() + "',`cedula` = '" + txtCedula.getText() + "', `telefono` = '" + txtPhone.getText() + "',`direccion`='" + txtPhone.getText() + "',`tipo_persona_idtipo_persona`='" + txtClasificación.getText() + "' WHERE `idpersona`='" + lbl_idHorario.getText() + "'";
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
        Frm_BusquedaColaboradores form;
        form = new Frm_BusquedaColaboradores();
        escritorio.add(form);
        form.toFront();
        form.setVisible(true);
    }//GEN-LAST:event_buscarActionPerformed

    private void txtCedulaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCedulaFocusLost
        // TODO add your handling code here:

    }//GEN-LAST:event_txtCedulaFocusLost

    private void txtPhoneKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPhoneKeyPressed
        // TODO add your handling code here:
//        char c = evt.getKeyChar();
//        if (Character.isAlphabetic(c) || Character.isSurrogate(c) || Character.isUnicodeIdentifierPart(c)) {
//            getToolkit().beep();
//            evt.consume();
//            JOptionPane.showMessageDialog(this, "Ingresa Solo Números.\n Gracias!", "Error", JOptionPane.ERROR_MESSAGE);
//        }
    }//GEN-LAST:event_txtPhoneKeyPressed


    private void cmbPuestoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbPuestoActionPerformed
        TipoPersona();
    }//GEN-LAST:event_cmbPuestoActionPerformed

    private void cmbHorarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbHorarioActionPerformed
        TipoTurno();
    }//GEN-LAST:event_cmbHorarioActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Persona;
    private javax.swing.JButton buscar;
    private javax.swing.JLabel cedula;
    private javax.swing.JLabel clasificación;
    private javax.swing.JLabel clasificación1;
    private javax.swing.JLabel clasificación2;
    private javax.swing.JComboBox<String> cmbHorario;
    private javax.swing.JComboBox<String> cmbPuesto;
    private javax.swing.JComboBox<String> cmbTipoPersona;
    private javax.swing.JLabel direccion;
    private javax.swing.JLabel direccion1;
    private javax.swing.JButton editar;
    private javax.swing.JButton guardar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lbl_idHorario;
    private javax.swing.JLabel lbl_idPuesto;
    private javax.swing.JLabel nombreApellidos;
    public static javax.swing.JLabel nombreUsuario1;
    public static javax.swing.JLabel nombreUsuario2;
    private javax.swing.JButton nuevo;
    private javax.swing.JLabel telefono;
    private javax.swing.JTextField txtCedula;
    private javax.swing.JLabel txtClasificación;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtFechaContrato;
    private javax.swing.JTextField txtFechaDespido;
    public static javax.swing.JTextField txtNombre_Apellidos;
    private javax.swing.JTextField txtObservarciones;
    private javax.swing.JTextField txtPhone;
    // End of variables declaration//GEN-END:variables
}
