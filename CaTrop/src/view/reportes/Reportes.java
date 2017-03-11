/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.reportes;

import controller.ConexionDB;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author ace
 */
public class Reportes {

    Connection con = null;
    ResultSet rs = null;
    PreparedStatement pst = null;
    ResultSet rs2 = null;
    PreparedStatement pst2 = null;

    public void ReporteFactura() {
        JasperReport reporte;
        JasperPrint reporte_view;
        con = ConexionDB.conexionDB();
        try {
            //direccion del archivo JASPER
            URL in = this.getClass().getResource("NuevaFactura.jasper");
            reporte = (JasperReport) JRLoader.loadObject(in);
            //Se crea un objeto HashMap
            Map<String, String> parametros = new HashMap<>();
            parametros.clear();
            //parametros de entrada
            //-----------------------------------
            reporte_view = JasperFillManager.fillReport(reporte, parametros, con);
            JasperViewer.viewReport(reporte_view, false);
            //terminamos la conexion a la base de datos

        } catch (JRException E) {
        }
    }
}
