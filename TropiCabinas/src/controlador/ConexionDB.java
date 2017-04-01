/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author ace
 */
public class ConexionDB {

    
    Connection con = null;
    
    public static Connection conexionDB() {
        try {
           //Se carga el driver para la BD
            Class.forName("com.mysql.jdbc.Driver");
            //La dirección de la db
            String urlDriver = "jdbc:mysql://localhost:3306/pct3?zeroDateTimeBehavior=convertToNull";
            //usuario
            String user = "root";
            //contraseña
            String pass = "";
            //se unifica la conección
            Connection con = DriverManager.getConnection(urlDriver, user, pass);
            return con;
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Cannot process request,Database disconnected!", "", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }
}