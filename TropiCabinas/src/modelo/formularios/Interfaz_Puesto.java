/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.formularios;

import controlador.dbConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import modelo.contructor.Modelo_Puesto;

/**
 *
 * @author Eisner López Acevedo <eisner.lopez at gmail.com>
 */
public class Interfaz_Puesto {

    private final dbConnection myLink = new dbConnection();
    private final Connection conexion = dbConnection.getConnection();
    private String sSQL = "";
    public Integer totalregistros;

    public int totalRegistros;
    ResultSet resultSets = null;
    PreparedStatement pst = null;

    public boolean mostrarHorario(String buscar) {
        //DefaultTableModel tableModel;
        //creación de un array para definir las columnas
        //String[] columnas = {"ID", "Horario"};
        //creación de un array para definir los registros que se incluiran por medio del codigo
        //String[] registro = new String[2];
        //integer que indica la cantidad de registros obtenidos del select
        String id;
        String descripcion;
        String h_sencilla;
        String h_extra;
        totalregistros = 0;
        //modelado de la tabla
        //tableModel = new DefaultTableModel(null, columnas);
        sSQL = "SELECT puesto_id as id, descripcion_puesto as puesto, pago_hora_sencilla as sencilla, pago_hora_extra as extra FROM pct3.puesto where descripcion_puesto like '%" + buscar + "%' order by puesto;";
        try {
            Statement st = conexion.createStatement();
            resultSets = st.executeQuery(sSQL);

            while (resultSets.next()) {
                id = resultSets.getString("id");
                descripcion = resultSets.getString("puesto");
                h_sencilla = resultSets.getString("sencilla");
                h_extra = resultSets.getString("extra");
                totalRegistros++;
                //tableModel.addRow(registro);
            }
            //return tableModel;
        } catch (SQLException sqle) {
            JOptionPane.showConfirmDialog(null, sqle);

        }
        return false;

    }

    public boolean insertar(Modelo_Puesto dts) {
        sSQL = "INSERT INTO `pct3`.`puesto` "
                + "(`descripcion_puesto`, `pago_hora_sencilla`, `pago_hora_extra`) "
                + "VALUES (?, ?, ?);";
        try {

            PreparedStatement ps;
            ps = conexion.prepareStatement(sSQL);

            ps.setString(1, dts.getDescripcion_puesto());
            ps.setString(2, dts.getPago_hora_sencilla());
            ps.setString(3, dts.getPago_hora_extra());
            int n = ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e);
            JOptionPane.showConfirmDialog(null, "Valor Duplicado", "Corregir", JOptionPane.YES_NO_OPTION);
        }
        return false;
    }

    public boolean editar(Modelo_Puesto dts) {
        sSQL = "UPDATE `pct3`.`puesto` "
                + "SET"
                + "`descripcion_puesto` = ?, "
                + "`pago_hora_sencilla` = ?, "
                + "`pago_hora_extra` = ? "
                + "WHERE `puesto_id` = ?; ";
        try {
            PreparedStatement ps = conexion.prepareStatement(sSQL);
            ps.setString(1, dts.getDescripcion_puesto());
            ps.setString(2, dts.getPago_hora_sencilla());
            ps.setString(2, dts.getPago_hora_extra());
            int n;
            n = ps.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showConfirmDialog(null, "Valor Duplicado", "Corregir", JOptionPane.YES_NO_OPTION);
        }
        return false;
    }

    public boolean eliminar(Modelo_Puesto dts) {
        sSQL = "DELETE FROM `pct3`.`puesto` WHERE descripcion_puesto = ?";
        try {

            PreparedStatement ps = conexion.prepareStatement(sSQL);
            ps.setString(1, dts.getDescripcion_puesto());
            int n = ps.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showConfirmDialog(null, e);
        }
        return false;
    }
}
