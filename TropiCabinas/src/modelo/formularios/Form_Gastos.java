/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.formularios;

import controlador.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.contructor.Modelo_Gastos;

/**
 *
 * @author Eisner López Acevedo <eisner.lopez at gmail.com>
 */
public class Form_Gastos {

    private final DBConnection myLink = new DBConnection();
    private final Connection conexion = DBConnection.getConnection();
    private String querySQL = "";
    ResultSet rs = null;
    PreparedStatement pst = null;
    Statement st = null;

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
