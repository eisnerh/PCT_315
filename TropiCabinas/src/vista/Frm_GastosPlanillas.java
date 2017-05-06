/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.dbConnection;
import java.io.File;
import java.sql.Connection;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
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
 */
public class Frm_GastosPlanillas extends javax.swing.JInternalFrame {

    /**
     * Creates new form Frm_GastosParametros
     */
    Connection con = null;
    public String fecha1, fecha2;
    public Frm_GastosPlanillas() {
        initComponents();
        con = dbConnection.getConnection();
    }
    
    private void obtenerFechas() {
        Calendar cal;
        int d, m, a;
        cal = Fecha1.getCalendar();
        d = cal.get(Calendar.DAY_OF_MONTH);
        m = cal.get(Calendar.MONTH);
        a = cal.get(Calendar.YEAR) - 1900;
        Format formatter = new SimpleDateFormat("yyyy-MM-dd");
        fecha1 = formatter.format(Fecha1.getDate());
        Calendar cal2;
        int d2, m2, a2;
        cal = Fecha2.getCalendar();
        d2 = cal.get(Calendar.DAY_OF_MONTH);
        m2 = cal.get(Calendar.MONTH);
        a2 = cal.get(Calendar.YEAR) - 1900;
        Format formatter2 = new SimpleDateFormat("yyyy-MM-dd");
        fecha2 = formatter2.format(Fecha2.getDate());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnImprimirReporteGastos = new javax.swing.JButton();
        Fecha1 = new com.toedter.calendar.JDateChooser();
        Fecha2 = new com.toedter.calendar.JDateChooser();

        setClosable(true);
        setTitle("Reporte de Gastos");
        setToolTipText("Reporte de gastos por parametros de fechas");

        jLabel1.setText("Hasta");

        jLabel2.setText("Desde");

        btnImprimirReporteGastos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/creditcard_64px.png"))); // NOI18N
        btnImprimirReporteGastos.setText("Imprimir Reporte");
        btnImprimirReporteGastos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImprimirReporteGastosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnImprimirReporteGastos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(125, 125, 125)
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Fecha1, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(Fecha2, javax.swing.GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Fecha1, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
                    .addComponent(Fecha2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(28, 28, 28)
                .addComponent(btnImprimirReporteGastos, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnImprimirReporteGastosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImprimirReporteGastosActionPerformed
        // TODO add your handling code here:
        obtenerFechas();
            Map p = new HashMap();

            p.put("fecha1", fecha1);
            p.put("fecha2", fecha2);
            JasperReport report;
            JasperPrint print;

            try {
                //C:\Users\eisne\PCT_315\TropiCabinas\src\vista\reportes\Ejemplo_GastosOperatvos.jrxml
                report = JasperCompileManager.compileReport(new File("").getAbsolutePath()
                        + "/src/vista/reportes/Planilla.jrxml");
                print = JasperFillManager.fillReport(report, p, con);
                JasperViewer view = new JasperViewer(print, false);
                view.setTitle("Reporte de Gastos");
                view.setVisible(true);

            } catch (JRException e) {
                JOptionPane.showMessageDialog(this, e);
            }
        
    }//GEN-LAST:event_btnImprimirReporteGastosActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser Fecha1;
    private com.toedter.calendar.JDateChooser Fecha2;
    private javax.swing.JButton btnImprimirReporteGastos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}
