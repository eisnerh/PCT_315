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
import modelo.contructor.Modelo_Persona;

/**
 *
 * @author Eisner López Acevedo <eisner.lopez at gmail.com>
 */
public class Interfaz_Persona {

    private final dbConnection myLink = new dbConnection();
    private final Connection conexion = dbConnection.getConnection();
    private String sSQL = "";
    private String sSQL2 = "";
    public Integer totalregistros;

    public DefaultTableModel mostrar(String buscar) {
        DefaultTableModel modelo;

        String[] titulos = {"ID", "Nombre", "Número Cédula", "Teléfono", "Dirección", "Tipo_Persona"};

        String[] registro = new String[5];

        totalregistros = 0;
        modelo = new DefaultTableModel(null, titulos);

        sSQL = "SELECT "
                + "`idpersona`, "
                + "`nombre`, "
                + "`cedula`, "
                + "`telefono`, "
                + "`direccion`, "
                + "`tipo_persona_idtipo_persona` "
                + "FROM "
                + "`persona` "
                + "WHERE "
                + "`nombre` like % " + buscar + "%";

        try {
            Statement st = conexion.createStatement();
            ResultSet rs = st.executeQuery(sSQL);

            while (rs.next()) {
                registro[0] = rs.getString("idpersona");
                registro[1] = rs.getString("nombre");
                registro[2] = rs.getString("cedula");
                registro[3] = rs.getString("telefono");
                registro[4] = rs.getString("direccion");
                registro[5] = rs.getString("tipo_persona_idtipo_persona");
                totalregistros = totalregistros + 1;
                modelo.addRow(registro);
            }
            return modelo;

        } catch (SQLException e) {
            JOptionPane.showConfirmDialog(null, e);
            return null;
        }

    }

    public boolean insertar(Modelo_Persona dts) {
        sSQL = "INSERT INTO `pct3`.`persona` "
                + "( "
                + "`nombre`, "
                + "`cedula`, "
                + "`telefono`, "
                + "`direccion`, "
                + "`tipo_persona_idtipo_persona`) "
                + "VALUES "
                + "( "
                + "?, "
                + "?, "
                + "?, "
                + "?, "
                + "?)";
        try {
            PreparedStatement pst = conexion.prepareStatement(sSQL);
            pst.setString(1, dts.getNombre());
            pst.setString(2, dts.getCedula());
            pst.setString(3, dts.getTelefono());
            pst.setString(4, dts.getDireccion());
            pst.setString(5, dts.getTipo_persona_idtipo_persona());
            int n = pst.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showConfirmDialog(null, e);
        }
        return false;
    }

    public boolean editar(Modelo_Persona dts) {
        sSQL = "UPDATE `persona` "
                + "SET "
                + "`nombre` = ?, "
                + "`cedula` = ?, "
                + "`telefono` = ?,"
                + "`direccion` = ? "
                + "WHERE "
                + "`idpersona` = ?";
        try {

            PreparedStatement pst = conexion.prepareStatement(sSQL);
            pst.setString(1, dts.getNombre());
            pst.setString(2, dts.getCedula());
            pst.setString(3, dts.getTelefono());
            pst.setString(4, dts.getDireccion());
            //idpersona
            pst.setString(5, dts.getIdpersona());
            pst.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showConfirmDialog(null, e);
        }
        return false;
    }

    public boolean eliminar(Modelo_Persona dts) {
        sSQL = "delete from persona where idpersona=?";
        sSQL2 = "delete from cliente_empresa where idpersona=?";

        try {

            PreparedStatement pst = conexion.prepareStatement(sSQL);
            PreparedStatement pst2 = conexion.prepareStatement(sSQL2);
            pst.setString(1, dts.getIdpersona());
            pst2.setString(1, dts.getIdpersona());
            int n = pst.executeUpdate();

            if (n != 0) {
                int n2 = pst2.executeUpdate();

                return n2 != 0;

            } else {
                return false;
            }

        } catch (SQLException e) {
            JOptionPane.showConfirmDialog(null, e);
            return false;
        }
    }

    public String getNumeroCodigo() {
        String NumeroCodigo = null;
        sSQL = "SELECT max(idpersona) as numeroPersona FROM pct3.persona";
        try {
            Statement st = conexion.createStatement();
            ResultSet rs = st.executeQuery(sSQL);
            while (rs.next()) {
                NumeroCodigo = rs.getString(1);
            }
            return NumeroCodigo;
        } catch (SQLException e) {
        }
        return null;
    }

    public String SeleccionarTipoPersona() {
        String DescripcionPersona = null;
        sSQL = "SELECT `idtipo_persona`, `desc_persona` FROM `tipo_persona` where `desc_persona` = 'Proveedor'";
        try {
            Statement st = conexion.createStatement();
            ResultSet rs = st.executeQuery(sSQL);
            while (rs.next()) {
                DescripcionPersona = rs.getString(1);
            }
            return DescripcionPersona;
        } catch (SQLException e) {
        }
        return null;
    }

    public String SeleccionarCliente() {
        String DescripcionPersona = null;
        sSQL = "SELECT `idtipo_persona`, `desc_persona` FROM `tipo_persona` where `desc_persona` = 'Cliente'";
        try {
            Statement st = conexion.createStatement();
            ResultSet rs = st.executeQuery(sSQL);
            while (rs.next()) {
                DescripcionPersona = rs.getString(1);
            }
            return DescripcionPersona;
        } catch (SQLException e) {
        }
        return null;
    }
    
    public String SeleccionarColaborador() {
        String DescripcionPersona = null;
        sSQL = "SELECT `idtipo_persona`, `desc_persona` FROM `tipo_persona` where `desc_persona` = 'Empleado'";
        try {
            Statement st = conexion.createStatement();
            ResultSet rs = st.executeQuery(sSQL);
            while (rs.next()) {
                DescripcionPersona = rs.getString(1);
            }
            return DescripcionPersona;
        } catch (SQLException e) {
        }
        return null;
    }
}
