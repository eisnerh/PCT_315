/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Cesar Gonzalez Salas, Eisner Lopez Acevedo
 */
public class conexionDB {

    Connection con = null;
    static Statement sentencia;
    static ResultSet resultado;

    public static Connection conexionDB() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pct3?zeroDateTimeBehavior=convertToNull", "root", "surfing");
            return con;
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Cannot process request,Database disconnected!", "", JOptionPane.ERROR_MESSAGE);

            return null;

        }

    }
    
    public static ArrayList<String> llenar_combo(){
        ArrayList<String> lista = new ArrayList<>();
        String q = "SELECT * FROM `puesto`";
        try {
            resultado = sentencia.executeQuery(q);
            System.out.println("Correcto");
        } catch (Exception e) {
            System.out.println("No Correcto");
        }
        try {
            while(resultado.next()){
                lista.add(resultado.getString("`descripcion_puesto`"));
            }
        } catch (Exception e) {
        }
        return lista;
    }

}
