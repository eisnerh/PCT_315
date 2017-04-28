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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.contructor.Modelo_Gastos;

/**
 *
 * @author Eisner López Acevedo <eisner.lopez at gmail.com>
 */
public class Interfaz_Gastos {

    // Se crea un array de botones
    // Se agrega un indice para prueba del nombre, aunque debería leer el nombre de la cabina.
    private final dbConnection myLink = new dbConnection();
    private final Connection conexion = dbConnection.getConnection();
    private String querySQL = "";
    public int totalRegistros;
    public float montoRegistros;
    ResultSet rs = null;
    ResultSet rsuma = null;
    PreparedStatement pst = null;

    public DefaultTableModel todosGastos(String buscar) {
        DefaultTableModel tableModel;
        //creación de un array para definir las columnas
        String[] columnas = {
            "ID Gastos",
            "Tipo Gastos",
            "Monto Gastos",
            "Fecha Gasto",
            "N° Factura",
            "Nombre Colaborador"
        };
        //creación de un array para definir los registros que se incluiran por medio del codigo
        String[] registro = new String[6];

        totalRegistros = 0;

        tableModel = new DefaultTableModel(null, columnas);
        querySQL = "SELECT "
                + "gasto_operativo.gasto_id, "
                + "gasto_operativo.tipo_gasto, "
                + "gasto_operativo.monto_gasto, "
                + "gasto_operativo.fecha_gasto, "
                + "gasto_operativo.factura_gasto, "
                + "persona.nombre "
                + "FROM "
                + "pct3.gasto_operativo "
                + "INNER JOIN "
                + "colaborador ON gasto_operativo.colaborador_empleado_id = colaborador.empleado_id "
                + "INNER JOIN "
                + "persona ON colaborador.persona_idpersona = persona.idpersona "
                + "where gasto_operativo.factura_gasto like '%" + buscar + "%'"
                + "and gasto_operativo.fecha_gasto = curdate()";
        
        try {
            Statement st = conexion.createStatement();
            rs = st.executeQuery(querySQL);
            
            while (rs.next()) {
                registro[0] = rs.getString(1);
                registro[1] = rs.getString(2);
                registro[2] = rs.getString(3);
                registro[3] = rs.getString(4);
                registro[4] = rs.getString(5);
                registro[5] = rs.getString(6);
                totalRegistros++;
                tableModel.addRow(registro);
            }
            return tableModel;
        } catch (SQLException sqle) {
            JOptionPane.showConfirmDialog(null, sqle);
            return null;
        }

    }

    public void todosGastos(Modelo_Gastos gastos) {
        try {
            querySQL = "SELECT `gasto_operativo`.`gasto_id`, "
                    + "`gasto_operativo`.`tipo_gasto`, "
                    + "`gasto_operativo`.`monto_gasto`, "
                    + "`gasto_operativo`.`fecha_gasto`, "
                    + "`gasto_operativo`.`factura_gasto`, "
                    + "`gasto_operativo`.`colaborador_empleado_id` "
                    + "FROM `pct3`.`gasto_operativo` "
                    + "WHERE `gasto_operativo`.`gasto_id` = 1";

            PreparedStatement ps;
            ps = conexion.prepareStatement(querySQL);
            if (rs.next()) {
                ps.setString(1, gastos.getGastoID());

            }
        } catch (SQLException ex) {
            Logger.getLogger(Interfaz_Gastos.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public boolean insertar(Modelo_Gastos dts) {
        querySQL = "INSERT INTO `pct3`.`gasto_operativo` "
                + "(`tipo_gasto`, "
                + "`monto_gasto`, "
                + "`fecha_gasto`, "
                + "`factura_gasto`, "
                + "`colaborador_empleado_id`) "
                + "VALUES "
                + "(?, "
                + "?, "
                + "?, "
                + "?, "
                + "?);";
        try {
            PreparedStatement ps;
            ps = conexion.prepareStatement(querySQL);
            ps.setString(1, dts.getTipo_Gasto());
            ps.setString(2, dts.getMonto_Gasto());
            ps.setString(3, dts.getFecha_Gasto());
            ps.setString(4, dts.getFactura_Gasto());
            ps.setString(5, dts.getColaborador_EmpleadoID());
            int n = ps.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showConfirmDialog(null, e, "Corregir", JOptionPane.YES_NO_OPTION);
        }
        return false;
    }

}
