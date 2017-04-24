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
import modelo.contructor.Modelo_Productos;

/**
 *
 * @author Eisner Lopez Acevedo <eisner.lopez at gmail.com>
 */
public class Interfaz_Productos {

    // Se agrega un indice para prueba del nombre, aunque debería leer el nombre de la cabina.
    private final dbConnection myLink = new dbConnection();
    private final Connection conexion = dbConnection.getConnection();
    private String querySQL = "";
    private String querySQL2 = "";
    public int totalRegistros;
    ResultSet rs = null;
    PreparedStatement pst = null;

    public DefaultTableModel mostrarProveedor(String buscar) {
        DefaultTableModel tableModel;
        //creación de un array para definir las columnas
        String[] columnas = {"ID Proveedor", "Nombre Proveedor", "Contacto"};
        //creación de un array para definir los registros que se incluiran por medio del codigo
        String[] registro = new String[3];

        totalRegistros = 0;

        tableModel = new DefaultTableModel(null, columnas);
        querySQL = "SELECT "
                + "proveedor.idproveedor, "
                + "proveedor.desc_proveedor, "
                + "persona.nombre "
                + "FROM "
                + "pct3.proveedor "
                + "INNER JOIN "
                + "persona ON proveedor.persona_idpersona = persona.idpersona "
                + "WHERE "
                + "proveedor.desc_proveedor LIKE '%" + buscar + "%'";
        try {
            Statement st = conexion.createStatement();
            rs = st.executeQuery(querySQL);

            while (rs.next()) {
                registro[0] = rs.getString(1);
                registro[1] = rs.getString(2);
                registro[2] = rs.getString(3);
                
                totalRegistros++;
                tableModel.addRow(registro);
            }
            return tableModel;
        } catch (SQLException sqle) {
            JOptionPane.showConfirmDialog(null, sqle);
            return null;
        }

    }

    public DefaultTableModel mostrarProductos(String buscar) {
        DefaultTableModel tableModel;
        //creación de un array para definir las columnas
        String[] columnas = {"ID Productos", "Nombre Producto", "Nombre Proveedor", "Contacto", "Teléfono"};
        //creación de un array para definir los registros que se incluiran por medio del codigo
        String[] registro = new String[5];

        totalRegistros = 0;

        tableModel = new DefaultTableModel(null, columnas);
        querySQL = "SELECT "
                + "productos.idproductos, "
                + "productos.nombre_producto, "
                + "proveedor.desc_proveedor, "
                + "persona.nombre, persona.telefono "
                + "FROM pct3.productos "
                + "INNER JOIN "
                + "proveedor "
                + "ON proveedor.idproveedor = productos.proveedor_idproveedor "
                + "INNER JOIN "
                + "persona "
                + "ON proveedor.persona_idpersona = persona.idpersona "
                + "where "
                + "productos.nombre_producto like '%" + buscar + "%';";
        try {
            Statement st = conexion.createStatement();
            rs = st.executeQuery(querySQL);

            while (rs.next()) {
                registro[0] = rs.getString(1);
                registro[1] = rs.getString(2);
                registro[2] = rs.getString(3);
                registro[3] = rs.getString(4);
                registro[4] = rs.getString(5);
                totalRegistros++;
                tableModel.addRow(registro);
            }
            return tableModel;
        } catch (SQLException sqle) {
            JOptionPane.showConfirmDialog(null, sqle);
            return null;
        }

    }
    
    public boolean insertar(Modelo_Productos dts) {
        querySQL = "INSERT INTO `pct3`.`productos` "+
"(`nombre_producto`, "+
"`proveedor_idproveedor`) "+
"VALUES " +
"(?, " +
"?)";
        try {

            PreparedStatement preparedst = conexion.prepareStatement(querySQL);
            preparedst.setString(1, dts.getNombreProductos());
            preparedst.setString(2, dts.getProveedor_idProveedor());
            int n = preparedst.executeUpdate();
            return n != 0;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Cábina Duplicado", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
    
}
