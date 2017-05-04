/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.dbConnection;
import java.awt.Component;
import java.io.File;
import java.sql.Connection;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Eisner López Acevedo <eisner.lopez at gmail.com>
 * @author Cesar Gonzalez Salas <cgonzalez816 at gmail.com>
 */
public class Frm_Inicio extends javax.swing.JFrame {

    /**
     * Creates new form frminicio
     */
    Connection con = null;

    public Frm_Inicio() {
        //inicialización de las variables de la coneccion a la base de datos
        con = dbConnection.getConnection();
        initComponents();
        this.setExtendedState(Frm_Inicio.MAXIMIZED_BOTH);
        this.setTitle("Sistema de Reserva de Cábinas y Gestión - Cábinas el Trópico");
        setIconImage(new ImageIcon(getClass().getResource("../Files/Home.png")).getImage());
        IdEmpleado.setVisible(false);
        lblacceso.setVisible(false);
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
        lblPuesto = new javax.swing.JLabel();
        menuBar = new javax.swing.JMenuBar();
        mnusisreserva = new javax.swing.JMenu();
        mnuarchivo = new javax.swing.JMenu();
        itemClientes = new javax.swing.JMenuItem();
        itemAgregarCabina = new javax.swing.JMenuItem();
        itemGastosPlanilla = new javax.swing.JMenuItem();
        itemProductos = new javax.swing.JMenuItem();
        mnureservas = new javax.swing.JMenu();
        itemDisponibles = new javax.swing.JMenuItem();
        mnuconsultas = new javax.swing.JMenu();
        itemListaCabina = new javax.swing.JMenuItem();
        itemCabina = new javax.swing.JMenuItem();
        itemListaClientes = new javax.swing.JMenuItem();
        itemRImprimirFactura = new javax.swing.JMenuItem();
        itemFacturasxCliente = new javax.swing.JMenuItem();
        itemProductosxProveedor = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        itmListaGastosDiarios = new javax.swing.JMenuItem();
        itemGastosRangoFechas = new javax.swing.JMenuItem();
        itemListaProductos = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        mnuConfiguraciones = new javax.swing.JMenu();
        itemUsuarios = new javax.swing.JMenuItem();
        itemColaborador = new javax.swing.JMenuItem();
        itemProveedor = new javax.swing.JMenuItem();
        mnuHerramientas = new javax.swing.JMenu();
        itemTipoPersona = new javax.swing.JMenuItem();
        itemHorarios = new javax.swing.JMenuItem();
        itemPuesto = new javax.swing.JMenuItem();
        mnuAyuda = new javax.swing.JMenu();
        itemAcerca = new javax.swing.JMenuItem();
        mnuSalir = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        escritorio.setBackground(new java.awt.Color(102, 255, 255));

        IdEmpleado.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        IdEmpleado.setForeground(new java.awt.Color(255, 255, 255));
        IdEmpleado.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        IdEmpleado.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        escritorio.add(IdEmpleado);
        IdEmpleado.setBounds(20, 10, 200, 40);

        Nombre_Empleado.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        Nombre_Empleado.setForeground(new java.awt.Color(255, 255, 255));
        Nombre_Empleado.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Nombre_Empleado.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Usuario", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(255, 255, 255))); // NOI18N
        escritorio.add(Nombre_Empleado);
        Nombre_Empleado.setBounds(20, 60, 200, 60);

        lblacceso.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        lblacceso.setForeground(new java.awt.Color(255, 255, 255));
        lblacceso.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblacceso.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        escritorio.add(lblacceso);
        lblacceso.setBounds(240, 10, 200, 40);

        lblPuesto.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        lblPuesto.setForeground(new java.awt.Color(255, 255, 255));
        lblPuesto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPuesto.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tipo de Usuario", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(255, 255, 255))); // NOI18N
        escritorio.add(lblPuesto);
        lblPuesto.setBounds(240, 60, 200, 60);

        menuBar.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N

        mnusisreserva.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/Inicio.png"))); // NOI18N
        mnusisreserva.setMnemonic('f');
        mnusisreserva.setText("TropiCabinas");
        mnusisreserva.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        menuBar.add(mnusisreserva);

        mnuarchivo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/Archivo.png"))); // NOI18N
        mnuarchivo.setMnemonic('e');
        mnuarchivo.setText("Archivo");
        mnuarchivo.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N

        itemClientes.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.CTRL_MASK));
        itemClientes.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        itemClientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/clientes.png"))); // NOI18N
        itemClientes.setMnemonic('a');
        itemClientes.setText("Clientes");
        itemClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemClientesActionPerformed(evt);
            }
        });
        mnuarchivo.add(itemClientes);

        itemAgregarCabina.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_H, java.awt.event.InputEvent.CTRL_MASK));
        itemAgregarCabina.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        itemAgregarCabina.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/1-39-128.png"))); // NOI18N
        itemAgregarCabina.setMnemonic('t');
        itemAgregarCabina.setText("Agregar Cábina");
        itemAgregarCabina.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemAgregarCabinaActionPerformed(evt);
            }
        });
        mnuarchivo.add(itemAgregarCabina);

        itemGastosPlanilla.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.ALT_MASK));
        itemGastosPlanilla.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        itemGastosPlanilla.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/empeados_icono.png"))); // NOI18N
        itemGastosPlanilla.setText("Planilla");
        itemGastosPlanilla.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemGastosPlanillaActionPerformed(evt);
            }
        });
        mnuarchivo.add(itemGastosPlanilla);

        itemProductos.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_G, java.awt.event.InputEvent.CTRL_MASK));
        itemProductos.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        itemProductos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/pagos.png"))); // NOI18N
        itemProductos.setText("Gastos por Productos");
        itemProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemProductosActionPerformed(evt);
            }
        });
        mnuarchivo.add(itemProductos);

        menuBar.add(mnuarchivo);

        mnureservas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/Reservas.png"))); // NOI18N
        mnureservas.setMnemonic('h');
        mnureservas.setText("Reservas");
        mnureservas.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N

        itemDisponibles.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.CTRL_MASK));
        itemDisponibles.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        itemDisponibles.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/reservas-consumos.png"))); // NOI18N
        itemDisponibles.setMnemonic('y');
        itemDisponibles.setText("Alquiler");
        itemDisponibles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemDisponiblesActionPerformed(evt);
            }
        });
        mnureservas.add(itemDisponibles);

        menuBar.add(mnureservas);

        mnuconsultas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/Consultas.png"))); // NOI18N
        mnuconsultas.setText("Consultas");
        mnuconsultas.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N

        itemListaCabina.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_B, java.awt.event.InputEvent.ALT_MASK));
        itemListaCabina.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        itemListaCabina.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/rsz_town-512.png"))); // NOI18N
        itemListaCabina.setText("Lista de Cabinas");
        itemListaCabina.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemListaCabinaActionPerformed(evt);
            }
        });
        mnuconsultas.add(itemListaCabina);

        itemCabina.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_G, java.awt.event.InputEvent.ALT_MASK));
        itemCabina.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        itemCabina.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/1-39-128.png"))); // NOI18N
        itemCabina.setText("Cabina");
        itemCabina.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemCabinaActionPerformed(evt);
            }
        });
        mnuconsultas.add(itemCabina);

        itemListaClientes.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_J, java.awt.event.InputEvent.ALT_MASK));
        itemListaClientes.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        itemListaClientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/Market-Research_icon.png"))); // NOI18N
        itemListaClientes.setText("Clientes");
        itemListaClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemListaClientesActionPerformed(evt);
            }
        });
        mnuconsultas.add(itemListaClientes);

        itemRImprimirFactura.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.event.InputEvent.ALT_MASK));
        itemRImprimirFactura.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        itemRImprimirFactura.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/browser_64px.png"))); // NOI18N
        itemRImprimirFactura.setText("Re Imprimir Factura");
        itemRImprimirFactura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemRImprimirFacturaActionPerformed(evt);
            }
        });
        mnuconsultas.add(itemRImprimirFactura);

        itemFacturasxCliente.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.ALT_MASK));
        itemFacturasxCliente.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        itemFacturasxCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/empeados_icono.png"))); // NOI18N
        itemFacturasxCliente.setText("Factura x Cliente");
        itemFacturasxCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemFacturasxClienteActionPerformed(evt);
            }
        });
        mnuconsultas.add(itemFacturasxCliente);

        itemProductosxProveedor.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_L, java.awt.event.InputEvent.ALT_MASK));
        itemProductosxProveedor.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        itemProductosxProveedor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/PROVEEDORES.png"))); // NOI18N
        itemProductosxProveedor.setText("Productos x Proveedor");
        itemProductosxProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemProductosxProveedorActionPerformed(evt);
            }
        });
        mnuconsultas.add(itemProductosxProveedor);

        jMenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/wallet_64px.png"))); // NOI18N
        jMenu1.setText("Menu Gastos");
        jMenu1.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N

        itmListaGastosDiarios.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_D, java.awt.event.InputEvent.ALT_MASK));
        itmListaGastosDiarios.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        itmListaGastosDiarios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/bookshelf_64px.png"))); // NOI18N
        itmListaGastosDiarios.setText("Lista de Gastos Diarios");
        itmListaGastosDiarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itmListaGastosDiariosActionPerformed(evt);
            }
        });
        jMenu1.add(itmListaGastosDiarios);

        itemGastosRangoFechas.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.ALT_MASK));
        itemGastosRangoFechas.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        itemGastosRangoFechas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/layers_64px.png"))); // NOI18N
        itemGastosRangoFechas.setText("Gastos por Fechas");
        itemGastosRangoFechas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemGastosRangoFechasActionPerformed(evt);
            }
        });
        jMenu1.add(itemGastosRangoFechas);

        itemListaProductos.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.ALT_MASK));
        itemListaProductos.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        itemListaProductos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/rsz_productos.png"))); // NOI18N
        itemListaProductos.setText("Productos");
        itemListaProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemListaProductosActionPerformed(evt);
            }
        });
        jMenu1.add(itemListaProductos);

        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/Market-Research_icon.png"))); // NOI18N
        jMenuItem1.setText("Planillas");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        mnuconsultas.add(jMenu1);

        menuBar.add(mnuconsultas);

        mnuConfiguraciones.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/Configuraciones.png"))); // NOI18N
        mnuConfiguraciones.setText("Datos");
        mnuConfiguraciones.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N

        itemUsuarios.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_U, java.awt.event.InputEvent.CTRL_MASK));
        itemUsuarios.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        itemUsuarios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/trabajadores.png"))); // NOI18N
        itemUsuarios.setText("Usuarios y Accesos");
        itemUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemUsuariosActionPerformed(evt);
            }
        });
        mnuConfiguraciones.add(itemUsuarios);

        itemColaborador.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.ALT_MASK));
        itemColaborador.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        itemColaborador.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/empeados_icono.png"))); // NOI18N
        itemColaborador.setText("Colaborador");
        itemColaborador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemColaboradorActionPerformed(evt);
            }
        });
        mnuConfiguraciones.add(itemColaborador);

        itemProveedor.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.ALT_MASK));
        itemProveedor.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        itemProveedor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/PROVEEDORES.png"))); // NOI18N
        itemProveedor.setText("Proveedor");
        itemProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemProveedorActionPerformed(evt);
            }
        });
        mnuConfiguraciones.add(itemProveedor);

        menuBar.add(mnuConfiguraciones);

        mnuHerramientas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/Herramientas.png"))); // NOI18N
        mnuHerramientas.setText("Mantenimiento");
        mnuHerramientas.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N

        itemTipoPersona.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_T, java.awt.event.InputEvent.ALT_MASK));
        itemTipoPersona.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        itemTipoPersona.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/members.png"))); // NOI18N
        itemTipoPersona.setText("Agregar Tipo Persona");
        itemTipoPersona.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemTipoPersonaActionPerformed(evt);
            }
        });
        mnuHerramientas.add(itemTipoPersona);

        itemHorarios.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Z, java.awt.event.InputEvent.ALT_MASK));
        itemHorarios.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        itemHorarios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/horario.png"))); // NOI18N
        itemHorarios.setText("Horarios");
        itemHorarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemHorariosActionPerformed(evt);
            }
        });
        mnuHerramientas.add(itemHorarios);

        itemPuesto.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Q, java.awt.event.InputEvent.ALT_MASK));
        itemPuesto.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        itemPuesto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/position.png"))); // NOI18N
        itemPuesto.setText("Puesto");
        itemPuesto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemPuestoActionPerformed(evt);
            }
        });
        mnuHerramientas.add(itemPuesto);

        menuBar.add(mnuHerramientas);

        mnuAyuda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/Ayuda.png"))); // NOI18N
        mnuAyuda.setText("Ayuda");
        mnuAyuda.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N

        itemAcerca.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.CTRL_MASK));
        itemAcerca.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        itemAcerca.setText("Acerca de...");
        itemAcerca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemAcercaActionPerformed(evt);
            }
        });
        mnuAyuda.add(itemAcerca);

        menuBar.add(mnuAyuda);

        mnuSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/Salir.png"))); // NOI18N
        mnuSalir.setText("Salir");
        mnuSalir.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
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

    private void itemAgregarCabinaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemAgregarCabinaActionPerformed
        Frm_Agregar_Cabina form = new Frm_Agregar_Cabina();
        Component add;
        add = escritorio.add(form);
        form.toFront();
        form.setVisible(true);
    }//GEN-LAST:event_itemAgregarCabinaActionPerformed

    private void itemDisponiblesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemDisponiblesActionPerformed

        Frm_Seleccionar_Cabina form = new Frm_Seleccionar_Cabina();
        escritorio.add(form);
        form.toFront();
        form.setVisible(true);

    }//GEN-LAST:event_itemDisponiblesActionPerformed

    private void itemClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemClientesActionPerformed
        // TODO add your handling code here:
        Frm_Agregar_Cliente form;
        form = new Frm_Agregar_Cliente();
        escritorio.add(form);
        form.toFront();
        form.setVisible(true);
    }//GEN-LAST:event_itemClientesActionPerformed

    private void itemUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemUsuariosActionPerformed
        Frm_Agregar_Usuario form;
        form = new Frm_Agregar_Usuario();
        escritorio.add(form);
        form.toFront();
        form.setVisible(true);
    }//GEN-LAST:event_itemUsuariosActionPerformed

    private void mnuSalirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mnuSalirMouseClicked
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_mnuSalirMouseClicked

    private void itemListaCabinaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemListaCabinaActionPerformed
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
            JOptionPane.showMessageDialog(this, e);
        }
    }//GEN-LAST:event_itemListaCabinaActionPerformed

    private void itemCabinaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemCabinaActionPerformed
        // TODO add your handling code here:
        Frm_Reporte_x_Cabina form = new Frm_Reporte_x_Cabina();
        escritorio.add(form);
        form.toFront();
        form.setVisible(true);
    }//GEN-LAST:event_itemCabinaActionPerformed

    private void itemHorariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemHorariosActionPerformed
        // TODO add your handling code here:
        Frm_Horario form = new Frm_Horario();
        escritorio.add(form);
        form.toFront();
        form.setVisible(true);
    }//GEN-LAST:event_itemHorariosActionPerformed

    private void itemTipoPersonaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemTipoPersonaActionPerformed
        // TODO add your handling code here:
        Frm_TipoPersona form = new Frm_TipoPersona();
        escritorio.add(form);
        form.toFront();
        form.setVisible(true);
    }//GEN-LAST:event_itemTipoPersonaActionPerformed

    private void itemColaboradorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemColaboradorActionPerformed
        // TODO add your handling code here:
        Frm_Agregar_Colaborador form = new Frm_Agregar_Colaborador();
        escritorio.add(form);
        form.toFront();
        form.setVisible(true);
    }//GEN-LAST:event_itemColaboradorActionPerformed

    private void itemListaClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemListaClientesActionPerformed
        // TODO add your handling code here:
        JasperReport report;
        JasperPrint print;

        try {
            report = JasperCompileManager.compileReport(new File("").getAbsolutePath()
                    + "/src/vista/reportes/Clientes_Estados.jrxml");
            print = JasperFillManager.fillReport(report, null, con);
            JasperViewer view = new JasperViewer(print, false);
            view.setTitle("Lista de Habitaciones");
            view.setVisible(true);

        } catch (JRException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_itemListaClientesActionPerformed

    private void itemProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemProveedorActionPerformed
        // TODO add your handling code here:
        Frm_Agregar_Proveedor form = new Frm_Agregar_Proveedor();
        escritorio.add(form);
        form.toFront();
        form.setVisible(true);
    }//GEN-LAST:event_itemProveedorActionPerformed

    private void itemPuestoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemPuestoActionPerformed
        // TODO add your handling code here:
        Frm_TipoPuesto form = new Frm_TipoPuesto();
        escritorio.add(form);
        form.toFront();
        form.setVisible(true);
    }//GEN-LAST:event_itemPuestoActionPerformed

    private void itemGastosRangoFechasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemGastosRangoFechasActionPerformed
        // TODO add your handling code here:
        Frm_GastosParametros form = new Frm_GastosParametros();
        escritorio.add(form);
        form.toFront();
        form.setVisible(true);
    }//GEN-LAST:event_itemGastosRangoFechasActionPerformed

    private void itemRImprimirFacturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemRImprimirFacturaActionPerformed
        // TODO add your handling code here:
        Frm_R_ImprimirFactura imprimirFactura = new Frm_R_ImprimirFactura();
        escritorio.add(imprimirFactura);
        imprimirFactura.toFront();
        imprimirFactura.setVisible(true);
    }//GEN-LAST:event_itemRImprimirFacturaActionPerformed

    private void itemFacturasxClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemFacturasxClienteActionPerformed
        // TODO add your handling code here:
        Frm_GrupoCabinasxCliente grupoCabinasxCliente = new Frm_GrupoCabinasxCliente();
        escritorio.add(grupoCabinasxCliente);
        grupoCabinasxCliente.toFront();
        grupoCabinasxCliente.setVisible(true);
        Frm_GrupoCabinasxCliente.idEmpleado.setText(IdEmpleado.getText());
        Frm_GrupoCabinasxCliente.nombreEmpleado.setText(Nombre_Empleado.getText());
    }//GEN-LAST:event_itemFacturasxClienteActionPerformed

    private void itemProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemProductosActionPerformed
        // TODO add your handling code here:
        Frm_Agregar_Productos agregarProductos = new Frm_Agregar_Productos();
        escritorio.add(agregarProductos);
        agregarProductos.toFront();
        agregarProductos.setVisible(true);
    }//GEN-LAST:event_itemProductosActionPerformed

    private void itemProductosxProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemProductosxProveedorActionPerformed
        // TODO add your handling code here:
        JasperReport report;
        JasperPrint print;
        try {
            report = JasperCompileManager.compileReport(new File("").getAbsolutePath()
                    + "/src/vista/reportes/ProductosporProveedor.jrxml");
            print = JasperFillManager.fillReport(report, null, con);
            JasperViewer view = new JasperViewer(print, false);
            view.setTitle("Lista de Productos por Proveedor");
            view.setVisible(true);

        } catch (JRException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_itemProductosxProveedorActionPerformed

    private void itemGastosPlanillaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemGastosPlanillaActionPerformed
        // TODO add your handling code here:
        Frm_Agregar_Gastos Busqueda = new Frm_Agregar_Gastos();
        escritorio.add(Busqueda);
        Busqueda.toFront();
        Busqueda.setVisible(true);
    }//GEN-LAST:event_itemGastosPlanillaActionPerformed

    private void itmListaGastosDiariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itmListaGastosDiariosActionPerformed
        // TODO add your handling code here:
        Frm_BusquedaGastos Busqueda = new Frm_BusquedaGastos();
        escritorio.add(Busqueda);
        Busqueda.toFront();
        Busqueda.setVisible(true);
    }//GEN-LAST:event_itmListaGastosDiariosActionPerformed

    private void itemListaProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemListaProductosActionPerformed
        // TODO add your handling code here:
        JasperReport report;
        JasperPrint print;
        try {
            report = JasperCompileManager.compileReport(new File("").getAbsolutePath()
                    + "/src/vista/reportes/ListaProdutos.jrxml");
            print = JasperFillManager.fillReport(report, null, con);
            JasperViewer view = new JasperViewer(print, false);
            view.setTitle("Lista de Productos por Proveedor");
            view.setVisible(true);

        } catch (JRException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_itemListaProductosActionPerformed

    private void itemAcercaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemAcercaActionPerformed
        // TODO add your handling code here:
        Frm_Acerca frmAcerca = new Frm_Acerca();
        escritorio.add(frmAcerca);
        frmAcerca.toFront();
        frmAcerca.setVisible(true);
    }//GEN-LAST:event_itemAcercaActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        Frm_GastosPlanillas frm_GastosPlanillas = new Frm_GastosPlanillas();
        escritorio.add(frm_GastosPlanillas);
        frm_GastosPlanillas.toFront();
        frm_GastosPlanillas.setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

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
            java.util.logging.Logger.getLogger(Frm_Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
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
            new Frm_Inicio().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JLabel IdEmpleado;
    public static javax.swing.JLabel Nombre_Empleado;
    public static javax.swing.JDesktopPane escritorio;
    private javax.swing.JMenuItem itemAcerca;
    private javax.swing.JMenuItem itemAgregarCabina;
    private javax.swing.JMenuItem itemCabina;
    private javax.swing.JMenuItem itemClientes;
    private javax.swing.JMenuItem itemColaborador;
    private javax.swing.JMenuItem itemDisponibles;
    private javax.swing.JMenuItem itemFacturasxCliente;
    private javax.swing.JMenuItem itemGastosPlanilla;
    private javax.swing.JMenuItem itemGastosRangoFechas;
    private javax.swing.JMenuItem itemHorarios;
    private javax.swing.JMenuItem itemListaCabina;
    private javax.swing.JMenuItem itemListaClientes;
    private javax.swing.JMenuItem itemListaProductos;
    private javax.swing.JMenuItem itemProductos;
    private javax.swing.JMenuItem itemProductosxProveedor;
    private javax.swing.JMenuItem itemProveedor;
    private javax.swing.JMenuItem itemPuesto;
    private javax.swing.JMenuItem itemRImprimirFactura;
    private javax.swing.JMenuItem itemTipoPersona;
    private javax.swing.JMenuItem itemUsuarios;
    private javax.swing.JMenuItem itmListaGastosDiarios;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuItem jMenuItem1;
    public static javax.swing.JLabel lblPuesto;
    public static javax.swing.JLabel lblacceso;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenu mnuAyuda;
    public static javax.swing.JMenu mnuConfiguraciones;
    public static javax.swing.JMenu mnuHerramientas;
    private javax.swing.JMenu mnuSalir;
    public static javax.swing.JMenu mnuarchivo;
    private javax.swing.JMenu mnuconsultas;
    private javax.swing.JMenu mnureservas;
    private javax.swing.JMenu mnusisreserva;
    // End of variables declaration//GEN-END:variables

}
