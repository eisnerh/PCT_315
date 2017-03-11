/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import controller.ConexionDB;
import java.sql.Connection;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ace
 */
public class fUsuario {

    private final ConexionDB myLink = new ConexionDB();
    private Connection conexion = ConexionDB.conexionDB();
    private String querySQL = "";
    private String querySQL2 = "";
    public Integer totalregistros;

    public DefaultTableModel mostrarUsuario(String Buscar) {
        DefaultTableModel tableModel;
        String[] columnas = {"usuario", "password", "colaborador_empleado_id"};
        String[] registro = new String[4];
        querySQL = "SELECT `persona`.`nombre` FROM `pct3`.`usuario` AS `usuario`, `pct3`.`colaborador` AS `colaborador`, `pct3`.`persona` AS `persona` WHERE `usuario`.`colaborador_empleado_id` = `colaborador`.`empleado_id` AND `colaborador`.`persona_idpersona` = `persona`.`idpersona`";
        return null;
    }
}
