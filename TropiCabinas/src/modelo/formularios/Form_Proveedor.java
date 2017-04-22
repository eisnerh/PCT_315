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

/**
 *
 * @author Eisner López Acevedo <eisner.lopez at gmail.com>
 */
public class Form_Proveedor {

    // Se agrega un indice para prueba del nombre, aunque debería leer el nombre de la cabina.
    private final DBConnection1 myLink = new DBConnection1();
    private final Connection conexion = DBConnection1.getConnection();
    private String querySQL = "";
    public int totalRegistros;
    ResultSet rs = null;
    PreparedStatement pst = null;

    public DefaultTableModel mostrarProveedor(String buscar) {
        DefaultTableModel tableModel;
        //creación de un array para definir las columnas
        String[] columnas = {"ID Proveedor", "Nombre Proveedor", "Contacto", 
        "Cédula", "Teléfono", "Tipo Persona"};
        //creación de un array para definir los registros que se incluiran por medio del codigo
        String[] registro = new String[7];

        totalRegistros = 0;

        tableModel = new DefaultTableModel(null, columnas);
        querySQL = "SELECT "
                + "proveedor.idproveedor AS 'ID Proveedor', "
                + "proveedor.desc_proveedor AS 'Nombre Proveedor', "
                + "persona.nombre AS 'Nombre Contacto', "
                + "persona.cedula AS 'Cédula', "
                + "persona.telefono AS 'Teléfono', "
                + "persona.direccion AS 'Dirección', "
                + "tipo_persona.desc_persona AS 'Tipo Persona' "
                + "FROM "
                + "proveedor "
                + "INNER JOIN "
                + "persona ON proveedor.persona_idpersona = persona.idpersona "
                + "INNER JOIN "
                + "tipo_persona ON persona.tipo_persona_idtipo_persona = tipo_persona.idtipo_persona "
                + "WHERE "
                + "proveedor.desc_proveedor LIKE '%" + buscar + "%'";
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
