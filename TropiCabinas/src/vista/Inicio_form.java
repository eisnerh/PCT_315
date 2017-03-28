/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.ConexionDB;
import java.awt.Component;
import java.io.File;
import java.sql.Connection;
import javax.swing.ImageIcon;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author CARLOS
 */
public class Inicio_form extends javax.swing.JFrame {

    /**
     * Creates new form frminicio
     */
    Connection con = null;

    public Inicio_form() {
        //inicialización de las variables de la coneccion a la base de datos
        con = ConexionDB.conexionDB();
        initComponents();
        this.setExtendedState(Inicio_form.MAXIMIZED_BOTH);
        this.setTitle("Sistema de Reserva de Cábinas y Gestión - Cábinas el Trópico");
        setIconImage(new ImageIcon(getClass().getResource("../Files/Home.png")).getImage());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        escritorio = new javax.swing.JDesktopPane();
        IdEmpleado = new javax.swing.JLabel();
        Nombre_Empleado = new javax.swing.JLabel();
        lblacceso = new javax.swing.JLabel();
        menuBar = new javax.swing.JMenuBar();
        mnusisreserva = new javax.swing.JMenu();
        mnuarchivo = new javax.swing.JMenu();
        itemAgregarCabina = new javax.swing.JMenuItem();
        itemDisponibles = new javax.swing.JMenuItem();
        mnureservas = new javax.swing.JMenu();
        contentMenuItem = new javax.swing.JMenuItem();
        aboutMenuItem = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        mnuconsultas = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();
        lista_x_cabina = new javax.swing.JMenuItem();
        mnuConfiguraciones = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        mnuHerramientas = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        mnuAyuda = new javax.swing.JMenu();
        itemAcerca = new javax.swing.JMenuItem();
        itemAyuda = new javax.swing.JMenuItem();
        mnuSalir = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        escritorio.setBackground(new java.awt.Color(102, 255, 255));

        IdEmpleado.setFont(new java.awt.Font("Hack", 1, 18)); // NOI18N
        IdEmpleado.setForeground(new java.awt.Color(0, 204, 0));
        IdEmpleado.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        IdEmpleado.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        escritorio.add(IdEmpleado);
        IdEmpleado.setBounds(20, 10, 200, 40);

        Nombre_Empleado.setFont(new java.awt.Font("Hack", 1, 18)); // NOI18N
        Nombre_Empleado.setForeground(new java.awt.Color(0, 204, 0));
        Nombre_Empleado.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Nombre_Empleado.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        escritorio.add(Nombre_Empleado);
        Nombre_Empleado.setBounds(20, 60, 200, 40);

        lblacceso.setFont(new java.awt.Font("Hack", 1, 18)); // NOI18N
        lblacceso.setForeground(new java.awt.Color(0, 204, 0));
        lblacceso.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblacceso.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        escritorio.add(lblacceso);
        lblacceso.setBounds(20, 120, 200, 40);

        mnusisreserva.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/Inicio.png"))); // NOI18N
        mnusisreserva.setMnemonic('f');
        mnusisreserva.setText("TropiCabinas");
        menuBar.add(mnusisreserva);

        mnuarchivo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/Archivo.png"))); // NOI18N
        mnuarchivo.setMnemonic('e');
        mnuarchivo.setText("Archivo");

        itemAgregarCabina.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_H, java.awt.event.InputEvent.CTRL_MASK));
        itemAgregarCabina.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/productos.png"))); // NOI18N
        itemAgregarCabina.setMnemonic('t');
        itemAgregarCabina.setText("Agregar Cábina");
        itemAgregarCabina.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemAgregarCabinaActionPerformed(evt);
            }
        });
        mnuarchivo.add(itemAgregarCabina);

        itemDisponibles.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.CTRL_MASK));
        itemDisponibles.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/habitaciones.png"))); // NOI18N
        itemDisponibles.setMnemonic('y');
        itemDisponibles.setText("Cábinas Disponibles");
        itemDisponibles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemDisponiblesActionPerformed(evt);
            }
        });
        mnuarchivo.add(itemDisponibles);

        menuBar.add(mnuarchivo);

        mnureservas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/Reservas.png"))); // NOI18N
        mnureservas.setMnemonic('h');
        mnureservas.setText("Reservas");

        contentMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.event.InputEvent.CTRL_MASK));
        contentMenuItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/reservas-consumos.png"))); // NOI18N
        contentMenuItem.setMnemonic('c');
        contentMenuItem.setText("Alquiler");
        contentMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                contentMenuItemActionPerformed(evt);
            }
        });
        mnureservas.add(contentMenuItem);

        aboutMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.CTRL_MASK));
        aboutMenuItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/clientes.png"))); // NOI18N
        aboutMenuItem.setMnemonic('a');
        aboutMenuItem.setText("Clientes");
        aboutMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aboutMenuItemActionPerformed(evt);
            }
        });
        mnureservas.add(aboutMenuItem);

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_G, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/pagos.png"))); // NOI18N
        jMenuItem1.setText("Pagos");
        mnureservas.add(jMenuItem1);

        menuBar.add(mnureservas);

        mnuconsultas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/Consultas.png"))); // NOI18N
        mnuconsultas.setText("Consultas");

        jMenuItem4.setText("Lista de Cabinas");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        mnuconsultas.add(jMenuItem4);

        lista_x_cabina.setText("Cabina");
        lista_x_cabina.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lista_x_cabinaActionPerformed(evt);
            }
        });
        mnuconsultas.add(lista_x_cabina);

        menuBar.add(mnuconsultas);

        mnuConfiguraciones.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/Configuraciones.png"))); // NOI18N
        mnuConfiguraciones.setText("Configuraciones");

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_U, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/trabajadores.png"))); // NOI18N
        jMenuItem2.setText("Usuarios y Accesos");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        mnuConfiguraciones.add(jMenuItem2);

        jMenuItem6.setText("Nueva Persona");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        mnuConfiguraciones.add(jMenuItem6);

        menuBar.add(mnuConfiguraciones);

        mnuHerramientas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/Herramientas.png"))); // NOI18N
        mnuHerramientas.setText("Herramientas");

        jMenuItem3.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_T, java.awt.event.InputEvent.ALT_MASK));
        jMenuItem3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/members.png"))); // NOI18N
        jMenuItem3.setText("Agregar Tipo Persona");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        mnuHerramientas.add(jMenuItem3);

        jMenuItem5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/horario.png"))); // NOI18N
        jMenuItem5.setText("Horarios");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        mnuHerramientas.add(jMenuItem5);

        menuBar.add(mnuHerramientas);

        mnuAyuda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/Ayuda.png"))); // NOI18N
        mnuAyuda.setText("Ayuda");

        itemAcerca.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.CTRL_MASK));
        itemAcerca.setText("Acerca de...");
        mnuAyuda.add(itemAcerca);

        itemAyuda.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_H, java.awt.event.InputEvent.CTRL_MASK));
        itemAyuda.setText("Ayuda");
        itemAyuda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemAyudaActionPerformed(evt);
            }
        });
        mnuAyuda.add(itemAyuda);

        menuBar.add(mnuAyuda);

        mnuSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/Salir.png"))); // NOI18N
        mnuSalir.setText("Salir");
        mnuSalir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mnuSalirMouseClicked(evt);
            }
        });
        menuBar.add(mnuSalir);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(escritorio, javax.swing.GroupLayout.DEFAULT_SIZE, 849, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(escritorio, javax.swing.GroupLayout.DEFAULT_SIZE, 453, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void itemAyudaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemAyudaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_itemAyudaActionPerformed

    private void itemAgregarCabinaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemAgregarCabinaActionPerformed
        Agregar_Cabina form = new Agregar_Cabina();
        Component add;
        add = escritorio.add(form);
        form.toFront();
        form.setVisible(true);
    }//GEN-LAST:event_itemAgregarCabinaActionPerformed

    private void itemDisponiblesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemDisponiblesActionPerformed

        Seleccionar_Cabina_frm form = new Seleccionar_Cabina_frm();
        escritorio.add(form);
        form.toFront();
        form.setVisible(true);

    }//GEN-LAST:event_itemDisponiblesActionPerformed

    private void aboutMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aboutMenuItemActionPerformed
        // TODO add your handling code here:
//        frmcliente form =new frmcliente();
//        escritorio.add(form);
//        form.toFront();
//        form.setVisible(true);
    }//GEN-LAST:event_aboutMenuItemActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
//        frmtrabajador form =new frmtrabajador();
//        escritorio.add(form);
//        form.toFront();
//        form.setVisible(true);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void mnuSalirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mnuSalirMouseClicked
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_mnuSalirMouseClicked

    private void contentMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_contentMenuItemActionPerformed
        // TODO add your handling code here:
//        frmreserva form = new frmreserva();
//        escritorio.add(form);
//        form.toFront();
//        form.setVisible(true);
//        frmreserva.txtidtrabajador.setText(lblidpersona.getText());
//        frmreserva.txttrabajador.setText(lblnombre.getText() + " " + lblapaterno.getText());
//        frmreserva.idusuario=Integer.parseInt(lblidpersona.getText());
    }//GEN-LAST:event_contentMenuItemActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        // TODO add your handling code here:
        JasperReport report;
        JasperPrint print;

        try {
            report = JasperCompileManager.compileReport(new File("").getAbsolutePath()
                    + "/src/vista/reportes/ListaCabinas.jrxml");
            print = JasperFillManager.fillReport(report, null, con);
            JasperViewer view = new JasperViewer(print, false);
            view.setTitle("Lista de Habitaciones");
            view.setVisible(true);

        } catch (JRException e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void lista_x_cabinaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lista_x_cabinaActionPerformed
        // TODO add your handling code here:
        Reporte_x_Cabina form = new Reporte_x_Cabina();
        escritorio.add(form);
        form.toFront();
        form.setVisible(true);
    }//GEN-LAST:event_lista_x_cabinaActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        // TODO add your handling code here:
        Horario_form form = new Horario_form();
        escritorio.add(form);
        form.toFront();
        form.setVisible(true);
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        // TODO add your handling code here:
        TipoPersona form = new TipoPersona();
        escritorio.add(form);
        form.toFront();
        form.setVisible(true);
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        // TODO add your handling code here:
        Personas_frm form = new Personas_frm();
        escritorio.add(form);
        form.toFront();
        form.setVisible(true);
    }//GEN-LAST:event_jMenuItem6ActionPerformed

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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Inicio_form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Inicio_form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Inicio_form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Inicio_form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Inicio_form().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JLabel IdEmpleado;
    public static javax.swing.JLabel Nombre_Empleado;
    private javax.swing.JMenuItem aboutMenuItem;
    private javax.swing.JMenuItem contentMenuItem;
    public static javax.swing.JDesktopPane escritorio;
    private javax.swing.JMenuItem itemAcerca;
    private javax.swing.JMenuItem itemAgregarCabina;
    private javax.swing.JMenuItem itemAyuda;
    private javax.swing.JMenuItem itemDisponibles;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    public static javax.swing.JLabel lblacceso;
    private javax.swing.JMenuItem lista_x_cabina;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenu mnuAyuda;
    public static javax.swing.JMenu mnuConfiguraciones;
    private javax.swing.JMenu mnuHerramientas;
    private javax.swing.JMenu mnuSalir;
    public static javax.swing.JMenu mnuarchivo;
    private javax.swing.JMenu mnuconsultas;
    private javax.swing.JMenu mnureservas;
    private javax.swing.JMenu mnusisreserva;
    // End of variables declaration//GEN-END:variables

}
