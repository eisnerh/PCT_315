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
import modelo.contructor.Modelo_Cabina;
import modelo.contructor.Modelo_ClienteEmpresa;

/**
 *
 * @author Eisner López Acevedo <eisner.lopez at gmail.com>
 * @author Cesar Gonzalez Salas <cgonzalez816 at gmail.com>
 */
public class Interfaz_ClienteEmpresa {

    // Se crea un array de botones
    // Se agrega un indice para prueba del nombre, aunque debería leer el nombre de la cabina.
    private final dbConnection myLink = new dbConnection();
    private final Connection conexion = dbConnection.getConnection();
    private String querySQL = "";
    private String querySQL2 = "";
    public int totalRegistros;
    ResultSet rs = null;
    PreparedStatement pst = null;

    public DefaultTableModel mostrarPersonaCliente(String buscar) {
        DefaultTableModel tableModel;
        //creación de un array para definir las columnas
        String[] columnas = {
            "ID Persona",
            "Nombre Cliente",
            "C\u00E9dula",
            "Tel\u00E9fono",
            "Direcci\u00F3n",
            "ID Empresa",
            "Empresa",
            "Estado"
        };
        //creación de un array para definir los registros que se incluiran por medio del codigo
        String[] registro = new String[8];

        totalRegistros = 0;

        tableModel = new DefaultTableModel(null, columnas);
        querySQL = "SELECT \n"
                + "    persona.idpersona,\n"
                + "    persona.nombre,\n"
                + "    persona.cedula,\n"
                + "    persona.telefono,\n"
                + "    persona.direccion,\n"
                + "    cliente_empresa.empresa_id,\n"
                + "    cliente_empresa.codigo_cliente,\n"
                + "    IF(cliente_empresa.estado_cliente = 0,\n"
                + "        'Activo',\n"
                + "        'Betado') AS estado\n"
                + "FROM\n"
                + "    pct3.persona\n"
                + "        INNER JOIN\n"
                + "    pct3.cliente_empresa ON persona.idpersona = cliente_empresa.persona_idpersona\n"
                + "WHERE\n"
                + "    nombre LIKE '%" + buscar + "%' and cliente_empresa.estado_cliente = '0' "
                + "ORDER BY cliente_empresa.codigo_cliente;";
        try {
            Statement st = conexion.createStatement();
            rs = st.executeQuery(querySQL);

            while (rs.next()) {
                registro[0] = rs.getString("idpersona");
                registro[1] = rs.getString("nombre");
                registro[2] = rs.getString("cedula");
                registro[3] = rs.getString("telefono");
                registro[4] = rs.getString("direccion");
                registro[5] = rs.getString("empresa_id");
                registro[6] = rs.getString("codigo_cliente");
                registro[7] = rs.getString("estado");
                totalRegistros++;
                tableModel.addRow(registro);
            }
            return tableModel;
        } catch (SQLException sqle) {
            JOptionPane.showConfirmDialog(null, sqle);
            return null;
        }

    }
    

    public DefaultTableModel mostrarvista(String buscar) {
        DefaultTableModel tableModel;
        //creación de un array para definir las columnas
        String[] columnas = {"id", "descripcion_cabina", "estado_cabina", "precio", "tipo_cabina"};
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

        } catch (SQLException e) {
            JOptionPane.showConfirmDialog(null, e);
            return null;
        }
    }

    public boolean insertarCliente(Modelo_ClienteEmpresa dts) {
        querySQL = "INSERT INTO `pct3`.`cliente_empresa`\n"
                + "( "
                + "`codigo_cliente`, "
                + "`estado_cliente`, "
                + "`persona_idpersona`) "
                + "VALUES "
                + "( "
                + "?, "
                + "0, "
                + "(SELECT max(idpersona) FROM pct3.persona))";
        try {

            PreparedStatement preparedst = conexion.prepareStatement(querySQL);
            preparedst.setString(1, dts.getCodigo_cliente());

            int n = preparedst.executeUpdate();

            return n != 0;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            return false;
        }
    }

    public boolean editar(Modelo_ClienteEmpresa dts) {
        querySQL = "UPDATE `pct3`.`cliente_empresa`\n"
                + "SET\n"
                + "`codigo_cliente` = ?,\n"
                + "WHERE `empresa_id` = ?";

        try {
            PreparedStatement preparedST = conexion.prepareStatement(querySQL);
            preparedST.setString(1, dts.getCodigo_cliente());

            preparedST.setString(2, dts.getEmpresa_id());

            int n = preparedST.executeUpdate();

            return n != 0;

        } catch (SQLException e) {
            JOptionPane.showConfirmDialog(null, e);
            return false;
        }
    }

    public boolean cambiarPassword(Modelo_Cabina dts) {
        querySQL = "UPDATE `pct3`.`usuario`"
                + "SET"
                + "`password` = ?"
                + "WHERE `idusuario` = ?";

        try {
            PreparedStatement preparedST = conexion.prepareStatement(querySQL);

            preparedST.setString(1, dts.getId_cabina());
            preparedST.setString(2, dts.getId_cabina());
            int n = preparedST.executeUpdate();

            return n != 0;

        } catch (SQLException e) {
            JOptionPane.showConfirmDialog(null, e);
            return false;
        }
    }

    public boolean betado(Modelo_ClienteEmpresa dts) {
        querySQL = "UPDATE `pct3`.`cliente_empresa` SET `estado_cliente`='1' WHERE `empresa_id`=?;";

        try {
            PreparedStatement preparedST = conexion.prepareStatement(querySQL);

            preparedST.setString(1, dts.getEstado_cliente());
            preparedST.setString(2, dts.getEmpresa_id());
            int n = preparedST.executeUpdate();
            return n != 0;
        } catch (SQLException e) {
            JOptionPane.showConfirmDialog(null, e);
            return false;
        }
    }

    /**
     *
     * @param dts
     * @return
     */
    public boolean eliminar(Modelo_ClienteEmpresa dts) {

        querySQL = "delete from cliente_empresa where idpersona=?";
        querySQL2 = "delete from persona where idpersona=?";

        try {

            PreparedStatement ps;
            ps = conexion.prepareStatement(querySQL);
            PreparedStatement pst2 = conexion.prepareStatement(querySQL2);

            ps.setString(1, dts.getPersona_idpersona());

            pst2.setString(1, dts.getPersona_idpersona());

            int n = ps.executeUpdate();

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

    /**
     *
     * @return
     */
    public String nuevoCodigo() {
        querySQL = "SELECT "
                + "MAX(empresa_id) + 1 AS nuevo "
                + "FROM "
                + "pct3.cliente_empresa";

        try {
            Statement st = conexion.createStatement();
            ResultSet resultS = st.executeQuery(querySQL);

            while (resultS.next()) {
                String add1;
                add1 = resultS.getString(1);
            }
        } catch (SQLException e) {
            JOptionPane.showConfirmDialog(null, e);
        }
        return null;
    }

    /**
     *
     * @param Codice
     * @return
     */
    public boolean nuevoCode(String Codice) {
        querySQL = "SELECT "
                + "MAX(empresa_id) + 1 AS nuevo "
                + "FROM "
                + "pct3.cliente_empresa";
        try {
            Statement st = conexion.createStatement();
            rs = st.executeQuery(querySQL);
            while (rs.next()) {
                Codice = rs.getString(1);
            }
        } catch (SQLException sqle) {
            JOptionPane.showConfirmDialog(null, sqle);

        }
        return false;
    }
}
