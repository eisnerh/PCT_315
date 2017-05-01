/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.dbConnection;
import java.awt.HeadlessException;
import java.io.File;
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
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;
import static vista.Frm_Horario.modeloTurno;
import static vista.Frm_Inicio.escritorio;

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
    PreparedStatement pst2 = null;
    public String Valor;
    private final dbConnection myLink = new dbConnection();
    private final Connection conexion = dbConnection.getConnection();

    public Frm_NuevaFactura() {
        initComponents();
        con = dbConnection.getConnection();
        nCabina.setText(Frm_Seleccionar_Cabina.ps_nombreCabina);
        nombreEmpleado.setText(Frm_Login.ps_NombreEmpleado);
        idEmpleado.setText(Frm_Login.ps_idEmpleado);
        nuevoNFactura();
        fechaEntrada.setVisible(false);
        jPanel1.setVisible(false);
    }

    private void obtenerFecha() {
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
    }

    public void nuevoNFactura() {
        try {
            Statement stmt;
            stmt = conexion.createStatement();
            String qSQL = "SELECT "
                    + "max(factura_cabina.numero_factura)+1 as N_Factura "
                    + "FROM "
                    + "pct3.factura_cabina";
            rs = stmt.executeQuery(qSQL);
            while (rs.next()) {
                numeroFactura.setText(rs.getString(1));
                if(numeroFactura.getText().equals(""))
                {
                    numeroFactura.setText("1");
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

        jPanel4 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        impuesto = new javax.swing.JLabel();
        precioTotal = new javax.swing.JLabel();
        subTotal = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        nombreCliente = new javax.swing.JLabel();
        idCabina = new javax.swing.JLabel();
        idEmpleado = new javax.swing.JLabel();
        lbl_IdClienteEmpresa = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        fechaEntrada = new javax.swing.JLabel();
        lblCantDias = new javax.swing.JLabel();
        CantidadDias = new javax.swing.JFormattedTextField();
        fechaSalida = new javax.swing.JLabel();
        lblPrecio = new javax.swing.JLabel();
        Precio = new javax.swing.JFormattedTextField();
        jLabel2 = new javax.swing.JLabel();
        txtNombreCliente = new javax.swing.JTextField();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        btnBuscarCliente = new javax.swing.JButton();
        nombreEmpleado = new javax.swing.JLabel();
        btnLimpiar = new javax.swing.JButton();
        guardar = new javax.swing.JButton();
        volver = new javax.swing.JButton();
        nCabina = new javax.swing.JLabel();
        numeroFactura = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setTitle("Facturar");

        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        impuesto.setBorder(javax.swing.BorderFactory.createTitledBorder("Impuesto"));

        precioTotal.setBorder(javax.swing.BorderFactory.createTitledBorder("Monto Total a Cancelar"));

        subTotal.setBorder(javax.swing.BorderFactory.createTitledBorder("Sub Total"));
        subTotal.setRequestFocusEnabled(false);

        nombreCliente.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nombreCliente.setBorder(javax.swing.BorderFactory.createTitledBorder("Nombre Cliente"));
        nombreCliente.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        idCabina.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        idCabina.setBorder(javax.swing.BorderFactory.createTitledBorder("ID Cabina"));
        idCabina.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        idEmpleado.setBorder(javax.swing.BorderFactory.createTitledBorder("ID Empleado"));
        idEmpleado.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        lbl_IdClienteEmpresa.setBorder(javax.swing.BorderFactory.createTitledBorder("ID Cliente"));
        lbl_IdClienteEmpresa.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(nombreCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lbl_IdClienteEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(idCabina, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(idEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(40, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(nombreCliente, javax.swing.GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE)
                    .addComponent(lbl_IdClienteEmpresa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(idCabina, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
                    .addComponent(idEmpleado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(impuesto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(precioTotal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(subTotal, javax.swing.GroupLayout.DEFAULT_SIZE, 243, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(96, 96, 96))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(impuesto, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(subTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(precioTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 8, Short.MAX_VALUE)))
                .addContainerGap())
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

        fechaEntrada.setFont(new java.awt.Font("Hack", 1, 14)); // NOI18N
        fechaEntrada.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        fechaEntrada.setBorder(javax.swing.BorderFactory.createTitledBorder("Fecha de Entrada"));
        jPanel4.add(fechaEntrada, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 176, 50));

        lblCantDias.setText("Cantidad de Días:");
        jPanel4.add(lblCantDias, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, -1, 20));

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
        jPanel4.add(CantidadDias, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, 176, 30));

        fechaSalida.setBorder(javax.swing.BorderFactory.createTitledBorder("Fecha de Salida"));
        jPanel4.add(fechaSalida, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 60, 176, 50));

        lblPrecio.setText("Precio:");
        jPanel4.add(lblPrecio, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 120, 176, 28));

        Precio.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("###0"))));
        Precio.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                PrecioFocusLost(evt);
            }
        });
        jPanel4.add(Precio, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 150, 170, 28));

        jLabel2.setText("Nombre del Cliente:");
        jPanel4.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        txtNombreCliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNombreClienteKeyPressed(evt);
            }
        });
        jPanel4.add(txtNombreCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 10, 270, 30));
        jPanel4.add(jDateChooser1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 170, 30));

        btnBuscarCliente.setText("...");
        btnBuscarCliente.setToolTipText("Busqueda del Cliente");
        btnBuscarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarClienteActionPerformed(evt);
            }
        });
        jPanel4.add(btnBuscarCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 10, -1, -1));

        nombreEmpleado.setFont(new java.awt.Font("Hack", 1, 14)); // NOI18N
        nombreEmpleado.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nombreEmpleado.setBorder(javax.swing.BorderFactory.createTitledBorder("Colaborador"));

        btnLimpiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/compose_64px.png"))); // NOI18N
        btnLimpiar.setToolTipText("Vaciar los Campos");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });

        guardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/book_64px.png"))); // NOI18N
        guardar.setToolTipText("Imprimir Factura");
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
        nCabina.setBorder(javax.swing.BorderFactory.createTitledBorder("Cabina"));

        numeroFactura.setBorder(javax.swing.BorderFactory.createTitledBorder("Factura #..."));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(36, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(nombreEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnLimpiar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nCabina, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(guardar)
                        .addGap(18, 18, 18)
                        .addComponent(volver)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(numeroFactura, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 639, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(numeroFactura, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(nCabina, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(volver, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE)
                                .addComponent(guardar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addComponent(nombreEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void CantidadDiasFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_CantidadDiasFocusLost

        Calendar c1 = jDateChooser1.getCalendar();
        System.out.println("Fecha actual: " + c1.getTime().toString());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
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

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        // TODO add your handling code here:

        try {
            modeloTurno.removeAllElements(); // eliminamos lo elementos
            Statement stmt;
            stmt = conexion.createStatement();
            String qSQL = "SELECT max(factura_cabina.numero_factura)+1 as N_Factura FROM pct3.factura_cabina;";
            rs = stmt.executeQuery(qSQL);
            while (rs.next()) {
                numeroFactura.setText(rs.getString(1));
                if (numeroFactura.getText().equals(""))
                {
                    numeroFactura.setText("1");
                }
            }

        } catch (HeadlessException | SQLException ex) {
            JOptionPane.showMessageDialog(this, ex);
        }
        CantidadDias.setText("");
        impuesto.setText("");
        subTotal.setText("");

        txtNombreCliente.setText("");
        fechaSalida.setText("");
        Precio.setText("");
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarActionPerformed
        // TODO add your handling code here:
        obtenerFecha();
        String queryFacturar = "INSERT INTO `pct3`.`factura_cabina` "
                + "("
                + "`cant_dia`, "
                + "`fecha`, "
                + "`impuesto_cabina`, "
                + "`precio_total_cabina`, "
                + "`cabina_cabina_id`, "
                + "`colaborador_empleado_id`, "
                + "`numero_factura`, "
                + "`cliente_empresa_empresa_id`) "
                + "VALUES "
                + "("
                + "'" + CantidadDias.getText() + "', "
                + "'" + fechaEntrada.getText() + "', "
                + "'" + impuesto.getText() + "', "
                + "'" + precioTotal.getText() + "', "
                + "'" + idCabina.getText() + "', "
                + "'" + idEmpleado.getText() + "', "
                + "'" + numeroFactura.getText() + "', "
                + "'" + lbl_IdClienteEmpresa.getText() + "')";
        try {
            int P = JOptionPane.showConfirmDialog(null, " Quiere Facturar esta Cabina ?", "Confirmación", JOptionPane.YES_NO_OPTION);
            if (P == 0) {
                con = dbConnection.getConnection();

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

                if (!numeroFactura.getText().equals("") && !idEmpleado.getText().equals("")) {
                    Map p = new HashMap();
                    p.put("facturaNumero", numeroFactura.getText());
                    p.put("idEmpleado", idEmpleado.getText());
                    JasperReport report;
                    JasperPrint print;

                    try {
                        report = JasperCompileManager.compileReport(new File("").getAbsolutePath()
                                + "/src/vista/reportes/N_Factura.jrxml");
                        print = JasperFillManager.fillReport(report, p, con);
                        JasperViewer view = new JasperViewer(print, false);
                        view.setTitle("Reporte por Cábina");
                        view.setVisible(true);

                    } catch (JRException e) {
                        JOptionPane.showMessageDialog(this, e);
                    }

                    Precio.setText("");
                    CantidadDias.setText("");

                    Frm_Seleccionar_Cabina cabina_frm = new Frm_Seleccionar_Cabina();
                    this.hide();
                    cabina_frm.setVisible(true);

                    try {
                        con = dbConnection.getConnection();
                        Statement statement;
                        statement = con.createStatement();
                        String Pru = "UPDATE `pct3`.`cabina` SET `estado_cabina`='Ocupado' WHERE `cabina_id`='" + idCabina.getText() + "'";
                        pst = con.prepareStatement(Pru);
                        pst.execute();
                        JOptionPane.showMessageDialog(null, "Guardado con Exito saved", "Tipo de Usuario", JOptionPane.INFORMATION_MESSAGE);

                    } catch (HeadlessException | SQLException ex) {
                        JOptionPane.showMessageDialog(null, ex);
                    }
                }
                if (P == 1) {
                    Frm_Seleccionar_Cabina cabina_frm = new Frm_Seleccionar_Cabina();
                    this.hide();
                    cabina_frm.setVisible(true);
                }
            }
        } catch (HeadlessException | SQLException ex) {
            JOptionPane.showMessageDialog(this, ex);

        }

    }//GEN-LAST:event_guardarActionPerformed

    private void volverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_volverActionPerformed
        // TODO add your handling code here:
        Frm_Seleccionar_Cabina sc = new Frm_Seleccionar_Cabina();
        sc.setVisible(true);
        this.hide();
    }//GEN-LAST:event_volverActionPerformed

    private void txtNombreClienteKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreClienteKeyPressed

    }//GEN-LAST:event_txtNombreClienteKeyPressed

    private void btnBuscarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarClienteActionPerformed
        // TODO add your handling code here:
        Frm_BusquedaClientes1 form = new Frm_BusquedaClientes1();
        escritorio.add(form);
        form.toFront();
        form.setVisible(true);
    }//GEN-LAST:event_btnBuscarClienteActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFormattedTextField CantidadDias;
    public static javax.swing.JFormattedTextField Precio;
    private javax.swing.JButton btnBuscarCliente;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JLabel fechaEntrada;
    private javax.swing.JLabel fechaSalida;
    private javax.swing.JButton guardar;
    public static javax.swing.JLabel idCabina;
    public static javax.swing.JLabel idEmpleado;
    private javax.swing.JLabel impuesto;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JLabel lblCantDias;
    private javax.swing.JLabel lblPrecio;
    public static javax.swing.JLabel lbl_IdClienteEmpresa;
    public static javax.swing.JLabel nCabina;
    public static javax.swing.JLabel nombreCliente;
    public static javax.swing.JLabel nombreEmpleado;
    private javax.swing.JLabel numeroFactura;
    private javax.swing.JLabel precioTotal;
    private javax.swing.JLabel subTotal;
    public static javax.swing.JTextField txtNombreCliente;
    private javax.swing.JButton volver;
    // End of variables declaration//GEN-END:variables
}
