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
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.contructor.Modelo_Usuario;

/**
 *
 * @author Eisner López Acevedo <eisner.lopez at gmail.com>
 */
public class Form_Usuario {

    private final DBConnection1 myLink = new DBConnection1();
    private final Connection conexion = DBConnection1.getConnection();
    private String sSQL = "";
    public Integer totalregistros;

    public DefaultTableModel mostrar(String buscar) {
        DefaultTableModel modelo;

        String[] titulos = {"ID Usuario", "Usuario", "Contraseña", "ID Colaborador", "Nombre Colaborador"};

        String[] registro = new String[5];

        totalregistros = 0;
        modelo = new DefaultTableModel(null, titulos);
        sSQL = "SELECT "
                + "usuario.idusuario, "
                + "usuario.usuario, "
                + "usuario.password, "
                + "usuario.colaborador_empleado_id, "
                + "persona.nombre "
                + "FROM "
                + "pct3.usuario "
                + "INNER JOIN "
                + "colaborador ON colaborador.empleado_id = usuario.colaborador_empleado_id "
                + "INNER JOIN "
                + "persona ON colaborador.persona_idpersona = persona.idpersona "
                + "WHERE "
                + "persona.nombre LIKE '%" + buscar + "%'";
        try {
            Statement st = conexion.createStatement();
            ResultSet rs = st.executeQuery(sSQL);
            while (rs.next()) {
                registro[0] = rs.getString(1);
                registro[1] = rs.getString(2);
                registro[2] = rs.getString(3);
                registro[3] = rs.getString(4);
                registro[4] = rs.getString(5);
                totalregistros = totalregistros + 1;
                modelo.addRow(registro);
            }
            return modelo;
        } catch (SQLException e) {
            JOptionPane.showConfirmDialog(null, e);
            return null;
        }
    }

    public DefaultTableModel mostrarColaborador(String buscar) {
        DefaultTableModel modelo;

        String[] titulos = {"ID Colaborador", "Nombre Colaborador"};

        String[] registro = new String[2];

        totalregistros = 0;
        modelo = new DefaultTableModel(null, titulos);
        sSQL = "SELECT "
                + "colaborador.empleado_id, persona.nombre "
                + "FROM "
                + "pct3.colaborador "
                + "INNER JOIN "
                + "pct3.persona ON colaborador.persona_idpersona = persona.idpersona "
                + "WHERE "
                + "persona.nombre LIKE '%%' "
                + "ORDER BY persona.nombre";
        try {
            Statement st = conexion.createStatement();
            ResultSet rs = st.executeQuery(sSQL);
            while (rs.next()) {
                registro[0] = rs.getString(1);
                registro[1] = rs.getString(2);
                totalregistros = totalregistros + 1;
                modelo.addRow(registro);
            }
            return modelo;
        } catch (SQLException e) {
            JOptionPane.showConfirmDialog(null, e);
            return null;
        }
    }

    public boolean insertar(Modelo_Usuario dts) {
        sSQL = "INSERT INTO `pct3`.`usuario` "
                + "(`usuario`, "
                + "`password`, "
                + "`colaborador_empleado_id`) "
                + "VALUES (?,?,?)";
        try {

            PreparedStatement preparedst = conexion.prepareStatement(sSQL);
            preparedst.setString(1, dts.getUsuario());
            preparedst.setString(2, dts.getPassword());
            preparedst.setString(3, dts.getColaborador_empleado_id());
            int n = preparedst.executeUpdate();
            return n != 0;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Nombre Usuario Duplicado", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    public boolean editar(Modelo_Usuario dts) {
        sSQL = "UPDATE `pct3`.`usuario` SET `usuario`= ?,`password`= ?,`colaborador_empleado_id`= ? WHERE `idusuario` = ?";
        try {
            PreparedStatement preparedST = conexion.prepareStatement(sSQL);
            preparedST.setString(1, dts.getUsuario());
            preparedST.setString(2, dts.getPassword());
            preparedST.setString(3, dts.getColaborador_empleado_id());
            int n = preparedST.executeUpdate();
            return n != 0;

        } catch (SQLException e) {
            JOptionPane.showConfirmDialog(null, e);
            return false;
        }
    }

    public boolean eliminar(Modelo_Usuario dts) {
        sSQL = "DELETE FROM `pct3`.`usuario` WHERE `idusuario` = ?";

        try {

            PreparedStatement preparedST = conexion.prepareStatement(sSQL);

            preparedST.setString(1, dts.getIdUsuario());

            int n = preparedST.executeUpdate();

            return n != 0;

        } catch (SQLException e) {
            JOptionPane.showConfirmDialog(null, e);
            return false;
        }
    }

}
