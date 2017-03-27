/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.formularios;

import controlador.ConexionDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.contructor.TipoPersona_constructor;

/**
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class TipoPersona_Formulario {

    private final ConexionDB mysql = new ConexionDB();
    private final Connection connect = ConexionDB.conexionDB();
    private String sSQL = "";
    public Integer totalregistros;
    

    public DefaultTableModel mostrar(String buscar) {
        DefaultTableModel modelo;

        String[] titulos = {"ID", "desc_persona"};

        String[] registro = new String[2];

        totalregistros = 0;
        
        modelo = new DefaultTableModel(null, titulos);

        sSQL = "SELECT `idtipo_persona`, `desc_persona` FROM `tipo_persona` WHERE = " + buscar + " order by `desc_persona`";

        try {
            Statement st = connect.createStatement();
            ResultSet rs = st.executeQuery(sSQL);

            while (rs.next()) {
                registro[0] = rs.getString("idtipo_persona");
                registro[1] = rs.getString("desc_persona");

                totalregistros = totalregistros + 1;

                modelo.addRow(registro);

            }
            return modelo;

        } catch (SQLException e) {
            JOptionPane.showConfirmDialog(null, e);
            return null;
        }

    }

    public boolean insertar(TipoPersona_constructor dts) {
        sSQL = "INSERT INTO `tipo_persona`(`idtipo_persona`, `desc_persona`) VALUES (?,?)";
        try {

            PreparedStatement pst = connect.prepareStatement(sSQL);
            pst.setInt(1, dts.getIdtipo_persona());
            pst.setString(2, dts.getDesc_persona());
            
            int n = pst.executeUpdate();

            return n != 0;

        } catch (SQLException e) {
            JOptionPane.showConfirmDialog(null, e,"Error Insertar",JOptionPane.YES_OPTION);
            return false;
        }
    }

    public boolean editar(TipoPersona_constructor dts) {
        sSQL = "UPDATE `tipo_persona` SET `desc_persona` = ? WHERE `idtipo_persona`= ? ";

        try {
            PreparedStatement pst = connect.prepareStatement(sSQL);
            pst.setInt(1, dts.getIdtipo_persona());
            pst.setString(2, dts.getDesc_persona());

            int n = pst.executeUpdate();

            return n != 0;

        } catch (SQLException e) {
            JOptionPane.showConfirmDialog(null, e);
            return false;
        }
    }

    public boolean eliminar(TipoPersona_constructor dts) {
        sSQL = "DELETE FROM `tipo_persona` WHERE `desc_persona` = ?";
        try {
            PreparedStatement pst = connect.prepareStatement(sSQL);
            pst.setInt(1, dts.getIdtipo_persona());
            int n = pst.executeUpdate();
            return n != 0;
        } catch (SQLException e) {
            JOptionPane.showConfirmDialog(null, e);
            return false;
        }
    }
}
