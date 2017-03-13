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
import model.form.mClienteEmpresa;

/**
 *
 * @author ace
 */
public class fClienteEmpresa {

    private final ConexionDB myLink = new ConexionDB();
    private final Connection conexion = ConexionDB.conexionDB();
    private String querySQL = "";
    public int totalRegistros;
    ResultSet rs = null;
    PreparedStatement pst = null;

    public DefaultTableModel mostrarClientes(String buscar) {
        DefaultTableModel tableModel;
        //creación de un array para definir las columnas
        String[] columnas = {"empresa_id", "nombre_empresa"};
        //creación de un array para definir los registros que se incluiran por medio del codigo
        String[] registro = new String[2];

        totalRegistros = 0;

        tableModel = new DefaultTableModel(null, columnas);
        querySQL = "SELECT empresa_id, "
                + "nombre_empresa "
                + "FROM pct3.cliente_empresa "
                + "where nombre_empresa "
                + "LIKE '%" + buscar + "%' order by nombre_empresa;";
        try {
            Statement st = conexion.createStatement();
            rs = st.executeQuery(querySQL);

            while (rs.next()) {
                registro[0] = rs.getString("empresa_id");
                registro[1] = rs.getString("nombre_empresa");
                totalRegistros++;
                tableModel.addRow(registro);
            }
            return tableModel;
        } catch (SQLException sqle) {
            JOptionPane.showConfirmDialog(null, sqle);
            return null;
        }

    }

    public DefaultTableModel mostrarVista(String buscar) {
        DefaultTableModel tableModel;
        //creación de un array para definir las columnas
        String[] columnas = {"empresa_id", "nombre_empresa"};
        //creación de un array para definir los registros que se incluiran por medio del codigo
        String[] registro = new String[2];

        totalRegistros = 0;
        tableModel = new DefaultTableModel(null, columnas);

        querySQL = "SELECT empresa_id, "
                + "nombre_empresa "
                + "FROM pct3.cliente_empresa "
                + "where nombre_empresa = '"
                + buscar + "' order by nombre_empresa;";

        try {
            Statement st = conexion.createStatement();
            ResultSet resultS = st.executeQuery(querySQL);

            while (resultS.next()) {
                registro[0] = rs.getString("empresa_id");
                registro[1] = rs.getString("nombre_empresa");
                totalRegistros++;
                tableModel.addRow(registro);

            }
            return tableModel;

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return null;
        }
    }

    public boolean insertar(mClienteEmpresa dts) {
        querySQL = "INSERT INTO `pct3`.`cliente_empresa`"
                + "(`empresa_id`,"
                + "`nombre_empresa`)"
                + "VALUES"
                + "(?,"
                + "?)";
        try {

            PreparedStatement preparedst = conexion.prepareStatement(querySQL);
            preparedst.setString(1, dts.getEmpresaId());
            preparedst.setString(2, dts.getNombreEmpresa());
            int n = preparedst.executeUpdate();
            return n != 0;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return false;
        }
    }

    public boolean editar(mClienteEmpresa dts) {
        querySQL = "UPDATE `pct3`.`cliente_empresa`"
                + "SET"
                + "`empresa_id` = ?,"
                + "`nombre_empresa` = ?"
                + "WHERE `empresa_id` = ?;";

        try {
            PreparedStatement preparedST = conexion.prepareStatement(querySQL);
            preparedST.setString(1, dts.getEmpresaId());
            preparedST.setString(2, dts.getNombreEmpresa());

            int n = preparedST.executeUpdate();

            return n != 0;

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return false;
        }
    }

    public boolean eliminar(mClienteEmpresa dts) {
        querySQL = "DELETE FROM `pct3`.`cliente_empresa`"
                + "WHERE cliente_empresa.empresa_id = ?;";

        try {

            PreparedStatement preparedST = conexion.prepareStatement(querySQL);
            preparedST.setString(1, dts.getEmpresaId());
            int n = preparedST.executeUpdate();
            return n != 0;

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return false;
        }
    }

}
