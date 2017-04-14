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
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.contructor.Modelo_Clientes;

/**
 *
 * @author Eisner López Acevedo <eisner.lopez at gmail.com>
 */
public class Form_Clientes {

    private final DBConnection myLink = new DBConnection();
    private final Connection conexion = DBConnection.getConnection();
    private String sSQL = "";
    public Integer totalregistros;

    public DefaultTableModel mostrar(String buscar) {
        DefaultTableModel modelo;

        String[] titulos = {"ID Cliente", "Nombre Cliente", "Codigo Cliente", "Tipo Persona"};

        String[] registro = new String[4];

        totalregistros = 0;
        modelo = new DefaultTableModel(null, titulos);
        sSQL = "SELECT "
                + "cliente_empresa.empresa_id , "
                + "persona.nombre, "
                + "cliente_empresa.codigo_cliente, "
                + "tipo_persona.desc_persona "
                + "FROM "
                + "cliente_empresa "
                + "INNER JOIN "
                + "persona ON cliente_empresa.persona_idpersona = persona.idpersona "
                + "INNER JOIN "
                + "tipo_persona ON persona.tipo_persona_idtipo_persona = tipo_persona.idtipo_persona "
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
                totalregistros = totalregistros + 1;
                modelo.addRow(registro);
            }
            return modelo;
        } catch (SQLException e) {
            JOptionPane.showConfirmDialog(null, e);
            return null;
        }
    }

    public void Client_Search(String buscar) {
        sSQL = "SELECT "
                + "cliente_empresa.empresa_id , "
                + "persona.nombre, "
                + "cliente_empresa.codigo_cliente, "
                + "tipo_persona.desc_persona "
                + "FROM "
                + "cliente_empresa "
                + "INNER JOIN "
                + "persona ON cliente_empresa.persona_idpersona = persona.idpersona "
                + "INNER JOIN "
                + "tipo_persona ON persona.tipo_persona_idtipo_persona = tipo_persona.idtipo_persona "
                + "WHERE "
                + "persona.nombre LIKE '%" + buscar + "%'";
        try {
            Statement st = conexion.createStatement();
            ResultSet rs = st.executeQuery(sSQL);

            while (rs.next()) {
                String registro1 = rs.getString(1);
                String registro2 = rs.getString(2);
            }
        } catch (SQLException e) {
            JOptionPane.showConfirmDialog(null, e);
        }
    }

    public ArrayList<Form_Clientes> listaClientes(String buscar) {
        ArrayList listarClientes = new ArrayList();
        Modelo_Clientes clientes;
        sSQL = "SELECT "
                + "cliente_empresa.empresa_id , "
                + "persona.nombre, "
                + "cliente_empresa.codigo_cliente, "
                + "tipo_persona.desc_persona "
                + "FROM "
                + "cliente_empresa "
                + "INNER JOIN "
                + "persona ON cliente_empresa.persona_idpersona = persona.idpersona "
                + "INNER JOIN "
                + "tipo_persona ON persona.tipo_persona_idtipo_persona = tipo_persona.idtipo_persona "
                + "WHERE "
                + "persona.nombre LIKE '%" + buscar + "%'";
        try {
            Statement st = conexion.createStatement();
            ResultSet rs = st.executeQuery(sSQL);
            while(rs.next())
            {
                clientes = new Modelo_Clientes();
                clientes.setEmpresa_id(rs.getString(1));
                clientes.setNombre(rs.getString(2));
                clientes.setCodigo_cliente(rs.getString(3));
                clientes.setDesc_persona(rs.getString(4));
            }
        } catch (SQLException sqle) {
            JOptionPane.showMessageDialog(null, sqle);
        }
        return listarClientes;
    }
}
