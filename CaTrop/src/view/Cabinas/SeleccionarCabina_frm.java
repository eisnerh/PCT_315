/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.Cabinas;

import controller.ConexionDB;
import java.awt.Color;
import java.awt.HeadlessException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import view.Form_Factura;
import view.Login_frm;
import view.Principal_frm;

/**
 *
 * @author ace
 */
public class SeleccionarCabina_frm extends javax.swing.JFrame {

    /**
     * Creates new form SeleccionarCabina
     */
    // Se crea un array de botones
    private final List<JButton> botones;
    // Se agrega un indice para prueba del nombre, aunque debería leer el nombre de la cabina.
    JButton b[];
    String cambiarFuncion[] = new String[6];

    Connection con = null;
    ResultSet rs = null;
    PreparedStatement pst = null;

    public SeleccionarCabina_frm() {
        initComponents();
        agregarCabinas.setOpaque(false);
        opciones.setOpaque(false);
        initComponents();
        setLocationRelativeTo(null);
        botones = new ArrayList<>();
        con = ConexionDB.conexionDB();
        Get_Data();
        NombreEmpleado.setText(Login_frm.ps_NombreEmpleado);
        IdEmpleado.setText(Login_frm.ps_idEmpleado);
    }

    private void Get_Data() {
        //Select sobre el estatus_empleado y se le asigna el valor a la columna de la tabla del formulario.

        String sqlQuery = "SELECT `descripcion_cabina`, `estado_cabina` FROM `cabina` ORDER BY `estado_cabina` asc ";
        int totalRegistros;
        agregarCabinas.removeAll();
        try {
            pst = con.prepareStatement(sqlQuery);

            rs = pst.executeQuery();
            totalRegistros = 0;
            while (rs.next()) {
                String nombreCabina = rs.getString(1);
                JButton btn = new JButton(nombreCabina);
                agregarCabinas.add(btn);

                if (rs.getString(2).equals("Ocupado")) {
                    btn.setBackground(Color.red);
                    btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icons/Cabina/racing.png"))); // NOI18N
                }
                if (rs.getString(2).equals("Libre")) {
                    btn.setBackground(Color.green);
                    btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icons/Cabina/house.png"))); // NOI18N
                }
                if (rs.getString(2).equals("Limpieza")) {
                    btn.setBackground(Color.yellow);
                    btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icons/Cabina/wiping.png"))); // NOI18N
                }
                if (rs.getString(2).equals("Bloqueo")) {
                    btn.setBackground(Color.yellow);
                    btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icons/Cabina/blocked.png"))); // NOI18N
                }
                btn.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(java.awt.event.ActionEvent e) {
                        try {
                            Principal_frm p = new Principal_frm();
                            p.setVisible(true);
                        } catch (IOException ex) {
                            Logger.getLogger(SeleccionarCabina_frm.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                });
                totalRegistros++;

            }

            agregarCabinas.updateUI();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);

        }
    }

    private void Get_Bloqueo() {
        //Select sobre el estatus_empleado y se le asigna el valor a la columna de la tabla del formulario.

        String sqlQuery = "SELECT `descripcion_cabina`, `estado_cabina` FROM "
                + "`pct3`.`cabina` AS `cabina` WHERE `estado_cabina` "
                + "Like '%Bloque%' ORDER BY `descripcion_cabina` ASC";
        int totalRegistros;
        agregarCabinas.removeAll();
        try {
            pst = con.prepareStatement(sqlQuery);

            rs = pst.executeQuery();
            totalRegistros = 0;
            while (rs.next()) {
                String nombreCabina = rs.getString(1);
                JButton btn = new JButton(nombreCabina);
                agregarCabinas.add(btn);

                if (rs.getString(2).equals("Ocupado")) {
                    btn.setBackground(Color.red);
                    btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icons/Cabina/racing.png"))); // NOI18N
                }
                if (rs.getString(2).equals("Libre")) {
                    btn.setBackground(Color.green);
                    btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icons/Cabina/house.png"))); // NOI18N
                }
                if (rs.getString(2).equals("Limpieza")) {
                    btn.setBackground(Color.yellow);
                    btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icons/Cabina/wiping.png"))); // NOI18N
                }
                if (rs.getString(2).equals("Bloqueo")) {
                    btn.setBackground(Color.yellow);
                    btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icons/Cabina/blocked.png"))); // NOI18N
                    btn.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(java.awt.event.ActionEvent e) {
                            try {
                                int P = JOptionPane.showConfirmDialog(null, " Quiere liberar la cábina # " + nombreCabina + " ?", "Confirmación", JOptionPane.YES_NO_OPTION);
                                if (P == 0) {
                                    con = ConexionDB.conexionDB();
                                    Statement stmt;
                                    stmt = con.createStatement();

                                    String Pru = "UPDATE `cabina` SET `estado_cabina` = 'Libre' WHERE `descripcion_cabina` = '" + nombreCabina + "' ";
                                    pst = con.prepareStatement(Pru);
                                    pst.execute();
                                    JOptionPane.showMessageDialog(null, "Guardado con Exito saved", "Tipo de Usuario", JOptionPane.INFORMATION_MESSAGE);
                                    agregarCabinas.removeAll();
                                    agregarCabinas.updateUI();
                                }

                            } catch (HeadlessException | SQLException ex) {
                                JOptionPane.showMessageDialog(null, ex);
                            }
                        }
                    });
                }

                totalRegistros++;

            }

            agregarCabinas.updateUI();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);

        }
    }

    private void Get_Libre() {
        //Select sobre el estatus_empleado y se le asigna el valor a la columna de la tabla del formulario.

        String sqlQuery = "SELECT `descripcion_cabina`, `estado_cabina` FROM "
                + "`pct3`.`cabina` AS `cabina` WHERE `estado_cabina` = 'Libre' "
                + "ORDER BY `descripcion_cabina` ASC";
        int totalRegistros;
        agregarCabinas.removeAll();
        try {
            pst = con.prepareStatement(sqlQuery);

            rs = pst.executeQuery();
            totalRegistros = 0;
            while (rs.next()) {
                String nombreCabina = rs.getString(1);
                JButton btn = new JButton(nombreCabina);
                agregarCabinas.add(btn);

                if (rs.getString(2).equals("Ocupado")) {
                    btn.setBackground(Color.red);
                    btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icons/Cabina/racing.png"))); // NOI18N
                }
                if (rs.getString(2).equals("Libre")) {
                    btn.setBackground(Color.green);
                    btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icons/Cabina/house.png"))); // NOI18N
                    btn.addActionListener(new ActionListener() {

                        @Override
                        public void actionPerformed(java.awt.event.ActionEvent e) {
                            Form_Factura factura_frm = new Form_Factura();
                            hide();
                            factura_frm.setVisible(true);
                            Form_Factura.FacturarCabina.setText(nombreCabina);
                        }
                    });
                }
                if (rs.getString(2).equals("Limpieza")) {
                    btn.setBackground(Color.yellow);
                    btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icons/Cabina/wiping.png"))); // NOI18N
                }
                if (rs.getString(2).equals("Bloqueo")) {
                    btn.setBackground(Color.yellow);
                    btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icons/Cabina/blocked.png"))); // NOI18N
                }

                totalRegistros++;

            }

            agregarCabinas.updateUI();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);

        }
    }

    private void Get_Ocupado() {
        //Select sobre el estatus_empleado y se le asigna el valor a la columna de la tabla del formulario.

        String sqlQuery = "SELECT `descripcion_cabina`, `estado_cabina` FROM `pct3`.`cabina` AS `cabina` WHERE `estado_cabina` = 'Ocupado' ORDER BY `descripcion_cabina` ASC";
        int totalRegistros;
        agregarCabinas.removeAll();
        try {
            pst = con.prepareStatement(sqlQuery);

            rs = pst.executeQuery();
            totalRegistros = 0;
            while (rs.next()) {
                String nombreCabina = rs.getString(1);
                JButton btn = new JButton(nombreCabina);
                agregarCabinas.add(btn);

                if (rs.getString(2).equals("Ocupado")) {
                    btn.setBackground(Color.red);
                    btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icons/Cabina/racing.png"))); // NOI18N
                    btn.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(java.awt.event.ActionEvent e) {
                            try {
                                int P = JOptionPane.showConfirmDialog(null, " Quiere liberar la cábina # " + nombreCabina + " ?", "Confirmación", JOptionPane.YES_NO_OPTION);
                                if (P == 0) {
                                    con = ConexionDB.conexionDB();
                                    Statement stmt;
                                    stmt = con.createStatement();

                                    String Pru = "UPDATE `cabina` SET `estado_cabina` = 'Libre' WHERE `descripcion_cabina` = '" + nombreCabina + "' ";
                                    pst = con.prepareStatement(Pru);
                                    pst.execute();
                                    JOptionPane.showMessageDialog(null, "Guardado con Exito saved", "Tipo de Usuario", JOptionPane.INFORMATION_MESSAGE);

                                }

                            } catch (HeadlessException | SQLException ex) {
                                JOptionPane.showMessageDialog(null, ex);

                            }
                        }
                    });
                }
                if (rs.getString(2).equals("Libre")) {
                    btn.setBackground(Color.green);
                    btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icons/Cabina/house.png"))); // NOI18N
                }
                if (rs.getString(2).equals("Limpieza")) {
                    btn.setBackground(Color.yellow);
                    btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icons/Cabina/wiping.png"))); // NOI18N
                }
                if (rs.getString(2).equals("Bloqueo")) {
                    btn.setBackground(Color.yellow);
                    btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icons/Cabina/blocked.png"))); // NOI18N
                }
                btn.addActionListener(new ActionListener() {

                    @Override
                    public void actionPerformed(java.awt.event.ActionEvent e) {
                        System.out.println("Ocupado");
                    }
                });

                totalRegistros++;

            }

            agregarCabinas.updateUI();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);

        }
    }

    private void Get_Limpieza() {
        //Select sobre el estatus_empleado y se le asigna el valor a la columna de la tabla del formulario.

        String sqlQuery = "SELECT `descripcion_cabina`, `estado_cabina` FROM `pct3`.`cabina` AS `cabina` WHERE `estado_cabina` = 'Limpieza' ORDER BY `descripcion_cabina` ASC";
        int totalRegistros;
        agregarCabinas.removeAll();
        try {
            pst = con.prepareStatement(sqlQuery);

            rs = pst.executeQuery();
            totalRegistros = 0;
            while (rs.next()) {
                String nombreCabina = rs.getString(1);
                JButton btn = new JButton(nombreCabina);
                agregarCabinas.add(btn);

                if (rs.getString(2).equals("Ocupado")) {
                    btn.setBackground(Color.red);
                    btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icons/Cabina/racing.png"))); // NOI18N
                }
                if (rs.getString(2).equals("Libre")) {
                    btn.setBackground(Color.green);
                    btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icons/Cabina/house.png"))); // NOI18N
                }
                if (rs.getString(2).equals("Limpieza")) {
                    btn.setBackground(Color.yellow);
                    btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icons/Cabina/wiping.png"))); // NOI18N
                    btn.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(java.awt.event.ActionEvent e) {
                            try {
                                int P = JOptionPane.showConfirmDialog(null, " Quiere liberar la cábina # " + nombreCabina + " este dato ?", "Confirmación", JOptionPane.YES_NO_OPTION);
                                if (P == 0) {
                                    con = ConexionDB.conexionDB();
                                    Statement stmt;
                                    stmt = con.createStatement();

                                    String Pru = "UPDATE `cabina` SET `estado_cabina` = 'Libre' WHERE `descripcion_cabina` = '" + nombreCabina + "' ";
                                    pst = con.prepareStatement(Pru);
                                    pst.execute();
                                    JOptionPane.showMessageDialog(null, "Guardado con Exito saved", "Tipo de Usuario", JOptionPane.INFORMATION_MESSAGE);

                                }

                            } catch (HeadlessException | SQLException ex) {
                                JOptionPane.showMessageDialog(null, ex);

                            }
                        }
                    });
                }
                if (rs.getString(2).equals("Bloqueo")) {
                    btn.setBackground(Color.yellow);
                    btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icons/Cabina/blocked.png"))); // NOI18N
                }

                totalRegistros++;

            }

            agregarCabinas.updateUI();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);

        }
    }

    private void Get_Sencilla() {
        //Select sobre el estatus_empleado y se le asigna el valor a la columna de la tabla del formulario.

        String sqlQuery = "SELECT `descripcion_cabina`, `tipo_cabina` FROM `pct3`.`cabina` AS `cabina` WHERE `tipo_cabina` = 'Sencilla' ORDER BY `descripcion_cabina` ASC";
        int totalRegistros;
        agregarCabinas.removeAll();
        try {
            pst = con.prepareStatement(sqlQuery);

            rs = pst.executeQuery();
            totalRegistros = 0;
            while (rs.next()) {
                String nombreCabina = rs.getString(1);
                JButton btn = new JButton(nombreCabina);
                agregarCabinas.add(btn);

                if (rs.getString(2).equals("Doble")) {
                    btn.setBackground(Color.BLUE);
                    btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icons/Cabina/queen.png"))); // NOI18N
                }
                if (rs.getString(2).equals("Sencilla")) {
                    btn.setBackground(Color.green);
                    btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icons/Cabina/single.png"))); // NOI18N
                }
                if (rs.getString(2).equals("Limpieza")) {
                    btn.setBackground(Color.yellow);
                    btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icons/Cabina/wiping.png"))); // NOI18N

                }
                if (rs.getString(2).equals("Bloqueo")) {
                    btn.setBackground(Color.yellow);
                    btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icons/Cabina/blocked.png"))); // NOI18N
                }

                totalRegistros++;

            }

            agregarCabinas.updateUI();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);

        }
    }

    private void Get_Doble() {
        //Select sobre el estatus_empleado y se le asigna el valor a la columna de la tabla del formulario.

        String sqlQuery = "SELECT `descripcion_cabina`, `tipo_cabina` FROM `pct3`.`cabina` AS `cabina` WHERE `tipo_cabina` = 'Doble' ORDER BY `descripcion_cabina` ASC";
        int totalRegistros;
        agregarCabinas.removeAll();
        try {
            pst = con.prepareStatement(sqlQuery);

            rs = pst.executeQuery();
            totalRegistros = 0;
            while (rs.next()) {
                String nombreCabina = rs.getString(1);
                JButton btn = new JButton(nombreCabina);
                agregarCabinas.add(btn);

                if (rs.getString(2).equals("Doble")) {
                    btn.setBackground(Color.BLUE);
                    btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icons/Cabina/queen.png"))); // NOI18N
                }
                if (rs.getString(2).equals("Sencilla")) {
                    btn.setBackground(Color.green);
                    btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icons/Cabina/single.png"))); // NOI18N
                }
                if (rs.getString(2).equals("Limpieza")) {
                    btn.setBackground(Color.yellow);
                    btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icons/Cabina/wiping.png"))); // NOI18N

                }
                if (rs.getString(2).equals("Bloqueo")) {
                    btn.setBackground(Color.yellow);
                    btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icons/Cabina/blocked.png"))); // NOI18N
                }

                totalRegistros++;

            }

            agregarCabinas.updateUI();

        } catch (Exception e) {
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

        bgOpciones = new javax.swing.ButtonGroup();
        opciones = new javax.swing.JPanel();
        Ocupado = new javax.swing.JRadioButton();
        Todos = new javax.swing.JRadioButton();
        Dobles = new javax.swing.JRadioButton();
        Vacio = new javax.swing.JRadioButton();
        Limpieza = new javax.swing.JRadioButton();
        Bloqueado = new javax.swing.JRadioButton();
        Sencillas = new javax.swing.JRadioButton();
        agregarCabinas = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        volverPrincipal = new javax.swing.JButton();
        AgregarCabina = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        NombreEmpleado = new javax.swing.JLabel();
        IdEmpleado = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Selección de Cábinas");
        setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        opciones.setBackground(new java.awt.Color(0, 51, 51));
        opciones.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        Ocupado.setBackground(new java.awt.Color(0, 51, 51));
        bgOpciones.add(Ocupado);
        Ocupado.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        Ocupado.setForeground(new java.awt.Color(251, 251, 251));
        Ocupado.setText("Ocupado");
        Ocupado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OcupadoActionPerformed(evt);
            }
        });

        Todos.setBackground(new java.awt.Color(0, 51, 51));
        bgOpciones.add(Todos);
        Todos.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        Todos.setForeground(new java.awt.Color(251, 251, 251));
        Todos.setText("Todos");
        Todos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TodosActionPerformed(evt);
            }
        });

        Dobles.setBackground(new java.awt.Color(0, 51, 51));
        bgOpciones.add(Dobles);
        Dobles.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        Dobles.setForeground(new java.awt.Color(251, 251, 251));
        Dobles.setText("Hab. Doble");
        Dobles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DoblesActionPerformed(evt);
            }
        });

        Vacio.setBackground(new java.awt.Color(0, 51, 51));
        bgOpciones.add(Vacio);
        Vacio.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        Vacio.setForeground(new java.awt.Color(251, 251, 251));
        Vacio.setText("Vacio");
        Vacio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VacioActionPerformed(evt);
            }
        });

        Limpieza.setBackground(new java.awt.Color(0, 51, 51));
        bgOpciones.add(Limpieza);
        Limpieza.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        Limpieza.setForeground(new java.awt.Color(251, 251, 251));
        Limpieza.setText("Limpieza");
        Limpieza.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LimpiezaActionPerformed(evt);
            }
        });

        Bloqueado.setBackground(new java.awt.Color(0, 51, 51));
        bgOpciones.add(Bloqueado);
        Bloqueado.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        Bloqueado.setForeground(new java.awt.Color(251, 251, 251));
        Bloqueado.setText("Bloqueado");
        Bloqueado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BloqueadoActionPerformed(evt);
            }
        });

        Sencillas.setBackground(new java.awt.Color(0, 51, 51));
        bgOpciones.add(Sencillas);
        Sencillas.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        Sencillas.setForeground(new java.awt.Color(251, 251, 251));
        Sencillas.setText("Hab. Sencilla");
        Sencillas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SencillasActionPerformed(evt);
            }
        });

        agregarCabinas.setLayout(new java.awt.GridLayout(0, 3));

        javax.swing.GroupLayout opcionesLayout = new javax.swing.GroupLayout(opciones);
        opciones.setLayout(opcionesLayout);
        opcionesLayout.setHorizontalGroup(
            opcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(opcionesLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(opcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Dobles)
                    .addComponent(Sencillas)
                    .addComponent(Ocupado)
                    .addComponent(Vacio)
                    .addComponent(Todos)
                    .addComponent(Limpieza)
                    .addComponent(Bloqueado))
                .addContainerGap(541, Short.MAX_VALUE))
            .addGroup(opcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(opcionesLayout.createSequentialGroup()
                    .addGap(0, 348, Short.MAX_VALUE)
                    .addComponent(agregarCabinas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 348, Short.MAX_VALUE)))
        );
        opcionesLayout.setVerticalGroup(
            opcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(opcionesLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(Todos)
                .addGap(18, 18, 18)
                .addComponent(Ocupado)
                .addGap(18, 18, 18)
                .addComponent(Vacio)
                .addGap(18, 18, 18)
                .addComponent(Limpieza)
                .addGap(18, 18, 18)
                .addComponent(Bloqueado)
                .addGap(18, 18, 18)
                .addComponent(Sencillas)
                .addGap(18, 18, 18)
                .addComponent(Dobles)
                .addGap(0, 75, Short.MAX_VALUE))
            .addGroup(opcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(opcionesLayout.createSequentialGroup()
                    .addGap(0, 208, Short.MAX_VALUE)
                    .addComponent(agregarCabinas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 208, Short.MAX_VALUE)))
        );

        getContentPane().add(opciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, 700, 420));

        jPanel1.setLayout(new java.awt.GridLayout(1, 3, 3, 4));

        volverPrincipal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icons/CRUD/volver.png"))); // NOI18N
        volverPrincipal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                volverPrincipalActionPerformed(evt);
            }
        });
        jPanel1.add(volverPrincipal);

        AgregarCabina.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icons/CRUD/boxxadd.png"))); // NOI18N
        AgregarCabina.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AgregarCabinaActionPerformed(evt);
            }
        });
        jPanel1.add(AgregarCabina);

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 170, 70));

        jLabel1.setText("Volver");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jLabel2.setText("Agregar Cabina");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 10, -1, -1));
        getContentPane().add(NombreEmpleado, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 30, -1, -1));
        getContentPane().add(IdEmpleado, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 50, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void OcupadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OcupadoActionPerformed
        // TODO add your handling code here:
        agregarCabinas.removeAll();
        Get_Ocupado();
    }//GEN-LAST:event_OcupadoActionPerformed

    private void TodosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TodosActionPerformed
        // TODO add your handling code here:
        agregarCabinas.removeAll();
        Get_Data();
    }//GEN-LAST:event_TodosActionPerformed

    private void VacioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VacioActionPerformed
        // TODO add your handling code here:
        agregarCabinas.removeAll();
        Get_Libre();
    }//GEN-LAST:event_VacioActionPerformed

    private void LimpiezaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LimpiezaActionPerformed
        // TODO add your handling code here:
        agregarCabinas.removeAll();
        Get_Limpieza();
    }//GEN-LAST:event_LimpiezaActionPerformed

    private void BloqueadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BloqueadoActionPerformed
        // TODO add your handling code here:
        agregarCabinas.removeAll();
        Get_Bloqueo();
    }//GEN-LAST:event_BloqueadoActionPerformed

    private void SencillasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SencillasActionPerformed
        // TODO add your handling code here:
        agregarCabinas.removeAll();
        Get_Sencilla();

    }//GEN-LAST:event_SencillasActionPerformed

    private void DoblesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DoblesActionPerformed
        // TODO add your handling code here:
        agregarCabinas.removeAll();
        Get_Doble();
    }//GEN-LAST:event_DoblesActionPerformed

    private void volverPrincipalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_volverPrincipalActionPerformed
        try {
            // TODO add your handling code here:
            Principal_frm principal_frm = new Principal_frm();
            principal_frm.setVisible(true);
            this.setVisible(false);
        } catch (IOException ex) {
            Logger.getLogger(SeleccionarCabina_frm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_volverPrincipalActionPerformed

    private void AgregarCabinaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AgregarCabinaActionPerformed
        Cabina_frm cabina_frm = new Cabina_frm();
        cabina_frm.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_AgregarCabinaActionPerformed

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
            java.util.logging.Logger.getLogger(SeleccionarCabina_frm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new SeleccionarCabina_frm().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AgregarCabina;
    private javax.swing.JRadioButton Bloqueado;
    private javax.swing.JRadioButton Dobles;
    public static javax.swing.JLabel IdEmpleado;
    private javax.swing.JRadioButton Limpieza;
    public static javax.swing.JLabel NombreEmpleado;
    private javax.swing.JRadioButton Ocupado;
    private javax.swing.JRadioButton Sencillas;
    private javax.swing.JRadioButton Todos;
    private javax.swing.JRadioButton Vacio;
    private javax.swing.JPanel agregarCabinas;
    private javax.swing.ButtonGroup bgOpciones;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel opciones;
    private javax.swing.JButton volverPrincipal;
    // End of variables declaration//GEN-END:variables

    private static abstract class ActionListener implements java.awt.event.ActionListener {

        public ActionListener() {
        }
    }

}
