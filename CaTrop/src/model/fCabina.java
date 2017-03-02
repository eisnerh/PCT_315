/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import model.form.mCabina;
import controller.ConexionDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.sf.jcarrierpigeon.WindowPosition;
import net.sf.jtelegraph.Telegraph;
import net.sf.jtelegraph.TelegraphEnvelope;
import net.sf.jtelegraph.TelegraphQueue;
import net.sf.jtelegraph.TelegraphType;

/**
 *
 * @author ace
 */
public class fCabina {

    // Se crea un array de botones
    // Se agrega un indice para prueba del nombre, aunque debería leer el nombre de la cabina.
    private final ConexionDB myLink = new ConexionDB();
    private final Connection conexion = ConexionDB.conexionDB();
    private String querySQL = "";
    public int totalRegistros;
    ResultSet rs = null;
    PreparedStatement pst = null;

    public DefaultTableModel mostrarCabina(String buscar) {
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
            Telegraph tele = new Telegraph("Mensaje",
                    "<html><body style='color:red;font-size:13px'><b> ERRO!</b></body></html>", TelegraphType.APPLICATION_WARNING, WindowPosition.TOPRIGHT, 500);
            TelegraphQueue q = new TelegraphQueue();
            TelegraphEnvelope qa = new TelegraphEnvelope();
            q.add(tele);
            JOptionPane.showConfirmDialog(null, sqle);
            return null;
        }

    }

    public DefaultTableModel mostrarvista(String buscar) {
        DefaultTableModel tableModel;
        //creación de un array para definir las columnas
        String[] columnas = {"id","descripcion_cabina", "estado_cabina", "precio", "tipo_cabina"};
        //creación de un array para definir los registros que se incluiran por medio del codigo
        String[] registro = new String[5];

        totalRegistros = 0;
        tableModel = new DefaultTableModel(null, columnas);

        querySQL = "SELECT `descripcion_cabina`, `estado_cabina`, `precio`, `tipo_cabina` FROM `cabina` WHERE `descripcion_cabina` = " + buscar + "'ORDER BY `descripcion_cabina`";

        try {
            Statement st = conexion.createStatement();
            ResultSet resultS = st.executeQuery(querySQL);

            while (resultS.next()) {
                registro[0] = resultS.getString("descripcion_cabina");
                registro[1] = resultS.getString("estado_cabina");
                registro[2] = resultS.getString("precio");
                registro[3] = resultS.getString("tipo_cabina");
                totalRegistros++;
                tableModel.addRow(registro);

            }
            return tableModel;

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return null;
        }
    }

    public boolean insertar(mCabina dts) {
        querySQL = "INSERT INTO `cabina`(`cabina_id`,`descripcion_cabina`, `estado_cabina`, `precio`, `tipo_cabina`) VALUES (?,?,?,?,?)";
        try {

            PreparedStatement preparedst = conexion.prepareStatement(querySQL);
            preparedst.setString(1, dts.getId_cabina());
            preparedst.setString(2, dts.getDescripcionCabina());
            preparedst.setString(3, dts.getEstado_cabina());
            preparedst.setString(4, dts.getPrecio());
            preparedst.setString(5, dts.getTipo_cabina());

            int n = preparedst.executeUpdate();

            return n != 0;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return false;
        }
    }

    public boolean editar(mCabina dts) {
        querySQL = "UPDATE `cabina` SET `descripcion_cabina`= ?,`estado_cabina`= ?,`precio`= ?,`tipo_cabina`= ? WHERE `cabina_id` = ?";

        try {
            PreparedStatement preparedST = conexion.prepareStatement(querySQL);
            preparedST.setString(1, dts.getDescripcionCabina());
            preparedST.setString(2, dts.getEstado_cabina());
            preparedST.setString(3, dts.getPrecio());
            preparedST.setString(4, dts.getTipo_cabina());

            int n = preparedST.executeUpdate();

            return n != 0;

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return false;
        }
    }

    public boolean desocupar(mCabina dts) {
        querySQL = "UPDATE `cabina` SET `estado_cabina` = 'Libre' WHERE `cabina_id` = ?";

        try {
            PreparedStatement preparedST = conexion.prepareStatement(querySQL);

            preparedST.setString(1, dts.getId_cabina());

            int n = preparedST.executeUpdate();

            return n != 0;

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return false;
        }
    }

    public boolean ocupar(mCabina dts) {
        querySQL = "UPDATE `cabina` SET `estado_cabina` = 'Ocupado' WHERE `cabina_id` = ?";

        try {
            PreparedStatement preparedST = conexion.prepareStatement(querySQL);

            preparedST.setString(1, dts.getId_cabina());

            int n = preparedST.executeUpdate();

            return n != 0;

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return false;
        }
    }

    public boolean eliminar(mCabina dts) {
        querySQL = "DELETE FROM `cabina` WHERE `cabina_id` = ?";

        try {

            PreparedStatement preparedST = conexion.prepareStatement(querySQL);

            preparedST.setString(1, dts.getId_cabina());

            int n = preparedST.executeUpdate();

            return n != 0;

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return false;
        }
    }

}