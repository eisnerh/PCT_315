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
import javax.swing.table.DefaultTableModel;
import modelo.contructor.Modelo_Colaborador;
import modelo.contructor.Modelo_Proveedor;

/**
 *
 * @author Eisner Lopez Acevedo <eisner.lopez at gmail.com>
 */
public class Interfaz_Colaborador {

    // Se agrega un indice para prueba del nombre, aunque debería leer el nombre de la cabina.
    private final dbConnection myLink = new dbConnection();
    private final Connection conexion = dbConnection.getConnection();
    private String querySQL = "";
    public int totalRegistros;
    ResultSet rs = null;
    PreparedStatement pst = null;

    public DefaultTableModel mostrarColaborador(String buscar) {
        DefaultTableModel tableModel;
        //creación de un array para definir las columnas
        String[] columnas = {
            "ID",
            "ID Persona",
            "Nombre",
            "Cedula",
            "Dirección",
            "Teléfono",
            "Fecha Contrato",
            "Fecha Despido",
            "ID Horario",
            "Horario",
            "Observaciones",
            "ID Puesto",
            "Puesto"};
        //creación de un array para definir los registros que se incluiran por medio del codigo
        String[] registro = new String[13];

        totalRegistros = 0;

        tableModel = new DefaultTableModel(null, columnas);
        querySQL = "SELECT \n"
                + "    colaborador.empleado_id,\n"
                + "    persona.idpersona, "
                + "    persona.nombre,\n"
                + "    persona.cedula,\n"
                + "    persona.direccion,\n"
                + "    persona.telefono,\n"
                + "    colaborador.fecha_contrato,\n"
                + "    colaborador.fecha_despido,\n"
                + "    colaborador.horario_horario_id,\n"
                + "    horario.descripcion_horario,\n"
                + "    colaborador.observaciones,\n"
                + "    colaborador.puesto_puesto_id,\n"
                + "    puesto.descripcion_puesto\n"
                + "FROM\n"
                + "    colaborador\n"
                + "        INNER JOIN\n"
                + "    persona ON colaborador.persona_idpersona = persona.idpersona\n"
                + "        INNER JOIN\n"
                + "    horario ON colaborador.horario_horario_id = horario.horario_id\n"
                + "        INNER JOIN\n"
                + "    puesto ON colaborador.puesto_puesto_id = puesto.puesto_id\n"
                + "WHERE\n"
                + "    persona.nombre LIKE '%" + buscar + "%'";
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
                registro[8] = rs.getString(9);
                registro[9] = rs.getString(10);
                registro[10] = rs.getString(11);
                registro[11] = rs.getString(12);
                registro[12] = rs.getString(13);
                totalRegistros++;
                tableModel.addRow(registro);
            }
            return tableModel;
        } catch (SQLException sqle) {
            JOptionPane.showConfirmDialog(null, sqle);
            return null;
        }

    }

    public boolean insertar(Modelo_Colaborador dts) {
        querySQL = "INSERT INTO `pct3`.`colaborador` "
                + "( "
                + "`fecha_contrato`, "
                + "`fecha_despido`, "
                + "`observaciones`, "
                + "`persona_idpersona`, "
                + "`puesto_puesto_id`, "
                + "`horario_horario_id`) "
                + "VALUES "
                + "( "
                + "?, "
                + "0000-00-00, "
                + "?, "
                + "(SELECT max(idpersona) FROM pct3.persona), "
                + "?, "
                + "?)";
        try {
            PreparedStatement statement;
            statement = conexion.prepareStatement(querySQL);
            statement.setString(1, dts.getFecha_contrato());
            statement.setString(2, dts.getObservaciones());
            statement.setString(3, dts.getPuesto_puesto_id());
            statement.setString(4, dts.getHorario_horario_id());
            statement.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showConfirmDialog(null, e);
        }
        return false;
    }

    public boolean editar(Modelo_Colaborador dts) {
        querySQL = "UPDATE `pct3`.`colaborador` "
                + "SET "
                + "`observaciones`= ?, "
                + "`puesto_puesto_id`= ?, "
                + "`horario_horario_id`= ? "
                + "WHERE "
                + "`empleado_id`= ? "
                + "and "
                + "`persona_idpersona`= ?;";
        try {

            PreparedStatement statement;
            statement = conexion.prepareStatement(querySQL);
            statement.setString(1, dts.getObservaciones());
            statement.setString(2, dts.getPuesto_puesto_id());
            statement.setString(3, dts.getHorario_horario_id());
            //ID's
            statement.setString(4, dts.getEmpleado_id());
            statement.setString(5, dts.getPersona_idpersona());
            statement.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showConfirmDialog(null, e);
        }
        return false;
    }
    
    public boolean editarDespido(Modelo_Colaborador dts) {
        querySQL = "UPDATE `pct3`.`colaborador` "
                + "SET "
                + "`fecha_despido`= ? "
                + "WHERE "
                + "`empleado_id`= ? "
                + "and "
                + "`persona_idpersona`= ?";
        try {

            PreparedStatement statement;
            statement = conexion.prepareStatement(querySQL);
            
            statement.setString(1, dts.getFecha_despido());
            //ID's
            statement.setString(2, dts.getEmpleado_id());
            statement.setString(3, dts.getPersona_idpersona());
            statement.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showConfirmDialog(null, e);
        }
        return false;
    }
}
