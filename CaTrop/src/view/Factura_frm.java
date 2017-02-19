/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import com.sun.glass.events.KeyEvent;
import controller.ConexionDB;
import java.awt.HeadlessException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import static view.Prueba_frm.jLabel1;

/**
 *
 * @author ace
 */
public final class Factura_frm extends javax.swing.JFrame {

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

    public Factura_frm() throws IOException {
        initComponents();

        //inicialización de las variables de la coneccion a la base de datos
        con = ConexionDB.conexionDB();
        //llama al procedimiento de obtener la información.

        //centra la ventana para que se inicie en el centro del escritorio
        setLocationRelativeTo(null);

        sqlSelect = "SELECT `idpersona`, `nombre`, `cedula`, `telefono`, `direccion`, `tipo_persona_idtipo_persona` FROM `persona` order BY `nombre`";
        sqlSelect_Valor = "SELECT `idpersona`, `nombre`, `cedula`, `telefono`, `direccion`, `tipo_persona_idtipo_persona` FROM `persona` WHERE `nombre` = '";
        sqlInsert = "INSERT INTO `persona`(`nombre`, `cedula`, `telefono`, `direccion`, `tipo_persona_idtipo_persona`) VALUES ('";
        sqlDelete = "DELETE FROM `persona` WHERE `idpersona` = ";

        modeloPuesto = new DefaultComboBoxModel();
        modeloHorario = new DefaultComboBoxModel();

        llena_ComboHorario(); // llenar los datos al ejecutar el programa
        llena_ComboPuesto();
        LlenaCabina();
    }

    public void llena_ComboPuesto() {
        try {
            modeloPuesto.removeAllElements(); // eliminamos lo elementos

            Statement stmt;
            stmt = con.createStatement();

            String sql1 = "SELECT `nombre` FROM `persona` ";
            rs = stmt.executeQuery(sql1);

            while (rs.next()) {
                modeloPuesto.addElement(rs.getString("nombre"));
            }
            cmbTipoPuesto.setModel(modeloPuesto); // seteamos el modelo y se cargan los datos

        } catch (HeadlessException | SQLException ex) {
            JOptionPane.showMessageDialog(this, ex);
        }
    }

    public void LlenaCabina() {
        try {
            //thane'
            String sql_persona = "SELECT `cabina`.`cabina_id` as 'id', `cabina`.`descripcion_cabina` as 'Cabina', `cabina`.`estado_cabina` as 'Estado', `cabina`.`precio_precio_id`, `precio`.`descripcion_precio`, `precio`.`monto_precio` as 'Monto' FROM `pct3`.`cabina` AS `cabina`, `pct3`.`precio` AS `precio` WHERE `cabina`.`precio_precio_id` = `precio`.`precio_id` AND `cabina`.`descripcion_cabina` = '" + NombreCabina.getText() + "'";
            pst = con.prepareStatement(sql_persona);
            rs = pst.executeQuery();
            if (rs.next()) {
                String add1 = rs.getString("id");
                String add2 = rs.getString("Cabina");
                String add3 = rs.getString("Estado");
                String add4 = rs.getString("Monto");

                PrecioCabina.setText(add4);
                EstadoCabina.setText(add3);

                IdCabina.setText(add1);

            }

        } catch (SQLException | NumberFormatException e) {
            JOptionPane.showMessageDialog(null, e);

        }
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
            cmbPersona.setModel(modeloHorario); // seteamos el modelo y se cargan los datos

        } catch (HeadlessException | SQLException ex) {
            JOptionPane.showMessageDialog(this, ex);
        }
    }

    public void fechas() {
        Date h = new Date();
        //SimpleDateFormat formato_Fecha = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        String date = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        SimpleDateFormat formato_Hora = new SimpleDateFormat("HH:mm:ss a", Locale.getDefault());
        //fechahora = new Date();

        //return formato_Fecha.format(fec);
        System.out.println(formato_Hora.format(h));
        txtFecha.setText(date);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grupo_clientes = new javax.swing.ButtonGroup();
        jPanel3 = new javax.swing.JPanel();
        empleado_id = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        rb_Cliente = new javax.swing.JRadioButton();
        rb_Empresa = new javax.swing.JRadioButton();
        rb_Gobierno = new javax.swing.JRadioButton();
        cmbPersona = new javax.swing.JComboBox<>();
        cmbTipoPuesto = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtFecha = new javax.swing.JTextField();
        lblCabina = new javax.swing.JLabel();
        NombreCabina = new javax.swing.JLabel();
        Nombre_Empleado = new javax.swing.JLabel();
        txSubTotal = new javax.swing.JTextField();
        txtImpuesto = new javax.swing.JTextField();
        txTotal = new javax.swing.JTextField();
        jSpinner1 = new javax.swing.JSpinner();
        PrecioCabina2 = new javax.swing.JLabel();
        PrecioCabina5 = new javax.swing.JLabel();
        PrecioCabina6 = new javax.swing.JLabel();
        EstadoCabina = new javax.swing.JLabel();
        PrecioCabina = new javax.swing.JLabel();
        PrecioCabina4 = new javax.swing.JLabel();
        IdCabina = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        guardar = new javax.swing.JButton();
        editar = new javax.swing.JButton();
        borrar = new javax.swing.JButton();
        buscar = new javax.swing.JButton();
        volver = new javax.swing.JButton();
        fondo = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        mnuSalir = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Factura");
        setMinimumSize(new java.awt.Dimension(818, 401));
        setUndecorated(true);
        setResizable(false);
        setType(java.awt.Window.Type.UTILITY);
        addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                formFocusGained(evt);
            }
        });
        addWindowFocusListener(new java.awt.event.WindowFocusListener() {
            public void windowGainedFocus(java.awt.event.WindowEvent evt) {
                formWindowGainedFocus(evt);
            }
            public void windowLostFocus(java.awt.event.WindowEvent evt) {
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setOpaque(false);

        empleado_id.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        empleado_id.setText("Nombre Cliente");

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED), "Tipo Cliente", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 16))); // NOI18N
        jPanel2.setOpaque(false);

        grupo_clientes.add(rb_Cliente);
        rb_Cliente.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        rb_Cliente.setForeground(new java.awt.Color(255, 255, 255));
        rb_Cliente.setText("Empresarial");
        rb_Cliente.setOpaque(false);

        grupo_clientes.add(rb_Empresa);
        rb_Empresa.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        rb_Empresa.setForeground(new java.awt.Color(255, 255, 255));
        rb_Empresa.setText("Gubernamental");
        rb_Empresa.setOpaque(false);

        grupo_clientes.add(rb_Gobierno);
        rb_Gobierno.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        rb_Gobierno.setForeground(new java.awt.Color(255, 255, 255));
        rb_Gobierno.setText("Normal");
        rb_Gobierno.setOpaque(false);
        rb_Gobierno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb_GobiernoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 158, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(rb_Gobierno)
                        .addComponent(rb_Cliente)
                        .addComponent(rb_Empresa))
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 110, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(rb_Gobierno)
                    .addGap(10, 10, 10)
                    .addComponent(rb_Cliente)
                    .addGap(10, 10, 10)
                    .addComponent(rb_Empresa)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        cmbPersona.setFont(new java.awt.Font("Dialog", 1, 16));
        cmbPersona.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cmbTipoPuesto.setFont(new java.awt.Font("Dialog", 1, 16));
        cmbTipoPuesto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbTipoPuesto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbTipoPuestoActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jLabel9.setText("Empleado:");

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jLabel7.setText("Fecha Factura");

        txtFecha.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        txtFecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFechaActionPerformed(evt);
            }
        });

        lblCabina.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblCabina.setText("N° Cabina");

        NombreCabina.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        NombreCabina.setText("jLabel1");

        Nombre_Empleado.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        Nombre_Empleado.setText("Nombre Empleado");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(cmbTipoPuesto, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbPersona, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(31, 31, 31)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel7)
                                            .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(26, 26, 26)
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lblCabina)
                                            .addComponent(NombreCabina)))
                                    .addComponent(jLabel9)
                                    .addComponent(Nombre_Empleado)))
                            .addComponent(empleado_id, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 190, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(lblCabina)
                                .addGap(8, 8, 8)
                                .addComponent(NombreCabina)
                                .addGap(55, 55, 55))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(11, 11, 11)
                                .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel9)))
                        .addGap(18, 18, 18)
                        .addComponent(Nombre_Empleado)
                        .addGap(44, 44, 44)))
                .addComponent(empleado_id, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbPersona, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbTipoPuesto, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 10, 750, 280));

        txSubTotal.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        txSubTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txSubTotalActionPerformed(evt);
            }
        });
        getContentPane().add(txSubTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 330, 210, 40));

        txtImpuesto.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        txtImpuesto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtImpuestoActionPerformed(evt);
            }
        });
        getContentPane().add(txtImpuesto, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 380, 210, 40));

        txTotal.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        txTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txTotalActionPerformed(evt);
            }
        });
        getContentPane().add(txTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 430, 210, 40));

        jSpinner1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jSpinner1.setModel(new javax.swing.SpinnerNumberModel(1, 1, 30, 1));
        jSpinner1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSpinner1StateChanged(evt);
            }
        });
        getContentPane().add(jSpinner1, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 290, -1, -1));

        PrecioCabina2.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        PrecioCabina2.setForeground(new java.awt.Color(255, 255, 255));
        PrecioCabina2.setText("Sub Total: ");
        getContentPane().add(PrecioCabina2, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 340, -1, -1));

        PrecioCabina5.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        PrecioCabina5.setText("Cantidad de Días:");
        getContentPane().add(PrecioCabina5, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 290, -1, -1));

        PrecioCabina6.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        PrecioCabina6.setText("Total:");
        getContentPane().add(PrecioCabina6, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 440, -1, -1));

        EstadoCabina.setText("jLabel1");
        getContentPane().add(EstadoCabina, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 390, -1, -1));

        PrecioCabina.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        PrecioCabina.setText("Impuesto:");
        getContentPane().add(PrecioCabina, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 390, -1, -1));

        PrecioCabina4.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        PrecioCabina4.setText("jLabel1");
        getContentPane().add(PrecioCabina4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 340, -1, -1));

        IdCabina.setText("jLabel1");
        getContentPane().add(IdCabina, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 370, -1, -1));

        guardar.setBackground(new java.awt.Color(204, 204, 204));
        guardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icons/CRUD/save-icon-silhouette.png"))); // NOI18N
        guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarActionPerformed(evt);
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
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(editar)
                            .addComponent(volver))
                        .addGap(0, 1, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(guardar, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(buscar, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(borrar, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(volver)
                .addGap(18, 18, 18)
                .addComponent(guardar)
                .addGap(18, 18, 18)
                .addComponent(editar)
                .addGap(18, 18, 18)
                .addComponent(buscar)
                .addGap(18, 18, 18)
                .addComponent(borrar)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 90, 330));

        fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icons/FondoAzul.png"))); // NOI18N
        getContentPane().add(fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 870, 500));

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

    private void guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarActionPerformed
        // TODO add your handling code here:
        try {
            int P = JOptionPane.showConfirmDialog(null, " Quiere agregar otro dato ?", "Confirmación", JOptionPane.YES_NO_OPTION);
            if (P == 0) {
                con = ConexionDB.conexionDB();

                if (txtFecha.getText().equals("")) {
                    JOptionPane.showMessageDialog(this, "Favor ingresa el Nombre y Apellidos ", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                Statement stmt;
                stmt = con.createStatement();

                String sql1 = sqlSelect_Valor + txtFecha.getText() + "'";
                rs = stmt.executeQuery(sql1);
                if (rs.next()) {
                    JOptionPane.showMessageDialog(this, "Valor ya existe.", "Error", JOptionPane.ERROR_MESSAGE);
                    txtFecha.setText("");
                    txtFecha.requestDefaultFocus();
                    return;
                }
                //                      `nombre`,                               `cedula`,                       `telefono`, `direccion`, `tipo_persona_idtipo_persona`
                String sql = sqlInsert + txtFecha.getText() + "','" + txtFecha.getText() + "','" + txtFecha.getText() + "','" + txtFecha.getText() + "')";
                pst = con.prepareStatement(sql);
                pst.execute();
                JOptionPane.showMessageDialog(this, "Guardado con Exito saved", "Gasto Operativo", JOptionPane.INFORMATION_MESSAGE);
                txtFecha.setText("");

            }
            if (P == 1) {
                String sql = sqlInsert + txtFecha.getText() + "','" + txtFecha.getText() + "','" + txtFecha.getText() + "','" + txtFecha.getText() + "')";
                pst = con.prepareStatement(sql);
                pst.execute();
                JOptionPane.showMessageDialog(this, "Guardado con Exito saved", "Gasto Operativo", JOptionPane.INFORMATION_MESSAGE);
                txtFecha.setText("");

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

                String Pru = "UPDATE `persona` SET `nombre` = '" + txtFecha.getText() + "',`cedula` = '" + txtFecha.getText() + "', `telefono` = '" + txtFecha.getText() + "',`direccion`='" + txtFecha.getText() + "',`tipo_persona_idtipo_persona`='" + txtFecha.getText() + "' WHERE `idpersona`='" + empleado_id.getText() + "'";
                pst = con.prepareStatement(Pru);
                pst.execute();
                JOptionPane.showMessageDialog(this, "Guardado con Exito saved", "Tipo de Usuario", JOptionPane.INFORMATION_MESSAGE);
                txtFecha.setText("");

                if (P == 1) {
                    txtFecha.setText("");

                }
            }

        } catch (HeadlessException | SQLException ex) {
            JOptionPane.showMessageDialog(this, ex);

        }

    }//GEN-LAST:event_editarActionPerformed

    public void accion_buscar() {

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
            Logger.getLogger(Factura_frm.class.getName()).log(Level.SEVERE, null, ex);
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

            }

        } catch (HeadlessException | SQLException ex) {
            JOptionPane.showMessageDialog(this, ex);

        }
    }//GEN-LAST:event_borrarActionPerformed

    private void volverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_volverActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_volverActionPerformed

    private void txtFechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFechaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFechaActionPerformed

    private void rb_GobiernoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb_GobiernoActionPerformed
        // TODO add your handling code here:
        cmbPersona.setVisible(true);
    }//GEN-LAST:event_rb_GobiernoActionPerformed

    private void formFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_formFocusGained
        // TODO add your handling code here:
        LlenaCabina();
    }//GEN-LAST:event_formFocusGained

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
        // TODO add your handling code here:
        LlenaCabina();
    }//GEN-LAST:event_formWindowGainedFocus

    private void txTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txTotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txTotalActionPerformed

    private void jSpinner1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSpinner1StateChanged
        // TODO add your handling code here:
        float Calculo, monto, dias, impuesto, subtotal;

        monto = Float.parseFloat(PrecioCabina.getText());
        dias = (Integer) jSpinner1.getValue();

        Calculo = monto * dias;

        impuesto = Calculo/13;
        
        subtotal = Calculo - impuesto;

        txtImpuesto.setText(String.valueOf(impuesto));
        txTotal.setText(String.valueOf(Calculo));
        txSubTotal.setText(String.valueOf(subtotal));

    }//GEN-LAST:event_jSpinner1StateChanged

    private void txSubTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txSubTotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txSubTotalActionPerformed

    private void txtImpuestoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtImpuestoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtImpuestoActionPerformed

    private void cmbTipoPuestoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbTipoPuestoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbTipoPuestoActionPerformed

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
            java.util.logging.Logger.getLogger(Factura_frm.class
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
                new Factura_frm().setVisible(true);

            } catch (IOException ex) {
                Logger.getLogger(Factura_frm.class
                        .getName()).log(Level.SEVERE, null, ex);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JLabel EstadoCabina;
    private javax.swing.JLabel IdCabina;
    public static javax.swing.JLabel NombreCabina;
    public static javax.swing.JLabel Nombre_Empleado;
    public static javax.swing.JLabel PrecioCabina;
    public static javax.swing.JLabel PrecioCabina2;
    public static javax.swing.JLabel PrecioCabina4;
    public static javax.swing.JLabel PrecioCabina5;
    public static javax.swing.JLabel PrecioCabina6;
    private javax.swing.JButton borrar;
    private javax.swing.JButton buscar;
    private javax.swing.JComboBox<String> cmbPersona;
    private javax.swing.JComboBox<String> cmbTipoPuesto;
    private javax.swing.JButton editar;
    private javax.swing.JLabel empleado_id;
    private javax.swing.JLabel fondo;
    private javax.swing.ButtonGroup grupo_clientes;
    private javax.swing.JButton guardar;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JLabel lblCabina;
    private javax.swing.JMenu mnuSalir;
    private javax.swing.JRadioButton rb_Cliente;
    private javax.swing.JRadioButton rb_Empresa;
    private javax.swing.JRadioButton rb_Gobierno;
    private javax.swing.JTextField txSubTotal;
    private javax.swing.JTextField txTotal;
    private javax.swing.JTextField txtFecha;
    private javax.swing.JTextField txtImpuesto;
    private javax.swing.JButton volver;
    // End of variables declaration//GEN-END:variables

    void setLbl_id_persona() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
