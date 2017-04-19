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
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Eisner Lopez Acevedo <eisner.lopez at gmail.com>
 */
public class Form_Productos {
    
        // Se agrega un indice para prueba del nombre, aunque debería leer el nombre de la cabina.
        private final DBConnection myLink = new DBConnection();
        private final Connection conexion = DBConnection.getConnection();
        private String querySQL = "";
        private String querySQL2 = "";
        public int totalRegistros;
        ResultSet rs = null;
        PreparedStatement pst = null;
        
        public DefaultTableModel mostrarProveedor(String buscar) {
            DefaultTableModel tableModel;
            //creación de un array para definir las columnas
            String[] columnas = {"descripcion_cabina", "estado_cabina", "precio", "tipo_cabina"};
            //creación de un array para definir los registros que se incluiran por medio del codigo
            String[] registro = new String[4];

            totalRegistros = 0;

            tableModel = new DefaultTableModel(null, columnas);
            querySQL = "SELECT `descripcion_cabina`, `estado_cabina`, `precio`, `tipo_cabina` FROM `cabina` WHERE `descripcion_cabina` LIKE '%" + buscar + "%' ORDER BY `descripcion_cabina`";
            try {
                Statement st = conexion.createStatement();
                rs = st.executeQuery(querySQL);

                while (rs.next()) {
                    registro[0] = rs.getString("descripcion_cabina");
                    registro[1] = rs.getString("estado_cabina");
                    registro[2] = rs.getString("precio");
                    registro[3] = rs.getString("tipo_cabina");
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
            String[] columnas = {"descripcion_cabina", "estado_cabina", "precio", "tipo_cabina"};
            //creación de un array para definir los registros que se incluiran por medio del codigo
            String[] registro = new String[4];

            totalRegistros = 0;

            tableModel = new DefaultTableModel(null, columnas);
            querySQL = "SELECT `descripcion_cabina`, `estado_cabina`, `precio`, `tipo_cabina` FROM `cabina` WHERE `descripcion_cabina` LIKE '%" + buscar + "%' ORDER BY `descripcion_cabina`";
            try {
                Statement st = conexion.createStatement();
                rs = st.executeQuery(querySQL);

                while (rs.next()) {
                    registro[0] = rs.getString("descripcion_cabina");
                    registro[1] = rs.getString("estado_cabina");
                    registro[2] = rs.getString("precio");
                    registro[3] = rs.getString("tipo_cabina");
                    totalRegistros++;
                    tableModel.addRow(registro);
                }
                return tableModel;
            } catch (SQLException sqle) {
                JOptionPane.showConfirmDialog(null, sqle);
                return null;
            }

        }
}
