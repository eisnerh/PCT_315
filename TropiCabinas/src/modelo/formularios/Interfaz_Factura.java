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

/**
 *
 * @author Eisner López Acevedo <eisner.lopez at gmail.com>
 */
public class Interfaz_Factura {

    private final dbConnection myLink = new dbConnection();
    private final Connection conexion = dbConnection.getConnection();
    private String querySQL = "";
    ResultSet rs = null;
    PreparedStatement pst = null;

    public boolean mostrarFactura(String Buscar) {
        String[] registro = new String[8];
        querySQL
                = "SELECT `factura_cabina`.`factura_id`, "
                + "`factura_cabina`.`cant_dia`, "
                + "`factura_cabina`.`fecha`, "
                + "`factura_cabina`.`impuesto_cabina`, "
                + "`factura_cabina`.`precio_total_cabina`, "
                + "`factura_cabina`.`cabina_cabina_id`, "
                + "`factura_cabina`.`colaborador_empleado_id`, "
                + "`factura_cabina`.`numero_factura`"
                + "FROM `pct3`.`factura_cabina`"
                + "WHERE "
                + "`factura_cabina`.`numero_factura` = '" + Buscar + "'"
                + "order by `factura_cabina`.`numero_factura`;";
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
                registro[6] = rs.getString(7);
                registro[7] = rs.getString(8);
            }
        } catch (SQLException sqle) {
            JOptionPane.showConfirmDialog(null, sqle);
        }
        return false;
    }
}
