/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import com.sun.glass.events.KeyEvent;
import controller.ConexionDB;
import java.awt.HeadlessException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

/**
 *
 * @author ace
 */
public final class Colaborador_frm extends javax.swing.JFrame {

    /**
     * Creates new form puesto
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
    //declarar static e instanciarla en tu contructor`
    static DefaultComboBoxModel modeloPuesto, modeloHorario;

    public Colaborador_frm() throws IOException {
        initComponents();
        Date sumarRestarDiasFecha = sumarRestarDiasFecha(dcFechaContrato.getDate(),3);
        //inicialización de las variables de la coneccion a la base de datos
        con = ConexionDB.conexionDB();
        //llama al procedimiento de obtener la información.

        //centra la ventana para que se inicie en el centro del escritorio
        setLocationRelativeTo(null);
        initState();
        sqlSelect = "SELECT `idpersona`, `nombre`, `cedula`, `telefono`, `direccion`, `tipo_persona_idtipo_persona` FROM `persona` order BY `nombre`";
        sqlSelect_Valor = "SELECT `idpersona`, `nombre`, `cedula`, `telefono`, `direccion`, `tipo_persona_idtipo_persona` FROM `persona` WHERE `nombre` = '";
        sqlInsert = "INSERT INTO `persona`(`nombre`, `cedula`, `telefono`, `direccion`, `tipo_persona_idtipo_persona`) VALUES ('";
        sqlDelete = "DELETE FROM `persona` WHERE `idpersona` = ";

        modeloPuesto = new DefaultComboBoxModel();
        modeloHorario = new DefaultComboBoxModel();

        llena_ComboHorario(); // llenar los datos al ejecutar el programa
        llena_ComboPuesto();
    }

    public void llena_ComboPuesto() {
        try {
            modeloPuesto.removeAllElements(); // eliminamos lo elementos

            Statement stmt;
            stmt = con.createStatement();

            String sql1 = "SELECT `descripcion_puesto` FROM `puesto`";
            rs = stmt.executeQuery(sql1);

            while (rs.next()) {
                modeloPuesto.addElement(rs.getString("descripcion_puesto"));
            }
            cmbHorario.setModel(modeloPuesto); // seteamos el modelo y se cargan los datos

        } catch (HeadlessException | SQLException ex) {
            JOptionPane.showMessageDialog(this, ex);
        }
    }
    // Suma los días recibidos a la fecha  
 public Date sumarRestarDiasFecha(Date fecha, int dias){
 
      Calendar calendar = Calendar.getInstance();
      SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
      calendar.add(Calendar.DAY_OF_YEAR, dias);  // numero de días a añadir, o restar en caso de días<0
 System.out.println(calendar.getTime().toString());
        
      return calendar.getTime(); // Devuelve el objeto Date con los nuevos días añadidos
      
 }


    public void llena_ComboHorario() { // static para poder llamarlo desde el otro frame o JDialog

        try {
            modeloHorario.removeAllElements(); // eliminamos lo elementos

            Statement stmt;
            stmt = con.createStatement();

            String sql1 = "SELECT `descripcion_horario` FROM `horario`";
            rs = stmt.executeQuery(sql1);

            while (rs.next()) {
                modeloHorario.addElement(rs.getString("descripcion_horario"));
            }
            cmbTipoPuesto.setModel(modeloHorario); // seteamos el modelo y se cargan los datos

        } catch (HeadlessException | SQLException ex) {
            JOptionPane.showMessageDialog(this, ex);
        }
    }

    private void initState() {
        chk_Activo.setSelected(true);
        txtFechaDespido.setEnabled(false);
        cmbHorario.setEnabled(false);
        txtPhone.setEnabled(false);
        txtClasificación.setEnabled(false);
        txtFechaContrato.setEnabled(false);
        cmbTipoPuesto.setEnabled(false);
        empleado_id.setText("");
        txtFechaDespido.setText("");
        nuevo.setEnabled(true);
        guardar.setEnabled(false);
        buscar.setEnabled(true);
        editar.setEnabled(false);
        borrar.setEnabled(false);
        Date d = new Date();
        dcFechaContrato.setDate(d);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtFechaDespido = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtFechaContrato = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        dcFechaContrato = new com.toedter.calendar.JDateChooser();
        id_persona = new javax.swing.JLabel();
        chk_Activo = new javax.swing.JCheckBox();
        cmbHorario = new javax.swing.JComboBox<>();
        txtClasificación = new javax.swing.JTextField();
        cmbTipoPuesto = new javax.swing.JComboBox<>();
        dcFechaContrato1 = new com.toedter.calendar.JDateChooser();
        jLabel9 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtPhone = new javax.swing.JTextField();
        Persona = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        nuevo = new javax.swing.JButton();
        editar = new javax.swing.JButton();
        borrar = new javax.swing.JButton();
        buscar = new javax.swing.JButton();
        volver = new javax.swing.JButton();
        fondo = new javax.swing.JLabel();
        empleado_id = new javax.swing.JLabel();
        guardar = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        mnuSalir = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Agregar Nueva Persona");
        setMinimumSize(new java.awt.Dimension(818, 401));
        setUndecorated(true);
        setResizable(false);
        setType(java.awt.Window.Type.UTILITY);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtFechaDespido.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        getContentPane().add(txtFechaDespido, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 170, 230, 40));

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Fecha Despido");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 140, -1, -1));

        txtFechaContrato.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        txtFechaContrato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFechaContratoActionPerformed(evt);
            }
        });
        getContentPane().add(txtFechaContrato, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 170, 230, 40));

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Observaciones");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 230, -1, -1));

        dcFechaContrato.setDateFormatString("yyyy/MM/dd");
        dcFechaContrato.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                dcFechaContratoMousePressed(evt);
            }
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dcFechaContratoMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                dcFechaContratoMouseEntered(evt);
            }
        });
        dcFechaContrato.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                dcFechaContratoPropertyChange(evt);
            }
        });
        getContentPane().add(dcFechaContrato, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 310, 160, 40));

        id_persona.setText("jLabel1");
        getContentPane().add(id_persona, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 420, 100, 30));

        chk_Activo.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        chk_Activo.setText("Activo");
        chk_Activo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chk_ActivoActionPerformed(evt);
            }
        });
        getContentPane().add(chk_Activo, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 170, -1, -1));

        cmbHorario.setFont(new java.awt.Font("Dialog", 1, 16));
        cmbHorario.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        getContentPane().add(cmbHorario, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 350, 200, 40));

        txtClasificación.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        getContentPane().add(txtClasificación, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 350, 200, 40));

        cmbTipoPuesto.setFont(new java.awt.Font("Dialog", 1, 16));
        cmbTipoPuesto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbTipoPuesto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbTipoPuestoActionPerformed(evt);
            }
        });
        getContentPane().add(cmbTipoPuesto, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 440, 200, 40));

        dcFechaContrato1.setDateFormatString("yyyy/MM/dd");
        dcFechaContrato1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                dcFechaContrato1MousePressed(evt);
            }
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dcFechaContrato1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                dcFechaContrato1MouseEntered(evt);
            }
        });
        dcFechaContrato1.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                dcFechaContrato1PropertyChange(evt);
            }
        });
        getContentPane().add(dcFechaContrato1, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 310, 160, 40));

        jLabel9.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Puesto");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 410, -1, -1));

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Fecha Contrato");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 140, -1, -1));

        jLabel8.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Horario");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 320, -1, -1));

        txtPhone.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        getContentPane().add(txtPhone, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 260, 690, 40));

        Persona.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icons/usuario.png"))); // NOI18N
        getContentPane().add(Persona, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 320, 150, 150));

        nuevo.setBackground(new java.awt.Color(204, 204, 204));
        nuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icons/CRUD/store-new-badges.png"))); // NOI18N
        nuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nuevoActionPerformed(evt);
            }
        });

        editar.setBackground(new java.awt.Color(204, 204, 204));
        editar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icons/CRUD/edit.png"))); // NOI18N
        editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editarActionPerformed(evt);
            }
        });

        borrar.setBackground(new java.awt.Color(204, 204, 204));
        borrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icons/CRUD/dustbin.png"))); // NOI18N
        borrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                borrarActionPerformed(evt);
            }
        });

        buscar.setBackground(new java.awt.Color(204, 204, 204));
        buscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icons/CRUD/searching-magnifying-glass.png"))); // NOI18N
        buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarActionPerformed(evt);
            }
        });

        volver.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icons/CRUD/volver.png"))); // NOI18N
        volver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                volverActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addComponent(volver)
                .addGap(71, 71, 71)
                .addComponent(nuevo)
                .addGap(79, 79, 79)
                .addComponent(editar)
                .addGap(72, 72, 72)
                .addComponent(buscar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 75, Short.MAX_VALUE)
                .addComponent(borrar)
                .addGap(42, 42, 42))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(borrar)
                    .addComponent(buscar)
                    .addComponent(editar)
                    .addComponent(nuevo)
                    .addComponent(volver))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 100));

        fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icons/FondoAzul.png"))); // NOI18N
        getContentPane().add(fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 810, 510));

        empleado_id.setText("jLabel1");
        getContentPane().add(empleado_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 300, 100, -1));

        guardar.setBackground(new java.awt.Color(204, 204, 204));
        guardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icons/CRUD/save-icon-silhouette.png"))); // NOI18N
        guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarActionPerformed(evt);
            }
        });
        getContentPane().add(guardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 10, -1, -1));

        jMenu1.setText("File");

        mnuSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icons/exit-sign.png"))); // NOI18N
        mnuSalir.setMnemonic(KeyEvent.VK_X);
        mnuSalir.setText("Salir");
        mnuSalir.setBorderPainted(false);
        mnuSalir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        mnuSalir.setName(""); // NOI18N
        mnuSalir.addMenuKeyListener(new javax.swing.event.MenuKeyListener() {
            public void menuKeyPressed(javax.swing.event.MenuKeyEvent evt) {
                mnuSalirMenuKeyPressed(evt);
            }
            public void menuKeyReleased(javax.swing.event.MenuKeyEvent evt) {
            }
            public void menuKeyTyped(javax.swing.event.MenuKeyEvent evt) {
            }
        });
        mnuSalir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mnuSalirMouseClicked(evt);
            }
        });
        jMenu1.add(mnuSalir);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mnuSalirMenuKeyPressed(javax.swing.event.MenuKeyEvent evt) {//GEN-FIRST:event_mnuSalirMenuKeyPressed


    }//GEN-LAST:event_mnuSalirMenuKeyPressed

    private void mnuSalirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mnuSalirMouseClicked
        // TODO add your handling code here:
        dispose();

    }//GEN-LAST:event_mnuSalirMouseClicked

    private void nuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nuevoActionPerformed
        // TODO add your handling code here:
        txtFechaDespido.setEnabled(false);
        cmbHorario.setEnabled(true);
        cmbTipoPuesto.setEnabled(true);

        txtPhone.setEnabled(true);
        txtClasificación.setEnabled(true);
        txtFechaContrato.setEnabled(true);

        empleado_id.setText("");
        txtFechaDespido.setText("");
        txtPhone.setText("");
        txtClasificación.setText("");
        txtPhone.setText("");
        txtFechaDespido.requestDefaultFocus();
        nuevo.setEnabled(false);
        guardar.setEnabled(true);
        buscar.setEnabled(false);
        editar.setEnabled(false);
        borrar.setEnabled(false);
    }//GEN-LAST:event_nuevoActionPerformed

    private void guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarActionPerformed
        // TODO add your handling code here:
        try {
            int P = JOptionPane.showConfirmDialog(null, " Quiere agregar otro dato ?", "Confirmación", JOptionPane.YES_NO_OPTION);
            if (P == 0) {
                con = ConexionDB.conexionDB();

                if (txtFechaDespido.getText().equals("")) {
                    JOptionPane.showMessageDialog(this, "Favor ingresa el Nombre y Apellidos ", "Error", JOptionPane.ERROR_MESSAGE);
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
                if (txtFechaContrato.getText().equals("")) {
                    JOptionPane.showMessageDialog(this, "Favor ingresa el número de cédula!", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                Statement stmt;
                stmt = con.createStatement();

                String sql1 = sqlSelect_Valor + txtFechaDespido.getText() + "'";
                rs = stmt.executeQuery(sql1);
                if (rs.next()) {
                    JOptionPane.showMessageDialog(this, "Valor ya existe.", "Error", JOptionPane.ERROR_MESSAGE);
                    txtFechaDespido.setText("");
                    txtFechaDespido.requestDefaultFocus();
                    return;
                }
                //                      `nombre`,                               `cedula`,                       `telefono`, `direccion`, `tipo_persona_idtipo_persona`
                String sql = sqlInsert + txtFechaDespido.getText() + "','" + txtFechaContrato.getText() + "','" + txtPhone.getText() + "','" + txtClasificación.getText() + "')";
                pst = con.prepareStatement(sql);
                pst.execute();
                JOptionPane.showMessageDialog(this, "Guardado con Exito saved", "Gasto Operativo", JOptionPane.INFORMATION_MESSAGE);
                txtFechaDespido.setText("");

            }
            if (P == 1) {
                String sql = sqlInsert + txtFechaDespido.getText() + "','" + txtFechaContrato.getText() + "','" + txtPhone.getText() + "','" + txtClasificación.getText() + "')";
                pst = con.prepareStatement(sql);
                pst.execute();
                JOptionPane.showMessageDialog(this, "Guardado con Exito saved", "Gasto Operativo", JOptionPane.INFORMATION_MESSAGE);
                txtFechaDespido.setText("");

            }

        } catch (HeadlessException | SQLException ex) {
            JOptionPane.showMessageDialog(this, ex);

        }

    }//GEN-LAST:event_guardarActionPerformed

    private void editarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editarActionPerformed
        // TODO add your handling code here:

        try {
            int P = JOptionPane.showConfirmDialog(null, " Quiere editar este dato ?", "Confirmación", JOptionPane.YES_NO_OPTION);
            if (P == 0) {
                con = ConexionDB.conexionDB();
                Statement stmt;
                stmt = con.createStatement();

                String Pru = "UPDATE `persona` SET `nombre` = '" + txtFechaDespido.getText() + "',`cedula` = '" + txtFechaContrato.getText() + "', `telefono` = '" + txtPhone.getText() + "',`direccion`='" + txtPhone.getText() + "',`tipo_persona_idtipo_persona`='" + txtClasificación.getText() + "' WHERE `idpersona`='" + empleado_id.getText() + "'";
                pst = con.prepareStatement(Pru);
                pst.execute();
                JOptionPane.showMessageDialog(this, "Guardado con Exito saved", "Tipo de Usuario", JOptionPane.INFORMATION_MESSAGE);
                txtFechaDespido.setText("");

                if (P == 1) {
                    txtFechaDespido.setText("");

                }
            }

        } catch (HeadlessException | SQLException ex) {
            JOptionPane.showMessageDialog(this, ex);

        }

    }//GEN-LAST:event_editarActionPerformed

    public void accion_buscar() {
        txtFechaDespido.setEnabled(true);

        txtPhone.setEnabled(true);
        txtClasificación.setEnabled(true);
        txtFechaContrato.setEnabled(true);

        txtFechaDespido.setText("");

        txtPhone.setText("");
        txtClasificación.setText("");
        txtFechaContrato.setText("");

        nuevo.setEnabled(false);
        guardar.setEnabled(false);
        buscar.setEnabled(false);
        editar.setEnabled(false);
        borrar.setEnabled(false);
    }
    private void buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarActionPerformed
        // TODO add your handling code here:
        Buscar_Persona_frm buscar_Persona_frm;
        try {
            buscar_Persona_frm = new Buscar_Persona_frm();
            buscar_Persona_frm.setVisible(true);
        } catch (IOException ex) {
            Logger.getLogger(Colaborador_frm.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_buscarActionPerformed

    private void borrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_borrarActionPerformed
        // TODO add your handling code here:
        try {
            int P = JOptionPane.showConfirmDialog(null, " Seguro que quiere eliminar ?", "Confirmation", JOptionPane.YES_NO_OPTION);
            if (P == 0) {
                con = ConexionDB.conexionDB();
                //DELETE FROM `Horario_frm` WHERE `horario_id` = 4
                String sql = sqlDelete + empleado_id.getText() + "";
                //String sql = "DELETE FROM `horario` WHERE `horario_id`='" + lbl_Horario_id.getText() + "'";
                pst = con.prepareStatement(sql);
                pst.execute();
                JOptionPane.showMessageDialog(this, "Successfully deleted", "Record", JOptionPane.INFORMATION_MESSAGE);
                initState();

            }
            initState();

        } catch (HeadlessException | SQLException ex) {
            JOptionPane.showMessageDialog(this, ex);

        }
    }//GEN-LAST:event_borrarActionPerformed

    private void volverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_volverActionPerformed
        // TODO add your handling code here:
        initState();
    }//GEN-LAST:event_volverActionPerformed

    private void txtFechaContratoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFechaContratoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFechaContratoActionPerformed

    private void cmbTipoPuestoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbTipoPuestoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbTipoPuestoActionPerformed

    private void chk_ActivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chk_ActivoActionPerformed
        // TODO add your handling code here:
        if (!chk_Activo.isSelected()) {
            txtFechaDespido.setEnabled(true);
        } else {
            txtFechaDespido.setEnabled(false);
        }


    }//GEN-LAST:event_chk_ActivoActionPerformed

    private void dcFechaContratoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dcFechaContratoMouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_dcFechaContratoMouseClicked

    private void dcFechaContratoPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_dcFechaContratoPropertyChange
        try {
            String formato = dcFechaContrato.getDateFormatString();
            //Formato
            Date date = dcFechaContrato.getDate();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            txtFechaContrato.setText(sdf.format(date));
        } catch (NullPointerException ex) {
            JOptionPane.showMessageDialog(this, "Al menos selecciona una fecha válida!", "Error!", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_dcFechaContratoPropertyChange

    private void dcFechaContratoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dcFechaContratoMousePressed
        // TODO add your handling code here:
        try {
            String formato = dcFechaContrato.getDateFormatString();
            //Formato
            Date date = dcFechaContrato.getDate();
            SimpleDateFormat sdf = new SimpleDateFormat(formato);
            txtFechaContrato.setText(sdf.format(date));
        } catch (NullPointerException ex) {
            JOptionPane.showMessageDialog(this, "Al menos selecciona una fecha válida!", "Error!", JOptionPane.INFORMATION_MESSAGE);

        }

    }//GEN-LAST:event_dcFechaContratoMousePressed

    private void dcFechaContratoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dcFechaContratoMouseEntered
        // TODO add your handling code here:
        try {
            String formato = dcFechaContrato.getDateFormatString();
            //Formato
            Date date = dcFechaContrato.getDate();
            SimpleDateFormat sdf = new SimpleDateFormat(formato);
            txtFechaContrato.setText(sdf.format(date));
        } catch (NullPointerException ex) {
            JOptionPane.showMessageDialog(this, "Al menos selecciona una fecha válida!", "Error!", JOptionPane.INFORMATION_MESSAGE);

        }
    }//GEN-LAST:event_dcFechaContratoMouseEntered

    private void dcFechaContrato1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dcFechaContrato1MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_dcFechaContrato1MousePressed

    private void dcFechaContrato1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dcFechaContrato1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_dcFechaContrato1MouseClicked

    private void dcFechaContrato1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dcFechaContrato1MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_dcFechaContrato1MouseEntered

    private void dcFechaContrato1PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_dcFechaContrato1PropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_dcFechaContrato1PropertyChange

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
            java.util.logging.Logger.getLogger(Colaborador_frm.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            try {
                new Colaborador_frm().setVisible(true);

            } catch (IOException ex) {
                Logger.getLogger(Colaborador_frm.class
                        .getName()).log(Level.SEVERE, null, ex);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Persona;
    private javax.swing.JButton borrar;
    private javax.swing.JButton buscar;
    private javax.swing.JCheckBox chk_Activo;
    private javax.swing.JComboBox<String> cmbHorario;
    private javax.swing.JComboBox<String> cmbTipoPuesto;
    private com.toedter.calendar.JDateChooser dcFechaContrato;
    private com.toedter.calendar.JDateChooser dcFechaContrato1;
    private javax.swing.JButton editar;
    private javax.swing.JLabel empleado_id;
    private javax.swing.JLabel fondo;
    private javax.swing.JButton guardar;
    public static javax.swing.JLabel id_persona;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JMenu mnuSalir;
    private javax.swing.JButton nuevo;
    private javax.swing.JTextField txtClasificación;
    private javax.swing.JTextField txtFechaContrato;
    private javax.swing.JTextField txtFechaDespido;
    private javax.swing.JTextField txtPhone;
    private javax.swing.JButton volver;
    // End of variables declaration//GEN-END:variables

    void setLbl_id_persona() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
