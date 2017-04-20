/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import javax.swing.JOptionPane;

/**
 *
 * @author Eisner López Acevedo <eisner.lopez at gmail.com>
 */
public class DB_Conexion {

    public static Properties loadPropertiesFile() throws Exception {

        Properties prop = new Properties();
        try (InputStream in = new FileInputStream("\\src\\controlador\\dbConfig.properties")) {
            prop.load(in);
        }
        return prop;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("create jdbc connection using properties file");

        Connection con = null;

        try {

            Properties prop = loadPropertiesFile();

            String driverClass = prop.getProperty("DB_DRIVER");
            String url = prop.getProperty("DB_HOST"+"DB_NAME");
            String username = prop.getProperty("DB_USER");
            String password = prop.getProperty("DB_PWD");

            Class.forName(driverClass);

            con = DriverManager.getConnection(url, username, password);

            if (con != null) {
                System.out.println("connection created successfully using properties file");
            } else {
                System.out.println(" unable to create connection");
            }

        } catch (SQLException e) {
            JOptionPane.showConfirmDialog(null, e);
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
        } finally {

            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                JOptionPane.showConfirmDialog(null, ex);
            }
        }
    }

}
