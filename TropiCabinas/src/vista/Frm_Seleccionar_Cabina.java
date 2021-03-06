/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.dbConnection;
import java.awt.Color;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import static vista.Frm_Inicio.escritorio;

/**
 *
 * @author Eisner López Acevedo <eisner.lopez at gmail.com>
 * @author Cesar Gonzalez Salas <cgonzalez816 at gmail.com>
 */
public class Frm_Seleccionar_Cabina extends javax.swing.JInternalFrame {

    /**
     * Creates new form Frm_Seleccionar_Cabina
     */
    // Se crea un array de botones
    private final List<JButton> botones;
    // Se agrega un indice para prueba del nombre, aunque debería leer el nombre de la cabina.
    JButton b[];
    String cambiarFuncion[] = new String[6];

    Connection con = null;
    ResultSet rs = null;
    PreparedStatement pst = null;

    public static String ps_idCabina;
    public static String ps_nombreCabina;
    public static String ps_Precio;

    public Frm_Seleccionar_Cabina() {
        initComponents();
        agregarCabinas.setOpaque(false);
        opciones.setOpaque(false);
        initComponents();

        botones = new ArrayList<>();
        con = dbConnection.getConnection();
        Get_Data();

        NombreEmpleado.setText(Frm_Login.ps_NombreEmpleado);
        IdEmpleado.setText(Frm_Login.ps_idEmpleado);
        NombreEmpleado.setVisible(false);
        IdEmpleado.setVisible(false);
    }

    private void Get_Data() {
        String sqlQuery = "SELECT "
                + "`descripcion_cabina`, "
                + "`estado_cabina` "
                + "FROM `pct3`.`cabina` AS `cabina` "
                + "ORDER BY `estado_cabina` ASC";
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
                    btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/racing.png"))); // NOI18N
                    btn.addActionListener(new Frm_Seleccionar_Cabina.ActionListener() {
                        @Override
                        public void actionPerformed(java.awt.event.ActionEvent e) {
                            int seleccion = JOptionPane.showOptionDialog(
                                    null,
                                    "Seleccione opcion",
                                    "Selector de opciones",
                                    JOptionPane.YES_NO_OPTION,
                                    JOptionPane.QUESTION_MESSAGE,
                                    null, // null para icono por defecto.
                                    new Object[]{"Liberar Cabina", "Cancelar"}, // null para YES, NO y CANCEL
                                    "Cancelar");
                            if (seleccion == 0) {
                                try {
                                    int P = JOptionPane.showConfirmDialog(null, " Liberar la Cabina # " + nombreCabina + " ?", "Confirmación", JOptionPane.YES_NO_OPTION);
                                    if (P == 0) {
                                        con = dbConnection.getConnection();
                                        Statement stmt;
                                        stmt = con.createStatement();

                                        String Pru = "UPDATE `cabina` SET `estado_cabina` = 'Libre' WHERE `descripcion_cabina` = '" + nombreCabina + "' ";
                                        pst = con.prepareStatement(Pru);
                                        pst.execute();
                                        JOptionPane.showMessageDialog(null, "Actualizado con Exito saved", "Estado de Cabina", JOptionPane.INFORMATION_MESSAGE);
                                        agregarCabinas.removeAll();
                                        agregarCabinas.updateUI();
                                    }

                                } catch (HeadlessException | SQLException ex) {
                                    JOptionPane.showMessageDialog(null, ex);
                                }
                            }
                        }
                    });
                    totalRegistros++;
                }
                //cambia los iconos especifico dependiendo de el estado de la cabina.
                if (rs.getString(2).equals("Libre")) {
                    btn.setBackground(Color.green);
                    btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/house.png"))); // NOI18N
                }
                //cambia los iconos especifico dependiendo de el estado de la cabina.
                if (rs.getString(2).equals("Limpieza")) {
                    btn.setBackground(Color.yellow);
                    btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/wiping.png"))); // NOI18N
                }
                //cambia los iconos especifico dependiendo de el estado de la cabina.
                if (rs.getString(2).equals("Bloqueo")) {
                    btn.setBackground(Color.yellow);
                    btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/blocked.png"))); // NOI18N
                }

            }

            agregarCabinas.updateUI();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);

        }
    }

    private void Get_Bloqueo() {
        //Select sobre el estatus_empleado y se le asigna el valor a la columna de la tabla del formulario.

        String sqlQuery = "SELECT `descripcion_cabina`, `estado_cabina`, `cabina_id`, `precio` FROM "
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

                String idCabina = rs.getString(3);
                String precioCabina = rs.getString(4);
                ps_Precio = precioCabina;
                ps_idCabina = idCabina;
                ps_nombreCabina = nombreCabina;
                agregarCabinas.add(btn);

                if (rs.getString(2).equals("Ocupado")) {
                    btn.setBackground(Color.red);
                    btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/racing.png"))); // NOI18N
                }
                if (rs.getString(2).equals("Libre")) {
                    btn.setBackground(Color.green);
                    btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/house.png"))); // NOI18N
                }
                if (rs.getString(2).equals("Limpieza")) {
                    btn.setBackground(Color.yellow);
                    btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/wiping.png"))); // NOI18N
                }
                if (rs.getString(2).equals("Bloqueo")) {
                    btn.setBackground(Color.yellow);
                    btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/blocked.png"))); // NOI18N
                    btn.addActionListener(new Frm_Seleccionar_Cabina.ActionListener() {
                        @Override
                        public void actionPerformed(java.awt.event.ActionEvent e) {
                            try {

                                con = dbConnection.getConnection();
                                Statement stmt;
                                stmt = con.createStatement();

                                String Pru = "UPDATE `cabina` SET `estado_cabina` = 'Libre' WHERE `descripcion_cabina` = '" + nombreCabina + "' ";
                                pst = con.prepareStatement(Pru);
                                pst.execute();
                                btn.addActionListener(new Frm_Seleccionar_Cabina.ActionListener() {

                                    @Override
                                    public void actionPerformed(java.awt.event.ActionEvent e) {
                                        Frm_NuevaFactura form = new Frm_NuevaFactura();
                                        escritorio.add(form);
                                        form.toFront();
                                        form.setVisible(true);
                                        Frm_NuevaFactura.nCabina.setText(nombreCabina);
                                        ps_Precio = precioCabina;
                                        ps_idCabina = idCabina;
                                        ps_nombreCabina = nombreCabina;
                                    }
                                });

                            } catch (HeadlessException | SQLException ex) {
                                JOptionPane.showMessageDialog(null, ex);
                            }
                        }
                    });
                }

                totalRegistros++;

            }

            agregarCabinas.updateUI();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);

        }
    }

    private void Get_Libre() {
        //Select sobre el estatus_empleado y se le asigna el valor a la columna de la tabla del formulario.

        String sqlQuery = "SELECT `descripcion_cabina`, `estado_cabina`, `cabina_id`, `precio` FROM "
                + "`pct3`.`cabina` AS `cabina` WHERE `estado_cabina` = 'Libre' "
                + "ORDER BY `descripcion_cabina` ASC";
        String sqlQueryFactura = "";
        int totalRegistros;
        agregarCabinas.removeAll();
        try {
            pst = con.prepareStatement(sqlQuery);

            rs = pst.executeQuery();
            totalRegistros = 0;
            while (rs.next()) {
                String nombreCabina = rs.getString(1);
                JButton btn = new JButton(nombreCabina);
                String idCabina = rs.getString(3);
                String precioCabina = rs.getString(4);
                ps_Precio = precioCabina;
                ps_idCabina = idCabina;
                ps_nombreCabina = nombreCabina;
                agregarCabinas.add(btn);

                if (rs.getString(2).equals("Ocupado")) {
                    btn.setBackground(Color.red);
                    btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/racing.png"))); // NOI18N
                }
                if (rs.getString(2).equals("Libre")) {
                    btn.setBackground(Color.green);
                    btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/house.png"))); // NOI18N
                    btn.addActionListener(new Frm_Seleccionar_Cabina.ActionListener() {

                        @Override
                        public void actionPerformed(java.awt.event.ActionEvent e) {
                            Frm_NuevaFactura form = new Frm_NuevaFactura();
                            escritorio.add(form);
                            form.toFront();
                            form.setVisible(true);
                            Frm_NuevaFactura.nCabina.setText(nombreCabina);
                            Frm_NuevaFactura.idCabina.setText(idCabina);
                            Frm_NuevaFactura.Precio.setText(precioCabina);
                            ps_Precio = precioCabina;
                            ps_idCabina = idCabina;
                            ps_nombreCabina = nombreCabina;
                        }
                    });
                }
                if (rs.getString(2).equals("Limpieza")) {
                    btn.setBackground(Color.yellow);
                    btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/wiping.png"))); // NOI18N
                }
                if (rs.getString(2).equals("Bloqueo")) {
                    btn.setBackground(Color.yellow);
                    btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/blocked.png"))); // NOI18N
                }

                totalRegistros++;

            }

            agregarCabinas.updateUI();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);

        }
    }

    private void Get_Ocupado() {
        //Select sobre el estatus_empleado y se le asigna el valor a la columna de la tabla del formulario.

        String sqlQuery = "SELECT `descripcion_cabina`, `estado_cabina`, `cabina_id`, `precio` FROM `pct3`.`cabina` AS `cabina` WHERE `estado_cabina` = 'Ocupado' ORDER BY `descripcion_cabina` ASC";
        int totalRegistros;
        agregarCabinas.removeAll();
        try {
            pst = con.prepareStatement(sqlQuery);

            rs = pst.executeQuery();
            totalRegistros = 0;
            while (rs.next()) {
                String nombreCabina = rs.getString(1);
                String idCabina = rs.getString(3);
                String precioCabina = rs.getString(4);
                ps_Precio = precioCabina;
                ps_idCabina = idCabina;
                ps_nombreCabina = nombreCabina;
                JButton btn = new JButton(nombreCabina);
                agregarCabinas.add(btn);

                if (rs.getString(2).equals("Ocupado")) {
                    btn.setBackground(Color.red);
                    btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/racing.png"))); // NOI18N
                    btn.addActionListener(new Frm_Seleccionar_Cabina.ActionListener() {
                        @Override
                        public void actionPerformed(java.awt.event.ActionEvent e) {
                            try {
                                int P = JOptionPane.showConfirmDialog(null, " Quiere liberar la cábina # " + nombreCabina + " ?", "Confirmación", JOptionPane.YES_NO_OPTION);
                                if (P == 0) {
                                    con = dbConnection.getConnection();
                                    Statement stmt;
                                    stmt = con.createStatement();

                                    String Pru = "UPDATE `cabina` SET `estado_cabina` = 'Libre' WHERE `descripcion_cabina` = '" + nombreCabina + "' ";
                                    pst = con.prepareStatement(Pru);
                                    pst.execute();
                                    JOptionPane.showMessageDialog(null, "Guardado con Exito saved", "Tipo de Usuario", JOptionPane.INFORMATION_MESSAGE);
                                    agregarCabinas.updateUI();

                                }

                            } catch (HeadlessException | SQLException ex) {
                                JOptionPane.showMessageDialog(null, ex);

                            }
                        }
                    });
                }
                if (rs.getString(2).equals("Libre")) {
                    btn.setBackground(Color.CYAN);
                    btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/house.png"))); // NOI18N
                }
                if (rs.getString(2).equals("Limpieza")) {
                    btn.setBackground(Color.yellow);
                    btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/wiping.png"))); // NOI18N
                }
                if (rs.getString(2).equals("Bloqueo")) {
                    btn.setBackground(Color.yellow);
                    btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/blocked.png"))); // NOI18N
                }
                btn.addActionListener(new Frm_Seleccionar_Cabina.ActionListener() {

                    @Override
                    public void actionPerformed(java.awt.event.ActionEvent e) {
                        System.out.println("Ocupado");
                    }
                });

                totalRegistros++;

            }

            agregarCabinas.updateUI();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);

        }
    }

    private void Get_Limpieza() {
        //Select sobre el estatus_empleado y se le asigna el valor a la columna de la tabla del formulario.

        String sqlQuery = "SELECT `descripcion_cabina`, `estado_cabina`, `cabina_id`, `precio` FROM `pct3`.`cabina` AS `cabina` WHERE `estado_cabina` = 'Limpieza' ORDER BY `descripcion_cabina` ASC";
        int totalRegistros;
        agregarCabinas.removeAll();
        try {
            pst = con.prepareStatement(sqlQuery);

            rs = pst.executeQuery();
            totalRegistros = 0;
            while (rs.next()) {
                String nombreCabina = rs.getString(1);
                JButton btn = new JButton(nombreCabina);
                String idCabina = rs.getString(3);
                String precioCabina = rs.getString(4);
//                ps_Precio = precioCabina;
                ps_idCabina = idCabina;
                ps_nombreCabina = nombreCabina;
                agregarCabinas.add(btn);
                System.out.println(ps_Precio);

                if (rs.getString(2).equals("Ocupado")) {
                    btn.setBackground(Color.red);
                    btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/racing.png"))); // NOI18N
                }
                if (rs.getString(2).equals("Libre")) {
                    btn.setBackground(Color.green);
                    btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/house.png"))); // NOI18N
                }
                if (rs.getString(2).equals("Limpieza")) {
                    btn.setBackground(Color.yellow);
                    btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/wiping.png"))); // NOI18N
                    btn.addActionListener(new Frm_Seleccionar_Cabina.ActionListener() {
                        @Override
                        public void actionPerformed(java.awt.event.ActionEvent e) {
                            try {
                                int P = JOptionPane.showConfirmDialog(null, " Quiere liberar la cábina # " + nombreCabina + " este dato ?", "Confirmación", JOptionPane.YES_NO_OPTION);
                                if (P == 0) {
                                    con = dbConnection.getConnection();
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
                    btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/blocked.png"))); // NOI18N
                }

                totalRegistros++;

            }

            agregarCabinas.updateUI();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);

        }
    }

    private void Get_Sencilla() {
        agregarCabinas.updateUI();
        String sqlQuery = "SELECT `descripcion_cabina`, `tipo_cabina`, `estado_cabina`, `cabina_id`, `precio` FROM `pct3`.`cabina` AS `cabina` WHERE `tipo_cabina` = 'Sencilla' ORDER BY `descripcion_cabina` ASC";
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

                String idCabina = rs.getString(4);
                String precioCabina = rs.getString(5);
                ps_Precio = precioCabina;
                ps_idCabina = idCabina;
                ps_nombreCabina = nombreCabina;
                agregarCabinas.add(btn);

                if (rs.getString(2).equals("Doble")) {
                    btn.setBackground(Color.green);
                    btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/queen.png"))); // NOI18N

                }
                if (rs.getString(2).equals("Sencilla")) {
                    btn.setBackground(Color.green);
                    btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/single.png"))); // NOI18N
                    btn.addActionListener(new Frm_Seleccionar_Cabina.ActionListener() {

                        @Override
                        public void actionPerformed(java.awt.event.ActionEvent e) {
                            Frm_NuevaFactura form = new Frm_NuevaFactura();
                            escritorio.add(form);
                            form.toFront();
                            form.setVisible(true);
                            Frm_NuevaFactura.nCabina.setText(nombreCabina);
                            Frm_NuevaFactura.idCabina.setText(idCabina);
                            Frm_NuevaFactura.Precio.setText(precioCabina);
                            ps_Precio = precioCabina;
                            ps_idCabina = idCabina;
                            ps_nombreCabina = nombreCabina;
                        }
                    });
                }

                if (rs.getString(3).equals("Ocupado")) {
                    btn.setBackground(Color.red);
                    btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/racing.png"))); // NOI18N
                    btn.addActionListener(new Frm_Seleccionar_Cabina.ActionListener() {
                        @Override
                        public void actionPerformed(java.awt.event.ActionEvent e) {
                            try {
                                int P = JOptionPane.showConfirmDialog(null, " Quiere liberar la cábina # " + nombreCabina + " ?", "Confirmación", JOptionPane.YES_NO_OPTION);
                                if (P == 0) {
                                    con = dbConnection.getConnection();
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

                if (rs.getString(3).equals("Limpieza")) {
                    btn.setBackground(Color.yellow);
                    btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/wiping.png"))); // NOI18N
                }
                if (rs.getString(3).equals("Bloqueo")) {
                    btn.setBackground(Color.yellow);
                    btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/blocked.png"))); // NOI18N
                }
                btn.addActionListener(new Frm_Seleccionar_Cabina.ActionListener() {

                    @Override
                    public void actionPerformed(java.awt.event.ActionEvent e) {
                        System.out.println("Ocupado");
                    }
                });

                totalRegistros++;

            }

            agregarCabinas.updateUI();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);

        }
    }

    private void Get_Doble() {
        agregarCabinas.updateUI();
        String sqlQuery = "SELECT `descripcion_cabina`, `tipo_cabina`, `estado_cabina`, `cabina_id`, `precio` FROM `pct3`.`cabina` AS `cabina` WHERE `tipo_cabina` = 'Doble' ORDER BY `descripcion_cabina` ASC";
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

                String idCabina = rs.getString(4);
                String precioCabina = rs.getString(5);
                ps_Precio = precioCabina;
                ps_idCabina = idCabina;
                ps_nombreCabina = nombreCabina;
                agregarCabinas.add(btn);

                if (rs.getString(2).equals("Doble")) {
                    btn.setBackground(Color.green);
                    btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/queen.png"))); // NOI18N
                    btn.addActionListener(new Frm_Seleccionar_Cabina.ActionListener() {

                        @Override
                        public void actionPerformed(java.awt.event.ActionEvent e) {
                            Frm_NuevaFactura form = new Frm_NuevaFactura();
                            escritorio.add(form);
                            form.toFront();
                            form.setVisible(true);
                            Frm_NuevaFactura.nCabina.setText(nombreCabina);
                            Frm_NuevaFactura.idCabina.setText(idCabina);
                            Frm_NuevaFactura.Precio.setText(precioCabina);
                            ps_Precio = precioCabina;
                            ps_idCabina = idCabina;
                            ps_nombreCabina = nombreCabina;
                        }
                    });
                }
                if (rs.getString(2).equals("Sencilla")) {
                    btn.setBackground(Color.green);
                    btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/single.png"))); // NOI18N

                }

                if (rs.getString(3).equals("Ocupado")) {
                    btn.setBackground(Color.red);
                    btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/racing.png"))); // NOI18N
                    btn.addActionListener(new Frm_Seleccionar_Cabina.ActionListener() {
                        @Override
                        public void actionPerformed(java.awt.event.ActionEvent e) {
                            try {
                                int P = JOptionPane.showConfirmDialog(null, " Quiere liberar la cábina # " + nombreCabina + " ?", "Confirmación", JOptionPane.YES_NO_OPTION);
                                if (P == 0) {
                                    con = dbConnection.getConnection();
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

                if (rs.getString(3).equals("Limpieza")) {
                    btn.setBackground(Color.yellow);
                    btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/wiping.png"))); // NOI18N
                }
                if (rs.getString(3).equals("Bloqueo")) {
                    btn.setBackground(Color.yellow);
                    btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/blocked.png"))); // NOI18N
                }
                btn.addActionListener(new Frm_Seleccionar_Cabina.ActionListener() {

                    @Override
                    public void actionPerformed(java.awt.event.ActionEvent e) {
                        System.out.println("Ocupado");
                    }
                });

                totalRegistros++;

            }

            agregarCabinas.updateUI();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);

        }
    }

    private static abstract class ActionListener implements java.awt.event.ActionListener {

        public ActionListener() {
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        opciones = new javax.swing.JPanel();
        Ocupado = new javax.swing.JRadioButton();
        Todos = new javax.swing.JRadioButton();
        Dobles = new javax.swing.JRadioButton();
        Vacio = new javax.swing.JRadioButton();
        Sencillas = new javax.swing.JRadioButton();
        NombreEmpleado = new javax.swing.JLabel();
        IdEmpleado = new javax.swing.JLabel();
        agregarCabinas = new javax.swing.JPanel();

        setClosable(true);
        setIconifiable(true);
        setTitle("Seleccionar Cábina");

        opciones.setBackground(new java.awt.Color(204, 204, 255));
        opciones.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        Ocupado.setBackground(new java.awt.Color(204, 204, 255));
        buttonGroup1.add(Ocupado);
        Ocupado.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        Ocupado.setForeground(new java.awt.Color(0, 0, 0));
        Ocupado.setText("Ocupado");
        Ocupado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OcupadoActionPerformed(evt);
            }
        });

        Todos.setBackground(new java.awt.Color(204, 204, 255));
        buttonGroup1.add(Todos);
        Todos.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        Todos.setForeground(new java.awt.Color(0, 0, 0));
        Todos.setText("Todos");
        Todos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TodosActionPerformed(evt);
            }
        });

        Dobles.setBackground(new java.awt.Color(204, 204, 255));
        buttonGroup1.add(Dobles);
        Dobles.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        Dobles.setForeground(new java.awt.Color(0, 0, 0));
        Dobles.setText("Hab. Doble");
        Dobles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DoblesActionPerformed(evt);
            }
        });

        Vacio.setBackground(new java.awt.Color(204, 204, 255));
        buttonGroup1.add(Vacio);
        Vacio.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        Vacio.setForeground(new java.awt.Color(0, 0, 0));
        Vacio.setText("Facturar");
        Vacio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VacioActionPerformed(evt);
            }
        });

        Sencillas.setBackground(new java.awt.Color(204, 204, 255));
        buttonGroup1.add(Sencillas);
        Sencillas.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        Sencillas.setForeground(new java.awt.Color(0, 0, 0));
        Sencillas.setText("Hab. Sencilla");
        Sencillas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SencillasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout opcionesLayout = new javax.swing.GroupLayout(opciones);
        opciones.setLayout(opcionesLayout);
        opcionesLayout.setHorizontalGroup(
            opcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(opcionesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(opcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Dobles)
                    .addComponent(Sencillas)
                    .addComponent(Ocupado)
                    .addComponent(Vacio)
                    .addComponent(Todos))
                .addContainerGap(384, Short.MAX_VALUE))
        );
        opcionesLayout.setVerticalGroup(
            opcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(opcionesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Vacio)
                .addGap(18, 18, 18)
                .addComponent(Todos)
                .addGap(18, 18, 18)
                .addComponent(Ocupado)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addComponent(Sencillas)
                .addGap(18, 18, 18)
                .addComponent(Dobles)
                .addGap(43, 43, 43))
        );

        agregarCabinas.setLayout(new java.awt.GridLayout(0, 3));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(694, Short.MAX_VALUE)
                .addComponent(agregarCabinas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap(166, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(IdEmpleado)
                        .addComponent(NombreEmpleado)
                        .addComponent(opciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(agregarCabinas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(282, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(IdEmpleado))
                        .addGroup(layout.createSequentialGroup()
                            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(NombreEmpleado)))
                    .addGap(0, 0, Short.MAX_VALUE))
                .addGroup(layout.createSequentialGroup()
                    .addGap(8, 8, 8)
                    .addComponent(opciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

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
        agregarCabinas.updateUI();
        Get_Data();
    }//GEN-LAST:event_TodosActionPerformed

    private void DoblesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DoblesActionPerformed
        // TODO add your handling code here:
        agregarCabinas.removeAll();
        Get_Doble();
    }//GEN-LAST:event_DoblesActionPerformed

    private void VacioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VacioActionPerformed
        // TODO add your handling code here:
        agregarCabinas.removeAll();
        Get_Libre();
    }//GEN-LAST:event_VacioActionPerformed

    private void SencillasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SencillasActionPerformed
        // TODO add your handling code here:
        agregarCabinas.removeAll();
        Get_Sencilla();
    }//GEN-LAST:event_SencillasActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton Dobles;
    public static javax.swing.JLabel IdEmpleado;
    public static javax.swing.JLabel NombreEmpleado;
    private javax.swing.JRadioButton Ocupado;
    private javax.swing.JRadioButton Sencillas;
    private javax.swing.JRadioButton Todos;
    private javax.swing.JRadioButton Vacio;
    private javax.swing.JPanel agregarCabinas;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JPanel opciones;
    // End of variables declaration//GEN-END:variables
}
