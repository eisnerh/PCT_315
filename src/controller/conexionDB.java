/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Cesar Gonzalez Salas, Eisner Lopez Acevedo
 */
public class conexionDB {

    Connection con = null;

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

}
