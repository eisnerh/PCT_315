/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import javax.swing.JOptionPane;

/**
 *
 * @author ace
 */
public class ConexionDB {

    
    Connection con = null;
    
    public static Connection conexionDB() throws IOException {
        try {
            Properties properties = new Properties();
            
            
            Class.forName("com.mysql.jdbc.Driver");
            
            String urlDriver = "jdbc:mysql://localhost:3306/pct3?zeroDateTimeBehavior=convertToNull";
            String user = "root";
            String pass = "surfing";
            Connection con = DriverManager.getConnection(urlDriver, user, pass);
            return con;
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Cannot process request,Database disconnected!", "", JOptionPane.ERROR_MESSAGE);

            return null;

        }

    }

}