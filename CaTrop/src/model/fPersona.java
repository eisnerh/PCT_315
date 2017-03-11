/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import controller.ConexionDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.form.mPersona;

/**
 *
 * @author ace
 */
public class fPersona {

    private final ConexionDB myLink;
    private final Connection conexion = ConexionDB.conexionDB();
    private String querySQL = "";
    public int totalRegistros;
    ResultSet rs = null;
    PreparedStatement pst = null;

    public fPersona() {
        this.myLink = new ConexionDB();
    }

    public DefaultTableModel mostarPersona(String buscar) {
        DefaultTableModel tableModel;
        //creación de un array para definir las columnas
        String[] columnas = {"nombre", "cedula", "telefono", "direccion", "tipo_persona"};
        //creación de un array para definir los registros que se incluiran por medio del codigo
        String[] registro = new String[5];

        totalRegistros = 0;

        tableModel = new DefaultTableModel(null, columnas);
        querySQL = "SELECT `nombre`, `cedula`, `telefono`, `direccion`, `tipo_persona_idtipo_persona` FROM `persona` WHERE `nombre`LIKE '%" + buscar + "%' order by `nombre`";
        try {
            Statement st = conexion.createStatement();
            rs = st.executeQuery(querySQL);

            while (rs.next()) {
                registro[0] = rs.getString("nombre");
                registro[1] = rs.getString("cedula");
                registro[2] = rs.getString("telefono");
                registro[3] = rs.getString("direccion");
                registro[3] = rs.getString("tipo_persona_idtipo_persona");
                totalRegistros++;
                tableModel.addRow(registro);
            }
            return tableModel;
        } catch (SQLException sqle) {
            JOptionPane.showConfirmDialog(null, sqle);
            return null;
        }

    }

    public boolean insertar(mPersona dts) {
        querySQL = "INSERT INTO `persona`(`nombre`, `cedula`, `telefono`, `direccion`, `tipo_persona_idtipo_persona`) VALUES (?, ?, ?, ?, ?)";
        try {

            PreparedStatement preparedst = conexion.prepareStatement(querySQL);
            preparedst.setString(1, dts.getIdPersona());
            preparedst.setString(2, dts.getNombre());
            preparedst.setString(3, dts.getCedula());
            preparedst.setString(4, dts.getTelefono());
            preparedst.setString(5, dts.getDireccion());
            preparedst.setString(6, dts.getTipoPersona());

            int n = preparedst.executeUpdate();

            return n != 0;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return false;
        }
    }

    public boolean editar(mPersona dts) {
        querySQL = "UPDATE `persona` SET `nombre`= ?,`cedula`= ?,`telefono`= ?,`direccion`= ?,`tipo_persona_idtipo_persona`= ? WHERE `idpersona` = ?";

        try {
            PreparedStatement preparedST = conexion.prepareStatement(querySQL);
            preparedST.setString(1, dts.getNombre());
            preparedST.setString(2, dts.getCedula());
            preparedST.setString(3, dts.getTelefono());
            preparedST.setString(4, dts.getDireccion());
            preparedST.setString(5, dts.getTipoPersona());

            int n = preparedST.executeUpdate();

            return n != 0;

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return false;
        }
    }

    public boolean eliminar(mPersona dts) {
        querySQL = "DELETE FROM `persona` WHERE `idpersona` = ?";

        try {

            PreparedStatement preparedST = conexion.prepareStatement(querySQL);

            preparedST.setString(1, dts.getIdPersona());

            int n = preparedST.executeUpdate();

            return n != 0;

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return false;
        }
    }

}
