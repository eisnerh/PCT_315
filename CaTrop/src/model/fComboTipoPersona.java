/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import controller.ConexionDB;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

/**
 *
 * @author ace
 */
public class fComboTipoPersona {
    
    // Se crea un array de botones
    // Se agrega un indice para prueba del nombre, aunque debería leer el nombre de la cabina.
    private final ConexionDB myLink = new ConexionDB();
    private final Connection conexion = ConexionDB.conexionDB();
    private String querySQL = "";
    public int totalRegistros;
    ResultSet rs = null;
    PreparedStatement pst = null;
    
    public DefaultComboBoxModel boxModel_TipoPersona()
    {
        DefaultComboBoxModel boxModel = null;
        try {
            Statement stmt;
            stmt = conexion.createStatement();

            String querySQL = "SELECT `descripcion_puesto` FROM `puesto`";
            rs = stmt.executeQuery(querySQL);
String[] registro = new String[1];
            
            while (rs.next()) {
                registro[0] = rs.getString("descripcion_puesto");
                int ttregistro = 0;
                ttregistro++;
            }
            boxModel.addElement(registro);
            

        } catch (HeadlessException | SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return boxModel;
    }
    
}
