/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.formularios;

import controlador.DBConnection1;
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
public class Form_Gastos {

    // Se crea un array de botones
    // Se agrega un indice para prueba del nombre, aunque debería leer el nombre de la cabina.
    private final DBConnection1 myLink = new DBConnection1();
    private final Connection conexion = DBConnection1.getConnection();
    private String querySQL = "";
    public int totalRegistros;
    ResultSet rs = null;
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
                + "where gasto_operativo.factura_gasto like '%" + buscar + "%'";
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
            Logger.getLogger(Form_Gastos.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
