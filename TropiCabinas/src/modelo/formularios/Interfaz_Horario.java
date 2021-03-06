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
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.contructor.Modelo_Horario;

/**
 *
 * @author Eisner López Acevedo <eisner.lopez at gmail.com>
 */
public class Interfaz_Horario {

    private final dbConnection myLink = new dbConnection();
    private final Connection conexion = dbConnection.getConnection();
    private String querySQL = "";
    public int totalRegistros;
    ResultSet resultSets = null;
    PreparedStatement pst = null;

    public boolean mostrarHorario(String buscar) {
        DefaultTableModel tableModel = null;
        //creación de un array para definir las columnas
        String[] columnas = {"ID", "Horario"};
        //creación de un array para definir los registros que se incluiran por medio del codigo
        String[] registro = new String[2];
        //integer que indica la cantidad de registros obtenidos del select
        String id;
        String descripcion;
        totalRegistros = 0;
        //modelado de la tabla
        //tableModel = new DefaultTableModel(null, columnas);
        querySQL = "SELECT * FROM pct3.horario WHERE BINARY descripcion_horario LIKE '%" + buscar + "%' ORDER BY `descripcion_horario`";
        try {
            Statement st = conexion.createStatement();
            resultSets = st.executeQuery(querySQL);

            while (resultSets.next()) {
                id = resultSets.getString("horario_id");
                descripcion = resultSets.getString("descripcion_horario");

                totalRegistros++;
                tableModel.addRow(registro);
            }
            //return tableModel;
        } catch (SQLException sqle) {
            JOptionPane.showConfirmDialog(null, sqle);

        }
        return false;

    }

    public boolean insertar(Modelo_Horario dts) {
        querySQL = "insert into pct3.horario (descripcion_horario) values (?)";
        try {
            PreparedStatement ps;
            ps = conexion.prepareStatement(querySQL);
            ps.setString(1, dts.getDescripcionHorario());
            int n = ps.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showConfirmDialog(null, "Valor Duplicado", "Corregir", JOptionPane.YES_NO_OPTION);
        }
        return false;
    }

    public boolean editar(Modelo_Horario dts) {
        querySQL = "UPDATE `horario` SET `descripcion_horario` = ? WHERE `horario`.`horario_id` = ?";
        try {
            PreparedStatement ps = conexion.prepareStatement(querySQL);
            
            ps.setString(1, dts.getDescripcionHorario());
            ps.setString(2, dts.getHorarioId());
            int n;
            n = ps.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showConfirmDialog(null, "Valor Duplicado", "Corregir", JOptionPane.YES_NO_OPTION);
        }
        return false;
    }

    public boolean eliminar(Modelo_Horario dts) {
        querySQL = "DELETE FROM `pct3`.`horario` WHERE descripcion_horario = ?";
        try {
            PreparedStatement ps = conexion.prepareStatement(querySQL);
            ps.setString(1, dts.getDescripcionHorario());
            int n = ps.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showConfirmDialog(null, e);
        }
        return false;
    }
    
    public DefaultComboBoxModel llena_Horario()
    {
        DefaultComboBoxModel modeloHorario = null;
        querySQL = "SELECT * FROM pct3.horario";
                try {
            Statement st = conexion.createStatement();
            resultSets = st.executeQuery(querySQL);
            while (resultSets.next()) {
                modeloHorario.addElement(resultSets.getString("descripcion_horario"));
                if (resultSets.getString("descripcion_horario").equals("Diurno")) {
                    modeloHorario.setSelectedItem(resultSets.getString("descripcion_horario"));
                }
            }
            //return tableModel;
        } catch (SQLException sqle) {
            JOptionPane.showConfirmDialog(null, sqle);
        }
        return modeloHorario;
    }
}
