/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Cesar Gonzalez Salas, Eisner Lopez Acevedo
 */
public class Conexion {

    public Connection getConexion(Connection conexion) {

        return conexion;

    }

    /**
     * Método utilizado para establecer la conexión con la base de datos
     *
     * @param conexion
     * @return estado regresa el estado de la conexión, true si se estableció la
     * conexión, falso en caso contrario
     */
    public boolean crearConexion(Connection conexion) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            //jdbc:mysql://localhost:3306/cabinas_el_tropico?zeroDateTimeBehavior=convertToNull
            conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/cabinas_el_tropico?zeroDateTimeBehavior=convertToNull",
                    "root","surfing");
                   // + "jdbc:mysql://localhost:306/cabinas_el_tropico", "root", "");
        } catch (SQLException ex) {
            ex.printStackTrace();

            return false;
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();

            return false;

        }

        return true;
    }

    /**
     *
     * Método utilizado para realizar las instrucciones: INSERT, DELETE y UPDATE
     *
     * @param sql Cadena que contiene la instrucción SQL a ejecutar
     * @return estado regresa el estado de la ejecución, true(éxito) o
     * false(error)
     *     
*/
    public boolean ejecutarSQL(String sql) {
        try {
            Statement sentencia = conexion.createStatement();
            sentencia.executeUpdate(sql);

        } catch (SQLException ex) {

            return false;
        }

        return true;
    }

    /**
     *
     * Método utilizado para realizar la instrucción SELECT
     *
     * @param sql Cadena que contiene la instrucción SQL a ejecutar
     * @return resultado regresa los registros generados por la consulta
     *     
*/
    public ResultSet ejecutarSQLSelect(String sql) {
        ResultSet resultado;
        try {
            Statement sentencia = conexion.createStatement();
            resultado = sentencia.executeQuery(sql);

        } catch (SQLException ex) {

            return null;
        }

        return resultado;
    }

    private static class conexion {

        private static Statement createStatement() {

            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

        }

        public conexion() {
        }
    }

}
