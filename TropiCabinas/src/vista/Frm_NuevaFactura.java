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
import java.text.DateFormat;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

/**
 *
 * @author Eisner López Acevedo <eisner.lopez at gmail.com>
 */
public final class Frm_NuevaFactura extends javax.swing.JInternalFrame {

    /**
     * Creates new form Frm_NuevaFactura
     */
    Connection con = null;
    
    ResultSet rs = null;
    PreparedStatement pst = null;
    ResultSet rs2 = null;
    PreparedStatement pst2 = null;
    
    DateFormat df = DateFormat.getDateInstance();
    public String Valor;
    //declarar static e instanciarla en tu contructor`
    static DefaultComboBoxModel modeloTipoPersona;
    
    public Frm_NuevaFactura() {
        initComponents();
        con = DBConnection.getConnection();
        nCabina.setText(Seleccionar_Cabina_frm.ps_nombreCabina);
        nombreEmpleado.setText(Login_frm.ps_NombreEmpleado);
        idEmpleado.setText(Login_frm.ps_idEmpleado);
        //idCabina.setVisible(false);
        fechaActual();
        fechas();
        modeloTipoPersona = new DefaultComboBoxModel();
        llena_comboPersona(); // llenar los datos al ejecutar el programa
    }
    
    public void llena_comboPersona() { // static para poder llamarlo desde el otro frame o JDialog
        try {
            modeloTipoPersona.removeAllElements(); // eliminamos lo elementos
            Statement stmt;
            stmt = con.createStatement();
            String queryComboEstado = "SELECT "
                    + "empresa_id, codigo_cliente, nombre "
                    + "FROM "
                    + "pct3.cliente_empresa "
                    + "INNER JOIN "
                    + "pct3.persona ON cliente_empresa.persona_idpersona = persona.idpersona";
            rs = stmt.executeQuery(queryComboEstado);
            while (rs.next()) {
                modeloTipoPersona.addElement(rs.getString("nombre"));
                codigoCliente.setText(rs.getString("empresa_id"));
                
            }
            
        } catch (HeadlessException | SQLException ex) {
            JOptionPane.showMessageDialog(this, ex);
        }
    }
    
    public void fechas() {
        Date h = new Date();
        SimpleDateFormat formato_Fecha;
        formato_Fecha = new SimpleDateFormat("yyyy/MM/dd", Locale.getDefault());
        String date = new SimpleDateFormat("yyyy/MM/dd").format(new Date());
        SimpleDateFormat formato_Hora;
        formato_Hora = new SimpleDateFormat("HH:mm:ss a", Locale.getDefault());
        //formato_Fecha.format(h)) Imprime el tiempo formateado 
        Valor = date;
        fechaEntrada.setText(Valor);
    }
    
    public void fechaActual() {
        Date hoy;
        hoy = new Date();
        String date = new SimpleDateFormat("yyyy/MM/dd", Locale.getDefault()).format(new Date());
//        jDateChooser1.setDateFormatString(date);
//        jDateChooser1.setDate(hoy);
//        Valor = jDateChooser1.getDateFormatString();
        System.out.println(Valor);
        fechaEntrada.setText(Valor);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        lblImpuesto = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        impuesto = new javax.swing.JTextField();
        subTotal = new javax.swing.JTextField();
        precioTotal = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        nombreCliente = new javax.swing.JLabel();
        nombreCliente1 = new javax.swing.JLabel();
        idCliente = new javax.swing.JLabel();
        codigoCliente = new javax.swing.JLabel();
        idCabina = new javax.swing.JLabel();
        idCabina1 = new javax.swing.JLabel();
        idEmpleado = new javax.swing.JLabel();
        idEmpleado1 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        lblFechaEntrada = new javax.swing.JLabel();
        fechaEntrada = new javax.swing.JLabel();
        lblCantDias = new javax.swing.JLabel();
        CantidadDias = new javax.swing.JFormattedTextField();
        jLabel3 = new javax.swing.JLabel();
        fechaSalida = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        Precio = new javax.swing.JFormattedTextField();
        jLabel2 = new javax.swing.JLabel();
        txtNombreCliente = new javax.swing.JTextField();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jButton1 = new javax.swing.JButton();
        nombreEmpleado = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        borrar = new javax.swing.JButton();
        guardar = new javax.swing.JButton();
        volver = new javax.swing.JButton();
        nCabina = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        numeroFactura = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setTitle("Facturar");

        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lblImpuesto.setText("Impuesto:");

        jLabel9.setText("Total:");

        jLabel10.setText("Sub Total:");

        impuesto.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        impuesto.setEnabled(false);

        subTotal.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        subTotal.setEnabled(false);

        precioTotal.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        precioTotal.setEnabled(false);

        nombreCliente.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nombreCliente.setText("nombreCliente");

        nombreCliente1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nombreCliente1.setText("nombreCliente");

        idCliente.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        idCliente.setText("idCliente");

        codigoCliente.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        codigoCliente.setText("idCliente");

        idCabina.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        idCabina.setText("idCabina");

        idCabina1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        idCabina1.setText("idCabina");

        idEmpleado.setText("idEmpleado");

        idEmpleado1.setText("idEmpleado");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nombreCliente)
                    .addComponent(nombreCliente1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(idCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(codigoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(idCabina, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(idCabina1, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(idEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(idEmpleado1, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(28, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {idCabina, idCliente, idEmpleado, nombreCliente});

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {codigoCliente, idCabina1, idEmpleado1, nombreCliente1});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(nombreCliente)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(nombreCliente1)
                            .addComponent(codigoCliente)))
                    .addComponent(idCliente))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(idCabina)
                    .addComponent(idEmpleado))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(idEmpleado1)
                    .addComponent(idCabina1))
                .addGap(25, 25, 25))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {idCabina, idCliente, idEmpleado, nombreCliente});

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblImpuesto)
                    .addComponent(jLabel10)
                    .addComponent(jLabel9))
                .addGap(32, 32, 32)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(impuesto)
                    .addComponent(subTotal)
                    .addComponent(precioTotal, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblImpuesto)
                            .addComponent(impuesto, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(subTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                                .addComponent(jLabel9)
                                .addGap(31, 31, 31))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(precioTotal)
                                .addContainerGap())))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );

        jPanel4.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(33, 206, -1, -1));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel4.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 325, -1, -1));

        lblFechaEntrada.setText("Fecha Entrada:");
        jPanel4.add(lblFechaEntrada, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 56, -1, -1));

        fechaEntrada.setFont(new java.awt.Font("Hack", 1, 14)); // NOI18N
        fechaEntrada.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        fechaEntrada.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel4.add(fechaEntrada, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 176, 26));

        lblCantDias.setText("Cantidad de Días:");
        jPanel4.add(lblCantDias, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, -1, 20));

        CantidadDias.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("###0"))));
        CantidadDias.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                CantidadDiasFocusLost(evt);
            }
        });
        CantidadDias.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                CantidadDiasKeyPressed(evt);
            }
        });
        jPanel4.add(CantidadDias, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, 176, 30));

        jLabel3.setText("Fecha Salida:");
        jPanel4.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 50, -1, 20));

        fechaSalida.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel4.add(fechaSalida, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 80, 176, 26));

        jLabel1.setFont(new java.awt.Font("Hack", 1, 14)); // NOI18N
        jLabel1.setText("Precio:");
        jPanel4.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 120, 176, 28));

        Precio.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("###0"))));
        Precio.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                PrecioFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                PrecioFocusLost(evt);
            }
        });
        jPanel4.add(Precio, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 160, 176, 28));

        jLabel2.setText("Nombre del Cliente:");
        jPanel4.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        txtNombreCliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNombreClienteKeyPressed(evt);
            }
        });
        jPanel4.add(txtNombreCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 10, 270, 30));

        jDateChooser1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jDateChooser1MouseClicked(evt);
            }
        });
        jDateChooser1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jDateChooser1KeyTyped(evt);
            }
        });
        jPanel4.add(jDateChooser1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 80, 170, 30));

        jButton1.setText("jButton1");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 140, -1, -1));

        nombreEmpleado.setFont(new java.awt.Font("Hack", 1, 14)); // NOI18N
        nombreEmpleado.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nombreEmpleado.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.lightGray, java.awt.Color.darkGray));

        jLabel14.setFont(new java.awt.Font("Hack", 1, 12)); // NOI18N
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("Nombre Cabina");
        jLabel14.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.lightGray, java.awt.Color.darkGray));

        jLabel16.setFont(new java.awt.Font("Hack", 1, 12)); // NOI18N
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText("Nombre Colaborador");
        jLabel16.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.lightGray, java.awt.Color.darkGray));

        borrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/compose_64px.png"))); // NOI18N
        borrar.setToolTipText("Vaciar los Campos");
        borrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                borrarActionPerformed(evt);
            }
        });

        guardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/book_64px.png"))); // NOI18N
        guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarActionPerformed(evt);
            }
        });

        volver.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/Inicio.png"))); // NOI18N
        volver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                volverActionPerformed(evt);
            }
        });

        nCabina.setFont(new java.awt.Font("Hack", 1, 14)); // NOI18N
        nCabina.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nCabina.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.lightGray, java.awt.Color.darkGray));

        jLabel5.setText("Factura #");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(36, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel16)
                            .addComponent(nombreEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(borrar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel14)
                            .addComponent(nCabina, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(guardar)
                        .addGap(18, 18, 18)
                        .addComponent(volver)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(50, 50, 50)
                                .addComponent(numeroFactura))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel5)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 639, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel14)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(nCabina, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(borrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(nombreEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(volver, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE)
                        .addComponent(guardar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addComponent(numeroFactura)))
                .addGap(18, 18, 18)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(29, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void CantidadDiasFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_CantidadDiasFocusLost
        // TODO add your handling code here:
        Calendar c1 = GregorianCalendar.getInstance();
        System.out.println("Fecha actual: " + c1.getTime().toLocaleString());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        System.out.println("Fecha Formateada: " + sdf.format(c1.getTime()));
        sdf = new SimpleDateFormat("yyyy/MM/dd");
        System.out.println("Fecha Formateada: " + sdf.format(c1.getTime()));
        int valorDias = Integer.parseInt(CantidadDias.getText());
        if (CantidadDias.getText() == null) {
            JOptionPane.showMessageDialog(null, "Ingrese un valor mayor a 1");
            CantidadDias.requestFocus();
        }
        System.out.println("" + valorDias);
        c1.add(Calendar.DATE, valorDias);
        System.out.println("Fecha Formateada: " + sdf.format(c1.getTime()));
        fechaSalida.setText(sdf.format(c1.getTime()));
    }//GEN-LAST:event_CantidadDiasFocusLost

    private void CantidadDiasKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CantidadDiasKeyPressed
        // TODO add your handling code here:

    }//GEN-LAST:event_CantidadDiasKeyPressed

    private void PrecioFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_PrecioFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_PrecioFocusGained

    private void PrecioFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_PrecioFocusLost
        // TODO add your handling code here:
        int montoImpuesto, subt, montoTotal;
        montoTotal = Integer.parseInt(Precio.getText()) * Integer.parseInt(CantidadDias.getText());
        montoImpuesto = (int) (montoTotal * 0.13);
        subt = montoTotal - montoImpuesto;
        impuesto.setText(String.valueOf(montoImpuesto));
        precioTotal.setText(String.valueOf(montoTotal));
        subTotal.setText(String.valueOf(subt));
    }//GEN-LAST:event_PrecioFocusLost

    private void borrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_borrarActionPerformed
        // TODO add your handling code here:

        CantidadDias.setText("");
        impuesto.setText("");
        subTotal.setText("");
        precioTotal.setText("");
    }//GEN-LAST:event_borrarActionPerformed

    private void guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarActionPerformed
        // TODO add your handling code here:
        String queryFacturar = "INSERT INTO "
                + "`factura_cabina` "
                + "(`factura_id`, "
                + "`cant_dia`, "
                + "`fecha`, "
                + "`impuesto_cabina`, "
                + "`precio_total_cabina`, "
                + "`cabina_cabina_id`, "
                + "`colaborador_empleado_id`, "
                + "`numero_factura`, "
                + "`cliente_empresa_empresa_id`) "
                + "VALUES (NULL, '1', '2017-04-17', '1300', '5000', '1', '2', '25', '1')";
        try {
            int P = JOptionPane.showConfirmDialog(null, " Quiere Facturar esta Cabina ?", "Confirmación", JOptionPane.YES_NO_OPTION);
            if (P == 0) {
                con = DBConnection.getConnection();
                
                if (CantidadDias.getText().equals("")) {
                    JOptionPane.showMessageDialog(this, "Favor ingresa el número de días a hospedarse ", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                if (Precio.getText().equals("")) {
                    JOptionPane.showMessageDialog(this, "Favor ingresa el monto de la cábina ", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                
                Statement stmt;
                stmt = con.createStatement();
                
                pst = con.prepareStatement(queryFacturar);
                pst.execute();
                JOptionPane.showMessageDialog(this, "Guardado con Exito saved", "Gasto Operativo", JOptionPane.INFORMATION_MESSAGE);
                
                Precio.setText("");
                CantidadDias.setText("");
                
                Seleccionar_Cabina_frm cabina_frm = new Seleccionar_Cabina_frm();
                this.hide();
                cabina_frm.setVisible(true);
                
                try {
                    int op = JOptionPane.showConfirmDialog(null, " Cambiar el estado de la cábina # " + nCabina.getText() + " ?", "Confirmación", JOptionPane.YES_NO_OPTION);
                    if (op == 0) {
                        con = DBConnection.getConnection();
                        Statement statement;
                        statement = con.createStatement();
                        
                        String Pru = "UPDATE `cabina` SET `estado_cabina` = 'Ocupado' WHERE `descripcion_cabina` = '" + nCabina.getText() + "' ";
                        pst = con.prepareStatement(Pru);
                        pst.execute();
                        JOptionPane.showMessageDialog(null, "Guardado con Exito saved", "Tipo de Usuario", JOptionPane.INFORMATION_MESSAGE);
                        
                    }
                    
                } catch (HeadlessException | SQLException ex) {
                    JOptionPane.showMessageDialog(null, ex);
                }
            }
            if (P == 1) {
                Seleccionar_Cabina_frm cabina_frm = new Seleccionar_Cabina_frm();
                this.hide();
                cabina_frm.setVisible(true);
            }
            
        } catch (HeadlessException | SQLException ex) {
            JOptionPane.showMessageDialog(this, ex);
            
        }

    }//GEN-LAST:event_guardarActionPerformed

    private void volverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_volverActionPerformed
        // TODO add your handling code here:
        Seleccionar_Cabina_frm sc = new Seleccionar_Cabina_frm();
        sc.setVisible(true);
        this.hide();
    }//GEN-LAST:event_volverActionPerformed

    private void txtNombreClienteKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreClienteKeyPressed
        // TODO add your handling code here:
        try {
            //SELECT `idpersona`, `nombre`, `cedula`, `telefono`, `direccion`, `tipo_persona_idtipo_persona` FROM `persona` WHERE 1
            String sql_persona = "SELECT "
                    + "cliente_empresa.empresa_id, "
                    + "cliente_empresa.codigo_cliente,"
                    + "persona.nombre, "
                    + "tipo_persona.desc_persona "
                    + "FROM "
                    + "cliente_empresa "
                    + "INNER JOIN "
                    + "persona ON persona.idpersona = cliente_empresa.persona_idpersona "
                    + "INNER JOIN "
                    + "tipo_persona ON persona.tipo_persona_idtipo_persona = tipo_persona.idtipo_persona "
                    + "WHERE "
                    + "persona.nombre LIKE '%" + txtNombreCliente.getText() + "%' "
                    + "AND tipo_persona.desc_persona = 'Cliente'";
            pst = con.prepareStatement(sql_persona);
            rs = pst.executeQuery();
            if (rs.next()) {
                String add1 = rs.getString(1);
                String add2 = rs.getString(2);
                String add3 = rs.getString(3);
                nombreCliente1.setText(add2);
                codigoCliente.setText(add1);
                txtNombreCliente.setText(add3);
                
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            
        }
    }//GEN-LAST:event_txtNombreClienteKeyPressed

    private void jDateChooser1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jDateChooser1KeyTyped
        // TODO add your handling code here:
        Calendar cal;
        int d, m, a;
        cal = jDateChooser1.getCalendar();
        d = cal.get(Calendar.DAY_OF_MONTH);
        m = cal.get(Calendar.MONTH);
        a = cal.get(Calendar.YEAR) - 1900;
        // Create an instance of SimpleDateFormat used for formatting 
// the string representation of date (month/day/year)
        DateFormat df = new SimpleDateFormat("MM/dd/yyyy");

// Get the date today using Calendar object.
        Date today = jDateChooser1.getDate();
// Using DateFormat format method we can create a string 
// representation of a date with the defined format.
        String reportDate = df.format(today);

// Print what date is today!
        System.out.println("Report Date: " + reportDate);
        fechaEntrada.setText(reportDate);
        
        Format formatter = new SimpleDateFormat("yyyy-MM-dd");
        String s = formatter.format(jDateChooser1.getDate());
        
        fechaEntrada.setText(s);
    }//GEN-LAST:event_jDateChooser1KeyTyped

    private void jDateChooser1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jDateChooser1MouseClicked
        // TODO add your handling code here:
        Calendar cal;
        int d, m, a;
        cal = jDateChooser1.getCalendar();
        d = cal.get(Calendar.DAY_OF_MONTH);
        m = cal.get(Calendar.MONTH);
        a = cal.get(Calendar.YEAR) - 1900;
        
        Format formatter = new SimpleDateFormat("yyyy-MM-dd");
        String s = formatter.format(jDateChooser1.getDate());
        
        fechaEntrada.setText(s);
        JOptionPane.showMessageDialog(this, s);
    }//GEN-LAST:event_jDateChooser1MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        Calendar cal;
        int d, m, a;
        cal = jDateChooser1.getCalendar();
        d = cal.get(Calendar.DAY_OF_MONTH);
        m = cal.get(Calendar.MONTH);
        a = cal.get(Calendar.YEAR) - 1900;
        
        Format formatter = new SimpleDateFormat("yyyy-MM-dd");
        String s = formatter.format(jDateChooser1.getDate());
        
        fechaEntrada.setText(s);
        JOptionPane.showMessageDialog(this, s);
        
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFormattedTextField CantidadDias;
    public static javax.swing.JFormattedTextField Precio;
    private javax.swing.JButton borrar;
    private javax.swing.JLabel codigoCliente;
    private javax.swing.JLabel fechaEntrada;
    private javax.swing.JLabel fechaSalida;
    private javax.swing.JButton guardar;
    public static javax.swing.JLabel idCabina;
    private javax.swing.JLabel idCabina1;
    private javax.swing.JLabel idCliente;
    private javax.swing.JLabel idEmpleado;
    public static javax.swing.JLabel idEmpleado1;
    private javax.swing.JTextField impuesto;
    private javax.swing.JButton jButton1;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JLabel lblCantDias;
    private javax.swing.JLabel lblFechaEntrada;
    private javax.swing.JLabel lblImpuesto;
    public static javax.swing.JLabel nCabina;
    private javax.swing.JLabel nombreCliente;
    private javax.swing.JLabel nombreCliente1;
    public static javax.swing.JLabel nombreEmpleado;
    private javax.swing.JLabel numeroFactura;
    private javax.swing.JTextField precioTotal;
    private javax.swing.JTextField subTotal;
    private javax.swing.JTextField txtNombreCliente;
    private javax.swing.JButton volver;
    // End of variables declaration//GEN-END:variables
}
